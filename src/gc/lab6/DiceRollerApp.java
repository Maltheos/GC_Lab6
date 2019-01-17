package gc.lab6;

import java.util.Scanner;

public class DiceRollerApp {

	public static void diceRollerResult(int howManyDice, int howManySides, Scanner scnr) {
		String keepPlaying;
		int result = 0;
		int result1 = 0;
		int result2 = 0;
		
		System.out.println("You have found the secret game by using 2 standard dice!");
		System.out.println("You're playing craps!");
		System.out.println();
		
		do { // keep playing craps until the user opts not to
			
			System.out.print("Press any key to roll the dice (or \"n\" to exit immediately): " ); // prompt user to roll the dice
			String rolldice = scnr.nextLine();
			System.out.println();
			
			if(!(rolldice.equalsIgnoreCase("n"))) { // wait until user hits a key to roll or n to exit
			
				for(int i = 1; i <= howManyDice; i++) {
					if(i%2==0) { // even rolls use DieRoll2
						result = GC_Lab6.generateRandomDieRoll2(howManySides);
						result1 = result;
					} else { // odd rolls use DieRoll1
						result = GC_Lab6.generateRandomDieRoll2(howManySides);
						result2 = result;
					}
				// using result1 and result2 in the if statement guarantees that the different rolls will give individual results
				// impossible for the result1 or result2 to be overwritten as we have 2 howManySides, so only 1 path will be taken each time
				// however, if i'm displaying the result for each dice roll, i need to maintain 1 variable to be written to the sysout
					System.out.print("Dice #" + (i) + ": " + result);
					System.out.println();
				}
			
			} else {
				break;
			}
			
			System.out.println();
			
			// playing craps using the results generated by random number generator, these are the rules apparently
			if (result1 + result2 == 7 || result1 + result2 == 11) { 
				System.out.println("You rolled a natural " + (result1 + result2) +"! Win!");
			} else if (result1 + result2 == 2 || result1 + result2 == 3 || result1 + result2 == 12) {
				System.out.println("You rolled a craps " + (result1 + result2) + "! Oh no! You lose!");
			} else {
				System.out.println("You rolled " + (result1 + result2) + ", roll again if you dare!");
			}
			System.out.println();
			System.out.print("Do you want to keep playing craps? (y/n) ");
			keepPlaying = scnr.nextLine();
			
		} while(keepPlaying.charAt(0)=='y' || keepPlaying.charAt(0) == 'Y');
		
	}	
	
}