public class DrinkPanel extends JPanel {
    public final double NO_DRINK = 0.0;
    public final double SODA = 1.50;
    public final double WATER = 1.00;
    public final double SLUSHIE = 2.50;

    private JRadioButton noDrink;
    private JRadioButton soda;
    private JRadioButton water;
    private JRadioButton slushie;
    private ButtonGroup bg;

    public DrinkPanel() {
        setLayout(new GridLayout(4, 1));
        noDrink = new JRadioButton("None");
        soda = new JRadioButton("Soda", true);
        water = new JRadioButton("Water");
        slushie = new JRadioButton("Slushie");

        bg = new ButtonGroup();
        bg.add(noDrink);
        bg.add(soda);
        bg.add(water);
        bg.add(slushie);

        setBorder(BorderFactory.createTitledBorder("Drinks"));

        add(noDrink);
        add(soda);
        add(water);
        add(slushie);
    }

    public double getDrinkCost() {
        if (noDrink.isSelected()) return NO_DRINK;
        else if (soda.isSelected()) return SODA;
        else if (water.isSelected()) return WATER;
        else return SLUSHIE;
    }
}
