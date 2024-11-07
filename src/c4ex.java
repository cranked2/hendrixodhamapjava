import java.util.Scanner;

public class c4ex {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int selection = 0;
        System.out.println("What would you like to do?  \n1: Same Star Char\n2: Palindrome\n3: Without String\n");
        selection = Integer.parseInt(sc.nextLine());

        switch (selection) {
            case 1:
                System.out.println("Enter StartString");
                String starch = sc.nextLine();
                samestarchar(starch);
                break;
            case 2:

                break;
            case 3:

                break;
        }
        sc.close();
    }

    private static void samestarchar(String star) {

    }
}
