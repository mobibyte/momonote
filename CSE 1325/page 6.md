
## Public static void main

Keyword on data access

* Public
    * Can be accessed anywhere (even other classes)
* Private
    * Can only be accessed in whatever method its in
* Protect
    * Only works with inheritance with methods, still is private but public deeper inside the program

Keyword on variables activity

* Static
* Non-static

Everything we can create classes as objects


### Creating our own classes

Splitting up 1 program into different files

Classes look like this

They have 3 parts each

Class name

-----------------

Data		States + instance variables

-----------------

Methods 	(functions/subroutines)

-----------------

Book

-----------------

Data		States + instance variables

ID

Static count 

-----------------

Static updateBook()	(functions/subroutines)

-----------------

Book B = <span style="text-decoration:underline;">new Book(); </span>//is a constructor, allows us to create instances from a class

Book C = new Book();

B.updateBook();

C.updateBook();

//both B and C objects share the book class, including their methods, but they contain their own data separately, 



* static shares methods of the class, not of the objects


## Building user defined classes

Each class has 3 parts

//everything can be treated like objects in programming

First is class name: i.e. car dealership db

Second is data and attributes: 

String Make

String Model

Int year

//class can contain as much data & attributes as needed

Third part is reserved for methods: //what we do with data

addNewCar()

deleteCar()

printCar()

Going to create separate classes to separate things

The access modifiers and static non-static modifiers

Will use access modifiers

Public

Private

Protected

Default //declaring a method that is like void and prints 



* If you make main method private then we cannot even run the program, because its locked off from java running or compiling it

Class car
{
	Public string make
	Public string model;

	private int year; //getters and setters are written in the class where a var is private
	public int getYear()//getters always have same data type as var used
    {return year;}	

    public void setYear(int year) //data type for setters are always void

    { this.year =year;} //this keyword is important in java for set funcs 
                      //this keyword only looks for var being entered for the specific obj

	Public void printCarDetails()
	{
		println( “Make: “ + make + “\nModel: “ + model + “\nYear: “ + year);
	}

	~~~~~ code ~~~~~

}

Class Test
{

	car c = new car(); //doing this initializes space for our new object, the class of car was a data structure but contained 0 data.

	c.make = “Lexus”; //can also initialize directly 

	c.model = “ES-300H”;

	//c.year = 2022; wont work because its private

	//because year is private we cant directly access through obj, we need 2 methods to access them, we need getters and setters 

	c.setYear(2022);

	.println(make: “+ c.make); //public var

	.println(“model: “+ c.model); //public var

	.println(“year: “ + c.getYear()); //access private var through get method

	car d - new car(); //making new obj for this specific car

	~~~~~

}

	

Inside our obj visual

C obj

|Lexus|

|ES-300H|

|2022|


## Creating and arrays arraylist, linked-lists of objects

Class Student
{
	Private String name;
	Private int gpa;
	Public String getName()
	{return name;}

	Public int getGPA()
	{return gpa;}

	Public void setStudent(String name, int gpa)
	{
		This.name = name;
		This.gpa = gpa
	}

	Public void print()
	{
		.println(“name: “ + name + “\nGPA: “ + gpa);
	}

}

Class Test
{
	Main
	{

		//Student S = new Student();

		// we dont just 1 student, but we need n amt of students

		// we need to create an array of these objects

		Student [] s = new Student[10]; //if we want 10 students

		//first we create the array, now in each of those fields of array we store data for each student

		Scanner sc = new Scanner(System.in);

		For (int i = 0; i &lt; S.size(); i++)
		{

			.print(“Enter name & gpa of student” + i++);

			String n = sc.next();

			Int g = sc.nextInt();

			//now we have data, next we need to construct our obj in the array

			S[i] = new Student(); //call constructor

			S[i].setStudent(n, g); //store what the user imputed for student i

		}

		//then to print each student

		For ( int i = 0; i &lt; s.size(); i++)

			s[i].print();

	}

}

Can create constants like this → Final int MAX = 10;

//Creating the same thing but with a real constructor

Class Student
{

	Public student(String name, int gpa)
	{
		This.name =name;

		This.gpa = gpa;
	}

//or

	Public student()

	{

		this(“null”, 0); //can still use this to pass in params, but by default will set these vals

    }
}
