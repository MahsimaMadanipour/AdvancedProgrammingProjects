import java.util.Scanner;

import storage.*;

public class Main{
    //A method (Function) that calcuates the reduced price based on the given price and the given amount of discount
    public static float calculateDiscount(float price, float discount){
        return (price * (100-discount)/100);
    }

    public static void main(String[] args){
        //Create a new object of "Shoes" class
        Shoes shoes1 = new Shoes(39, "v39", "basketball", "black", 1, 550000);
        //Create a new object of "Storage" class
        Storage storage1 = new Storage(1);
        Scanner input = new Scanner(System.in);
        //add shoes1 to storage1
        storage1.addShoes(shoes1);

        //Get the model from user and get it's price using sellShoes method, calculate the price after applying discount and output the new price
        for(int i = 0; i <2; i++){
            System.out.println("Enter model:");
            String model = input.nextLine();

            long price = storage1.sellShoes(model);
            if(price >= 0){
                System.out.println("Model: " + model + " Price: " +calculateDiscount(price,20));
            } else {
                System.out.println("Out of stock");
            }
        }
    }
}