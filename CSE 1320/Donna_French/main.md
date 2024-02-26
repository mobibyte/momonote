Code formatting

10% of coding assignment grade

And on any quiz, 10% on that question on that quiz

 

Donna French Formatting

Based on indention and alignment



* Code blocks should be indented at least 3 spaces and not more than 5 spaces
* If tabs are used, always use tabs and set tab size to be 3-5 spaces
* If spaces are used, always use spaces and always use the same number of them
* (so basically use spaces)
* Curly braces should align vertically and be on their own line
    * Int main()
    * **{**
    * **}**
* Code formatting can make it readable, can see nested structures easily
* Less reliance on editor to match up braces and code blocks
* Makes easy grading

 

OLQ1

This one can only be taken multiple times

OLQ2 -> 13 

Are only final submission

 

Need to use preformatted font when writing code in canvas for quizzes -5pts for not doing so

 

Tools needed for this class:

Whatever u want

Virtual machine works 

Visual studio code is what the class is using (can install ubuntu’s terminal in vs code)

Slide show soon to come

 

Windows was based on dos

 

Ubuntu mr popular

 


## UNIX 

ls -> list

ls -a  -> lists hidden files, have a . in front ex. .vscode

ls -l -> command lists more information about the files, The long description

Touch - makes a new empty file

mkdir -> command is used to make sub directories in home directory

cd -> change directory, also returns to home dir 

cd .. -> takes you back a folder

cd . -> does **<span style="text-decoration:underline;">nothing</span>**

cd -  -> undos the previous cd

pwd -> print working directory, tells you where you are, your file path

cp -> copies files

mv -> renames file, or moves it to a new name

rm -> removes a file, deletes it

rmdir -> deletes an empty folder

cat _filename_ -> entire files to the screen at once

more _filename_ -> displays page by page

clear -> clears screen 

apropos _a word_ -> displays any command that references 

man -> manual 

grep -> searches a file for a particular pattern of characters

           	Lots of options, but basic grep is what we need to know

diff -> displays differences in files, compares line by line, if 2 files are identical, it shows nothin

 

Tips & shortcuts

history -> shows every command you have typed, can redo any of commands

TAB completion 

Up arrow -> shows history aswell, for previous command

 

(uta ourcs)

Language level

 


#### Computer languages can be 



* High level - 
    * easier for human to write, takes more for the compilers to take to machine code C++, java, easier to port between systems too
* Intermediate level
    * C is inbetween, intermediate to high level language because it allows programmers to have some control over the hardware. Assembly code can be written into a C program.
* Low level - 
    * harder for human to write, more work for us, takes less for compilers to make machine code, Assembly language - used to write operating systems

 

Character set



* ASCII
    * Capped letter grouped together and small letters are too
    * Used on all pc’s
    * Each character has an int value between 0 and 127
    * The ASCII values are used when determining the order of strings
    * Need to memorize 
        * A = 65
        * a = 97
        * 0 = 48
        * space = 32
        * 97 - 65 = 32
        * a - A = ( )
*  
* Extended binary coded decimal interchange code EBCDIC
    * Used on IBM mainframes
    * Letters grouped 9 at a time
    * Stems from punch card origins and is quite difficult for programmers to deal with

Unicode is a expansion of ASCII

 

Format of C programs

(python and cobol are not free format)



* C is a free-format language
    * No requirements that code begin in a colum
    * Doesnt need multiple lines
    * Doesnt care about white spaces

 


### Libraries in C



* A library in C is a collection of functions and definitions without a main() function
* C contains many standard libraries
    * Stdio.h
    * Math.h
    * String.h
* Can put #include anywhere, but C processes top down

 


#### Escape characters



* \n -> new line
* \t -> tab character
* \b -> backspace (doesn’t destroy what you’re backspacing over) 
    * Manipulates cursor
* \” -> prints “
* \\ -> prints \
* \0 -> null 
* \007 -> audible bell
    * Need to use octal value of ascii to print
* ! -> can repeat commands that you last used

 

Unary



* ++M

Binary



* 4+3

Ternary



* ?: 

 

Int divisions dont give remainders

If u do float divisions then ya do

 

To get the remainder just use mod %

 

++ -- 

 

Arithmetic operators

 

High precedence 



* Unary operators ++,--
* Multiplicative operators
* Additive operators
* Assignment operators

 

Low precedence



* Within each group the operations associate from left ot right.

 

() = your best friend for this shit

 


#### Structure programming in C



* How you _“should”_ write your code
* Write source code that is 
    * Modular
    * Easily modifiable
    * Robust (handles errors gracefully)
    * Readable
* Write functions that can be used with little or no modification in many programs
* Write functions to do one task that is not too long and can be understood easily

 

#include &lt;stdio.h> is preprocesser instructures

# is a preprocessor directive

 


#### Preprocessor



* Executes before program is compiled
* Inclusion of other files
* Start with #
* Preprocessor combines it with your program
* -E only run preprocessor, not the compiler
* Two forms of includes
* &lt;> 
    * Look in system files
* “”
    * Look in personal files
* #include
    * Go get my file and mash it together
* #define
    * Creates symbolic constants, once you set it, you cant change it
    * #define identifier replacement-text
    * #define row 4
    * No = sign
    * Adds readability
    * Easy to modify
    * UPPER CASE
    * Makes ur life easier


#### Expression vs statements



* Expressions
    * Sequences of tokens that can be evaluated to a numerical quantity
    * Can be number
    * Variable can be any operator in c
    * Arguments to functions
    * Somethin u can print or assign to variable
* Statements
    * May not have values
    * Purpose might be to select which statements
    * Cause sequences to happen
    * if for while 

 


#### Lvalue vs rvalue expressions



* Lvalue
    * Left value
    * Location in memory such as a name of variable
    * Variables here only
* Rvalue
    * Something that can be evaluated
    * On right side
    * Variables and single numbers or operations
    * Fully evaluated then assigned to Lvalue

Block statement



* A set of statements contained in braces {}
* Dont declare variables in blocks
* Curly braces are like a prison for variables


#### Rules of variables



* Must be declared
* Must be assigned a type
* Compiler reserves spaces in memory - amount depends on type
* Scalar types
    * Enumerated
    * Pointer
    * Arithmetic
* Aggregate types
* Function types
* Union types
* Void type
    * Doesnt return value

 

Int



* Scalar type
* Usually equivalent to a word
* Handled more efficiently han other types in c
* Issues
    * The size of a word varies with different hardware
        * 16bits on one computers and 32 bits on another
    * Creates portability problem
    * Largest value can vary
* Int types
    * Short int: referred as short
    * Long int: called long
    * Different sizing
* Converion specifications
    * %ld longs
    * %hd short

 


## sizeof() vs strlen()

sizeof()-1 vs sizeof(__ . -1)



* Gives you number of bytes associated with a specified type or variable
    * Type name
    * Variable
    * Expression
* sizeof(variable-1) does nothin
    * Need to have it like sizeof(variable)-1


## Overflow



* When an arithmetic operation attempts to create a numeric value that is outside of the range that cna be represented with a given number of bits we get
* Doesnt go anywhere but changes your valuable 

 


#### Unsigned types



* Unsigned type gives you the whole space for positive values
* Normal types are called signed types which have negative and positive values limited to their byte size
    * Doesnt change the size of the type
* %hu unsigned short in decimal
* %u unsigned int in decimal
* %lu unsigned long in decimal

 

Limits.h 



* Defines in min and in max
* Uint max is doubled then the normal max for a signed

 

Printf()- field width specifier



* Optional
* A decimal integer constant (no negatives)
* Outputs the right justfies and blanks will be used to pad on the left
* Basically css shit in c

 

Floating point types



* Float - single precision
* Double - double precision
* Long double - extra precision
    * Put L at thend of what it is = to
* Float.h has limits of floating point
    * You can use float.h for max of float, double and long double
* Using operators with floating points
    *  Floating point + floating point = floating point
    * With a relational operator the result will be equal to an Floating point >= floating point = int (true false)
    * Float && float = int (true false)

Printf () - precision specification



* Optional
* .5 tells how many numbers to print after the decimal
* Default is .6 without precision
* %f.2 ~ 1.21
    * %e gives you scientific notation

 

Translation of floats into binary is not perfect 



* Floats do not have precise storage in computers

 

Decimal vs hexadecimal vs octal


#### Bit byte vs word

 



