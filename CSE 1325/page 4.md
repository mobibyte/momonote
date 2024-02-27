
## Collection Frameworks


### 3 main collections


#### List collection

* Works like an array
    * Ordered list
    * Unordered lists
* **Arraylists **
    * It is a dynamic array, it can be easily resized
        * Takes a lot of memory allocation to add a new element in between arrays
        * Easy to take data from, or read from it
        * Needs to be shifted
        * Doesnts work well in multithreaded environment 


```
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class arraylists
{
    // Java program to Demonstrate main methods for ArrayList

public static void main(String[] args) {

  // Creating list using the ArrayList class
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println("List: " + numbers);




        //get

        int number = numbers.get(2);
        System.out.println("Accessed Element: " + number);
        System.out.println("Accessed Element: " + numbers.get(3));



        //remove
        numbers.remove(1);
        int removedNumber = numbers.remove(2);
       System.out.println("Removed Element: " + removedNumber);
        System.out.println("List: " + numbers);


        //set
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Python");
        languages.add("English");
        languages.add(1,"JavaScript");
        System.out.println("ArrayList: " + languages);

        String element = languages.set(1, "Java");
        System.out.println("Updated ArrayList: " + languages);
        System.out.println("Replaced Element: " + element);


        //addAll
        // create another arraylist
        ArrayList<String> programmingLang = new ArrayList<>();
        programmingLang.addAll(languages);

        System.out.println("Programming Languages: " + programmingLang);


        //contains
        System.out.println("Is Java present in the arraylist: "
            +languages.contains("Java"));

        //size
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        primeNumbers.add(7);
        System.out.println("ArrayList: " + primeNumbers);


        // get the number of elements of arraylist
        int size = primeNumbers.size();
        System.out.println("Length of ArrayList: " + size);


        // Create a new array of String type
        // size of array is same as the ArrayList
        String[] arr = new String[languages.size()];
        languages.toArray(arr);
        System.out.println("Array: ");
        for(String item:arr) {
          System.out.print(item+", ");
        }


        //removeAll
        System.out.println();
        languages.removeAll(languages);
        System.out.println("ArrayList after removeAll(): " + languages);


        //clear
        languages.clear();
        System.out.println("ArrayList after clear(): " + languages);



        //adding user inputs in arraylist
        ArrayList<Integer> values=new ArrayList<>();
        Scanner input = new Scanner(System.in);

    do
      {
      System.out.println("Please enter a value:");
      Integer course_input = input.nextInt();
      if(course_input!=000)
      values.add(course_input);
      else
        break;
      }while(true);
      System.out.println(values);


      //printing using iterator
      System.out.println("\n=== Iterate using an iterator() ===");
          Iterator<Integer> iterator = values.iterator();
          while (iterator.hasNext()) {
              Integer val = iterator.next();
              System.out.println(val);
          }


          //printing using Lambda, similar to method, short block of code which takes in parameters and returns a value.
          System.out.println("\n=== Iterate using Lambda ===");
          values.forEach( (val) -> { System.out.println(val);});

}

}

```


## Linked lists
* Linked lists are double linked lists, pointing to and back.
* All data is placed within nodes
* LLH ←prev  nxt→ Node A ← → node B ← → node C ← → null
* Easy to insert data within linked list, and easy to remove


```
import java.util.LinkedList;

public class LLS
{
    // Java program to Demonstrate main methods for LinkedList

    public static void main(String[] args) {


        LinkedList<String> ll = new LinkedList<>();


        ll.add("UTA");
        ll.add("Students");
        ll.add(1, "For");
        ll.add("are");
        ll.add("super great");
        ll.add(4, "for sure");


        System.out.println(ll);


        //seta
        ll.set(0, "Yea");
        System.out.println("Updated LinkedList " + ll);


        //delete
        ll.remove(1);
        System.out.println("After the Index Removal " + ll);
        ll.remove("Yea");
        System.out.println("After the Object Removal " + ll);


        // Displaying the size of the list
        System.out.println("The size of the linked list is: " + ll.size());


        //delete first
        System.out.println("The removed first element is: " + ll.removeFirst());


        System.out.println("Final LinkedList:" + ll);


        //delete last
        System.out.println("The last element is removed: " + ll.removeLast());
        System.out.println("Final LinkedList:" + ll);


        // Add an element to the beginning of the linked list
        ll.addFirst("lala");


        // Add an element to the end of the linked list
        ll.addLast("yeaa");
        System.out.println("Final LinkedList:" + ll);




        // Fetching the specific element from the list
        System.out.println("The element is: " + ll.get(2));


        // Clone
        LinkedList<String> ll2 = new LinkedList();
        ll2 = (LinkedList) ll.clone();
        System.out.println("Second LinkedList is:" + ll2);


        // Check if the list contains "are"
        System.out.println("Does the List contains 'are': " + ll2.contains("are"));


        // Check if the list contains "yeaa"
        System.out.println("Does the List contains 'me': "  + ll2.contains("yeaa"));


        // Clearing the list
        ll2.clear();
        System.out.println("List after clearing all elements: " + ll2);

    }

}

```

## Stack
    * LIFO
        * Last in first out
    * Like a stack of plates
* **Vector**
    * Similar to arraylists
    * Works well in multi-threaded environment (multiple processes)


```
import java.util.Vector;

public class vector
{
    // Java program to Demonstrate main methods for Vector

    public static void main(String[] args) {


        Vector<Integer> v2 = new Vector<Integer>();


        //add
        v2.add(1);
        v2.add(2);
        v2.add(3);

        // Printing the vector elements to the console
        System.out.println("Vector v2 is " + v2);


        v2.add(2,5);
        System.out.println("Vector v2 is " + v2);    

        // set
        System.out.println("The Object that is replaced is: "
                        +v2.set(3, 50));

        System.out.println("The new Vector is:" + v2);

        //delete
        v2.remove(1);

        // checking vector
        System.out.println("After removal: " + v2);


        // Insert an element 0 at index 1
        v2.insertElementAt(0, 1);
        System.out.println("The new Vector is:" + v2);




        // Remove the element at index
        v2.removeElementAt(2);
        System.out.println("The new Vector is:" + v2);


        // Fetching the specific element from the Vector
        System.out.println("The element is: " + v2.get(2));


    //contains
        System.out.println("Does the Vector contains '21'? "+ v2.contains(21));

    // Clearing the Vector using clear() method
        v2.clear();

        // Displaying the final vector after clearing;
        System.out.println("The final Vector: " + v2);

    }

}

```

* All the lists can have duplicate data

#### Set Interface

* HashSet
* TreeSet
* Set does not allow duplicate data


## Queue

* Dequeue
* Priority que
* Enqueue? 
* FIFO
    * First in first out
        * Like a movie theater line or just a line
