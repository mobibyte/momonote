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
