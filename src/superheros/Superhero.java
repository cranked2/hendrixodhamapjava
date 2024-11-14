public class Superhero {
    private String Name;
    private String AlterEgo;
    private String Superpower;
    private String Alignment;
    private int Strengthlevel;

    public Superhero(String Name,String AlterEgo,String Superpower, String Alignment, int Strengthlevel )
    {
        this.Name = Name;
        this.AlterEgo = AlterEgo;
        this.Superpower = Superpower;
        this.Alignment = Alignment;
        this.Strengthlevel = Strengthlevel;

    }

    public Superhero()
    {

    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getName()
    {
        return Name;
    }


    public String getAlterEgo()
    {
        return AlterEgo;
    }

    public void setAlterEgo(String AlterEgo)
    {
        this.AlterEgo = AlterEgo;
    }

    public String getSuperpower()
    {
        return Superpower;
    }


    public void setSuperpower(String Superpower)
    {
        this.Superpower = Superpower;
    }

    public String getAlignment()
    {
        return Alignment;
    }

    public void setAlignment(String Alignment)
    {
        this.Alignment = Alignment;
    }

    public void setStrengthlevel(int Strengthlevel)
    {
        this.Strengthlevel = Strengthlevel;
    }

    public int getStrengthlevel()
    {
        return Strengthlevel;
    }

    public void useSuperpower()
    {
        System.out.println(Name + " uses " + Superpower);
    }

    public String toString()
    {
        return "Name: " + Name + "\n" + "AlterEgo: " + AlterEgo + "\n" + "Superpower: " + Superpower + "\n" + "Alignment: " + Alignment + "\n" + "Strengthlevel: " + Strengthlevel + "\n";
    }


}
