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

Structures 

Struct Student

{

	Int ID,

	String Name,

	String Address,

}

Student S1;

S1.ID = 1001;



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

Class Student

{

	Private int ID; //this cannot be accessed through main

	Public String Name, Add; // can be accessed anywhere easily

}

Student S;


## Java 

JVM

Java virtual machine



* JVM is an interpreter of Java Byte code

JRE



* Java Runtime Enviornment
* Basically it executes the code, not your actual system
    * Doing it this way makes java universal to run anywhere if JRE is on a system

JDK



* Java Development Kit
    * Pretty much where all the libraries are
    * JVM most likely pulls from here to link the libraries in your classes that you imported
* **In Java, binary starts with 0b, octal starts with 0, and hexadecimal starts with 0x. **
    * **When of course declaring an int**
    * **I.e. int Binary = 0b1001;**


## Data types

Primitive



* Int ( 4 bytes)
    * Byte (1 byte) 
    * Long (8 bytes) a = 1_000_000_000
    * Short (2 bytes)
* Double 
    * Float (requires an F at the end)
* Char
* Boolean

NonPrimative



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

Int a =2, b=5;

println(a + b);

int i = 5; //shortcut for System.out is

		//<span style="text-decoration:underline;">Sysout</span> <span style="text-decoration:underline;">ctrl</span>+space

		System.**_out_**.println(i);

Int a= 2, b = 3, c = 4

Bool c = (a &lt; b && a &lt; c);


### Instance of

String str = “Hello”;

Boolean b = str instanceof String; //checks if our variable is a certain data type we check for


### Ternary if

Int a = (b > c) ? 10 : 20;

Set a = to 10 if true or 20 if false


## Scanner class

Import java.util.Scanner;

We need to create objects from these classes to use whatever they offer to us what we want.

Scanner input = new Scanner(System.in);

Int n =input.nextint(): 

… use n however you would like

.next_(data type)

.nextint()

.nextdouble()

.next boolean()

.next() (only scans up to the space)

.nextln() (scans in the whole line)


## C++

#include&lt;iosstream>

Using namespace std;

Int main()

{

	Cout &lt;< “Hello World”;

	

	Return 0;

}


## Math class



* Min 
* Max
* Absolute value
* Power
* Square root

We call it like this

Math.abs(a); &lt;- absolute value

Math.min(b, c);

.max

.sqrt

R = a/(Math.pow(c, 20)) + x*y


## If statements (Same as C)

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


## Switch statements

Old switch

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

New switch

int a = 2

        switch(a)

        {

            case 1,2,3 -> System.out.println("1, 2 or 3");

            case 4, 5 -> System.out.println("4 or 5");

            case 6 -> System.out.println("6");

            default -> System.out.println("unknown");

        }


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



## Repetition Structures


## Conditional loops (plural)


### For loop


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


### While 

I = n;

While ( i &lt;= n )

{

	f= f * i;

	I++;

}


### Do while

i = 1;

Do

{

	F = f*i;

	i++

} 

While ( i &lt;= n );


### Math problem using loops


#### Sequential sum

Y = (n)SeSum( i=1)  (i+2) + 3n! + x

Unknowns ask users to input data

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


#### Sequential product

//symbol looks like a box

T = 3  (n+2)SeProduct(i = 2) i != 5 //skip 5// (3i+2a) - min(a,b)

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


#### Another problem

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


## Break and Continue & labeled?

What does continue do?



* It will just skip the rest of the code underneath and i will increment

For ( i = 1; i  &lt;= 10; i++)

{

	If ( i == 5)

	{

		continue;

	}

	println(i);

}

Break



* Instead of skipping the loop and continues looping
* It instead breaks out of the loop
* Only breaks the closest loop to itself

For ( i = 1; i  &lt;= 10; i++)

{

	If ( i == 5)

	{

		break;

	}

	println(i);

}

Labled



