import java.net.*;
import java.io.*;

public class MessageServer {

	public static void main(String[] args) {
		int port = 11963;
		if(args.length == 0) {
			System.err.println("No port specified. Default: 11963");
		} else {
			port = Integer.parseInt(args[0]);
		}
		
		while(true) {
			try {
				ServerSocket server = new ServerSocket(port);
				Socket client = server.accept();
				
				System.out.println((Message)(new ObjectInputStream(client.getInputStream())).readObject());
				
				client.close();
				server.close();
			}
			catch(Exception e) {
				System.err.println(e);
				System.exit(2);
			}
		}
	}
}