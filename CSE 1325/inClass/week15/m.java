import enums.weekdays;

public class m
{

    public enum season
    {
        WINTER, SPRING, SUMMER, FALL;
    }


    //Enums
    public static void main(String args[])
    {
        weekdays day = weekdays.friday;
        weekdays day2 = weekdays.monday;

        if(day == weekdays.friday)
        {
            System.out.println("Yay ITS Friday!");
        }
        if (!day.equals(day2))
        {
            System.out.println("The days " + day + " and " + day2 + " are not equal to each other ");
        }

        for (weekdays w : weekdays.values())
        {
            System.out.print(w+"\t");
            System.out.print("\t dayNum: " + w.dayNumber);
            System.out.println("\t levelOfExcitement: " + w.levelOfExcitement);
        }

        System.out.println(day.dayNumber);

        for (season s : season.values()) 
        {
            System.out.println(s);
        }

        System.out.println(season.valueOf("SPRING"));
        System.out.println(season.WINTER.toString());
    }
}