* Creates a label for our loops, when using a break statement we can refer to the label on where we do want to break
* Can also do this with continue too

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


## Nested loops

for(i=0; i&lt; S, i++)

{

	for(j =0; j &lt; 5; j++)

	{

		println(i + “ “ + j);

	}

}

Can be useful to display arrays

Or making wacky patterns on the screen

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


### Programming examples

Being told that while loops are for sentinel values, while the other professor would give us 0’s for sentinel values.


### Sum product and factorial

Y = e (n)sum(i=1) **(a!** + 3i)

The factorial parts are not the same, the a factorial is static, but the i factorial…is not.

Sequential Sum with static factorial

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

Sequential product with dynamic factorial

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



## Group project ideas

Connect 4


## Strings



* Can be changed
    * Mutable
* String class

S1 = “Hello” 

S1 = s1 + “ There” // turns into “Hello There”



* Different ways to declare strings

**char array[] = {‘h’, ‘e’, ‘l’, ‘l’, ‘o’};**

println(array) //prints hello

<span style="text-decoration:underline;">String s = new string(array)</span>; //created a new object of class string naming it s

**String s1= “Hello”;**

**String s2 = “There**

**Literal  <span style="text-decoration:underline;">Creating object</span>**


### Heap Memory



* Inside theres a string pool, or constant pool.
* When we declare that s1 = “Welcome” 
    * We then search in the heap, inside the heap pool, then we will have a pointer to that string, instead of making a new one
    * Same thing when we make another s2 = “Welcome”
        * Strings are just null terminated character arrays
* String s3 = new String (“Welcome”) 
    * Wont make a point to the welcome inside of heap memory’s string pool
    * It makes its own object area inside the heap
* When creating string objects you cant use == to check their equality
    * You must use a method println(S3.equal(S4)) //will return true or false
* With the normal points to welcome in string pool you can compare (s1 == s2)
    * S1 and s2 are string literals, not an object

But why would you make an object string?



* Java is memory efficient by not repeating itself


```
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
```



### Variable vs objects



* In Java**, no variable can ever hold an object.** A variable can **only hold a reference to an object**.
    * Int a = 5;
*  You should think of objects as floating around independently in the computer's memory. In fact, there is a** special portion of memory called the heap where objects live.**


### Difference between primitive data types and strings



* Strings are objects!

All primitive data types have veraupper class??

Strings s = “2013”;

println(s); // 2017

println(s + 4); //20134


## Parsing strings



* Into usable data that the programmers want

Strings s = “2013”;



* println(s); // 2017
* println(s + 4); //20134

Int a = S.parseInt(); //in theory should convert the string to an integer 



* //what a heaven sent method S.parseInt();
* println(a); //2013
* println(a+3); //2016


## Wrapper classes

Types of wrapper classes

**Integer**

**Long**

**Short**

**Float**

**Double **

**Boolean**

Int a = 30; //lets create an object of this

Integer b = a; //creates an WRAPPER class object class of integer



* This process is known as **Auto Boxing**

Integer c = 30;

Int d = c; 



* Going from wrapper class to primitive is **Unboxing**

double d = Double.parseDouble(“27.3”);


```
//write a java program tha tconverts an integer to its corresponding integer wrapper class and vice versa.

        int value = 42;
        Integer wrapperValue = Integer.valueOf(value);

        int valueAgain = wrapperValue.intValue();

        System.out.println("Original int: " + value);
        System.out.println("Wrapper to int: " + valueAgain);
```



## Tokens

“2014, Java program, 22” 

**How do we parse this, we cant do parseDatatype();?**



* We can parse each of these as a token, but we need to know how they’re separated within our string
    * Like for example, our delimiter is a comma
* Other examples are
    * “33!JAVVA.C++_WORLD”
        * We can have multiple delimiters
        * We can tell it extract after finding 1 !, 1 ., and 1 _

Scanner sc = new Scanner(System.in) //can be any user input or a user file

