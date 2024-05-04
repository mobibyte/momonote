# Distributed Systems

* Virtually all large computer-based systems are now distributed systems.
* Information processing is distributted over several computers rather confined to a single machine.
* Distributed SWE is therefore very important for enterprise computing systems
  * Enterprise is when a business is about more than one thing
  * usually multiple businesses
* one of the largest problems with this is security.

## System Types: SUPER IMPORTANT

* Personal Systems that are not distrubted and that are designed to run on a personal computer or workstation.
* Embedded Systems: that run on a single processor or on an integrated grou of processors.
* Distributed Systems: Where the system software runs on a loosely integrated gorup of cooperating processors linked by a network.

## Distributed System Characteristics

* Resource Sharing
  * Sharing of hardware and software resources
* Openness
  * Use of equipment and software from different vendors.
* Concurrency
  * Conccurent processing to enhance performance.
* Scalability
  * Increased throughput by adding new resources.
* Fault tolerance
  * The ability to coninue in operation after a fualt has occured.

## Distributed system disadvantages

* Compelexity
  * Typically, distributed systems are more complex than centralised systems.
* Security
  * More susceptible to external attack.
* Manageability
  * More effort required for system management.
* Unpredictability
  * Unpredictable response depending on the system organization and network load

## Distributed systems architectures

2 Types

* Client-server Architectures
  * Distributed services which are called on by clients. Servers that provide services are treated differently from clients that use services.
* Distributed object architectures
  * No distinction between clients and servers. Any object on the system may provide and use services from other objects

## MiddleWare (IMPORTANT)

* Software that manges and supports the different components of distributed systems .
* Middleware is usually off the shelf rather than specfically written software.
e.g.
  * Transcations, processing monitors;
  * data converters;
  * Communication controllers.

## Big vs Little Endien

Intel, microsoft... :

* Use little endien

Apple, Amazon etc... :

* Use Big endien

Little endien:

* Pushes small to big
* DATA: 456
  * Little endien: 654
  * Box

Big Endien:

* Pusshes big to small
* DATA: 456
  * Big Endien 456
  * Triangle

Thats where middleware comes in:

* Can convert little to big, Big to little
* box to triangle, triangle to box

CORBA is another middleware Converter

## CLient Server Architecture

* The application is modelled as a set of services that are provided by servers and a set of clients that use these services
* Clients know of servers but servers need not know of clients
* client and servers are logical processes
* The mapping of processors to processess is not necessarily 1 : 1

Servers are Squares, clients are circles

looks a lot like a bunch of nodes and clusters

## Layered application architecture

* Presentation Layer
  * Concerned with presenting the results of a computation to system users and collecting user inputs.
* Application processing layer
  * Concerned with providing application specific functionality e.g. in a banking system, banking functions such as a open accounts, close acc. etc.
* Data management layer
  * concerned with managing the system database

## Thin and Fat Clients 2 models

Thin client model:

* all of application processing and data mangement is carried out on the Server

Fat client model:

* Server is only responsable for data management, the software on the client implements the application logic

Who uses fat client:

* Microsoft (how many copys of word do you have)
* Intel
* Dell

Who uses Thin client:

* Google
* Amazon
* Nvidia

Everybody is moving to thin client, because thin is better


## Three tier C/S Architecture (Client Server)

* Client
* Application Processing (server)
* Data Management (server)

For big companies (expensive to do)

## Distributed Object Architectures

* No distinction in a distribured object architectures between clients and servers
* each distributable entity is an object that provides services to other objects adn recieves services from objects
* Object communication is through a middleware system called an object request broker (ORB)
* Distributed object architectures are more complex to design than C/S systems

a diagram of this is similar to class objects

Exam questions: who handles the communication is distributed object architecture?

* ORB: Object Request Broker

## Advantages of Distributed object arch

* Allows the system designer to delay decisions
* very open
* allowed to use it as client server as well!

## Uses of distributed object Arch

* As a logical model its good
* and a client server
* Can be used in data mining systems
  * Data mining (comparing data with each other)
  * Integrators use deep learning to learn off the data
  * Kinda like how beer and baby products are next to each other
  
## CORBA (common object request broker architecture)

* Middleware for distributed computing 2 level
  * At the lgocial communication, allows object on diff computers to exchange data
  * At the component level provides a basis for delvoping compatable components
  
Exam questions:

What does corba stand for?

* CORBA (common object request broker architecture)

What is Corba Application structure (list or draw it)

* Application objects (Your own version of stuff / flavor / subroutines-api's)
* Domain Facilities (Display of information)
* Object Request Broker (Gathering information)
* CORBA Services  (runs and manages all the services)
* Horizontal CORBA facilities (Common services for each corba task / Fonts and colors)

Corba is the heart of Distributed object architectures

## Application Structure

* Application object
* This is defined by OMG

## Corba objects

* CORBA objects are comparable in principle to objects in C++ & java
* Corba objects must have a seperate interface definition that is expressed using a common language (IDL) similar to C++
* Interface Definition Languages (IDL)
* There is a mapping form IDL to programming languages
* Therefore objects wirtten in diffent languages can communicate with each other

## Peer-to-peer architecture

* Peer to peer (p2p) Systems are decentrailised systems where computations may be carried out by any node in the network
* The overall system is designed to take advantage of the computation power and storage of a large networked computers
* Most p2p systems have been personal system but there is increaing business use of this technology.

p2p communication is a lot like a game of telephone but the data is not lost!

## p2p architectural models

* The logical network arch.
  * Decentralised arch. ( each node just holds info and p2p has to repeat its process again)
  * semi-centralised arch. (semi-centralized has a discovery server where it saves some info that has been searched for before and shortens the search time)
* Application arch.
  * the generacic org of componets
* focus is on network architecutre

## Generic Service

* An act/performance offered by one party to another.
* Service probvison is therefore independent of the application using the service

## WEB SERVICES DIAGRAM (important for exam)

* Service registry
* Service requestor
* Service Provider

## Services and distrbuted objects

* Provider independence
* public advertising
* pay for use

All of these are written in soap (which soap is written in XML)

## service standards

* Services are based on agreed, XML-based standards, so they can provide on any platform in any lang.
* Key standards
  * SOAP - Simple Object Access Protocol (message in an envolope
  * WSDL - WEb Services Description Language
  * UDDI - Universal Decription, Discovery and Integration
  
Exam question:

Draw xml diagram

what technologies included

what are they based on
