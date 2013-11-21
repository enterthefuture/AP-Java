import java.net.*;
import java.io.*;
import java.util.*;

public class MessageClientMod {
	public static void main(String[] args) {
		String host;
		String port;
		String user;
		String message = "NULL";
		Message envelope;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nHost: ");
		host = input.nextLine();
		
		System.out.print("Port: ");
		port = input.nextLine();
		
		System.out.print("User: ");
		user = input.nextLine();
		
		sendMessage(new Message(user, "INFO: " + user + " has entered."), host, Integer.parseInt(port));
		
		while(true) {
			System.out.print("Message: ");
			message = input.nextLine();
			if (message.equals("exit")) {
				sendMessage(new Message(user, "INFO: " + user + " has left."), host, Integer.parseInt(port));
				break;
			} else {
				sendMessage(new Message(user, message), host, Integer.parseInt(port));
			}
		}
	}
	
	private static void sendMessage(Message body, String host, int port) {
		try {
			Socket server = new Socket(host, port);
			
			ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
			
			output.writeObject(body);
			
			output.flush();
			output.close();
			
			System.out.println("\n*** Message Sent ***");
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
}