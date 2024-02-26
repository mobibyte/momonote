package mthread;

public class multithread extends Thread
{

    private int threadNumber;

    public multithread(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }
    
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            System.out.println(i + " from thread: " + threadNumber);

            // if(threadNumber == 3)
            //     throw new RuntimeException(); //stops thread 3 only

            try 
            {
                sleep(600);
            } 
            catch (InterruptedException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
