# SetUID
Date: 01-26-2024  

# WPA2 Crack  

# Introduction  

1:45 PM
# Demo: SEEDUbuntu2004
man shadow
man -s 3 crypt  
* to show the hash structure    

On Linux, passwords are salted.
Salting defeats what sort of attack? Building rainbow tables  
If I'm able to precompute the total possible of characters for a password, hash them, and build a rainbow table, then I can just match that hash. 

If you salt it, before you actually hash it, you take a random string, concatonate it with the actual password, and then hash it.  

Hashing is a oneway deterministic mathematical function. If two users have two different salts, then the passwords are going to be unique.  

The salt is not considered a secret.  If i wanted to figure out a particular users password, then I'll have to compute a unique set of rainbow tables, which is expensive.  

Given the salt doesn't change, you'll be able to brute force.  

If here are unique salts, that basically renders the attack impractical.

Windows does not use salting for their passwords.

# Two-Tier Approach  
Operating Systems are complex. We try to architect in a way that we don't put too much complexity in the kernel of the OS.  
It is designed to think in a pretty straightforward way.  

# Demo 

cp /user/bin/cat  
sudo chown root mycat
ls-al
 

3:20 PM
# Demo
"important you understand"  
v[0] = "/bin/cat";  # is immutable   # the command we're running

v[1] = argv[1]; # whatever else is passed in

v[2] = 0; # last element has to be 0 # You must always have an additional value, a null argument, to know where the end of the list is  

There's nothing the user can do to change the meaning of what is happening here.  
This does not suffer from the vulnerabilitiy of the last example. 

safecatall safecaatall.c  
sudo chown root safecatall  
sudo chmod 4755 safecatall
./safecatall "/etc/shadow; id" 

# Privilege Management Considerations 
You want code to be atomic ***  
Code is running, and signal comes in. It is running in the interrupt handler, and a higher privilege is granted, and you don't know if an exploit has just been opened.
