
## Midterm 1

ERB 108 && 109 
(note from current Betim and a funny story ill tell
* These rooms from when i remember didnt exist so we
had to go to nedderman hall instead unnannounced )

7pm

Scanner 1st question

* INPUT OUTPUT 
* IF ELSE
* CONDITIONALS
* LOOPS
* MATH PROBLEMS

Y = 3X + E(N-1) (I=1) (2I + A)
DECLARE A VALUE TO STORE CALCUATIONS
```
S = S + ( 2 * i + a)
For (i = 1; i &lt;= n-1; i++)
{
	calculations

}
```

SUM PRODUCT AND FACTORIAL

Factorials
(2n+a)!
R = 2n+a
F = 1;

For ( i=; i &lt; r; i ++)
	F = f * i ????

Second question
Matrix [][]
* Want user to add unknown values
* Know how to copy one matrix to another
* How to access elements of matrix
* Access third column of the matrix
* Understand how to manipulate the matrix

i/j

**[00]**[01][02]

[10]**[11**][12]

[20][21**][22]**

**If ( i == j)**

	Do something

Above

If ( i > j)

	

Below

If ( i &lt; j)

Opposite diagonal

If( i + j = 2)

	Do something else

3rd question 

* How many times a user enters a thing and then do something with whatever that thing was

4th question

* STRINGS

Split, str tok

Need to know How to use the methods, not memorize
Dont need to import libraries

5th question

Either linked list or array lists
Add values to fill either lists
Or user values
And do something with the values


## Exception handling

```
Try 
{
    String S = “UTA”;

    Int a = Integer.parseInt(“S”);

}
catch (Exception e) 
{
	//.println(“Cannot parse string to integer”);
	.println(e.getMessage()); //prints the kind of error and where it occurs
	//or
	.println(e.toString()); //writes the kind of exception w/out line where it occurs
	.println(e.printStackTrace()); //gives more detail
}
```

Use: throw Exception

There are two
Exceptions and error (we arent interested in errors)

Keywords
* Try
* Catch
* Finally
* Throw
* Throws 

```
getMessage()
toSt
Try
{
	//code here
}
catch(ArithmeticExecption ae)
{
	→ do somethin
}
catch(NullPointerException npe)
{
	→ do somethin else
}

a=3
b=4
A | B
catch(ArithmeticException | NullPointerException …)
{
	→ do somethin 
}
Finally
{
	.println(“This will be executed always”);
}
```

Need to know try catch and finally

L1
L2
L3

SMALL STUPID MISTAKE → int A = integer.parseInt(“1ab”);

Putting try catch around this will stop the program from crashing !


```
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
```

## File handling code


```
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//new imports
import java.io.IOException;
import java.util.Scanner;

public class filehandle
{
    public static void main(String[] args)
    {
        //start with writing a file
        /*
        * have to call file write to specify which file to write and in which place,
        * then inside file writer we have to specify what file we want to be create or accessed
        *   i.e. doing File writer("C:\ user\ drive...") access it at a specific place on your drive, like a roadway to ur file
        * also good practice to put a try catch around bufferedwriter
        */
        try
        {
            /*The second arg in FileWrite, needs to be true or fale based on whether you want to appened or not */
            BufferedWriter writer = new BufferedWriter(new FileWriter("Test.txt" , true));

            //writing to file using bufferedwriterobj.write method, this way it will overwrite it, not appened it
            writer.write("Hello there\n");
            writer.write("General kenobi\n");

            //taking user input to store into our txt file
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a string: ");
            String s = sc.nextLine();
            //storing the string the user wrote in our file
            writer.write(s + "\n");
            writer.newLine();

            //writing a list of names to our txt file
            String[] list = {"James", "Tamerea", "bob", "joey"};
            for (String string : list)
            {
                writer.write(string);
                writer.newLine(); //writes a \n without the work
            }



            //needs to always close writer when done
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //READING

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Test.txt"));
            String s3 = reader.readLine(); //reads in a line from our file (the next line (self incrementing)) and stores it
            System.out.println(s3);  //prints it
            //can also write it like sys.out.println(reader.readLine()); to just read in the 1st

            while(s3 != null)
            {
                System.out.println(s3);
                s3 = reader.readLine(); //self incrementing magic of methods
            }

            reader.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
```