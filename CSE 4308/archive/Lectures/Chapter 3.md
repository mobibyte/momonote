Date: 01/18/2024

Date: 01/23/2024  

# State Based Search (Whiteboard)

How do I keep track of which state transitions used in my solution? 

This is the benefit of node based search.


# Node Based Search (Whiteboard) 
2:10 PM
*What I feel is useful to put into the node solution is the following*  

1. Pointer Ptr (that node would have been the parent)  
2. Node A
3. Depth d (the depth, how many actions needed to get to this state?)
4. Cumulative cost g(n) 
5. Action (what action did you need to take to get to this state from the previous state?)  

Nodes:  

A
1. N/A  
2. A  
3. 0  
4. 0 
5. N/A  

B  
1. A
2. B
3. 1
4. 2
5. A->B 

...

Related Slide  
Implementation: Goal Search 


# Search Strategies 
2:25 PM
Where do you add new candidates once you have them?  
Where do you remove them?
That is the only difference between fringe and graph search  
Do I insert all of them at the front? The back? That determines search strategy


# Breadth-first Search  
2:35 PM  

Nothing is stating that B should be added first or E should be added first.

# Properties of bread-first search  


Uniform Cost Traversal?
Cheapest cost first.
# Uniform

# Depth-first search
3:00 PM

# Properties of depth-first search

Date: 01/25/2024  

# Properties of depth-first search  

# Iterative Deepening Search

# Properties of iterative deepning search
Is it complete?  
Yes  

It may take a while, but eventually it will find it.  

# Graph search  
Similar to Dijkstra's Algorithm  

# Bread-first search  


14:27  
# Example: Romania  

# Romania with steps 

Heuristc

## Whiteboard example
The heuristic cost of n is n(n)
the heuristic of n is how much i think that it is going to take to get from a path.   

# Greedy Search  
To implement greedy search, you will use tree search or graph search, where the criteria is the heuristic value.  

The closer I think the node is to the gaol, that is the one I will use.  

# Properties of greedy search  

# A*  

# Properties of A*  

# A* search example    

# Admissable heuristic  
Not necessarily "accurate" heuristics

## Manhattan Distance

L = E(d) | x2 - y2 |  

## Euclidian distance  
E = sqrt(Ed(x2-y2)^2)

# Dominance  

# Relaxed Problems  


