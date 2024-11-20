package student;

public class Student {

    private String name, sn;
    private double gpa;
    private int gradYr;
    private static String teacher;

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

    public String setName(String name)
    {
        this.name = name;
        return name;
    }

    public String getName()
    {
        return name;
    }

    public String getSN()
    {
        return sn;
    }

    public String setSN(String name)
    {
        this.sn = name;
        return name;
    }


    public double getGpa()
    {
        return gpa;
    }

    public double setGpa(double gpa)
    {
        this.gpa = gpa;
        return gpa;
    }

    public int setgradYr(int gradYr)
    {
        this.gradYr = gradYr;
        return gradYr;
    }


    public double getgradYr(double gradYr)
    {
        return gradYr;
    }

    public static String getTeacher()
    {
        return teacher;
    }

    public static void setTeacher(String name)
    {
        teacher = name;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name);
        sb.append("Sn: ").append(sn);
        sb.append("GradYr: ").append(gradYr);
        sb.append("Teacher: ").append(teacher);
        sb.append("Gpa: ").append(gpa);
        return sb.toString();
    }






}
