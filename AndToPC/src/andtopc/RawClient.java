import java.net.*;
import java.io.*;
import java.util.*;

public class RawClient {
	public static void main(String[] args) {
		String host;
		String port;
		int type;
		int target;
		int dir;
		
		Scanner input = new Scanner(System.in);

		System.out.print("\nHost: ");
		host = input.nextLine();
		
		System.out.print("Port: ");
		port = input.nextLine();

		while(true) {
			try {
				System.out.print("Type: ");
				type = Integer.parseInt(input.nextLine());
				
				System.out.print("Target: ");
				target = Interger.parseInt(input.nextLine())
				
				System.out.print("dir: ");
				dir = Integer.parseInt(input.nextLine());
				
				Socket server = new Socket(host, Integer.parseInt(port));
		
				ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
		
				output.writeObject(new Action(type, target, dir));
				
				output.flush();
				output.close();
				
				System.out.println("\n*** Message Sent ***");
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
	}
}