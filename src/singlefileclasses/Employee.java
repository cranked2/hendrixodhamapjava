package singlefileclasses;

import org.jetbrains.annotations.NotNull;

public class Employee implements Comparable {
    private String name;
    private String pay;
    private int years;
    private static int num;
    public Employee(String name, String pay)
    {
        this.name = name;
        this.pay = pay;

    }
    public int empCount()
    {
        return num;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPay(String pay)
    {
        this.pay = pay;
    }

    public String getName()
    {
        return name;
    }

    public String getPay()
    {
        return pay;
    }
    public int getYears()
    {
         return years;
    }
    public void setYears(int years)
    {
        this.years = years;
    }

    public String toString()
    {
        return name  + " , " + pay;
    }

    public int compareTo( Object obj) {
        Employee emp = (Employee)obj;

        if(this.getYears() > emp.getYears())
            return 1;
        else if (this.getYears() == emp.getYears())
            return 0;
        else
            return -1;
    }
}
