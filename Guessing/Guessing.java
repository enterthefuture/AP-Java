import java.io.*;
import java.util.*;

public class Guessing {
	public static void main(String args[]) {
		int target = 0;
		int guess = 0;
		int difficulty = 1;
		int limit = 10;
		int score = 0;
		
		Random rand = new Random();
		Scanner input = new Scanner(System.in);

		System.out.print("\nDifficulty: ");
		difficulty = Integer.parseInt(input.nextLine());
		
		limit = (int)Math.pow(10,difficulty);
		target = rand.nextInt(limit) + 1;
		
		System.out.print(String.format("\nGuess a number between 1 and %s.", limit));

		for(int i = 1; guess != target; i++) {

			System.out.print(String.format("\nGuess #%s: ", i));
			guess = Integer.parseInt(input.nextLine());
			
			if(guess != target) {
				
				if(guess > target) {
					System.out.print("\nTOO HIGH");
				} else {
					System.out.print("\nTOO LOW");
				}
			} else {
				System.out.print("\nCORRECT");
			}
			
			score = (difficulty*4) - i;
		}
		System.out.print(String.format("\nScore: %s", score));
	}
}