import java.util.Scanner;

public class C4ex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String logo = "" +
                " ______   ___   ___   __   __      ______   __     __     \n" +
                "/_____/\\ /__/\\ /__/\\ /__/\\/__/\\   /_____/\\ /__/\\ /__/\\    \n" +
                "\\:::__\\/ \\::\\ \\\\  \\ \\\\  \\ \\: \\ \\__\\::::_\\/_\\ \\::\\\\:.\\ \\   \n" +
                " \\:\\ \\  __\\::\\/_\\ .\\ \\\\::\\_\\::\\/_/\\\\:\\/___/\\\\_\\::_\\:_\\/   \n" +
                "  \\:\\ \\/_/\\\\:: ___::\\ \\\\_:::   __\\/ \\::___\\/_ _\\/__\\_\\_/\\ \n" +
                "   \\:\\_\\ \\ \\\\: \\ \\\\::\\ \\    \\::\\ \\   \\:\\____/\\\\ \\ \\ \\::\\ \\\n" +
                "    \\_____\\/ \\__\\/ \\::\\/     \\__\\/    \\_____\\/ \\_\\/  \\__\\/\n" +
                "                                                          ";

        System.out.println(logo);

        int selection;
        do {
            System.out.println("What would you like to do?  \n1: Same Star Char\n2: Palindrome\n3: Without String\n0: To Exit");
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
                    System.out.println("Result: " + withoutString(str3, str4));
                    break;
                case 0:
                    break;
            }
        }while(selection != 0);
        sc.close();
    }

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

    public static String withoutString(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < str1.length()) {// check base string loop through every char in base string
            if (str1.substring(i, Math.min(i + str2.length(), str1.length())).equalsIgnoreCase(str2)) {
                i += str2.length();
            } else {
                result.append(str1.charAt(i));//this is what string builder allows me to do
                i++;
            }
        }
        return result.toString();
    }

}
