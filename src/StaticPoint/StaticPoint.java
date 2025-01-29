package StaticPoint;

public class StaticPoint {
    private static int x;
    private static int y;

    public StaticPoint(int a, int b)
    {
        x = a;
        y = b;
    }

    public void swap()
    {
        int temp =x;
        x = y;
        y = temp;
    }

    public String toString()
    {
        return x + " " + y;
    }
}
