import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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
        
        System.out.println("\n");

        //split and append with stuff in a file
        try
        {
            String line;
            int count = 0;
            
            BufferedReader br = new BufferedReader(new FileReader("Test.txt"));
            
            while((line = br.readLine()) != null)
            {
                String words[] = line.split(" ");
                count = count + words.length;
            }

            System.out.println("Number of characters present in given file: " + count);
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        //appending

        try
        {
            String str = "World";
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
            writer.append(' ');
            writer.append(str);

            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    } 
}