import java.util.Scanner;
import java.util.StringTokenizer;

public class parsing 
{
    public static void main(String[] args)
    {
        // Scanner sc;
        // String s = ("I love you so much. I want to hug you");
        // sc = new Scanner(s);

        // while( sc.hasNext() ) //hasMoreTokens
        // {
        //     String token = sc.next();
        //     System.out.println( token ); //nextTokens
        // }


        /***************************************************************************/
        Scanner sc1;
        String ss = ("I love you so much. I want to hug you");
        sc1 = new Scanner(ss);

        sc1.useDelimiter("[] .]"); //+
        
        while( sc1.hasNext() ) //hasMoreTokens
        {
            String token = sc1.next();
            System.out.println( token ); //nextTokens
        }
        
        /***************************************************************************/
        // Scanner sc2;
        // String s4 = ("I love you 4 much. I 34 want 22 to hug you");
        // sc2 = new Scanner(s4);
        
        // sc2.useDelimiter("[\\+d]"); //+
        // while( sc2.hasNext() ) //hasMoreTokens
        // {
        //     String token = sc2.next();
        //     System.out.println( token ); //nextTokens
        // }
        
        /***************************************************************************/
        String tokens[];
        String s4 = ("I love you 4 much. I 34 want 22 to hug you");
        tokens = s4.split("[\\s\\d]+");
        
        for (int i = 0; i < tokens.length; i++)
        {
            System.out.println(tokens[i]);
        }
        System.out.println("number of tokens: " + tokens.length); //arrays are treated as an object

        /***************************************************************************/
        StringTokenizer stk; //requires import java.util.StringTokenizer 
        String s = "I love you so much! but i cannot hug you.";

        stk = new StringTokenizer(s);

        while(stk.hasMoreTokens())
            System.out.println(stk.nextToken());


        /**************************************************************************/
        
        String str1 = new String("Nothing is impossible in the world!");
        
        String delimSpace = "[ ]+";
        
        String arr1 [] = str1.split(delimSpace);
        
        for (String uniqVal1 : arr1) //creates a variable to take out of array? I think
            System.out.println(uniqVal1);
            
            
        /**************************************************************************/
        
        
    }
}
