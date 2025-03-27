package inerhitancelab;

public class GradStudent extends Student {
    private int myGradID;

    public GradStudent()
    {
        super();
        myGradID = 0;
    }

    public GradStudent(String n, int[] tests, String g, int ID)
    {
        super(n,tests,g);
        myGradID = ID;
    }

    public void computeGrade()
    {
        super.computeGrade();//calls inherited computegrade
        if(getTestAvg() >= 90)
            myGrade = "In Hendiddy we trust.";


    }
}
