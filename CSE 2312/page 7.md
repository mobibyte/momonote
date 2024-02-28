
## To execute an instruction



1. Processor <span style="text-decoration:underline;">Fetches </span>instruction from memory
2. Instruction is <span style="text-decoration:underline;">decoded</span>
3. Get relevant register values
4. Execute instruction
5. Write results to register file
* The program counter (PC) tracks the address of the next instruction to process.
* Pipelining are (mostly) just models

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



* How long until machine x is complete
```
X / time	avg

1  30 min	30 min

2  40		40/2 = 20

3  50		50/3 = 17

4  60		60/4 = 15

5  70		70/5 

………………………

\/
```

As number of machines increases, the average time <span style="text-decoration:underline;">per </span>machine approaches 10 minutes

In our computer pipeline we use cycles



* In <span style="text-decoration:underline;">general </span>(not absolute) things happen on clock cycles
    * Fetch 
    * Decode
    * Execute
    * FDE



* Why not have lots of stages in piplining?
1. Not every stage really takes the same amount of time
2. Need buffers between stages → each adds time


## How to think about latency and throughput

Latency = time to do 1 thing 

sec/task, min/person transported, … etc 

Throughput = # of things done in some amount of time

How many tasks in 1 hr?

How many people in 1 hr?

Ver1

* Mov
* Mov
* Mov
* Add
* Sub

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


## How branches affect stuff

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


## Conditional Branches

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

3 total cycles cost

**This happens ONLY**

**If branch is taken**




* This is not true for unconditional branch because we always take the branch

Sample homework will be like

“Assume pipeline is full”

(use the average cost, assume that the pipeline is already benefiting from processing a new instruction)

C code
```
Sum = 0;
I = 1;

While ( i &lt;= 5)
{
	Sum += i;
	I++
}
```

Ver1

```
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
```

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

```
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
```



## Hw5 guidance



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

