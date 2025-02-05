import java.io.*;
import java.util.*;

public class PlayerList {
    private Player[] players;
    private int size;
    private static final int INITIAL_CAPACITY = 3;
    private String fileName;
    
    public PlayerList(String fileName) throws IOException {
        this.fileName = fileName;
        players = new Player[INITIAL_CAPACITY];
        size = 0;
        loadPlayers();
    }
    
    private void loadPlayers() throws IOException {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(" ");
                String name = data[0];
                int rounds = Integer.parseInt(data[1]);
                int wins = Integer.parseInt(data[2]);
                int losses = Integer.parseInt(data[3]);
                int guesses = Integer.parseInt(data[4]);
                Player player = new Player(name);
                player.updateStats(wins > losses, guesses); // Simulate loading stats
                addPlayer(player);
            }
        }
    }
    
    public Player findPlayer(String name) {
        for (int i = 0; i < size; i++) {
            if (players[i].getName().equalsIgnoreCase(name)) {
                return players[i];
            }
        }
        return null;
    }
    
    public void addPlayer(Player player) {
        if (size == players.length) {
            resizeArray();
        }
        players[size++] = player;
    }
    
    private void resizeArray() {
        Player[] newPlayers = new Player[players.length * 2];
        System.arraycopy(players, 0, newPlayers, 0, players.length);
        players = newPlayers;
    }
    
    public void saveList() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < size; i++) {
                Player p = players[i];
                writer.printf("%s %d %d %d %d%n", p.getName(), p.getRounds(), p.getWins(), p.getLosses(), p.getGuesses());
            }
        }
    }
    
    public int capacity() {
        return players.length;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Player List:\n");
        for (int i = 0; i < size; i++) {
            result.append(players[i]).append("\n\n");
        }
        return result.toString();
    }
}
