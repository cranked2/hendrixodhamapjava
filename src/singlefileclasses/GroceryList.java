package singlefileclasses;
import java.util.*;
import java.io.*;
public class GroceryList {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)throws IOException
    {
        PrintWriter outFile = new PrintWriter("grocery.txt");
        String ans = "";
        while(!(ans.equals("quit")))
        {
            System.out.println("Enrer the nexr item or <quit> when done.");
            ans=sc.nextLine();
            if(!(ans.equals("quit")))
                outFile.print(ans + "\n");
        }
        outFile.close();

        Scanner inFile = new Scanner(new File("grocery.txt"));
        ArrayList<String> groceryList = new ArrayList<>();
        while(inFile.hasNext())
        {
            String str = inFile.nextLine();
            groceryList.add(str);
        }
        inFile.close();
        display(groceryList);
        Collections.sort(groceryList);
    }

    public static void display(ArrayList<String> al)
    {
        for(String s: al) {
            System.out.print(s + ", ");
        }

        System.out.println();

    }

}
