public class PopcornPanel extends JPanel {
    public final double SMALL_POPCORN = 3.00;
    public final double LARGE_POPCORN = 5.00;

    private JRadioButton smallPopcorn;
    private JRadioButton largePopcorn;
    private ButtonGroup bg;

    public PopcornPanel() {
        setLayout(new GridLayout(2, 1));
        smallPopcorn = new JRadioButton("Small Popcorn", true);
        largePopcorn = new JRadioButton("Large Popcorn");

        bg = new ButtonGroup();
        bg.add(smallPopcorn);
        bg.add(largePopcorn);

        setBorder(BorderFactory.createTitledBorder("Popcorn"));
        add(smallPopcorn);
        add(largePopcorn);
    }

    public double getPopcornCost() {
        if (smallPopcorn.isSelected())
            return SMALL_POPCORN;
        else
            return LARGE_POPCORN;
    }
}
