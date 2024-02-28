## Pointers
### Memory and addresses

* In upper-level languages give the programmer little or no control over the assignment of memory addresses
* You do get to pick what type of memory, Control What is stored in memory, But not where it’s stored
* You control what is in your PO box based on what type of mail you get
* You decide how big it is 

* The & used with scanf refers to the address of the variable

* Dont use it with arrays because the name of the array is the address of the array

- %p Conversion specifier for printing addresses
Forms vary from computer systems
- %x Hex
- %o Octal

0x7fff
Stack address


## Pointer

A variable that can store the address of another variable
Just holds addresses of other variables, they have no idea whats in the variable

Pointers indirectly references values
Pointers also have their own addresses
```
Int intvarA = 8765;
Int *intvarAptr = &intvarA;
```

* Pointers are separate data types
* Every datatype has a pointer type
* Cant mix pointer types and data types
```
Int dog
Char *frog = &dog doesnt work
```
We can have pointers to pointers, nested pointers

* makes pointers


### Pointer initialization and the null pointer
* Null should be used to indicated that a pointer is not pointing yet

Int *A=NULL;

- famous words of donna french
- "Like putting safety on a gun"

* Its good to put NULL, because 0 could not work on some systems, this is a good habit

* Pointers are variables

## Dereferneing a Pointer variable

Print the addresses of variables
Could be useful for debugging

Not often a permanent part of program
More interested in value pointed to by pointer
Value can be changed through pointers

Dereferencing operator
* is used to get to the contents of something
printf("%d", *ptrcat)

Prints contents of the address of the ptrcat
Dereferencing can be used on either side of an assignment
* is like the key of the PO box

Unary operators & and * when used with porters have equal precedence with each other
* Expresiosions combining them are evaluated from left ot right

Unary operators have higher precedence than binary operators
IntVar2 *intvarprtr1 + *&intvarptr2
*& cancel each other out


### Size of pointers
* Holds 8 bytes
* Pointers hold addresses
* Same size as long

#### Why do pointers need to have a type?
For the same reason that languages have a type system in the first place, it helps to detect invalid usage of pointers when compiler time comes rather than runtime

If you pass a ptr to char that points to an int, it wont work!

* Compiler dont like different types

### Pointer Arithmetic
Makes it easier why pointers have types
You can move pointers around by integers for arrays
Take ptr add 2 to an int array

### Do while

Executes contents of loop at least once
Expression evaluated after statement
While (expression); <- need this for DO while

### Switch
Expression needs be int 
Switch (expression)
Cases below

### Continue and Break
While
For
Dowhile
Use inside a loop or switch then fall out of loop
Used to alter flow of control



### Return
Used in main to terminate the progam
Also terminates functions to
Lets function end too
Functions in c arent required to return it


### Exit()
Takes single parameter of type int
Terminates the program
Needs <stdlib.h> 

* Not allowed to use exit unless assignments say to
* Use return 0; in main, not exit(0) 

\0 at the end of initialization of char arr
“ABC” -> char A[4] the real size is ABC\0 just dont put size

* **The name of the array is the address of the first element of the array**

```
Char *PtrArray[] ={"The","quick","fox","jumps",""};
```
Array doesnt hold strings ^

* Pointer array is an array of pointers
* T is the memory location of the string “the\0” same with q, f and j
* The “” is just empty space, it is just a \0

So an arrays use pointers, a pointer array uses an array of pointers
* Char **PtrPtr = PtrArray;

An address to get to another address to get out contents

Char *ptrarray[9];

	Construct is used in c to represent an array of strings

strlen(cat), counts until theres a \0

* **C does not put a limit on the number of levels of indirection.** “Fun”


## Makefile
Adding in steps so we can link multiple object files

