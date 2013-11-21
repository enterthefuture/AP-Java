import java.io.*;
import java.text.*;
import java.util.*;

public class Message implements Serializable {
	private String user;
	private String message;
	private String timeStamp;
	
	public Message(String user, String message) {
		this.user=user;
		this.message=message;
		timeStamp = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());
	}
	
	public String toString() { return "[(" + user + ") " + timeStamp + "] " + message; }
}