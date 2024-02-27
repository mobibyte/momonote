import java.util.Scanner;

public class guess 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int num = (int)(101*Math.random());
        int guesses = 5;
        int i, guess;

        for(i = 0; i < guesses; i++)
        {
            System.out.println("guess a number between 0 and 100 using only " + guesses + " guesses!");
            guess = input.nextInt();
            if (guess == num)
            {
                System.out.println("thats correct!!");
                System.out.println("you have earned 1 pizza");
                System.out.println("1 pizza added to your inventory");
                break;
            }
            else if (guess > num && i!= guesses-1)
            {
                System.out.println("That guess was too high!");
            }
            else if ((guess < num && i!= guesses-1))
            {
                System.out.println("That guess was too low!");
            }

        }
        
        if ( i == guesses)
        {
            System.out.println("All of your guesses have ran out! \n The guess was " + num + "!");
        }
        
        input.close();
    }
}
