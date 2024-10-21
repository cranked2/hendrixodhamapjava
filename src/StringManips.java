// ***************************************************************
// FILE:  StringManips.java
// Author:
//
// Purpose: Test several methods for manipulating String objects
// ***************************************************************

import java.util.Scanner;

public class StringManips
{
    public static void main (String[] args)
    {
    Scanner sc = new Scanner(System.in);
	String phrase = new String ("This is a String test.");
	int phraseLength;   // number of characters in the phrase String
	int middleIndex;    // index of the middle character in the String
	String firstHalf;   // first half of the phrase String
	String secondHalf;  // second half of the phrase String
	String switchedPhrase; // a new phrase with original halves switche
	String middle3;
	String city;
	String state;

				// compute the length and middle index of the phrase

	phraseLength = phrase.length();
	middleIndex = phraseLength / 2;
	middle3 = phrase.substring(middleIndex-1,middleIndex+2);

	switchedPhrase = phrase.replace(" ","*");

	firstHalf = phrase.substring(0,middleIndex);
	secondHalf = phrase.substring(middleIndex,phraseLength);
	// get the substring for each half of the phrase


	// concatenate the firstHalf at the end of the secondHalf


	// print information about the phrase
	System.out.println();
	System.out.println ("Original phrase: " + phrase);
	System.out.println ("Length of the phrase: " + phraseLength + " characters");
	System.out.println ("Index of the middle: " + middleIndex);
	System.out.println("Middle 3: " + middle3);
	System.out.println ("Switched phrase: " + switchedPhrase);
	System.out.println ("First Half: " + firstHalf);
	System.out.println ("Second Half: " + secondHalf);
	System.out.println ("Character at the middle index: " + phrase.charAt(middleIndex));
	System.out.println ("Both Halfs: " + firstHalf + secondHalf);

	System.out.println();

	System.out.println("Enter your City: ");
	city = sc.nextLine();
	System.out.println("Enter your State: ");
	state = sc.nextLine();

	System.out.println(state.toUpperCase() + city.toLowerCase() + state.toUpperCase());

    }
}







