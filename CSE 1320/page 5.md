
## fgets()

fgets(buffer, sizeof(buffer)-1, ReadFH);

Reads 1 line at a time in a file of words
Remember it stops at the enter key \n

* File pointer keeps track of where we are in the file
It moves as we do reads and writes

## Two types of access
* Sequential (VHS)
    * Open a file and just read it line by line

* Random access (DVD)
    * Allows the reading of records in any order

Two standard library functions in standard c to do this

* fseek(fp, offset, start);
    * Fp File handle
    * Offset (how many bytes do you wanna move)
    * Start (where are we moving from) must be 0 1 or 2 <- #define for these

ftell(fp);

File handle and tells us where we are

fseek(myFile, 0, 0); <- how we get back to beginning of the file

fseek(Myfile, 21, SEEK_SET);
SEEK_SET is defined as 0
SEEK_CUR = 1
SEEK_END  = 2

Formatted input and output
Sscanf() and sprintf()



sprintf(buffer, “%s %s has student id %s”, first_name, last_name, id);
Instead of printing to screen or scanning from screen it puts the stuff into buffer or a char array[];

Takes pieces and ties it together in one string

sscanf(buffer, control_string, args);

This does the opposite from sprintf(); it takes puzzle and rips the pieces out
Its like strtok but not as advanced
It parses but it looks for white spaces works good for phrases

%*s reads it and then throws away what it reads



## Layout of Memory

Higher addresses
External Data Segment
Command line arguments
Environment variables


Lower Addresses
Stack
Statically allocated variables
```
        |
        \/

        /\
	|
```

## Heap
Dynamtically allocated variables
Uninitialized Data Segment
Unitialized global and static variables
Initialized data segment
Initialized global and static variables

Code Segment
Programs source code

## Differences between Static vs statically allocated
* Static
    * Is a storage class
    * Automatically initialized as zero
    * Run for the whole program and dont get reset
* Statically allocated 
    * Like int cat
    * And how we normally do our stuff
    * At the time the program compiled we know that this variable is going to take this much memory
    * (DOES NOT MEAN STATIC STORAGE CLASS)


## Stack vs heap

Stack
* Stores auto variables
* Nice and neat stack
* Orderly
* Stack is used for static memor allocation like int cat;
* Manges memory for you
* Variables cannot be resized
* Access is easier faster and cache friendly
* Not flexible, allotted memory cannot be changed
* Faster access allocation and deallocation

