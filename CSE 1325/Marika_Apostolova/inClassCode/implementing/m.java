import implementing.bicycle;
import implementing.motorcycle;

public class m
{
    public static void main(String[] args) 
    {
        bicycle b = new bicycle();
        b.changeGear(5);
        b.speedUp(10);
        b.print();

        motorcycle m = new motorcycle();

        m.changeGear(8);
        m.speedUp(90);
        m.print();
        m.honkHorn();
        m.applyBreak(40);
        m.print();
    }
}