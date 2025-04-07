package movidesuper;


import java.util.ArrayList;

public class MovieTest {


    public static void main(String[] args) {

        ArrayList<String> baseactors = new ArrayList<String>();
        baseactors.add("Hendrizzy");
        baseactors.add("keith");
        baseactors.add("Jack");
        baseactors.add("Fadey");
        baseactors.add("Mewcubs");
        baseactors.add("The Capper");

        Comedy comedyMovie = new Comedy("Super Funny Movie", "DR WHO", 1.2,2039,baseactors,90);
        Action actionMovie = new Action("Explosive Action", "Jimmy", 1.8,2020,baseactors,700);

        System.out.println("Comedy Movie Details:");
        System.out.println(comedyMovie);
        System.out.println("\nAction Movie Details:");
        System.out.println(actionMovie);

        Fantasy fmovie1 = new Fantasy("Cuh", "Cousin Colin", 86,2040,baseactors,60);
        Fantasy fmovie2 = new Fantasy("Huzz", " Jack", 67,1982,baseactors,50);

        System.out.println("fmovie1 Movie Details:");
        System.out.println(fmovie1);

        System.out.println("fmovie2 Movie Details:");
        System.out.println(fmovie2);

        System.out.println(fmovie1.equals(fmovie2));

        SciFi scmovie1 = new SciFi("Connor Invasion", "ChrissyT", 56,1876,baseactors,9000);
        SciFi scmovie2 = new SciFi("Mewing Masters", "Cacobs", 67,1786,baseactors,100000);

        System.out.println("scmovie1 Movie Details:");
        System.out.println(scmovie1);
        System.out.println("scmovie2 Movie Details:");
        System.out.println(scmovie2);

    }

}