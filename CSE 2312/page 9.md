## padding

* Modern computers prefer addresses be a multiple of the size of the type

Individual variables

<span style="text-decoration:underline;">Size in bytes</span> <span style="text-decoration:underline;">addresses</span>

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


## The lost art of structure <span style="text-decoration:underline;">packing </span>
##### reorder struct elements to try to eliminate padding

* Padding: → inserting space to allow variable types to be on certain address boundaries
* Packed: → don’t allow any extra space
1. In general, structures will have the alignment of the longest <span style="text-decoration:underline;">Scalar </span>member (scalar would be on of the basic types: int, char, double, etc.)
2. May need padding at the end to ensure alignment
3. Can sometimes reorder structure elements to reduce padding requirements
4. Packing → don’t add padding, even if this means that scalar types don’t have the desired alignment
5. Inside struct, smaller elements login at first place alignment allows

```
Struct s
{
	Int a;
	Char b;
	Int c;
};
```
Offsets

    Int a : 0x0

    Char b : 0x4

    Int c : 0x8

5 is not a default alignment for an int, so it chooses 8

Int a;

Int c;

char b;


* Modern processors prefer that **scalar types**, have boundaries of their type.
* In terms of structures, we should construct them so they also have those boundaries
    * We should do this because in code its just bits, it can’t really identify it by itself
* A struct itself is like an array of data types w/ values

#### pragma pack(1) 
// tells compiler in gcc to not do packing
```
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
```


## Virtual memory

1. The typical computer has much more disk storage that memory. However, memory is much faster to access than disk storage. 
2. It is possible to have the memory ( i.e., RAM ) act as a cache for the disk storage using <span style="text-decoration:underline;">virtual memory</span> 
    1. This gives us the access speed of memory while having the size of disk storage.
    2. Programs are compiled to their own <span style="text-decoration:underline;">Address space</span> , which is a set of <span style="text-decoration:underline;">virtual addresses.</span> These virtual addresses are mapped to physical memory or disk storage.
        1. → two programs may each think they are storing info at the virtual address 0xBF00 
        2. → in reality, each maps to different physical addresses
    3. Info on disk is read in <span style="text-decoration:underline;">pages</span>, which are similar to a cache block. However cache blocks are small (e.g., 32 bytes) while pages are much larger (e.g. 4k bytes)
        1. A <span style="text-decoration:underline;">Page fault</span> is when a page we want is not in memory, similar to a cache miss.


#### Benefits

1. Security - it is easier to restrict access of a process to its allocated memory 
    1. Attempts ti access unallocated memory or allocated ( read-only memory cause <span style="text-decoration:underline;">Segmentation faults</span>)
2. Heap fragmentation - while physical memory may be fragmented into many non-contiguous blocks, in virtual memory they may appear to be contiguous
3. Shared resources - easier for multiple processes to share physical memory or libraries 
4. Makes physical memory appear much larger
