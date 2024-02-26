import java.util.Scanner;

public class tryCatchFinally 
{
    public static void main(String [] args)
    {
        try
        {
            int a = 30, b = 0;
            int c = a/b;
            System.out.println("Result = " + c);
        }
        catch (ArithmeticException e)
        {
            System.out.println("An Arithmetic Exception has occurred: "+ e);
            // System.out.println("An Arithmetic Exception has occurred: "+ e.toString());
            // e.printStackTrace();
        }
        finally //finally dont care
        {
            System.out.println("Finally block...");
        }

        System.out.println("Next statements...");


        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");
        
        //null pointer

        try
        {
            String a = null;
            System.out.println(a.charAt(0));
        }
        catch(NullPointerException | ArithmeticException e)
        {
            System.out.println("Null pointer exception");
        }
        // catch(NullPointerException e)
        // {
        //     System.out.println("Null pointer Exception");
        // }
        // catch(ArithmeticException ae) 
        // {
        //     System.out.println("Arithmetic Exception");
        // }
        finally //finally dont care
        {
            System.out.println("Finally block...");
        }
        
        System.out.println("Next statements...");


        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");
        
        try
        {
            String a = "This is like chipping ";
            char c = a.charAt(24);
            System.out.println(c);
        }
        catch (StringIndexOutOfBoundsException ie)
        {
            System.out.println("String Intdex Out of Bounds");
        }

        finally //finally dont care
        {
            System.out.println("Finally block...");
        }
        
        System.out.println("Next statements...");
        
        
        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");
        
        try
        {
            // "akki" is not a number
            int num = Integer.parseInt("akki123");
            System.out.println(num);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Number format exception");
        }

        finally //finally dont care
        {
            System.out.println("Finally block...");
        }
        
        System.out.println("Next statements...");
        
        
        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");
        
        
        // int[] arr = new int[4];
        // try
        // {
        //     int i = arr[4];
            
        //     //this statement will never exvute as exception is raised by above statement (without catch our whole program crashes)
        //     System.out.println("inside try block");
        // }
        // catch (ArrayIndexOutOfBoundsException ai)
        // {
        //     ai.printStackTrace();
        // }
        // finally
        // {
        //     System.out.println("Finally block exceuted");
        // }
        
        System.out.println("Next statements...");
        
        
        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");
        
        
        Scanner scan = new Scanner("Hello UTA!");

        System.out.println("" + scan.nextLine());

        //check if there is an IO exception
        System.out.println("Exception output: " + scan.ioException());

        scan.close();
        
        System.out.println("Next statements...");
        
        
        

    }
}
