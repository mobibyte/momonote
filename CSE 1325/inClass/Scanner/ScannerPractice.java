import java.util.Scanner;

public class ScannerPractice
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        /* Create a program to make the result of a b and c */
        System.out.print("Please enter a value for a: ");
        int a = input.nextInt();
        System.out.print("Please enter a value for b: ");
        int b = input.nextInt();
        System.out.print("Please enter a value for c: ");
        int c = input.nextInt();

        // int result = a + b + c;
        // System.out.println("The result is " + result);

        System.out.println(a + " + " + b + " + " + c + " = " + (a+b+c)); 
        /*a simpler way of writing it w/out an extra var
        also gives the output a + b + c = r i.e. 1 + 2 + 3 = 6*/


        System.out.println("Please enter the length of the rectangle");
        double length = input.nextDouble();
        System.out.println("Please enter the width of the rectangle");
        double width = input.nextDouble();

        double area = length * width;
        double perimeter = (2 * length) + (2 * width);

        System.out.println("Area = " + area);
        System.out.println("Perimeter = " + perimeter);

        input.close();

    }
}
