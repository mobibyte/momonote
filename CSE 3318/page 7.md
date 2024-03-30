
## FIFO Queues
* FIFO: First In First Out
* sort of like waiting in line at a restaraunt
* 2 implementations of this:
  * Single Linked Lists
  * Arrays

<badge type="info" text="Heres a visualization" />
--- 
<img src="/CSE 3318/image-7.png" width="100%" height="100%">

* both implementations are essentially the same, just keeping track of the first and last nodes / idxs and updating their positions
* imo its easier with a single linked list

## HashTables
* Allows for searching data in constant time
* One of the 1st things to think of when trying to solve a search/lookup leetcode esq problem

$$
Pairs Of Key => Hash Value => index
$$

### Collision Resolution
2 items trying to go to the same cell

Solution: Linked lists

## Seperate Chaining
M = table size h(k) = k%m

* using a number like 10 as a size is a bad idea for hash tables
* we tend to use ***Prime Numbers***

Inserting data at beginning is good when new data is searched more frequently

Ratio between
M = table size: 10
N = Number of items in table: 6

$$
α = \frac{N}{M} = \frac{6}{10} = .6
$$
α = load factor

* When the load factor(α) goes past threshold
  * Resize it ! (usually multiply m by 2)
  * Good threshold size is .75

<badge type="info" text="Heres a visualization" />
--- 
<img src="/CSE 3318/image-6.png" width="50%" height="50%">

## Resizing Tables

Ans: Double the space


M = 10 => m = 20 -> h(k,20) = k % 20

    | 0  |  |
    | 1  |  |
    | 2  |  |
    | 3  |  |
    | 4  |  |
    | 5  |  |
    | 6  |  |
    | 7  |  |
    | 8  |  |
    | 9  |  |
    | 10 |  |
    | 11 |  |
    | 12 |  |
    | 13 |  |
    | 14 |  |
    | 15 |  |
    | 16 |  |
    | 17 |  |
    | 18 |  |
    | 19 |  |

Once resized, ***Rehash*** all items from original table to new table

TC: θ(N + M)
* Have to go through N Linked lists & size of M table

**How to initialize without resizing**

expected N = 100

