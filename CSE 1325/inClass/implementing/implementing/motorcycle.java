package implementing;

public class motorcycle implements vehicle
{
    private int gear;
    private int speed;

    @Override
    public void changeGear(int a) 
    {
        gear = a;
        System.out.println("\ngear changed: " + gear);
    }
    @Override
    public void speedUp(int a) 
    {
        speed += a;
    }
    @Override
    public void applyBreak(int a)
    {
        speed -= a;
    }

    public void honkHorn()
    {
        System.out.println("\nHOOOONKKK...brrr");
    }

    public void print()
    {
        System.out.printf("\nVehicle: Motorcycle, Gear: %d Speed: %d mph\n", gear, speed);
    }
    
}
