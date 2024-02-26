package implementing;

public class bicycle implements vehicle
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

    public void print()
    {
        System.out.printf("\nVehicle: bicycle, Gear: %d Speed: %d mph\n", gear, speed);
    }
}
