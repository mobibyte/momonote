
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


##### 4 digit non negative fixed-point number with this arrangement

XX.XX

00.00 \/

99.99 



* The issue with this is what if you want to use 100
* You cant because the decimal is fixed in the middle, and we didnt allocate for space of 100


## For floating point numbers

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


## IEEE 754 Floating-Point Standard 

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

```
            Single               double

Aprox +- 10^+-38          +-10^+-308

Ranges
```



* You lose some precision with floats

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

```
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
```


* 32 bit single precision for 65536.0009765625 and 65536 is the same, if you want to store more you need double precision, aka more for fraction and exponent

## Issues with floating point


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

