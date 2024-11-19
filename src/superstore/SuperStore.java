package superstore;

import java.util.Scanner;

public class SuperStore {


    public static void main(String[] args) {
        String logo = "" +
                "      ___           ___                         ___           ___                    ___                         ___           ___           ___     \n" +
                "     /  /\\         /  /\\          ___          /  /\\         /  /\\                  /  /\\          ___          /  /\\         /  /\\         /  /\\    \n" +
                "    /  /::\\       /  /:/         /  /\\        /  /::\\       /  /::\\                /  /::\\        /__/\\        /  /::\\       /  /::\\       /  /::\\   \n" +
                "   /__/:/\\:\\     /  /:/         /  /::\\      /  /:/\\:\\     /  /:/\\:\\              /__/:/\\:\\       \\  \\:\\      /  /:/\\:\\     /  /:/\\:\\     /  /:/\\:\\  \n" +
                "  _\\_ \\:\\ \\:\\   /  /:/         /  /:/\\:\\    /  /::\\ \\:\\   /  /::\\ \\:\\            _\\_ \\:\\ \\:\\       \\__\\:\\    /  /:/  \\:\\   /  /::\\ \\:\\   /  /::\\ \\:\\ \n" +
                " /__/\\ \\:\\ \\:\\ /__/:/     /\\  /  /::\\ \\:\\  /__/:/\\:\\ \\:\\ /__/:/\\:\\_\\:\\          /__/\\ \\:\\ \\:\\      /  /::\\  /__/:/ \\__\\:\\ /__/:/\\:\\_\\:\\ /__/:/\\:\\ \\:\\\n" +
                " \\  \\:\\ \\:\\_\\/ \\  \\:\\    /:/ /__/:/\\:\\_\\:\\ \\  \\:\\ \\:\\_\\/ \\__\\/~|::\\/:/          \\  \\:\\ \\:\\_\\/     /  /:/\\:\\ \\  \\:\\ /  /:/ \\__\\/~|::\\/:/ \\  \\:\\ \\:\\_\\/\n" +
                "  \\  \\:\\_\\:\\    \\  \\:\\  /:/  \\__\\/  \\:\\/:/  \\  \\:\\ \\:\\      |  |:|::/            \\  \\:\\_\\:\\      /  /:/__\\/  \\  \\:\\  /:/     |  |:|::/   \\  \\:\\ \\:\\  \n" +
                "   \\  \\:\\/:/     \\  \\:\\/:/        \\  \\::/    \\  \\:\\_\\/      |  |:|\\/              \\  \\:\\/:/     /__/:/        \\  \\:\\/:/      |  |:|\\/     \\  \\:\\_\\/  \n" +
                "    \\  \\::/       \\  \\::/          \\__\\/      \\  \\:\\        |__|:|~                \\  \\::/      \\__\\/          \\  \\::/       |__|:|~       \\  \\:\\    \n" +
                "     \\__\\/         \\__\\/                       \\__\\/         \\__\\|                  \\__\\/                       \\__\\/         \\__\\|         \\__\\/    ";

       Scanner sc = new Scanner(System.in);

        int rpsw = 29;
        int swpb = 17;
        int rpb = rpsw * swpb;
        int selection;

        String pass = "SigmaOverlords";
        double discount = 0.10;

        double sp = 12;
        double ap = 116;
        double lgp = 70;
        double sgp = 40;

        System.out.println(logo);


        do {
            System.out.println("Is there a customer in line? (1 = yes, 2 = no) > ");
            selection = Integer.parseInt(sc.nextLine());;
            
            if (selection == 2)
            {
                System.out.println("BYE");
                break;
            }

            boolean isMember = checkMembership(sc,pass);
            displayPriceList(isMember);

            int shields = 0, armor = 0, smallGadgets = 0, largeGadgets = 0;

            int checkout = 0;
            while (checkout != 1) {
                System.out.println("Please choose an option:");
                System.out.println("    1) Update Shields Order");
                System.out.println("    2) Update Armor Order");
                System.out.println("    3) Update Super Gadget Order");
                System.out.println("    4) Check Out");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        shields = updateShields(sc);
                        break;
                    case 2:
                        armor = updateArmor(sc);
                        break;
                    case 3:
                        smallGadgets = updateSmallGadgets(sc);
                        largeGadgets = updateLargeGadgets(sc);
                        break;
                    case 4:
                        checkout = 1;
                        break;
                }
            }
            double total = calculateTotal(shields, armor, smallGadgets, largeGadgets, isMember,discount,sp,rpsw,ap,sgp,lgp);
            if (isMember && total >= 1000) {
                System.out.printf("Bonus discount of 10%%: -%.2f\n", total * discount);
                total *= (1 - discount);
            }
            System.out.printf("New Total: %.2f\n", total);

            processPayment(sc, total,rpsw,rpb);

            System.out.println("\nThank you for shopping at the Super Store!\n");
        }while(selection != 2 );
        sc.close();

    }

    private static boolean checkMembership(Scanner sc,String member_password) {
        System.out.print("What is the password? hint SigmaOverlords");
        String password = sc.nextLine();
        if (password.equals(member_password)) {
            System.out.println("Welcome Very Super member!");
            System.out.println("You will get special discounts at the Super Store!");
            return true;
        } else {
            System.out.println("Sorry but that is not right. We will give you one more chance.");
            System.out.print("What is the password? ");
            password = sc.nextLine();
            if (password.equals(member_password)) {
                System.out.println("Welcome Very Super member!");
                return true;
            }
        }
        System.out.println("Please enjoy our items at their regular prices.");
        return false;
    }

    private static void displayPriceList(boolean isMember) {
        System.out.println("Here is our price list:");
        if (isMember) {
            System.out.println("    Shields (each)            11 Rubles");
            System.out.println("    Shields 2 or more         10 Rubles each");
            System.out.println("    Armor (each)              100 Rubles");
            System.out.println("    Super Gadget (small)      50 Rubles");
            System.out.println("    Super Gadget (large)      58 Rubles (2 Scally Wags)");
        } else {
            System.out.println("    Shields (each)            12 Rubles");
            System.out.println("    Shields (5 or more)       2 Scally Wags or 58 Rubles");
            System.out.println("    Armor                     4 Scally Wags or 116 Rubles");
            System.out.println("    Super Gadget (small)      50 Rubles");
            System.out.println("    Super Gadget (large)      70 Rubles");
        }
    }

    private static int updateShields(Scanner sc) {
        System.out.println("How many Shields would you like?");
        return Integer.parseInt(sc.nextLine());
    }

    private static int updateArmor(Scanner sc) {
        System.out.println("How much Armor would you like?");
        return  Integer.parseInt(sc.nextLine());
    }

    private static int updateSmallGadgets(Scanner sc) {
        System.out.println("How many small Super Gadgets would you like?");
        int small = Integer.parseInt(sc.nextLine());
        return small;
    }

    private static int updateLargeGadgets(Scanner sc) {
        System.out.println("How many large Super Gadgets would you like?");
        int large =  Integer.parseInt(sc.nextLine());
        return large;
    }

    private static double calculateTotal(int shields, int armor, int smallGadgets, int largeGadgets, boolean isMember,double member_discount,double shield_price,int rubles_per_scaly_wag,double armor_price,double small_gadget_price,double large_gadget_price) {
        double total = 0;
        double shield_discount = member_discount * shield_price + shield_price;
        double armor_discount = member_discount * armor_price + armor_price;
        double large_gadget_discount = member_discount * large_gadget_price + large_gadget_price;

        if (shields >= 5) total += shields * (isMember ? shield_discount : rubles_per_scaly_wag * 2);
        else total += shields * shield_price;

        total += armor * (isMember ? armor_discount : armor_price);
        total += smallGadgets * small_gadget_price;
        total += largeGadgets * (isMember ? large_gadget_discount : large_gadget_price);

        System.out.printf("Total: %.2f\n", total);
        return total;
    }

    private static void processPayment(Scanner sc, double total,int rubles_per_scaly_wag,int rubles_per_buckaroo) {
        double amountPaid = 0;
        while (amountPaid < total) {
            System.out.print("Please enter your payment amount (e.g., '3 Buckeroos'): ");
            int amount = Integer.parseInt(sc.nextLine());
            String currency = sc.nextLine();
            
            switch (currency.toLowerCase()) {
                case "rubles":
                    amountPaid += amount;
                    break;
                case "scally wags":
                    amountPaid += amount * rubles_per_scaly_wag;
                    break;
                case "buckeroos":
                    amountPaid += amount * rubles_per_buckaroo;
                    break;
            }
            if (amountPaid < total) {
                System.out.printf("I'm sorry but your total is %.2f Rubles and you have given only %.2f.\n", total, amountPaid);
            }
        }

        System.out.println("Thank you!");
    }
}