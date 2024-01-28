import java.util.ArrayList;
import java.util.Scanner;

public class rentCar {
    final static String GREEN = "\u001b[32;1m";
    final static String YELLOW = "\u001b[33m";
    final static String reset = "\u001b[0m";

    Car c = new Car();
    ArrayList<Car> stock = c.store();
    int days;
    double pricePerDay;
    double totalPrice;
    
    void showMenu(){
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice!=0) {
            System.out.println(YELLOW+"\n==============================================================================");
            System.out.println("\t\t1 . VIEW CARS\t\t2 . RENT CAR");
            System.out.println("===============================< 0 . EXIT >===================================");
            System.out.print("ENTER CHOICE : "+reset);
            choice = sc.nextInt();
            
            if (choice==1) {
                viewCars();
            }else if(choice==2){
                rentCars();
            }else if(choice==0){
                System.out.println(GREEN+"\nPLEASE VISIT AGAIN!\n"+reset);
            }else{
                System.out.println(YELLOW+"INVALID CHOICE"+reset);
            }
        }
    }
    //  VIEW AL CARS
    void viewCars(){
        c.display_all_cars(stock);
    }
    //  RENT CARS
    void rentCars(){
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice!=0) {
            System.out.println(YELLOW+"\n==============================================================================");
            System.out.println("\t\t1 . NORMAL\t2 . LUXURY\t3 . DELUX");
            System.out.println("===============================< 0 . EXIT >===================================");
            System.out.print("ENTER CHOICE : "+reset);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    pricePerDay = 5000;
                    for(int i=0 ; i<stock.size() ; i++){
                        if(stock.get(i).car_price<=1000000){
                            stock.get(i).display();
                        }
                    }
                    startRenting();
                break;
                case 2:
                    pricePerDay = 7000;
                    for(int i=0 ; i<stock.size() ; i++){
                        if(stock.get(i).car_price<=3000000 && stock.get(i).car_price>1000000){
                            stock.get(i).display();
                        }
                    }
                    startRenting();
                break;
                case 3:
                    pricePerDay = 10000;
                    for(int i=0 ; i<stock.size() ; i++){
                        if(stock.get(i).car_price<=5000000 && stock.get(i).car_price>3000000){
                            stock.get(i).display();
                        }
                    }
                    startRenting();
                break;
                case 0:
                return;
                default:
                    System.out.println("INVALID CHOICE");
                break;
            }
        }
    }
    void startRenting(){
        Scanner sc = new Scanner(System.in);
        System.out.print(YELLOW+"\nENTER CAR ID TO RENT : "+reset);
        int rentID = sc.nextInt();
        System.out.print(YELLOW+"\nENTER DAYS TO RENT : "+reset);
        days = sc.nextInt();
        totalPrice = days*pricePerDay;
        billGeneration();
    }
    void billGeneration(){
        System.out.println(GREEN+"\n--------------------------------------------------------------------------------");
        System.out.println("\t\tName : "+reset+Main.userData.get(Main.index).name+"                              \t\t");
        System.out.println(GREEN+"\t\tMobile number : "+reset+Main.userData.get(Main.index).mobileNumber+"                           \t\t");
        System.out.println(GREEN+"\t\tDays : "+reset+days);
        System.out.println(GREEN+"\t\tTotal Price : "+reset+totalPrice);
        System.out.println(GREEN+"--------------------------------------------------------------------------------"+reset);
        System.out.println(YELLOW+"\nYOU HAVE TO PAY 50% ADVANCE\n"+reset);
        downPayment();
    }
    void downPayment(){
        Scanner sc = new Scanner(System.in);
        System.out.print(YELLOW+"ENTER CARD NUMBER : "+reset);
        String card = sc.next();
        if(card.length()!=16){
            System.out.println(YELLOW+"\nINVALID CARD NUMBER\n"+reset);
            downPayment();
        }else{
            System.out.print(YELLOW+"ENTER CVV : "+reset);
            String cvv = sc.next();
            if(cvv.length()!=3){
                System.out.println(YELLOW+"\nINVALID CVV\n"+reset);
                downPayment();
            }else{
                System.out.printf(GREEN+"%.2f HAS BEEN DEBITED FROM YOUR ACCOUNT\n"+reset,(totalPrice*50)/100.0);
            }
        }
    }
}
