package hamrahbank;

import java.util.Scanner;

/**
 * @author Mahsima Madaniopour
 * @author Nastaran Mahmoudifard
 * @author Sana Lashgari
 * @author Sara Fahimi
 */
public class Card {

    private String name;
    private String cardnumber;
    private int cvv2;
    private long balance;

    public Card(String[] cardinfo) {
        setname(cardinfo[0]);
        setcardnumber(cardinfo[1]);
        setcvv2(Integer.valueOf(cardinfo[2]));
        setbalance(Long.valueOf(cardinfo[3]));
    }

    public Card(int cv) {
        setcvv2(cv);
    }

    public void setname(String n) {
        name = n;
    }

    public String getname() {
        return name;
    }

    public void setcardnumber(String cn) {
        cardnumber = cn;
    }

    public String getcardnumber() {
        return cardnumber;
    }

    public void setcvv2(int cv) {
        cvv2 = cv;
    }

    public int getcvv2() {
        return cvv2;
    }

    public void setbalance(long b) {
        balance = b;
    }

    public long getbalance() {
        return balance;
    }

    public void CardtoCard(long m, String cn, Card[] clist, int counter, int indx, int ramz) {
        boolean controlcard = false;
        int idx = 0;
        for (int i = 0; i < counter; i++) {
            if (cn.equalsIgnoreCase(clist[i].cardnumber)) {
                controlcard = true;
                idx = i;
                break;
            }
        }
        if (m < balance) {
            if (controlcard == true) {
                boolean Control = Deposit(clist, counter, indx, ramz);
                if (Control) {
                    clist[indx].balance -= m;
                    clist[idx].balance += m;
                    print();
                } else {
                    System.out.println("CardNumber is not Valid!");
                }
            }
        } else {
            System.out.println("Mojodi kafi nist!");
        }

    }

    public boolean Deposit(Card[] clist, int counter, int idx, int ramz) {
        Scanner input = new Scanner(System.in);
        boolean control = false;
        System.out.print("Enter Cvv2 : ");
        int tempcvv2 = input.nextInt();
        System.out.print("Enter Dynamic Password : ");
        int tempramz = input.nextInt();
        if (tempcvv2 == clist[idx].cvv2 && tempramz == ramz) {
            control = true;
        }
        if (control) {
            System.out.println("Successful Transaction.");
        } else {
            System.out.println("Wrong Ccv2 or Dynamic Password");
        }
        return control;
    }

    public void charity(Card[] clist, int counter, int idx, int ramz) {
        System.out.println("\t1.Mahak");
        System.out.println("\t2.Helal-e-Ahmar");
        System.out.println("\t3.Hamyari baraye moghabele ba Covid-19");
        System.out.println("\t4.Zanane bi sarparast");
        System.out.print("Choose your Organization Name :");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number < 1 || number > 4) {
            System.out.println("You should choose a number from 1 to 4");
            number = input.nextInt();
        }
        System.out.print("Enter the Amount of money that you want to transfer :");
        long money = input.nextLong();
        if (money > 3000000) {
            System.out.print("Amount should be less than 3000000 : ");
            money = input.nextLong();
        }
        if (money < clist[idx].getbalance()) {
            if (Deposit(clist, counter, idx, ramz)) {
                long temp = clist[idx].getbalance();
                temp -= money;
                clist[idx].setbalance(temp);
            }

        } else {
            System.out.println("Mojodi kafi nist!");
        }
    }

    public void print() {
        System.out.println("Mojodi feli shoma : " + getbalance());
    }

    @Override
    public String toString() {
        String cv = Integer.toString(getcvv2());
        String b = Long.toString(getbalance());
        String forwrite = getname() + "," + getcardnumber() + "," + cv + "," + b;
        return forwrite;

    }
}
