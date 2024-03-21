## Task 1
### Question

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

### Answer
To answer these questions, we need to understand the concept of entailment in propositional logic. Entailment occurs when the truth of one statement (the consequent) is guaranteed by the truth of another statement (the antecedent).

#### Part a: Does KB entail S1?
We need to check if every time KB is true, S1 is also true. Based on the truth table:

1. The first row shows both KB and S1 as true.
2. In the seventh row, KB is true and so is S1.
3. There are no cases where KB is true and S1 is false.  

Therefore, in all cases where KB is true, S1 is also true. This indicates that KB does indeed entail S1.

#### Part b: Does NOT(KB) entail NOT(S1)?
For this, we need to check if every time KB is false, S1 is also false:

1. In the second and third rows, KB is false but S1 is true.  
2. In the fourth row, both KB and S1 are false.  
3. In the fifth and sixth rows, KB is false and S1 is also false.  

Since there are cases (rows 2 and 3) where KB is false but S1 is true, NOT(KB) does not always lead to NOT(S1) being true. Therefore, NOT(KB) does not entail NOT(S1).

## Task 2

### Question

Suppose that some  knowledge base contains various propositional-logic sentences that utilize symbols A, B, C, D (connected with various connectives). There are only two cases when the knowledge base is false:  
- First case: when A is true, B is false, C is true, D is false.
- Second case: when A is false, B is false, C is true, D is true.

In all other cases, the knowledge base is true.  
Write a conjunctive normal form (CNF)  for the knowledge base.

### Answer  


To write a conjunctive normal form (CNF) for the given knowledge base, we first consider the conditions under which the knowledge base is false and then negate these conditions.

The knowledge base is false in two cases:
1. A is true, B is false, C is true, D is false.
2. A is false, B is false, C is true, D is true.

We can represent these two cases with the following propositional logic expressions:
1. $A \land \neg B \land C \land \neg D$
2. $( \neg A \land \neg B \land C \land D)$

Now, to convert this into a CNF, we will use the negation of these expressions (since these are the cases where the knowledge base is false, and we want to represent when it is true). We then use De Morgan's Laws and distribute the negation across the conjunctions:

1. Negation of the first case:
   $\neg (A \land \neg B \land C \land \neg D)$  
   Which is equivalent to:  
   $\neg A \lor B \lor \neg C \lor D$

2. Negation of the second case:
   $\neg (\neg A \land \neg B \land C \land D)$
   Which is equivalent to:  
   $A \lor B \lor \neg C \lor \neg D$

Finally, the CNF for the knowledge base (representing when the knowledge base is true) is the conjunction of these two expressions:

$(\neg A \lor B \lor \neg C \lor D) \land (A \lor B \lor \neg C \lor \neg D)$

This expression captures all the conditions under which the knowledge base is true, except for the two specific false cases.

## Task 3
### Question
Consider the KB

(A => C) AND (B <=> C) AND (D => A) AND E AND [(B AND E) => G] AND (B => F) AND D

Show that this entails G (if possible) by

i. Forward Chaining  
ii. Backward Chaining  
iii. Resolution  
