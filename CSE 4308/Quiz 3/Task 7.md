# Task 7
## Question  
Suppose that we are using PDDL to describe facts and actions in a certain world called JUNGLE. In the JUNGLE world there are 3 predicates, each predicate takes at most 4 arguments, and there are 5 constants. Give a reasonably tight bound on the number of unique states in the JUNGLE world. Justify your answer.

## Answer

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

