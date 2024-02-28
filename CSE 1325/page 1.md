
# cse 1325 Object Oriented Programming


## Syllabus

Email: [matika.apostolova@uta.edu](mailto:matika.apostolova@uta.edu) 

Office hours: tuesday 10-12 

ERB 545

Midterm exam 09 october 2023 11am

Final exam date 27 november 2023 11am


## WORA



* Write once, run anywhere
* Java is useable everywhere

Difference between structs and classes

## Structures 

```
Struct Student
{
	Int ID,
	String Name,
	String Address,
}
Student S1;
S1.ID = 1001;
```



* You create objects from structures
* When creating an object you can access each thing inside the struct with
* S. 
    * Then you can do ID, Name, and address
    * I.E. S.
* If the data is protected the class that inherits it can only access it
    * If its public then anything can access it
* Every line of code we put in classes
* Packages are like folders
    * You put all the classes in there for what you need it for

```
Class Student
{
	Private int ID; //this cannot be accessed through main

	Public String Name, Add; // can be accessed anywhere easily
}
Student S;
```


## Java 

### JVM
Java virtual machine

* JVM is an interpreter of Java Byte code

### JRE

* Java Runtime Enviornment
* Basically it executes the code, not your actual system
    * Doing it this way makes java universal to run anywhere if JRE is on a system

### JDK

* Java Development Kit
    * Pretty much where all the libraries are
    * JVM most likely pulls from here to link the libraries in your classes that you imported
* **In Java, binary starts with 0b, octal starts with 0, and hexadecimal starts with 0x. **
    * **When of course declaring an int**
    * **I.e. int Binary = 0b1001;**

## Data types

## Primitive

* Int ( 4 bytes)
    * Byte (1 byte) 
    * Long (8 bytes) a = 1_000_000_000
    * Short (2 bytes)
* Double 
    * Float (requires an F at the end)
* Char
* Boolean

## NonPrimative

```
* String
    * Strings are a class
* Array

Int a = 0b00001010;
println(a);

Int b = 0xAF15;
println(b);

Int c = 0753;
println(c);

String username = “Wick”;
println(username);

println(“hello mr” + username);
```

## Java operators



1. Arithmetic 
    1. + - * / %
2. Logical
    2. && || !
3. Relational
4. Unary 
    3. ++ -- - + 
    4. ++a (increments before) a++ (increments after)
5. Bitwise
    5. ^ | &
6. Assignment operators
    6.  = += -= *= /= %= 

```
Int a =2, b=5;

println(a + b);

int i = 5; //shortcut for System.out is

		//<span style="text-decoration:underline;">Sysout</span> <span style="text-decoration:underline;">ctrl</span>+space

		System.**_out_**.println(i);

Int a= 2, b = 3, c = 4

Bool c = (a &lt; b && a &lt; c);
```


### Instance of

String str = “Hello”;

Boolean b = str instanceof String; //checks if our variable is a certain data type we check for


### Ternary if

Int a = (b > c) ? 10 : 20;

Set a = to 10 if true or 20 if false


## Scanner class

Import java.util.Scanner;

We need to create objects from these classes to use whatever they offer to us what we want.

```
Scanner input = new Scanner(System.in);

Int n =input.nextint(): 

… use n however you would like

.next_(data type)

.nextint()

.nextdouble()

.next boolean()

.next() (only scans up to the space)

.nextln() (scans in the whole line)
```


## C++

```
#include&lt;iosstream>
Using namespace std;

Int main()
{

	Cout &lt;< “Hello World”;

	Return 0;

}
```


## Math class

* Min 
* Max
* Absolute value
* Power
* Square root

We call it like this
```
Math.abs(a); &lt;- absolute value
Math.min(b, c);
.max
.sqrt
R = a/(Math.pow(c, 20)) + x*y
```


## If statements (Same as C)

```
If ( a > b )
{
	//Do something will ya
}
Else if ( a &lt; b )
{
	// do somethin elseeee 
}
Else
{
	// default do somethin or somethin
}
```


## Switch statements

Old switch

```
Int a = 2;
switch (a)
        {
            case 1:
               println(“You entered a 1”);
                Break;
		case 2:
               println(“You entered a 2”);
                break;
		case 3:
               println(“You entered a 3”);
                break;
            Default:
		   println(“unknown”);
                break;
        }
```

New switch
```
int a = 2
        switch(a)
        {
            case 1,2,3 -> System.out.println("1, 2 or 3");
            case 4, 5 -> System.out.println("4 or 5");
            case 6 -> System.out.println("6");
            default -> System.out.println("unknown");
        }
```


```
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
```


#### Creating a factorial loop

F = 5!

5 * 4 * 3 * 2 * 1

Using a for loop

Int f = 1, i, n;

Input -> n

//increments

For ( i = 1; i &lt; n, i++)
{
	F = f * i;
}

//decrements
For ( i = n; i >= 1; i--)
{
	F= f*i;
}
