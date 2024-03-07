
## Structuring cache

Our goal: Appear to have <span style="text-decoration:underline;">Lots </span> of <span style="text-decoration:underline;">fast </span>, <span style="text-decoration:underline;">cheap </span> **memory**


1. How do we structure our cache to support having (and finding) what we want in cache as opposed to slower storage?
    1. Direct mapping - every <span style="text-decoration:underline;">block* </span>maps to a specific place in cache
        1. *by <span style="text-decoration:underline;">block </span>we mean a unit of memory values, for example, 16 bytes of memory sometimes the term “Block” gets used differently.

Ex. Suppose our cache can store 4 words. 1 wrd is 4 bytes or 16 bytes

* In ARM words are stored in addresses ending in 0x00, 0x04, 0x08, 0x0C.
* **Pro**: Always know where in cache to look for something (where it will be if it’s there)
* **Con**: Only one thing that maps there, can be there at a time.
1. Fully Associative
   *  Any block can be in any cache “slot” 
   * **Pro:** a block is not restricted to any particular slot, So any combination of blocks can be in cache at the same time (Up to the limited cache size)
   * **Con:** 
      1. N-way set associative
          1. Combination of direct mapping and fully associative.
              1. Cache is divided into sets and each set holds n blocks.
              2. Every block of memory maps to a specific set.
2. So if we are using set associative or fully associative, how do we decide what is replaced?
    1. Keep track of time since use and replace least recently used.
    2. Choose at random // our top priority is speed
3. When do cache values get written back to memory?
    1. Write-Through → when cache is updated, also update corresponding value in memory. 
* **Pro: **always in sync
* **Con: **Takes time
    1. Write-Back → Update memory only when the block in cache is replaced.

How do we quantify how well cache is being used?

*  When something we want is in cache, we have a <span style="text-decoration:underline;">hit</span>. Otherwise, we have a <span style="text-decoration:underline;">miss</span>.
* These ideas lead to a <span style="text-decoration:underline;">hit rate</span> and a <span style="text-decoration:underline;">miss penalty</span>.


## Average memory access time (AMAT) 

AMAT = time in Loc1 + time in Loc2 + … + time in locN

Weight average 

Absolute: %

Relative:  %

Ex. Suppose we only have L1 cache and RAM, with these values.

```
                    L1      RAM
Hit Rate:           90%     10%
Total access time:  1ns     100ns
```
 

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


## Floating point registers


1. 32, 32-bit fp registers with names s0, s1,...s31

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

    <span style="text-decoration:underline;">integer fp</span>



    * Mov		vmov		Sometimes have to add .{type}


    * Add		vadd		ex. Adding 2 32bit floating point nums


    * Ldr		vldr		vadd.<span style="text-decoration:underline;">f32</span> s0, s1, s2


    * .f32 means level of precision

4. **<span style="text-decoration:underline;">To convert</span>**

	vcvt .{dest type}.{source type} ← f32, f64, u32, s32


5. **<span style="text-decoration:underline;">Compare with </span>**

    * Vcmp.{type} fp1, fp2


    Or


    * Vcmp.{type} fp1, #0.0 ← only zero


    (you change the floating point flags, not int flags)


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


## HW9

1st 3, calculate memory access time

Program, start learning how to do floating point avg

1st subroutine, given address to get hw num to get calculate avg of grade

Write another subrotuine of exam1 and exam 2 grade to get a 90 in class for the final

S0-s15 are passed in for floating registers


## How to calculate the average?


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


## Passing floating point numbers

Passing 32-bit integers

F ( r0, r1, … , r3) → result = r0

Passing 32-bit single precision floating point number

g(s0, s1, … , 515) → result = s0

Combining these? 

–assembler figures it out

I.e. F( r0, s0, r1, s1) would be f( int, float, int, float)


## Mulby2 assembly 

```
.global mulBy2

mulBy2:

	Ldr r1, = constant  @ get address of floating point

Constant

	Vldr s1, [r1]	@ load floating - point constant

	Vmul.f32 s0, s0, s1

	Bx lr

.data

Constant: .float 2
```

## FloatMulbyInt
```

	/*Input: s0 = float, r0 = int  *

*return: s0, =s0  * r0         */

	.global mulFPbyInt

mulFPbyInt

	Vmov s2, r0 @ mov integer register value to FP register

	Vctv.f32.s32 s1, s2 @ convert from signed, 32-bit to fp

	Vmul.f32 s0, s0, s1

	Bx lr
```


* Do a lot of incremental development


## MulFPbyFP
```
/*Input: s0 = float, s1 = float*

*Result: s0 = s0 * s1          */

	.global mulFloatByFloat

mulFLoatByFloat:

	Vmul.f3 s0, s0, s1

	Bx lr
```

## MulDoublebyDouble
```
/*

input: d0, d1            

Result: d0 * d1 = d0 

Note: that d0 = s1,s0 and d1 = s3, s2

*/

	.global mulDoublebyDouble

mulDoublebyDouble:

	Vmul.f64 d0, d0, d1

	Bx lr
```

## Real roots
```
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

``` -->

