package hamrahbank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

/**
 * @author Mahsima Madaniopour
 * @author Nastaran Mahmoudifard
 * @author Sana Lashgari
 * @author Sara Fahimi
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("<LOGIN MENU>");
        File UserFile = new File("src/hamrahbank/User.txt");
        User[] userlist = new User[100];
        int ucounter = 0;
        try {
            Scanner userfileinput = new Scanner(UserFile);
            while (userfileinput.hasNextLine()) {
                String s = userfileinput.nextLine();
                String[] user = s.split(",");
                User u = new User(user[0], Long.valueOf(user[1]));
                userlist[ucounter] = u;
                ucounter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("UserFile Not Found!");
        }
        File CardFile = new File("src/hamrahbank/Card.txt");
        Card[] Cardlist = new Card[100];
        Car[] Carlist = new Car[100];
        Phone[] Phonelist = new Phone[100];
        int counter = 0;
        try {
            Scanner cardfileinput = new Scanner(CardFile);
            while (cardfileinput.hasNextLine()) {
                String s = cardfileinput.nextLine();
                String[] filesplit = s.split("\\//");
                String[] cardinfo = filesplit[0].split(",");
                String[] phoneinfo = filesplit[1].split(",");
                String[] carinfo = filesplit[2].split(",");
                Card c = new Card(cardinfo);
                Car car = new Car(cardinfo, carinfo);
                Phone p = new Phone(cardinfo, phoneinfo);
                Cardlist[counter] = c;
                Carlist[counter] = car;
                Phonelist[counter] = p;
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File of Information Not Found!");
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username : ");
        String uname = input.nextLine();
        System.out.print("Enter password : ");
        Long upass = input.nextLong();
        User utemp = new User(uname.toLowerCase(), upass);
        boolean c = utemp.login(userlist, ucounter);
        if (c) {
            System.out.println("<USER MENU>");
        } else {
            System.out.println("user is not defined in the system!!");
            return;
        }
        int indx = 0;
        for (int i = 0; i < counter; i++) {
            if (uname.equalsIgnoreCase(Cardlist[i].getname())) {
                indx = i;
            }
        }
        boolean control = true;
        Random rand = new Random();
        int a = 100000, b = 999999;
        int x = rand.nextInt((b - a) + 1) + 100000;
        System.out.println("Ramze pouyaye shoma : " + x);

        while (control) {
            System.out.println("\t1.Card to Card");
            System.out.println("\t2.Mobile/Phone");
            System.out.println("\t3.Car");
            System.out.println("\t4.Nikokari");
            System.out.println("\t5.Mojodi");
            System.out.println("\t6.Exit");
            System.out.print("Choose your Service:");
            Scanner input2 = new Scanner(System.in);
            int menu = input2.nextInt();
            switch (menu) {
                case 1:
                    Scanner menuinput = new Scanner(System.in);
                    System.out.print("Enter the Destination Card Number(**** **** **** ****) :");
                    String Cardnumber = menuinput.nextLine();
                    System.out.print("Enter the Amount of Money that you want to transfer(Toman) :");
                    Long Money = menuinput.nextLong();
                    if (Money > 3000000) {
                        System.out.println("invalid  amount of money ,the amount of money have to be less than 3000000");
                        System.out.print("Enter the Amount of Money that you want to transfer(Toman) :");
                        Money = menuinput.nextLong();
                    }
                    Cardlist[indx].CardtoCard(Money, Cardnumber, Cardlist, counter, indx, x);
                    toWrite(Cardlist, Carlist, Phonelist, CardFile, counter);
                    break;
                case 2:
                    System.out.println("\t1.pardakhte ghobuz");
                    System.out.println("\t2.sharzh va internet");
                    System.out.print("choose the option : ");
                    Scanner Ansinput = new Scanner(System.in);
                    int Ans = Ansinput.nextInt();
                    switch (Ans) {
                        case 1:
                            Phonelist[indx].Bill(Phonelist, indx, x);
                            break;
                        case 2:
                            Phonelist[indx].ChargeorInternet(Phonelist, indx, x);
                            break;
                        default:
                            System.out.println("you have entered an invalid number!");
                            break;
                    }
                    toWrite(Cardlist, Carlist, Phonelist, CardFile, counter);
                    break;
                case 3:
                    System.out.println("\t1.jarime");
                    System.out.println("\t2.avarez");
                    System.out.print("choose your option :");
                    Scanner JorA = new Scanner(System.in);
                    int jorAinput = JorA.nextInt();
                    switch (jorAinput) {
                        case 1:
                            Carlist[indx].Jarimeh(Carlist, indx, x);
                            break;
                        case 2:
                            Carlist[indx].Avarez(Carlist, indx, x);
                            break;

                        default:
                            System.out.println("you have entered an invalid number!");
                            break;
                    }
                    toWrite(Cardlist, Carlist, Phonelist, CardFile, counter);
                    break;
                case 4:
                    Cardlist[indx].charity(Cardlist, counter, indx, x);
                    toWrite(Cardlist, Carlist, Phonelist, CardFile, counter);
                    break;
                case 5:
                    System.out.println("Modoji Shoma : " + Cardlist[indx].getbalance());
                    toWrite(Cardlist, Carlist, Phonelist, CardFile, counter);
                    break;
                case 6:
                    toWrite(Cardlist, Carlist, Phonelist, CardFile, counter);
                    return;
                default:
                    System.out.println("We don't have this Option!");
            }
            System.out.println("**************************");
            System.out.print("Aya mikhahid edameh dahid(yes/No) : ");
            Scanner YorN = new Scanner(System.in);
            String answer = YorN.nextLine();
            if (answer.equalsIgnoreCase("Yes")) {
                control = true;
            } else if (answer.equalsIgnoreCase("No")) {
                control = false;
            } else {
                System.out.println("Invalid Answer!back to menu cause the default answer is Yes");
            }
        }
    }

    public static void toWrite(Card[] cardlist, Car[] carlist, Phone[] phonelist, File f, int counter) {
        try {
            FileWriter cardfile = new FileWriter(f);
            for (int i = 0; i < counter; i++) {
                String s = cardlist[i].toString() + "//" + phonelist[i].toString() + "//" + carlist[i].toString() + "\n";
                cardfile.write(s);
            }
            cardfile.close();
        } catch (IOException ef) {
            System.out.println("IOException");
        }
    }

}
