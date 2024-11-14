import java.util.Scanner;

public class SuperStore {
    private static final int RUBLES_PER_SCALLY_WAG = 29;
    private static final int SCALLY_WAGS_PER_BUCKEROO = 17;
    private static final int RUBLES_PER_BUCKEROO = RUBLES_PER_SCALLY_WAG * SCALLY_WAGS_PER_BUCKEROO;

    private static final String MEMBER_PASSWORD = "$uperDooper";
    private static final double MEMBER_DISCOUNT = 0.10;

    private static final double SHIELD_PRICE = 12;
    private static final double SHIELD_DISCOUNT_PRICE = 10;
    private static final double ARMOR_PRICE = 116;
    private static final double ARMOR_MEMBER_PRICE = 100;
    private static final double SMALL_GADGET_PRICE = 50;
    private static final double LARGE_GADGET_PRICE = 70;
    private static final double LARGE_GADGET_MEMBER_PRICE = 58;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean anotherCustomer = true;

        System.out.println("Welcome to the Super Store!");

        while (anotherCustomer) {
            System.out.print("Is there a customer in line? (1 = yes, 2 = no) > ");
            if (scanner.nextInt() == 2) break;
            scanner.nextLine(); // Consume newline

            boolean isMember = checkMembership(scanner);

            // Display pricing information based on membership status
            displayPriceList(isMember);

            // Customer's order variables
            int shields = 0, armor = 0, smallGadgets = 0, largeGadgets = 0;

            // Order update loop
            boolean checkout = false;
            while (!checkout) {
                System.out.println("Please choose an option:");
                System.out.println("    1) Update Shields Order");
                System.out.println("    2) Update Armor Order");
                System.out.println("    3) Update Super Gadget Order");
                System.out.println("    4) Check Out");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        shields = updateShields(scanner, isMember);
                        break;
                    case 2:
                        armor = updateArmor(scanner);
                        break;
                    case 3:
                        int[] gadgets = updateGadgets(scanner);
                        smallGadgets = gadgets[0];
                        largeGadgets = gadgets[1];
                        break;
                    case 4:
                        checkout = true;
                        break;
                }
            }

            // Calculate and display subtotal
            double total = calculateTotal(shields, armor, smallGadgets, largeGadgets, isMember);
            if (isMember && total >= 1000) {
                System.out.printf("Bonus discount of 10%%: -%.2f\n", total * MEMBER_DISCOUNT);
                total *= (1 - MEMBER_DISCOUNT);
            }
            System.out.printf("New Total: %.2f\n", total);

            // Payment processing
            processPayment(scanner, total);

            System.out.println("\nThank you for shopping at the Super Store!\n");
        }

        scanner.close();
    }

    private static boolean checkMembership(Scanner scanner) {
        System.out.print("What is the password? ");
        String password = scanner.nextLine();
        if (password.equals(MEMBER_PASSWORD)) {
            System.out.println("Welcome Very Super member!");
            System.out.println("You will get special discounts at the Super Store!");
            return true;
        } else {
            System.out.println("Sorry but that is not right. We will give you one more chance.");
            System.out.print("What is the password? ");
            password = scanner.nextLine();
            if (password.equals(MEMBER_PASSWORD)) {
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

    private static int updateShields(Scanner scanner, boolean isMember) {
        System.out.println("How many Shields would you like?");
        return scanner.nextInt();
    }

    private static int updateArmor(Scanner scanner) {
        System.out.println("How much Armor would you like?");
        return scanner.nextInt();
    }

    private static int[] updateGadgets(Scanner scanner) {
        System.out.println("How many small Super Gadgets would you like?");
        int small = scanner.nextInt();
        System.out.println("How many large Super Gadgets would you like?");
        int large = scanner.nextInt();
        return new int[]{small, large};
    }

    private static double calculateTotal(int shields, int armor, int smallGadgets, int largeGadgets, boolean isMember) {
        double total = 0;

        if (shields >= 5) total += shields * (isMember ? SHIELD_DISCOUNT_PRICE : RUBLES_PER_SCALLY_WAG * 2);
        else total += shields * SHIELD_PRICE;

        total += armor * (isMember ? ARMOR_MEMBER_PRICE : ARMOR_PRICE);
        total += smallGadgets * SMALL_GADGET_PRICE;
        total += largeGadgets * (isMember ? LARGE_GADGET_MEMBER_PRICE : LARGE_GADGET_PRICE);

        System.out.printf("Total: %.2f\n", total);
        return total;
    }

    private static void processPayment(Scanner scanner, double total) {
        double amountPaid = 0;
        while (amountPaid < total) {
            System.out.print("Please enter your payment amount (e.g., '3 Buckeroos'): ");
            int amount = scanner.nextInt();
            String currency = scanner.next();
            
            switch (currency.toLowerCase()) {
                case "rubles":
                    amountPaid += amount;
                    break;
                case "scallywags":
                    amountPaid += amount * RUBLES_PER_SCALLY_WAG;
                    break;
                case "buckeroos":
                    amountPaid += amount * RUBLES_PER_BUCKEROO;
                    break;
            }
            if (amountPaid < total) {
                System.out.printf("I'm sorry but your total is %.2f Rubles and you have given only %.2f.\n", total, amountPaid);
            }
        }

        System.out.println("Thank you!");
    }
}