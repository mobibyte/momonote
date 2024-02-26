import java.util.Scanner;

public class leapyear 
{
    public static void main(String [] args)
    {
        //user will enter number of the mont
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter the month number: ");
        // int month = scanner.nextInt();
        // int days = 0;

        // // switch (month) 
        // // {
        // //     case 1:
        // //     case 3:
        // //     case 5:
        // //     case 7:
        // //     case 8:
        // //     case 10:
        // //     case 12:
        // //         days = 31;
        // //         break;
        // //     case 4:
        // //     case 6:
        // //     case 9:
        // //     case 11:
        // //         days = 30;
        // //         break;
        // //     case 2:
        // //     {
        // //         int year;
        // //         System.out.print("Enter a year: ");
        // //         year = scanner.nextInt();
        // //         if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) )
        // //         {
        // //             days = 29;
        // //         }
        // //         else
        // //         {
        // //             days = 28;
        // //         }

        // //         break;
        // //     }
        // //     default: System.out.println("Wrong month number!");
        // // }

        // switch (month) 
        // {
        //     case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
        //     case 4, 6, 9, 11 -> days = 30;

        //     case 2 ->
        //     {
        //         int year;
        //         System.out.print("Enter a year: ");
        //         year = scanner.nextInt();
        //         if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) )
        //         {
        //             days = 29;
        //         }
        //         else
        //         {
        //             days = 28;
        //         }

        //     }
        //     default -> System.out.println("Wrong month number!");
        //     if (month <= 12 && month >= 1)
        //     {
        //         System.out.printf("The month %d is having %d days\n", month, days);
        //     }
        // }


        /********************************************************************************/

        int score;

        System.out.print("Enter a score: ");
        score=scanner.nextInt();
        char grade;

        if(score >= 90)
        {
            grade = 'A';
        }
        else if (score >=80)
        {
            grade = 'B';
        }
        else if (score >= 70)
        {
            grade = 'C';
        }
        else if (score >= 60)
        {
            grade = 'D';
        }
        else
        {
            grade = 'F';
        }

        System.out.printf("You got an %c\n", grade);
        
        scanner.close();
    }
}
