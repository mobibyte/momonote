package Function;

public class myMethods 
{
    public int minFunction(int n1, int n2)
    {
        int min;
        if(n1 > n2)
        {
            min = n2;
        }
        else
        {
            min = n1;
        }
        return min;
    }
    //for double
    public static double minFunction(double n1, double n2)
    {
        double min;
        if(n1 > n2)
        {
            min = n2;
        }
        else
        {
            min = n1;
        }
        return min;
    }

    // public static double minArray(double array[] )
    // {

    // }

    public static void printMax ( double... numbers) //double [] numbers
    {
        if( numbers.length == 0)
        {
            System.out.println("no arguments passed");
            return; // just go back to main
        }

        double result = numbers[0];

        for (int i = 1; i < numbers.length; i++)
        {
            if(numbers[i] > result)
                result = numbers[i];

            result = numbers[i];
        }
        System.out.println("The max value is " + result);
    }

    public void displayInt ( int...list)
    {
        System.out.println("\n number of arguements: "+  list.length);

        for(int i : list)
        {
            System.out.println(i + "\t");
        }
    }
    public void displayString (String...list) // List[] = "Hello there", "im good", "woa kenny"
    {
        System.out.println("\n number of arguements: "+  list.length); //would print out 3

        for(String i : list) // grabs array element n + 1
        { // String i : list  (starts at array element 0)
            System.out.print(i + "\t"); //prints out n
        }
    }

    
}
