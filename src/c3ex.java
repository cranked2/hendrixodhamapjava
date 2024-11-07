import java.util.Scanner;

public class c3ex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int selection = 0;

        String logo = "                                                                                                                                                                                                                                                                                                                             \n" +
                "                                                                                                                                                                                                                                                                                                                             \n" +
                "        CCCCCCCCCCCCChhhhhhh                                                           tttt                                                        333333333333333        EEEEEEEEEEEEEEEEEEEEEE                                                                                lllllll                                      \n" +
                "     CCC::::::::::::Ch:::::h                                                        ttt:::t                                                       3:::::::::::::::33      E::::::::::::::::::::E                                                                                l:::::l                                      \n" +
                "   CC:::::::::::::::Ch:::::h                                                        t:::::t                                                       3::::::33333::::::3     E::::::::::::::::::::E                                                                                l:::::l                                      \n" +
                "  C:::::CCCCCCCC::::Ch:::::h                                                        t:::::t                                                       3333333     3:::::3     EE::::::EEEEEEEEE::::E                                                                                l:::::l                                      \n" +
                " C:::::C       CCCCCC h::::h hhhhh         aaaaaaaaaaaaa  ppppp   ppppppppp   ttttttt:::::ttttttt        eeeeeeeeeeee    rrrrr   rrrrrrrrr                    3:::::3       E:::::E       EEEEEExxxxxxx      xxxxxxxaaaaaaaaaaaaa      mmmmmmm    mmmmmmm   ppppp   ppppppppp    l::::l     eeeeeeeeeeee        ssssssssss   \n" +
                "C:::::C               h::::hh:::::hhh      a::::::::::::a p::::ppp:::::::::p  t:::::::::::::::::t      ee::::::::::::ee  r::::rrr:::::::::r                   3:::::3       E:::::E              x:::::x    x:::::x a::::::::::::a   mm:::::::m  m:::::::mm p::::ppp:::::::::p   l::::l   ee::::::::::::ee    ss::::::::::s  \n" +
                "C:::::C               h::::::::::::::hh    aaaaaaaaa:::::ap:::::::::::::::::p t:::::::::::::::::t     e::::::eeeee:::::eer:::::::::::::::::r          33333333:::::3        E::::::EEEEEEEEEE     x:::::x  x:::::x  aaaaaaaaa:::::a m::::::::::mm::::::::::mp:::::::::::::::::p  l::::l  e::::::eeeee:::::eess:::::::::::::s \n" +
                "C:::::C               h:::::::hhh::::::h            a::::app::::::ppppp::::::ptttttt:::::::tttttt    e::::::e     e:::::err::::::rrrrr::::::r         3:::::::::::3         E:::::::::::::::E      x:::::xx:::::x            a::::a m::::::::::::::::::::::mpp::::::ppppp::::::p l::::l e::::::e     e:::::es::::::ssss:::::s\n" +
                "C:::::C               h::::::h   h::::::h    aaaaaaa:::::a p:::::p     p:::::p      t:::::t          e:::::::eeeee::::::e r:::::r     r:::::r         33333333:::::3        E:::::::::::::::E       x::::::::::x      aaaaaaa:::::a m:::::mmm::::::mmm:::::m p:::::p     p:::::p l::::l e:::::::eeeee::::::e s:::::s  ssssss \n" +
                "C:::::C               h:::::h     h:::::h  aa::::::::::::a p:::::p     p:::::p      t:::::t          e:::::::::::::::::e  r:::::r     rrrrrrr                 3:::::3       E::::::EEEEEEEEEE        x::::::::x     aa::::::::::::a m::::m   m::::m   m::::m p:::::p     p:::::p l::::l e:::::::::::::::::e    s::::::s      \n" +
                "C:::::C               h:::::h     h:::::h a::::aaaa::::::a p:::::p     p:::::p      t:::::t          e::::::eeeeeeeeeee   r:::::r                             3:::::3       E:::::E                  x::::::::x    a::::aaaa::::::a m::::m   m::::m   m::::m p:::::p     p:::::p l::::l e::::::eeeeeeeeeee        s::::::s   \n" +
                " C:::::C       CCCCCC h:::::h     h:::::ha::::a    a:::::a p:::::p    p::::::p      t:::::t    tttttte:::::::e            r:::::r                             3:::::3       E:::::E       EEEEEE    x::::::::::x  a::::a    a:::::a m::::m   m::::m   m::::m p:::::p    p::::::p l::::l e:::::::e           ssssss   s:::::s \n" +
                "  C:::::CCCCCCCC::::C h:::::h     h:::::ha::::a    a:::::a p:::::ppppp:::::::p      t::::::tttt:::::te::::::::e           r:::::r                 3333333     3:::::3     EE::::::EEEEEEEE:::::E   x:::::xx:::::x a::::a    a:::::a m::::m   m::::m   m::::m p:::::ppppp:::::::pl::::::le::::::::e          s:::::ssss::::::s\n" +
                "   CC:::::::::::::::C h:::::h     h:::::ha:::::aaaa::::::a p::::::::::::::::p       tt::::::::::::::t e::::::::eeeeeeee   r:::::r                 3::::::33333::::::3     E::::::::::::::::::::E  x:::::x  x:::::xa:::::aaaa::::::a m::::m   m::::m   m::::m p::::::::::::::::p l::::::l e::::::::eeeeeeee  s::::::::::::::s \n" +
                "     CCC::::::::::::C h:::::h     h:::::h a::::::::::aa:::ap::::::::::::::pp          tt:::::::::::tt  ee:::::::::::::e   r:::::r                 3:::::::::::::::33      E::::::::::::::::::::E x:::::x    x:::::xa::::::::::aa:::am::::m   m::::m   m::::m p::::::::::::::pp  l::::::l  ee:::::::::::::e   s:::::::::::ss  \n" +
                "        CCCCCCCCCCCCC hhhhhhh     hhhhhhh  aaaaaaaaaa  aaaap::::::pppppppp              ttttttttttt      eeeeeeeeeeeeee   rrrrrrr                  333333333333333        EEEEEEEEEEEEEEEEEEEEEExxxxxxx      xxxxxxxaaaaaaaaaa  aaaammmmmm   mmmmmm   mmmmmm p::::::pppppppp    llllllll    eeeeeeeeeeeeee    sssssssssss    \n" +
                "                                                           p:::::p                                                                                                                                                                                           p:::::p                                                         \n" +
                "                                                           p:::::p                                                                                                                                                                                           p:::::p                                                         \n" +
                "                                                          p:::::::p                                                                                                                                                                                         p:::::::p                                                        \n" +
                "                                                          p:::::::p                                                                                                                                                                                         p:::::::p                                                        \n" +
                "                                                          p:::::::p                                                                                                                                                                                         p:::::::p                                                        \n" +
                "                                                          ppppppppp                                                                                                                                                                                         ppppppppp                                                        \n" +
                "                                                                                                                                                                                                                                                                                                                             ";
        System.out.println(logo);
        System.out.println("What would you like to do?  \n1: Order numbers\n2: Divisble numbers\n3: Right Triangles\n4: Vehicle regestration\n5: Birthday ");
        selection = Integer.parseInt(sc.nextLine());

        switch (selection) {
            case 1:
            System.out.println("Enter number 1: ");
            int num1 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number 2: ");
            int num2 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number 3: ");
            int num3 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number 4: ");
            int num4 = Integer.parseInt(sc.nextLine());
            checkOrder(num1, num2, num3, num4);
            break;
            case 2:
            System.out.println("Enter number 1: ");
            int x = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number 2: ");
            int y = Integer.parseInt(sc.nextLine());
            checkDivisibility(x, y);
            break;
            case 3:
            System.out.println("Enter side 1: ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.println("Enter side 2: ");
            int b = Integer.parseInt(sc.nextLine());
            System.out.println("Enter side 3: ");
            int c = Integer.parseInt(sc.nextLine());
            checkRightTriangle(a, b, c);
            break;
            case 4:
            System.out.println("Enter the weight of the vehicle in pounds: ");
            int weight = Integer.parseInt(sc.nextLine());
            vehicleRegistration(weight);
            break;
            case 5:
            System.out.println("Enter your birth date (mm-dd-yy): ");
            String birthDate = sc.nextLine();
            dayOfWeek(birthDate);
            break;
        }
            sc.close();
    }


    private static void checkOrder(int num1, int num2, int num3, int num4) {
        if (num1 < num2 && num2 < num3 && num3 < num4) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void checkDivisibility(int x, int y) {

        System.out.println(x % 5 == 0 ? x + " Is Divisible by 5" : x + " Is not Divisible by 5");
        System.out.println(x % 3 == 0 ? x + " Is Divisible by 3" : x + " Is not Divisible by 3");
        System.out.println(y % 5 == 0 ? y + " Is Divisible by 5" : y + " Is not Divisible by 5");
        System.out.println(y % 3 == 0 ? y + " Is Divisible by 3" : y + " Is not Divisible by 3");

    }

    private static void checkRightTriangle(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a + b + c - max - min;

        if (min * min + mid * mid == max * max) {
            System.out.println("These sides form a right triangle.");
        } else {
            System.out.println("These sides do not form a right triangle.");
        }
    }

    private static void vehicleRegistration(int weight) {
        double cost;
        if (weight <= 1500) {
            cost = 23.75;
        } else if (weight <= 2500) {
            cost = 27.95;
        } else if (weight <= 3000) {
            cost = 30.25;
        } else {
            cost = 37.00;
        }
        System.out.printf("The cost of registration is: $%.2f%n", cost);
    }

    private static void dayOfWeek(String birthDate) {
        String[] parts = birthDate.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]) + 1900;

        if (year < 1900 || year >= 2000) {
            System.out.println("Error: Year must be between 1900 and 1999.");
            return;
        }

        int total = (year % 100) / 4;
        total += year % 100;
        total += day;

        int monthValue = 0;
        switch (month) {
            case 1: monthValue = 1; break;
            case 2: monthValue = 4; break;
            case 3: monthValue = 4; break;
            case 4:
                break;
            case 5: monthValue = 2; break;
            case 6: monthValue = 5; break;
            case 7:
                break;
            case 8: monthValue = 3; break;
            case 9: monthValue = 6; break;
            case 10: monthValue = 1; break;
            case 11: monthValue = 4; break;
            case 12: monthValue = 6; break;
        }
        total += monthValue;

        if (year % 4 == 0 && (month == 1 || month == 2)) {
            total -= 1;
        }

        int dayOfWeek = total % 7;
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        System.out.println("You were born on a " + days[dayOfWeek] + ".");
    }

}

