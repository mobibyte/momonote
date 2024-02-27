import mthread.multithread;

public class m
{
    public static void main(String args[])
    {
        for (int i = 0; i<10; i++)
        {
            multithread thread1 = new multithread(i);
            thread1.start(); //starts all the threads
            // thread1.join();//not allow next thread to be executed, before the previous thread to finish
        }
    }
}