public class OrderCalculatorTheaterGUI extends JFrame {
    private PopcornPanel popcorn;
    private SnackPanel snacks;
    private DrinkPanel drinks;
    private WelcomePanel banner;
    private JPanel buttonPanel;
    private JButton calcButton;
    private JButton exitButton;
    private final double TAX_RATE = 0.06;

    public OrderCalculatorTheaterGUI() {
        setTitle("Movie Theater Order Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        banner = new WelcomePanel();
        popcorn = new PopcornPanel();
        snacks = new SnackPanel();
        drinks = new DrinkPanel();

        buildButtonPanel();

        add(banner, BorderLayout.NORTH);
        add(popcorn, BorderLayout.WEST);
        add(snacks, BorderLayout.CENTER);
        add(drinks, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    // ...rest of the class remains unchanged
}
