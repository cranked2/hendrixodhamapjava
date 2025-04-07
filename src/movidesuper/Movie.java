package movidesuper;

import java.time.Year;
import java.util.ArrayList;

public class Movie {
    private String title;
    private String director; // in minutes
    private double gross;
    private int Year;
    private ArrayList<String> actors;

    public Movie(String title, String director, double gross, int Year, ArrayList<String> actors) {
        this.title = title;
        this.director = director;
        this.gross = gross;
        this.Year = Year;
        this.actors = actors;
    }
    @Override
    public String toString() {
        StringBuilder actorstr = new StringBuilder();

        for (String val : actors)
            actorstr.append("\n" + val);
        actorstr.toString();

        return "Title: " + title + "\nDirector: " + director + "\nEarnings: " + gross + "\nYear: " + Year + "\nActors: " + actorstr;
    }
}