* Binary digit - bit
    * Holds 0 or 1 on or off true or false
* Byte is 8 bits in 1
* Word  could be one or more bytes

 

Types of Expression



*   Every expression has an associated type
    * 3+4 = 7, we know they’re ints

        `o`   3 + 4.1 = 7.1


            §  3 is an int, and 4.1 is a float


        `o`   3 &lt; 4 = 1 true


·        Unary operation


        `o`   ++cat

·        Binary


        `o`   Cat + dog

·        In a binary operation, both operands are converted to the dominating type


        `o`   Result is dominating type

·        Automatic typecasting, converts types based on dominance


     


    Forced type conversion


    Type casts

·        The type of an expression can be temporarily changed with a type cast

·        Can be constructed with any off the basic types in C

·        No restrictions on the use of type casts


        `o`   Data may be lost in this process.

 

 

Memory buffer and C executable file

·        Stdin


        `o`   Memory buffer


        `o`   When scanf is runned, it looks inside stdin


        `o`   Enter key is \n

·        C executable


        `o`   Pulls in and checks stdin


        `o`   Puts out variables to stdout

·        Stdout


        `o`   Memory buffer


        `o`   Variables get put here


        `o`   Stdout puts out what needs to be displaye*

 


## Bit operations on the ints

·        Least significant bit


        `o`   The bit in a binary number that is of the lowest numerical value

·        Most significant bit


        `o`   The bit in binary number that is the highest numberical value

·        <span style="text-decoration:underline;">1</span>010110<span style="text-decoration:underline;">0</span>


        `o`   <span style="text-decoration:underline;">1 </span>is most significant


        `o`   <span style="text-decoration:underline;">0 </span>least significant

·        Count right to left, start from 0


### ·        Bitwise negation


        `o`   ~


        `o`   Flip the bits


        `o`   Replaces all the 0 bits by 1 and all of the 1 bits by 0


        `o`   Basically a mirror image of binary


### ·        Bitwise AND


        `o`   & &lt;- one of these


        `o`   && is logical operation


        `o`   Takes binary, stack them on top of the bits and combine them,


        `o`   1 & 1 is 1   ,  1 & 0 is 0,	0 & 1 is 0  ,  0 & 0 is 0


### ·        Bitwise OR


        `o`   |


        `o`   Same thing with logical or but with bits


### ·        Bitwise XOR


        `o`   ^


        `o`   Same logic but with every bit


### Bit masks

·        Is a number that we can & | ^

·        To detect whether or not a certain bit is on or off

·        To turn a bit on or off

·        16 bit numbers to be able to use as flags

·        2^(whatever bit) we wanna know is on or off using &


        `o`   Result is 0 if off


        `o`   Result is 2^(bit) if on ex 64 = 2^6

·        XOR can turn off the bits, and can turn it on


        `o`   0 ^ 1 is = 1   1 ^ 0 = 0


        `o`   Essentially subtracting but for computers


        `o`   Also can turn it on whatever it’s worth, adding

·        Using non powers of 2, results in adding and subtracting

·        Can be used to determine if number odd or even


        `o`   Check the last bit to determine if  odd or even 0 = even, 1 = odd


        `o`   2^0 = 1


### Bitshifting 



* Shifts left &lt;<
    * 00000001
    * 00000010
    * Used for multiplication
* Shifts right >>
    * 10000000
    * 01000000
    * Used for division

 


## Random Number Generator



* Int rand(void)
    * Gives you a pseudo random number in the range of 0 to RAND_MAX
    * RAND_MAX is a constant
* rand() % 50
    * Gives it a specified range
    * 0 - 49 
    * In stdlib.h
* Pseudo random number
    * Pulls from a list of random number
    * Doesnt actually generate random numbers
* srand() 
* srand(time(0))
    * Seed rand, seeds the random number generator to start at a different place in the list
    * We pass time(0) since Epoch into this to seed the generator
        * To start in a different set of random numbers
        * Since it changes every second
    * Need to include stdlib.h 
    * And time.h
    * For this
    * Srand should be at the top of int main, should not be called more than once or be used in a function
* Random number within a range
    * Dont want it hardcoded, use a special formula
    * How to find random number inclusively between 32 and 87
    * Making the mod (end-start) correct size but not in the right spot in number line
        * rand() % (end-start+1) + start;
        * Used to find a number within the range of what u want
            * rand() % (87-32+1) + 32;
* Random numbers are NOT unique
* For coding assignment 3 we need to come up with these numbers to be unique
* How do you get unique numbers
    * Basically set the formula rand() % (end-start+1) + start and fill it up in an array, asking if the number generator generates something unique and then putting that in said array and keep on asking it within a range


## Arrays



* Aggregate type
* Ised to store collections of related data
* Multiple values of the same data type can eb stored with one variable name.
* Ways to initialize array
    * Method 1 the array declaration
        * Comma separated list enclosed in braces
            * Char cat [] = {}
            * NOT reserving space in memory
            * Only can leave it empty if you fille the {braces} 
* Initialization of arrays out of bounds
    * You can overwrite memory
    * Can lead to seg faults
    * Overflow
* Storing and printing arrays
    * Dont need & for printing %s
* Passing arrays
    * Calling functions
        * Do not use the brackets when passing arrays
        * Passing address of the array with its name
        * Not possible to pass acopy of the array as ta parameter
    * function(array)
    * Void function(int array[])
* 

Ron Cross 


# Discret structures professor

Berasch

Theoritical concepts in ____

3312 or 3315 

Not algorithms and data structures

1106

/* 512 loop


```
#include <stdio.h>
#include <stdint.h>

int main()
{
    uint8_t a = 0;
    uint8_t b = 6;
    int a_equal_b, a_less_than_b, a_greater_than_b;

    printf("a\t a == b\t a < b\t a > b\n");
    for (int i = 0; i < 512; i++)
    {
        printf("%u\t %u\t %u\t %u\n", a, a==b, a<b, a>b);
        a++;
    }



    return 0;
}
```


*/

/* 32 loop


```
#include <stdio.h>
#include <stdint.h>

int main()
{
    uint8_t a = 0;
    uint8_t b = 6;
    int a_equal_b, a_less_than_b, a_greater_than_b;

    printf("a\t a == b\t a < b\t a > b\n");
    for (int i = 0; i < 32; i++)
    {
        printf("%u\t %u\t %u\t %u\n", a, a==b, a<b, a>b);
        a = (a+1) % 16;
    }



    return 0;
}
```


*/


### 4 bit adding in binary



* ---- 
* 1111 all bits are on 1111=15
* 1001
* Binary addition
    * Pretty much know this
* If you have a 5th bit when adding in 4 bits you overflow
    * Take away 5th number
    * Same thing in 8 bit world


## Two’s complement



* How do we represent negative numbers in binary
* Several ways
    * Using sign bit
    * One’s complement
    * Two’s complement
* Two’s complement is the most commonly used technique
*  Sign bit
    * Cut the circle in half
    * Positive 5 in binary
    * 0101 = 5
    * If we use the first bit to determine the sign, then negative 5 is
    * 1101 = -5
        * Cant take 5 and -5 to get 0
        * You get 2 
* One’s complement
    * Flips all bits,
    * 5 + -5 = -0
    * Inverting all the bits makes the calculation off by 1
* Two’s complement
    * Get an extra negative number -8
    * 5 + -5 = 0 
    * Just works
    * Works like how our numbers work
    * Everything lines up great
    * “It just works, it just fuckin works”
* How to calculate it
    * Flip the bits
    * Add 1
    * Thats how you get 2’s compliment
    * 0101 
    * 1010 flip
    * 1011 add 1
* Looking at the binary number out of context you cant tell if it’s negative or positive

Functuons



* Type
* Name
* Parameters
* Executable inside
    * Parameters
        * What type they are
        * What order they are in
        * How many there are
    * These 3 things make up function signature
    * + the functions name
* Default type for C is type int
    * Any other type must be explicitly declared
* Type must match expression
    * Return cat ~ cat = float  return type = float
* Void is used for not returning anything
* Functions aren’t required to return a type
* If a function does return a value do we need to catch it
    * Nope

Function prototypes



* Way to introduce them to the compiler, to let them know what they look like
* Take definition, copy past add ;
* In them variable names dont really matter
* What does compiler do with the prototype
    * Do a lot of things but mainly matches things up
    * Plays a little matching game

Ternary operators



