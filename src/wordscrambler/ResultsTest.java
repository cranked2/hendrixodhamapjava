package wordscrambler;// CMPINF 0401
// Test program for Results class.  This program should run
// without modification with your Results class and should produce output
// identical to that shown in resultstest.txt 
// Note the for this to work, a file called "results.txt" must already
// exist in the same directory as this program file.  You can create a simple
// "results.txt" file using a text editor.  Enter a single 0 on each of 4 lines
// then save the file.

import java.io.*;

public class ResultsTest
{
	public static void main(String [] args) throws IOException
	{
		Results R = new Results("results.txt");
		System.out.println("Initial results data..." );
		System.out.println(R.toString());
		
		R.update(false, 5);
		R.update(true, 3);
		R.update(true, 4);
		
		System.out.println("Results after three updates..." );
		System.out.println(R.toString());
		
		System.out.println("Average guesses: " + R.aveGuesses());
		
		System.out.println("Saving back to file...");
		R.save();
		
		// Let's now make a new Results object
		Results R2 = new Results("results.txt");
		System.out.println("Results read back from file...");
		System.out.println(R2.toString());
		
		System.out.println("One more update...");
		R2.update(true, 2);
		System.out.println(R2.toString());
		R2.save();
	}
}