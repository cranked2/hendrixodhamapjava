import java.util.Scanner;
public class theMethod
{
    public static Scanner sc = new Scanner(System.in);

    public static void main (String [] args)
    {
        System.out.println("What is your avergae");
        double avg  = Double.parseDouble(sc.nextLine());

        System.out.println(nested(avg));

        System.out.println(extended(avg));

    }
//user methods
    //return
    //value name formal param - temporary
    public static String nested (double avg)
    {
        if (avg > 70) {
            if (avg >= 80) {
                if (avg >= 90) {
                    return "Exellant";
                } else
                    return "Above Avg";
            } else
                return "Satisfactory";
        }
        else
            return "Stupid";
    }

    public static char extended(double avg)
    {
        char grade = ' ';

        if (avg >= 90)
            grade = 'A';
        else if(avg >=80)
            grade = 'B';
        else if(avg >=70)
            grade = 'C';
        else if(avg >=60)
            grade = 'D';
        else
            grade = 'F';
        switched(grade);
        return grade;
    }

    public static void switched(char grade)
    {
        switch(grade)
        {
            case 'A': System.out.println("Average >= 90");
                break;
            case 'B': System.out.println("Average >= 80 but < 90");
                break;
            case 'C': System.out.println("Average >= 70 but <  80");
                break;
            case 'D': System.out.println("Average >= 60 but < 70");
                break;
            default: System.out.println("You're Dumb Go study");
        }
        return;
    }

}
