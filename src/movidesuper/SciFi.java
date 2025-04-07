package movidesuper;

import java.util.ArrayList;

public class SciFi extends Movie{
    private int aliens;

    public SciFi(String title, String director, double gross, int Year, ArrayList<String> actors, int aliens) {
        super(title, director,gross,Year,actors);
        this.aliens = aliens;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAlein Level " + aliens;
    }

    public boolean equals(SciFi s)
    {
        return this.aliens == s.aliens;

    }
}
