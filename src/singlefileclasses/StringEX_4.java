package singlefileclasses;

public class StringEX_4 {

    public static void main(String[] args) {

        String message = "Java Is Great Fun!";
        System.out.println(message.toUpperCase());
        message = message.toLowerCase();
        System.out.println(message);
        //analysis
        int n1=4,n2=1,n3=2;
        String s1 = "";//null
        String s2 = "s2"; //null pointer exception
        String s3 = "null";

        System.out.println(n1 + " " + n2 + " " + " " + n3);

        System.out.println(s1 + " " + s2 + " " + " " + s3);

        n1 = message.indexOf("a");
        n2 = message.indexOf("eat");
        n3 = message.indexOf("good");

        System.out.println(n1 + "\n " + n2 + "\n" + "\n" + n3);

        int len = message.length();
        s1 = message.substring(2);
        s2 = message.substring(8,13);
        s3 = message.substring(len - 5);

        System.out.println(s1 + "\n " + s2 + "\n" + "\n" + s3);

        System.out.println(message.substring(50));//run time
        //Index out of bounds





    }
}