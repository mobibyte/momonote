

## Strings

* Can be changed
    * Mutable
* String class

S1 = “Hello” 

S1 = s1 + “ There” // turns into “Hello There”



* Different ways to declare strings
```
**char array[] = {‘h’, ‘e’, ‘l’, ‘l’, ‘o’};**
println(array) //prints hello
<span style="text-decoration:underline;">String s = new string(array)</span>; //created a new object of class string naming it s

**String s1= “Hello”;**

**String s2 = “There**

**Literal  <span style="text-decoration:underline;">Creating object</span>**
```




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

* **Integer**
* **Long**
* **Short**
* **Float**
* **Double**
* **Boolean**

```
Int a = 30; //lets create an object of this
Integer b = a; //creates an WRAPPER class object class of integer
```



* This process is known as **Auto Boxing**

```
Integer c = 30;
Int d = c; 
```

* Going from wrapper class to primitive is **Unboxing**

```
double d = Double.parseDouble(“27.3”);
```


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

```
Scanner sc;
String s = “Hello There. How are you.”;
sc = new Scanner(s, “ ,”);
while( sc.hasNext() ) //hasMoreTokens
{
	println( sc.Next() ); //nextTokens
}
```

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

```
Int arr[] = new int[5] {2 , -3 , 10 ,11 ,22};
Int arr[][] name = new int[][]    {{2, 3, 5, 7} 
			                    ,{10, -13},
                                {1},
                                {22, -2, 10, 0, 10}};
```

Usually nested for loops to go through each element to do something with it.

I.e. 

```
For ( i = 0; i &lt; name.length; i++_
	For ( j = 0; j &lt; name.length; j++)
		print(name[i][j]
```


### Matrix array shortcut



* To use shortcut do For each:

```
for( int data[] : name)
	for(int num : data)
		println(num)
```