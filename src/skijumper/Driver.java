package skijumper;

import javax.swing.*;

public class Driver {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SkiJumperGame game = new SkiJumperGame();
            game.setVisible(true);
        });
    }
}
