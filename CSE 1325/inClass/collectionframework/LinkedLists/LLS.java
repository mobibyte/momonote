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
