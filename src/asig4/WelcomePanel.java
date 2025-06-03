public class WelcomePanel extends JPanel {
    private JLabel greeting;

    public WelcomePanel() {
        greeting = new JLabel("Welcome to the Movie Theater Concessions");
        greeting.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(greeting);
    }
}
