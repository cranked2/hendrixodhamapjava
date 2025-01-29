package skijumper;

public enum Difficulty {
    EASY(1.5), MEDIUM(2.0), HARD(2.5);
    private final double multiplier;
    Difficulty(double multiplier) {
        this.multiplier = multiplier;
    }
    public double getMultiplier() {
        return multiplier;
    }
}