* 3 things
* Ternary if
    * If else to a 1 line statement
* Only a simple if else and needs to be same variable

Variable = (condition) ? expr1 : expr2

If (bit1 & 2

{

	bit1 =1;

}

Else

{

	Bit1 = 0;

}

Ternary if

Bit1 = (bit1 % 2) ? 1 : 0;

two -dimensional array



* Split up in row columns [0][0]
* [] rows [] columns
* [6] [4] 6 1diminesional arrays with 4 cells

When passing 1d array dont specify value

First dimension blank when passing 2d array but not the 2nd [][5]

Calling them just the name

Passing parameters to functions

Two basic methods



* Pass by value
    * A copy is made when you pass
* Pass by references
    * Pass it by the addresses storage location
    * Operations are done directly on parameter

In C



* All parameters pased by value
* No ability to pass by reference does not exist 
* Arrays are exceptions by using pointers which simulate it

segmentation faults



* When u do something bad
* When you attempted to access a restricted area of memory, 
* The operating system is not happy about this


### Debugging



* Is a tool to help you locate logic problems
* Also shows the line of code causing segfault
* Printing to screen is not as effective due to buffering
    * Its waste of time with print statements
    * Debug is faster
    * Printing is buffered, when program died, buffer dies
* This is a weapon against logic issues

Why use GDB and not some other debug



* Works on any unix linux system
* Widley available
* Works with RPI
    * Many ides use the same words, but use icons stead of typing
    * Learning them on cml helps you learn debugging in general
* GDB: The GNU Project Debugger
    * When you compile your program you need to run the option to add debugging
        * -g
        * Gdb a.out
        * Quit
        * Most debug commands can be run by their first letter
    * List
        * List 1- will show the first 10 lines of the program
        * List n- will show the 5 lines before n and 4 lines after n 10 lines
        * List x,y - will show lines x through y
        * List function_name - wil show 4 lines before and after start of function
    * Break on main -always 
    * Run - start program
    * Print /t prints int in binary
    * Print /x - print int in hex
    * Ptype - way to see definition of variable
* Step
    * Steps into function
* Next
    * Executes line of code
    * Doesnt go into function but executes it all
* Watch
    * Sets watchpoint for an expression
        * Gdb will break when the expression is written into by the pgram and its values change
* Backtrace - display which functions have been called


## Pointers

Memory and addresses

In upper-level languages give the programmer little or no control over the assignment of memory addresses



* You do get to pick what type of memory
* Control What is stored in memory
    * But not where it’s stored
    * You control what is in your PO box based on what type of mail you get
    * You decide how big it is 
* The & used with scanf refers to the address of the variable
    * Dont use it with arrays because the name of the array is the address of the array
* %p
    * Conversion specifier for printing addresses
    * Forms vary from computer systems
* %x
    * Hex
* %o
    * Octal
* 0x7fff
    * Stack address


#### Pointer



* A variable that can store the address of another variable
* Just holds addresses of other variables, they have no idea whats in the variable
* Pointers indirectly references values
    * Pointers also have their own addresses

        ```
Int intvarA = 8765;
Int *intvarAptr = &intvarA;
```


* Pointers are separate data types
* Every datatype has a pointer type
* Cant mix pointer types and data types
    * Int dog
    * Char *frog = &dog doesnt work
* We can have pointers to pointers, nested pointers
* * makes pointers

Pointer initialization and the null pointer



* Null should be used to indicated that a pointer is not pointin yet

    ```
Int *A=NULL;
```


* Like putting safety on a gun
* Its good to put NULL, because 0 could not work on some systems, this is a good habit

Pointers are variables

Dereferneing a Pointer variable



* Print the addresses of variables
    * Could be useful for debugging
    * Not often a permanent part of program
    * More interested in value pointed to by pointer
    * Value can be changed through pointers
* Dereferencing operator
* * is used to get to the contents of something

    ```
printf("%d", *ptrcat)
```


    * Prints contents of the address of the ptrcat
* Dereferencing can be used on either side of an assignment
    * * is like the key of the PO box
* Unary operators & and * when used with porters have equal precedence with each other
* Expresiosions combining them are evaluated from left ot right
* Unary operators have higher precedence than binary operators
    * IntVar2 *intvarprtr1 + *&intvarptr2
        * *& cancel each other out

Size of pointers



* Holds 8 bytes
* Pointers hold addresses
* Same size as long

Why do pointers need to have a type?



* For the same reason that languages have a type system in the first place, it helps to detect invalid usage of pointers when compiler time comes rather than runtime
* If you pass a ptr to char that points to an int, it wont work!
* Compiler dont like different types


#### Pointer Arithmetic



* Makes it easier why pointers have types
* You can move pointers around by integers for arrays
* Take ptr add 2 to an int array


### Do while

Executes contents of loop at least once



* Expression evaluated after statement
* While (expression); &lt;- need this for DO while


#### Switch



* Expression needs be int 
* Switch (expression)
* Cases below


#### Continue and Break



* While
* For
* Dowhile
* Use inside a loop or switch then fall out of loop

Used to alter flow of control


#### Return



* Used in main to terminate the progam
* Also terminates functions to
* Lets function end too
* Functions in c arent required to return it


#### Exit()



* Takes single parameter of type int
* Terminates the program
* Needs &lt;stdlib.h> 

Not allowed to use exit unless assignments say to

Use return 0; in main, not exit(0) 

\0 at the end of initialization

“ABC” -> char A[4] the real size is ABC\0 just dont put size


#### The name of the array is the address of the first element of the array 


```
Char *PtrArray[] ={"The","quick","fox","jumps",""};
```


Array doesnt hold strings ^

Pointer array is an array of pointers

T is the memory location of the string “the\0” same with q, f and j

The “” is just empty space, it is just a \0

So an arrays use pointers, a pointer array uses an array of pointers


```
Char **PtrPtr = PtrArray;
```


An address to get to another address to get out contents


```
Char *ptrarray[9];
```


	Construct is used in c to represent an array of strings

strlen(cat), counts until theres a \0

C does not put a limit on the number of levels of indirection. “Fun”


### Makefile

Adding in steps so we can link multiple object files

`Gcc -c` (command to ONLY compile)

You get to see object file

`Gcc -g code_name.o -o code_name.e `(names executable

We can run the .e file

What is make



* Unix utility that is designed to start execution of a makefile


#### A Makefile 



* Is a special file, containing shell commands that you create and name.
* People dont do this by hand
* Make looks for the directory you’re in 
* make (looks for file named makefile)
* Coding assignments need separate folders now
    * Make keeps track of the last time files were updated, itl only compile new updated code
* Without makefile this sucks ass
* Makefile works well in one shell but may not in another
    * Makefile contains list of rule, tells make what to do
        * The rules, have to begin in column 1 No indentions
            * Dependcency line
        * Recipe
            * Must be indented with a 	tab not spaces
    * After its been created a make file or a text file
    * Make will stop when it runs into an error

Rule : dependencies

	System commands (recipe)



* All is default rule where it starts
* Dependency
* Recipe
* Makefiles works its way down then back up
    * Executes backwards
* *** missing separator means that you didnt use a tab
* Make cant find makefile.txt, make cant also find makefile.mak
* We neeed to have it as	makefile (no extensions)

    ```
SRC = code.c
OBJ = $(SRC: .c=.o)
EXE = $(SRC:.c=.e)

CFLAGS = -g

All : $(EXE)

$(EXE) : $(OBJ)
```



$() -> signals to do substitutions

We dont need to memorize makefile on a test, but instead understand what it does.

To use multiple c files


```
SRC1 = code_main.c
SRC2 = libarray_code.c
OBJ1 = $(SRC1:.c=.o)
OBJ2 = $(SRC2:.c=.o)
EXE = $(SRC1:.c=.e)
```


With multiple file = multiple sources and objects but only 1 exe file with src1 being main.

Will ask what section is compiler section



* Compiler creates an object file, or a .o
* Linker links files to make 1 .e or executable 


#### Library



* Libraries are not executable
    * Do not contain a main() function
    * Only contain functions and declarations
    * Cannot gcc a library then ./a.out it
        * No more gcc or a.out after we start using make
* Coding assignment 4 your library has 2 files
    * Mylibrary.c
    * And mylibrary.h 
* Stdio.h is a standard library file, there is no executable code in stdio.h the prototype is in the .h the real code is in stdio.c which is linked with the system library
* We need something for our header files to prevent stupid from happening


#### Include guard



* Guards our original file, our personal bouncer
    * Will make our header file idempotent
    * A file being idempotent means it tells the preprocessor to grab whatever header only 1 if its even there 100 times

        ```
#ifndef (if not defined)
#define (define it)
Then put prototype
Somecode();
morefunccode();
#endif (if its included again it goes back to top)
```


* Include guard is for our safety
* Include guard is the bread to our grilled cheese sandwich

Take name of file #ifndef _FUNCPRO_H (always unique this way)

Compiling and Linking

Main program

Filelib.c

FTP.c



* We compile and link with make individual files, because we dont open files that we dont need to open
* Allow multiple people in industry to work on separate files to work at multiple places at once and then compare if it works

Comments are made by # sign 

make -B (causes make to recompile everything)

In C



* All parameters are passed by value (pass a copy of them)
* The ability to pass by reference does not exist

We can simulate it (pass by reference)



* We pass the address of the variable
* Addresses cannot be modified
* Contents of address can be modified
* This can be done in functions
    * If you pass an address to the function
    * We can modify the contents of the variable because we passed its address

Calling it: we print it like<code> cat(<strong>&dog</strong>);</code>

In func: `void cat(int *Bird)`


###  Strings



* No string data type, in other languages they are objects
* C doesn’t have objects
* string.h what is it?
* A string is a sequence of characters from the underlying character set
    * A string in C is terminated by a null character. ‘\0’
    * A string is accessed via a pointer in its first character
    * A string is like an array of characters - both are stored in contiguous memory
    * Arrays do not require a null character
* Strings must have a null character at the end

**<span style="text-decoration:underline;">Strings are a null terminated character array</span>**

String library functions expect strings or Null terminated char arrays


```
Char Cat[]"Put things in memory with a \0"
```


The address is the first element

If you put a \0 in the middle of string it just cuts off your string


```
" please dont cut me \0 off"
Prints: please dont cut me
```


Char cat[10] = {};

Char *Cat;

These things are not interchangeable directly~

If assignment says make an array make a gosh dang array

%s



* Basically just telling printf(%s) will print until it finds the \0

scanf(“%s”, array) 

Dont need & because name of the array is the address of the first element of the array

If you want to print a % sign in string you do %%

Scanf doesnt read through whitespace



* When it sees whitespace it stops
* Scanf adds a null terminator to the array

What happens if array is not large enough to hold input?



* Overflowwwwwwwwwwwwwwwwwwwwwwwwwwwwww

A string can be stored in an array at the type the array is declared


### Variable Strings



* To input a variable length string


#### Fgets (inbuff, n, fp) fp = stdin



* Will not stop at whitespaces
* Everything it reads is a string
* Only returns character
* For strings that have spaces in them
* Puts null terminator at the end
* So always do n-1

Returns a value



* a char* value(the address of inbuff) or NULL

We dont even need it

For now

fgets must get an array to write into

Cant use a pointer for thisss


### gets()



* Takes array, and assume you’re reading from stdin
* gets(inputarray);
* It doesnt, have the second parameter to stop it from reading too much
    * Thats no good
    * Doesnt have overflow control
    * The compiler tells you that gets is dangerous and should not be used lmao


### String library Functions


#### strlen(string)



* Calculates the length of string
    * Parameters, null terminated array
    * Return value: the length of a string not including a null
    * size_t is an unsigned int, or like one (8 bits?) 0 and up, ints positive
* Gets rid of the that pesky \n

    ```
UserString[strlen (UserString) -1] = '\0';
```



Implicit declaration of built in function warning means u need to #include


#### strcpy(buffer, string)



* Copies string into buffer
* Writes over what was there before, not wiping it clean, just writes over the parts that were there
    * Result always ends up in first parameter


#### strcat(buffer, string)



* Glues two things together
* Glues two strings togetheerr
    * Hellow there
    * How are you
* Hellow therehow are you
    * Second string is unharmed
    * First one is glued together with second


#### strncat  (buffer, string, n)



* n lets us tell it how many character to glue together
* strncat (string, string1, 2)
    * This string was
    * This string was gl


#### strcmp(string1, string2) 



* Just compares strings no altering
* It return a 
    * 0 -string identical
    * Positive - first string is > second string
    * negative - first string is &lt; second string
* Compares first char in string, then moves on if they’re diff
* Shorter string will always be less than


#### strncmp(string1, string2, n)



* Like strcmp, but the n is just how many characters its comparing

Requiring use of pointers


#### strchr(string, ch)



* Looks in a string for a given character ch
* If it cant find it gives you NULL
* If it does find it, it gives you the address of it back
    * If you have an odd string like qbcabqc
    * It will only find the first letter of the pointer, like q will only be the first q
        * To get around this you use a while loop with a pointer not = null
        * You would dereference with first occurrence and slam the first occurrence with a -
        * Then ask it to get another strchr after u do that


#### strstr(string1, string2)



* Like strchr but with pointers
* Points back to the first letter of the string)


##### Technique for coding assignment 5

Get pointer to first occurrence

Same while loop as strchr

Find the distance between the 1st string and first occurrence

Then for loop counting up to strlen of userstring 2

Inside for loop, userstring1[distance + i] = ‘X’

First occur = strstr(userstring1, userstring2);


```
    while (FirstOccur != NULL)
    {
        distance=abs(UserString1)-FirstOccur;
        for(i=0;i<strlen(UserString2);i++)
        {
            UserString1[distance+i]='X';
            
        }
        FirstOccur=strstr(UserString1,UserString2);
    }
```



#### strpbrk(string, char_set)



* Like string char, but uh whole set of char’s 
* Same loop with string char
* A more efficient string char

While (firstoccur != NULL)

{

	

}


#### strtok(buffer, delimiters)



* How you take a string, and put them into separate variables or tokenize them
* Delimiters divide up tokens
* We break them up because we want to handle things separately
* Stringtok changes our strings when it sees delimiters, it will replace it with a NULL
* Creates internal static pointer that points to the point after the delimiter it just replaced with NULL 
* Strtok can be told to not start over, pick up where it left off
    * Using NULL instead of the array name invokes the pointer to the spot after NULL
* If you dont use NULL
    * It just startsss over at the beginning

You can use char *Delmiters = “{}”;

Char *Token = NULL;


### Is functions

Only works for single character

islower(ch) is lowercase

isupper(ch)

Isalpha(ch)

isalnum(ch)

Checks for things on single char

Can use with if statements to return 1 or 0


#### To func.


##### tolower(ch) returns the lowercase version of ch

toupper(ch) returns the uppercase version of ch

Needs to be passed by reference or be used by passed by value to store a variable to the return of toupper

Ex. x = toupper(chrX);


### Atoi and Atof

Takes string that has a number value and gives back the int or float vers. Of the char number

Char num[5] = {“540”};

printf(“%d”, atoi(num));

Does not work if char array has letters before numbers

Works with letters after


#### memcpy() memcmp()

memcpy()

memcmp()

A lot like strcpy() and strcmp()

Memcpy and cmp do not obey the null

Both take a 3rd parameter, in that you tell it how much to cpy or cmp

Or num. Of characters to copy

memcpy(array2, array1, strlen(array1));

Memcmp is just like strcmp but with the number of bytes for its third parameter

Be careful not to compare garbage to garbage 


#### memset

Voit *memset(void *str, int c, size_t, n)

A way to set all of the elements of the array to a given value

Set

Value

Num of bytes

Char MyTestArray[] = {“ABCDE”};

Memset (myTestArray, “ “, sizeof(MyTestArray) );

Turns it all to blanks in the array

Sizeof will overwrite the null

This will do exactly what you tell it to do.

If sizeof is used 

Do 

Sizeof -1

Or use strlen 

(only with char arrays)

Memset puts that number for ints in every byte 

Since ints are 4 bytes, it set it to every 4 bytes

Use 0 and -1 with memset and int arrays


## Automatic versus static variables


### Storage class



* Storage classes are used to describe the features of a variable or function.


#### 4 things abt storage classes



* Scope (local or global)
* Default initial value
* Lifespan
* Storage location


#### Automatic variables



* Default storage class auto int intvar;
* Created each time they’re created and called then they get destroyed when they go away
    * Functions have overhead, they take extra processing power
    * The variable in functions are local they exist only within the func, 
* When an automatic variable is created without being initialized it is not given an initial value may contain garbage
* Automatic variables created with an initialization, its redone each time its called


#### Scope



* Inside function - local

Default initial value



* Contains garbage

Lifespan



* Created when func is called and destroyed when it exits

Storage location



* stack


#### Static variables

Static int intvar;



* Static variables exits the whole tiem the program is executing
* Mem space is allocated when program starts
* Static variables are given the default value of 0
* If an initializer is used then the variable is initialization once at the beginning of the program

Scope



* Inside function -local

Default initial value



* 0

Lifespan



* Created 1 goes aways 1

Storage location



*  data segment

Being static != being global


#### Register variables

Register int i



* Programmer requests that a variable be placed in a register
    * (the answer could be no)
* Usually indicates taht a variable will be used frequently
    * Improved speed and performance – indices and loop counters are great in register
* No guarantee that the variable will be placed in the register
* Very limited in availability and size
* Illegal to use the address operator & with the name of a register variable


## Global versus local variables


### Local Variables



* It exists only in the CURLY BRACES {}
* {
* }
* Once declared it can be referenced from any point on

    ```
Int main()
{
	Char[] = {"IM A local VARIABLE"};
}
```




### Global Variables

Not inside Curly braces



* Defined from outside of them
* Can be referenced at any point in SC (source code)
* Global variables exist during the full execution of the program

    ```
Char[] = {"im a GLoOBAL variable"};
```



For locals {} are like little gates


#### Caution



* Global variables should be used with discretion
* All functions can access global variables and change their values

The effect of a function changing a variable from outside its scope is called a 

**<span style="text-decoration:underline;">SIDE EFFECT</span>**

You can create a local version of a global variable with the same name


### CRLF vs LF vs CR

CRLF

	How windows interprets a newline

LF

	Unix

CR

	Mac


## Omega


### How to create a remote terminal on Omega



* Setup pulse vpn 
    * Google uta pulse 
* We use ftp client called FileZilla
* Tool for moving FTPing files between your computer and omega (and other things too)

PC



* We need SSH 
    * Download putty (optional) (its a terminal emulator)

PC and Mac



* Use ssh to connect to omega 
    * Ssh [netid@omega.uta.edu](mailto:netid@omega.uta.edu)
    * Then your pass

Leaving idle too long will disconnect automatically

(abt 20 minutes)


## Pointer Arithmetic

This is limited to the bounds of a single array

Pointers may be incremented or decremented

intvarptr ++ pushes it right

intvarptr - - pushes to the left

++ intvarptr 

- -  intvarptr

You can also add or subtract from a pointer

Intvarptr += 2 invarptr -= 5

( you dont have to calculate the number of bytes it does it for you! )

One pointer may be subtracted from another pointer of the same type (gives us distance)

Intvarptr - inintvarvarptrptr;

Amt to increment/decrement is relative to the sizeof() the type of the pointer its pointing to

*intvarptr + i &lt;- does not move the pointer     *(intvarptr + i) &lt;-moves the pointer

Pointer addition 



* Not defined in the language
* Just cant add two pointers theres no meaning to adding 2 addresses 


## Enumerated Types



* Are scalar types in C and are used to declare a set of integer constants in C.
* Creates our own data type basically
* You can declare variables of that data type

    ```
enum boolean
{
	False,true //false = 0 true = 1
};

enum boolean correct

```



Int constants are automatically numbered like an array

Default values start at 0 then add 1 to it every spot

You can overwrite their values like this

Enum colors

{

	Red=3, orange=6, blue=4, indigo

}

Rainbow;



* More than one identifier can be assigned the same value 
* If one isnt defined after, itl just add up to the next one

Main use of enumerations would be case statements

Switch (colornumb)

{

	Case red : printf(“red”);

	Case blue

Only problem is we cannot have repeating numbers in case statements (enum doesnt care, case does)

Variables hold numbers or things

Enums do not, they represent constant ints



* Enum variable is legally supposed to accept only the values defined in it, but compilers arent required to check
* Operations with enums are limited because they’re int constants

What else can you use them (mostly use them for case statements)



* Improves readability

#define vs enum



1. Enum follow scope rules
2. Enum variables are automatically assigned values
3. Enums have a type - #defines do not (enum is an int) (define is search and replace)
4. Debug can display enums

Gcc Test.c -g -Wall (gives you things to fix)

Legal to val in enumerated var that doesnt exist in there


## Introduction to Structures


### Aggregate Types

Aggregate types are designed to hold multiple data values 

	Arrays can hold many data values of the same type

	These are same type /\


### Structures



* Also an aggregate type
* Allows us to hold different types
* We can make arrays of structures

    ```
struct Tshirt
{
   char size[5];
   char color[10];
   char design [100];
   char fittype;
   float price;
   int inventory_level
};

struct Tshirts My_Tshirts, YourTshirts;
```



struct is a keyword in C - declares a structure

Ptype is handy for structs

Ptype tshirt list them out



* Initialization is like arrays
* Good idea to set your struct to ={};

    ```
Struct tshirt mytshirts = {"XS", "DISNEY", 'y', 14.99, 1987};
```



Need to know that “” put a null \0 at the end of the string

Single char single quotes

Dont quote numbers dummy



* Restrictions to structs
    * A member of a structure cannot be a function
    * Structures are not classes
    * A structure may not nest a structure of its own type
    * Cannot initizliaze as you declare in a struct
        * Equivalent to int 5;
        * Proper way is to intialize it all in 1 line of code

Strucute for a box


```
Struct box
{
	int height;
	Int length
	Int depth;
	Float weight;
	Char size[3]; //XS S M L XL
	Char strength[10] // how heavy duty
	Int code; //USPS assigns codes
	Int inventory_level;
};
```


How to use our structures

We have the dot operator 

Variable_name.member_name

MyTshirts.size = char size[5]

MyTshirts.color

MyTshirts.design

MyTshirts.fittype

Term becomes whatever type is in the struct

Dot links it from struct


#### Operators on structures

assignment

YourTshirts = MyTshirts works

Address

&MyTshirts

&YourTshirts

sizeof()

sizeof(MyTshirts);

sizeof(MyTshirts.color);


#### Arrays of structures

Making an array of structs holding each cell of structs 

Struct tshirt Marve;Tshirts[10];

Struct tshirt DisneyTshirts[15];

Every cell is a structure

MarvelTshirts[0].color

MarvelTshirts[5].fittype

MarvelTshirts[6].size

MarvelTshirts[9].inventory

Can intialize array of structs to be null

You can also intizalize the first field

Individual elements in an array can be accessed like arrays

MarvelTshirts[5].color[0] = ‘R’;

MarvelTshirts[5].color[1] = ‘E’;

MarvelTshirts[5].fittype = ‘Y’;


#### Pointers in Structures

Pointers ARE EVERYWHERE

If you pass a struct to a function, it will not be changed unless we actually pass by reference with pointers

Struct tshirt *tshirtptr;

Tshirtptr = &MyTshirts;

Struct tshirt *tshirtarrayptr;

Tshirtarrayptr = &dccomicsTshirts[3]; (only works because its an element of the array) would work without [3]

The () are necessary because the dot selector has precedence over the dereferencing operator *

If you dont use it error: Request for emmber ‘design’ in something not a structure or union

Pointer to a structure is used too often in c they created a shortcut for it

(*struct_pointer).member can be written as struct_pointer->member (arrow operator)

We will use **<span style="text-decoration:underline;">struct_pointer->member</span>**


#### Passing structure to and from functions

When passing you dont put type or brackets if its an array same with structs

catdog(MyTshirts)

Passing it like a variable 

If we want it to change the struct, pass the address/ptr of it to the func

/*pass by reference*/

You dont neeed to make a pointer variable, you can also just put the address of it, but ptrs are cooler

Struct tshirt *tshirtptr = &myTshirts;struct Tshirts *tshirtarrayptr = &DCCommicsTshirts[3];

Int inventory (struct tshirt * x) 


### Unions

Union is like a structure



* It can hold members of different types
* Same rules as structures
* Arrays and pointers to unions allowed
* You can use -> to get to member selection
* Unions different from structures
    * Will only contain one of its members at any instant instead of all members
    * Its a time share, at any given moment only one of them exits
    * Storage is allocated to the largest one

Union tag

{

	Member list

};

Size of unions are the largest member in it

When storing inside of the union all of the members share the same memory space

Its up to the programmer to know which one exists

Share one chunk of memory, all share the same address

Caution



* Theres no automatic mechanism to determine which member of a union is in use at any given time. It is up to the programmer to keep track


### Typedefs

The typedef is a storage class is used to associate an identifier with a type

typedef old_type new_type;

Take a type and give it a new name

Its similar to a #define 

They’re processed by the compiler

Only used to define data types

Defines have more freedom then typedefs

More controlled define

Typedef short MyShort; 

Dressing up variables and giving them a new name;

Myshort x=0; 

Typical use of typedef is to get rid of the struct

Typedef struct

{

   Float radius’

}

CIRCLE;

Union shape

{

   CIRCLE circle;

}

Takes struct out of that

Note abt math library



* abs() absolute value
    * Does not need math.h
    * Abs is in stdlib.h
* If math library is used you need an extra compiler command
* Math library is not part of standard C library
* You have to use -lm to link it in

Link math -lm

M_PI = pi

Compiler optimized the call for calculating radius for circle instead of calling math library to raise something to the power of 2, itl just multiply it by itself.


#### Array notation [] and when to use pointer notation

When you pass an array, recieve it as an array

When you pass a precise element of an array, receive it as a pointer to that array element


### Command line parameters/arguments

Command line parameters are a sequence of strings 

They are a null terminated character array

Appears string after the name of the program

main(int argc, char *argv[])

Argc and argv are traditional names but can be anything

Argc is the number of parameters on the command line

Can never be 0

Always >= 1

Argv are array of pointers ot chars

Pointer point to string that are on command line argos

To run program in debug with cml argos you need to do

Gdb - -args a.out clp1 clp2

Running things in batch

(at night)


## File handling

Storage of data in memory is temporary

Files are used for data persistence and permanent retention of data

Cds dvds flash drives and tapes

C does not impose structure on a file, a file is just a sequence of data



*   the concept of a record in a file does not exit
* Application reading it imposes the structure of whatever you do

Things in files are just sequence of bytes

Will have an EOF (End of file) marker

When you open a file you get a file handler and refer it to it every time you use it

To open a file

Use: FILE *myfile, *yourfile;

FILE is a struct 


### Open and close

Myfile = fopen(“filename”, “mode”);

fopen(“it.txt”, “r”);

How we open files

After opening it, we need to Closseee it

fclose(Filehandle)

fclose(myfile);


### “Mode”

R read

W write

A appends

R+ reads and updates existing file

W+ create a new file for update

A+ 

Lots of modes


### fprintf() fscanf() &lt;- file version of printf and scanf

Reads and writes to files

sprintf() and sscanf()

Read and write from a string!

Printf and scanf families for f and s versions of printf and scanf

Error detection with the printf() and scanf()

printf() returns int val indicating total chars printed

scanf() 

Depending on the criticality of your application adding this level of error checking may not be worth it

fscanf(fp, control_string, args);

fprintf(fo, control_string, args);

Fp file handle

control_String conversion specifier

Can use fscaf to read from keyboard but use it with stdin

Scanf and printf are shortcuts for fscanf and fprintf


### fgets()

fgets(buffer, sizeof(buffer)-1, ReadFH);

Reads 1 line at a time in a file of words

Remember it stops at the &lt;enter> key \n

File pointer - keeps track of where we are in the file

It moves as we do reads and writes


### Two types of access


#### Sequential (VHS)



* Open a file and just read it line by line


#### Random access (DVD)



* Allows the reading of records in any order

Two standard library functions in standard c to do this

fseek(fp, offset, start);

Fp - File handle

Offset (how many bytes do you wanna move)

Start (where are we moving from) must be 0 1 or 2 &lt;- #define for these

ftell(fp);

File handle and tells us where we are

fseek(myFile, 0, 0); &lt;- how we get back to beginning of the file

fseek(Myfile, 21, SEEK_SET);

SEEK_SET is defined as 0

SEEK_CUR = 1

SEEK_END  = 2


### Formatted input and output


### Sscanf() and sprintf()

sprintf(buffer, “%s %s has student id %s”, first_name, last_name, id);

Instead of printing to screen or scanning from screen it puts the stuff into buffer or a char array[];

Takes pieces and ties it together in one string

sscanf(buffer, control_string, args);

This does the opposite from sprintf(); it takes puzzle and rips the pieces out

Its like strtok but not as advanced

It parses but it looks for white spaces works good for phrases

%*s reads it and then throws away what it reads


## Layout of Memory

Higher addresses



* External Data Segment
    * Command line arguments
    * Environment variables

Lower Addresses



* Stack
    * Statically allocated variables

          |

          \/

           /\

	|



* Heap
    * Dynamtically allocated variables
* Uninitialized Data Segment
    * Unitialized global and static variables
* Initialized data segment
    * Initialized global and static variables
* Code Segment
    * Programs source code


#### Differences between Static vs statically allocated

Static



* Is a storage class
* Automatically initialized as zero
* Run for the whole program and dont get reset

Statically allocated 



* Like int cat
* And how we normally do our stuff
* At the time the program compiled we know that this variable is going to take this much memory
* (DOES NOT MEAN STATIC STORAGE CLASS)



<p id="gdcalert1" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image1.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert2">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image1.png "image_tooltip")



### Stack vs heap

Stack



* Stores auto variables
* Nice and neat stack
* Orderly
* Stack is used for static memor allocation like int cat;
    * Manges memory for you
    * Variables cannot be resized
    * Access is easier faster and cache friendly
    * Not flexible, allotted memory cannot be changed
    * Faster access allocation and deallocation

Heap



* Not so nice and stacked up
* Not orderly and can become fragmented
* Used for dynamic memory allocation (ask program on fly to allocate it
    * Memory management needs to be done manually
    * Variables can be resized
    * Causes more cache misses because of being dispersed throughout memory
    * Flexible and allotted memory can be altered
    * Slower access allocation and deallocation (not significant)

Both are stored in computers RAM


### Dynamic Allocation and de-Allocation of memory

Functions for dynamic allocation and deallocation

malloc()

calloc()

Realloc()

free()

Must include stdlib.h


#### malloc()

Void *malloc(size_t size)

One parameter the num of bytes

Returns a void pointer which means it can be put into any pointer type

Memory is allocated is unitialized 



<p id="gdcalert2" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image2.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert3">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image2.png "image_tooltip")


Arrayptr1 = malloc(arraysize*sizeof(int));


#### Calloc()

Void *calloc(size_t n, size_t size);

First parameter

Num of items

Second 

Size of each item

Returns address of the first byte

Malloc doesnt 0 it when freeing it up

Calloc does

Malloc is faster but doesnt zero it


#### Freeee

Void free(void *ptr);

Free should be used when allocated memory is no longer needing in order to avoid memory leaks

A memory leak is caused when a program fails to release discarded memory it caused impaired performance or failure

Free does NOT set your pointer to null

To combat this problem

You should <span style="text-decoration:underline;">Probably set it to **NULL**</span>


#### Realloc

Void *realloc(void *ptr, size_t newsize)

Takes memory you have and makes it BIGGER

Whether or not itl change the pointer depends sorta

Sometimes realloc will move the address sometimes it wont

Its literally the perfect mover no headache except the new memory has trash

Old data is not lost and newly allocated memory is not initialized

If it falls you will get back null and the old memory remains the same

Always adds new stuff to the end of it

How do we move things around?



* A bit harder to do but possible
* Linked lists enable this
* But also make it EASIER


## Linked List

Linked list are a linear data structure consists of groups of nodes in a sequence


### Nodes



* Pieces of a linked list (like array’s cells we say linked lists nodes)
* Nodes are just a struct
* Is going to malloc 
* Contains a pointer within a struct 
* NODES ALWAYS CONTAIN A POINTER
    * Holds the address of the next node
* Each node holds it own data 
    * But always holds the address of the next node like link in a chain
    * Hence linked list



<p id="gdcalert3" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image3.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert4">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image3.png "image_tooltip")


Not necessarily next to each other in memory

(never make assumptions where the nodes are in memory)

Advantages



* Dynamic: therefore only allocate memory when you need to
* Insertions and deletions operations are easily implemented
* Stacks and queues can be easily executed

Disadvantages



* Memory is wanted due to extra storage needed for pointer
* No element can be accessed randomly 
    * Sequentially accessed like VHS tapes



<p id="gdcalert4" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image4.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert5">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image4.png "image_tooltip")




<p id="gdcalert5" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image5.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert6">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image5.png "image_tooltip")




<p id="gdcalert6" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image6.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert7">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image6.png "image_tooltip")


Single linked list



* Only 1 node can see another node
* Thats why it cant be randomly accessed

How to think of linked list in memory

Heads are just the pointer to the first node

Last one always gets pointed to null (its like null terminating a string)

If you want to add a node to a linked list:



* Create a new node malloc it 
* And depending on where we wanna add it its easy to do.
    * If you wanna change it to be on the end, we change the null ptr to the new node
* Inserting a node
    * You point the node behind,and point the new node to the next one
    * So much easier, no one gets moved only have to change 2 ptrs
* Delete a node
    * You have to free the node
    * Then change the ptr to null if its pointing to nothing
    * Just change the ptrs
* Does not require data to be moved

Not much code involved with linked lists


### Head node


### Code partt


```
Struct node
{
	Int node_number;
	Struct node *next_ptr; //works because its not nesting a struct inside of itself, its a ptr
};

//creating the head node
Struct node *LinkedListHead;// not a node but a ptr of type node
LinkedListHead = NULL; //MUST SET THE HEAD TO NULL

 //can be lots of other data, you dont need to number the nodes
```



```
Struct node *NewNode;
NewNode = malloc(sizeof(struct node));
NewNode->node_number = NodeNumbeToAddl
NewNode->next_ptr = NULL;

If (LinkedListHead == NULL)
{
Linkedlisthead = newnode;
}
```



#### Traversing through linked list + displaying node


```
// this is essential


TempPtr = LinkedListHead; //start at the head

While (TempPtr->next_ptr != NULL)
{
    Temptr = temptr->next_ptr
}
//Stops at the last node

While (TempPtr != NULL) //this is different than the one above
//Pasts the last node
```



### Inserting nodes


```
Struct node *temptr, *Newnode, *preptr;

Prevptr = NULL;
Tempptr = Linkedlist

While (Tempptr != NULL && Tempptr->node_number < nodenumbertoinsert) //node number is example
{
    Prevptr = temptr;
    Tempptr = temptr->next_ptr;
}

if(prevptr == NULL)
{
    Linkedlisthead = newNode;
}
Else
{
   Prevptr->next_ptr = newnode;
}

Put print statement inside of traversal to display a linked list
```



##### Display nodes

 use the <code>(<strong>tempptr</strong> != NULL)</code> while loop to print the whole list


### Deleting node

Code for deleting is similar to inserting


```
Temptr = linkedlisthead; prevptr=  null;
While (tempptr->next_ptr != NULL && temptr->noe_number !- Numberofnodetodelete)
{
	Prevptr = temptpr;
	Temptpr = temptpr->next_ptr
}
if(temptpr->node_number == numberofnodetodelete)
{
   If (temptr == Linkedlisthead)
   {
       Linkedlist head = temptr->next_ptr;
   }
   Else
   {
      prevptr ->next_ptr = temptr->next_ptr;
   }
   free(tempptr);
}
else
{
   printf("this is not the node you're looking for\n");
}

```


Very similar to inserting.


### Counting nodes


```
Struct node *TEmpPtr;
Int node_count = 0;

Tempptr = linkedlisthead;

while(temptptr != NULL)
{
   Tempptr =tempptr->next_ptr;
   Node_count++;
}
```


Easiest way to see how your linked list looks is to draw it out after counting how many you have.


```
Newnode = malloc(sizeof(node));
if(*Linkedlisthead == null)
{
	*Linkedlisthead = Newnode;
}
Else
{
	Tempptr = *Linkedlisthead;
	While ( tempptr->next_ptr != NULL)
	{
		Temptpr = tempptr->next_ptr;
	}

	tempptr->next_ptr = newnode;
}
```



## Typedef structs nodes


```
Typedef struct node
{
	Int node_number;
	Struct node *next_ptr;
}
Node;

Node *linkedlisthead = NULL;
```


Passing head of linkedlist is easy

displaylionkedlist(linkedlisthead);

That easy


## read a file with variable length fields using dynamic memory allocation

Tacobell example

Want to store it without arrays

Typedef struct

{

	Char *category;

	Char *name;

	Char *whatsincluded;

}

TACOBELL;

Int main(int argc, char *argv[])

{

	TACOBELL menu[20] = {};

	Char *token = NULL;

	Char filename[20] = {};

	FILE *FH = NULL;

	Char fileline[200];

	Int menucount = 0;

	Int i;

	strcpy(filename, argv[1];

	FH = fopen(filename, “r+”);

	

	If ( FH == NULL)

	{

		printf(“File did nto open);

		exit(0);

	}

	

	While ( fgets(fileline, sizeof(fileline)-1, FH);

	{

		Token = strtok(Fileline, “|”);

		Menu{MenuCount].category = malloc (strlen(token)*sizeof(char)+1); 


    /*because we malloced this space we know tacos is ours */

		strcpy(Menu[MenuCount].category, token);

		

		Token = strtok(NULL, “|”);

		Menu{MenuCount].name = malloc (strlen(token)*sizeof(char)+1);


    strcpy(Menu[MenuCount].name, token); 


    Token = strtok(NULL, “|”);

		Menu{MenuCount].whatsincluded = malloc (strlen(token)*sizeof(char)+1);


    strcpy(Menu[MenuCount].whatsincluded, token); 


    menucount++;

	}

For (i = 0l i&lt;menucount; i++)

{

printf(“category : %s\n Name       : %s\n what’s included : %s\n\n”, menu[i].category, menu[i].name, menu[i].whatsincluded;


## Stacks and Queues

Just linked lists with rules

Stack



* Stack is a linear data structure that follows a particular order in which the operations are preformed. The order will be LIFO (Last in First Out).
* LIFO works like a stack of plates.
* Stacks can be popped(taken out) and pushed( put back in)
    * Operations on stack
    * Push: adds an item to the stack
    * Pop: removes an item from the stack.
    * Peek: returns element of top stack
    * isEmpty returns true if stack is empty, else false
* A lot of things use stacks, the undo button, is a stack

Typedef struct node

{

	Int node_number:

	Struct node *next_ptr;

}

node:

Stack is literally a linked list but with rules

Node *StackTop = NULL; (could call it linkedlisthead but since we have stack rules yknow)

Stacks are meant for push and pop, nothing more 


### Stack Push

Void push(node **StackTop, int Node_Number)

{

	Node *NewNode = malloc(sizeof(node));

	newnode->node_number = nodenumber;

	newnode->next_ptr = NULL;

	if(*StackTop == NULL)

	{

		*StackTop = Newnode;

	}

	Else

	{

		newnode->next_ptr = *StackTop;

		*Stacktop = newnode;

	}

}


### Stack Pop

Void pop(node **STackTop)

{

	Node *Temptr = (*StackTop)->next_ptr;

	

	if(*Stacktop == NULL)

	{

		printf(“Stack is empty\n\n”);

	}

	Else

	{

		free(*StackTop);

		*StackTop = TempPtr;

	}

}


## Queues

Queue is a linear data structure which follows a particular order in which the operations are preformed as FIFO

First in first out

Like a line at the post office

Lines have a head and a tail,


### Operations on queue

Enqueue adds item to the queue

Dequeue removes an item from the queue

Head  front

Tail   end

Node for a queue look the same as a normal node

Typedef struct node

{

	Int node_number;

	Struct node *next_ptr;

}

node;

Node *Quehead = NULL, *QueueTail = NULL;


### Enqueue

Void enQueue(int newnodenumber, node **Queuehead, node **QueueTail)

{

Node *NewNode = malloc(sizeof(node));

	newnode->node_number = nodenumber;

	newnode->next_ptr = NULL;

	

	/* queue is empty */

	if(*Queuehead == NULL)

	{

		*Queuehead = *Queuetail = Newnode;

	}

	Else

	{

		(*queuetail)->next_ptr = newnode;

		*queueeTail = newnode;

	}

}


### DeQueue

Void deQueue( node **Queuehead)

{

Node *tempPtr = (*QueueHead)->next_ptr;

if(*Quehead == NULL)

{

	printf(“Queue is empty\n\n”);

}

Else

{

	free(*Queuehead);

	*Queuehead = tempptr;

}

}

Traversing stacks and queues is like traversing linked lists.

Typedef struct node

{

	Int node_num;

	Struct node *next_ptr;

}

node;


## Recursion 



* How functions are normally called
    * When calling a function, main gets put on pause
    * And executes the function called executes
    * And if cat calls dog, then it also pauses
        * When they’re all called they are all running but paused
    * When dog is done, it returns to cat and puts whatever value it has
    * Then cat finishes up and then main can continue.
* The memory all these functions are taken up we need it, if we call to many then bad stuff
* Recursions are functions that call themselves
    * But how does it stop??
    * Recursion is complex
    * Recursion existed long before computers, its like factorials
    * A recursive function for math is
        * N! = n * (n - 1)!
        * That into code looks like


### Recursion is used with algorithms


```
Int factorial (int n)
{
	If ( n == 0 )
	{
		Return 1; // this is our stopping point
	}
	Else
	{
		Return (n * factorial ( n - 1)); //this helps n get to 0 to stop
	}
}

Int main (void)
{
	Int input, output;

	printf("Enter an input for the factorial " );
	scanf("%d", &input);

	Output = factorial(input);

	printf(" the result of %d! Is %d\n\n", input, output);
	
	Return 0;
}
```


We are creating an execution environment in recursions

With a factorial of 4 creates 5 function environments

They can use a lot of memory quickly

Reqursions are really fast but eat up your memory quickly

Debugging recursive code is interesting…

Recursive program to sum range of natural numbers


```
Itn main(void)
{
	Int num;
	
	printf("Enter a positive integer: ");
	scanf("%d", &num);

	printf("sum of all natural numbers from %d to 1 = %d\n", num, addnumbers(num));
}

Int addnumbers (int n)
{
	If ( n != 0 )
	{
		Return n + addnumbers(n-1); // this is our stopping point
	}
	Else
	{
		Return n; //this helps n get to 0 to stop
	}
}
```


Not every recursive thing needs to return something to the previous step

Noo looping but it prints down and back up

Each of these calls to printfun(test-1) is a separate environment of the function and is a copy of printfun(int test) why it prints down back up

Void printfun(int test)

{

	if  (test &lt; 1)

	{

		Return;

	}

	Else

	{

		printf(“%d”, test);

		printfun(test-1);

		printf(“%d”, test);

		

		Return;

	}

}

Not normally looks like like this

But instead like this:

Void printfun(int test)

{

	if  (test >= 1)

	{

		printf(“%d”, test);

		printfun(test-1);

		printf(“%d”, test);

	}

}

Implicit else and just returns because it doesnt need a return when its void

Functional programming: dont use loops, use recursions

Fibonacci series

0, 1, 1, 2, 3, 5, 8, 13, 21, 34

Prev num + next num

Occurs in nature, forms a spiral

Golden ratio is fibonacci

Fibonacci can be expressed recurssivly

Unsigned long long int fibonacci (unsigned int in)

{

	If ( n == 0 || n == 1)

	{

		Return n;

	}

	Else

	{

		Return fibonacci (n-1)+ fibonacci(n-2);

	}

}

Fibonacci with recursion is slower than other methods

Any problem that can be solved recursivly can be solve iteraivly (looping)

Depends on wheen you should and shouldnt use recursion


## Tree Data Structure



* Linked lists,stacks and queues are linear structures
    * One node follows another
    * Each node contains ptr to next node
* Trees are non-linear
    * More than one node can follow another
    * Each node contains pointers to an arbitrary number of nodes
    * Number of nodes can vary
* Trees organize data hiearchily instead of linearly 
    * Like a family tree
    * Trees we draw upside down, root is at the top


## Binary tree



* Binary tree, is a tree with **up** to 2 child nodes
* Two children are called left and right nodes
* Parent nodes are nodes with children, parent nodes can be achild nodes themselves
    * Binary trees are used for a lot of different things
* 0 1 or 2 nodes only
* Top of the tree is the root
    * Parents because they have children, and are children
        * Children are also parents if they have children themselve
            * Children who arent parents, are called leaf
        * Link between nodes are called edges
    * Length of the path from the root is called depth
    * Height is from the deepest leaf to the root

Binary tree node 

Typdef Struct node

{

	Int node_number;

	Struct node *left_ptr;

	Struct node *right_ptr;

}

node;

Struct node *root;

Same malloc, data, only need to set left and right ptrs to null

Add node to binary tree

Normal linked list setup

Now we need to set parents left or right ptr to the child, how do we figure out how to do it?

Node *createNewNode (int nodeNumber) //pass in the data

{

	Node *node = malloc(sizeof(nodE));

	node->left_ptr = NULL;

	node->right_pr = NULL;

	node->node_number = nodenumber;

	printf(“node number %d %p\n”, nodenumber, node);

	Return node;

}

Struct node *root;

Root = createnewnode(1);

root->left_ptr = createnewnode(2); //put in left for now

root->right_ptr = createnewnode(3); //put in right ptr 


### Binary tree vs binary search tree

Binary tree = maximum of two child nodes, no order to how the nodes are organized



* Binary search tree
    * Maximum of 2 child nodes, there is a relative order
    * We apply rules to make it a binary search tree

We are not going to deal with duplicate node values (its irrelevant to coding assignment, and is a lot of work)

RUles:

Values in left subtree are less than their parents

Values in right subtree are greater than its parents

The shape of the binary search tree

(want binary search tree to be balanced as possible)


## BST

Every to the left is less, everything to the right is great for every Node

Order of how the data is imputed is how the tree will look

Tree structures will be traversed in a way


### Breadth-first order

Cover whole layer of nodes, then the next layer (this is for algorithms class)


### Depth-first

We go down a branch, then back up, then back down



* Inorder traversal
    * Give us the nodes in increasing order
    * Sequential order
* Preorder traversal
    * Parent nodes are traversed first before the child nodes
    * Used to get a copy of the BST
    * File systems us it to track your movements through files
* Postorder traversal
    * Used to delete the tree
    * File systems use it to delete folders containing folders/files

Preorder //root first

	Root, left, right

	OLR

Postorder //root last

	Left right root

	LRO

Inorder //root in middle 

	Left, root , right

	LOR

Left right root = postorder

Root Left Right = preorder

Left root Right = inorder

Node *root = NULL;

AddBSTNode(&root, node_data);


```
void AddBSTNode(BNODE **BSTnode, char MTN[], char ZC[], char FN[], char DIM[])
{
	// If passed in BNODE is empty, then current BNODE becomes root
    if (*BSTnode == NULL)
    {
        *BSTnode = malloc(sizeof(BNODE));
        
		(*BSTnode)->left = (*BSTnode)->right = NULL;
		
		(*BSTnode)->MovieTheaterName = malloc(strlen(MTN) * sizeof(char) + 1);
        strcpy((*BSTnode)->MovieTheaterName, MTN);
        strcpy((*BSTnode)->ZipCode, ZC);
		(*BSTnode)->FileName = malloc(strlen(FN) * sizeof(char) + 1);
        strcpy((*BSTnode)->FileName, FN);
        strcpy((*BSTnode)->Dimensions, DIM);
    }
    else
    {
        if (strcmp(ZC, (*BSTnode)->ZipCode) < 0)
			AddBSTNode(&(*BSTnode)->left, MTN, ZC, FN, DIM);
		
        else if(strcmp(ZC, (*BSTnode)->ZipCode) > 0)
            AddBSTNode(&(*BSTnode)->right, MTN, ZC, FN, DIM);
        
		else
            printf(" Duplicate Element !! Not Allowed !!!");

    }
}
```


FEQ1

	Base conversions

	Recursion

	Command line argos

	Debug

	String handling

	Twos complement

	Bitwise operators

FEQ2

	File handling

	Structs

	Malloc

	Pointers

	Dont forget taco bell

	Need to malloc space for the array

	Lines of code laveld with a letter, match the code laveled

	Use comments to pick correct ording

	It must work as a program, and match the comments

FEQ3

	Linked lists

	Given code that forms a linked list can you 

		Add a node to the start

		Display linked list

		Add a node to the end

		Delete a node from the l list

FEQ4

	Stacks and queues

	Same thing, can you put it in order

		Push and pop node

		Explain what a stack is

	Queue

		Can you enqueue

		Dequeue

	Also displaying queue and stack

FEQ5

	BST

		Add a node to BST

		Can you traverse BST 

			Preorder, inorder, postorder

		
