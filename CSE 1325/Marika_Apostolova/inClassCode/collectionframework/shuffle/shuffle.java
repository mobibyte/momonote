
    // Java program to Demonstrate shuffle
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class shuffle{

	public static void main(String[] args) {

		ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("java");
        mylist.add("quiz");
        mylist.add("uta");
        mylist.add("students");
        mylist.add("practice");
        mylist.add("yea");
 
        System.out.println("Original List : \n" + mylist);
 
        Collections.shuffle(mylist);
 
        System.out.println("\nShuffled List : \n" + mylist);
        
        // Here we use Random(3) to shuffle given list. Here 3
        // is seed value for Random.
        Collections.shuffle(mylist, new Random(3));       
        System.out.println("\nShuffled List user defined seed : \n" + mylist);

        Collections.shuffle(mylist, new Random(5));       
        System.out.println("\nShuffled List user defined seed : \n" + mylist);

        Collections.shuffle(mylist, new Random());       
        System.out.println("\nShuffled List user defined seed : \n" + mylist);
		    }

         }

}
