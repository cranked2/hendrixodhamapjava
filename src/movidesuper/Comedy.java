package movidesuper;

import java.util.ArrayList;

class Comedy extends Movie {
    private int humorLevel;

    public Comedy(String title, String director, double gross, int Year, ArrayList<String> actors, int humorLevel) {
        super(title, director,gross,Year,actors);
        this.humorLevel = humorLevel;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHumor Level " + humorLevel;
    }

    public boolean equals(Comedy c)
    {
       return this.humorLevel == c.humorLevel;

    }
}
