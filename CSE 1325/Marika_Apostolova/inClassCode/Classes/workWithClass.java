import Function.myMethods;
//looks inside function folder and grabs myMethods.java

public class workWithClass 
{
    public static void main(String[] args) 
    {
        myMethods obj = new myMethods();

        int a = 11;
        int b = 6;
        double c = 7.3;
        double d = 9.4;
        int result1 = obj.minFunction(a, b);

        //same function name with differerent parameters
        double result2 = myMethods.minFunction(c, d);
        System.out.println("Min val = " + result1);
        System.out.println();
        
        System.out.println("Min val = " + result2);
        System.out.println();
        /********************************************************************/
        //min of double arrays
        
        // double [] a1 = { 2.3, 3.4, 4.5, 5.7, 1.2, 7.8, 8.9 }; // 7 elements
        // double [] b1 = { -8.7, 9.7, -14.6, 89.9 }; //4 elements
        
        // int i; //array index
        // double min; //curent min val

        // min = minArray( a1 );
        
        // System.out.println( min );
        
        // min = minArray ( b1 );
        
        // System.out.println( min );
        //didnt get the code on this
        /*printMax************************************************************/
        
        
        myMethods.printMax(34, 3, 3, 2, 56.5);
        System.out.println();
        myMethods.printMax(new double[]{1,2,3});
        System.out.println();
        
        
        /********************************************************************/
        
        
        int li [] = {1, 2};
        obj.displayInt(li);
        System.out.println();
        obj.displayInt( 1, 2, 3);
        System.out.println();
        obj.displayString("hello there", "im good", "woa kenny");
        System.out.println();
        
        
    }

}


/* 
Min val = 6

Min val = 7.3

The max value is 56.5

The max value is 3.0


 number of arguements: 2
1
2


 number of arguements: 3
1
2
3


number of arguements: 3
hello there
im good
woa kenny
*/