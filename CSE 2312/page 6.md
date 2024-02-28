
## Exam will be 4 - 5 problems

What are the minimum number of bits to represent 9b10 as an integer? (technically you need addition info)



* Is it signed or unsigned

4b10 = 100b2 (works for unsigned, but if its signed)

	0100

	Need room for the sign, or just an extra bit



* There is 1 program on the test, here’s a program, and tell me what it does, whats the value at this point or at this point


## More on floating point numbers

**Why do we bias the exponent?**

* It makes it easier to order the numbers and see the actual sizes of the numbers
* Once you normalize and bias, all you need to do is look at the exponent to see how big a number really is

If we had 3-bit signed ints (2’s comp)

```
       Unsign 	signed    Ones complement Two’s comp.        Biased exponent

000	 0 	  0		0			0             4 100

001 	1            1		1			1             5 101

010 	2            2		2			2             6 110

011 	3            3		3			3             7 111

100 	4           -0		-3			-4            0 000

101 	5           -1		-2			-3            1 001

110 	6           -2		-1			-2            2 010

111 	7           -3		-0			-1            3 011
```


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

Big

1 0000 0000 0000 0000.0

Small

0.0000000000001

→ 0 x 10^1
```



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


## Why does this stuff matter besides this course?

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


## Pointers! 


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


### Pointer arithmetic 



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


## Demonstrating load register


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


## Table of addressing modes

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


## Data in ASM

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


## Read write strings

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


## Sign extension



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


## .space allocation

.space 50  → allocate with 50 bytes (does pad with 0s)

.space 100 0xa → allocated 100 bytes each with 0xa

.space 50 == .space 50, 0


## X RISC VS CISC



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



Functions uses the...

## Program counter

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

