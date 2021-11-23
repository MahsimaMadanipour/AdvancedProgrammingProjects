package hamrahbank;

import java.util.Scanner;

/**
 * @author Mahsima Madaniopour
 * @author Nastaran Mahmoudifard
 * @author Sana Lashgari
 * @author Sara Fahimi
 */
public class Phone extends Card {

    String PhoneNumber;
    String MobileNumber;
    long PhoneBill;
    long MobileBill;

    public Phone(String[] cardinfo, String[] phoneinfo) {
        super(cardinfo);
        PhoneNumber = phoneinfo[2];
        MobileNumber = phoneinfo[0];
        PhoneBill = Long.valueOf(phoneinfo[3]);
        MobileBill = Long.valueOf(phoneinfo[1]);
    }

    public void Bill(Phone[] plist, int idx, int ramz) {
        System.out.println("Please Choose your Bill : (Phone/Mobile)");
        Scanner input = new Scanner(System.in);
        String PorM = input.nextLine();
        if (PorM.equalsIgnoreCase("phone")) {
            System.out.println("Please Enter your phone Number :");
            Scanner input1 = new Scanner(System.in);
            String phonen = input1.nextLine();
            boolean controlp = false;
            if (phonen.equalsIgnoreCase(PhoneNumber)) {
                controlp = true;
                System.out.println(PhoneBill);
            }

            if (controlp) {
                System.out.println("Aya mikhahid pardakht konid? Yes/No");
                Scanner input2 = new Scanner(System.in);
                String ans = input2.nextLine();
                if (ans.equalsIgnoreCase("Yes")) {
                    if (plist[idx].PhoneBill < plist[idx].getbalance()) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            plist[idx].PhoneBill = 0;
                            long temp = plist[idx].getbalance();
                            temp -= plist[idx].PhoneBill;
                            plist[idx].setbalance(temp);
                        }

                    } else {
                        System.out.println("Mojodi kafi nist!");
                    }
                } else if (ans.equalsIgnoreCase("No")) {
                    System.out.println("Bawshe! :(");
                }
            } else {
                System.out.println("Wrong Number!!");
            }
        } else if (PorM.equalsIgnoreCase("mobile")) {
            System.out.println("Please Enter your Mobile Number :");
            Scanner input2 = new Scanner(System.in);
            String mobilen = input2.nextLine();
            boolean controlm = false;
            if (mobilen.equalsIgnoreCase(MobileNumber)) {
                controlm = true;
                System.out.println(MobileBill);
            }

            if (controlm) {
                System.out.println("Aya mikhahid pardakht konid? Yes/No");
                Scanner input3 = new Scanner(System.in);
                String ans = input3.nextLine();
                if (ans.equalsIgnoreCase("Yes")) {
                    if (MobileBill < plist[idx].getbalance()) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            MobileBill = 0;
                            long temp = plist[idx].getbalance();
                            temp -= MobileBill;
                            plist[idx].setbalance(temp);
                        }

                    } else {
                        System.out.println("Mojodi kafi nist!");
                    }
                } else if (ans.equalsIgnoreCase("No")) {
                    System.out.println("Bawshe! :(");
                }
            }
        }
    }

    public void ChargeorInternet(Phone[] plist, int idx, int ramz) {
        System.out.println("Choose your Operator :");
        System.out.println("1.Hamrah Aval");
        System.out.println("2.Irancell");
        System.out.println("3.Rightel");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        if (!(option >= 1 && option <= 3)) {
            System.out.println("Wrong Operator!you should choose an operator from the list.");
            option = input.nextInt();
        }
        String totalnumber = null;
        switch (option) {
            case 1:
                System.out.print("choose (1.091 / 2.099):");
                Scanner inputtemp = new Scanner(System.in);
                int tempnum = inputtemp.nextInt();
                if (tempnum == 2) {
                    System.out.print("099");
                    Scanner input3 = new Scanner(System.in);
                    String number = input3.nextLine();
                    totalnumber = "091" + number;
                    if (!(totalnumber.length() == 11)) {
                        System.out.print("Number is not valid! Enter (099********):");
                        number = input3.nextLine();
                    }
                } else if (tempnum == 1) {
                    System.out.print("091");
                    Scanner input4 = new Scanner(System.in);
                    String number = input4.nextLine();
                    totalnumber = "091" + number;
                    if (!(totalnumber.length() == 11)) {
                        System.out.print("Number is not valid! Enter (091********):");
                        number = input4.nextLine();
                    }

                }

                break;
            case 2:
                System.out.print("choose (1.093 / 2.090):");
                Scanner inputtemp2 = new Scanner(System.in);
                int tempnum2 = inputtemp2.nextInt();
                if (tempnum2 == 2) {
                    System.out.print("090");
                    Scanner input3 = new Scanner(System.in);
                    String number = input3.nextLine();
                    totalnumber = "090" + number;
                    if (!(totalnumber.length() == 11)) {
                        System.out.print("Number is not valid! Enter (090********):");
                        number = input3.nextLine();
                    }
                } else if (tempnum2 == 1) {
                    System.out.print("093");
                    Scanner input4 = new Scanner(System.in);
                    String number = input4.nextLine();
                    totalnumber = "093" + number;
                    if (!(totalnumber.length() == 11)) {
                        System.out.print("Number is not valid! Enter (093********):");
                        number = input4.nextLine();
                    }
                }
                break;
            case 3:
                System.out.print("choose (1.0921 / 2.0922):");
                Scanner inputtemp3 = new Scanner(System.in);
                int tempnum3 = inputtemp3.nextInt();
                if (tempnum3 == 2) {
                    System.out.print("0922");
                    Scanner input3 = new Scanner(System.in);
                    String number = input3.nextLine();
                    totalnumber = "0922" + number;
                    if (!(totalnumber.length() == 11)) {
                        System.out.print("Number is not valid! Enter (0922********):");
                        number = input3.nextLine();
                    }
                } else if (tempnum3 == 1) {
                    System.out.print("0921");
                    Scanner input4 = new Scanner(System.in);
                    String number = input4.nextLine();
                    totalnumber = "0921" + number;
                    if (!(totalnumber.length() == 11)) {
                        System.out.print("Number is not valid! Enter (0921********):");
                        number = input4.nextLine();
                    }
                }
                break;
        }
        System.out.println("Khadamate moredenazare khod ra entekhab konid : (Charge / Internet)");
        Scanner input5 = new Scanner(System.in);
        String service = input5.nextLine();
        if (service.equalsIgnoreCase("Charge")) {
            Charge(plist, idx, ramz);
        } else if (service.equalsIgnoreCase("Internet")) {
            Internet(plist, idx, ramz);
        } else {
            System.out.print("Invalid Service!");
        }

    }

    public void Internet(Phone[] plist, int idx, int ramz) {
        System.out.println("Choose your Internet package : ");
        System.out.println("1.500MB-Daily");
        System.out.println("2.1GB-Weekly");
        System.out.println("3.5GB-Monthly");
        System.out.println("4.10GB-Yearly");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {
            case 1:
                System.out.println("hazine baste shoma 5000 toman ast");
                if (getbalance() > 5000) {
                    if (Deposit(plist, plist.length, idx, ramz)) {
                        long temp = plist[idx].getbalance();
                        temp -= 5000;
                        plist[idx].setbalance(temp);
                        print();
                    }

                } else {
                    System.out.println("You don't have enough money");
                }
                break;
            case 2:
                System.out.println("hazine baste shoma 10000 toman ast");
                if (getbalance() > 10000) {
                    if (Deposit(plist, plist.length, idx, ramz)) {
                        long temp = plist[idx].getbalance();
                        temp -= 10000;
                        plist[idx].setbalance(temp);
                        print();
                    }

                } else {
                    System.out.println("You don't have enough money");
                }
                break;
            case 3:

                System.out.println("hazine baste shoma 15000 toman ast");
                if (getbalance() > 15000) {
                    if (Deposit(plist, plist.length, idx, ramz)) {
                        long temp = plist[idx].getbalance();
                        temp -= 15000;
                        plist[idx].setbalance(temp);
                        print();
                    }

                } else {
                    System.out.println("You don't have enough money");
                }
                break;
            case 4:
                System.out.println("hazine baste shoma 20000 toman ast");
                if (getbalance() > 20000) {
                    if (Deposit(plist, plist.length, idx, ramz)) {
                        long temp = plist[idx].getbalance();
                        temp -= 20000;
                        plist[idx].setbalance(temp);
                        print();
                    }

                } else {
                    System.out.println("You don't have enough money");
                }
                break;
            default:
                System.out.println("We don't have this package!");
                break;
        }

    }

    public void Charge(Phone[] plist, int idx, int ramz) {
        System.out.println("Choose your charge package : ");
        System.out.println("1.2000toman");
        System.out.println("2.5000toman");
        System.out.println("3.10000toman");
        System.out.println("4.20000toman");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {
            case 1:
                System.out.println("noe sharzh ra entekhab konid adi/shegeft angiz");
                Scanner input1 = new Scanner(System.in);
                String AorS = input1.nextLine();
                if (AorS.equalsIgnoreCase("adi")) {
                    System.out.println("hazine sharzh shoma ba ehtesab 9% maliat 2180 toman ast.");
                    if (getbalance() > 2180) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            long temp = plist[idx].getbalance();
                            temp -= 2180;
                            plist[idx].setbalance(temp);
                            System.out.println("Etebare hesabe shoma : 2000");
                            print();
                        }

                    } else {
                        System.out.println("You don't have enough money");
                    }
                } else if (AorS.equalsIgnoreCase("shegeft angiz")) {
                    System.out.println("hazine sharzh shoma ba ehtesab 9% maliat 2180 toman ast.");
                    if (getbalance() > 2180) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            long temp = plist[idx].getbalance();
                            temp -= 2180;
                            plist[idx].setbalance(temp);
                            System.out.println("Etebare hesabe shoma : 2250");
                            print();
                        }

                    } else {
                        System.out.println("You don't have enough money");
                    }
                } else {
                    System.out.println("we don't offer these kind of services");
                }
                break;
            case 2:
                System.out.println("noe sharzh ra entekhab konid adi/shegeft angiz");
                Scanner input2 = new Scanner(System.in);
                String AorS2 = input2.nextLine();
                if (AorS2.equalsIgnoreCase("adi")) {
                    System.out.println("hazine sharzh shoma ba ehtesab 9% maliat 5450 toman ast.");
                    if (getbalance() > 5450) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            long temp = plist[idx].getbalance();
                            temp -= 5450;
                            plist[idx].setbalance(temp);
                            System.out.println("Etebare hesabe shoma : 5000");
                            print();
                        }

                    } else {
                        System.out.println("You don't have enough money");
                    }
                } else if (AorS2.equalsIgnoreCase("shegeft angiz")) {
                    System.out.println("hazine sharzh shoma ba ehtesab 9% maliat 5450 toman ast.");
                    if (getbalance() > 5450) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            long temp = plist[idx].getbalance();
                            temp -= 5450;
                            plist[idx].setbalance(temp);
                            System.out.println("Etebare hesabe shoma : 5500");
                            print();
                        }

                    } else {
                        System.out.println("You don't have enough money");
                    }
                } else {
                    System.out.println("we don't offer these kind of services");
                }
                break;
            case 3:
                System.out.println("noe sharzh ra entekhab konid adi/shegeft angiz");
                Scanner input3 = new Scanner(System.in);
                String AorS3 = input3.nextLine();
                if (AorS3.equalsIgnoreCase("adi")) {
                    System.out.println("hazine sharzh shoma ba ehtesab 9% maliat 10900 toman ast.");
                    if (getbalance() > 10900) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            long temp = plist[idx].getbalance();
                            temp -= 10900;
                            plist[idx].setbalance(temp);
                            System.out.println("Etebare hesabe shoma : 10000");
                            print();
                        }
                    } else {
                        System.out.println("You don't have enough money");
                    }
                } else if (AorS3.equalsIgnoreCase("shegeft angiz")) {
                    System.out.println("hazine sharzh shoma ba ehtesab 9% maliat 2180 toman ast.");
                    if (getbalance() > 10900) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            long temp = plist[idx].getbalance();
                            temp -= 10900;
                            plist[idx].setbalance(temp);
                            System.out.println("Etebare hesabe shoma : 11500");
                            print();
                        }

                    } else {
                        System.out.println("You don't have enough money");
                    }
                } else {
                    System.out.println("we don't offer these kind of services");
                }
                break;
            case 4:
                System.out.println("noe sharzh ra entekhab konid adi/shegeft angiz");
                Scanner input4 = new Scanner(System.in);
                String AorS4 = input4.nextLine();
                if (AorS4.equalsIgnoreCase("adi")) {
                    System.out.println("hazine sharzh shoma ba ehtesab 9% maliat 21800 toman ast.");
                    if (getbalance() > 21800) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            long temp = plist[idx].getbalance();
                            temp -= 21800;
                            plist[idx].setbalance(temp);
                            System.out.println("Etebare hesabe shoma : 20000");
                            print();
                        }

                    } else {
                        System.out.println("You don't have enough money");
                    }
                } else if (AorS4.equalsIgnoreCase("shegeft angiz")) {
                    System.out.println("hazine sharzh shoma ba ehtesab 9% maliat 21800 toman ast.");
                    if (getbalance() > 21800) {
                        if (Deposit(plist, plist.length, idx, ramz)) {
                            long temp = plist[idx].getbalance();
                            temp -= 21800;
                            plist[idx].setbalance(temp);
                            System.out.println("Etebare hesabe shoma : 25000");
                            print();
                        }

                    } else {
                        System.out.println("You don't have enough money");
                    }
                } else {
                    System.out.println("we don't offer these kind of services");
                }
                break;
            default:
                System.out.println("We don't have this package!");
                break;
        }

    }

    @Override
    public String toString() {
        String m = Long.toString(MobileBill);
        String p = Long.toString(PhoneBill);
        String forwrite = MobileNumber + "," + m + "," + PhoneNumber + "," + p;
        return forwrite;

    }
}
