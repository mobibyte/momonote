package composition;

public class author
{
    private String name;
    private String email;
    private char gender; //m or f

    public author(String name, String email, char gender)
    {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() 
    {return name;}
    public String getEmail() 
    {return email;}
    public char getGender()
    {return gender;}

    public void setName(String name) 
    {this.name = name;}
    public void setEmail(String email) 
    {this.email = email;}
    public void setGender(char gender) 
    {this.gender = gender;}


    //returns self-descriptive string
    public String toString()
    {
        return "" + name + " Gender: " + gender + " Email: " + email + "\n";
    }
}