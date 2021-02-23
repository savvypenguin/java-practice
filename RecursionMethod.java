/**
 * 
 * @author  Eileen-Margaret Churchill
 * Date:    January 22, 2021
 * Purpose: To create a program that utilizes a recursion method to
 * 	        determine if a word is "elfish".
 *
 */

import java.util.Scanner;

public class RecursionMethod {
	static boolean letterE = false;
	static boolean letterL = false;
	static boolean letterF = false;

	public static void main(String[] args) {
		
		// Local variables.
		Scanner keyboard = new Scanner(System.in);
		String userInput= null;
		
		// Obtain user input.
		System.out.println("Let's determine if your word is elfish!");
		System.out.print("Please enter your word: ");
		userInput = keyboard.nextLine();
		
		if(elfish(userInput)) {
			System.out.println(userInput + " is elfish!");
		}else {
			System.out.println(userInput + " is not elfish.");
		}
		
		keyboard.close();
	}
	
	// Recursive method.
	public static boolean elfish(String str) {
	
		if(str.length() == 0) {
			System.out.print("\n");
		}else {
			if(str.substring(0,1).equals("E") || 
					str.substring(0,1).equals("e")) {
				letterE = true;
			}
		
			if(str.substring(0,1).equals("L") || 
					str.substring(0,1).equals("l")) {
				letterL = true;
			}
		
			if(str.substring(0,1).equals("F") || 
					str.substring(0,1).equals("f")) {
				letterF = true;
			}
		
			return elfish(str.substring(1));
			}
			
		if(letterE && letterL && letterF) {
			return true;
		}else {
			return false;
		}
		
	}
	
}