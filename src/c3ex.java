import java.util.Scanner;
import java.util.ArrayList;

public class c3ex {


    public static Scanner sc = new Scanner(System.in);
    public static void main (String [] args)
    {

        System.out.println("Enter first number: ");
        int first  = Integer.parseInt(sc.nextLine());
        System.out.println("Enter second number: ");
        int second  = Integer.parseInt(sc.nextLine());
        System.out.println("Enter third number: ");
        int third  = Integer.parseInt(sc.nextLine());
        System.out.println("Enter fourth number: ");
        int fourth  = Integer.parseInt(sc.nextLine());

        System.out.println( first + 1 == second && second + 1 == third && third + 1 == fourth ? "Yes" : "No");

        ArrayList<Integer> divisiblenums = new ArrayList<Integer>();

        int x = 0;
        do {
            System.out.println(divisiblenums.get(x) % 5 == 0 ? "Divisible by 5" : "Not divisble by 5");
        }while(x!=2);




    }
}
