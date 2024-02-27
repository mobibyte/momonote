



Queues
Queue is a linear data structure which follows a particular order in which the operations are preformed as FIFO
First in first out

Like a line at the post office
Lines have a head and a tail,

Operations on queue

Enqueue adds item to the queue
Dequeue removes an item from the queue

Head  front
Tail   end

Node for a queue look the same as a normal node

Typedef struct node
{
	Int node_number;
	Struct node *next_ptr;
}
node;

Node *Quehead = NULL, *QueueTail = NULL;

Enqueue

Void enQueue(int newnodenumber, node **Queuehead, node **QueueTail)
{
Node *NewNode = malloc(sizeof(node));
	newnode->node_number = nodenumber;
	newnode->next_ptr = NULL;
	
	/* queue is empty */
	if(*Queuehead == NULL)
	{
		*Queuehead = *Queuetail = Newnode;
	}
	Else
	{
		(*queuetail)->next_ptr = newnode;
		*queueeTail = newnode;
	}
}
DeQueue
Void deQueue( node **Queuehead)
{
Node *tempPtr = (*QueueHead)->next_ptr;

if(*Quehead == NULL)
{
	printf(“Queue is empty\n\n”);
}
Else
{
	free(*Queuehead);
	*Queuehead = tempptr;
}
}

Traversing stacks and queues is like traversing linked lists.

Typedef struct node
{
	Int node_num;
	Struct node *next_ptr;
}
node;


Recursion 

How functions are normally called
When calling a function, main gets put on pause
And executes the function called executes
And if cat calls dog, then it also pauses
When they’re all called they are all running but paused
When dog is done, it returns to cat and puts whatever value it has
Then cat finishes up and then main can continue.
The memory all these functions are taken up we need it, if we call to many then bad stuff

Recursions are functions that call themselves
But how does it stop??
Recursion is complex
Recursion existed long before computers, its like factorials
A recursive function for math is
N! = n * (n - 1)!
That into code looks like


Recursion is used with algorithms
Int factorial (int n)
{
	If ( n == 0 )
	{
		Return 1; // this is our stopping point
	}
	Else
	{
		Return (n * factorial ( n - 1)); //this helps n get to 0 to stop
	}
}

Int main (void)
{
	Int input, output;

	printf("Enter an input for the factorial " );
	scanf("%d", &input);

	Output = factorial(input);

	printf(" the result of %d! Is %d\n\n", input, output);
	
	Return 0;
}



We are creating an execution environment in recursions
With a factorial of 4 creates 5 function environments

They can use a lot of memory quickly

Reqursions are really fast but eat up your memory quickly

Debugging recursive code is interesting…


Recursive program to sum range of natural numbers

Itn main(void)
{
	Int num;
	
	printf("Enter a positive integer: ");
	scanf("%d", &num);

	printf("sum of all natural numbers from %d to 1 = %d\n", num, addnumbers(num));
}

Int addnumbers (int n)
{
	If ( n != 0 )
	{
		Return n + addnumbers(n-1); // this is our stopping point
	}
	Else
	{
		Return n; //this helps n get to 0 to stop
	}
}





Not every recursive thing needs to return something to the previous step










Noo looping but it prints down and back up
Each of these calls to printfun(test-1) is a separate environment of the function and is a copy of printfun(int test) why it prints down back up

Void printfun(int test)
{
	if  (test < 1)
	{
		Return;
	}
	Else
	{
		printf(“%d”, test);
		printfun(test-1);
		printf(“%d”, test);
		
		Return;
	}
}

Not normally looks like like this

But instead like this:

Void printfun(int test)
{
	if  (test >= 1)
	{
		printf(“%d”, test);
		printfun(test-1);
		printf(“%d”, test);
	}
}

Implicit else and just returns because it doesnt need a return when its void

Functional programming: dont use loops, use recursions

Fibonacci series
0, 1, 1, 2, 3, 5, 8, 13, 21, 34
Prev num + next num

Occurs in nature, forms a spiral
Golden ratio is fibonacci

Fibonacci can be expressed recurssivly

Unsigned long long int fibonacci (unsigned int in)
{
	If ( n == 0 || n == 1)
	{
		Return n;
	}
	Else
	{
		Return fibonacci (n-1)+ fibonacci(n-2);
	}
}

Fibonacci with recursion is slower than other methods

Any problem that can be solved recursivly can be solve iteraivly (looping)

Depends on wheen you should and shouldnt use recursion

Tree Data Structure
Linked lists,stacks and queues are linear structures
One node follows another
Each node contains ptr to next node
Trees are non-linear
More than one node can follow another
Each node contains pointers to an arbitrary number of nodes
Number of nodes can vary
Trees organize data hiearchily instead of linearly 
Like a family tree
Trees we draw upside down, root is at the top

