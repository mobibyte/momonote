# First-Order Logic  
Date: 02-27-2024  
Link: https://crystal.uta.edu/%7Egopikrishnav/classes/common/4308_5360/slides/fol.pdf

**Objects**  
Called constants
Examples:
- John
- Mary  


## Relations and Functions  
Should "sibling" be a relation or a function?
- Relation: siblings(John, Mary)
- Function: sibling(John) returns Mary  

"Sibling" should be a relation, because someone can
have many (or no) siblings. A function can only
return one value.  

## Basic Elements of First Order Logic  
In propositional logic we only had symbols and
connectives.  

In first-order logic we have NO SYMBOLS. Instead,
we have:
- Constants.
- Predicates.
- Functions.
- Connectives (and, or, not, if, iff).
- The equal sign = (a "special" predicate).
- Variables.
- Quantifiers, ∀ (for every), ∃ (there exists).  

## Demo
Timestamp:  
02-27-2024  
03:17 PM  

Taller(Bob, x)  
x is a free variable. It has no inherent truth value.  
If you are using a variable, it has to be quantified.  
- universal quantifier  
- existential quantifier

If you universally quantify a variable, it does not matter what I plug in for x, it is true.  
You have to be very careful when using quantifiers. If you say for all x, you mean for all x.  

Universal Quantifier
(∀x)[Taller(Bob, x)]  

Existential Quantifier  
(∃x)[Taller(Bob, x)]  
