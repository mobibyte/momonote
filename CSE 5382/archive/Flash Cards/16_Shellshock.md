**Shell program**  
A command-line interpreter in operating systems  

Provides an interface between the user and operating sysytem  

**Different types of shell**  
- sh  
- bash  
- csh  
- zsh  
- windows powershell  
- etc  

**Which is one of the most popular shell programs in the Linux OS?**  
Bash shell  

**Shellshock vulnerability**  
is related to shell functions  

**Example of a shell function**
```
$ foo() {echo "Inside function; }  
# declare -f foo  
foo ()  
{
    echo "Inside function"
}
$ foo  
Inside function  
$ unset -f foo  
$ declare -f foo  
```

**Approach 1 to pass shell function to child process**  
Define the function in the parent shell and export it.  
The child process will then have it.  

**Approach 2 to pass shell function to child process**  
Define an environment variable.  
It will become a function definition in the child bash process.  

**The two approaches to pass shell function to child process. How are they similar?**  
They both use environment variables  

**The two approaches to pass shell function to child process. How are they different?**  
Approach 2 does not require the parent process to be a shell process.  

**Any process that needs to pass a function definition to the child bash process**  
can simple use environment variables.  

**Shellshock**  
A vulnerability that exploited a mistake made by bash when it converts environment variable to function definition.  

**Bash executes some of the command contained in the variable due to**  
a bug in the parsing logic  

**The shellshock bug starts in**  
the variables.c file in the bash source code  

**What are the consequences to the parse_and_execute() example?**  
Attacker can get process to run their commands.  
If the target is a server process or runs with a privilege, security breaches can occur.  
