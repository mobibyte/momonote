# Task 5
## Question  

Does a unifier exist for these pairs of predicates. If they do, give the unifier

i. Taller(x, John); Taller(Bob, y)
ii. Taller(y, Mother(x)); Taller(Bob, Mother(Bob))
iii. Taller(Sam, Mary); Shorter(x, Sam)
iv. Shorter(x, Bob); Shorter(y, z)
v. Shorter(Bob, John); Shorter(x, Mary)

## Answer

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
