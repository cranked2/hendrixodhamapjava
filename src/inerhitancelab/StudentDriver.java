package inerhitancelab;

public class StudentDriver {

    public static void main(String args[])
    {
        int[] tests = {80,90,59,60};
        Student jacksmells = new UnderGrad("JackSmells",tests,"A",99);
        UnderGrad chrissy = new UnderGrad("TreySmells",tests,"C",75);
        GradStudent steranko = new GradStudent("The Capper",tests,"B",80);

        jacksmells.computeGrade();
        chrissy.computeGrade();
        steranko.computeGrade();

        System.out.println(jacksmells);
        System.out.println(chrissy);
        System.out.println(steranko);

    }
}
