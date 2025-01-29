package shapes;


public class Circle implements Shape,Comparable{
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

    @Override
    public int compareTo(Object obj) {
        Shape c = (Shape) obj;
        if(this.calcArea()==c.calcArea())
            return 0;
        else if (this.calcArea()<c.calcArea())
            return -1;
        else
            return 1;
    }

    public String toString()
    {
        return "Circuference: " + calcArea() + "\nArea " + "circumfrence" + calcCirc();
    }

}
