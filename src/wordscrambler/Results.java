import java.io.*;

public class Results {
    private int rounds;
    private int wins;
    private int losses;
    private int guesses;
    private String fileName;
    
    public Results(String fileName) throws IOException {
        this.fileName = fileName;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            rounds = Integer.parseInt(reader.readLine());
            wins = Integer.parseInt(reader.readLine());
            losses = Integer.parseInt(reader.readLine());
            guesses = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            rounds = wins = losses = guesses = 0;
        }
    }
    
    public void update(boolean won, int guessCount) {
        rounds++;
        if (won) wins++;
        else losses++;
        guesses += guessCount;
    }
    
    public double aveGuesses() {
        return rounds == 0 ? 0 : (double) guesses / rounds;
    }
    
    public void save() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(rounds);
            writer.println(wins);
            writer.println(losses);
            writer.println(guesses);
        }
    }
    
    @Override
    public String toString() {
        return String.format("Rounds: %d\nWins: %d\nLosses: %d\nGuesses: %d\nAverage Guesses per Round: %.2f", 
                             rounds, wins, losses, guesses, aveGuesses());
    }
}
