package inerhitancelab;

public class UnderGrad extends Student
{
    private int gradeLevel;

    public UnderGrad()
    {
        super();
    }
    public UnderGrad(String n, int[] tests, String g,int grade)
    {
        super(n,tests,g);//must be first
        gradeLevel = grade;

    }

    @Override
    public void computeGrade()
    {
        if(getTestAvg() >= 70)
            myGrade = "Pass";
        else
            myGrade = "Fail";
    }
}
