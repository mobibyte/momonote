

### Loop unrolling

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


## Avoid:

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


### Reduce calls to memory

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

From Patterson p336


## ARMv8 uses these terms

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

Push {R1} 

Push {R2} 

Works the same way like how the functions being called looks 

(this is just a visualization of data)



* ARM allows you to create your own stack with an array, but we will use The Stack


## Stack models



1. When something is pushed onto the stack, do addresses increase or decrease?
    1. Increasing → addresses get bigger (# go up)
    2. Decreasing → addresses get smaller (# go down)
2. Where does the stack pointer point after a push?
    3. A full stack, if SP points at top value of stack
    4. A empty stack, if SP points at next available spot
* The Stack, ARM, is full, descending 


## Examples of stacks
```
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

```

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

```
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
```


* func1(R0, R1, R2, R3, Stack(#5), Stack(#6))
* Which order is it?
* When you pop #5 it comes out first
* Then you can pop #6 to get to the last element


## Hw8

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


## Example similar to hw

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


## Cache


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

## How do we achieve our goal of appearing to have fast, cheap memory?

2 principles

1. Spacial locality
* When you request #2, computer grabs all of those next to it in memory
    * Move from main mem → cache
1. Temporal locality 
* When you keep on calling sum a lot, we put in cache from memory. Because we will use it for a certain amount of time.
* Try to figure out what you need in near future and have it on hand
