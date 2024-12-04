package skijumper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

interface Game {
    void startGame();
    void endGame();
    void saveScore();
}
enum Difficulty {
    EASY(1.5), MEDIUM(2.0), HARD(2.5);
    private final double multiplier;
    Difficulty(double multiplier) {
        this.multiplier = multiplier;
    }
    public double getMultiplier() {
        return multiplier;
    }
}
public class SkiJumperGameWithEnums extends JFrame implements Game {
    private int spaceCount = 0;
    private boolean isJumping = false;
    private JLabel instructionLabel;
    private JLabel countdownLabel;
    private JLabel resultLabel;
    private Difficulty difficulty = Difficulty.MEDIUM;
    private int score = 0;

    public SkiJumperGameWithEnums() {
        setTitle("Ski Jumper");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        instructionLabel = new JLabel("Press SPACE as fast as you can for 5 seconds!", SwingConstants.CENTER);
        add(instructionLabel, BorderLayout.NORTH);
        countdownLabel = new JLabel("Get ready...", SwingConstants.CENTER);
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(countdownLabel, BorderLayout.CENTER);
        resultLabel = new JLabel("", SwingConstants.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
        addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                if (isJumping && e.getKeyCode() == KeyEvent.VK_SPACE) {
                    spaceCount++;
                }
            }
        });
        String[] options = {
                "EASY",
                "MEDIUM",
                "HARD"
        };
        String choice = (String) JOptionPane.showInputDialog(this, "Choose Difficulty:", "Difficulty Selection", JOptionPane.QUESTION_MESSAGE, null, options, "MEDIUM");
        if (choice != null) {
            difficulty = Difficulty.valueOf(choice);
        }
        startGame();
    }
    @Override public void startGame() {
        Timer gameTimer = new Timer(1000, new ActionListener() {
            int timeLeft = 5;
            @Override public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    countdownLabel.setText("Time left: " + timeLeft + " seconds");
                    timeLeft--;
                } else {
                    ((Timer) e.getSource()).stop();
                    endGame();
                }
            }
        });
        Timer countdownTimer = new Timer(1000, new ActionListener() {
            int countdown = 3;
            @Override public void actionPerformed(ActionEvent e) {
                if (countdown > 0) {
                    countdownLabel.setText("Starting in: " + countdown);
                    countdown--;
                } else {
                    ((Timer) e.getSource()).stop();
                    countdownLabel.setText("Go!");
                    isJumping = true;
                    gameTimer.start();
                }
            }
        });
        countdownTimer.start();
    }
    @Override public void endGame() {
        isJumping = false;
        int jumpDistance = (int)(spaceCount * difficulty.getMultiplier());
        score += jumpDistance;
        instructionLabel.setText("Game Over!");
        resultLabel.setText("You jumped " + jumpDistance + " meters! Total score: " + score);
        saveScore();
    }
    @Override public void saveScore() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ski_jumper_scores.txt", true))) {
            writer.write("Difficulty: " + difficulty + ", Score: " + score + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving score: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() - > {
                SkiJumperGameWithEnums game = new SkiJumperGameWithEnums();
                game.setVisible(true);
        });
    }
}

}