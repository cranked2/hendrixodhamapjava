package lightsequence;

import java.util.Scanner;
public class lightDriver
{

    public static void main (String [] args)
    {
        LightSequence gradShow = new LightSequence("0101 0101 0101");
        gradShow.display();
        gradShow.changeSequence("0011 0011 0011");
        gradShow.display();

        System.out.println(gradShow.insertSegment("000",2));
        gradShow.display();


    }

}
