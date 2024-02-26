# Cse2312 Computer Organization and Assembly Language Programming


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


## Example program

In C when you write int x = 35;

You allocate memory, then say interpret those bits as an integer, 


### Side notes

(gonna start needing to bring RP4B to class) (do we need to bring RPI to class?)

Tip: plug the pi right into the pi, and then hook the desktop to the router with linux, he basically ran it headless (not hooking a monitor but running it through ssh) 

He usually works from CML. Editing files on one side and running from another. 

Nmap (tool on linux) 

Nmap - sn 192.168… 

Shows all devices


### Storing 



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


### ASCII to memorize.

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


### Storing a Char

When we do

Char a[] = “ABC”;  &lt;- hidden “\0” = NULL 



* We are telling C its a null terminated array

      ‘A’                ‘B’             ‘C’           ‘ \0’

|01000001|01000010 |01000011 | 00000000 |

2^31  2^24 2^23  2^16 2^15  2^8 2^7     2^0

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


### Representing numbers

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


### Signed Magnitude



* Using 3 bit ints

000 we use 1 of the bits at the left end (the leading bit high order is the sign)



* Bit = 0 -> non negative
* Bit = 1 -> negative
* Unsigned means we dont need a negative number

Base 10 unsigned is 1 - 7

unBold is pos. bold is neg with signed magnitude

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

One of the problems with this is that we do have negative 0



* In C, the default is signed int
* If you do unsigned int x;
    * Your negative numbers wont work
    * Only used to represent positive numbers


### One’s Complement



* When you add them together you get all 1’s in binary

       Unsign 	signed    Ones complement

000	 0 	  0		0

001 	1            1		1

010 	2            2		2

011 	3            3		3

100 	4           -0		-3

101 	5           -1		-2

110 	6           -2		-1

111 	7           -3		-0

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


### Two’s complement



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


### Nines complement

+123

 999

-123

—---- 

876 &lt;- (-123)

A + (-a) = 999…

Pascals calculator


### Tens complement

2 digit integer in tens complement


<table>
  <tr>
   <td>0
<p>
1	99 = -1
<p>
2	98 = -2
<p>
3	97 =-3
<p>
.
<p>
.
<p>
.
<p>
48	52 = -48
<p>
49	51 = -49
<p>
	50
   </td>
   <td>What is -3?
<p>
99
<p>
-3
<p>
—
<p>
96
<p>
+1
<p>
—
<p>
97 = -3
   </td>
   <td>Base 10
<p>
23		99
<p>
-25		-25
<p>
—-		—-
<p>
-2 		74
<p>
		+1
<p>
23		— 		99
<p>
+75		75		-98
<p>
98				1 + 1 = 2
   </td>
  </tr>
</table>



## What happens when we compile in our computer

Gcc file.c

-> a.out

File.c - - preprocesser - - > |”File.i” - - compiler – > file.s - - Assembler - -> File.o (object file) - - linker - - >



    * Inside we have a=b+c
    * #include &lt;stdio.h> #define MAX 4 (are all preprocesser flags)
        * Basically saying hey i need this stuff for my code (essentially a search and replace)
        * Int printf(const *s, …) &lt;- Variadic function
    * When you write printf(“x = %d”, x);
        * Then write printf(x = <span style="text-decoration:underline;">%d</span>, y = <span style="text-decoration:underline;">%f</span>”, x, y);
        * The reason why we have format specifies because the function doesnt know what you’re asking of it, it goes through the string and looks at these flags to see what data types it needs.

<span style="text-decoration:underline;">Fake</span> Assembly for file.s (made by the compiler)

a = b+c; -> 

LDR R3, b

LDR R5, c

ADD R1, R3, R5 - - ->(FAKE) machine code1100(opcode) 0001(R1) 0011(R3) 0101(R5)

STR R1, a

/\ 

||  mnemonics 



* Cpus have little areas of storage called registers like R3, R5,
*  we put things from memory into cpu registers,
* The cpu has an ALU which does the addition part of bit patterns
* There is an object file called printf.o which is linked together by the linker and the errors get resolved

The problem is that all these computer cpu, that use certain processors and different companies have different assembly and bit patterns for their computers.

Gcc File.c -S (does the compiling but not assembling or linking, produces file.s)



* In x86 the machine code can be from 1 byte to 8 bytes
* While ARM is 32 bits? Or bytes cant remember

INTEL CISC 



* Complex construction set computers ( came first, more mnemonics and specific )

ARM RISC



* Reduced construction set computers

The <span style="text-decoration:underline;">Instruction Set Architecture</span> (ISA)



* For a processor consists of the supported machine instructions, The registers the processor will have, how memory is addressed, data types and so forth.
    * What will be the machine instructions be add, subtract, shift the bits

32-bit Raspberry Pi



* Support the ARMv7 
* 16, 32 bit registers, with names R0, R1,...,R15
    * R0 - R12 are general purpose
    * R13 stack pointer or (SP)
    * R14 link register (LR)
    * R15 Program counter (PC)

We will stand alone assembly programs, and functions in assembly called from a c program

Starting off with the basic


## Stand alone assembly programs


### The skeleton

.global _start

_start: 



* Code goes here

	Mov R7, #1

	Swi 0

Mov R7, #1 }

Swi 0 	       } exits the code, its a software interrupt

1 exit

3 read 

4 write

Mov r7, #3 (means go to register 7 and read)

(this is like our main func.)

(different comment styles for compilers)


#### Comments

Keil (compiler that uses ; for comments)

@ symbol for comments

/* for multi line comments*/

// and slash slash for comments



* Assembly is not case sensitive 
    * r0 R0
    * add ADD


### assembly deffinitions

mov Rd, Ra or constant 

		Immediate in assembly terms 



* Essentially you want to move a constant in Rd
* mov r5, #18

ADD Rd, RA, Rb or constant



* Rd = Ra + Rb
    * Rd = Ra + Constant
* A = b + c, in c
    * A = b + 14

SUB Rd, Ra, Rb or constant



* Rd = Ra - Rb

ARMv7 cheatsheet or textbooks professor told us about



* Prof. uses vim, so i will use vim

Exit: (used to exit out of loops)

Alias log = ‘ ls -logtr’

As -o ex1.o ex1.s

Ld ex1.o

./a.out

Echo $? -> gives value as an 8 bit unsigned int 

./a.out ; echo $?

Echo $SHELL

Bash (born again shell)

Endianness doesnt matter for this here

[https://thinkingeek.com/2013/01/09/arm-assembler-raspberry-pi-chapter-1/](https://thinkingeek.com/2013/01/09/arm-assembler-raspberry-pi-chapter-1/) 

Starting assembly 


#### Hw1



1. Show work to get a grade
2. If you have multiple pages, staple the pages if you don’t, then prof. Will staple and take 10 points off

C standard 1989 &lt;- not tied to two’s complement



* Char 	1 byte -> -127, 127 
* Short	
* Int at least 2 bytes 
* Long

Stdint.h (has these definitions in C99)


## Doc s

Mnemonics are located in the files section of canvas

Add Rd, Rn, Op2 

Gcc -o outName File.c

gcc File.c -o outName -g


## Tools

Also cheat sheats too

And tools


## Bit ranges

What are the ranges?



* For n bits 2^n bit arrangements (for unsigned)
    * For n = 3, 2^3 = 8 bit arrangements 0,1,2…8-1 = 7 ->  2^3 -1 
    *  2^n-1
* 2’s comp. 
    * 3 is max, min is -4
        * -4, -3 … 0, 1, 2, 3 
    * When we say we are gonna have a signed int for twos comp. We loose a bit to represent the sign, still have 2^3 bit arrangements but we cut all the representation in half for pos. & neg.

<table>
  <tr>
   <td>
3 bit in
<p>
000
<p>
001
<p>
010
<p>
011
<p>
100
<p>
101
<p>
110
<p>
111
   </td>
   <td>Unsigned
<p>
0
<p>
1
<p>
2
<p>
3
<p>
4
<p>
5
<p>
6
<p>
7
   </td>
   <td>Signed 2’s comp.
<p>
0
<p>
1
<p>
2
<p>
3
<p>
-4
<p>
-3
<p>
-2
<p>
-1
   </td>
  </tr>
</table>



<table>
  <tr>
   <td>
   </td>
   <td>Min
   </td>
   <td>Max
   </td>
  </tr>
  <tr>
   <td>Unsigned 
   </td>
   <td>0
   </td>
   <td> 2^n - 1
   </td>
  </tr>
  <tr>
   <td>Signed two’s comp
   </td>
   <td>-(2^n-2) 
   </td>
   <td>2^n-1 - 1
   </td>
  </tr>
</table>


C char



* Where 1 byte = 8 bits and use twos complement
* 2^8 = 256 bit arrangements
    * Half of that is 128 which non neg is 127 because we start at 0
    * -128, …, -2, -1, 0, 1, …, +127

Word = 4 bytes (on 32bit machines, but on a PDP-10 the word is 36 bits)


## AND, ORR

In C



* Logical operators
    * A && B
    * A || B
* Bitwise
    * A & B
    * A | B
    * A ^ B

0 = false

Nonzero numbers = true

A = 3.4;

B = -7;

If (A && B) &lt;- (3.4 && -7 ) is true in C

A = 3; 0011

B = 5; 0101

          0001 And

          0111 orr

          0110 eor

(same thing as multiplying by 2)

0011.

&lt;-

0011 &lt;< 1

00110.

(same thing as dividing by 2)

0011. 

->

0011 >> 1

Computers are built around clocks, 4.8 gigahertz is a clock like 4.8 billion cycles, you measure things that take clock cycles.

In C

A = 5*1024; &lt;- 2^10

(turns into a = 5 &lt;< 10;) it takes a shortcut because its more efficient)


## Debugger

Profess. Likes to use the “old mans” debugger which is just print statements

To use debugger,

We need to keep debugging information (or flags)

as -o outName.o inName.s -g &lt;- debug flag

Ld outName.o -> a.out

gdb outName

break _start

Info r &lt;- lets you see registers

