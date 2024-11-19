package student;

public class Student {

    private String name, sn;
    private double gpa;
    private int gradYr;

    public static void maim(String[] args)
    {
        //state - attributes (characteristics)
        //acc modifier,protected,priv and pub

    }

    public Student ()
    {
        //automatically created
        name = "";      sn = "";
        gpa = 2.5;      gradYr = 2025;
    }

    public Student (String name, int year)
    {
        this.name = name;
        gradYr = year;
    }

    public Student(String name, String sn, double gpa, double avg, int year){
        this.name = name; this.sn = sn; gpa = avg; gradYr = year;
    }
    public Student(String name)
    {
        this.name = name;
    }
    // acc methods that allow acc of members
    //getters pref get return value

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }


}
