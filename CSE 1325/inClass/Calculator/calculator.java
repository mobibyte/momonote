import java.util.Scanner;

public class calculator 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        double a, b;
        char op;

        System.out.println("Welcome to a simple java calculator \n The opperands are (+) (-) (/) (*) (%) (0) = minimum (1) = max \n");

        System.out.print("Enter the first number: ");
        a = input.nextDouble();
        System.out.print("Enter an operand: ");
        op = input.next().charAt(0);
        System.out.print("Enter the second number: ");
        b = input.nextDouble();

        

        System.out.println("\n----------------------\n");

        switch (op) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));

                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));

                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));

                break;
            case '/':
                System.out.println(a + " / " + b + " = " + (a / b));

                break;
            case '%':
                System.out.println(a + " % " + b + " = " + (a % b));

                break;
            case '1':
                System.out.println("maxium value is: " + Math.max(a, b));

                break;
            case '0':
                System.out.println("minium value is: " + Math.min(a, b));

                break;
            default:
                break;
        }

        System.out.println("\n----------------------\n");

        System.out.print("Enter an int: ");
        int c = input.nextInt();
        int ones, tens, hundreds, temp;

        temp = c;

        ones = c % 10;
        // System.out.println("Ones = " + ones);
        tens = (c / 10) % 10;
        // System.out.println("Tens = " + tens);
        hundreds = c / 100;
        // System.out.println("Hundreds = " + hundreds);

        c = ones * 100 + tens * 10 + hundreds;

        // System.out.println("your int = " + c);

        String str = (c == temp) ? "a Palindrome" : "Not a palindrome!";
        
        System.out.println("your int is " + str);


        System.out.println("\n----------------------\n");

        System.out.println("please input first value: ");
        int d = input.nextInt();
        System.out.println("please input second value: ");
        int e = input.nextInt();

        if (d > e)
        {
            temp = d;
            d = e;
            e = temp;
        }

        System.out.println(d + " " + e);




        
        
    }
}
