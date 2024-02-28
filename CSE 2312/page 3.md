
#### RPI in class

```
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
```


### Assembly Opcodes meanings

* MUL Rd, Ra, Rb	 ==	 Rd = Ra * Rb
* MLA Rd, Ra, Rb, Rc 	== 	Rd = Ra * Rb + Rc (Rd and Rc can be the same)
* AND Rd, Ra, Rb or const 	 ==	 Rd = Ra & Rb &lt;- C style (bitwise and)
* ORR Rd, Ra, Rb or const	 == 	Rd = Ra | Rb (bitwise or)
* EOR Rd, Ra, Rb or const	 ==	 Rd = Ra ^ Rb (exclusive or)
* LSL  Rd, const  	== 	Rd = RA &lt;< Const (logical shift left, or bitshift left) 
	Or
* LSL Rd, Ra, Const  	
* LSR Rd, Const	== 	rd = Rn >> Const   (logical shift right, or bitshift right)
	Or 
* LSR Rd, Ra, Const
* LSL = logical shift left / logical shift right LSR
* ASR Rd, const
* ASR Rd, Ra const
* ASR = Arithmetic shift
* ROR Rd, const
* ROR Rd, Ra, const
* ROR = rotate right
* Rd = |A|B|C|D|
* LSL RD, #1



* Rd = |B|C|D|0|

LSR RD, #1



* Rd = |0|A|B|C|

ASR RD. #1



* Rd= |A|A|B|C| (adds the most significant bit aka left most bit) 
    * Theres no ASL because it would be the same as LSL

ROR Rd, #1



* Rd = |D|A|B|C| (simply wraps the bits around)

## Two’s comp num 

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


#### C program

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


#### Why do we need bitwise operations



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


```

1011
0101 + 1
(the caryout 1| 0000
 3 bit signed ints.
   -2              010
+ -3     flip    101
         Add 1| 110 = (-2


011
100 flip
    1 +
101 = -3
110
101
011 <- overflow

```

Certain flags we can set to help us out


## The Arithmetic Logic Unit (ACLU)

Is the part of the central processing Unit (CPU) that preforms arithmetic, bitwise operations, and shifts.

Overflow is defined as adding two pos.

To get a neg. Or two neg to get a pos.

In this sense

Sometimes you do get zero and theres An actual flag for that

When writing C code

If (x == 5)

In assembly 

	X-5  (if you get a 0 its equal) (if x was 5, x-5 would be 0 which is true)


## Current Program Status Register (CPSR)

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


## NZCV

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

## ASM PROGRAM
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
```

* Or top 4 bits have
* 0110
* Nzcv
    * Results in all zeros and didnt have to carry

while ( x &lt; 5 )

Cmp r1, #5


## TAR

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

## Conditions in assembly

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