Binary tree
Binary tree, is a tree with up to 2 child nodes
Two children are called left and right nodes
Parent nodes are nodes with children, parent nodes can be achild nodes themselves
Binary trees are used for a lot of different things
0 1 or 2 nodes only
Top of the tree is the root
Parents because they have children, and are children
Children are also parents if they have children themselve
Children who arent parents, are called leaf
Link between nodes are called edges
Length of the path from the root is called depth
Height is from the deepest leaf to the root

Binary tree node 

Typdef Struct node
{
	Int node_number;
	Struct node *left_ptr;
	Struct node *right_ptr;
}
node;

Struct node *root;

Same malloc, data, only need to set left and right ptrs to null

Add node to binary tree
Normal linked list setup
Now we need to set parents left or right ptr to the child, how do we figure out how to do it?

Node *createNewNode (int nodeNumber) //pass in the data
{
	Node *node = malloc(sizeof(nodE));
	node->left_ptr = NULL;
	node->right_pr = NULL;

	node->node_number = nodenumber;

	printf(“node number %d %p\n”, nodenumber, node);

	Return node;
}
Struct node *root;

Root = createnewnode(1);
root->left_ptr = createnewnode(2); //put in left for now
root->right_ptr = createnewnode(3); //put in right ptr 


Binary tree vs binary search tree
Binary tree = maximum of two child nodes, no order to how the nodes are organized

Binary search tree
Maximum of 2 child nodes, there is a relative order
We apply rules to make it a binary search tree
We are not going to deal with duplicate node values (its irrelevant to coding assignment, and is a lot of work)

RUles:

Values in left subtree are less than their parents
Values in right subtree are greater than its parents

The shape of the binary search tree
(want binary search tree to be balanced as possible)

BST
Every to the left is less, everything to the right is great for every Node

Order of how the data is imputed is how the tree will look

Tree structures will be traversed in a way

Breadth-first order
Cover whole layer of nodes, then the next layer (this is for algorithms class)

Depth-first
We go down a branch, then back up, then back down

Inorder traversal
Give us the nodes in increasing order
Sequential order
Preorder traversal
Parent nodes are traversed first before the child nodes
Used to get a copy of the BST
File systems us it to track your movements through files
Postorder traversal
Used to delete the tree
File systems use it to delete folders containing folders/files

Preorder //root first
	Root, left, right
	OLR
Postorder //root last
	Left right root
	LRO
Inorder //root in middle 
	Left, root , right
	LOR

Left right root = postorder
Root Left Right = preorder
Left root Right = inorder

Node *root = NULL;
AddBSTNode(&root, node_data);
void AddBSTNode(BNODE **BSTnode, char MTN[], char ZC[], char FN[], char DIM[])
{
	// If passed in BNODE is empty, then current BNODE becomes root
    if (*BSTnode == NULL)
    {
        *BSTnode = malloc(sizeof(BNODE));
        
		(*BSTnode)->left = (*BSTnode)->right = NULL;
		
		(*BSTnode)->MovieTheaterName = malloc(strlen(MTN) * sizeof(char) + 1);
        strcpy((*BSTnode)->MovieTheaterName, MTN);
        strcpy((*BSTnode)->ZipCode, ZC);
		(*BSTnode)->FileName = malloc(strlen(FN) * sizeof(char) + 1);
        strcpy((*BSTnode)->FileName, FN);
        strcpy((*BSTnode)->Dimensions, DIM);
    }
    else
    {
        if (strcmp(ZC, (*BSTnode)->ZipCode) < 0)
			AddBSTNode(&(*BSTnode)->left, MTN, ZC, FN, DIM);
		
        else if(strcmp(ZC, (*BSTnode)->ZipCode) > 0)
            AddBSTNode(&(*BSTnode)->right, MTN, ZC, FN, DIM);
        
		else
            printf(" Duplicate Element !! Not Allowed !!!");

    }
}



FEQ1
	Base conversions
	Recursion
	Command line argos
	Debug
	String handling
	Twos complement
	Bitwise operators
FEQ2
	File handling
	Structs
	Malloc
	Pointers
	Dont forget taco bell
	Need to malloc space for the array

	Lines of code laveld with a letter, match the code laveled
	Use comments to pick correct ording
	It must work as a program, and match the comments
FEQ3
	Linked lists
	Given code that forms a linked list can you 
		Add a node to the start
		Display linked list
		Add a node to the end
		Delete a node from the l list
FEQ4
	Stacks and queues
	Same thing, can you put it in order
		Push and pop node
		Explain what a stack is

	Queue
		Can you enqueue
		Dequeue

	Also displaying queue and stack
FEQ5
	BST
		Add a node to BST
		Can you traverse BST 
			Preorder, inorder, postorder
		