# Language / Grammar Hierarchy
Ordered from Most to Least General:  

**All languages**
Non-computable even with Turing Machine

**Recognizable Languages**  
Turing machine will halt on YES  
May loop infinitely otherwise  

**Decidable Langauges**  
Turing Machine will always halt, answering YES or NO.  

**Context-Sensitive Languages**  
Linear-Bounded Automaton  

**Context-Free Languages**  
Languages like LR(k) and LL(k)



# NULLABLE, FIRST, FOLLOW
**NULLABLE(X)**  
Does X ever derive empty string? 
- X derives ε directly.    
- No other non-terminals derive X without also including something else.  

Examples:
expr1 -> ε  
term1 -> ε  
 

**FIRST(X)**  
Which terminals can appear first in a string derived from X?  

Example:  
expr1 -> add_op term expr1  
FIRST(expr1) = {'+','-'}

**FOLLOW(X)**  
Which terminals can appear immediately after X?
FOLLOW(expr1) = {')', EOF }

# NULLABLE Terminal
Can a terminal be NULLABLE?
No

# NULLABLE Algorithm
What is the maximumm number of time that can be looped for a NULLABLE algorithm?  



# The relationship between Nondeterministic and Deterministic

