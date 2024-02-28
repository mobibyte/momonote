package enums;

public enum weekdays 
{
    monday(1, 0), 
    tuesday(2, -1), 
    wednesday(3, 4), 
    thursday(4, 8), 
    friday(5, 10){
        @Override
        public String toString()
        {
            return "It's friday!";
        }
    }, 
    saturday(6, 9999), 
    sunday(7, -9999);

    public int dayNumber;
    public int levelOfExcitement;
    weekdays(int dayNumber, int levelOfExcitement)
    {
        this.dayNumber = dayNumber;
        this.levelOfExcitement = levelOfExcitement;
    }
}
