
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



## Overflow C code


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


## If else in assembly


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


## Conditionals w/out jumps/breaks


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


prof Pet peeves



* The for loop is used when number of times known to run and while is used when its unknown
* Absolutes 
    * Things that are required to be a certain way
* Idioms or conventions
    * Expressions that dont translate literally
* Preferences

C gives you a whole lot of freedom on how you format it.


#### Obfuscated C contest 

Code that works but is absolutely unreadable

Back to loops

For ( ; ; );

Thats legal in C

Any or all of the 3 parts are optional


## Difference between movw and mov

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
```
     .global _start 
_start: 
   Mov r1, #0xF0000000

   moww r1, #0x1234

    Movt r1, #0xABCD

_end: 
   Mov r7, #1 \
   swi 0</code>
 
```



## Back to loops



* Writing this loop in assembly
```
Sum = 0;
i= 1;

While ( i &lt; 4 )
{
    sum+=i;
    I++;
}
```

First method is conceptional way

Second method is what is normally seen.

For the most part we use cmp nmemonics

But can use subs if needed



* Opposite of &lt; is >=

## Conceptional way of loops in ASM


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

```
Do
{
	sum+=1;
	I++;
}
While (i &lt; 4);
```

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

## do while in ASM

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

* Goto is frowned upon in C



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
