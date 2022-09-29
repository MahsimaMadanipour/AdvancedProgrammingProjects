package storage;

public class Shoes {
    private int size;
    private String model;
    private String category;
    private String color;
    private int quantity;
    private long price;
    //Constructor
    public Shoes(int s, String m, String cat, String c, int q, long p){
        setSize(s);
        setModel(m);
        setCategory(cat);
        setColor(c);
        setQuantity(q);
        setPrice(p);
    }
    //Getter and Setter methods (lines 20-66)
    public void setSize(int n){
        this.size = n;
    }

    public void setQuantity(int n){
        this.quantity = n;
    }

    public void setModel(String s){
        this.model = s;
    }

    public void setCategory(String s){
        this.category = s;
    }

    public void setColor(String s){
        this.color = s;
    }

    public void setPrice(long p){
        this.price = p;
    }

    public int getSize(){
        return this.size;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getModel(){
        return this.model;
    }

    public String getCategory(){
        return this.category;
    }

    public String getColor(){
        return this.color;
    }

    public long getPrice(){
        return this.price;
    }
//End of Getter and Setter methods

//A method that decreases the value of "Quantity" by 1.
    public boolean sellShoes(){
        int q = getQuantity();
        if(q > 0){
            setQuantity(q-1);
            return true;
        } else{
            return false;
        }
    }
    
}
