/*BaseConvert.java
 *CS 0401 Lab 2
 **/

import java.util.Scanner;

public class BaseConvert {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int base;
        int base10Num;
        int maxNumber;

        int place0, place1, place2, place3;

        String baseBNum = "";


        System.out.println("Please enter a base (2-9):");
        base = sc.nextInt();

        System.out.println("Please enter a base 10 number to convert:");
        base10Num = sc.nextInt();

        maxNumber = (int) Math.pow(base, 4) - 1;
        System.out.println("The maximum number in base " + base + " that fits in 4 digits is: " + maxNumber);


        if (base10Num > maxNumber) {
            System.out.println("Error: The number exceeds the maximum value for base " + base);
            return;
        }


        place0 = base10Num % base;
        base10Num = base10Num / base;
        place1 = base10Num % base;
        base10Num = base10Num / base;
        place2 = base10Num % base;
        base10Num = base10Num / base;
        place3 = base10Num % base;


        baseBNum = place3 + "" + place2 + "" + place1 + "" + place0;
        
        System.out.println("The number in base " + base + " is: " + baseBNum);
    }
}
