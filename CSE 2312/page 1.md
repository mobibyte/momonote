
## Cse2312 Computer Organization and Assembly Language Programming


## Syllabus

Darin Brezeale: email [darin.brezeale@uta.edu](mailto:darin.brezeale@uta.edu) 

Office hours: TuThu, 9:45-11:15am

Cache is biggest speed improvement for computers

ALU is the adding part of the cpu

How does knowing the computer help you code efficiently


## Myths



1. Everything in a computer <span style="text-decoration:underline;">Has </span>to be a power of 2.
    1. <span style="text-decoration:underline;">If </span>8 bit byte
        1. 2^8th power
        2. 3^8th power (on a base 3 com)
        3. 10^8th power ( on a base 10 com)
2. Bits have inherent meaning
    2. Endian
        4. The farther you get away from the physical machine the less they worry about how the machine works
        5. Assembly does not have types, its just a bit pattern


## Bits



* Represents 0’s and 1’s
* They just represent states
    * Like on and off, dashes and dots
* 8 bits = 1 byte
    * Bit is a binary digit (associate with base 10 digit)
    * . is a radix (or a number base)
* Bytes dont have to be 8 bits, there are different computers with different bit types
    * They can choose a byte to = 8 bits, which is a power of 2^8
    * One of the benefits of binary is its clear what state is being represented


## Number bases

Common bases 

Base	name		symbol

2	binary		0,1

8	octal		0,1,2….7	

10	decimal	0,1,2…9

16	hexadecimal	0,1,2…9,A,B,C,D,E,F



* If you use linux, ls -l
    * You can see the file long names
    * On unix its owner, group other  - rw-r--r-- file text
    * Programs are rwxr-xr-x

Can also be stored as bits files and programs



* MAC Address almost always written in base 16 hexadecimal
    * 14:A0:B3:__:__:__ 


## Base conversions



* Base 16 -> B2
    * 5C B16
    * 4 bits on 5 and C
        * When converting its helpful to write leading 0’s 
    * 0101 1100 = 5C
* In math we use positional number sys. Hundreds tens ones … 10^2 10^1 10^0, 10^-1 …
* Base 2 can do the smae thing, … 2^2, 2^1, 2^0, 2^-1 …
* Can be applied to base 16 aswell …16^1, 16^-1 …
    *  a5B16 -> base 10 5x16^0 = 5 10x16^1 = 160 == 165
* 35 B10 -> B2
    * Prof. method, fill in the distance of 35 inches for example
    * 9 1-inch, 9-10inch, 9-100inch
    * Use 3 10-inch pieces and 5 1-inch pieces
    * For base 2 we use diff pieces now
    * 64, 32, 16, 8, 4, 2, 1 (we only have one of something now) 
        * But we start with the biggest
        * 64 is too big, but we need to start with 32 = 2^5
        * So we then go to 2 = 2^1
        * Then 1 = 2^0
        * 100011 	32 + 2 + 1
    * Learn up to 2^10 power 
* Alternative is to use division
* 2/35 = 17 R1 then keep going down
* 2/17 = 8 R1
* 2/8 = 4 R0
* 4/2 = 2 R0
* 2/2 = 1 R0
* 1/2 = 0 R1
* Then read backwards -> 100011 if you’re writing in 8 bits then its 0010 0011

This is essentially bitshifting to the right which divides by 2

123 x 1000 you just add the 3 0’s at the end of 123 to get 123000 123.000 -> 123000.

123/10 = 12.3  123. -> 12.3



* 60B10 -> b16
* 16^2 16^1 16^0
* 256 16 1
* 3x16^1 = 48
* 12x16^0 = 12 = c
* 3C more different way then the dividing method


### Example program

In C when you write int x = 35;

You allocate memory, then say interpret those bits as an integer, 


### Side notes

(gonna start needing to bring RP4B to class) (do we need to bring RPI to class?)

Tip: plug the pi right into the pi, and then hook the desktop to the router with linux, he basically ran it headless (not hooking a monitor but running it through ssh) 

He usually works from CML. Editing files on one side and running from another. 

Nmap (tool on linux) 

Nmap - sn 192.168… 

Shows all devices


## Storing 



* If you stack files to keep them the same way,
* Bits do not have address, but bytes have address
* Storing 32 bits, aka 4 byte int
    * And store it at |RP00| RP01| RP02| RP03|
    * Which part goes where?
* 1 hex digit = 4bits
    * 0, 1, 10, 11, 100, (binary)
    * 0, 2, 3, 4 … F (hex)
    * 0x12345678 (what is endian)
* By default in RPI the processor is little endian
    * The low order bit would be 8 on 0x
    * And 1 is the high order
        * Little endian reverse the bytes, but the bits stay in order
        * | 78 | 56 | 34 | 12 | thats how its stored,
        * Then when u use it for math, it puts it back into correct order
* If you have a big endian computer
    * Then things are in the order you expect
    * Big end is first stored like put big end first
        * 12 | 34 | 56 | 78

A string in C is null terminated array of Chars



* We swap the bytes keep the bits in the same order, bits stay as pairs and bytes get swapped (ofc it gets stored as binary but we get it displayed as hex to visually see it easier)
* We also put the null or 0 at the beginning when storing bits/bytes
* Bits do not inherently have particular meanings, its based on context

Itroply standard

