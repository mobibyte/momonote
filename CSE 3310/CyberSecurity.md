# CyberSecurity/Security Engineering

- Tools, techniques and methods to support the development and maintenance of systems that can resist malicious attacks that are intended to damage a computer system or its data
- Malicious software == Malware
- this is a subfield of the broader field of computer security

## Security Dimensions

- Confidentiality
  - Information in a system may be disclosed or made accessible to people or programs that are not authorized to have access to that info.
- Integrity
  - Information in a system may be damaged or corrupted making it unusual or unreliable.
- Availability
  - Access to a system or its data that is normally available may not be possible

## Security 

- The security of a system is a system property that reflects the sytems ability to protect itself from accidental or deliberate external attacks.
- Security is essential as most systems are networked so that external access to the system through the internet is possible.
- Security is an essential pre-requisite for avalibiltiy, reliability and safety.

## Security Terminology

Know these definitions

- Asset
  - Something of value which has to be protected.
- Attack
  - An exploitation of a systems vulnerability. Generally, this is from outside the system and is a deliberate attempt to cause some damage.
- Control
  - A protective measure that reduces a systems vulnerability. encryption is an example of control that reduces a vulnerabiltiy of weak access control system
- Exposure
  - Possible loss or harm to a computing system. This can be loss or damage to data, or time and effor to recovery after a security breach.
- Threat
  - Circumstances that have potential cuase loss or harm. (system vulnerabiltiy that is subjected to an attack)
- Vulnerabiltiy
  - A weakness in a computer-based system that may be exploited to cause loss or harm.

## Threat types (IMPORTANT)

Know these 

- Interception threats
  - Allows an attacker to gain access to an asset
- Interruption threats
  - Allows an attacker to make part of the system unavailable.
  - A possible threat might be (DoS) Denial of Service
  - A possible threat might be (DDoS) Distributed Denial of Service
- Modification Threats
  - Allow an attacker to tamper with system asset
  - E.g. attacker alters or destroys a user record 
- Fabrication threat
  - Allows an attacker to insert false information into a system
  - E.g. False transactions might be added to the system that trnasfers money to the perps bank account (or out of your bank account!)

## Types of security requirements (IMPORTANT)

- Identification
- Authentication
- Authorization
- Immunity (i.e. protection)
- Integrity 
- Intrustion Detection
- Non-repudiation (i.e. undeniable)
- Privacy
- Security Auditing
- System maintenance security

(these are all requirmenets)

## Security requirement classification (IMPORTANT)

- Risk:
  - Avoidance
    - risks that should be avoided by designing system so that hese risks cannot arise
  - Detection
    - Define mechanisms that identify risks if it does arise, and neutrilize the risk before loss
  - Mitigation
    - Set out how system should be designed so that it can recover from and restore sys. assets after loss has occurred

## What is a bot? (IMPORTANT)

- a bot is an automated software application that preforms reptitive tasks over a network.
  - It follows instructions to imitate human behavior but is faster and more accurate.
  - A bot can also run independenetly without human intervention
- An org. or individual can use a bot to replace repetitive tasks.
- Bots are super fast
- They can also be malicous in the form of malware

## Main Cybersecurity Threats (IMPORTANT)

know these definitions and what they are

- Viruses
- Worms
- Trojan Horse
- Social Engineering
- Phishing 
- Ransomware
- Pharming
- Zombie Botnets
- Rootkits
- Man-in-the-middle (MITM)

## Viruses

