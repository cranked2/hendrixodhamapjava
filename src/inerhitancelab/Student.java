package inerhitancelab;

public class Student {
    public final static int NUM_TESTS = 3;
    private String myname;
    private int[]myTests;
    protected String myGrade;

    public Student()
    {
        myname = "jack";
        myTests = new int[NUM_TESTS];
        myGrade = "F";
    }

    public Student(String n, int [] tests, String g)
    {
        myname = n;
        myTests = tests;
        myGrade = g;
    }

    public void computeGrade()
    {
        if(getTestAvg()>= 90)
            myGrade = "A";
        else if(getTestAvg() >= 80)
            myGrade = "B";
        else if(getTestAvg() >= 70)
            myGrade = "C";
        else
            myGrade = "Failure";
    }

    public double getTestAvg()
    {
        int sum = 0;
        for(int k = 0; k<myTests.length; k++)
        {
            sum += myTests[k];
        }
        return (double) sum/NUM_TESTS;
    }

    @Override
    public String toString()
    {
        return myname + "\t" + myGrade;
    }
}
