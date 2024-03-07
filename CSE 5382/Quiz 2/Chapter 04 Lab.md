# Buffer Overflow Attack Lab (Set-UID Version)

## 1 Overview
Buffer overflow is defined as the condition in which a program attempts to write data beyond the boundary
of a buffer. This vulnerability can be used by a malicious user to alter the flow control of the program,
leading to the execution of malicious code. The objective of this lab is for students to gain practical insights
into this type of vulnerability, and learn how to exploit the vulnerability in attacks.

In this lab, students will be given a program with a buffer-overflow vulnerability; their task is to develop
a scheme to exploit the vulnerability and finally gain the root privilege. In addition to the attacks, students
will be guided to walk through several protection schemes that have been implemented in the operating
system to counter against buffer-overflow attacks. Students need to evaluate whether the schemes work or
not and explain why. This lab covers the following topics:
• Buffer overflow vulnerability and attack
• Stack layout
• Address randomization, non-executable stack, and StackGuard
• Shellcode (32-bit and 64-bit)
• The return-to-libc attack, which aims at defeating the non-executable stack countermeasure, is covered in a separate lab.  

**Readings and videos.** Detailed coverage of the buffer-overflow attack can be found in the following:  
- Chapter 4 of the SEED Book, Computer & Internet Security: A Hands-on Approach, 2nd Edition, by Wenliang Du. See details at https://www.handsonsecurity.net.  
- Section 4 of the SEED Lecture at Udemy, Computer Security: A Hands-on Approach, by Wenliang Du. See details at https://www.handsonsecurity.net/video.html.  

**Lab environment.** This lab has been tested on the SEED Ubuntu 20.04 VM. You can download a pre-built image from the SEED website, and run the SEED VM on your own computer. However, most of the SEED labs can be conducted on the cloud, and you can follow our instruction to create a SEED VM on the cloud.

**Note for instructors.** Instructors can customize this lab by choosing values for L1, ..., L4. See Section 4 for details. Depending on the background of students and the time allocated for this lab, instructors can also make the Level-2, Level-3, and Level-4 tasks (or some of them) optional. The Level-1 task is sufficient to cover the basics of the buffer-overflow attacks. Levels 2 to 4 increase the attack difficulties. All the countermeasure tasks are based on the Level-1 task, so skipping the other levels does not affect those tasks.  

## 2 Environment Setup  

### 2.1 Turning Off Countermeasures  
Modern operating systems have implemented several security mechanisms to make the buffer-overflow at- tack difficult. To simplify our attacks, we need to disable them first. Later on, we will enable them and see whether our attack can still be successful or not.  

**Address Space Randomization.** Ubuntu and several other Linux-based systems uses address space ran- domization to randomize the starting address of heap and stack. This makes guessing the exact addresses difficult; guessing addresses is one of the critical steps of buffer-overflow attacks. This feature can be dis- abled using the following command:  
> $ sudo sysctl -w kernel.randomize_va_space=0  

**Configuring /bin/sh.** In the recent versions of Ubuntu OS, the /bin/sh symbolic link points to the /bin/dash shell. The dash program, as well as bash, has implemented a security countermeasure that prevents itself from being executed in a Set-UID process. Basically, if they detect that they are executed in a Set-UID process, they will immediately change the effective user ID to the process’s real user ID, essentially dropping the privilege.  

Since our victim program is a Set-UID program, and our attack relies on running /bin/sh, the countermeasure in /bin/dash makes our attack more difficult. Therefore, we will link /bin/sh to another shell that does not have such a countermeasure (in later tasks, we will show that with a little bit more effort, the countermeasure in /bin/dash can be easily defeated). We have installed a shell program called zsh in our Ubuntu 20.04 VM. The following command can be used to link /bin/sh to zsh:

> $ sudo ln -sf /bin/zsh /bin/sh  

**StackGuard and Non-Executable Stack.**  These are two additional countermeasures implemented in the system. They can be turned off during the compilation. We will discuss them later when we compile the vulnerable program.
  

## 3 Task 1: Getting Familiar with Shellcode  
The ultimate goal of buffer-overflow attacks is to inject malicious code into the target program, so the code can be executed using the target program’s privilege. Shellcode is widely used in most code-injection attacks. Let us get familiar with it in this task.  

### 3.1 The C Version of Shellcode  

A shellcode is basically a piece of code that launches a shell. If we use C code to implement it, it will look like the following:  

```
#include <stdio.h>
int main() {
    char *name[2];
    name[0] = "/bin/sh";
    name[1] = NULL;
    execve(name[0], name, NULL);
}
```

Unfortunately, we cannot just compile this code and use the binary code as our shellcode (detailed explanation is provided in the SEED book). The best way to write a shellcode is to use assembly code. In this lab, we only provide the binary version of a shellcode, without explaining how it works (it is non-trivial). If you are interested in how exactly shellcode works and you want to write a shellcode from scratch, you can learn that from a separate SEED lab called Shellcode Lab.

### 3.2 32-bit Shellcode  

```
; Store the command on stack
xor  eax, eax
push eax
push "//sh"
push "/bin"
mov  ebx, esp     ; ebx --> "/bin//sh": execve()’s 1st argument
; Construct the argument array argv[]
push eax
push ebx
mov  ecx, esp
; argv[1] = 0
; argv[0] --> "/bin//sh"
; ecx --> argv[]: execve()’s 2nd argument
; For environment variable
xor edx, edx
; Invoke execve()
xor eax,eax mov al, 0x0b
; edx = 0: execve()’s 3rd argument
;
; execve()’s system call number
int 0x80
```

The shellcode above basically invokes the execve() system call to execute /bin/sh. In a separate SEED lab, the Shellcode lab, we guide students to write shellcode from scratch. Here we only give a very brief explanation.

- The third instruction pushes "//sh", rather than "/sh" into the stack. This is because we need a 32-bit number here, and "/sh" has only 24 bits. Fortunately, "//" is equivalent to "/", so we can get away with a double slash symbol.

- We need to pass three arguments to execve() via the ebx, ecx and edx registers, respectively. The majority of the shellcode basically constructs the content for these three arguments.

- The system call execve() is called when we set al to 0x0b, and execute "int 0x80".  

