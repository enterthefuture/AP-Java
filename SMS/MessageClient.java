import java.net.*;
import java.io.*;
import java.util.*;

public class MessageClient {
	public static void main(String[] args) {
		String host;
		String port;
		String user;
		String message;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nHost: ");
		host = input.nextLine();
		
		System.out.print("Port: ");
		port = input.nextLine();
		
		System.out.print("User: ");
		user = input.nextLine();
		
		System.out.print("Message: ");
		message = input.nextLine();
		
		try {
			Socket server = new Socket(host, Integer.parseInt(port));
			
			ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
			
			output.writeObject(new Message(user, message));
			
			output.flush();
			output.close();
			
			System.out.println("\n*** Message Sent ***");
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
}