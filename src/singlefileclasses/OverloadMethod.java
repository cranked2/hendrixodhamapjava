package singlefileclasses;

public class OverloadMethod{
     public static void main(String[] args)
     {
        System.out.println(larger(2.1,5.1));
        System.out.println(larger(1,2,3));
        System.out.println(larger("jack","black"));
     }

     public static boolean larger(double a, double b)
     {
         if(a>b)
             return true;
         else
             return false;
     }

    public static boolean larger(double a, double b, double c)
    {
        if(a>b && b>c)
            return true;
        else
            return false;
    }

    public static boolean larger(String a, String b)
    {
        if(a.length() >= b.length())
            return true;
        else
            return false;

    }


}