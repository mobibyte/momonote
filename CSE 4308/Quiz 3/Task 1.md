## Question

| A     | B     | C     | KB    | S1    |
|-------|-------|-------|-------|-------|
| True  | True  | True  | True  | True  |
| True  | True  | False | False | True  |
| True  | False | False | False | True  |
| True  | False | False | False | True  |
| False | True  | True  | False | False |
| False | True  | False | False | False |
| False | False | True  | True  | True  |
| False | False | False | False | False |

 KB and S1 are two propositional logic statements, that are constructed using symbols A, B, C, and using various connectives. The above truth table shows, for each combination of values of A, B, C, whether KB and S1 are true or false.

**Part a:** Given the above information, does KB entail S1? Justify your answer.

**Part b:** Given the above information, does statement NOT(KB) entail statement NOT(S1)? Justify your answer. 

## Answer
To answer these questions, we need to understand the concept of entailment in propositional logic. Entailment occurs when the truth of one statement (the consequent) is guaranteed by the truth of another statement (the antecedent).

### Part a: Does KB entail S1?
We need to check if every time KB is true, S1 is also true. Based on the truth table:

1. The first row shows both KB and S1 as true.
2. In the seventh row, KB is true and so is S1.
3. There are no cases where KB is true and S1 is false.  

Therefore, in all cases where KB is true, S1 is also true. This indicates that KB does indeed entail S1.

### Part b: Does NOT(KB) entail NOT(S1)?
For this, we need to check if every time KB is false, S1 is also false:

1. In the second and third rows, KB is false but S1 is true.  
2. In the fourth row, both KB and S1 are false.  
3. In the fifth and sixth rows, KB is false and S1 is also false.  

Since there are cases (rows 2 and 3) where KB is false but S1 is true, NOT(KB) does not always lead to NOT(S1) being true. Therefore, NOT(KB) does not entail NOT(S1).