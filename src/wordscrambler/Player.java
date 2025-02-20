package wordscrambler;

public class Player {
    private String name;
    private int rounds;
    private int wins;
    private int losses;
    private int guesses;

    public Player(String name) {
        this.name = name;
        this.rounds = 0;
        this.wins = 0;
        this.losses = 0;
        this.guesses = 0;
    }

    public Player(String name, int rounds, int wins, int losses, int guesses) {
        this.name = name;
        this.rounds = rounds;
        this.wins = wins;
        this.losses = losses;
        this.guesses = guesses;
    }

    public void update(boolean won, int guessCount) {
        rounds++;
        if (won) wins++;
        else losses++;
        guesses += guessCount;
    }

    public double averageGuesses() {
        return rounds == 0 ? 0 : (double) guesses / rounds;
    }

    public String getName() {
        return name;
    }

    public int getRounds() {
        return rounds;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getGuesses() {
        return guesses;
    }

    @Override
    public String toString() {
        return String.format("Player: %s\nRounds: %d\nWins: %d\nLosses: %d\nTotal Guesses: %d\nAverage Guesses per Round: %.2f", 
                             name, rounds, wins, losses, guesses, averageGuesses());
    }

}
