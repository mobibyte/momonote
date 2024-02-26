import composition.author;
import composition.book;

public class m
{
    public static void main(String[] args) 
    {
        author a1 = new author("Anna Smith", "annasmith@gmail.com", 'f');
        System.out.println(a1); //calls to string method

        //test setters and getters
        a1.setEmail("annasmith123@gmail.com");

        System.out.println(a1);

        //can also print w/ getters

        /**************************************************************/
        //creating a book by that author
        book b1 = new book("Java for professonials", a1, 9.99, 99);

        System.out.println(b1);

        b1.setPrice(100.11);
        b1.setQty(55);

        System.out.println(b1.toString());


        /*******************************************/
        /**************Inheritance******************/
        /*******************************************/

        System.out.println("\n\n");
        


    }
}