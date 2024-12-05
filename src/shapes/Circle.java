package shapes;

public class Circle {
    private double radius;

    public Circle(double r)
    {
        radius = r;
    }
    public double calcCirc()
    {
        return 2*Math.PI*radius;
    }
    public double calcArea()
    {
        return Math.PI*radius*radius;
    }
    public String toString()
    {
        return "Circuference: " + calcArea() + "\nArea " + "circumfrence" + calcCirc();
    }

}
