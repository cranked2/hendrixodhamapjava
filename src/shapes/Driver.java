package shapes;



public class Driver {

    public static void main(String[] args)
    {
        Triangle obtuse = new Triangle();
        Triangle acute = new Triangle(5,12,13);
        Triangle equil = new Triangle(9,9,9);

        System.out.println(obtuse.toString());
        System.out.println(acute);
        System.out.println(equil);

        Circle pool = new Circle(15);
        Circle table = new Circle(6);

        System.out.println(pool);
        System.out.println(table);
    }
}