Lets see how scanner can parse

Scanner sc;

String s = “Hello There. How are you.”;

sc = new Scanner(s, “ ,”);

while( sc.hasNext() ) //hasMoreTokens

{

	println( sc.Next() ); //nextTokens

}

String tokenizer is similar, but for the while loop is hasmoretokens and nexttoek


## Methods of parsing


```
// Scanner sc;
        // String s = ("I love you so much. I want to hug you");
        // sc = new Scanner(s);

        // while( sc.hasNext() ) //hasMoreTokens
        // {
        //     String token = sc.next();
        //     System.out.println( token ); //nextTokens
        // }

        // Scanner sc1;
        // String ss = ("I love you so much. I want to hug you");
        // sc1 = new Scanner(ss);

        // sc1.useDelimiter("[] .]"); //+

        // while( sc1.hasNext() ) //hasMoreTokens
        // {
        //     String token = sc1.next();
        //     System.out.println( token ); //nextTokens
        // }

        // Scanner sc2;
        // String s4 = ("I love you 4 much. I 34 want 22 to hug you");
        // sc2 = new Scanner(s4);


        // sc2.useDelimiter("[\\+d]"); //+
        // while( sc2.hasNext() ) //hasMoreTokens
        // {
        //     String token = sc2.next();
        //     System.out.println( token ); //nextTokens
        // }

        String tokens[];
        String s4 = ("I love you 4 much. I 34 want 22 to hug you");
        tokens = s.split("[\\s\\d]+")


        for (int i = 0; i < tokens.length; i++)
        {
            System.out.println(tokens[i]);
        }
        System.out.println("number of tokens: " + tokens.length);
```



### Preferred way to parse for me


```
Write a program to split a sentence into words, considering both spaces and commas as delimiters

        String str ="Java,Python C++, Swift, Go, Rust, C#, Assembly";

        String words[] = str.split("[, \\s]+"); //+ takes spaces or delimeters in a row and sees them as one

        for (String word: words) 
        {
            System.out.println(word);
        }

        output
        Java
        Python
        C++
        Swift
        Go
        Rust
        C#
        Assembly
```



## Arrays

Different ways to declare arrays in java

Can declare like



* Int arr [];
* Int [] arr[];
* Int[] arr[];

In order to allocate memory for these arrays you need to



* Int [] arr;
* Arr = new int[10]
    * Cant you do this like int [10] arr; ????

Default initialization of arrays is 0 unlike c where it gives you garbage 

Or you can assign it like this

Int arr [/*4*/] = {1, 2, 3, 4, 5}; //this is obviously 5 values starting from 1 but 4 values starting from 0



* Then we can loop through said array to go through each element in the array. And manipulate it that way.


### Array shortcut

For (int a : arr)

	println(a); 



* Shortcut for looping arrays


## 2d arrays

Int arr[] = new int[5] {2 , -3 , 10 ,11 ,22};

Int arr[][] name = new int[][]    {{2, 3, 5, 7} 

			          ,{10, -13},

				{1},

				{22, -2, 10, 0, 10}};

Usually nested for loops to go through each element to do something with it.

I.e. 

