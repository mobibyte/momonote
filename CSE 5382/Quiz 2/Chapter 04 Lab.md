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
• The return-to-libc attack, which aims at defeating the non-executable stack countermeasure, is covered
in a separate lab.