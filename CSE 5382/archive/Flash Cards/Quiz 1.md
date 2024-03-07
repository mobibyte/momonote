**What is password salting and how does it improve security?**  
Password salting enhances the security of stored passwords by combining the plaintext with a random string prior to hashing, thus ensuring that if more than one account uses the same password, the resulting hash will be unique. It helps defeat the use of rainbow tables which would otherwise speed up offline attacks against hashed passwords.  

**Alice runs a Set-UID program that is owned by Bob. The program tries to read from /tmp/x, which is readable to Alice, but not to anybody else. Can this program success fully read from the file? Why or why not? Explain your answer.**  
No. When the program runs, the effective user ID is Bob, which is hwat is used by the system to check whether the process is able to read from /tmp/x. Although the real user ID Alice can read from the file, the effective user ID does not have permission. Therefore, the read access will be denied.   

**What are some of the data conerns that must be addressed in the disposal phase of a sytem lifecycle?**  
Data residing on the system must be dispositioned in accordance with any applicable
laws or regulations. It may be required to retain or archive the data for some specific period of time or destroy the data in accordance with established practices, typically through sanitization of media or destruction of non-volatile storage devices.

**Why did Android completely remove the Set-UID and SET-GID mechanisms**  
Android completely removed the Set-UID and SET-GID mechanisms due to security concerns