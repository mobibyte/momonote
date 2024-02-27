
# Decimal vs hexadecimal vs octal

## Bit byte vs word
 
* Binary digit - bit
   * Holds 0 or 1 on or off true or false
* Byte is 8 bits in 1
* Word  could be one or more bytes
 
### Types of Expression
*   Every expression has an associated type
   * 3+4 = 7, we know they’re ints
 *    3 + 4.1 = 7.1
 *    3 is an int, and 4.1 is a float
 *    3 < 4 = 1 true
·        Unary operation
 *    ++cat
·        Binary
 *    Cat + dog
·        In a binary operation, both operands are converted to the dominating type
 *    Result is dominating type
·        Automatic typecasting, converts types based on dominance
 
## Forced type conversion
### Type casts
·        The type of an expression can be temporarily changed with a type cast
·        Can be constructed with any off the basic types in C
·        No restrictions on the use of type casts
* Floats do not have precise storage in computers  Data may be lost in this process.
 
 
## Memory buffer and C executable file
·        Stdin
   Memory buffer
*    When scanf is runned, it looks inside stdin
*   Enter key is \n
·        C executable
*    Pulls in and checks stdin
*    Puts out variables to stdout
·        Stdout
*    Memory buffer
 *    Variables get put here
 *    Stdout puts out what needs to be displaye*
 
### Bit operations on the ints
·        Least significant bit
 *    The bit in a binary number that is of the lowest numerical value
·        Most significant bit
 *    The bit in binary number that is the highest numberical value
·        10101100
 *    1 is most significant
 *    0 least significant
·        Count right to left, start from 0
·        Bitwise negation
 *    ~
 *    Flip the bits
 *    Replaces all the 0 bits by 1 and all of the 1 bits by 0
 *    Basically a mirror image of binary
·        Bitwise AND
 *    & <- one of these
 *    && is logical operation
 *    Takes binary, stack them on top of the bits and combine them,
 *    1 & 1 is 1   ,  1 & 0 is 0,        0 & 1 is 0  ,  0 & 0 is 0
·        Bitwise OR
 *    |
 *    Same thing with logical or but with bits
·        Bitwise XOR
 *    ^
 *    Same logic but with every bit
#### Bit masks
·        Is a number that we can & | ^
·        To detect whether or not a certain bit is on or off
·        To turn a bit on or off
·        16 bit numbers to be able to use as flags
·        2^(whatever bit) we wanna know is on or off using &
 *    Result is 0 if off
 *    Result is 2^(bit) if on ex 64 = 2^6
·        XOR can turn off the bits, and can turn it on
 *    0 ^ 1 is = 1   1 ^ 0 = 0
 *    Essentially subtracting but for computers
 *    Also can turn it on whatever it’s worth, adding
·        Using non powers of 2, results in adding and subtracting
·        Can be used to determine if number odd or even
 *    Check the last bit to determine if  odd or even 0 = even, 1 = odd
 *    2^0 = 1

### Bitshifting 
* Shifts left <<
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


# Arrays
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

/* 512 loop* /
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


/* 32 loop */
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


### 4 bit adding in binary
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






# Functions
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


## Function prototypes
* Way to introduce them to the compiler, to let them know what they look like
* Take definition, copy past add ;
* In them variable names dont really matter
* What does compiler do with the prototype
   * Do a lot of things but mainly matches things up
   * Plays a little matching game


### Ternary operators
* 3 things
* Ternary if
   * If else to a 1 line statement
* Only a simple if else and needs to be same variable

```
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

```

## two-dimensional array 
* Split up in row columns [0][0]
* [] rows [] columns
* [6] [4] 6 1diminesional arrays with 4 cells


When passing 1d array dont specify value
First dimension blank when passing 2d array but not the 2nd [][5]
Calling them just the name

# Passing parameters to functions


## Two basic methods
* Pass by value
   * A copy is made when you pass
* Pass by references
   * Pass it by the addresses storage location
   * Operations are done directly on parameter

### In C
* All parameters pased by value
* No ability to pass by reference does not exist 
* Arrays are exceptions by using pointers which simulate it

## segmentation faults
* When u do something bad
* When you attempted to access a restricted area of memory, 
* The operating system is not happy about this

# Debugging
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

