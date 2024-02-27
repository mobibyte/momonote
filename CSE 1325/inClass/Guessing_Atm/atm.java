import java.util.Scanner;

public class atm 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int balance = 100_000;
        int withdraw, deposit, choice = 0;

        while(choice != 4)
        {
            System.out.println("Choose one of the options: ");
            System.out.println("Withdraw     (1): ");
            System.out.println("Deposit      (2): ");
            System.out.println("Check balance(3): ");
            System.out.println("Exit         (4): ");
            choice = input.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("What is the amount you would like withdrawn? ");
                    withdraw = input.nextInt();

                    while ( withdraw > balance)
                    {
                        System.out.println("insufficient funds.");
                        System.out.print("What is the amount you would like withdrawn? ");
                        withdraw = input.nextInt();
                    }
                    balance -= withdraw;
                    System.out.println("Balance is now " + balance + ", please collect " + withdraw + "!");

                    break;
                case 2:
                    System.out.print("What is the amount you would like deposited? ");
                    deposit = input.nextInt();
                    balance += deposit;

                    System.out.println("Balance is now " + balance + "!");

                    break;
                case 3:
                    System.out.println("Balance is " + balance + "!");

                    break;
                case 4:
                    System.out.println("Goodbye!");

                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }
}