Heap
* Not so nice and stacked up
* Not orderly and can become fragmented
* Used for dynamic memory allocation (ask program on fly to allocate it
* Memory management needs to be done manually
* Variables can be resized
* Causes more cache misses because of being dispersed throughout memory
* Flexible and allotted memory can be altered
* Slower access allocation and deallocation (not significant)
* Both are stored in computers RAM

## Dynamic Allocation and de-Allocation of memory
Functions for dynamic allocation and deallocation
* malloc()
* calloc()
* Realloc()
* free()

Must include stdlib.h

#### malloc()
Void *malloc(size_t size)


One parameter the num of bytes
Returns a void pointer which means it can be put into any pointer type
Memory is allocated is unitialized 

Arrayptr1 = malloc(arraysize*sizeof(int));

#### Calloc()

Void *calloc(size_t n, size_t size);
First parameter
Num of items
Second 
Size of each item
Returns address of the first byte

Malloc doesnt 0 it when freeing it up
Calloc does

Malloc is faster but doesnt zero it

#### Freeee
Void free(void *ptr);

Free should be used when allocated memory is no longer needing in order to avoid memory leaks

A memory leak is caused when a program fails to release discarded memory it caused impaired performance or failure

Free does NOT set your pointer to null
To combat this problem
You should Probably set it to NULL

#### Realloc
Void *realloc(void *ptr, size_t newsize)
Takes memory you have and makes it BIGGER

Whether or not itl change the pointer depends sorta

Sometimes realloc will move the address sometimes it wont
Its literally the perfect mover no headache except the new memory has trash

Old data is not lost and newly allocated memory is not initialized

If it falls you will get back null and the old memory remains the same

Always adds new stuff to the end of it


How do we move things around?
A bit harder to do but possible
Linked lists enable this
But also make it EASIER


## Linked List
Linked list are a linear data structure consists of groups of nodes in a sequence

## Nodes
Pieces of a linked list (like array’s cells we say linked lists nodes)

Nodes are just a struct
Is going to malloc 
Contains a pointer within a struct 
* NODES ALWAYS CONTAIN A POINTER

Holds the address of the next node
Each node holds it own data 
But always holds the address of the next node like link in a chain
Hence linked list

Not necessarily next to each other in memory
(never make assumptions where the nodes are in memory)

Advantages
* Dynamic: therefore only allocate memory when you need to
Insertions and deletions operations are easily implemented
Stacks and queues can be easily executed

Disadvantages
* Memory is wanted due to extra storage needed for pointer
No element can be accessed randomly 
Sequentially accessed like VHS tapes




## Single linked list
Only 1 node can see another node
Thats why it cant be randomly accessed

How to think of linked list in memory

Heads are just the pointer to the first node

Last one always gets pointed to null (its like null terminating a string)

If you want to add a node to a linked list:
Create a new node malloc it 
And depending on where we wanna add it its easy to do.
If you wanna change it to be on the end, we change the null ptr to the new node

#### Inserting a node
* You point the node behind,and point the new node to the next one
So much easier, no one gets moved only have to change 2 ptrs

#### Delete a node
* You have to free the node
Then change the ptr to null if its pointing to nothing
Just change the ptrs
Does not require data to be moved

Not much code involved with linked lists

Head node
Code partt

```
Struct node
{
	Int node_number;
	Struct node *next_ptr; //works because its not nesting a struct inside of itself, its a ptr
};
```

```
//creating the head node
Struct node *LinkedListHead;// not a node but a ptr of type node
LinkedListHead = NULL; //MUST SET THE HEAD TO NULL

 //can be lots of other data, you dont need to number the nodes


Struct node *NewNode;
NewNode = malloc(sizeof(struct node));
NewNode->node_number = NodeNumbeToAddl
NewNode->next_ptr = NULL;

If (LinkedListHead == NULL)
{
Linkedlisthead = newnode;
}

```
Traversing through linked list + displaying node
// this is essential

```
TempPtr = LinkedListHead; //start at the head

While (TempPtr->next_ptr != NULL)
{
    Temptr = temptr->next_ptr
}
//Stops at the last node

While (TempPtr != NULL) //this is different than the one above
//Pasts the last node
```

### Inserting nodes

```
Struct node *temptr, *Newnode, *preptr;

Prevptr = NULL;
Tempptr = Linkedlist

While (Tempptr != NULL && Tempptr->node_number < nodenumbertoinsert) //node number is example
{
    Prevptr = temptr;
    Tempptr = temptr->next_ptr;
}

if(prevptr == NULL)
{
    Linkedlisthead = newNode;
}
Else
{
   Prevptr->next_ptr = newnode;
}

Put print statement inside of traversal to display a linked list
```

#### Display nodes
* use the (tempptr != NULL) while loop to print the whole list

### Deleting node
* Code for deleting is similar to inserting

```
Temptr = linkedlisthead; prevptr=  null;
While (tempptr->next_ptr != NULL && temptr->noe_number !- Numberofnodetodelete)
{
	Prevptr = temptpr;
	Temptpr = temptpr->next_ptr
}
if(temptpr->node_number == numberofnodetodelete)
{
   If (temptr == Linkedlisthead)
   {
       Linkedlist head = temptr->next_ptr;
   }
   Else
   {
      prevptr ->next_ptr = temptr->next_ptr;
   }
   free(tempptr);
}
else
{
   printf(“this is not the node you’re looking for\n”);
}
```


Very similar to inserting.
#### Counting nodes

```
Struct node *TEmpPtr;
Int node_count = 0;

Tempptr = linkedlisthead;

while(temptptr != NULL)
{
   Tempptr =tempptr->next_ptr;
   Node_count++;
}
```



Easiest way to see how your linked list looks is to draw it out after counting how many you have.

```
Newnode = malloc(sizeof(node));
if(*Linkedlisthead == null)
{
	*Linkedlisthead = Newnode;
}
Else
{
	Tempptr = *Linkedlisthead;
	While ( tempptr->next_ptr != NULL)
	{
		Temptpr = tempptr->next_ptr;
	}

	tempptr->next_ptr = newnode;
}

Typedef structs nodes
Typedef struct node
{
	Int node_number;
	Struct node *next_ptr;
}
Node;

Node *linkedlisthead = NULL;
```

Passing head of linkedlist is easy

displaylinkedlist(linkedlisthead);
That easy


read a file with variable length fields using dynamic memory allocation
## Tacobell example

Want to store it without arrays

```
Typedef struct
{
	Char *category;
	Char *name;
	Char *whatsincluded;
}
TACOBELL;

Int main(int argc, char *argv[])
{
	TACOBELL menu[20] = {};
	Char *token = NULL;
	Char filename[20] = {};
	FILE *FH = NULL;
	Char fileline[200];
	Int menucount = 0;
	Int i;

	strcpy(filename, argv[1]);
	FH = fopen(filename, “r+”);

	If ( FH == NULL)
	{
		printf(“File did not open);
		exit(0);
	}
	
	While ( fgets(fileline, sizeof(fileline)-1, FH) )
	{
		Token = strtok(Fileline, “|”);
		Menu{MenuCount].category = malloc (strlen(token)*sizeof(char)+1); 

        /*because we malloced this space we know tacos is ours */

		strcpy(Menu[MenuCount].category, token);
		
		Token = strtok(NULL, “|”);
		Menu{MenuCount].name = malloc (strlen(token)*sizeof(char)+1);
        strcpy(Menu[MenuCount].name, token); 

        Token = strtok(NULL, “|”);
        Menu{MenuCount].whatsincluded = malloc (strlen(token)*sizeof(char)+1);
        strcpy(Menu[MenuCount].whatsincluded, token); 

        menucount++;

	}
For (i = 0; i<menucount; i++)
{
    printf(“category : %s\n Name       : %s\n what’s included : %s\n\n”, menu[i].category, menu[i].name, menu[i].whatsincluded;

}
```


## Stacks and Queues
Just linked lists with rules

### Stack
Stack is a linear data structure that follows a particular order in which the operations are preformed. The order will be LIFO (Last in First Out).

* LIFO works like a stack of plates.
* Stacks can be popped(taken out) and pushed( put back in)
* Operations on stack
    * Push: adds an item to the stack
    * Pop: removes an item from the stack.
    * Peek: returns element of top stack
* isEmpty returns true if stack is empty, else false
* A lot of things use stacks, the undo button, is a stack

```
Typedef struct node
{
	Int node_number:
	Struct node *next_ptr;
}
node:
```

* Stack is literally a linked list but with rules

```
Node *StackTop = NULL; (could call it linkedlisthead but since we have stack rules yknow)
```

Stacks are meant for push and pop, nothing more 



### Stack Push

```
Void push(node **StackTop, int Node_Number)
{
	Node *NewNode = malloc(sizeof(node));
	newnode->node_number = nodenumber;
	newnode->next_ptr = NULL;

	if(*StackTop == NULL)
	{
		*StackTop = Newnode;
	}
	Else
	{
		newnode->next_ptr = *StackTop;
		*Stacktop = newnode;
	}
}
```

### Stack Pop
```
Void pop(node **STackTop)
{
	Node *Temptr = (*StackTop)->next_ptr;
	
	if(*Stacktop == NULL)
	{
		printf(“Stack is empty\n\n”);
	}
	Else
	{
		free(*StackTop);
		*StackTop = TempPtr;
	}
}
```
