## While 

```
I = n;
While ( i &lt;= n )
{
	f= f * i;
	I++;
}
```


### Do while
```
i = 1;
Do
{
	F = f*i;
	i++
} 
While ( i &lt;= n );
```


### Math problem using loops

#### Sequential sum

```
Y = (n)SeSum( i=1)  (i+2) + 3n! + x
//Unknowns ask users to input data

Input → n, x;
Int s = 0; 	//3, 7,
For ( int i = 1; i &lt;= n; i++) //to increment by odd numbers do i += 2
{
	S = S + (i+2);
}

Int f = 1;
For ( i =1, i &lt; (3*n); i++) 
{
	F = f * i;
}

Int y = s + f + x;
Println → y;
```


#### Sequential product

//symbol looks like a box

T = 3  (n+2)SeProduct(i = 2) i != 5 //skip 5// (3i+2a) - min(a,b)
```
Declare → T, n, a, b, p, i
Input → n, a, b
p = 1;
For ( i = 2; i &lt;= (n+2); i++)
{
    If (i != 5)
    {
	    P = p * (3*i + 2 * a);
    } 
}

Int min = a;
If ( b &lt; a )
{
	Min = b;
}

T = p - min;
Println → result;
```



#### Another problem

```

Y = { 	0		: x+1 > 5
       { 	(2m + n -1)! + x :  x + 1 &lt;5
       {	x ^7 + 5 E(n-1, i =1) (2i + 2a) : x+1 = 5

Declare n, x, m, a, i, y, f=1, s = 0, 
Input → n, x, m, a;
If ( x + 1 > 5)
{
	y=0;
}
Else if ( x+1 &lt; 5)
{
	For ( i = 1; 1 &lt;= (2 * m + n - 1; i++)
	{
		F = f * i;
	}
	Y = f + x;
}
Else
{
	For ( i = 1; 1 &lt;= n-1, i++)
	{
		S = s + (2 * i + 2 * a);
	}
	Y = Math.pow(x,7) + 5 * s;
}

Println → Y
```


## Break and Continue & labeled?

What does continue do?

* It will just skip the rest of the code underneath and i will increment

```
For ( i = 1; i  &lt;= 10; i++)
{
	If ( i == 5)
	{
		continue;
	}
	println(i);
}
```


Break

* Instead of skipping the loop and continues looping
* It instead breaks out of the loop
* Only breaks the closest loop to itself

```
For ( i = 1; i  &lt;= 10; i++)
{
	If ( i == 5)
	{
		break;
	}
	println(i);
}
```

Labled

* Creates a label for our loops, when using a break statement we can refer to the label on where we do want to break
* Can also do this with continue too

```
first: 

for(j =1; j&lt;10; j++)
{
	Second:
    For ( i = 1; i  &lt;= 10; i++)
    {
    	If ( i == 5)
    	{
    		Break first;
    	}
    	println(i);
    }
}
```


## Nested loops

```
for(i=0; i&lt; S, i++)
{
	for(j =0; j &lt; 5; j++)
	{
		println(i + “ “ + j);
	}
}
```

Can be useful to display arrays

Or making wacky patterns on the screen
```
N = input.nextInt();
for(i = 1, i &lt;= n, i++)
{
	for( j = 1; j &lt;= i; j++)
	{
		print(j); //if you put this as i
	}
	println();
}


(if you print j)

Input: 5

1

12

123

1234

12345

(If you print i)

1

22

333

4444

55555
```


### Programming examples

Being told that while loops are for sentinel values, while the other professor would give us 0’s for sentinel values.


### Sum product and factorial

Y = e (n)sum(i=1) **(a!** + 3i)

The factorial parts are not the same, the a factorial is static, but the i factorial…is not.

Sequential Sum with static factorial

```
F = 1;
for(i =1; i &lt;= a; i++)
{
	f= f* i;
}

S = 0;
For (i = 1; i&lt;=n; i++)
{
	S = s + (f + 3*1);
}
```

Sequential product with dynamic factorial

```
y= b^7 + a (n+1)product(i=1) (** i!** + 3)
P =1;
for (i = 1; i&lt;= n+1; i++)
{
	f=1;
	For (j = 1; j &lt;= i; j++)
	{
		F = f * j;
	}
	P = p * ( f + 3 );
}
```


## Guessiing game, with a random number


```
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
```



## Another program for an atm machine


```
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
```
