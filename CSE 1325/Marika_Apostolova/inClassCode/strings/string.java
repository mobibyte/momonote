import java.util.Scanner;

public class string 
{
    public static void main(String[] args) throws Exception
    {
        String s1 = "Welcome there";
        //extract 5th char there
        char ch = s1.charAt(5); //.charAt(index) 
        System.out.println("ch is "+ch);//output: c

        int len = s1.length(); //stores the length of the string
        System.out.println("there are "+len+ " characters in the string");

        String s2 = "UTA";
        String s3 = "UTA";
        int res = s1.compareTo(s2); //compareTo method to compare equality of strings, returns a value
        System.out.println("Result of comparing S1 and S2 is " + res); //result is 2 so false?
        res = s2.compareTo(s3);
        System.out.println("Result of comparing S2 and S3 is " + res); // result is 0 which means =
        System.out.println("Hello " + s2 + " how are you?");


        char A[] = {'h','e','l','l','o', '!'};
        String s4 = "";
        s4 = s4.copyValueOf(A); //copys value of char array A
        System.out.println("copy value of s4 = " + s4);
        String s5 = "";
        s5 = s5.copyValueOf(A, 3, 3); //copys value of char array A from offset of 3, and counts to end of array only for char array
        System.out.println("copy value of s5 = " + s5);

        //Done with literals
        //now string objs
        System.out.println("\n\n\n");
        String s6 = new String("Java is fun!");
        boolean result;
        result = s6.endsWith("fun!"); //endsWith(var or "String")  //compares the ending of the strings to each other
        System.out.println("Ends with fun ? = " + result);

        String s7 ="PC";
        String s8 = "pc";

        System.out.println("s7 == s8 ? = " + s7.equals(s8)); //checks if s7 and s8 are == by specific characters
        System.out.println("s7 == s8 ? = " + s7.equalsIgnoreCase(s8)); //ignores case sensitivity


        String s9 = new String("UTA rocks!");
        System.out.println("s9 o appears at index = " + s9.indexOf('o')); //returns the first occurance of the letter o 

    }
}
