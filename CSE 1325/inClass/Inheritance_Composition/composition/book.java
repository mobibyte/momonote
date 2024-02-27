package composition;

public class book 
{
    private String name;
    private author Author;
    private double price;
    private int qty;
    
    public book (String name, author Author, double price, int qty)
    {
        this.Author = Author;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() 
    {return name;}
    public author getAuthor() 
    {return Author;}
    public double getPrice() 
    {return price;}
    public int getQty() 
    {return qty;}
    public void setQty(int qty) 
    {this.qty = qty;}
    public void setPrice(double price)
    {this.price = price;}

    public String toString() 
    {
        return " " + name + " by " + Author;
    }



}
