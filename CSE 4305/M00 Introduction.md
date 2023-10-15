# First FORTRAN Manual, 1956 October 15

The IBM Mathematical Formula Translating System FORTRAN is an automatic coding system for the IBM 704 EDPM. MOre precisely, it is a 704 program which accepts a source program written in a language - the FORTRAN language - closely resembling the ordinary language of mathematics, and which produces an object program in 704 machine language, ready to be run on a 704.

FORTRAN therefore in effect transforms the 704 into a machine with which communication can be made in a language more concise and more familiar than the 704 language itself, The result should be a considerable reduction in the training required to program, as well as in the time consumed in writing programs and eliminating their errors.

# Programmable with Language

**Machine Code**  
The actual ones and zeros that the processor uses to control its operation.  
Each processor architecture has its own interpretation  

Example:  
A GCD routine for the x86 architecture

# Programming with Language  

**Assembly language**  
Gives mnemonic (!)names to the instructions, registers, etc.  
An assembler translates this into machine code.  
Eventually included more than just 1-1 correspondence.  
(e.g. macros)  

Q: How was the first assembler written?

**High-level Language**  
Gets away from any particular processor architecture. (Generally ...)
A compiler translates the high-level language to (assembly which is the translated to) machine code. (Generally ...)

At first, humans could write better assembly code than the compiler generated, so slow to catch on.  
But, reduced the number of statements that had to be written by a factor of 20!  
It took 18 staff-years (!) to write the first FORTRAN compiler.  

Q: How was the first compiler written?

# [Turing complete]  
Informally, any real-world general-purpose computer or computer language can approximately simulate the computational aspects of any other real-world general-purpose computer or computer language.

In other words, they are all the same; It's just that some may be more or less convenient for any particular computation.  

# Compiling a Program  
A compiler translates a source program into an equivalent target program and then goes away.  
At some later time, the target program can be executed.  

During compilation, the compiler is the locus of control.  
During its own execution, the target program is the locus of control.  
Typically, the compiler is a machine language program.  
Typically, the target program is also a machine language program.  
Generally leads to best performance.

Translate once, run many times.

# Interpreting a Program  
An interpreter, on the other hand, typically stays around for the execution of the target program.  
The interpreter is the locus of contorl during all parts of the execution.  
The interpreter is in effect a virtual machine whose machine language is the programming language.  

Translate every time  
Source program ->   
                   Interpreter -> Original
       Input ->

Generally, interpretation is more flexible and has better diagnostics than compilation.  
The source code of the program is still available.

Some language features are very difficult to implement without interpretation.  
"On-the-fly" code generation 

# [Read-Eval-Print Loop (REPL)] 
A Read-Eval-Print Loop is an interactive environment wherein the user types a line at a time which is then evaluated and results displayed.  
Read - Get input from user.
Eval - Determine value
Print - Display result to user
Loop - Do again, until terminated

Can be created for any text-based language, Lisp, Python, Java ...   
REPL is a one-liner in Lisp for Lisp:  
(loop (print (eval (read))))

Lot of REPLs available live and on-line:  
https://joel.franusic.com/online-reps-and-repls

We saw that REPL is a one-liner in Lisp. What about, say, Python?

Well, we could try ...  
` while True: print( eval( input() ))`

This works fine as long as we enter only expressions, not statements.

Replacing eval() with exec() will permit the evaluation of any Python code, but exec() does not return a value, so there's nothing to print.

This isn't entirely unexpected.  
After all, Python is a statement-oriented language instead of an expression-oriented language, as is Lisp.
This doesn't mean Python can't have a REPL; it clearly does as we saw in the previous screenshot.

It just means that we don't get to write it in a "clever" one-liner.  
(Thanks to Sam Thomas for the Python suggestoin. :)

# Compilation vs Interpretation  
In both cases, instructions are executed on the target processor.  

A compiler generates instructions by analyzing the source code in its entirety and optimizes the generated code based on the entire source code and specific optimizations.   

The generation of the instructions is (generally) independent of the execution of the target program.  

# Compilation vs Interpretation

An interpreter typically reads one "line" at a time.  
- it cannot perform overall analysis of the code as it does not know all of the code.  
- It therefore executes one line at a time without optimization.