import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AvgListens extends JFrame {
    private JButton startButton, finishButton;
    private JTextField inputField;
    private JLabel theLabel;
    private JPanel panel;
    private Timer chaosTimer, pulseTimer;
    private int sum = 0, count = 0;
    private boolean collecting = false;
    private Random rand = new Random();
    private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private float scale = 1.0f;
    private boolean grow = true;

    public AvgListens() {
        super("AvgListens");

        startButton = new JButton("START");
        finishButton = new JButton("FINISH");
        inputField = new JTextField();
        theLabel = new JLabel("Press Start", SwingConstants.CENTER);

        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        finishButton.setFont(new Font("Arial", Font.BOLD, 16));
        inputField.setFont(new Font("Consolas", Font.BOLD, 20));
        theLabel.setFont(new Font("Impact", Font.BOLD, 26));
        theLabel.setOpaque(true);

        panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.add(startButton);
        panel.add(finishButton);
        panel.add(inputField);
        panel.add(theLabel);

        add(panel);
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        finishButton.setEnabled(false);
        inputField.setEnabled(false);

        startButton.addActionListener(e -> start());
        finishButton.addActionListener(e -> finish());
        inputField.addActionListener(e -> submit());

        setupChaos();
        setupPulse();
    }

    private void start() {
        collecting = true;
        sum = 0;
        count = 0;
        inputField.setEnabled(true);
        startButton.setEnabled(false);
        finishButton.setEnabled(true);
        theLabel.setText("🌀 Enter Numbers...");
        chaosTimer.start();
        pulseTimer.start();
    }

    private void finish() {
        collecting = false;
        chaosTimer.stop();
        pulseTimer.stop();
        inputField.setEnabled(false);
        startButton.setEnabled(true);
        finishButton.setEnabled(false);

        if (count > 0) {
            double avg = (double) sum / count;
            theLabel.setText("AVG: " + String.format("%.2f", avg) + "");
        } else {
            theLabel.setText("⚠️ No Input!");
        }

        panel.setBackground(Color.BLACK);
    }

    private void submit() {
        if (!collecting) return;

        String input = inputField.getText().trim();
        try {
            int value = Integer.parseInt(input);
            sum += value;
            count++;
            inputField.setText("");
            theLabel.setText("💾 Saved: " + value);
            Toolkit.getDefaultToolkit().beep();
            spawnExplosion(value);
        } catch (NumberFormatException ex) {
            theLabel.setText("Invalid");
        }
    }

    private void setupChaos() {
        chaosTimer = new Timer(100, e -> {
            Color bgColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            panel.setBackground(bgColor);

            Color fgColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            theLabel.setForeground(fgColor);

            String fontName = fonts[rand.nextInt(fonts.length)];
            int fontSize = rand.nextInt(12) + 20;
            theLabel.setFont(new Font(fontName, Font.BOLD, fontSize));

            // Append some random sparkles (up to 3)
            int sparkles = rand.nextInt(4);
            StringBuilder text = new StringBuilder(theLabel.getText().replaceAll("✨", ""));
            for (int i = 0; i < sparkles; i++) text.append("✨");
            theLabel.setText(text.toString());

            jitterLabel();
        });
    }

    private void jitterLabel() {
        int jitterX = rand.nextInt(7) - 3;
        int jitterY = rand.nextInt(7) - 3;
        Point loc = theLabel.getLocation();
        loc.translate(jitterX, jitterY);
        theLabel.setLocation(loc);
        // Reset location after a short delay so it doesn’t drift too far
        new Timer(50, e -> {
            theLabel.setLocation(panel.getComponent(3).getX(), panel.getComponent(3).getY());
            ((Timer)e.getSource()).stop();
        }).start();
    }

    private void setupPulse() {
        pulseTimer = new Timer(60, e -> {
            if (grow) scale += 0.02f;
            else scale -= 0.02f;

            if (scale > 1.2f) grow = false;
            if (scale < 1.0f) grow = true;

            int w = (int) (500 * scale);
            int h = (int) (200 * scale);
            setSize(w, h);
        });
    }

    private void spawnExplosion(int value) {
        JLabel floatLabel = new JLabel("+" + value);
        floatLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        floatLabel.setForeground(Color.RED);
        floatLabel.setSize(50, 30);

        final int[] x = {rand.nextInt(getWidth() - floatLabel.getWidth())};
        final int[] y = {rand.nextInt(getHeight() - floatLabel.getHeight())};
        floatLabel.setLocation(x[0], y[0]);

        getLayeredPane().add(floatLabel, JLayeredPane.POPUP_LAYER);

        Timer floatTimer = new Timer(50, null);
        floatTimer.addActionListener(new ActionListener() {
            int dy = 0;
            int dx = rand.nextBoolean() ? 3 : -3;
            final int ty = y[0] - 100;

            @Override
            public void actionPerformed(ActionEvent e) {
                dy += 5;
                x[0] += dx;
                y[0] -= 5;
                floatLabel.setLocation(x[0], y[0]);
                floatLabel.setForeground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

                if (y[0] < ty || x[0] < 0 || x[0] > getWidth()) {
                    getLayeredPane().remove(floatLabel);
                    getLayeredPane().repaint();
                    floatTimer.stop();
                }
            }
        });
        floatTimer.start();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(AvgListens::new);
    }
}
