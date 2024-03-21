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

### Answer

To show that the given knowledge base entails $ G $, we will apply three different logical inference techniques: forward chaining, backward chaining, and resolution.

#### Knowledge Base (KB)

The knowledge base can be represented as:
1. $ A \implies C $
2. $ B \Leftrightarrow C $
3. $ D \implies A $
4. $ E $
5. $ (B \wedge E) \implies G $
6. $ B \implies F $
7. $ D $

#### i. Forward Chaining

In forward chaining, we start with the known facts and apply inference rules to derive new facts until we either reach the goal or exhaust all possibilities.

1. Start with the known facts: $ E $ and $ D $.
2. From $ D $ and $ D \implies A $, infer $ A $.
3. From $ A $ and $ A \implies C $, infer $ C $.
4. From $ C $ and $ B \Leftrightarrow C $, infer $ B $.
5. Now we have $ B $ and $ E $, so from $ (B \wedge E) \implies G $, we can infer $ G $.

Thus, using forward chaining, we have shown that $ G $ follows from the knowledge base.

#### ii. Backward Chaining

In backward chaining, we start with the goal and work backwards to see if it can be deduced from the known facts.

1. Goal: $ G $.
2. To infer $ G $, we need $ B \wedge E $.
3. $ E $ is a known fact.
4. To infer $ B $, we look at $ B \Leftrightarrow C $. We need either $ B $ or $ C $.
5. $ C $ can be inferred from $ A $ (using $ A \implies C $).
6. $ A $ can be inferred from $ D $ (using $ D \implies A $).
7. $ D $ is a known fact.

Since we can trace back from $ G $ to the known facts, backward chaining also shows that $ G $ is entailed by the knowledge base.

#### iii. Resolution

In resolution, we convert all statements into clauses and use the resolution rule to derive contradictions or the goal.

1. Convert KB into clauses:
   - $ A \implies C $ becomes $ \neg A \vee C $.
   - $ B \Leftrightarrow C $ becomes $ (\neg B \vee C) \wedge (\neg C \vee B) $.
   - $ D \implies A $ becomes $ \neg D \vee A $.
   - $ E $.
   - $ (B \wedge E) \implies G $ becomes $ \neg B \vee \neg E \vee G $.
   - $ B \implies F $ becomes $ \neg B \vee F $.
   - $ D $.

2. Using resolution:
   - Resolve $ D $ and $ \neg D \vee A $ to get $ A $.
   - Resolve $ A $ and $ \neg A \vee C $ to get $ C $.
   - Resolve $ C $ and $ \neg C \vee B $ to get $ B $.
   - With $ B $ and $ E $ (known fact), we get $ G $ from $ \neg B \vee \neg E \vee G $.

Thus, by resolution, we can derive $ G $ from the knowledge base.

In summary, all three methods — forward chaining, backward chaining, and resolution — demonstrate that $ G $ is entailed by the given knowledge base.

## Task 4

### Question

John and Mary sign the following contract:

- If it rains on Monday, then John must give Mary a check for $100 on Tuesday
- If John gives Mary a check for $100 on Tuesday, Mary must mow the lawn on Wednesday.

What truly happened those days is the following:
- It did not rain on Monday
- John gave Mary a check for $100 on Tueday
- Mary mowed the lawn on Wednesday.

Part a (10 pts): Write a first order logic statement to express the contract. Make sure that you clearly define what constants and predicates that you use are. (NOTE: DO NOT use functions)

Part b (8 pts): Write a logical statement to express what truly happened. When possible, use the same predicates and constants as in question 6a. If you need to define any new predicates or constants, clearly define what they stand for.

Part c (12 pts): Define the symbols required to convert any KB involved in the above domanin from FOL to Propositional logic. Use this to convert the answers to part a and b to Propositional Logic.

Part d (5 pts) (Extra Credit): Was the contract violated or not, Justify your answer [Note: Contract is definitely not violated if the events entail the contract. Contract is definitly violated if the events entail the opposite of the contract. Unknown otherwise]

### Answer

Let's break down this task step by step.

### Part a: First-Order Logic Representation of the Contract

First, let's define the predicates and constants:

- Constants: `Monday`, `Tuesday`, `Wednesday`.
- Predicates: 
  - `Rains(day)`: It rains on `day`.
  - `GivesCheck(J, M, day)`: John (`J`) gives Mary (`M`) a check on `day`.
  - `MowsLawn(M, day)`: Mary (`M`) mows the lawn on `day`.

Using these, the contract can be represented as two implications in first-order logic:

1. If it rains on Monday, then John must give Mary a check for $100 on Tuesday:
   \[ Rains(Monday) \rightarrow GivesCheck(J, M, Tuesday) \]

2. If John gives Mary a check for $100 on Tuesday, Mary must mow the lawn on Wednesday:
   \[ GivesCheck(J, M, Tuesday) \rightarrow MowsLawn(M, Wednesday) \]

### Part b: Logical Statement of the Events

Now, we express the actual events:

