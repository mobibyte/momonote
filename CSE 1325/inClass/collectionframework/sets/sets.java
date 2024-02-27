import java.util.HashMap;

public class sets 
{
    // Java program to Demonstrate few new methods for Hashmap

    public static void main(String[] args) {
            
        // Create an empty hash map by declaring object
        // of string and integer type
        HashMap<String, Integer> map = new HashMap<>();

        // Adding elements to the Map
        // using standard put() method
        map.put("John", 10);
        map.put("Peter", 30);
        map.put("Jim", 30);
        map.put("Vera", 20);

        // Print size and content of the Map
        System.out.println("Size of map is:- "
                        + map.size());

        // Printing elements in object of Map
        System.out.println(map);

        // Checking if a key is present and if
        // present, print value by passing
        // random element
        if (map.containsKey("Vera")) {

            // Mapping
            Integer a = map.get("Vera");

            // Printing value for the corresponding key
            System.out.println("value for key"
                            + " \"Vera\" is: " + a);
            }
        System.out.println(map);
    // Remove an element from the HashMap
        map.remove("Jim");
        System.out.println(map);
        
        //change value
        map.put("Vera", 50);
        System.out.println(map);
        
    // Iterate the hashmap using
        // for-each loop
        for (HashMap.Entry<String, Integer> e : map.entrySet())
            System.out.println("Key: " + e.getKey()
                            + " Value: " + e.getValue());
        
    // Using keySet() to get the set view of keys 
        System.out.println("The set is: " + map.keySet());
        
        // Using values() to get the set view of keys 
        System.out.println("The set is: " + map.values());
        
        
        //contains key or value
        System.out.println("Contains key:"+map.containsKey("John"));
        System.out.println("Contains value:"+map.containsValue(20));
        
        map.clear();
        if (map.isEmpty()){
            System.out.println("Hashmap is empty");
            }
            else{
            System.out.println(map);
            }
        
        
    }


}
