import java.util.Scanner;

public class loops 
{
    public static void main(String[] args)
    {
        Scanner Scanner = new Scanner(System.in);
        int num;
        int count = 0;

        //writen with while loop (techincally written with a sentinel value?)
        // System.out.print("Please enter a number or type a negative to end:  ");
        // int num = Scanner.nextInt();
        // while(num > 0)
        // {
        //     if (num % 3 == 0)
        //     {
        //         count++;
        //     }
        //     System.out.print("Please enter the next number \nor type a less than 0 to end:  ");
        //     num = Scanner.nextInt();
        // }

        //writen with do while loop (techincally written with a sentinel value?)
        // do
        // {
        //     System.out.print("Please enter the next number \nor type a less than 0 to end:  ");
        //     num = Scanner.nextInt();
        //     if (num % 3 == 0)
        //     {
        //         count++;
        //     }
        // }
        // while(num > 0);


        //while loop using a break statement (should not be used)
        while(true)
        {
            System.out.print("Please enter the next number (enter a negative number to end):  ");
            num = Scanner.nextInt();
            if (num % 3 == 0)
            {
                count++;
            }
            if(num < 0)
            {
                break;
            }
        }

        System.out.println("amount of numbers from input divisable with 3 = " + count);
        
    }
}
