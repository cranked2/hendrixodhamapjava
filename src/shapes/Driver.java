package shapes;



public class Driver {

    public static void main(String[] args)
    {
        Triangle obtuse = new Triangle();
        Shape acute = new Triangle(5,12,13);
        Triangle equil = new Triangle(9,9,9);

        System.out.println(obtuse.toString());
        System.out.println(acute.toString());
        System.out.println(equil.toString());

        Circle pool = new Circle(15);
        Shape table = new Circle(6);

        System.out.println(pool);
        System.out.println(table);

        int result = acute.compareTo(table);

        if(result == 0)
            System.out.println("Areas Are equal");
        else if (result > 0 )
            System.out.println("Greater");
        else
            System.out.println("Less");
    }

    // Circle c = new Circle(9);
    //cannot instantiate an interface
    //Shape cannot be an instance becayse it has no constrcutors
    // Shape c = new Shape();
    //Shape c = new Comparable();
}
