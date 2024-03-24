# Time Complexity
* Behavior as data size goes to **Infinity**
* Notation: O( )

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
