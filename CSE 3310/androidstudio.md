## Android studio training 

Kotlin & Android UI development (into and hand on projects)

Online theres android courses to build stuff

Kotlin (made in 2011)

## Why use kotlin

* consise syntax
* Null Safety: Explicity define null variables as nullable
* extension function: can add new functions to existing classes without modifying them.
* Coroutines: more efficient and readable (multiple tasks can share the same memory within one proccess?)
* Functional Programming: Lamda
* Interoperability: yes

Intellij ide is for kotlin 

## Kotlin Programming lang.

* Data Types (int float)
* Control Flow (if else else if)
* Advanced (lamda / threads)

### Vars & data types

Val is like a constant, cannot be changed
var is like variable

* Kotlin has the val keyword 
val myNum = 5

* it is dynamically typed

you can also explicitly type it

val myNum int = 5

* having both of these is pretty nice to have.


Kotlin also has normal assignment operations.

## When statements

* very similar to switch statements

i.e.
```
val day = 4

val result = when (day) {
 1 -> "Monday"
 2-> "tues"
...
 else -> invalid day
}
print(result)
```

## coroutines (lightweight thread)

Kinda like a parrallel process that runs

## lamda
```
val sum: (int, int) -> int = { a, b -> a + b}

val result = sum (5, 3)
println("Sum: $result")
```

## Android Architecture

(kinda how the system runs from bottom up, Left to right)

Linux kernel -> Hardware abstraction -> native C/C++ libraries // android runtime -> java API framework -> system apps

## Android GUI (Graphical user interface)

* Material Design (kinda like a philosophy)

* core component for UI and GUI we use...

Jetpack Compose

* this is cool because it can be dynamically changed

## composable functions

* describes UI
* Take input and generate UI on screen
* Anootation:
  * Start with @
  * Help compiler identifiy composable funcs.
  * @composable: 
  * @preview


## todays hands on proj

* basic layout
	* parent/child
	* column
	* row
* resource managers: text/images
* event handlers: click
* Navigation between screens


