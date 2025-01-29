package movies;

// CMPINFO 401
// Your job is to complete this program so that it runs correctly.
// The Movie class and MovieDB class have already been completed for you.
// You just need to write the correct code in the 3 passages below.  Some
// comments indicate what you need to do in each case.

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class Lab7
{
	public static void main(String [] args) throws IOException
	{
		MovieDB movies = new MovieDB(10); // Create MovieDB object.  The
		// size is set at 10, meaning it can hold up to 10
		// movies.  If we wanted (as discussed in lecture) we
		// could allow for it to be resized so it could hold
		// an arbitrary number of movies.

		loadData(movies);       // input movie data from file
		getCommands(movies);    // interact with user
		saveData(movies);       // save movie data back to file
	}

	public static void loadData(MovieDB movies) throws IOException
	{
		// Note the syntax below for creating a Scanner to a file
		Scanner sc = new Scanner(Files.newInputStream(Paths.get("movieFile.txt")));

		// *** CODE SEGMENT 1 *** //
		// Complete this method in the following way:
		// Read in the number of movies from the file
		// For each movie read the data from the file and create a Movie
		// object
		// Add the Movie to the MoviesDB object (movies) using the appropriate
		// method (see MovieDB class)
		String title;
		String director;
		String studio;
		String empty;
		double gross;
		Movie movie = null;
		int sum = Integer.parseInt(sc.nextLine());

		while(sc.hasNext())
		{
			title = sc.nextLine();
			director = sc.nextLine();
			studio = sc.nextLine();
			gross =  Double.parseDouble(sc.nextLine());
			movie = new Movie(title,director,studio,gross);
			movies.addMovie(movie);

		}

		sc.close();
	}

	public static void getCommands(MovieDB movies) throws IOException
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Enter your choice:");
		System.out.println("1. List movies");
		System.out.println("2. Add new movie");
		System.out.println("3. Find movie");
		System.out.println("4. Quit");
		String choice = inScan.nextLine();

		while (true)
		{
			Movie temp;
			if (choice.equals("1"))
			{
				System.out.println(movies.toString());
			}
			else if (choice.equals("2"))
			{
				// *** CODE SEGMENT 2 *** //
				// Complete this choice in the following way:
				// Prompt for and read in each of the values needed
				// for the new Movie object (3 strings, 1 double)
				// Create a new Movie object and then add it to the
				// MovieDB object (movies) using the correct method.
				System.out.println("Enter Movie name: ");
				String title = inScan.nextLine();
				System.out.println("Enter Movie director: ");
				String director = inScan.nextLine();
				System.out.println("Enter Movie studio: ");
				String studio = inScan.nextLine();
				System.out.println("Enter Movie gross: ");
				double gross = Double.parseDouble(inScan.nextLine());
				Movie movie = new Movie(title,director,studio,gross);
				movies.addMovie(movie);
				saveData(movies);
			}
			else if (choice.equals("3"))
			{
				// *** CODE SEGMENT 3 *** //
				// Complete this choice in the following way:
				// Ask the user for the movie name and read it in
				// Call the appropriate method in the MovieDB object
				// (movies) to find the Movie and return it
				// Show the movie's info (or indicate it is not found)
				System.out.println("Enter Movie name: ");
				String title = inScan.nextLine();
				temp = movies.findMovie(title);
				if (temp != null) {
					System.out.println(temp);
				} else {
					System.out.println("Movie not found.");
				}
			}
			else
			{
				System.out.println("Good-bye");
				break;  // any other value -- quit
			}
			System.out.println("Enter your choice:");
			System.out.println("1. List movies");
			System.out.println("2. Add new movie");
			System.out.println("3. Find movie");
			System.out.println("4. Quit");
			choice = inScan.nextLine();
		}

		inScan.close();
	}

	public static void saveData(MovieDB movies) throws IOException
	{
		PrintWriter P = new PrintWriter("movieFile.txt");
		// Note that we are printing the entire DB to the file with
		// one statement.  This is because the toStringFile() method
		// of the MovieDB class calls the toStringFile() method of
		// each Movie within the DB.
		P.print(movies.toStringFile());
		P.close();
	}
}