- It did not rain on Monday: \[ \neg Rains(Monday) \]
- John gave Mary a check for $100 on Tuesday: \[ GivesCheck(J, M, Tuesday) \]
- Mary mowed the lawn on Wednesday: \[ MowsLawn(M, Wednesday) \]

### Part c: Propositional Logic Conversion

For the conversion to propositional logic, we define the following symbols:

- \( P \): It rains on Monday.
- \( Q \): John gives Mary a check on Tuesday.
- \( R \): Mary mows the lawn on Wednesday.

Now, rewrite the first-order logic statements from parts a and b into propositional logic:

From part a:

1. \( P \rightarrow Q \)
2. \( Q \rightarrow R \)

From part b:

1. \( \neg P \)
2. \( Q \)
3. \( R \)

### Part d: Contract Violation Analysis

To analyze if the contract was violated or not, let's consider the logical implications:

- Since it did not rain on Monday (\( \neg P \)), the first clause of the contract is not applicable (John is not obligated by the rain condition to give the check).
- John still gave Mary a check on Tuesday (\( Q \)), and Mary mowed the lawn on Wednesday (\( R \)).

Since the second condition \( Q \rightarrow R \) (if John gives the check, Mary must mow the lawn) is satisfied, and the first condition \( P \rightarrow Q \) is vacuously true because \( P \) (it raining on Monday) is false, the contract has not been violated. The actions taken are in alignment with the conditions set out in the contract, even though the first condition's premise was not met.

## Task 5
### Question  

Does a unifier exist for these pairs of predicates. If they do, give the unifier

i. Taller(x, John); Taller(Bob, y)
ii. Taller(y, Mother(x)); Taller(Bob, Mother(Bob))
iii. Taller(Sam, Mary); Shorter(x, Sam)
iv. Shorter(x, Bob); Shorter(y, z)
v. Shorter(Bob, John); Shorter(x, Mary)

### Answer

In logic and computer science, a unifier is a substitution that makes two or more predicates identical. Let's analyze each pair of predicates to determine if a unifier exists:

i. `Taller(x, John); Taller(Bob, y)`

   Unifier: {x/Bob, y/John}
   
   After the substitution, both become `Taller(Bob, John)`.

ii. `Taller(y, Mother(x)); Taller(Bob, Mother(Bob))`

   Unifier: {y/Bob, x/Bob}
   
   After the substitution, both become `Taller(Bob, Mother(Bob))`.

iii. `Taller(Sam, Mary); Shorter(x, Sam)`

   No unifier exists. 

   Reason: The predicates are not of the same type ('Taller' vs 'Shorter').

iv. `Shorter(x, Bob); Shorter(y, z)`

   Unifier exists but is not specific.

   Reason: Any values for x, y, z can be a unifier as long as x = y and z = Bob.

v. `Shorter(Bob, John); Shorter(x, Mary)`

   No unifier exists.

   Reason: The constants ('Bob', 'John', 'Mary') cannot be changed and there is no substitution that makes the predicates identical.

## Task 6

### Question

Consider the 8-Puzzle problem. There are 8 tiles on a 3 by 3 grid. Your task is to get from some given configuration to a goal configuration. You can move a tile to an adjacent location as long as that location is empty.

Sample Initial configuration:
| 2 | 3 | 6 |
|---|---|---|
| 1 |   | 7 |
| 4 | 8 | 5 |

Sample Goal configuration:
| 1 | 2 | 3 |
|---|---|---|
| 4 | 5 | 6 |
| 7 | 8 |   |


Your task is to define this problem in PDDL Describe the initial state and the goal test using PDDL. Define appropriate actions for this planning problem, in the PDDL language. For each action, provide a name, arguments, preconditions, and effects.

### Answer

In PDDL (Planning Domain Definition Language), we can represent the 8-puzzle problem as follows. The domain describes the types, predicates, and actions, while the problem definition includes the specific initial state and the goal state.

### Domain Definition

::: details 
*pddl*
:::
```lisp
(define (domain eight-puzzle)

    (:requirements :strips)

    ;; Types
    (:types 
        position
    )

    ;; Predicates
    (:predicates
        (tile-at ?t - position ?p - position) ; Tile ?t is at position ?p
        (adjacent ?p1 ?p2 - position) ; Position ?p1 is adjacent to ?p2
        (empty ?p - position) ; Position ?p is empty
    )

    ;; Actions
    (:action move-tile
        :parameters (?t - position ?from - position ?to - position)
        :precondition (and (tile-at ?t ?from) (empty ?to) (adjacent ?from ?to))
        :effect (and (tile-at ?t ?to) (empty ?from) (not (tile-at ?t ?from)) (not (empty ?to)))
    )
)
```

### Problem Definition

