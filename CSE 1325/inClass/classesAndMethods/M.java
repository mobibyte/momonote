
public class M
{
    public static void main(String[] args)
    {
        String name ="Bob";
        int age = 22;

        //creating an object from main class
        M obj = new M();
        //accessing our print function (dont need to do obj.print because print is static (which also means it takes in the same thing as all other objs do, its static))
        M.print("marina", age);
        M.print("marina", age);

        print(name, age);
        print("Marina", 33);
        print("Joe", 44);

        int [] ages = {22,33,44,55,89};
        int [] ages2 = {1, 4};

        printArray(ages); //from inside calling method
        System.out.println();
        M.printArray(ages2); //calling method from obj

    }

    //creating methods! or functions, or subroutines whatever floats your boat
    public static void print(String name, int age)
    {
        System.out.println("The name is: |" + name + "| and age: " + age);
    }

    public static void printArray(int arr [])
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}


/*
 * Output:
 * 
 * The name is: |marina| and age: 22
    The name is: |marina| and age: 22
    The name is: |Bob| and age: 22
    The name is: |Marina| and age: 33
    The name is: |Joe| and age: 44
    22
    33
    44
    55
    89

    1
    4
 */