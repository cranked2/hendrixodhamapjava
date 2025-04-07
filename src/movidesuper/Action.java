package movidesuper;

import java.util.ArrayList;

class Action extends Movie {
    private int explosionCount;

    public Action(String title, String director, double gross, int Year, ArrayList<String> actors, int explosionCount) {
        super(title, director,gross,Year,actors);
        this.explosionCount = explosionCount;
    }


    @Override
    public String toString() {
        return super.toString() + "\nexplosionCount " + explosionCount;
    }


    public boolean equals(Action a)
    {
        return this.explosionCount == a.explosionCount;

    }
}
