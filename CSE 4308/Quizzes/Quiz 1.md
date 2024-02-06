# Task 1  
**Consider the navigation problem shown in Figure 1.**

**The number next to each edge is the cost of the performing the action corresponding to that edge.** 
**You start from A and your goal is to get to F.** 
List 
1. the order in which nodes are expanded
2. which nodes are added to the fringe
3. which states are added to the closed set when performing Graph Search using:
- breadth-first search  
- depth-first search  
- iterative deepening search  
- uniform cost search

## Breadth-first search
Fringe is A  

| Nodes Popped | State Added to Closed| Nodes Added to Fringe |
|--------------|----------------------|-----------------------|
| A            | A                    | B C                   |
| B            | B                    | A C E D               |


# Task 2  
A social network graph (SNG) is a graph where each vertex is a person and each edge represents an acquaintance.  
In other words, an SNG is a graph showing who knows who. 
For example, in the graph shown on Figure 2, 
- George knows Mary and John, 
- Mary knows Christine, 
- Peter and George, 
- John knows Christine, 
- Helen and George, 
- Christine knows Mary and John  
- Helen knows John, 
- Peter knows Mary.
The degrees of separation measure how closely connected two people are in the graph. 
For example, John has 
- 0 degrees of separation from himself, 
- 1 degree of separation from Christine, 
- 2 degrees of separation from Mary, and 
- 3 degrees of separation from Peter.


1. From among general tree search using breadth-first search, depth-first search, iterative deepening search, and uniform cost search, which one(s) guarantee finding the correct number of degrees of separation between any two people in the graph?

2. For the SNG shown in Figure 2, draw the first three levels of the search tree, with John as the starting point (the first level of the tree is the root).

3. Is there a one-to-one correspondence between nodes in the search tree and vertices in the SNG (i.e. does every node in the search tree correspond to a vertex in the SNG)? Why, or why not? In your answer here, you should assume that the search algorithm does not try to avoid revisiting the same state.

4. Draw an SNG containing exactly 5 people, where at least two people have 4 degrees of separation between them.

5. Draw an SNG containing exactly 5 people, where all people have 1 degree of separation between them.

6. In an implementation of breadth-first tree search for finding degrees of separation, suppose that every node in the search tree takes 1KB of memory. Suppose that the SNG contains one million people. Outline (briefly but precisely) how to make sure that the memory required to store search tree nodes will not exceed 1GB (the correct answer can be described in one-two lines of text). In your answer here you are free to enhance/modify the breadth-first search implementation as you wish, as long as it remains breadth-first (a modification that, for example, converts breadth-first search into depth-first search or iterative deepening search is not allowed). 

# Task 3  

Consider the search space shown in Figure 3. 
D is the only goal state. 
Costs are undirected. 
For each of the following heuristics, determine if it is admissible or not. 
For non-admissible heuristics, modify their values as needed to make them admissible.

Heuristic 1:
      h(A) = 5
      h(B) = 20
      h(C) = 15
      h(D) = 0
      h(E) = 10
      h(F) = 0

Heuristic 2:
      h(A) = 45
      h(B) = 45
      h(C) = 45
      h(D) = 45
      h(E) = 45
      h(F) = 45

Heuristic 3:
      h(A) = 10
      h(B) = 15
      h(C) = 0
      h(D) = 0
      h(E) = 25
      h(F) = 5

Heuristic 4:
      h(A) = 0
      h(B) = 0
      h(C) = 0
      h(D) = 0
      h(E) = 0
      h(F) = 0


# Task 5  
Figures 4 and 5 show maps where all the towns are on a grid. 
Each town T has coordinates (Ti, Tj), 
where Ti Tj are non-negative integers. 
We use the term Euclidean distance for the straight-line distance between two towns, 
and the term driving distance for the length of the shortest driving route connecting two towns. 

The only roads that exist connect towns that have Euclidean (straight-line) distance 1 from each other (however, there may be towns with Euclidean distance 1 from each other that are NOT directly connected by a road, for example in Figure 5).

Note: Euclidean distance formula is given here.

Consider greedy search, where the node to be expanded is always the one with the shortest Euclidean distance to the destination. 
Also consider A* search, where h(n) is the Euclidean distance from n to the destination (remember that the next node is picked not based on h(n) but based on f(n) = g(n) + h(n)). 

For each of the maps showing on Figures 4 and 5, which of the following statements is true?

    Greedy search always performs better than or the same as A*.
    Greedy search always performs worse than or the same as A*.
    Greedy search performs sometimes better, sometimes worse, and sometimes the same as A*, depending on the start and end states.

Justify your answer. For the purposes of this question, the performance of a search algorithm is simply measured by the number of nodes visited by that algorithm. Note that you have to provide separate answers for Figure 4 and for Figure 5.