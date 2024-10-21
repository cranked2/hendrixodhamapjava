public class Superdriver
{
    public static void main (String [] args)
    {
        Superhero superman = new Superhero("Jack lester","Jack","Bad at Java","Good",21390183);

        System.out.println(superman);

        Superhero batMan = new Superhero();

        batMan.setAlignment("Good");
        batMan.setName("Batman");
        batMan.setStrengthlevel(90000000);
        batMan.setAlterEgo("Bruce Wayne");
        batMan.setSuperpower("Super Rich");

        System.out.println(batMan.getAlignment());
        System.out.println(batMan.getAlterEgo());
        System.out.println(batMan.getName());
        System.out.println(batMan.getSuperpower());
        System.out.println(batMan.getStrengthlevel() + "\n");

        superman.useSuperpower();
        batMan.useSuperpower();
    }
}
