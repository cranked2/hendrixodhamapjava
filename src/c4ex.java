import java.util.Scanner;

public class C4ex {

    public static void sameStarChar(String str) {
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*') {
                if (str.charAt(i - 1) == str.charAt(i + 1)) {
                    System.out.print("true ");
                } else {
                    System.out.print("false ");
                }
            }
        }
        System.out.println();
    }

    public static void checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                System.out.println("false");
                return;
            }
            start++;
            end--;
        }
        System.out.println("true");
    }

    public static String removeSubstring(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < str1.length()) {
            if (str1.substring(i, Math.min(i + str2.length(), str1.length())).equalsIgnoreCase(str2)) {
                i += str2.length();
            } else {
                result.append(str1.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int selection = 0;
        System.out.println("What would you like to do?  \n1: Same Star Char\n2: Palindrome\n3: Without String\n");
        selection = Integer.parseInt(sc.nextLine());

        switch (selection) {
            case 1:
                System.out.print("Enter a string: ");
                String str = sc.nextLine();
                sameStarChar(str);
                break;
            case 2:
                System.out.print("Enter a string: ");
                String str2 = sc.nextLine();
                checkPalindrome(str2);
                break;
            case 3:
                System.out.print("Enter a string: ");
                String str3 = sc.nextLine();
                System.out.print("Enter a substring to remove: ");
                String str4 = sc.nextLine();
                String result = removeSubstring(str3, str4);
                System.out.println("Result: " + result);
                break;
        }
        sc.close();
    }

}
