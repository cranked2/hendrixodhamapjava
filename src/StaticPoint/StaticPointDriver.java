package StaticPoint;

public class StaticPointDriver {
    public static void main(String args[])
    {
        StaticPoint a = new StaticPoint(3,4);
        StaticPoint b = new StaticPoint(1,0);

        a.swap();

        System.out.println("a: " + a);

        b.swap();

        System.out.println("b: " + b);

    }
}
