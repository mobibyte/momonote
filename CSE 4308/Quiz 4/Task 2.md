# Task 2

## Question
In a certain probability problem, we have 11 variables: A, $B_{1}$, $B_{2}$, ..., $B_{10}$.


- Variable A has 7 values.
- Each of variables $B_{1}$, ..., $B_{10}$ have 8 possible values. Each $B_{i}$ is conditionally indepedent of all other 9 $B_{j}$variables (with j != i) given A.

Based on these facts:

### **Part a** 
How many numbers do you need to store in the joint distribution table of these 11 variables?

### **Part b**: 
What is the most space-efficient way (in terms of how many numbers you need to store) representation for the joint probability distribution of these 11 variables? How many numbers do you need to store in your solution? Your answer should work with any variables satisfying the assumptions stated above.

### **Part c**: 
Does this scenario follow the Naive-Bayes model?

## Answer

### Part a
A 11 dimensional table 7 across one dimensions and 8 across the other dimension.  

$7\times8^{10}$ values in total  
7,516,192,768 values in theory  
(or)  
7,516,192,767 in practice  

### Part b
Using Conditional Independence we need to store  
$P(A)$ and $10 P(\frac{B_i}{A})$ distributions  

So in theory we would need to store:  
$7+(8\times7)\times10=567$

In practice we need to store:  
$6+(7\times7)\times10=496$

### Part c  
Yes. If A is the cause and each $B_i$ is its effect then it does follow Naive-Bages Model  

![task2](./assets/task2.png)

