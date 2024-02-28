## memcpy() memcmp()

* A lot like strcpy() and strcmp()

Memcpy and cmp do not obey the null
Both take a 3rd parameter, in that you tell it how much to cpy or cmp
Or num. Of characters to copy


memcpy(array2, array1, strlen(array1));

### memcmp()
Memcmp is just like strcmp but with the number of bytes for its third parameter

* Be careful not to compare garbage to garbage 

### memset
Void *memset(void *str, int c, size_t, n)
* A way to set all of the elements of the array to a given value

Set
Value
Num of bytes

Char MyTestArray[] = {“ABCDE”};
Memset (myTestArray, “ “, sizeof(MyTestArray) );
Turns it all to blanks in the array
Sizeof will overwrite the null
* This will do exactly what you tell it to do.

If sizeof is used 
Do 
Sizeof -1

Or use strlen 
(only with char arrays)

Memset puts that number for ints in every byte 
Since ints are 4 bytes, it set it to every 4 bytes

* Use 0 and -1 with memset and int arrays

## Automatic versus static variables

### Storage class
* Storage classes are used to describe the features of a variable or function.
* 4 things abt storage classes
    * Scope (local or global)
    * Default initial value
    * Lifespan
    * Storage location

### Automatic variables
* Default storage class auto int intvar;
* Created each time they’re created and called then they get destroyed when they go away
* Functions have overhead, they take extra processing power
* The variable in functions are local they exist only within the func, 
* When an automatic variable is created without being initialized it is not given an initial value may contain garbage
* Automatic variables created with an initialization, its redone each time its called

### Scope
Inside function - local
* Default initial value
    * Contains garbage
* Lifespan
    * Created when func is called and destroyed when it exits
* Storage location
    * stack

### Static variables
* Static int intvar;
* Static variables exits the whole tiem the program is executing
* Mem space is allocated when program starts
* Static variables are given the default value of 0
* If an initializer is used then the variable is initialization once at the beginning of the program
* Scope
    * Inside function -local
* Default initial value
    * 0
* Lifespan
    * Created 1 goes aways 1
* Storage location
    * data segment
* Being static != being global


## Register variables
Register int i
Programmer requests that a variable be placed in a register
(the answer could be no)
Usually indicates taht a variable will be used frequently
Improved speed and performance – indices and loop counters are great in register
No guarantee that the variable will be placed in the register
Very limited in availability and size
Illegal to use the address operator & with the name of a register variable

## Global versus local variables

### Local Variables
* It exists only in the CURLY BRACES {}
{
}
* Once declared it can be referenced from any point on
Int main()
{
	Char[] = {"IM A local VARIABLE"};
}


### Global Variables
Not inside Curly braces
Defined from outside of them
Can be referenced at any point in SC (source code)
Global variables exist during the full execution of the program
Char[] = {"im a GLoOBAL variable"};



For locals {} are like little gates


**Caution**
Global variables should be used with discretion
All functions can access global variables and change their values
The effect of a function changing a variable from outside its scope is called a 
SIDE EFFECT

You can create a local version of a global variable with the same name


### CRLF vs LF vs CR
* CRLF
	* How windows interprets a newline
* LF
	* Unix
* CR
	* Mac


## Omega
How to create a remote terminal on Omega

Setup pulse vpn 
Google uta pulse 
We use ftp client called FileZilla
Tool for moving FTPing files between your computer and omega (and other things too)

PC
We need SSH 
Download putty (optional) (its a terminal emulator)
PC and Mac
Use ssh to connect to omega 
Ssh netid@omega.uta.edu
Then your pass

Leaving idle too long will disconnect automatically
(abt 20 minutes)


## Pointer Arithmetic
This is limited to the bounds of a single array

Pointers may be incremented or decremented
intvarptr ++ pushes it right
intvarptr -- pushes to the left
++ intvarptr 
--  intvarptr

You can also add or subtract from a pointer
Intvarptr += 2 invarptr -= 5

* ( you dont have to calculate the number of bytes it does it for you! )

One pointer may be subtracted from another pointer of the same type (gives us distance)
Intvarptr - inintvarvarptrptr;

Amt to increment/decrement is relative to the sizeof() the type of the pointer its pointing to


*intvarptr + i <- does not move the pointer     *(intvarptr + i) <-moves the pointer

### Pointer addition 
Not defined in the language
Just cant add two pointers theres no meaning to adding 2 addresses 



## Enumerated Types
Are scalar types in C and are used to declare a set of integer constants in C.
Creates our own data type basically
You can declare variables of that data type

```
enum boolean
{
	False,true //false = 0 true = 1
};

enum boolean correct
```



* Int constants are automatically numbered like an array
* Default values start at 0 then add 1 to it every spot
* You can overwrite their values like this

```
Enum colors
{
	Red=3, orange=6, blue=4, indigo
}
Rainbow;
```

More than one identifier can be assigned the same value 
If one isnt defined after, itl just add up to the next one

Main use of enumerations would be case statements

```
Switch (colornumb)
{
	Case red : printf(“red”);
	Case blue
}
```

Only problem is we cannot have repeating numbers in case statements (enum doesnt care, case does)

Variables hold numbers or things
Enums do not, they represent constant ints


Enum variable is legally supposed to accept only the values defined in it, but compilers arent required to check
Operations with enums are limited because they’re int constants


What else can you use them (mostly use them for case statements)
* Improves readability

## #define vs enum
Enum follow scope rules
Enum variables are automatically assigned values
Enums have a type - #defines do not (enum is an int) (define is search and replace)
Debug can display enums

