/* William Stevens - 1/16/14
 * Multiple.java
 * States if 'A' is a multiple of 'B'
 */
 
import java.io.*;
import java.util.*;

public class Multiple {
	public static void main(String args[]) {
		int a, b;
		Scanner input = new Scanner(System.in);
		System.out.print("Interger A: ");
		a = input.nextInt();
		System.out.print("Interger B: ");
		b = input.nextInt();
		if ((b%a) == 0) {
			System.out.printf("%d is a multiple of %d\n", a, b);
		} else {
			System.out.printf("%d is not a multiple of %d\n", a, b);
		}
	}
}