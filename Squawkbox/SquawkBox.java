import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class SquawkBox extends JFrame {
	public static final int DEFAULT_SERVER_PORT = 15555;
	
	private static final int EXIT_SUCCESS = 0;
	private static final int EXIT_FAILURE = 1;
	
	private int serverPort;
	
	private MessageServer mserver;
	
	private JTextArea inputBox;
	private JTextArea outputBox;
	
	private JTextField host;
	private JTextField port;
	private JTextField user;
	
	private JButton send;
	private JButton clear;
	
	public SquawkBox(int serverPort) {
		super("SquawkBox: A Really Simple Point-to-Point Text Messenger");
		
		this.serverPort = serverPort;
		
		mserver = new MessageServer();
		
		host = new JTextField(15);
		port = new JTextField(Integer.toString(DEFAULT_SERVER_PORT), 5);
		user = new JTextField(10);
		
		inputBox = new JTextArea();
		inputBox.setEditable(false);
		
		outputBox = new JTextArea();
		
		inputBox.setBorder(new BevelBorder(BevelBorder.RAISED));
		outputBox.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		send = new JButton("Send");
		clear = new JButton("Clear");
		
		send.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sendMessage();
				}
			}
		);
		
		clear.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearFields();
				}
			}
		);
		
		buildGUI();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(850, 500);
		
		setVisible(true);
	}
	
	private void buildGUI() {
		JMenuBar menubar = new JMenuBar();
		
		menubar.add(getMainMenu());
		
		setJMenuBar(menubar);
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		c.add(getTextAreaPanel(), BorderLayout.CENTER);
		
		c.add(getMainPanel(), BorderLayout.SOUTH);
	}
	
	private JMenu getMainMenu() {
		JMenu menu = new JMenu("File");
		
		JMenuItem exit = new JMenuItem("Exit");
		
		exit.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(EXIT_SUCCESS);
				}
			}
		);
		
		menu.add(exit);
		
		return menu;
	}
	
	private JPanel getTextAreaPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		panel.add(new JScrollPane(inputBox));
		panel.add(new JScrollPane(outputBox));
		
		return panel;
	}
	
	private JPanel getMainPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		
		panel.add(new JLabel("Remote Host:"));
		panel.add(host);
		panel.add(new JLabel("Remote Port:"));
		panel.add(port);
		panel.add(new JLabel("Your Name:"));
		panel.add(user);
		panel.add(send);
		panel.add(clear);
		
		return panel;
	}
	
	private void sendMessage() {
		try {
			Socket remoteHost = new Socket(host.getText(), Integer.parseInt(port.getText()));
			
			ObjectOutputStream output = new ObjectOutputStream(remoteHost.getOutputStream());
			
			Message m = new Message(user.getText(), outputBox.getText());
			
			output.writeObject(m);
			
			output.flush();
			output.close();
			
			inputBox.append(m.toString() + "\n\n");
			
			outputBox.setText(null);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Unable to send your message. Perhaps the destination's IP address, hostname, \nor tcp port number is incorrect?", "Network Communication Error", JOptionPane.WARNING_MESSAGE);
			
			System.err.println(e);
		}
	}
	
	private void clearFields() {
		inputBox.setText(null);
		outputBox.setText(null);
		host.setText(null);
		port.setText(Integer.toString(DEFAULT_SERVER_PORT));
	}
	
	private class MessageServer extends Thread {
		private ServerSocket server;
		private Socket client;
		
		public MessageServer() {
			try {
				server = new ServerSocket(serverPort);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(SquawkBox.this, "Unable to create server socket.", "Local Host Server Error", JOptionPane.WARNING_MESSAGE);
				
				System.err.println(e);
				
				System.exit(EXIT_FAILURE);
			}
		}
		public void run() {
			while(true) {
				try {
					client = server.accept();
					
					inputBox.append((new ObjectInputStream(client.getInputStream())).readObject().toString() + "\n\n");
					
					client.close();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(SquawkBox.this, "Error accepting client connection.", "Network Communication Error", JOptionPane.WARNING_MESSAGE);
					
					System.err.println(e);
				}
			}
		}
	}
	
	public void runApp() { mserver.start(); }
	
	public static void main(String[] args) {
		(new SquawkBox((args.length == 0) ? SquawkBox.DEFAULT_SERVER_PORT : Integer.parseInt(args[0]))).runApp();
	}
}