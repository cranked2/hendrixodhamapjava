public class SnackPanel extends JPanel {
    public final double NACHOS = 2.00;
    public final double CANDY = 1.50;
    public final double HOTDOG = 3.50;
    public final double PRETZEL = 2.75;

    private JCheckBox nachos;
    private JCheckBox candy;
    private JCheckBox hotdog;
    private JCheckBox pretzel;

    public SnackPanel() {
        setLayout(new GridLayout(4, 1));
        nachos = new JCheckBox("Nachos");
        candy = new JCheckBox("Candy");
        hotdog = new JCheckBox("Hotdog");
        pretzel = new JCheckBox("Pretzel");

        setBorder(BorderFactory.createTitledBorder("Snacks"));

        add(nachos);
        add(candy);
        add(hotdog);
        add(pretzel);
    }

    public double getSnackCost() {
        double cost = 0.0;
        if (nachos.isSelected()) cost += NACHOS;
        if (candy.isSelected()) cost += CANDY;
        if (hotdog.isSelected()) cost += HOTDOG;
        if (pretzel.isSelected()) cost += PRETZEL;
        return cost;
    }
}