::: details 
*pddl*
:::
```lisp
(define (problem eight-puzzle-problem)
    (:domain eight-puzzle)

    ;; Initial state
    (:init
        (tile-at t2 p1) (tile-at t3 p2) (tile-at t6 p3)
        (tile-at t1 p4) (empty p5) (tile-at t7 p6)
        (tile-at t4 p7) (tile-at t8 p8) (tile-at t5 p9)

        ;; Define adjacency (assuming p1 to p9 are the positions in the grid)
        (adjacent p1 p2) (adjacent p2 p1)
        (adjacent p2 p3) (adjacent p3 p2)
        (adjacent p4 p5) (adjacent p5 p4)
        (adjacent p5 p6) (adjacent p6 p5)
        (adjacent p7 p8) (adjacent p8 p7)
        (adjacent p8 p9) (adjacent p9 p8)
        (adjacent p1 p4) (adjacent p4 p1)
        (adjacent p2 p5) (adjacent p5 p2)
        (adjacent p3 p6) (adjacent p6 p3)
        (adjacent p4 p7) (adjacent p7 p4)
        (adjacent p5 p8) (adjacent p8 p5)
        (adjacent p6 p9) (adjacent p9 p6)
    )

    ;; Goal state
    (:goal (and
        (tile-at t1 p1) (tile-at t2 p2) (tile-at t3 p3)
        (tile-at t4 p4) (tile-at t5 p5) (tile-at t6 p6)
        (tile-at t7 p7) (tile-at t8 p8) (empty p9)
    ))
)
```

In this PDDL representation:

- The domain defines a single action type, `move-tile`, with parameters for the tile and its from/to positions. The precondition checks that the tile is in the 'from' position, the 'to' position is adjacent and empty. The effect moves the tile and updates the empty position.
  
- The problem definition specifies the initial state, with each tile's position and the empty slot, and the adjacency relationships between positions. The goal state reflects the desired configuration.

## Task 7
### Question  
Suppose that we are using PDDL to describe facts and actions in a certain world called JUNGLE. In the JUNGLE world there are 3 predicates, each predicate takes at most 4 arguments, and there are 5 constants. Give a reasonably tight bound on the number of unique states in the JUNGLE world. Justify your answer.

### Answer

Each of the 3 predicates can have a varying number of arguments ranging from 1 to 4.

For each predicate:
- When it has 1 argument, there are $5^1 = 5$ combinations (since there are 5 constants to choose from).
- When it has 4 arguments, there are $5^4 = 625$ combinations (since each argument can be any of the 5 constants).

Since there are 3 predicates, we consider the combinations for both cases (1 argument and 4 arguments) for each predicate. This gives:
- $3 \times 5^1 = 15$ combinations for the 1-argument scenario.
- $3 \times 5^4 = 1875$ combinations for the 4-argument scenario.

Now, for calculating the number of possible states, we consider that each predicate can be either true or false. Therefore, the total number of states is based on the binary possibilities for all the combinations:
- For the 15 combinations (1-argument scenario), there are $2^{15}$ possible states.
- For the 1875 combinations (4-argument scenario), there are $2^{1875}$ possible states.

These represent the range of possible states in the JUNGLE world, from the simplest scenario (where each predicate has only 1 argument) to the most complex (where each predicate has 4 arguments).

For the JUNGLE world with the specified predicates and constants:

- When each predicate has 1 argument, there are 15 possible combinations. This leads to $2^{15} = 32,768$ possible states.
- When each predicate has 4 arguments, there are 1,875 possible combinations. This leads to $2^{1875}$ possible states, which is an extraordinarily large number.


## Task 8

### Question  

Consider the following PDDL state description for the Blocks world problem.

On(A, B)
On(B, C)
On(C, Table)
On(D, E)
On(D, Table)

Consider the definition of Move(block, from, to) as given in the slides

Can you perform action Move(A, B, D) in this state.

What is the outcome of performing this action in this state.

### Answer

To determine whether the action `Move(A, B, D)` can be performed in the given state of the Blocks world and what the outcome would be, we need to consider the preconditions for the `Move` action and the state of the world before and after the action.

In the Blocks world, the typical preconditions for a `Move(block, from, to)` action are:
1. `block` is clear (i.e., no other block is on top of it).
2. `from` is the current location of `block`.
3. `to` is clear (i.e., no other block is on top of it) and different from `from`.
4. `block` is not the same as `to`.

Given the state description:
- On(A, B)
- On(B, C)
- On(C, Table)
- On(D, E)
- On(E, Table)

Let's analyze whether the action `Move(A, B, D)` can be performed:

1. **A is clear**: True, as there is no block on top of A.
2. **A is on B**: True, as stated in the state description.
3. **D is clear**: False, since E is on top of D.
4. **A is not D**: True.

Since one of the preconditions (D being clear) is not satisfied, the action `Move(A, B, D)` cannot be performed in this state.

If we hypothetically ignore the precondition that "D must be clear", and still perform the action, the resulting state would be:
- A is now on D.
- B is clear.
- C, E, and Table remain unchanged.

So, the new state would be:
- On(A, D)
- On(B, Table) (since A was moved from B)
- On(C, Table)
- On(D, E)
- On(E, Table)

But, it's important to note that in the real Blocks world problem as traditionally defined, this action would not be allowed due to the violation of the preconditions.