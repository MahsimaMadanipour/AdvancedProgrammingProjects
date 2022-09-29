package storage;

public class Storage {
    private static int CAPACITY = 100;
    private int quantity = 0;
    private int counter = 0;

    private Shoes[] shoes= new Shoes[CAPACITY];
    private int storageNumber;

    //Constructor
    public Storage(int n){
        setStorageNumber(n);
    }

    //Getter and Setter for storageNumber
    public void setStorageNumber(int n){
        this.storageNumber = n;
    }

    public int getStorageNumber(){
        return this.storageNumber;
    }
    
    //A method that searches for the given Model in shoes array and returns the index of the element.
    private int search(String m){
        for(int i=0; i<counter; i++){
            if(m.equals(shoes[i].getModel())){
                return i;
            }
        }
        return -1;
    }
    //A method that adds the given object of Shoes class to shoes array and updates the Quantity and counter variables.
    public void addShoes(Shoes sh){
        if(sh.getQuantity() + this.quantity >= CAPACITY){
            System.out.println("Storage is full!");
        } else {
            int i = search(sh.getModel());
            if(i>=0){
                shoes[i].setQuantity(shoes[i].getQuantity()+sh.getQuantity());
            } else {
                shoes[counter] = sh;
                counter++;
            }
            this.quantity += sh.getQuantity();
        }
    }

    //A method that returns the price of given shoes model and decreases the value of it's quantity using "sellShoes" method of Shoes calss.
    public long sellShoes(String m){
        int i = search(m);
        if(i>=0){
            if(shoes[i].sellShoes() == true){
                return shoes[i].getPrice();
            } else{
                return -1;
            }
        } else {
            return -1;
        }
    }
}
