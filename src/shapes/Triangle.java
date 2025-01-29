package shapes;

public class Triangle implements Shape, Comparable {
    private double a, b , c;

    public Triangle() //defstrcut
    {
        a=0; b=0; c=0;
    }
    public Triangle(double a, double b, double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    //helper - calculations
    public double clacPerimeter()
    {
        return(a+b+c);
    }
    public double calcArea()
    {
        double s = clacPerimeter()/2.0;
        double area = Math.sqrt(s*(s-a)*(s-b) * (s-c));
        return area;

    }

    public String toString()
    {
        return "P: " + clacPerimeter() + "\nArea " + calcArea();
    }

    public int compareTo(Object obj)
    {
        Shape t = (Shape) obj;
        if(this.calcArea()==t.calcArea())
            return 0;
        else if (this.calcArea()<t.calcArea())
            return -1;
        else
            return 1;
    }

}
