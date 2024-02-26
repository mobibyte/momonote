public class arraysss
{
    public static void main(String[] args)
    {
           // [Array]
           int[] intArr = {23,44, -15, 7, 888};
           for(int a: intArr)
               System.out.println(a);
           for(int i = 0; i< intArr.length; i++)
               System.out.println(intArr[i] + " ");
           System.out.println("Printng with to String: " + Arrays.toString(intArr));
           Arrays.sort(intArr);
           System.out.println("Printingv with totring" + Arrays.toString(intArr));
           int[] intArr2 = {23,10,0,23,44,-15,7,88};
           Arrays.parallelSort(intArr2);
           System.out.println("Printingv with totring" + Arrays.toString(intArr));
           int intKey = 44;
           System.out.println(intKey + "found at" + Arrays.binarySearch(intArr2, intKey));
           int[] intArr3 = {23,23,44,-15,7,888}; // Could be the same as intArr4
           int[] intArr4 = {23,100,0,23,44,-15,7,888};
           System.out.println("Reslt of comparison " + Arrays.compare(intArr3, intArr4));
           int intArr5[] = {1,2,3,4,5};
           
           int intArr6[] = new int[intArr5.length];

           // System.arraycopy(intArr5, 0, intArr6, 0, intArr6.length);
           System.out.println("Printing " + Arrays.toString(intArr6));

           int intArr7[] = Arrays.copyOfRange(intArr5, 0,2);

           System.out.println("Pritning: " + Arrays.toString(intArr7));

           int[] source = {1,2,3,,4,5};

           int[] destination = Arrays.copyOfRange(source, 0, source.length);

           System.out.println("Printing " + Arrays.toString(destination));

           int fillVal = 22;

           Arrays.fill(source,fillVal);

           System.out.println("Printing" + Arrays.toString(source));

           int [][]source1 = {{1,2,3,4,5},{6,7,8}, {9}};

           int[][] destination3 = new int[source1.length][];

           for(int i = 0; i < destination3.length; i++)
           {
               destination3[i] = new int[source1[i].length];
           }
    }
}