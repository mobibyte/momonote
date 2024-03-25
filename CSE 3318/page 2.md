# Time Complexity
* Behavior as data size goes to **Infinity**
* Notation: O( )
* Most of the notes in this is pure math & code

| N    | N^2     | 3N^2    | 100N             | 1000     |
| ---- | ------- | ------- | ---------------- | -------- |
| 10^4 | T:0.1s  | T:0.3s  | T:0.001s         | T:10^-6  |
| 10^9 | T:31yrs | T:95yrs | T= 100s = 1.66mm | T: 10^-6 |

$$ \frac{10^4 * 10^4}{10^9} = \frac{N * N}{10^9}$$

```
void ex1()
{
    int A[7] = {5, 1, 9 ,3, 5, 9, 5};
    int N=7;
    int T = 4;
    int k;

    k = 0; //executed 1
    while(k < T) // 4 T times
    {
        printf("%4d, ", A[K]); //4 T times
        K++; //4 T times
    }
    printf("\N) //1
}
```
1 + T + T +T + 1 +1 = 3T + 3 = O( T ) 

---

```
for ( j = 1 (O(1)); j < N (O(N)); j++)
{

}
```
(N-1)(3T+3) = 3NT-3T+3N-3 = O(NT)
N+T = O(N+T)

$$
N^2 + T = O(N^2+T) = \frac{T}{N^2} (N^2 not dominater)
$$

---

```
for(j = 0; j < N; j++)
{
    printf(a(j));
}
```

toal TC is Sum

| iter | j   | TCiter |
| ---- | --- | ------ |
| 0    | 0   | O(1)   |
| 1    | 1   | O(1)   |
| 2    | 2   | O(1)   |
|      | .   |        |
|      | N-1 | O(1)   |


---

```
for(j=1; j<= n; j++)
{
    for(k=0; k<t; k++)
    {
        printf(A[K]);
    }
}
```

| j   | TCiters(j)=O(T) |
| --- | --------------- |
| 1   | O(T)            |
| 2   | O(T)            |
| 3   | O(T)            |
| ... | ...             |
| ... | ...             |
| N   | O(T)            |

$$
sum = O(t)+O(t)+...O(t) = N*T = O(NT)
$$


## TC of Function Calls

```
int count(int nums[], int T, int V) // this functions has TC:O(T)
{
    int count = 0;
    for (int k=0; k<T; k++)
    {
        if(nums[k] == V)
            count++;
    }
    return count;
}
```

$$
    TCiter(k) = O(1)+O(1)+O(1)...+O(1) = O(1)
$$

* TCiter stands for time complexity of that iteration, in this example its the for loop for the function

| k   | TC1iter(k)=O(1) |
| --- | --------------- |
| 0   | O(1)            |
| 1   | O(1)            |
| 2   | O(1)            |
| 3   | O(1)            |
| ... | ...             |
| ... | ...             |
| T-1 | O(1)            |

* We do O(1) T times, so ...

$$
  O(1) + O(1) ... + O(1) = O(1) * T = O(T)
$$


Remember our function count, what if we called it, what would its time complexity be if it looked like this?

```count(nums,n,val);```
<details>
  <summary><i>Answer</i></summary>
  <b>O(N)</b>
</details>

<badge type='info' text='Tip: any function that processes an array will have a loop!' />

## Sequential Loops

Write the O( ) time complexity of this code

```
for(j = left; j<= right; j++)
{
    printf("%d,  ", A[i]);
}
for(i = 0; i < p; i++)
{
    for(k=0; k<r; k++)
        printf("B");
}
```
<details>
  <summary><i>Answer/Explanation</i></summary>
  <p>By examining the code we want to start with the second for loop, the inner part of that loop is a simple O(r) TC</p>

  <p>The outer part is more complicated though</p>
  <p>
  
  </p>
</details>