* Gcc Test.c -g -Wall (gives you things to fix)

Legal to val in enumerated var that doesnt exist in there


## Introduction to Structures

### Aggregate Types
* Aggregate types are designed to hold multiple data values 
	* Arrays can hold many data values of the same type
	* These are same type /\

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

* Ptype is handy for structs
* Ptype tshirt list them out

Initialization is like arrays
* Good idea to set your struct to ={};

```
Struct tshirt mytshirts = {"XS", "DISNEY", 'y', 14.99, 1987};
```

* Need to know that “” put a null \0 at the end of the string

Single char single quotes
Dont quote numbers dummy


### Restrictions to structs
A member of a structure cannot be a function
Structures are not classes
A structure may not nest a structure of its own type
Cannot initizliaze as you declare in a struct
Equivalent to int 5;
Proper way is to intialize it all in 1 line of code

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

## How to use our structures

We have the dot operator 
Variable_name.member_name

MyTshirts.size = char size[5]
MyTshirts.color
MyTshirts.design
MyTshirts.fittype
Term becomes whatever type is in the struct

* Dot links it from struct

## Operators on structures

* assignment

YourTshirts = MyTshirts works
Address
&MyTshirts
&YourTshirts

* sizeof()

sizeof(MyTshirts);
sizeof(MyTshirts.color);


### Arrays of structures
Making an array of structs holding each cell of structs 

Struct tshirt Marve;Tshirts[10];
Struct tshirt DisneyTshirts[15];

Every cell is a structure

MarvelTshirts[0].color
MarvelTshirts[5].fittype
MarvelTshirts[6].size
MarvelTshirts[9].inventory

* Can intialize array of structs to be null
* You can also intizalize the first field
* Individual elements in an array can be accessed like arrays

MarvelTshirts[5].color[0] = ‘R’;
MarvelTshirts[5].color[1] = ‘E’;
MarvelTshirts[5].fittype = ‘Y’;

* Pointers in Structures
* Pointers ARE EVERYWHERE

If you pass a struct to a function, it will not be changed unless we actually pass by reference with pointers

Struct tshirt *tshirtptr;
Tshirtptr = &MyTshirts;

Struct tshirt *tshirtarrayptr;
Tshirtarrayptr = &dccomicsTshirts[3]; (only works because its an element of the array) would work without [3]

* The () are necessary because the dot selector has precedence over the dereferencing operator *

If you dont use it error: Request for emmber ‘design’ in something not a structure or union

Pointer to a structure is used too often in c they created a shortcut for it
(*struct_pointer).member can be written as struct_pointer->member (arrow operator)
We will use struct_pointer->member

## Passing structure to and from functions

When passing you dont put type or brackets if its an array same with structs

catdog(MyTshirts)
Passing it like a variable 

If we want it to change the struct, pass the address/ptr of it to the func

#### /*pass by reference*/

You dont neeed to make a pointer variable, you can also just put the address of it, but ptrs are cooler


Struct tshirt *tshirtptr = &myTshirts;struct Tshirts *tshirtarrayptr = &DCCommicsTshirts[3];
Int inventory (struct tshirt * x) 


## Unions
* Union is like a structure
* It can hold members of different types
* Same rules as structures
* Arrays and pointers to unions allowed
* You can use -> to get to member selection

Unions different from structures
* Will only contain one of its members at any instant instead of all members
* Its a time share, at any given moment only one of them exits
* Storage is allocated to the largest one

```
Union tag
{
	Member list
};
```

* Size of unions are the largest member in it
* When storing inside of the union all of the members share the same memory space
* Its up to the programmer to know which one exists
* Share one chunk of memory, all share the same address


**Caution**
Theres no automatic mechanism to determine which member of a union is in use at any given time. It is up to the programmer to keep track


## Typedefs
The typedef is a storage class is used to associate an identifier with a type
typedef old_type new_type;

* Take a type and give it a new name

Its similar to a #define 
They’re processed by the compiler
Only used to define data types

* Defines have more freedom then typedefs

More controlled define

Typedef short MyShort; 
Dressing up variables and giving them a new name;

Myshort x=0; 

Typical use of typedef is to get rid of the struct

```
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
```


Note abt math library

#### abs() absolute value
Does not need math.h
Abs is in stdlib.h
If math library is used you need an extra compiler command
Math library is not part of standard C library
You have to use -lm to link it in

Link math -lm

M_PI = pi

Compiler optimized the call for calculating radius for circle instead of calling math library to raise something to the power of 2, itl just multiply it by itself.


Array notation [] and when to use pointer notation

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

* Storage of data in memory is temporary

Files are used for data persistence and permanent retention of data
Cds dvds flash drives and tapes

C does not impose structure on a file, a file is just a sequence of data
  the concept of a record in a file does not exit
Application reading it imposes the structure of whatever you do
Things in files are just sequence of bytes

* Will have an EOF (End of file) marker

When you open a file you get a file handler and refer it to it every time you use it

* To open a file
    * Use: FILE *myfile, *yourfile;

* FILE is a struct 

#### Open and close

Myfile = fopen(“filename”, “mode”);
fopen(“it.txt”, “r”);

How we open files

After opening it, we need to Closseee it

fclose(Filehandle)
fclose(myfile);

“Mode”

R read
W write
A appends
R+ reads and updates existing file
W+ create a new file for update
A+ 

Lots of modes

### f/s-printf/scanf 

* fprintf() fscanf() <- file version of printf and scanf
    * Reads and writes to files

* sprintf() and sscanf()
    * Read and write from a string!

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