Layout r &lt;- prof. Uses this the most (focus r, focus cmd

Step 

Quit


### RPI in class

    .global _start

_start: 

	Mov r1, #3

	Mov r2, #4

	Mul r1, r2, r1

_end: (not required ,but the mov and swi below is Required)

	mov r7, #1

	swi 0

as -o ex1.o ex1.s -g

Ld ex1.o

Gdb a.out

In gdb

Layout r

B _start

Run

Then use step

Out of gdb

objdump -3 a.out > out.txt

>> appends to file

> makes and overwrites a file.

(mul r1, r1, r2 gives a warning, so don’t do it that way)

History | grep SHELL 

-> basically tells you what commands were used with shell previosly

| = pipe


## Assembly Opcodes meanings

MUL Rd, Ra, Rb	 ==	 Rd = Ra * Rb

MLA Rd, Ra, Rb, Rc 	== 	Rd = Ra * Rb + Rc (Rd and Rc can be the same)

AND Rd, Ra, Rb or const 	 ==	 Rd = Ra & Rb &lt;- C style (bitwise and)

ORR Rd, Ra, Rb or const	 == 	Rd = Ra | Rb (bitwise or)

EOR Rd, Ra, Rb or const	 ==	 Rd = Ra ^ Rb (exclusive or)

LSL  Rd, const  	== 	Rd = RA &lt;< Const (logical shift left, or bitshift left) 

	Or

LSL Rd, Ra, Const  	

LSR Rd, Const	== 	rd = Rn >> Const   (logical shift right, or bitshift right)

	Or 

LSR Rd, Ra, Const

LSL = logical shift left / logical shift right LSR

ASR Rd, const

ASR Rd, Ra const

ASR = Arithmetic shift

ROR Rd, const

ROR Rd, Ra, const

ROR = rotate right

Rd = |A|B|C|D|

LSL RD, #1



* Rd = |B|C|D|0|

LSR RD, #1



* Rd = |0|A|B|C|

ASR RD. #1



* Rd= |A|A|B|C| (adds the most significant bit aka left most bit) 
    * Theres no ASL because it would be the same as LSL

ROR Rd, #1



* Rd = |D|A|B|C| (simply wraps the bits around)

Two’s comp num 

0111 >> 0011 but if it was a negative number

1100 >> would make it pos. But what asr does 1100 -> 1110 (introduces the 1 bec. Its most sig. bit)



* In assembly bit shifting happens a lot, either implicitly or explicitly 

5 &lt;< 2; (three parts of this in c)

12 bits are three combinations of that process

There was a time this was illegal



* MUL Rd, Rd, Rb
* Rd = Rd * Rb
* Illegal to have first two be the same
    * C style 
    * y *= b;

MLA 



* Multiply and accumulate 
* Mla R0, R1, R2, R0 -> a= a+3;


### C program

Gcc -S file.c 

Vim file.s

Dont do that

Instead..

Gcc -c file.c

Objdump -d file.o

(now it tells us more of our logic in our file)

You have to have addresses with lines of machine code, the OS decides it ultimately. Memory could be the same way, theres some required but some arent. 



* What we care about are offsets
* The problem is 1 million base 10 cant fit into a 12 bit pattern, so how does it store it
    * What it says with the .word is to store into the memory and be machine instruction
    * You take this one and shift it over by 20 places to get 1 million
        * 0x1000000
    * If you take a 1 and shift it over by 40 to get about a billion
        * 00….00101
        * ROR #1
        * 100…010
* If you do mov R!, #1040000 (can get error message for the number being too big)
    * But you can do this instead R0, r1, LSL #4 (you tell the computer to shift it to make it fit that number in way, not changing r1)
    * Its like saying a = 3*b in c B is not being changed.
* Take a small bit pattern, and preform a shift, and by some amount to get


### Why do we need bitwise operations



* They show up a lot of network operations
* If we have a lot of lightswitches 
    * You can just flip them on and off individually
    * But with bits we interact with them all, but not individually
    * I.e. 1011 & 0010 = 0010 (we have to do bitwise operators to get bit patterns we want)
    * 1011 | 0010 = 1011 

Enum bln {F, T}; &lt;- creates boolean data type in C yourself really means 0, 1



* What bit pattern and operations can get you to do what you want


## Computer Arithmetic

When adding bits, 

0 +0 = 0, 0 +1 = 1, 1+0 = 1, 1 + 1 = 0 carry the 1 after: 10

(negative numbers are almost always twos comp. Now unless said otherwise)


<table>
  <tr>
   <td>
        1011
<p>

        0101 + 1
<p>
(the caryout 1| 0000
   </td>
   <td> 3 bit signed ints.
<p>
   -2              010
<p>
+ -3     flip    101
<p>
         Add 1| 110 = (-2
   </td>
  </tr>
  <tr>
   <td>011
<p>
100 flip
<p>
    1 +
<p>
101 = -3
   </td>
   <td>110
<p>
101
<p>
011 &lt;- overflow
   </td>
  </tr>
</table>


Certain flags we can set to help us out


### The Arithmetic Logic Unit (ACLU)

Is the part of the central processing Unit (CPU) that preforms arithmetic, bitwise operations, and shifts.

Overflow is defined as adding two pos.

To get a neg. Or two neg to get a pos.

In this sense

Sometimes you do get zero and theres An actual flag for that

When writing C code

If (x == 5)

In assembly 

	X-5  (if you get a 0 its equal) (if x was 5, x-5 would be 0 which is true)


### Current Program Status Register (CPSR)


<table>
  <tr>
   <td>Bit position
   </td>
   <td>31
   </td>
   <td>30
   </td>
   <td>39
   </td>
   <td>28
   </td>
   <td>27… S
   </td>
   <td>7
   </td>
   <td>6
   </td>
   <td>5
   </td>
   <td>4…0
   </td>
  </tr>
  <tr>
   <td>meaning
   </td>
   <td>N
   </td>
   <td>Z
   </td>
   <td>c
   </td>
   <td>V
   </td>
   <td>reserved
   </td>
   <td>I
   </td>
   <td>F
   </td>
   <td>T
   </td>
   <td>Mode
   </td>
  </tr>
</table>


NZCV



* No zero can vary
    * N = negative -> 1 in MSB
    * Z = Zero -> REsual all zeros
    * C = Carry out -> results carried out past bit 31
    * V = overflow -> signed overflow
        * (+)+(+) = (-)
        * (-)+(-) = (+)

IFT



* Integers

How do we make these flags get set?



* When you do mov and it has an S 
    * An S means set the flags

CMP R1, R2(or Const)  –like→  SUB<span style="text-decoration:underline;">S</span> **R0**, R1, R2 **(doesnt say result**)

/\     	r1 - r2

Always sets flags in CPSR for CMP

TST R1, R2 –Like→ ANDS **Rd, **R1, R2 



* TST is a bitwise AND

We will use cmp a lot for loops and conditionals


```
	.global _start
_start:
	Mov r1, #3
	Mov r2, #4
	Mrs r0, cpsr

	Sub r1, r2 //should not change status register if it doesnt have an S at the end of sub
	Mrs r0, cpsr

Subs r1, r2
	Mov r1, #3
	Mov r2, #4
	Mrs r0, cpsr

Mov r1, #3
	Mov r2, #4
	

	Cmp r1, r2
Mrs r0, cpsr


_exit:
	Mov r7, #1
	Swi 0
```


As -o ex.o ex.s -g

Ld ex.o

Gdb a.out

B _start

Run

Layout r

Focus r

Copy cpsr to register 

MRS r0, cpsr  → Move status register into register taking cpsr and put it into r0, 



* used to not look at cpsr all the time

So whats going on



* 0x80 00 00 10
* The 8 = 1000
    * Or NZCV 
    * CMP -> 3-4 = -1
    * Triggered the negative bit

0xfffffff = -1 in twos comp

Just saying 32 bit 1’s 

_start:

	Mov r1, #3

	Mov r2, #3

	Mrs r0, cpsr	

	Cmp r1, r2

Mrs r0, cpsr

_exit:

	Mov r7, #1

	Swi 0

Cpsr gets 0x60000010



* Or top 4 bits have
* 0110
* Nzcv
    * Results in all zeros and didnt have to carry

while ( x &lt; 5 )

Cmp r1, #5


### TAR

Tape archives 



* basically packages your folder and the contents within

Hw02

	Writing an assembly program that does things


## geConditionals



* No if’s, for or while loops in assembly
* You build them yourself

B → Branch or jump to a different label

B<span style="text-decoration:underline;">LT </span>← condition w/ branch

Branch Less than 

ADD LT

MOV LT

Conditions in assembly



* EQ equal
* NE not equal
* CS unsigned higher or same
* CC unsigned lower
* MI negative
* PL positive or zero
* VS overflow
* VC no overflow
* HI unsigned higher
* LS Unsigned lower or same
* GE Greater than
* LT Less than

<span style="text-decoration:underline;">C Code </span>

If ( a &lt; 10 )

	B =5;

C = 10;

Fake assembly

CMP a, 10

LT, EQ, GE


## Pi vim cond.


```
/*
   R0 = 99
   R1 = 5

   If r1 < 10
      R0 = 123
   
   Return r0
*/
  .global _start
_start:
   Mov r0, #99
   Mov r1, #5
 
   Cmp r1, #10
   Bge _end /* we say its >= because thats the condition that skips over assigning a new value to r0 */
   Mov r0, #123


_end:
   Mov r7, #1
   swi 0
```



#### Overflow C code


```
#include <stdio.h>

Int main(void)
{
	Int i;
	Short x = 32766;

	For(i < 0; i < 10; i++)
	{
		printf("x= %hd\n", x);
	}
	
	Return 0;
}
```


Carry and overflows are both considered for overflows, they both flow out of their ranges.

If ( a&lt;10 )

   B = 99;

Else

   B = 123;

Return b;


### If else in assembly


```
/*
   R1 = 5

   If r1 < 10
      R0 = 9
   else
      R0 = 123
   
   Return r0
*/
  .global _start
_start:
   Mov r1, #5
 
   Cmp r1, #10
   Bge else
   Mov r0, #99
   B _end 

else:
   Mov r0, #123


_end:
   Mov r7, #1
   swi 0
```


In math

3 &lt; x &lt; 99

In programming

3 &lt; x and x &lt; 99

In c its legal to do this

x=numb.

If (3 &lt; x &lt; 99)



* What happens though
* It always evaluates as true
* It check 3 &lt; x which will always be true
* What you should write instead

If (3 &lt; x && x &lt; 99)

ADD {cond}{S}



* Mov
* Moveq
* Movs
* Moveqs

If ( a&lt;10 )

   B = 99;     → do if a &lt; 10

Else

   B = 123;  → do if not T

Return b;  

The trade off is that a branch can take cycle time, but it can also avoid looking at 20 different problems without one

If you care abt speed, dont do branches then


### Conditionals w/out jumps/breaks


```
  .global _start
_start:
   Mov r1, #5
 
   Cmp r1, #10
   movlt r0, #99 //mov if r1 < 10
   Movlt r2, #999 
   Movge r0, 123 // mov if r1 >= 10
   Movge r2, #1234
   Add r1, r2

_end:
   Mov r7, #1
   swi 0
```


Some things are alliased in assembly and in programming in general

When disassembling you won’t know which Allias that person used to actually type that program

Mov<span style="text-decoration:underline;">eq </span>aka → Conditional executing


## Loops


### Prof. Pet peeves



* The for loop is used when number of times known to run and while is used when its unknown
* Absolutes 
    * Things that are required to be a certain way
* Idioms or conventions
    * Expressions that dont translate literally
* Preferences

C gives you a whole lot of freedom on how you format it.


### Obfuscated C contest 

Code that works but is absolutely unreadable

Back to loops

For ( ; ;)

	;

Thats legal in C

Any or all of the 3 parts are optional


#### Difference between movw and mov

Mov R1, #999

Movw R1, #999

2^10 = 1024 = 11 bits

2^9 = 512 = 10 bits

101 &lt;< 3

999 takes 10 bits

Movw does not shift, but it devotes 16 bits to store!

With movw it stores that number exactly. You have a much greater range you can store but you have a bunch of holes in it.

Diff. between movw and movt



* Movt also stores 16 bit number
* Doesnt clear out what was previously stored in a register
* Combination of movw and movt allows us to put a specific 32 bit pattern into a register
    * Movw is lower 16 bits and movt is upper 16 bits

<table>
  <tr>
   <td>
<code>  .global _start \
_start: \
   Mov r1, #0xF0000000</code>
<p>
<code>   moww r1, #0x1234</code>
<p>
<code>   Movt r1, #0xABCD</code>
<p>
<code> \
_end: \
   Mov r7, #1 \
   swi 0</code>
   </td>
  </tr>
  <tr>
   <td>
   </td>
  </tr>
</table>



### Back to loops



* Writing this loop in assembly

Sum = 0;

i= 1;

While ( i &lt; 4 )

{

sum+=i;

I++;

}

First method is conceptional way

Second method is what is normally seen.

For the most part we use cmp nmemonics

But can use subs if needed



* Opposite of &lt; is >=

Conceptional way


```
  .global _start
_start:
   Mov r0, #0  @sum = 0
   Mov r1, #1 @ i = 1

Loop:
   Cmp r1, #4
   Bge _end
   Add r0, r0, r1
   Add r1, r1, #1

   b loop
 
_end:
   Mov r7, #1
   swi 0
```


They basically turned the structure to a do while loop except it doesnt run onces before testing

Do

{

	sum+=1;

	I++;

}

While (i &lt; 4);

In c you can use goto, but needs a label

Goto bottom;

Do

{

	sum+=1;

	I++;

Bottom:   ;

}

While (i &lt; 4);

This form is more standard



* Because we jmp to the bottom we will do the comparison we think we do

    ```
  .global _start
_start:
   Mov r0, #0  @sum = 0
   Mov r1, #1 @ i = 1
   B bottom
Loop:
   Add r0, r0, r1  @ sum = sum + i
   Add r1, r1, #1 @ i++ can be written add r1, #1

bottom:   
   Cmp r1, #4
   Blt loop
 
_end:
   Mov r7, #1
   swi 0
```



Goto is frowned upon in C



* Because it creates spaghetti code

If you go to the trouble to write assembly you care about efficiency and performance reasons

Benefit to of the conventional over the intuitive way

Intuitive



* Cmp
* B over the body
* execute
* Then branch to top

If you did this cmp 100 times and the first 99 dont use b to bottom, you have to compare every time, basically doing the intuitive way double the branches

Conventional



* B to bottom → 1 time only
* Body
* Cmp
* branch if true to top

In this scenario we execute the branch half the amount of times as intuitive way



* Modern computers when they are pipelined try to get ahead, when it makes the wrong choice you can get branch penalty, where it guesses wrong.
* Convential way gets less branch statements and less penalties

Why should you learn assembly



* To understand assembly you need to know the machine better
* But to understand the machine better you need to know assembly

This class is about understanding the machine more than making efficient assembly code.


## Floating points

Floating-point numbers



* How do you store 12.345


### Fixed-Point Vs floating-point

Computer where int is 32 bits / 4bytes

Float is 32 bits

Int x;

Float y;



* What does this do?
* 1. Telling the computer how much space to allocate
* 2. How to interpret those bits
* This is how C does it usually

Python will assign the data type and space dynamically

A =5

b= 3.4

C = 5



* Most popular version of python is C python because source code is written in C
    * Someone wrote a lot of C code to avoid writing C code.
* Besides that someone still has to decide memory allocation and interpretation of bits


#### 4 digit non negative fixed-point number with this arrangement

XX.XX

00.00 \/

99.99 



* The issue with this is what if you want to use 100
* You cant because the decimal is fixed in the middle, and we didnt allocate for space of 100


#### For floating point numbers

100.0

5.680

19.79



* Can shift the decimal around

Mov r1, #F0000000 @ reason we can store this is because we shift bits around

Movw r2, #999

Fb16 = 1111b2



* Movw is fixed, you get exactly what you expect
* But with mov you get it changed
* Same with floating and fixed point

Scientific notation works the same, the 10^x x= the amt of decimals we shifted.

+1230.0 = 1.23 x 10^3



* Sign pos
* Exponent +3
* Mag 1.23

What we need to store



1. Sign
2. Exponent
3. Magnitude (if some form)

On computers floating point won the battle


### IEEE 754 Floating-Point Standard 

Basic idea

Steps



1. Convert to binary

-12.25 _b10

12 = 8 + 4 + 0 + 0

1100 _b2

0.25 

0.01 _b2

12.25 = 1100.01 _b2

-12.25 = -1100.01



2. Normalize (do this for normalized numbers)

-1.10001 x 2^3

(signed magnitude 0011 = +3 so just add 1 or 0 at the end to change it 1011 = -3)

Floating point standard needs:

Sign: 



* 0 for nonNegative
* 1 for negative

exp:



* Bias by adding 127 for single precision
* 1023 for double precision

Fraction

Mantisa



* Binary is unique among all the bases
* -**1**.1001 x 2^3
* The fraction for just the part right to the decimal point, we dont store the leading one because we know we can always add the one in the beginning to reconstruct the number

	  	  | # of bits				                                             |


<table>
  <tr>
   <td>precision
   </td>
   <td>sign
   </td>
   <td>exponent
   </td>
   <td>fraction
   </td>
   <td>total
   </td>
   <td>C keyword
   </td>
  </tr>
  <tr>
   <td>single
   </td>
   <td>1
   </td>
   <td>8
   </td>
   <td>23
   </td>
   <td>32
   </td>
   <td>float
   </td>
  </tr>
  <tr>
   <td>double
   </td>
   <td>1
   </td>
   <td>11
   </td>
   <td>52
   </td>
   <td>64
   </td>
   <td>double
   </td>
  </tr>
</table>


            Single               double

Aprox +- 10^+-38          +-10^+-308

Ranges



* You lose some precision with floats



<p id="gdcalert1" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image1.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert2">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image1.png "image_tooltip")




* This class we care abt the 3rd line floating point number

Floating point underflow



* Where the number becomes too small to represent
* So it just puts a 0 there

    ```
#include<stdio.h>

Int main(void)
{
	Float d = 0;

	printf("%f", 1/d);  //inf
	printf("%f", -1/d); //-inf
	printf("%f", d/d); // nan (not a number)
}
```



Steps for single percision



1. Convert to binary
2. Normalize (move decimal to leading number)
3. Bias exponent ( xponent +  127 and conv to binary)

+41_b10 → single precision C float



1. Convert to binary

41

32 16 8 4 2 1

+1 0 1 0 0 1



2. normalize

+ 1.01001 x 2^5



3. Bias exponent

5 + 127 = 132 (conv. To binary)

128 64 32 16 8 4 2 1

1     0   0   0  0  1 0 0 

Sign exp         frac

0|1000 0100| 0100 1000 0000 0000 0000 000

-12.625

12_b10 = 1100_b2

2^-1 = .1_b2 == .5_b10

2^-2 = 0.01_b2 == .25_b10

2^-3 = 0.001_2 == 0.125 _10

0.625

-.5 

.125

-.125

=0

0.625 _10 = 

.101_2

-1<span style="text-decoration:underline;">.100101</span>_2 x 2^3

3 + 127 = 130 = 128 + 2

1000 0010

1 | 1000 0010 | 1001 0100 0000 0000 0000 000

What is 

    0    | 1000 0100 | 1010 0010 0000 0000 0000 000

Sign     128 + 4         fraction → 1.fraction 

Pos.      132-127        **1**.1010001 x 2^5

              5 expont       +110100.01

                                    32 + 16 + 4   + .25 = +52.25

What is

      0 | 0111 0101 | 0000 0000 0000 0000 0000 000

Since frac. Is 0, its an int that is a power of 2

      64 + 32 + 16 + 4 + 1 = 117

      116 -127 = -10

1.fraction x 2^-10

1.0 x 2^-10 = 0.0009765625_b10 (exact)

What is ?

65536.0009765625_b10

2^16    2^-10

1000 0000 0000 0000. 0000 0000 01

Normalize

1.<span style="text-decoration:underline;">0000 0000 0000 0000 /\ 0000 000</span>0 01 x 2^16

Bias exponent

127 + 16 =143 = 128 + 8 + 4+ 2 + 1 

		   1000 1111

Underlined is 23 bits in it

0 | 1000 1111 | 0000 0000 0000 0000 0000 000 



* 32 bit single precision for 65536.0009765625 and 65536 is the same, if you want to store more you need double precision, aka more for fraction and exponent


### Issues with floating point



* If a float (in c) can represent numbers (ints or non ints) in the approximate range of +- 10^+-38, why not just used floats for everything?

32- bit unsigned

Int  ||||||||||||||||32 bit magnitude|||||||||||||||||||||||

Float |23 (+1) bits magnitude| 

12345 ← int

Vs

123x10^2 → 123 000 000 x 10^6 (can represent bigger ints but loose precision)



* Like the mov vs movw (mov is like float, and movw is like an int)
* Can’t represent all numbers as floating-point numbers.

Pi = 3.14159 …

⅓ = 0.333…

1/10 

(1/10)_b10 = (1/1010)_b2  2^-4 + 2^-5 + 2^-8 … (Can never store 1/10 in base 2, its infinite like ⅓ )


```
#include <stdio.h>

Int main(void) 
{
	Double x = 1/10.0;
	printf("%f\n", x/0);
	printf("%.30f\n", x/0);

}
```



## Exam will be 4 - 5 problems

What are the minimum number of bits to represent 9b10 as an integer? (technically you need addition info)



* Is it signed or unsigned

4b10 = 100b2 (works for unsigned, but if its signed)

	0100

	Need room for the sign, or just an extra bit



* There is 1 program on the test, here’s a program, and tell me what it does, whats the value at this point or at this point


### More on floating point numbers

**Why do we bias the exponent?**



* It makes it easier to order the numbers and see the actual sizes of the numbers
* Once you normalize and bias, all you need to do is look at the exponent to see how big a number really is

If we had 3-bit signed ints (2’s comp)

       Unsign 	signed    Ones complement Two’s comp.        Biased exponent

000	 0 	  0		0			0             4 100

001 	1            1		1			1             5 101

010 	2            2		2			2             6 110

011 	3            3		3			3             7 111

100 	4           -0		-3			-4            0 000

101 	5           -1		-2			-3            1 001

110 	6           -2		-1			-2            2 010

111 	7           -3		-0			-1            3 011



*  Floating point arithmetic is not associative

    ```
#include <stdio.h>
#include <math.h>

Int main(void)
{
	Float small = pow(2, -10);
	Float big = pow(2, 16);
	Float f;
	
	F = (small + big) - big;
	printf("%.23f\n", f);

	F = small + (big - big);
	printf("%.23f\n", f);
}

Output 
0.0000000000000000000
0.0009766562500000000
```



Big

1 0000 0000 0000 0000.0

Small

0.0000000000001

→ 0 x 10^1



* For a float when you start mixing things of huge differences of exponents then its too big/small to represent

    ```
#include <stdio.h>

Int main(void)
{
	Double d = 1/10.0;
      Float f = 1/10.0;

      If ( d == f ) //cant actually compare float to double, float gets promoted to a double to do said comparison
          printf("equal\n");
      Else
      {
          printf("d = %.25f\n", d);
          printf("f = %.25f\n", f);
      }
}

Output 
0.0000000000000000000
0.0009766562500000000
```


* So the float becomes a double, but what do we put in those spots, we dont know

    ```
/*
Y = (x -3) (x- 8 ) = x^2 - 11x + 24;
*/

#include <stdio.h>
#include <math.h>

Int main(void)
{
	Double y, x;

	For (x = 2.0; x < 10; x = x +.001)
	{
		y= x*x - 11*x +24;
		If ( fabs(y-0) < 0.001) // can be written as fabs(y)
			printf("x = %.15f, y = %.25f\n", x, y);	
	}
}
```



True y and estimated y



* True y is 0 
* In math lib, theres a floating point ab val, 
    * Allows you to say its close enough to zero to your rules
* The problem with this program if you’re trying to equate it to be 0 and it will probably not be 0.

To represent money

We can represent change as ints.

$1.23 = 123 cents


### Why does this stuff matter besides this course?

Most famous example of why this matters is the patriot missile failure, during 1st gulf war it kept track of it in 1/10 of a second in fixed point arithmetic.

24-bit 		24 bit

– - - 0101 . 110 - - - -

 	5.75

After the system ran for 20 hrs, they found out the skew was off so much that it couldn’t track a missile


## How to store, and retrieve things within memory

We have registers r0 - r15

We have ram 

x=5;

y=10;

z=15; //z = x+y

ALU (does the math) 

All of those units are tied together



* One of arms features is that its RISC
* And one of RISCS features its
    * load/store


### Pointers! 


```
#include <stdio.h>

Int main(void)
{
	Int d[] = {11, 22, 33, 44};
	Int i;
	int *p = %d[0]; //being explicit that we want the address of the 1st element of the array

	For ( i= 0; i < 4; i++)
		printf("%d\n". *p++);
}
```


*p<span style="text-decoration:underline;">++  </span>→ ++ is suffix postscript

If we had

A = ++b - c ++; //the postfix would go first

You can have a point like this ++*P++ //thats fun

What professor prefers


```
#include <stdio.h>

Int main(void)
{
	Char ac[] = {1, 2, 3, 4};
	Int ai[] = {11, 22, 33, 44};
	double ad[] = {111, 222, 333, 444};
	Int i;
	char  *pc = &ac[0];
      Int *pi = &ai[0];
      Double *pd = &ad[0];

	int *p = %d[0]; //being explicit that we want the address of the 1st element of the array

	For ( i= 0; i < 4; i++)
	{
		printf("%p = %c, %p = %d, %p = %.0f\n". Pc, *pc, pi, *pi, pd, *pd);
		Pc++;
		Pi++;
		Pd++;//makes it clear that we want to move the pointer
	}
}
```


When we add one to a pointer, we use


## Pointer arithmetic 



* Pointers will always be pointing to another data type, which will give the pointer a data type of xxx ptr xxx or int ptr int x then it will be told how far to move when to go to the next location in an array, since ints are 4 bytes apart.
* When you write assembly, we have to know what that means


## Addressing Modes

w/ writeback  LDR&lt; Rd, [Rn, offset]!     P++; x= *p; or *++p;

//this is the closest to the pointer arithmetic in assembly


```
#include <stdio.h>

Int main(void)
{
	Int ai[] = {11, 22, 33, 44};
      Int i;

	For ( i= 0; i < 4; i++)
		printf("%d, %d\n", a[1], *(a + i));
}
```


Objectdump default doesnt show the data section

Hexdump shows everything, but its not organized

LDR is a pseudo statement, the assembler decides what to really make out with it


### Demonstrating load register


```
/*
Demonstrate load register
*/

	.global _start
_start:
	ldr r1, =array @ get address of array and put it in r1
	ldr r2, [r1] @ dereference that address and get the value from r1
	
	ldr r2, [r1, #4]! @ takes 4 add it to r1, grab the value. if you want you can do this [r1, #-4]
ldr r3, [r1, #4]! 

_end:
	Mov R7, #1
	Swi 0

.data
array: 
	.word 11, 22, 33, 44

/*
Demonstrate load register
*/

	.global _start
_start:
	Ldr r1 =old
      Ldr r3, =new

      Ldr r2, [r1], #4
      Add r2, r2, #100
      Str r2, [r3], #4

      Ldr r2, [r1], #4
      Add r2, r2, #100
      Str r2, [r3], #4

_end:
	Mov R7, #1
	Swi 0

.data
old: 
	.word 11, 22, 33, 44
New:
      .space 16

X /4wd &array
```


Assume int a, x;


### Table of addressing modes

int *p;

<span style="text-decoration:underline;">Mode</span>				    C equivalent

Direct	    LDR RD, address (we almost never know the actual address)

	    LDR Rd, =label	     p = &a;

Indirect    LDR RD, [Rn] 	     x = *p;

Preindex  LDR Rd, [Rn, Rn]

                LDR Rdm [Rn, offset]   x= x(p+offset) //offset in bytes

			     #4

Post index

	LDR Rd, [Rn], offset	   x=*p;

	LDR Rd, [Rn], Ra	   p++;

LDR load register

Ldr dest, source

STR store register //same as ldr but reversed

STR source, dest

LDR and STR assume word size


    Ldrh &lt;- halfwords 


    ldrb &lt;- bytes


    Strb &lt;-bytes 

Big value:

.word 1 milion

2^20 > 1mil //computer read in this as too big and put it into memory to store it

1 million

2^30 > 1 bil


#### Data stuff

.word

.byte 15

.ascii “Some String”

.asciz “String with null” @ null terminated string

.space 100 &lt;- bytes

.space 50, 0xAB (fill each type) 

@ when doing .space you allocate space for bytes

.space 50, 3 &lt;-puts a 3 in each bytes

Lets say you write c code

Int *p = malloc(16); //allocates 16 bytes doesnt empty out 

Char *c

Double *d

Int d[10]; //store 40 bytes

calloc (4, 4) //#, size


### 	     Read write strings

R7 syscall (3 = read, 4=write)

R0 filepointer (0=stdin, 1=stdout)

R2 # of characters

R1 address of strings

Swi 0

//do this when to process the string and do another for the newline


```
.global _start
_start:
	Ldr r1 =string
	Mov r3, #65
	Strb r3, [r1]

      Mov r7, #4
	Mov r0, #1
	Mov r2, #11
	Swi 0

_end:
	Mov R7, #1
	Swi 0
.data
string:
/*1234567891012*/
.asciz "some string"
```


Output: Aome string

In gdb, doing x /bd &xxxx (examines data)


### Sign extension



* Storing numbers in bytes, with a room of 32 bits wont give us our expected value always, since if you store an 8 bit number in a 32 bit size, then there will be leading zeros
* With sign extension, we extend the sign or add the 1’s
    * Looks at most significant bits and extends it through

<span style="text-decoration:underline;">S </span>Stands for sign extension

LDR<span style="text-decoration:underline;">S</span>B(B for bytes)

LDR<span style="text-decoration:underline;">S</span>H(H for halfwords)

R3

|0xAB|0xCD|0x10|0x34|

STRB

|0x34|

STRH

|0x10|0x34| (pay attention to endianness, can be swapped around)


```
.global _start
_start:
	Ldr r1, =endian
      Ldrb r2, [r1]

      Ldr r2, =endian
      Ldr r3, [r2]
      Ldr r4, =half
      Strh r3, [r4]

_end:
	Mov R7, #1
	Swi 0
.data
Endian:

.word 0xab1234ef
Half:
.hword 0x0
```


X /wx &endian  → 0xab1234ef

X /4bx &endian → 0xef 0x34 0x12 0xab (how its stored in memory)

X /4bx &half → 0xef 0x34 0x41 0x13

X /2bx &half → 0xef 0x34



* Little endian swaps the bites


#### .space allocation

.space 50  → allocate with 50 bytes (does pad with 0s)

.space 100 0xa → allocated 100 bytes each with 0xa

.space 50 == .space 50, 0


#### X RISC VS CISC



* RISC 
    * is load store process
    * Register files we transfer with risc is almost instant
    * Transfer to alu to do math
* CISC
    * Can do math with register and mem
    * More complex

Reg and mem are both storage, all the work is done in the ALU

CISC						RISC

Mem1 = mem1+mem2;		LDR r1, mem1

					LDR r2, mem2

					ADD r3, r2, r1

					STR r3, mem1


## Functions

It uses the 


### Program counter

PC → R15 (Program Counter)

LR → R14 (Link Register)

Mov r1, #5 →stored in machine code 

How does it keep track of itself



* After processing, the program counter leaves itself there so you can go back to it
* Which is how we stay where we are when we do mov r1, #5 by using link register to store its value n program counter

    ```
	.global _start
_start:
	Mov r1, #3
	Mov r2, #9
	BL myadd (branch with link register)

	Mov r1, #30
	Mov r2, #25
	BL myadd

End:
	Mov r7, #1
	Swi 0
Myadd: @ this becomes a function now that we us BL and BX LR
	Add re3, r1, r2
	BX LR (Branch back and put what was in link register back into program counter to get back where we were!)
```



B == BAL (branch == branch always)



* Terminology ppl call it subroutine when switching lr and pc stuff


## Performance 

How to quantify Program Performance



* Speed → is this obvious
* 2 ways to quantify it

Users often care about time to perform a <span style="text-decoration:underline;">Single </span>task.



* This is called <span style="text-decoration:underline;">Latency</span>

An alternative is <span style="text-decoration:underline;">Throughput.</span>



* This is the number of tasks performed in a given amount of time

Latency = seconds / instructions = cycles / instructions * seconds / cycle<span style="text-decoration:underline;"> </span>

Throughput = instructions / second = instructions / cycle * cycle / second

Ex. 

Charles can carry one brick from A to B & then return to A in 1 minute total.

Ralphcan load a wheel barrow with 50 bricks & go from A to B, unload, and return in 10 minutes total.

		       			Latency		  	Throughput


<table>
  <tr>
   <td>Charles
   </td>
   <td>1min/brick
   </td>
   <td>60brick/hour
   </td>
  </tr>
  <tr>
   <td>Ralph
   </td>
   <td>10min/brick
   </td>
   <td>50*(60`/10) == 300 bricks/hour
   </td>
  </tr>
</table>



### Hw5 guidance



* Char *s = “Cat
    * String literal, cannot change it ( C terms)
* Turn int into chars
    * R1 = 15
        * “15\n” to be printed out

If ( ‘0’ &lt;= S[i] && S[i] &lt;= ‘9’)

==

If ( ‘0’ &lt;= S[i] )

	If (S[i] &lt;= ‘9’)

		//run process


#### How do we write subroutines?

_start:

	BL F1	@ 0xBF00

F1:

	//Store LR on stack

	BL F2

	//restore LR

	Bx LR

F2:

	BX LR

Push {LR}

Pop {LR}


#### Extract chars from ints

Iterations	Remainder

1		25 - 10 = 15

**2**		15 - 10 = **5**

2 iterations and a remainder of 5

“25”

Things to think abt



* #’s that divide evenly 
    * I.e. 30, there’s no remainder
* If a num is 1 digit
    * I.e. 6, needs to be inputted like 06


## Clock Cycles



* Most computers have a clock and instructions processed (in part) on clock cycles

3.8 GHz



* 3.8 billion Cycles / second

___**—**___**—**__



* **Clock period **is length of a cycle and is the inverse of frequency
* Clock period = 1/clock frequency


### Pipelining

Add r1, r2, r3

<span style="text-decoration:underline;">10011</span> **0100 **- -  - -

Add     r1    r2   r3



* Has 3 processes it does in clock cycles 
    * Fetch
    * Decode
    * Execute
        * Usually one leading to another

If a CPU has a clock frequency of 3ghz, then the period is 

1/3x10^9 = 3.33 x 10^-10 seconds

CPU Execution time =  (CPU Clock cycles for program) x (period of the clock)

Different instructions may take different number of <span style="text-decoration:underline;">Clock Cycles per Instructions (CPI)</span>



* Which is the average number of clock cycles per instruction for some code.
    * Generally a good idea to write your program to not have CPI so high
* One day look up someones real printf function


## More on CPI

Cycles per instruction

The compiler will always try to save on clock cycles by changing * and / to LSL and LSR &lt;< >>

Ex. We have a piece of code with the following clock cycle counts:

7      instructions take 3 cycles each

20	‘	‘	4	‘	‘

10	‘	‘	5	‘	‘

—-

37 total

What is the CPI for this on average??

CPI = 7(3) + 20(4) + 10(5) / 37 === 4.08 clock cycler per instruction

CPI really depends on the particular instructions used by a program, but we may have an average from common tasks. <span style="text-decoration:underline;">Think benchmarks</span>

Ex. computer A has a 4GHz processor 

And a CPI of 5

Computer B has a 3.5GHz processor

And a CPI of 2.

Which is faster, if we assume # of instructions = 1000 in each case?

CPU time = (#instrunctions)(CPI)(clockperiod)

Computer A = 1000(5)(1/4x10^9) = 1.25x10^-6 sec

Computer B = 1000(2)(1/ 3.5x10^9) = <span style="text-decoration:underline;">5.7 x 10^-7 sec - </span>Faster


### Make cpu faster?

How do we make this faster



1. Reduce instructions 
    1. processor architecture does more per instruction
    2. Better algorithm → CSE 3318
2. Lower CPI
    3. Shorter period → higher frequency

The Pentium 4 was released in 2000. It was expected to eventually scale to 10 GHz, but stopped at 3.8 Ghz, Why? 

The power wall → heat

Power is proportional ½ (capacitive load)(voltage^2)(clock frequency)



* One way to reduce this, is to reduce voltage, but too low of a voltage can lead to transistor power leakage 
    * Reach a point where elections could start bleeding through insulation
* Why are computers faster now?
    * We went from single core to multi core
    * CPU → |CPU1||CPU2|
    * Unicore multicore


## Patterson & Hennessy 

Eight Great Ideas of computer architecture



1. Design for Moore’s Law 
    1. Design for the future, not today
2. Use abstractions
    2. Groups of transistors → logic gates
    3. Groups of logic gates → store bits

Newton’s method for finding roots

sqrt()

Double f(double x, double t) 

{

	Double r = 1.0;

	While (fabs(r*r - x) > t)

	{

		 r-(r*r - x) / (2 * r);

	}

	Return r;

}



3. Make common case fast 
    4. → devote more resources to what is done more often
    5. → compression
        1. How does this work with tar cvzf
        2. C: create, V: verbose (show), Z: gzip util
        3. Lossy compression
            1. Like what happens when you watch a video
            2. 3.48729 … 578943201 gets thrown away
        4. Lossless compression
            3. Like what we do when we submit files to the professor
                1. ‘E’ represented in 7 bits
                2. ‘Q’ represented in 7 bits
                3. ‘E’ = 101
                4. ‘Q’ = 1001101011010
                5. Algorithms used to take priority of what needs more or less bits to be represented and in doing so it compresses items
4. Performance via parallelism 
    6. CPU: multiple cores
5. **Pipelining**: process multiple instructions simultaneously (major deal for this class)
        5. 3-stage pipeline
            4. Fetch
            5. Decode
            6. eXecute
        6. 
    7. SIMD: Single instruction, multiple data
        7. Get more done
            7. 32 bit adds a + b
            8. A [c 8bits][e][g][j]
            9. B [d]        [f][h][k]
6. Performance via prediction
    8. Branching
        8. Branch prediction, it will try to assume one is right
    9. Cache
        9. Very fast memory, not as big as registers
        10. Registers are fastest
7. Hierarchy of memories
8. Dependability via redundancy 
    10. RAID - Redundant Array of Disks
    11. Parity
        11. Even: data
        12.           1101 = 1
        13.           1001 = 1 (just tells you something is corrupted)
        14. If you have data split across harddrives when one crashes it can lead to problems
        15. Can have D1 and D2 as data, you can also have copies of it in other drives


### HW6

1310 prof: Shawn Norman Gieser

1320 prof: Donna French

// this will be relevant to the exam



* Questions on doing latency and throughput

Where would you want it take longer to do a process in computing?



* Password Hash
    * Pw = fish → ?2A4bz19 
    * Its good to be slow to negate brute force attacks
    * Hashing changes the value of the password
* In subroutines calling functions from C
* In register 0 it looks for the address

f(r0, r1, r2, r3) 

Returns like → r0 (32 bits) r1 (64 bits)

If you want to use r4-r8, r10, r11

You need to save those values

Easiest way to save is with stack

Push {R4}

Pop {R4} 



* Most likely will do this

Can do it like this too

Push {R4, R5, R3} (takes lowest number and puts it at lowest stack address

Pop { R4, R5, R3}



* Some people will do this instead of bxlr
* Push {LR}
* Pop {PC} 


### Practicing this 

.global _start

_start: 

	Ldr r0, =array

	—

End:

	mov r7, #1

	Swi 0

.data

Array: 

	.word 1, 2, 3

.global name_of_function

Name_of_function

	//r0’s array was passed in

	bxlr

	

Prog.c

#include &lt;stdio.h>

Int add(int a, int b);

Int main()

{

	Int x = 3, y = 4, z;

	Z = add(x, y);

	printf(“z = %d\n”, z);

}

Assemblypart.s

	.global add

/* input: R0 = int, R1 = int 

   Result: R0 = R0 + R1    */

Add:

	/*For this we just do add r0, r0, r1*/

Add r2, r0, r1

	/*Do stuff*/

	Mov r0, r2

	Bx lr

Gcc prog.c assemblypart.s -g


## (Processor) More details on the 

Processor→pipelining


### Schaum’s outline of computer architecture, nick carter



<p id="gdcalert2" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert3">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)


#### To execute an instruction



1. Processor <span style="text-decoration:underline;">Fetches </span>instruction from memory
2. Instruction is <span style="text-decoration:underline;">decoded</span>
3. Get relevant register values
4. Execute instruction
5. Write results to register file
* The program counter (PC) tracks the address of the next instruction to process.
* Pipelining are (mostly) just models


## Memory



<p id="gdcalert3" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert4">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)


## 3 stage pipeline



* Just a model
1. Fetch
2. Decode
3. Execute
* A form of parallelism 

Add r0, r1, r2

Add r3, r4, r0

Ex from patterson and hennessy 

EX1:

Add, r1, r2, r3



1. The instr. Pointed at by PC is <span style="text-decoration:underline;">fetched</span>
2. The PC is updated to the next instr.
3. Instruction is <span style="text-decoration:underline;">decoded </span>to tell us:
    1. We are <span style="text-decoration:underline;">adding </span>R2 & R3 and placing it in R1
4. Retrieve R2 & R3
5. ALU preforms add
6. Result written to R1

EX2:

LDR R1, [R2, #8]



1. Fetch instruction pointed at by PC
2. The PC is updated to the next instruction
3. Decode as “load value at R2 + offset address, put the value in R1”
4. Get value from R2
5. ALU preforms R2 + offset
6. Get value at this address
7. Store value in R1

EX3:

Beq next ← ( the label is stored as an offset )



1. Fetch instruction pointed
2. Update PC to next instruction
3. Decode as “Conditional branch”
4. ALU produces PC + offset
5. If relevant flags are set ( zero in this case )
    1.  PC gets new address


## Pipelining



* Classic analogy is an assembly line

We need 30 minutes to build something



1. Assemble parts to form machine ( 10 mins )
2. Paint machine ( 10 mins )
3. Add wiring ( 10 mins )
* All together it takes 30 minutes (or the latency is 30 minutes)

Inefficient process



<p id="gdcalert4" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert5">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)



<p id="gdcalert5" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert6">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)



* How long until machine x is complete

X / time	avg

1  30 min	30 min

2  40		40/2 = 20

3  50		50/3 = 17

4  60		60/4 = 15

5  70		70/5 

………………………

\/

As number of machines increases, the average time <span style="text-decoration:underline;">per </span>machine approaches 10 minutes

In our computer pipeline we use cycles



* In <span style="text-decoration:underline;">general </span>(not absolute) things happen on clock cycles
    * Fetch 
    * Decode
    * Execute
    * FDE



<p id="gdcalert6" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert7">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)



* Why not have lots of stages in piplining?
1. Not every stage really takes the same amount of time
2. Need buffers between stages → each adds time



<p id="gdcalert7" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert8">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)


### How to think about latency and throughput

Latency = time to do 1 thing 

sec/task, min/person transported, … etc 

Throughput = # of things done in some amount of time

How many tasks in 1 hr?

How many people in 1 hr?

Ver1

Mov

Mov

Mov

Add

Sub

Ver2

Loop:

	B loop

Ver2 executed more, actually infinitly 

100k ints 

O(Nlog2n)

Quicksort &lt;1sec

O(n^2)

Bubble sorts =43 min

1000 instructions (executed) 

Clock rate = 2ghz = 2 billion cycles / sec

2x10^9 cycles = 1 sec

1 sec / 2 * (2x10^9 cycles) 

Period = 1/f

1000 instr/task (cycles / instr) (cycles/sec)


## More on pipelining

3 stage pipeline model



1. Not all stages really take the same amount of time
2. Enabling pipelining adds some overhead
3. While the time to process one instruction remains the same, we increase the throughput

Some features of an instruction set architecture (ISA) make pipelining easier:



* These 3 features are characteristic of RISC processors
    * Reduced instruction set computer
1. Equal-length instructions
    1. If each instruction is the same length, it’s easier to  find the op code		<span style="text-decoration:underline;">1101</span>0011….1										add
    2. In x86 assembly → instructions are 1-15 bytes
2. Small number of instruction formats
3. Memory operands are only loads and stores
    3. Allows the execution stage to calculate the address to use in the following stage (assuming additional stages)
    4. 5 stage model pipeline
        1. 1) fetch
        2. 2) decode & get relevant registers
        3. 3) execute 
        4. 4) access memory
        5. 5) write results to registers

Good: pipelining improves throughput

Bad: increases conflicts



* Out of order processing 
    * Can process unrelated code at the same time


### How branches affect stuff

EX: 	

Cmp r1, r2

1	bgt next	← when you get to this, the pc has already gone

2	add r3, r3, #4  ← here

Next: (1) 

	Add r1, r1 #1

Which is next?

Assume no branch prediction



* Branch prediction is basically assuming it will branch (especially done in loops)

B bottom (no decision, always going to the bottom)

Decoding stage realizes this branch is unconditional



* It takes to the execution stage in the pipeline to see what a condition is true or false

1 mov

2 add

3 b 1

4 mov

1 cycle in a stage

F1|D1|X1|

    |F2|D2|X2|

    |    |F3|D3|X3|

    |    |     |F4|F1|D1|X1



* Red indicates it was false
* What it really should have done is a fetched 1 and start the pipeline again
    * It takes time to undo the mistake
* D3 decodes branch
* F4 flushes it because it was a unconditional branch
* F1 at the end, rescheduled the pipeline
    * Then the whole system gets a penalty

Cost: lose cycle fetching 

Cost = 1 normal cycles

	+1 penalty cycle

2 cycles for <span style="text-decoration:underline;">unconditional branch</span>

(this happens if you use this model and don’t have branch prediction)


#### Conditional Branches

1 mov 

2 subs

3 bne 2

4 ldr

5 mul 

F1|D1|X1|

    |F2|D2|X2|

    |    |<span style="text-decoration:underline;">F3</span>|D3|X3|

    |    |   ** |F4|D4|**

**                   |F5|**

		  |_F2_|D2|X2|

	**Loss**	       |F3|D3|X3

<span style="text-decoration:underline;">Underline: </span>decoded branch

**Bold: flushed F4, D4 and F5**

_Itali: reschedule_

Why is it different?



* Whole we do know it is a conditional branch in the decoded stage, we don’t know the final decision until the execute stage

Cost: 1 normal cycle

+2 	penalty cycles

—--------------------------

	3 total cycles cost

**This happens ONLY**

**If branch is taken**



* This is not true for unconditional branch because we always take the branch

Sample homework will be like

“Assume pipeline is full”

(use the average cost, assume that the pipeline is already benefiting from processing a new instruction)

C code

Sum = 0;

I = 1;

While ( i &lt;= 5)

{

	Sum += i;

	I++

}

Ver1

Mov r0, #0 @ sum

Mov r1, #1 @ i

Loop:

	Cmp r1, #5

	Bgt next

	Add r0, r0, r1 @ sum += i

	Add r1, r1, #1 @ i ++

	B loop

Next:

			Show cycle counts

Sum	i	cmp	bgt	b

0	1	1&lt;=5	1	2

1	2	2&lt;=5	1	2

3	3	3&lt;=5	1	2

6	4	4&lt;=5	1	2

10	5	5&lt;=5	1	2

15	6	6&lt;=5	3	–

	Done after sum+=i

Total cost: sum + i + cmp + bgt + b

For just the conditionals its 18 clockcycles

= 6 * 1 + 6 * 1 + 6 * 1 +(5 * 1 + 1 * 3) + 5 * 2 = 36 clockcycles for the whole program

What if we did the loop 100 times?

Let n = while ( i &lt;= n)

C(n) = (n + 1) *1 + (n+1) *1 + (N+1) * 1 + [n*1 + 1 * 3] + n * 2

C(n) = 6n + 6


## HW7

Calculate number of instructions cycles required to execute this program

Normal command cost 1

B cost 2

B → cmp cost 3

2nd q

Another program, find clock cycles and then find execution time in nanoseconds

3

Write 2 subroutines for a c file

1st routine

Count num x’s in a streak (repeated)

(will always end in a streak)

2nd routine

Going to shift a string by 5

Meaning

 123456

“Abc”

New string

“-----abc\0” (null already there dont type one )

“X”

“-----X\0” (it just shifts over X and null over by 5 spaces)


### Costs for programs to run

========================================================================

loop:


    Cmp i &lt;= 5


    Bgt next 


    Body


    B loop

Cycle count 36

Cost

c(n) = 6n+6

// two branches for every iteration

========================================================================

			Show cycle counts

Sum	i	cmp	bgt	b

0	1	1&lt;=5	1	2

1	2	2&lt;=5	1	2

3	3	3&lt;=5	1	2

6	4	4&lt;=5	1	2

10	5	5&lt;=5	1	2

15	6	6&lt;=5	3	–

	Done after sum+=i

Total cost: sum + i + cmp + bgt + b

For just the conditionals its 18 clockcycles

= 6 * 1 + 6 * 1 + 6 * 1 +(5 * 1 + 1 * 3) + 5 * 2 = 36 clockcycles for the whole program

What if we did the loop 100 times?

Let n = while ( i &lt;= n)

C(n) = (n + 1) *1 + (n+1) *1 + (N+1) * 1 + [n*1 + 1 * 3] + n * 2

C(n) = 6n + 6

========================================================================

Ver2


    Mov r0, #0


    Mov r1, #1


    B bottom

Loop:

	Add r0, r0, r1

	Add r1, r1, #1

Bottom:

	Cmp r1, #5

	Ble loop

========================================================================

			Show cycle counts

Sum	i	i&lt;5	ble	b

0	1	y	3	2

1	2	y	3	-

3	3	y	3	-

6	4	y	3	-

10	5	y	3	-

15	6	n	1	–

New ver

Cost = sum + i + b + cmp + ble

Cost = 6*1 + 6 *1 + 1*1 + 6 *1 + [5*3 + 1*1] = 35 cycles

c(n) = 6n+5;

========================================================================

Simplified pipeline model w/o branch prediction, almost identical in cycle count

========================================================================

 C

If ( x &lt; 3 )

{

	A = 4;

	b= 5;

}

Else

{

	A = 6;

	B = 7

}

========================================================================

Variable cost of statements based on what you skip and what you execute 

Ver1

	Cmp r0, #3

	Bge else

	Mov r1, #4

	Mov r2, #5

	B after

Else:

	Mov r1, #6

	Mov r2, #6

After:

Assume x = 2 

	Cmp = 1*1 = 1 cycle

	Bge = 1 * 1 = 1

	Mov = 2 * 1 = 2

	B = 1*2 = 2

6 cycles total

x=5

	Cmp = 1*1 = 1 cycle

	Bge = 1 * 3 = 3

	Mov = 1 * 2 = 2

6 cycles total

========================================================================

Fixed cost based on statements

Ver2 

	Cmp r0, #3

	Movlt r1, #4

	Movlt r2, #5

	Movge r1, #6

	movge r2, #7

Assume x = 2

Cmp 1*1 = 1 cycle

Mov 4*1 = 4 

5 cycles total 

(for this example this # does not change)

========================================================================


### **Warning:**

**If you intend to ask the compiler to optimize, then not everyone agrees on the programmer doing the optimizations.**



* All involved with pipelining


## Loop unrolling

Sum = 0;

For ( i = 0; i &lt; 3; i ++)

	Sum += 5;

===================

Mov R0, #0 @ i

Loop:

	Cmp r0, #3

	Beq next

	Add r1, #5

	Add r0, #1

	B loop

=================== or

Unroll the loop

	Add r1, #5

	Add r1, #5

	Add r1, #5 

(if we already know that it will run 3 times)


## Variation for arrays

<span style="text-decoration:underline;">Standard approach</span>

For (i = 0; i &lt; n; i ++)

	Sum += d[i];

=================== 

<span style="text-decoration:underline;">Partially unrolled</span>

For ( i = 0; i&lt;n l i+=2)

{

	Sum += d[i];

	Sum += d[i+1];

}

// assume n is even number


### Avoid:

**Repeatedly calculating something that doesn’t change**

For ( i = 0; i&lt; strlen(s); i ++)

	if( ‘0’ &lt;= s[i] && s[i] &lt;= ‘9’ )

		Count ++;

**Should do**

Int len = strlen(s);

For ( i = 0; i&lt; len; i ++)

	if( ‘0’ &lt;= s[i] && s[i] &lt;= ‘9’ )

		Count ++;

EX2

For ( i=0; i&lt; count; i++)

	Sum += i/sqrt(5);

**Replace with:**

Double s5= sqrt(5);

For ( i = 0; i &lt; count; i++)

	Sum += i / s5;


## Reduce calls to memory

(Caching may reduce the cost)

For ( i=1; i&lt;n; i++)

	D[k] += i; //k isn't changing

               //d[k] == *(d +k)

**Replace with**

Sum = 0;

for(i = 1; i&lt;n; i++)

	sum+=i;

D[k] = sum;



* Any non branch command treat as 1, else branch is 2, conditional branch is 3 or 1 depending on execution


## Interrupts and exception



1. Some authors treat the words as synonyms 
2. They alter the normal flow of the program
    1. Somewhat like a conditional branch, in terms of how they affect the pipeline



<p id="gdcalert8" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert9">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)

From Patterson p336


### ARMv8 uses these terms



* System reset → Exception
* (not bad) → I/O Device Request → interrupt
* Invoke O/S from user program → exception (like creating or removing directories)
* Floating-point over/under-flow → exception
* Undefined instruction → exception
* Hardware malfunction → Exception or interrupt

From Sloss, p 317 (20 y) 

“ARM defines an interrupt as a special kind of exception”


## <span style="text-decoration:underline;">Stack</span>

Common analogy → plate dispenser at buffet



<p id="gdcalert9" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert10">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)



<p id="gdcalert10" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert11">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)



<p id="gdcalert11" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert12">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)

Push {R1} 

Push {R2} 

Works the same way like how the functions being called looks 

(this is just a visualization of data)



* ARM allows you to create your own stack with an array, but we will use The Stack


### Stack models



1. When something is pushed onto the stack, do addresses increase or decrease?
    1. Increasing → addresses get bigger (# go up)
    2. Decreasing → addresses get smaller (# go down)
2. Where does the stack pointer point after a push?
    3. A full stack, if SP points at top value of stack
    4. A empty stack, if SP points at next available spot
* The Stack, ARM, is full, descending 



<p id="gdcalert12" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert13">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)


#### Examples

Ex.s

	.global_start

_start:

	Mov r1, #99

	Mov r2, #123

	Mov r3, #444

	Push {r1}  @ this is a shortcut of str r1, [sp, #-4]! But dont actually write this

	Push {r2}

	Pop {r3} @ takes what SP is pointing at and puts it into r3, then after change sp

End:

	Mov r7, #1

	Swi 0

In gdb

Info r sp (tells us sp, address and val)

X /wd address (examine as a word at this address)

This is legal

Push { R1, R5, R8}

Equivalent to…

Push { R5, R8, R1}

Equal to pushing R8, then R5, then R1

Lowest register numbers are pushed to the lowest addresses

Same logic applies when you pop

.global_start

_start:

	Mov r1, #99

	Mov r2, #123

	Mov r3, #444

	Push {r1-r3} (equivlent to push r1, r2 r3)

	

	Pop {R3} @ take r1 → r3

	Pop {R1} @ r2 → r1

	Pop {R2} @ r3 → r2

End:

	Mov r7, #1

	Swi 0



* func1(R0, R1, R2, R3, Stack(#5), Stack(#6))
* Which order is it?
* When you pop #5 it comes out first
* Then you can pop #6 to get to the last element


### Hw8

How he did shift by 2 left

A = {1,2,3,4} 

Means that we are copying

A= {3, 4,Extra1, extra2}

Shifts left by 2, and copies extra 1 and extra 2 where 3 and 4 were

If we have 4 values, how many are copied to a new position, **total amt - shift amt**

4 val - 2 = 2 copies

If we have a loop that goes through our array we only need to loop **copy amt of times **

In c terms

D[0] = d[[2]

D[1] = d[3]

d[2] = d[4]

We start at the beginning and have a count

A = {1, 2, 3, 4}

        0  1  2  3

We go to 1, when we are at 1 we only have 1 copy more to go, 4 - 3 = 1 away from next copy, then add one to that and then take the copy value and put in pos 0, repeat for next inst

So basically **Total amt -shift amt left + 1 = copy val**

Second func.

Count matches

Given 2 strings starting from left, we want to count how many consecutive chars match. For 2 strings being compared.

(we dont include null to the match)

(we dont restart the count after consecutive chars have already gotten a number.)

“abcdFEG” == “avcDFEG” ⇒ 4 char matching


### Example similar to hw

	.global _start

_start:

	bl sub

End:

	Mov r7, #1

	swi 0

sub:

	Mov r1, #3000000

	Mov r2, #0x5000

	Push {r1, r2. Lr}

___________________



<p id="gdcalert13" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert14">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)


## Cache



<p id="gdcalert14" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert15">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)

2012 values from Patterson


<table>
  <tr>
   <td>
   </td>
   <td>Tech
   </td>
   <td>Access times
   </td>
   <td>$ per gib ← Gib → 2^30 bytes
   </td>
   <td>Space requirements per sq inch
   </td>
  </tr>
  <tr>
   <td>cache
   </td>
   <td>SRAM
   </td>
   <td>.5-2.5ns
   </td>
   <td>$500-$1000
   </td>
   <td>Highest
   </td>
  </tr>
  <tr>
   <td>mem
   </td>
   <td>DRAM
   </td>
   <td>50-70ns
   </td>
   <td>$10-$20
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>usb/ssd
   </td>
   <td>flash
   </td>
   <td>5k-50kns
   </td>
   <td>$.75-$1.00
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>HDD
   </td>
   <td>Mag disk
   </td>
   <td>5m-20m ns
   </td>
   <td>$.05-$.10
   </td>
   <td>lowest
   </td>
  </tr>
</table>



<table>
  <tr>
   <td>1980
   </td>
   <td>64-Kibibit
   </td>
   <td>$1.5million/gib
   </td>
   <td>250ns Access time
   </td>
  </tr>
  <tr>
   <td>2012
   </td>
   <td>4-gigibit
   </td>
   <td>$1/gib
   </td>
   <td>35ns
   </td>
  </tr>
</table>


2^10 = 1024 != 10^3 = 1000

Kibi	kilo

Mibi	mega

Gibi	giga

Goal: appear to have, 

<span style="text-decoration:underline;">fast</span>, **cheap **memory

Tend to go in diff directions

How do we achieve our goal of appearing to have fast, cheap memory?

2 principles

For ( i = 0; i &lt; n; i++)

	<span style="text-decoration:underline;">Sum</span> = d[i];

Int d[] ={1,<span style="text-decoration:underline;"> 2</span>, 3, 4, 5, ,6 ,7, 8};



1. Spacial locality
* When you request #2, computer grabs all of those next to it in memory
    * Move from main mem → cache
2. Temporal locality 
* When you keep on calling sum a lot, we put in cache from memory. Because we will use it for a certain amount of time.
* Try to figure out what you need in near future and have it on hand


### Structuring cache

Our goal: Appear to have <span style="text-decoration:underline;">Lots </span> of <span style="text-decoration:underline;">fast </span>, <span style="text-decoration:underline;">cheap </span> **memory**



1. How do we structure our cache to support having (and finding) what we want in cache as opposed to slower storage?
    1. Direct mapping - every <span style="text-decoration:underline;">block* </span>maps to a specific place in cache
        1. *by <span style="text-decoration:underline;">block </span>we mean a unit of memory values, for example, 16 bytes of memory sometimes the term “Block” gets used differently.

Ex. Suppose our cache can store 4 words. 1 wrd is 4 bytes or 16 bytes



* In ARM words are stored in addresses ending in 0x00, 0x04, 0x08, 0x0C.
* **Pro**: Always know where in cache to look for something (where it will be if it’s there)
* **Con**: Only one thing that maps there, can be there at a time.
    2. Fully Associative
        2. Any block can be in any cache “slot” 
* **Pro: **a block is not restricted to any particular slot, So any combination of blocks can be in cache at the same time (Up to the limited cache size)
* **Con:** 
    3. N-way set associative
        3. Combination of direct mapping and fully associative.
            1. Cache is divided into sets and each set holds n blocks.
            2. Every block of memory maps to a specific set.
2. So if we are using set associative or fully associative, how do we decide what is replaced?
    4. Keep track of time since use and replace least recently used.
    5. Choose at random // our top priority is speed
3. When do cache values get written back to memory?
    6. Write-Through → when cache is updated, also update corresponding value in memory. 
* **Pro: **always in sync
* **Con: **Takes time
    7. Write-Back → Update memory only when the block in cache is replaced.

How do we quantify how well cache is being used?



*  When something we want is in cache, we have a <span style="text-decoration:underline;">hit</span>. Otherwise, we have a <span style="text-decoration:underline;">miss</span>.
* These ideas lead to a <span style="text-decoration:underline;">hit rate</span> and a <span style="text-decoration:underline;">miss penalty</span>.


### Average memory access time (AMAT) 

AMAT = time in Loc1 + time in Loc2 + … + time in locN

Weight average 

Absolute: %

Relative:  %

Ex. Suppose we only have L1 cache and RAM, with these values.


<table>
  <tr>
   <td>
   </td>
   <td>L1
   </td>
   <td>RAM
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Hit Rate
   </td>
   <td>90%
   </td>
   <td>10%
   </td>
   <td>← Absolute rates
   </td>
  </tr>
  <tr>
   <td>Total access times
   </td>
   <td>1ns
   </td>
   <td>100ns
   </td>
   <td>
   </td>
  </tr>
</table>


	0.9		0.1

AMAT = 90%(1ns) + 10%(100ns) 

=  0.9 ns + 10ns = <span style="text-decoration:underline;">10.9ns </span>

Ex.What if we add L2 cache, which accounts for 70% of the time not in L1? Assuming total access time = 20ns


<table>
  <tr>
   <td>
   </td>
   <td>L1
   </td>
   <td>L2
   </td>
   <td>RAM
   </td>
  </tr>
  <tr>
   <td>Hit Rate
   </td>
   <td>90%
   </td>
   <td>70%(10%) == 7%
   </td>
   <td>30%(10%) == 3%
   </td>
  </tr>
  <tr>
   <td>Total access times
   </td>
   <td>1ns
   </td>
   <td>20ns
   </td>
   <td>100ns
   </td>
  </tr>
</table>


AMAT = 90%(1ns) + 7%(20ns) + 3%(100ns) 

== .9(1ns) + .07(20ns) + .03(100ns) 

== 5.3 ns (nano seconds, or billionths of a second)


## Floating point (programming)


### Floating point registers



1. 

32, 32-bit fp registers with names s0, s1,...s31

D0 = s1, s0

D1 = s3, s2



* Can use D’s to do 64 big double floating point numbers
* If we use d0 we cannot separately use s1 because its already been used

D16 – d31 (Are only 64 bit doubles, this class we should never get that far to need to use them)

In C

	R0   r1	     s0

Float f(int a, int b, float c); 



* If its a float return in s0

For double

	d0

Double g()

CPSR and FPSCR (own floating point flag register)



2.  **<span style="text-decoration:underline;">Can store in memory using </span>**

        .float


        .double


Ex. 

.data

Pi: .float 3.14159



3. Have many of the same instructions 

    <span style="text-decoration:underline;">integer</span> 	<span style="text-decoration:underline;">fp</span>


    Mov		vmov		Sometimes have to add .{type}


    Add		vadd		ex. Adding 2 32bit floating point nums


    Ldr		vldr		vadd.<span style="text-decoration:underline;">f32</span> s0, s1, s2


    					.f32 means level of precision

4. **<span style="text-decoration:underline;">To convert</span>**

	vcvt .{dest type}.{source type} ← f32, f64, u32, s32



5. **<span style="text-decoration:underline;">Compare with </span>**

    Vcmp.{type} fp1, fp2


    Or


    Vcmp.{type} fp1, #0.0 ← only zero


    (you change the floating point flags, not int flags_


So if you do this

Bgt after ← its looking at the integer flags



* We just need to copy floating point flags to int flags
* Before we make that statement we need to write

Vmrs apsr_nzcv, fpscr 



6. Loads and stores 

    Vldr Fp, [int register]  


    → [r7] or [r3, #4] (the offset, but there is no saving) cannot do [r3, #4]! Or [r3], #4


    Vldr s0, [r3]


What do we do instead?

Can do this → add r3, r3, #4 (we manually add 4 to it)


### HW9

1st 3, calculate memory access time

Program, start learning how to do floating point avg

1st subroutine, given address to get hw num to get calculate avg of grade

Write another subrotuine of exam1 and exam 2 grade to get a 90 in class for the final

S0-s15 are passed in for floating registers


#### How to calculate the average?


<table>
  <tr>
   <td>hw
   </td>
   <td>e1
   </td>
   <td>e2
   </td>
   <td>final
   </td>
   <td>Letter grade
   </td>
  </tr>
  <tr>
   <td>25%(100)
   </td>
   <td>+25%(100)
   </td>
   <td>+30%(100)
   </td>
   <td>+20%(100)
   </td>
   <td>90
   </td>
  </tr>
</table>


(final) = 90 - 25%(100)-25%(100) - 30%(100) / 20%

Cant have a = b+c+d in assembly

(need to do partial sums)


#### Passing number

Passing 32-bit integers

F ( r0, r1, … , r3) → result = r0

Passing 32-bit single precision floating point number

g(s0, s1, … , 515) → result = s0

Combining these? 

–assembler figures it out

I.e. F( r0, s0, r1, s1) would be f( int, float, int, float)


### Mulby2 assembly 

.global mulBy2

mulBy2:

	Ldr r1, = constant  @ get address of floating point

Constant

	Vldr s1, [r1]	@ load floating - point constant

	Vmul.f32 s0, s0, s1

	Bx lr

.data

Constant: .float 2


### FloatMulbyInt

	/*Input: s0 = float, r0 = int  *

*return: s0, =s0  * r0         */

	.global mulFPbyInt

mulFPbyInt

	Vmov s2, r0 @ mov integer register value to FP register

	Vctv.f32.s32 s1, s2 @ convert from signed, 32-bit to fp

	Vmul.f32 s0, s0, s1

	Bx lr



* Do a lot of incremental development


### MulFPbyFP

/*Input: s0 = float, s1 = float*

*Result: s0 = s0 * s1          */

	.global mulFloatByFloat

mulFLoatByFloat:

	Vmul.f3 s0, s0, s1

	Bx lr


### MulDoublebyDouble

/*

input: d0, d1            

Result: d0 * d1 = d0 

Note: that d0 = s1,s0 and d1 = s3, s2

*/

	.global mulDoublebyDouble

mulDoublebyDouble:

	Vmul.f64 d0, d0, d1

	Bx lr


### Real roots

/*

	S0 = a, S1 = b, S2 = c, R0 = float* root1, R1 float* root2

	If we have { 1, -8, 15} // roots are : 3, 5

*/

	.global realRoots

realRoots:

	Mov r2, #0

	Str r2, [r0]	@ r1

	Str r2, [r1]	@ r2

	@ calculate discriminant

	Vmul.f32 s3, s1, s1 @ s3 =b^2

	Ldr r2, =four

	Vldr s4, [r2]  @ s4 = 4.0

	Vmul.f32 s4, s4, s0  @ s4 = s4 * a = 4a

	Vmul.f32 s4, s4, s2 @ s4 = s4 * c = 4ac

	Vsub.f32 s3, s3, s4 @ s3 = 5^2 - 4ac

	Vcm.f32 s3, #0.0 @ compare discriminat to 0

	Vmrs apsr_nzcv, fpscr @ copy fp flags to integer flags

 	Bxlt lr @ return if negative (imaginary roots)

	@ produce parts of expression

	Ldr r2, =two

	Vldr.f32 s2, [r2]

	Vmul.f32 s2, s2, s0 @ s2 = 2*a

	Vsqrt.f32 s3, s3 @ s= sqrt(s3) = sqrt(b^2 - 4 ac)

	Vneg.f32 s5, s1 @ s5 = -b

	@ caculate ( -b + sqrt(disc))/2a

	Vadd.f32 s4, s5, s3 @ s4 = -bt + sqrt (s3)

	Vdiv.f32 s4, s4, s2 @ s4 = s4/s2 = (-b + sqrt(discr))2/a

	Vstr.f32 s4, [r0] @ root 1

	

@ caculate ( -b - sqrt(disc))/2a

	Vsub.f32 s4, s5, s3 @ s4 = -bt - sqrt (s3)

	Vdiv.f32 s4, s4, s2 @ s4 = s4/s2 = (-b - sqrt(discr))2/a

	Vstr.f32 s4, [r1] @ root 2

	Bx lr

.data

Two: .float 2

Four: .float 4

//push and pop on stack (same stack ptr)

Vpush {s0}

Vpop {s1-s5} 


## padding



* Modern computers prefer addresses be a multiple of the size of the type

Individual variables

<span style="text-decoration:underline;">Size in bytes</span>		<span style="text-decoration:underline;">addresses</span>

1			anything

2			0,2,4,6,8,A,C,E

4			0,4,8

8			0, 8

How do you maintain this alignment, use padding

size

Char	1

Int	4

Short	2

int*	4

Char	1

Int	4

Would think it would add up to be a size of 16, but the size is 24, because of padding



<p id="gdcalert15" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert16">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)


### The lost art of structure <span style="text-decoration:underline;">packing </span>← reorder struct elements to try to eliminate padding



* Padding: → inserting space to allow variable types to be on certain address boundaries
* Packed: → don’t allow any extra space
1. In general, structures will have the alignment of the longest <span style="text-decoration:underline;">Scalar </span>member (scalar would be on of the basic types: int, char, double, etc.)
2. May need padding at the end to ensure alignment
3. Can sometimes reorder structure elements to reduce padding requirements
4. Packing → don’t add padding, even if this means that scalar types don’t have the desired alignment
5. Inside struct, smaller elements login at first place alignment allows

Struct s

{

	Int a;

	Char b;

	Int c;

};

Offsets

Int a : 0x0

Char b : 0x4

Int c : 0x8

5 is not a default alignment for an int, so it chooses 8

Int a;

Int c;

char b;



* Modern processors prefer that scalar types, have boundaries of their type.
* In terms of structures, we should construct them so they also have those boundaries
    * We should do this because in code its just bits, it can’t really identify it by itself
* A struct itself is like an array of data types w/ values

#pragma pack(1) // tells compiler in gcc to not do packing

Mla r0, r1, r2, r3

 R0 = r1 * r2 + r3

Fp

	Fmla.f32 s0, s1, s2

S0 = s0 + s1, s2

/*

	Test add with carry

*/

	.global _start

_start:

	Mov r0, #0x8000000000

	Mov r1, #0

	Mov r2, #0x8000000000

	Mov r3, #0

	Adds r4, r0,r2

	Adc r4, r1, r3

End:

	Mov r7, #1

	Swi 0


## Virtual memory



1. The typical computer has much more disk storage that memory. However, memory is much faster to access than disk storage. 
2. It is possible to have the memory ( i.e., RAM ) act as a cache for the disk storage using <span style="text-decoration:underline;">virtual memory</span> 
    1. This gives us the access speed of memory while having the size of disk storage.
3. 

<p id="gdcalert16" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline drawings not supported directly from Docs. You may want to copy the inline drawing to a standalone drawing and export by reference. See <a href="https://github.com/evbacher/gd2md-html/wiki/Google-Drawings-by-reference">Google Drawings by reference</a> for details. The img URL below is a placeholder. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert17">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![drawing](https://docs.google.com/drawings/d/12345/export/png)
    2. Programs are compiled to their own <span style="text-decoration:underline;">Address space</span> , which is a set of <span style="text-decoration:underline;">virtual addresses.</span> These virtual addresses are mapped to physical memory or disk storage.
        1. → two programs may each think they are storing info at the virtual address 0xBF00 
        2. → in reality, each maps to different physical addresses
    3. Info on disk is read in <span style="text-decoration:underline;">pages</span>, which are similar to a cache block. However cache blocks are small (e.g., 32 bytes) while pages are much larger (e.g. 4k bytes)
        3. A <span style="text-decoration:underline;">Page fault</span> is when a page we want is not in memory, similar to a cache miss.


### Benefits



1. Security - it is easier to restrict access of a process to its allocated memory 
    1. Attempts ti access unallocated memory or allocated ( read-only memory cause <span style="text-decoration:underline;">Segmentation faults</span>)
2. Heap fragmentation - while physical memory may be fragmented into many non-contiguous blocks, in virtual memory they may appear to be contiguous
3. Shared resources - easier for multiple processes to share physical memory or libraries 
4. Makes physical memory appear much larger