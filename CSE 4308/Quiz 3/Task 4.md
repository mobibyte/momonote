## Question

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

## Answer

Let's break down this task step by step.

### Part a: First-Order Logic Representation of the Contract

First, let's define the predicates and constants:

- Constants: `Monday`, `Tuesday`, `Wednesday`.
- Predicates: 
  - `Rains(day)`: It rains on `day`.
  - `GivesCheck(J, M, day)`: John (`J`) gives Mary (`M`) a check on `day`.
  - `MowsLawn(M, day)`: Mary (`M`) mows the lawn on `day`.

Using these, the contract can be represented as two implications in first-order logic:

1. If it rains on Monday, then John must give Mary a check for 100 dollars on Tuesday:
   $Rains(Monday) \rightarrow GivesCheck(J, M, Tuesday)$

2. If John gives Mary a check for 100 dollars on Tuesday, Mary must mow the lawn on Wednesday:
   $GivesCheck(J, M, Tuesday) \rightarrow MowsLawn(M, Wednesday)$

### Part b: Logical Statement of the Events

Now, we express the actual events:

- It did not rain on Monday: $\neg Rains(Monday)$
- John gave Mary a check for 100 dollars on Tuesday: $GivesCheck(J, M, Tuesday)$
- Mary mowed the lawn on Wednesday: $MowsLawn(M, Wednesday)$

### Part c: Propositional Logic Conversion

For the conversion to propositional logic, we define the following symbols:

- $P$: It rains on Monday.
- $Q$: John gives Mary a check on Tuesday.
- $R$: Mary mows the lawn on Wednesday.

Now, rewrite the first-order logic statements from parts a and b into propositional logic:

From part a:

1. $ P \rightarrow Q $
2. $ Q \rightarrow R $

From part b:

1. $ \neg P $
2. $ Q $
3. $ R $

### Part d: Contract Violation Analysis

To analyze if the contract was violated or not, let's consider the logical implications:

- Since it did not rain on Monday ($ \neg P $), the first clause of the contract is not applicable (John is not obligated by the rain condition to give the check).
- John still gave Mary a check on Tuesday ($ Q $), and Mary mowed the lawn on Wednesday ($ R $).

Since the second condition $ Q \rightarrow R $ (if John gives the check, Mary must mow the lawn) is satisfied, and the first condition $ P \rightarrow Q $ is vacuously true because $ P $ (it raining on Monday) is false, the contract has not been violated. The actions taken are in alignment with the conditions set out in the contract, even though the first condition's premise was not met.