Gcc -c (command to ONLY compile)
You get to see object file
Gcc -g code_name.o -o code_name.e (names executable
We can run the .e file

### What is make
Unix utility that is designed to start execution of a makefile

A Makefile Is a special file, containing shell commands that you create and name.

* People dont do this by hand

Make looks for the directory you’re in 
make (looks for file named makefile)

* Coding assignments need separate folders now
* Make keeps track of the last time files were updated, itl only compile new updated code
* Without makefile this sucks ass


Makefile works well in one shell but may not in another

Makefile contains list of rule, tells make what to do
The rules, have to begin in column 1 No indentions
* * Dependcency line
* * Recipe

Must be indented with a 	tab not spaces
After its been created a make file or a text file
Make will stop when it runs into an error
* Rule : dependencies
	* System commands (recipe)

All is default rule where it starts
Dependency
Recipe

Makefiles works its way down then back up
Executes backwards
*** missing separator means that you didnt use a tab

Make cant find makefile.txt, make cant also find makefile.mak
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

**We dont need to memorize makefile on a test, but instead understand what it does.**

* To use multiple c files
SRC1 = code_main.c
SRC2 = libarray_code.c
OBJ1 = $(SRC1:.c=.o)
OBJ2 = $(SRC2:.c=.o)
EXE = $(SRC1:.c=.e)


With multiple file = multiple sources and objects but only 1 exe file with src1 being main.

Will ask what section is compiler section

Compiler creates an object file, or a .o
Linker links files to make 1 .e or executable 


## Libraries

* Libraries are not executable
* Do not contain a main() function
* Only contain functions and declarations
* Cannot gcc a library then ./a.out it
* No more gcc or a.out after we start using make 
* Coding assignment 4 your library has 2 files
* Mylibrary.c
* And mylibrary.h 

### Stdio.h
Stdio.h is a standard library file, there is no executable code in stdio.h the prototype is in the .h the real code is in stdio.c which is linked with the system library

We need something for our header files to prevent stupid from happening

## Include guard

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

## Compiling and Linking
Main program
Filelib.c
FTP.c

* We compile and link with make individual files, because we dont open files that we dont need to open
* Allow multiple people in industry to work on separate files to work at multiple places at once and then compare if it works

Comments are made by # sign 

* make -B (causes make to recompile everything)

In C

* All parameters are passed by value (pass a copy of them)
The ability to pass by reference does not exist

* We can simulate it (pass by reference)
We pass the address of the variable

* Addresses cannot be modified
Contents of address can be modified

* This can be done in functions
If you pass an address to the function
We can modify the contents of the variable because we passed its address

Calling it: we print it like cat(&dog);
In func: void cat(int *Bird)

## Strings

No string data type, in other languages they are objects
* C doesn’t have objects

### string.h what is it?
* A string is a sequence of characters from the underlying character set
* A string in C is terminated by a null character. ‘\0’
* A string is accessed via a pointer in its first character
* A string is like an array of characters - both are stored in contiguous memory
* Arrays do not require a null character
* Strings must have a null character at the end
* Strings are a null terminated character array

String library functions expect strings or Null terminated char arrays

```
Char Cat[]"Put things in memory with a \0"
```

* The address is the first element

If you put a \0 in the middle of string it just cuts off your string

```
" please dont cut me \0 off"
Prints: please dont cut me

Char cat[10] = {};
Char *Cat;
```

These things are not interchangeable directly

* If assignment says make an array make a gosh dang array

##### %s
Basically just telling printf(%s) will print until it finds the \0

##### scanf(“%s”, array) 
* Dont need & because name of the array is the address of the first element of the array

If you want to print a % sign in string you do %%

* Scanf doesnt read through whitespace
* When it sees whitespace it stops

Scanf adds a null terminator to the array
What happens if array is not large enough to hold input?
* Overflowwwwwwwwwwwwwwwwwwwwwwwwwwwwww

A string can be stored in an array at the type the array is declared


## Variable Strings
To input a variable length string

### Fgets (inbuff, n, fp) fp = stdin
* Will not stop at whitespaces
* Everything it reads is a string
* Only returns character

For strings that have spaces in them
Puts null terminator at the end
So always do n-1

Returns a value
a char* value(the address of inbuff) or NULL
We dont even need it
For now


fgets must get an array to write into
* Cant use a pointer for thisss

### gets()

Takes array, and assume you’re reading from stdin
gets(inputarray);
It doesnt, have the second parameter to stop it from reading too much
Thats no good
**Doesnt have overflow control**
**The compiler tells you that gets is dangerous and should not be used lmao**

## String library Functions

### strlen(string)
* Calculates the length of string
* Parameters, null terminated array
* Return value: the length of a string not including a null

size_t is an unsigned int, or like one (8 bits?) 0 and up, ints positive
Gets rid of the that pesky \n
UserString[strlen (UserString) -1] = '\0';


* Implicit declaration of built in function warning means u need to #include

### strcpy(buffer, string)

Copies string into buffer

Writes over what was there before, not wiping it clean, just writes over the parts that were there
Result always ends up in first parameter

### strcat(buffer, string)
Glues two things together
Glues two strings togetheerr
```
Hellow there
How are you
Hellow therehow are you
```
Second string is unharmed
First one is glued together with second

### strncat  (buffer, string, n)
n lets us tell it how many character to glue together
strncat (string, string1, 2)
This string was
This string was gl

### strcmp(string1, string2) 
Just compares strings no altering
It return a 
0 -string identical
Positive - first string is > second string
negative - first string is < second string
Compares first char in string, then moves on if they’re diff

Shorter string will always be less than

### strncmp(string1, string2, n)
Like strcmp, but the n is just how many characters its comparing


#### Requiring use of pointers

### strchr(string, ch)
Looks in a string for a given character ch
If it cant find it gives you NULL
If it does find it, it gives you the address of it back
If you have an odd string like qbcabqc
It will only find the first letter of the pointer, like q will only be the first q

To get around this you use a while loop with a pointer not = null
You would dereference with first occurrence and slam the first occurrence with a -
Then ask it to get another strchr after u do that

### strstr(string1, string2)
Like strchr but with pointers
Points back to the first letter of the string)

