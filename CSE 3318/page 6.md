## Priority Queues
Goal:
* Delete max element
* inser new element
* initialize

Applicaiton:
* Waitlists
* CPU Tasks
* Scheduling
* Proccessing online data

e.g:

Insert in empty priority Queue:
    
```    
    5, 3, 9, 1, 2
    5, 3, 9, 1, 2 remove -> 9
    5, 3,  , 1, 2 remove -> 5
     , 3,  , 1, 2 insert -> 7
    7, 3,  , 1, 2 remove -> 7
     , 3,  , 1, 2 remove -> 3
     ,  ,  , 1, 2 remove -> 2
     ,  ,  , 1,   remove -> 1
     ,  ,  ,  ,  
```

| Index    | 0 | 1 | 2 | 3 | 4 |
| -------- | - | - | - | - | - |
| Unsorted | 1 | 2 | 7 | 5 | 3 |
| Sorted   | 1 | 2 | 3 | 5 | 7 |

    TC for PQ:   Insert     Remove
    Unsorted Arr θ(1)       θ(N)
    unsorted LL  θ(1)       θ(N)
    Sorted Arr   O(N)       θ(1)
    sorted LL    O(N)       θ(1)
    Binary Heap  O(lgN)     O(lgN)

## Binary Heap

* Is an Array
* Will view as a nearly complete Tree 
EX:
![alt text](image.png)
* 1st element at index 1

| val | \- | 9 | 7 | 5 | 3 | 5 | 4 | 3 | 2 | 1 | 1  | 3  | 4  | 1  |
| --- | -- | - | - | - | - | - | - | - | - | - | -- | -- | -- | -- |
| idx | 0  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 |

![alt text](image-2.png)

* Order: The priorty of every note is <= parent
* Max is the root
* Shape is like an incomplete trianlge missing a piece from the bottom right

## IDX Computation

```
int left (int idx){ return idx * 2;}
int right (int idx){ return (idx * 2)+1;}
int parent (int idx){ return (idx / 2);}
```

## Swipup & Increase
* Essentially this code swaps the position of nodes, making it able to swim up
* code not neccesary to know but its the concept thats important

![alt text](image-1.png)

