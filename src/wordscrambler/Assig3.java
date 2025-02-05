import java.io.*;
import java.util.*;

public class Assig3 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Scramble Game!");
        System.out.print("Enter your name: ");
        String playerName = input.nextLine();
        
        // Initialize Scramble and Results objects
        Scramble scramble = new Scramble("words.txt");
        Results results = new Results("results.txt");
        
        boolean keepPlaying = true;
        while (keepPlaying) {
            System.out.println("\nNew Round!");
            String realWord = scramble.getRealWord();
            if (realWord == null) {
                System.out.println("No more words available. Game over.");
                break;
            }
            String scrambledWord = scramble.getScrambledWord();
            System.out.println("Scrambled word: " + scrambledWord);
            
            boolean roundWon = false;
            int guessCount = 0;
            for (int i = 0; i < 5; i++) {
                System.out.print("Guess the word: ");
                String guess = input.nextLine().toLowerCase();
                guessCount++;
                
                if (guess.equals(realWord.toLowerCase())) {
                    System.out.println("Correct! You won this round.");
                    roundWon = true;
                    break;
                } else {
                    System.out.println("Incorrect. Correct letters so far: " + getMatchingLetters(realWord, guess));
                }
            }
            
            if (!roundWon) {
                System.out.println("You lost this round. The correct word was: " + realWord);
            }
            results.update(roundWon, guessCount);
            
            System.out.print("Do you want to play another round? (yes/no): ");
            keepPlaying = input.nextLine().equalsIgnoreCase("yes");
        }
        
        System.out.println("\nGame Over. Here are your results:");
        System.out.println(results);
        results.save();
        input.close();
    }
    
    private static String getMatchingLetters(String realWord, String guess) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.min(realWord.length(), guess.length()); i++) {
            if (realWord.charAt(i) == guess.charAt(i)) {
                result.append(realWord.charAt(i));
            } else {
                result.append("_");
            }
        }
        return result.toString();
    }
}