C calls it a float (a single precision floating point number, has 4 bytes or 32 Bits

In this example all four representation of the bytes are the same but the bits represents something different.



* Professor likes python
* Because its dynamically typed x=5, it says its a 5


### In C assigning variables and types

Float x; //what is this doing?



1. Allocate memory for 4 bytes
2. Interpret the bits as a single precision floating point number
* Internally 0’s and 1’s don’t necessarily exists, but its just states that can represent a lot of things

Int y; (interprets this as a signed integer)



* Allows you to represent positive and negative ints
* You split the bits between pos. 0, neg.

Never can have an infinite number of Bits


## ASCII to memorize.

All in base 10

32 = space

48 = ‘0’ (zero character)

65 = ‘A’

97 = ‘a’

Luckily ik most of it



* Char is a type of int
* Original ASCII required 7 bits
    * Shows you values of 0 - 127 base 10
* When using cat to open binary files, it will represent some of those bit patterns as extended ASCII, all it is, is just states of 0 and 1

       2^6 2^0

65 = 64 + 1 	01000001 = ‘A’

2^5 = 32 	01000010 = ‘B’

2^6 = 64	01000011 = ‘C’

2^7 = 128


## Storing a Char

When we do
```
Char a[] = “ABC”;  &lt;- hidden “\0” = NULL 



* We are telling C its a null terminated array

      ‘A’                ‘B’             ‘C’           ‘ \0’

|01000001|01000010 |01000011 | 00000000 |

2^31  2^24 2^23  2^16 2^15  2^8 2^7     2^0
```

2^31 = abt 2 billion (which is technically not the value of this)

This fits into 1 byte because its a char



* When you’re a network programmer, if you have big and little endian coms. You have to figure out how to stack it

C thinks its stored like this (in little endian i think)

&c -> ‘\0’ ‘C’ ‘B’ ‘A’



* Printf needs format specifier because it doesn't receive the data type information which is why we use %s, %d %c %p
* When printing an int as a string you need the address of the integer, to print it as ABC
* All 4 cases had same exact bit pattern but were interpreted differently each
    * Same thing for a short, long
* There are no 0’s and 1’s its just a representation


## Representing numbers

Theres numbers you cant represent



* Double x = 0.1; (you cannot store this exactly in binary
* Same thing as ⅓ = 0.333.. (takes an infinite number of threes in base 10)
* In base 3: (⅓)10 = (0.1)3

We can represent 0.5, and 0.25, its just a base thing that can be easily represented in a finite characters.



* They dont have fractional dollars they have cents
* $1 = 100 Cents
* $1.23 = 123 Cents 
    * Just change it to something you can represent

We interpret States


## Minimum bits to represent something

If we have A and B, both ints

A has 3 digits

B can between 2-4 digits

99 &lt; a &lt; 1000 

87 &lt; b &lt; 2033



* We can say that A has 3 digits because the boundaries are 2 digits and 4 digits
* But B’s boundaries dont restrict it. To a single confirmation of how many digits it has

13 base 10 requires ? bits

2^0 - 2^3

Has to be within  4 bit range

Now if you’re storing this in a data type, you have to start to think about your ranges

2^n -> n + 1 bits (helps to memorize)

2^3 -> 3 + 1 bits

2^20 = abt a 1m

2^19 = 500,000


## Representing Negative numbers

-5.75 base 10

- 101.11 base 2 (if we grew up learning binary, but pc’s dont have - and .)

The computer represents it as a bunch of bits 1001100101

How do we represent negative numbers?


## Signed Magnitude



* Using 3 bit ints

000 we use 1 of the bits at the left end (the leading bit high order is the sign)



* Bit = 0 -> non negative
* Bit = 1 -> negative
* Unsigned means we dont need a negative number

Base 10 unsigned is 1 - 7

unBold is pos. bold is neg with signed magnitude
```
       Unsign 	signed

000	 0 	  0

001 	1            1

010 	2            2

011 	3            3

100 	4           -0

101 	5           -1

110 	6           -2

111 	7           -3

011 = +3

111 = -3
```

One of the problems with this is that we do have negative 0



* In C, the default is signed int
* If you do unsigned int x;
    * Your negative numbers wont work
    * Only used to represent positive numbers


## One’s Complement



* When you add them together you get all 1’s in binary
```
       Unsign 	signed    Ones complement

000	 0 	  0		0

001 	1            1		1

010 	2            2		2

011 	3            3		3

100 	4           -0		-3

101 	5           -1		-2

110 	6           -2		-1

111 	7           -3		-0
```

Shortcut for one’s complement



* Flip the bits
    * Nonneg: 1011 B2 = 11 B10
    * Neg: 0100 B2 = -11 B10
* We dont use 1’s complement 

In reality we are doing this

A + (-a) 11…1

N bits   n bits

011 = + 3

 111

-011

—---

100

Its ultimately adding certain bits to get a negative number


## Two’s complement



* Doesnt have a negative 0

Shortcut for Two’s complement



* Flip the bits
* Add 1

001 (flip)

110

110 + 1 (add 1)

111

Whats really happening

A + (-a) = 10….0

N bits       n + 1 bits

(exactly the same whether we talk abt base 2 or base 10)

011 + (-a) = 1000

1000 - 011

111 + 1 - 001

111 -001 + 1



* Two’s comp. Representation 
* -1 will be the pattern that consists of all 1’s
* -1 in 2’s comp is 8 bits, or however many you need
* This restricts to 1 less positive number

```
       Unsign 	signed    Ones complement Two’s comp.

000	 0 	  0		0			0

001 	1            1		1			1

010 	2            2		2			2

011 	3            3		3			3

100 	4           -0		-3			-4

101 	5           -1		-2			-3

110 	6           -2		-1			-2

111 	7           -3		-0			-1

It allows you to get 0 when subtracting the same numbers and not -0

Twos complement gives you additive inverse in binary

A + (-a) = 0

```
