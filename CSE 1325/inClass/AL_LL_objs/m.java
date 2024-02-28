import java.util.ArrayList;

public class m
{
    
    public static void main(String [] args)
    {
        person p1 = new person("Bob", 3526512);
        person p2 = new person("Anna", 301235125);
        person p3 = new person("Tom", 253250);
        ArrayList<person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);


        for (person p: people) 
        {
            System.out.println("name: " + p.name + "\nid: " + p.id);
        }

        System.out.println("name: " + people.get(0).name);


    }
}