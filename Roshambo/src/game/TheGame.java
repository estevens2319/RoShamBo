package game;
import java.util.Random;
import java.util.*;

public class TheGame {
	public static void main(String Args[]) {       
System.out.println("Welcome to Roshambo! Choose a difficulty 1, 2, 3, 4, or 5.");
Scanner input = new Scanner(System.in);	
String difficulty = input.next();
while(!difficulty.equals("1") && !difficulty.equals("2") && !difficulty.equals("3") && !difficulty.equals("4") && !difficulty.equals("5")) {
	System.out.println("Bad input. Please choose a difficulty 1, 2, 3, 4, or 5.");
	difficulty = input.next();
}
System.out.println("Alright lets play! \nChoose (R) Rock (P) Paper (S) Scissors (C) Choose Difficulty or (Q) Quit");

String choice = input.next();
while(!choice.equalsIgnoreCase("q")) {
	while(choice.equalsIgnoreCase("C")) {
		System.out.println("Choose a difficulty 1, 2, 3, 4, or 5.");
		difficulty = input.next();
		while(!difficulty.equals("1") && !difficulty.equals("2") && !difficulty.equals("3") && !difficulty.equals("4") && !difficulty.equals("5")) {
			System.out.println("Bad input. Please choose a difficulty 1, 2, 3, 4, or 5.");
			difficulty = input.next();
		}
		System.out.println("Alright lets play! \nChoose (R) Rock (P) Paper (S) Scissors (C) Choose Difficulty or (Q) Quit");

		 choice = input.next();
	}
	while(!choice.equalsIgnoreCase("R") && !choice.equalsIgnoreCase("P") && !choice.equalsIgnoreCase("S") && !choice.equalsIgnoreCase("C") && !choice.equalsIgnoreCase("q")) {
		System.out.println("Bad input. Please choose (R) Rock (P) Paper (S) Scissors (C) Choose Difficulty or (Q) Quit");
		choice = input.next();
	}
	
	// ROCK = 1 PAPER = 2 SCISSORS = 3
	if(!choice.equalsIgnoreCase("C") && !choice.equalsIgnoreCase("q")) {
	int numberChoice = 0;
	int pc = 0;
	int[] array = new int[100];
	if(choice.equalsIgnoreCase("r")) 
		numberChoice = 1;
	if(choice.equalsIgnoreCase("p"))
		numberChoice = 2;
	if(choice.equalsIgnoreCase("s"))
		numberChoice = 3;
	System.out.println("\nYou threw " + getThrow(numberChoice));
	
	
	if(difficulty.equals("1")) {
		if(numberChoice == 1)
			pc = 3;
		if(numberChoice == 2)
			pc = 1;
		if(numberChoice == 3)
			pc = 2;
		}

	if(difficulty.equals("5")) {
		if(numberChoice == 1)
			pc = 2;
		if(numberChoice == 2)
			pc = 3;
		if(numberChoice == 3)
			pc = 1;
	}
	if(difficulty.equals("2"))
		pc = Level2(numberChoice, array);
	if(difficulty.equals("3"))
		pc = Level3(numberChoice, array);
	if(difficulty.equals("4"))
		pc = Level4(numberChoice, array);


	
	System.out.println("\nI threw " + getThrow(pc));
	
	int win = winner(pc, numberChoice);
	System.out.print("\n");
	if(win == 0)
		System.out.println("It's a tie! We gotta go again\n\nChoose (R) Rock (P) Paper (S) Scissors (C) Choose Difficulty or (Q) Quit");
	if(win == 1)
		System.out.println("You win! Let's run it back\n\nChoose (R) Rock (P) Paper (S) Scissors (C) Choose Difficulty or (Q) Quit");
	if(win == -1)
		System.out.println("Ha! I win! Let's go again\n\nChoose (R) Rock (P) Paper (S) Scissors (C) Choose Difficulty or (Q) Quit");
	
	
	
choice = input.next();
	}
	}



System.out.println("Alright, GG WP");
    }
	
public static String getThrow(int i) {
	if(i == 1)
		return "Rock";
	if(i == 2)
		return "Paper";
	if(i == 3)
		return "Scissors";
	return "";
}
	
	public static int Level2(int input, int[] array) {
		Random rand = new Random();
		int winner = 0;
		int loser = 0;
		for(int i = 0; i < 25; i++ ) {
			array[i] = input;
		}
		if(input == 1) {
			winner = 2;
			loser = 3;
		}
		if(input == 2) {
			winner = 3;
			loser = 1;
		}
		if(input == 3) {
			winner = 1;
			loser = 2;
		}
		for(int i = 25; i < 75; i++) {
			array[i] = loser;
		}
		for(int i = 75; i < 100; i++) {
			array[i] = winner;
		}
		
		int pcThrow = rand.nextInt(100);
		
		return array[pcThrow];
	}
	public static int Level3(int input, int[] array) {
		Random rand = new Random();
		int pc = rand.nextInt(3) + 1;
		return pc;
	}
	public static int Level4(int input, int[] array) {
		
		Random rand = new Random();
		int winner = 0;
		int loser = 0;
		for(int i = 0; i < 25; i++ ) {
			array[i] = input;
		}
		if(input == 1) {
			winner = 2;
			loser = 3;
		}
		if(input == 2) {
			winner = 3;
			loser = 1;
		}
		if(input == 3) {
			winner = 1;
			loser = 2;
		}
		for(int i = 25; i < 75; i++) {
			array[i] = winner;
		}
		for(int i = 75; i < 100; i++) {
			array[i] = loser;
		}
		
		int pcThrow = rand.nextInt(100);
		
		return array[pcThrow];
	}
	public static int winner(int pc, int user) {
	// -1 equals pc 1 equals user 0 equals tie
		if(pc == user)
		return 0;		
		if(pc == 1 && user == 2)
			return 1;
		if(pc == 1 && user == 3)
			return -1;
		if(pc == 2 && user == 1)
			return -1;
		if(pc == 2 && user == 3)
			return 1;
		if(pc == 3 && user == 1)
			return 1;
		if(pc == 3 && user == 2)
			return -1;
		
			return 0;
	}
}