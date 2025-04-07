package movidesuper;

import java.util.ArrayList;

public class Fantasy extends Movie{
    private int fantasticalness;

    public Fantasy(String title, String director, double gross, int Year, ArrayList<String> actors, int fantasticalness) {
        super(title, director,gross,Year,actors);
        this.fantasticalness = fantasticalness;
    }


    @Override
    public String toString() {
        return super.toString() + "\nfantasticalness Level " + fantasticalness;
    }

    public boolean equals(Fantasy f)
    {
        return this.fantasticalness == f.fantasticalness;

    }
}