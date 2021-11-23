package hamrahbank;

import java.util.Scanner;

/**
 * @author Mahsima Madaniopour
 * @author Nastaran Mahmoudifard
 * @author Sana Lashgari
 * @author Sara Fahimi
 */
public class Car extends Card {

    String carnumber;
    long jarimeh;
    long avarez;

    public Car(String[] cardinfo, String[] carinfo) {
        super(cardinfo);
        carnumber = carinfo[0];
        jarimeh = Long.valueOf(carinfo[1]);
        avarez = Long.valueOf(carinfo[2]);
    }

    public void Jarimeh(Car[] carlist, int indx, int ramz) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your Car Number :");
        String carn = input.nextLine();
        boolean control = false;
        if (carn.equalsIgnoreCase(carnumber)) {
            control = true;
        }
        if (control) {
            System.out.println(jarimeh);
            System.out.println("Aya mikhahid pardakht konid? Yes/No");
            String ans = input.nextLine();
            if (ans.equalsIgnoreCase("Yes")) {
                if (jarimeh < carlist[indx].getbalance()) {
                    if (Deposit(carlist, carlist.length, indx, ramz)) {
                        carlist[indx].jarimeh = 0;
                        long temp = carlist[indx].getbalance();
                        temp -= jarimeh;
                        carlist[indx].setbalance(temp);
                    }

                } else {
                    System.out.println("Mojodi kafi nist!");
                }
            } else if (ans.equalsIgnoreCase("No")) {
                System.out.println("Bawshe! :(");
            }
        } else {
            System.out.println("Wrong CarNumber!!");
        }
    }

    public void Avarez(Car[] carlist, int indx, int ramz) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your Car Number :");
        String carn = input.nextLine();
        boolean control = false;
        if (carn.equalsIgnoreCase(carnumber)) {
            control = true;
        }
        if (control) {
            System.out.println(avarez);
            System.out.println("Aya mikhahid pardakht konid? Yes/No");
            String ans = input.nextLine();
            if (ans.equalsIgnoreCase("Yes")) {
                if (avarez < carlist[indx].getbalance()) {
                    if (Deposit(carlist, carlist.length, indx, ramz)) {
                        carlist[indx].avarez = 0;
                        long temp = carlist[indx].getbalance();
                        temp -= avarez;
                        carlist[indx].setbalance(temp);
                    }

                } else {
                    System.out.println("Mojodi kafi nist!");
                }
            } else if (ans.equalsIgnoreCase("No")) {
                System.out.println("Bawshe! :(");
            }
        } else {
            System.out.println("Wrong CarNumber!!");
        }
    }

    @Override
    public String toString() {
        String j = Long.toString(jarimeh);
        String a = Long.toString(avarez);
        String forwrite = carnumber + "," + j + "," + a;
        return forwrite;

    }
}