For ( i = 0; i &lt; name.length; i++_

	For ( j = 0; j &lt; name.length; j++)

		print(name[i][j]


### Matrix array shortcut



* To use shortcut do For each:

for( int data[] : name)

	for(int num : data)

		println(num)


## Collection Frameworks


### 3 main collections


#### List collection



* Works like an array
    * Ordered list
    * Unordered lists
* **Arraylists **
    * It is a dynamic array, it can be easily resized
        * Takes a lot of memory allocation to add a new element in between arrays
        * Easy to take data from, or read from it
        * Needs to be shifted
        * Doesnts work well in multithreaded environment 


```
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class arraylists
{
    // Java program to Demonstrate main methods for ArrayList

public static void main(String[] args) {

  // Creating list using the ArrayList class
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println("List: " + numbers);




        //get

        int number = numbers.get(2);
        System.out.println("Accessed Element: " + number);
        System.out.println("Accessed Element: " + numbers.get(3));



        //remove
        numbers.remove(1);
        int removedNumber = numbers.remove(2);
       System.out.println("Removed Element: " + removedNumber);
        System.out.println("List: " + numbers);


        //set
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Python");
        languages.add("English");
        languages.add(1,"JavaScript");
        System.out.println("ArrayList: " + languages);

        String element = languages.set(1, "Java");
        System.out.println("Updated ArrayList: " + languages);
        System.out.println("Replaced Element: " + element);


        //addAll
        // create another arraylist
        ArrayList<String> programmingLang = new ArrayList<>();
        programmingLang.addAll(languages);

        System.out.println("Programming Languages: " + programmingLang);


        //contains
        System.out.println("Is Java present in the arraylist: "
            +languages.contains("Java"));

        //size
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        primeNumbers.add(7);
        System.out.println("ArrayList: " + primeNumbers);


        // get the number of elements of arraylist
        int size = primeNumbers.size();
        System.out.println("Length of ArrayList: " + size);


        // Create a new array of String type
        // size of array is same as the ArrayList
        String[] arr = new String[languages.size()];
        languages.toArray(arr);
        System.out.println("Array: ");
        for(String item:arr) {
          System.out.print(item+", ");
        }


        //removeAll
        System.out.println();
        languages.removeAll(languages);
        System.out.println("ArrayList after removeAll(): " + languages);


        //clear
        languages.clear();
        System.out.println("ArrayList after clear(): " + languages);



        //adding user inputs in arraylist
        ArrayList<Integer> values=new ArrayList<>();
        Scanner input = new Scanner(System.in);

    do
      {
      System.out.println("Please enter a value:");
      Integer course_input = input.nextInt();
      if(course_input!=000)
      values.add(course_input);
      else
        break;
      }while(true);
      System.out.println(values);


      //printing using iterator
      System.out.println("\n=== Iterate using an iterator() ===");
          Iterator<Integer> iterator = values.iterator();
          while (iterator.hasNext()) {
              Integer val = iterator.next();
              System.out.println(val);
          }


          //printing using Lambda, similar to method, short block of code which takes in parameters and returns a value.
          System.out.println("\n=== Iterate using Lambda ===");
          values.forEach( (val) -> { System.out.println(val);});

}

}

```



* **Linked lists**
    * Linked lists are double linked lists, pointing to and back.
    * All data is placed within nodes
    * LLH ←prev  nxt→ Node A ← → node B ← → node C ← → null
    * Easy to insert data within linked list, and easy to remove


```
import java.util.LinkedList;

public class LLS
{
    // Java program to Demonstrate main methods for LinkedList

    public static void main(String[] args) {


        LinkedList<String> ll = new LinkedList<>();


        ll.add("UTA");
        ll.add("Students");
        ll.add(1, "For");
        ll.add("are");
        ll.add("super great");
        ll.add(4, "for sure");


        System.out.println(ll);


        //seta
        ll.set(0, "Yea");
        System.out.println("Updated LinkedList " + ll);


        //delete
        ll.remove(1);
        System.out.println("After the Index Removal " + ll);
        ll.remove("Yea");
        System.out.println("After the Object Removal " + ll);


        // Displaying the size of the list
        System.out.println("The size of the linked list is: " + ll.size());


        //delete first
        System.out.println("The removed first element is: " + ll.removeFirst());


        System.out.println("Final LinkedList:" + ll);


        //delete last
        System.out.println("The last element is removed: " + ll.removeLast());
        System.out.println("Final LinkedList:" + ll);


        // Add an element to the beginning of the linked list
        ll.addFirst("lala");


        // Add an element to the end of the linked list
        ll.addLast("yeaa");
        System.out.println("Final LinkedList:" + ll);




        // Fetching the specific element from the list
        System.out.println("The element is: " + ll.get(2));


        // Clone
        LinkedList<String> ll2 = new LinkedList();
        ll2 = (LinkedList) ll.clone();
        System.out.println("Second LinkedList is:" + ll2);


        // Check if the list contains "are"
        System.out.println("Does the List contains 'are': " + ll2.contains("are"));


        // Check if the list contains "yeaa"
        System.out.println("Does the List contains 'me': "  + ll2.contains("yeaa"));


        // Clearing the list
        ll2.clear();
        System.out.println("List after clearing all elements: " + ll2);

    }

}

```



* Stack
    * LIFO
        * Last in first out
    * Like a stack of plates
* **Vector**
    * Similar to arraylists
    * Works well in multi-threaded environment (multiple processes)


```
import java.util.Vector;

public class vector
{
    // Java program to Demonstrate main methods for Vector

    public static void main(String[] args) {


        Vector<Integer> v2 = new Vector<Integer>();


        //add
        v2.add(1);
        v2.add(2);
        v2.add(3);

        // Printing the vector elements to the console
        System.out.println("Vector v2 is " + v2);


        v2.add(2,5);
        System.out.println("Vector v2 is " + v2);    

        // set
        System.out.println("The Object that is replaced is: "
                        +v2.set(3, 50));

        System.out.println("The new Vector is:" + v2);

        //delete
        v2.remove(1);

        // checking vector
        System.out.println("After removal: " + v2);


        // Insert an element 0 at index 1
        v2.insertElementAt(0, 1);
        System.out.println("The new Vector is:" + v2);




        // Remove the element at index
        v2.removeElementAt(2);
        System.out.println("The new Vector is:" + v2);


        // Fetching the specific element from the Vector
        System.out.println("The element is: " + v2.get(2));


    //contains
        System.out.println("Does the Vector contains '21'? "+ v2.contains(21));

    // Clearing the Vector using clear() method
        v2.clear();

        // Displaying the final vector after clearing;
        System.out.println("The final Vector: " + v2);

    }

}

```



* All the lists can have duplicate data


#### Set Interface



* HashSet
* TreeSet
* Set does not allow duplicate data


#### Queue



* Dequeue
* Priority que
* Enqueue? 
* FIFO
    * First in first out
        * Like a movie theater line or just a line


## Midterm 1

ERB 108 && 109

7pm

Scanner 1st question

INPUT OUTPUT 

IF ELSE

CONDITIONALS

LOOPS

MATH PROBLEMS

Y = 3X + E(N-1) (I=1) (2I + A)

DECLARE A VALUE TO STORE CALCUATIONS

S = S + ( 2 * i + a)

For (i = 1; i &lt;= n-1; i++)

{

	calculations

}

SUM PRODUCT AND FACTORIAL

Factorials

(2n+a)!

R = 2n+a

F = 1;

For ( i=; i &lt; r; i ++)

	F = f * i ????

Second question

Matrix [][]

Want user to add unknown values

Know how to copy one matrix to another

How to access elements of matrix

Access third column of the matrix

Understand how to manipulate the matrix

i/j

**[00]**[01][02]

[10]**[11**][12]

[20][21**][22]**

**If ( i == j)**

	Do something

Above

If ( i > j)

	

Below

If ( i &lt; j)

Opposite diagonal

If( i + j = 2)

	Do something else

3rd question 

How many times a user enters a thing and then do something with whatever that thing was

4th question

STRINGS

Split, str tok

Need to know How to use the methods, not memorize

Dont need to import libraries

5th question

Either linked list or array lists

Add values to fill either lists

Or user values

And do something with the values


## Exception handling

Try 

{


    String S = “UTA”;


    Int a = Integer.parseInt(“S”);

}

catch (Exception e) 

{

	//.println(“Cannot parse string to integer”);

	.println(e.getMessage()); //prints the kind of error and where it occurs

	//or

	.println(e.toString()); //writes the kind of exception w/out line where it occurs

	.println(e.printStackTrace()); //gives more detail

}

Use: throw Exception

There are two

Exceptions and error (we arent interested in errors)

Keywords

Try

Catch

Finally

Throw

Throws 

getMessage()

toSt

Try

{

	//code here

}

catch(ArithmeticExecption ae)

{

	→ do somethin

}

catch(NullPointerException npe)

{

	→ do somethin else

}

a=3

b=4

A | B

catch(ArithmeticException | NullPointerException …)

{

	→ do somethin 

}

Finally

{

	.println(“This will be executed always”);

}

Need to know try catch and finally

L1

L2

L3

SMALL STUPID MISTAKE → int A = integer.parseInt(“1ab”);

Putting try catch around this will stop the program from crashing !


```
import java.util.Scanner;

public class tryCatchFinally
{
    public static void main(String [] args)
    {
        try
        {
            int a = 30, b = 0;
            int c = a/b;
            System.out.println("Result = " + c);
        }
        catch (ArithmeticException e)
        {
            System.out.println("An Arithmetic Exception has occurred: "+ e);
            // System.out.println("An Arithmetic Exception has occurred: "+ e.toString());
            // e.printStackTrace();
        }
        finally //finally dont care
        {
            System.out.println("Finally block...");
        }

        System.out.println("Next statements...");

        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");


        //null pointer

        try
        {
            String a = null;
            System.out.println(a.charAt(0));
        }
        catch(NullPointerException | ArithmeticException e)
        {
            System.out.println("Null pointer exception");
        }
        // catch(NullPointerException e)
        // {
        //     System.out.println("Null pointer Exception");
        // }
        // catch(ArithmeticException ae)
        // {
        //     System.out.println("Arithmetic Exception");
        // }
        finally //finally dont care
        {
            System.out.println("Finally block...");
        }


        System.out.println("Next statements...");

        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");


        try
        {
            String a = "This is like chipping ";
            char c = a.charAt(24);
            System.out.println(c);
        }
        catch (StringIndexOutOfBoundsException ie)
        {
            System.out.println("String Intdex Out of Bounds");
        }

        finally //finally dont care
        {
            System.out.println("Finally block...");
        }


        System.out.println("Next statements...");




        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");


        try
        {
            // "akki" is not a number
            int num = Integer.parseInt("akki123");
            System.out.println(num);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Number format exception");
        }

        finally //finally dont care
        {
            System.out.println("Finally block...");
        }


        System.out.println("Next statements...");




        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");




        // int[] arr = new int[4];
        // try
        // {
        //     int i = arr[4];


        //     //this statement will never exvute as exception is raised by above statement (without catch our whole program crashes)
        //     System.out.println("inside try block");
        // }
        // catch (ArrayIndexOutOfBoundsException ai)
        // {
        //     ai.printStackTrace();
        // }
        // finally
        // {
        //     System.out.println("Finally block exceuted");
        // }


        System.out.println("Next statements...");




        System.out.println("\n/***********************************/");
        System.out.println("/***********************************/");
        System.out.println("/***********************************/\n");




        Scanner scan = new Scanner("Hello UTA!");

        System.out.println("" + scan.nextLine());

        //check if there is an IO exception
        System.out.println("Exception output: " + scan.ioException());

        scan.close();


        System.out.println("Next statements...");







    }
}
```



## File handling code


```
import java.io.BufferedReader;
import java.io.BufferedWriter;
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




    }
}
```



## Public static void main

Keyword on data access



* Public
    * Can be accessed anywhere (even other classes)
* Private
    * Can only be accessed in whatever method its in
* Protect
    * Only works with inheritance with methods, still is private but public deeper inside the program

Keyword on variables activity



* Static
* Non-static

Everything we can create classes as objects


### Creating our own classes

Splitting up 1 program into different files

Classes look like this

They have 3 parts each

Class name

-----------------

Data		States + instance variables

-----------------

Methods 	(functions/subroutines)

-----------------

Book

-----------------

Data		States + instance variables

ID

Static count 

-----------------

Static updateBook()	(functions/subroutines)

-----------------

Book B = <span style="text-decoration:underline;">new Book(); </span>//is a constructor, allows us to create instances from a class

Book C = new Book();

B.updateBook();

C.updateBook();

//both B and C objects share the book class, including their methods, but they contain their own data separately, 



* static shares methods of the class, not of the objects


## Building user defined classes

Each class has 3 parts

//everything can be treated like objects in programming

First is class name: i.e. car dealership db

Second is data and attributes: 

String Make

String Model

Int year

//class can contain as much data & attributes as needed

Third part is reserved for methods: //what we do with data

addNewCar()

deleteCar()

printCar()

Going to create separate classes to separate things

The access modifiers and static non-static modifiers

Will use access modifiers

Public

Private

Protected

Default //declaring a method that is like void and prints 



* If you make main method private then we cannot even run the program, because its locked off from java running or compiling it

Class car

{

	Public string make

	Public string model;

	private int year; //getters and setters are written in the class where a var is private

	public int getYear()//getters always have same data type as var used


    {return year;}	


    public void setYear(int year) //data type for setters are always void


    { this.year =year;} //this keyword is important in java for set funcs 


                      //this keyword only looks for var being entered for the specific obj

	Public void printCarDetails()

	{

		println( “Make: “ + make + “\nModel: “ + model + “\nYear: “ + year);

	}

	~~~~~ code ~~~~~

}

Class Test

{

	car c = new car(); //doing this initializes space for our new object, the class of car was a data structure but contained 0 data.

	c.make = “Lexus”; //can also initialize directly 

	c.model = “ES-300H”;

	//c.year = 2022; wont work because its private

	//because year is private we cant directly access through obj, we need 2 methods to access them, we need getters and setters 

	c.setYear(2022);

	.println(make: “+ c.make); //public var

	.println(“model: “+ c.model); //public var

	.println(“year: “ + c.getYear()); //access private var through get method

	car d - new car(); //making new obj for this specific car

	~~~~~

}

	

Inside our obj visual

C obj

|Lexus|

|ES-300H|

|2022|


## Creating and arrays arraylist, linked-lists of objects

Class Student

{

	Private String name;

	Private int gpa;

	Public String getName()

	{return name;}

	

	Public int getGPA()

	{return gpa;}

	Public void setStudent(String name, int gpa)

	{

		This.name = name;

		This.gpa = gpa

	}

	Public void print()

	{

		.println(“name: “ + name + “\nGPA: “ + gpa);

	}

}

Class Test

{

	Main

	{

		//Student S = new Student();

		// we dont just 1 student, but we need n amt of students

		// we need to create an array of these objects

		Student [] s = new Student[10]; //if we want 10 students

		//first we create the array, now in each of those fields of array we store data for each student

		Scanner sc = new Scanner(System.in);

		For (int i = 0; i &lt; S.size(); i++)

		{

			.print(“Enter name & gpa of student” + i++);

			String n = sc.next();

			Int g = sc.nextInt();

			//now we have data, next we need to construct our obj in the array

			S[i] = new Student(); //call constructor

			S[i].setStudent(n, g); //store what the user imputed for student i

		}

		//then to print each student

		For ( int i = 0; i &lt; s.size(); i++)

			s[i].print();

	}

}

Can create constants like this → Final int MAX = 10;

//Creating the same thing but with a real constructor

Class Student

{

	Public student(String name, int gpa)

	{

		This.name =name;

		This.gpa = gpa;

	}

//or

	Public student()

	{

		this(“null”, 0); //can still use this to pass in params, but by default will set these vals

	}

Class Test

			S[i] = new Student(n, g); //call constructor w/ vals

			// can still have setStudents func. To edit specific students for later
