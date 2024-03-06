Date: 01-30-2024
# Chapter 6
## Game Playing

## Games vs Search problems  

## Types of games

**Perfect information and deterministic**  
Chess  
Checkers  
Go  
Othello  

**Perfect information and chance**  
Backgammon  
Monopoly  

**Imperfect Information and deterministic**  
Battleships  
Blind tictactoe  

**Imperfect information and chance**  
Bridge  
Poker  
Scrabble  
Nuclear war  

## Game tree (2-player, deterministic, turns)   
**Properties**  
Finite search tree  
Will terminate in a node  

**Terminal states**  
It is possible for you to come up with a number 
E.g. in tac-tac-toe, you'd rather it end in a state with 3 X's in row  

**Utility**  
The more i want the game to end in a certain state, the higher the utility that is given for that state  

**X**  
Your turn  

**O**   
Your opponent's turn

**MAX**  
Represents your state because you want it to be as high as possible  

**MIN**  
Represents your opponent's state because you it to be as low as possible  


**Min-max algorithm**  
Perfect play strategies  

## DEMO Min-Max Algorithm  
2:23PM  

## DEMO Min-Max Algorithm  
2:26 PM 

**What type of algorithm is Min-Max?**  
Deep-first search  

**What happens if two nodes have the same min-max value?**  
You pick one at random

# Properties of minimax  
Complete? - Only if tree is finite

# DEMO 
For any non-terminal, you need toc reate an evaluation function
That tells you how stronge of a position your player is in