- a virus is a program that spreads first by infecting files or system areas of a computer/networks hard drive.
  - it makes copies of itself and spreads to other computers (through attaching itself to programs, files, or the disk)
  - Some viruses are harmless and other may damage files, or destroy them.
    - (they're just computer programs that can be written to do malicous things.)
- Unlike worms, viruses require user action
  - e.g. Opening email attachement or visiting a malicious web page

## Worms

- A worm is a type of virus that can spread **Without human interaction**
- They spread from computer to computer taking up valuable memory and network bandwith, which can cause computers to stop working.
  - They do this by replicating itself and sending copies from computer to computer across network connections.
- Worms can also allow attackers to gain access to your computer remotely (sort of a backdoor)

## Trojan Horse

- Trojan horse is a computer program that is hiding a virus or other malicious software.
  - It can be a program that looks like normal software and works normally but in the background its running malware on your computer as well
- Usually obtained by downloading free games(or software) or as an email attachement
- **They tend to masquerade as a proper program while quietly destroying data or your system in the background**

## Social Engineering

- While not having to directly relate to computer virueses or programs, it instead is a tactic of manipulating, influencing or deceiving a victim in order to gain control over a computer system/steal personal data.
  - A lot of hacking truely does come from social engineering, this reminds me of the time a casino was hacked because the employees were social engineered.
  - https://arcticwolf.com/resources/blog/major-casinos-hacked-using-social-engineering-attacks/ (this is a short article on what i was talking about)

## Phishing

- Phishing is when attackers send scam emails/texts that contain links to malicious websites, the websites may contain malware (such as ransomware).
  - An example of this is when UPS sends you text to confirm your order, you go to their website they sent you, fill your info, and suddenly you gave a bunch of your information to "UPS" which is really a hacker trying to collect your data and steal your credit card.
- Counterfeit Emails are usually the most commmon method to do this, but texting is becoming more prevalent

(IMPORTANT)

The 4 phishing types are 
- Spear Phishing
- Whaling
- Vishing
- Email Phising

### Spear Phishing

- Spear Phishing is a type of phishing attack that targets specific individuals or orgs. typically through malicous emails.
  - Goal is to steal sensitive info, such as login credentials, or infect the targets device with malware.

### Whaling

- This is a highly targeted phishing attack aimed at senior executives.
  - It pretends to be a legit email, but it digitally enableds fraud through social engineering to encourage victims to preform a secondary action
    - e.g. If you are a senior executive at a company, you may be asked to sign a contract that will allow the company to access your personal information
    - e.g. initiating a wire transfer of funds.

### Vishing

- Vishing or "voice phishing" involves defrauding people over the phone (also another social engineering tactic)
  - e.g. The IRS calls you because you didn't pay your taxs correctly (The IRS will never call you ever, unless you call them first!)
- Usually done to get sensitive info out of you.

### Email PHishing

- The most common type is when attackers send scame emails/texts that contain links to malicous websites previously mentioned before

## Ransomware

- Type of malware which prevents you from accessing your device and the data stored on it, usually by encrypting your files.
  - A criminal group will then demand ransom in exchange for decryption, the computer data could become locked, encrypted, stolen or destroyed.

### Two types of Ransomware

- Crypto-Ransomware
  - Type of harmful program that encrypts files stored on a computer in order to extort for money. 
- Locker Ransomware
  - Type of Ransomware that doesn't use encryption, but instead it prevents the user from using their device.
  - The ransomeware will then display a message to the user that extorts fee to restore access to their device

## Pharming

- Sophistaticated type of fraudulent acitivty that redirects internet users to fake websites to steal data from them.
  - e.g. You go to amazon and it redirects you to a fake amazon that steals your info when you purchase an item (or login to your account)

## Zombie Botnet

- Botnets
  - They are a number of compromised computers used to create/send spam, viruses, or flood a network with messages as a (DoS) attack.
  - The compromised computers are called zombies
- The malware usually includes a component that allwos the attacker to control the infected computer remotly, typically via a command-and-control-server
- Once the botnet is established, the attacker can issue commands to zombie computers, directed them to prevorm various activities.
  - e.g. spam emails, DoS attacks, spreading malware, and helping botnet grow

## Rootkit

- Type of malware program that enables cyber criminals to gain access to machines without being detected
  - Commonly referred to as a "Backdoor"
- Upon penetrating a computer, a hacker may install a collection of programs (called a rootkit)
- This enables
  - Easy access for the hacker (and others) ionto the enterprise
  - Keystroke logger 
- Eliminates evidence of break-in
- Modifies the OS

## Man-in-the-Middle Attack (MITM)

- This type of attack involves a threat actor putting themselves in the middle of two paries, typically a suer and an application to intercept their communications and data and use them for malicous purposes
  - e.g. When someone on a public network is packet sniffing for data that is unencrypted then using that data to login to your accounts

## Dependable Programming guidlines

There are 8 of them (IMPORTANT)

1. Limit visiblity of information in a program
2. Check all inputs for validity
3. Provide a handler for all exceptions
4. Minimize the use of error-prone constructs
5. Provide restart capabilities
6. Check array bounds
7. include timeouts when calling external components
8. Name all constants that represent real-world values