## Technique for coding assignment 5
Get pointer to first occurrence
Same while loop as strchr
Find the distance between the 1st string and first occurrence
Then for loop counting up to strlen of userstring 2
Inside for loop, userstring1[distance + i] = ‘X’
First occur = strstr(userstring1, userstring2);



    while (FirstOccur != NULL)
    {
        distance=abs(UserString1)-FirstOccur;
        for(i=0;i<strlen(UserString2);i++)
        {
            UserString1[distance+i]='X';
            
        }
        FirstOccur=strstr(UserString1,UserString2);
    }




### strpbrk(string, char_set)
Like string char, but uh whole set of char’s 
Same loop with string char
A more efficient string char
```
While (firstoccur != NULL)
{
	
}
```

### strtok(buffer, delimiters)
How you take a string, and put them into separate variables or tokenize them
Delimiters divide up tokens

We break them up because we want to handle things separately

Stringtok changes our strings when it sees delimiters, it will replace it with a NULL

Creates internal static pointer that points to the point after the delimiter it just replaced with NULL 
Strtok can be told to not start over, pick up where it left off

Using NULL instead of the array name invokes the pointer to the spot after NULL
If you dont use NULL
It just startsss over at the beginning

You can use char *Delmiters = “{}”;
Char *Token = NULL;

## Is functions
Only works for single character
* islower(ch) is lowercase
* isupper(ch)
* Isalpha(ch)
* isalnum(ch)

Checks for things on single char
Can use with if statements to return 1 or 0

## To func.
* tolower(ch) returns the lowercase version of ch
* toupper(ch) returns the uppercase version of ch

Needs to be passed by reference or be used by passed by value to store a variable to the return of toupper

Ex. x = toupper(chrX);

## Atoi and Atof

Takes string that has a number value and gives back the int or float vers. Of the char number

Char num[5] = {“540”};
printf(“%d”, atoi(num));

Does not work if char array has letters before numbers
Works with letters after

