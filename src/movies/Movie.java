package movies;

import java.text.*; //formatting
import java.util.*;//file streams
public class Movie
{
    String title;
    private String director;
    private String studio;
    private double gross;

    public Movie(String t, String d, String s, double g)
    {
        this.title = t;
        this.director = d;
        this.studio = s;
        this.gross = g;

    }
    //Accessor
    public String getTitle()
    {
        return title;
    }
//Mutator - added as needed

    //toString for Output (output.txt)
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Title:\t\t"+title+"\n");
        sb.append("Director:\t"+director+"\n");
        sb.append("Studio:\t\t"+studio+"\n");


        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
        sb.append("Gross:\t\t"+fmt.format(gross));
        sb.append("\n");
        return sb.toString();
    }
    //toStrinbgFile for movieFile.txt
    public String toStringFile()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(title+"\n");
        sb.append(director+"\n");
        sb.append(studio+"\n");
        sb.append(gross+"\n");

        return sb.toString();
    }

}
