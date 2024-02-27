
# CSE 1320

Donna French Formatting
Based on indention and alignment

* Code blocks should be indented at least 3 spaces and not more than 5 spaces
* If tabs are used, always use tabs and set tab size to be 3-5 spaces
* If spaces are used, always use spaces and always use the same number of them
* (so basically use spaces)
* Curly braces should align vertically and be on their own line
   * Int main()
   * {
   * }
* Code formatting can make it readable, can see nested structures easily
* Less reliance on editor to match up braces and code blocks
* Makes easy grading
 
### OLQ1
This one can only be taken multiple times
OLQ2 -> 13 Are only final submission
 
* Need to use preformatted font when writing code in canvas for quizzes -5pts for not doing so
 
Tools needed for this class:
* Whatever u want
* Virtual machine works 
* Visual studio code is what the class is using (can install ubuntu’s terminal in vs code)
* Slide show soon to come
 
Windows was based on dos
Ubuntu mr popular
 
## UNIX 
* ls -> list
* ls -a  -> lists hidden files, have a . in front ex. .vscode
* ls -l -> command lists more information about the files, The long description
* Touch - makes a new empty file
* mkdir -> command is used to make sub directories in home directory
* cd -> change directory, also returns to home dir 
* cd .. -> takes you back a folder
* cd . -> does nothing
* cd -  -> undos the previous cd
* pwd -> print working directory, tells you where you are, your file path
* cp -> copies files
* mv -> renames file, or moves it to a new name
* rm -> removes a file, deletes it
* rmdir -> deletes an empty folder
* cat _filename_ -> entire files to the screen at once
* more _filename_ -> displays page by page
* clear -> clears screen 
* apropos _a word_ -> displays any command that references 
* man -> manual 
* grep -> searches a file for a particular pattern of characters Lots of options, but basic grep is what we need to know
* diff -> displays differences in files, compares line by line, if 2 files are identical, it shows nothin
 
## Tips & shortcuts
* history -> shows every command you have typed, can redo any of commands
* TAB completion 
* Up arrow -> shows history aswell, for previous command

### Computer languages can be 
* High level - 
   * easier for human to write, takes more for the compilers to take to machine code C++, java, easier to port between systems too
* Intermediate level
   * C is inbetween, intermediate to high level language because it allows programmers to have some control over the hardware. Assembly code can be written into a C program.
* Low level - 
   * harder for human to write, more work for us, takes less for compilers to make machine code, Assembly language - used to write operating systems
 
## Character set




### ASCII
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

* Extended binary coded decimal interchange code EBCDIC
   * Used on IBM mainframes
   * Letters grouped 9 at a time
   * Stems from punch card origins and is quite difficult for programmers to deal with 
   * Unicode is a expansion of ASCII
 
#### Format of C programs
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
 
Escape characters
* \n -> new line
* \t -> tab character
* \b -> backspace (doesn’t destroy what you’re backspacing over) 
   * Manipulates cursor
* \” -> prints “
* \ \ -> prints \
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
If u do float divisions then you do get remainders
 
To get the remainder just use mod %
 
++ -- 
 
### Arithmetic operators
 
High precedence 
* Unary operators ++,--
* Multiplicative operators
* Additive operators
* Assignment operators
 
Low precedence
* Within each group the operations associate from left ot right.
 
() = your best friend for this
 
### Structure programming in C
* How you “should” write your code
* Write source code that is 
   * Modular
   * Easily modifiable
   * Robust (handles errors gracefully)
   * Readable
* Write functions that can be used with little or no modification in many programs
* Write functions to do one task that is not too long and can be understood easily
 
 #include <stdio.h> is preprocesser instruction
 
## Preprocessor
* Executes before program is compiled
* Inclusion of other files
* Start with #
* Preprocessor combines it with your program
* -E only run preprocessor, not the compiler
* Two forms of includes
* <> 
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
 
### Expression vs statements

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




## Rules of variables

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
 
#### Int

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
 
### sizeof() vs strlen()
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
 
## Unsigned types
* Unsigned type gives you the whole space for positive values
* Normal types are called signed types which have negative and positive values limited to their byte size
   * Doesnt change the size of the type
* %hu unsigned short in decimal
* %u unsigned int in decimal
* %lu unsigned long in decimal
 
### Limits.h 
* Defines in min and in max
* Uint max is doubled then the normal max for a signed
 
### Printf()- field width specifier
* Optional
* A decimal integer constant (no negatives)
* Outputs the right justfies and blanks will be used to pad on the left
* Basically css shit in c
 
### Floating point types
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