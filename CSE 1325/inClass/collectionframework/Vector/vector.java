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
