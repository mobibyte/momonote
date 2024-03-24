<badge type="info" text="Tip: Compile in C99(for homeworks)"/>

## Stable Sorting
After it sorts arrays, any 2 record compared equal, will be in the same relative order. As they were before sorting, happens for every possible input array.

<badge type="info" text="Im looking back at this and im not quite sure what this means, just look at this instead"/>

| EX  |     |      |      |       |
| --- | --- | ---- | ---- | ----- |
| 4   | 3   | 4    | 3    | 1     |
| Bob | Tom | Anna | Jane | Henry |

| Stable Sort |     |      |     |      |
| ----------- | --- | ---- | --- | ---- |
| 1           | 3   | 3    | 4   | 4    |
| Henry       | Tom | Jane | Bob | Anna |

| Unstable Sort |     |      |      |     |
| ------------- | --- | ---- | ---- | --- |
| 1             | 3   | 3    | 4    | 4   |
| Henry         | Tom | Jane | Anna | Bob |

Essentially how it works is that it sorts group first (GPA) then puts names first by Input!

## Insertion Sort

5,7,9,12,20 ==> | 5 | 7 | 9 | 12 | 20 |

Checks each number if it's greater than previous number.
* If it's less than previous number it loops and sorts it correctly.
* Else: Puts it at front.

Adaptive:
- Time complexity depnds on Input
  - Almost Sorted = Faster, Else = slower
  - Best: Acending
  - Worst: Decending

unsorted: 20, 12, 9, 7, 5

    (1)     20, *12* -> *12*, 20
    (2)     12, 20, *9* -> *9*, 12, 20 
    (3)     9, 12, 20, *7* -> *7*, 9, 12, 20
    (4)     7, 9, 12, 20, *5* -> *5*, 7, 9, 12, 20

Total swaps:
* 1 + 2 + 3 + 4
* = 10

$$
n = \frac {n(n-1)} {2} = \frac {5*4} {2} = 10
$$

$$
n = \frac {n(n-1)} {2} = \frac {n^2 - n}{2} => \frac{n^2}{2} - \frac{n}{2} 
$$

### Psuedo Code

```
For i = 1; i <= n-1
{
    key = A[i]
    K = i - 1
    While ( K >= 0 && A[k] >= Key)
    {
        A[K + 1] = A[K]
        K--
    }
    A[K+1] = key
}
```

## Steps for Devleoping Algorithms
0. Draw Input data / Final
1. Loops & Variables
2. Property
   1. Identify Prop (relationship between data and loop iteration)
   2. i -> (i+1)
      1. State it for I
      2. State it for i + 1 ( know what to expect )
      3. Work out loop iteration i
      4. check loop I variant for i + 1
3. Solved at the end
4. Fix Start

## Indirect Sorting
<badge type="info" text="This uses insertion sort!"/>

When to use Indirect sorting
* When you cant modify the data
* Or when theres too much data

|   | IDX |   | Data |   | IDX |   | Data |
| - |     --- | - | ---- | - | --- | - | ---- |
| 0 | **0**   | 0 | 709  | 0 | **1**   | 0 | 709  |
| 1 | **1**   | 1 | 115  | 1 | **3**   | 1 | 115  |
| 2 | **2**   | 2 | 616  | 2 | **5**   | 2 | 616  |
| 3 | **3**   | 3 | 201  | 3 | **4**   | 3 | 201  |
| 4 | **4**   | 4 | 505  | 4 | **2**   | 4 | 505  |
| 5 | **5**   | 5 | 427  | 5 | **0**   | 5 | 427  |
| 6 | **6**   | 6 | 934  | 6 | **6**   | 6 | 934  |

* Very short explanation is that it sorts it by the index of the data
* index 1 of the data is the smallest number 115, & index 6 is the largest at 934

### Code

<badge type="info" text="Essentially is insertion sort"/>
```
for( i = 1; i < n; i++)
{
    key_idx = idxs[i];
    j = j - 1;
    while (j >= 0 && (data[idxs[j]] > data[key_idx]))
    {
        idxs[j+1] = idxs [j];
        j--;
    }
    idxs[j+1] = key_idx;
}
```

## Binary Search
* Reduces search in half

Example: guess my number, range is 0-100

$$ 0-100 -> guess 50 $$ 
$$ x < 50 $$ 
$$ x > 25 $$
$$ x < 37 $$
$$ x = 32 $$

On her quizzes and exams this is something you would have to do
(like saying what are the computed middle values)

| Left  | Right | Middle | Action    | 0 | 115 |
| ----- | ----- | ------ | --------- | - | --- |
| 0     | 6     | 3      | 392 < 505 | 1 | 201 |
| 0     | 2     | 1      | 392 > 201 | 2 | 427 |
| 2     | 2     | 2      | 392 < 427 | 3 | 505 |
| 2     | 1     |        |           | 4 | 616 |
| FALSE | \=>   | Stop   |           | 5 | 709 |
|       |       |        |           | 6 | 934 |