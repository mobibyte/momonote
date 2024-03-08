
## Nines complement

+123

 999

-123

—---- 

876 &lt;- (-123)

A + (-a) = 999…

Pascals calculator


## Tens complement

2 digit integer in tens complement

```
0
1	99 = -1
2	98 = -2
3	97 =-3
.
.
.
48	52 = -48
49	51 = -49
	50



What is -3?
99
-3
—
96
+1
—
97 = -3
Base 10

23		99
-25		-25
—-		—-
-2 		74
		+1
23		— 		99
+75		75		-98
98				1 + 1 = 2
```







## What happens when we compile in our computer
```
Gcc file.c

-> a.out

File.c - - preprocesser - - > |”File.i” - - compiler – > file.s - - Assembler - -> File.o (object file) - - linker - - >
```



* Inside we have a=b+c
* #include &lt;stdio.h> #define MAX 4 (are all preprocesser flags)
    * Basically saying hey i need this stuff for my code (essentially a search and replace)
    * Int printf(const *s, …) &lt;- Variadic function
* When you write printf(“x = %d”, x);
    * Then write printf(x = <span style="text-decoration:underline;">%d</span>, y = <span style="text-decoration:underline;">%f</span>”, x, y);
    * The reason why we have format specifies because the function doesnt know 
        what you’re asking of it, it goes through the string and looks at these 
        flags to see what data types it needs.

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

## RISC & CISC

### INTEL CISC 


* Complex construction set computers ( came first, more mnemonics and specific )

### ARM RISC



* Reduced construction set computers

The <span style="text-decoration:underline;">Instruction Set Architecture</span> (ISA)



* For a processor consists of the supported machine instructions, The registers the processor will have, how memory is addressed, data types and so forth.
    * What will be the machine instructions be add, subtract, shift the bits

## 32-bit Raspberry Pi



* Support the ARMv7 
* 16, 32 bit registers, with names R0, R1,...,R15
    * R0 - R12 are general purpose
    * R13 stack pointer or (SP)
    * R14 link register (LR)
    * R15 Program counter (PC)

We will stand alone assembly programs, and functions in assembly called from a c program

Starting off with the basic


### Stand alone assembly programs


### The skeleton
```
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


## Comments

Keil (compiler that uses ; for comments)

@ symbol for comments

/* for multi line comments*/

// and slash slash for comments
```


* Assembly is not case sensitive 
    * r0 R0
    * add ADD


## assembly deffinitions

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


## Hw1



1. Show work to get a grade
2. If you have multiple pages, staple the pages if you don’t, then prof. Will staple and take 10 points off

C standard 1989 &lt;- not tied to two’s complement



* Char 	1 byte -> -127, 127 
* Short	
* Int at least 2 bytes 
* Long

Stdint.h (has these definitions in C99)


### Doc s

Mnemonics are located in the files section of canvas

Add Rd, Rn, Op2 

Gcc -o outName File.c

gcc File.c -o outName -g


## Bit ranges

What are the ranges?



* For n bits 2^n bit arrangements (for unsigned)
    * For n = 3, 2^3 = 8 bit arrangements 0,1,2…8-1 = 7 ->  2^3 -1 
    *  2^n-1
* 2’s comp. 
    * 3 is max, min is -4
        * -4, -3 … 0, 1, 2, 3 
    * When we say we are gonna have a signed int for twos comp. We loose a bit to represent the sign, still have 2^3 bit arrangements but we cut all the representation in half for pos. & neg.

```
3 bit in
000
001
010
011
100
101
110
111
Unsigned
0
1
2
3
4
5
6
7
Signed 2’s comp.
0
1
2
3
-4
-3
-2
-1



Min
Max
Unsigned 
0
 2^n - 1
Signed two’s comp
-(2^n-2) 
2^n-1 - 1


```


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
