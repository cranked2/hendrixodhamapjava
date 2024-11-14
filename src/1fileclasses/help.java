public class help {
    public static void main(String[] args)
    {
        int count_i =0, count = 0;
        for(int i =0; i<6; i++)
        {
            for(int j=0;j<4; j++)
            {
                System.out.print("this is j " + j + " |");
                count++;
            }
            System.out.println(i + " " + count + " " + count_i);
            count_i = count_i + 1;

            String lgoo =
                    "false should return false\n" +
                    "true should return true";

        }
    }
}
