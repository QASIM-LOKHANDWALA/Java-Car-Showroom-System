import java.util.ArrayList;
import java.util.Scanner;

public class deepCleaning {
    final static String GREEN = "\u001b[32;1m";
    final static String RED = "\033[1;31m";
    final static String YELLOW = "\u001b[33m";
    final static String reset = "\u001b[0m";
    Car c = new Car();
    ArrayList<Car> stock = c.store();
    int price = 5000;

    void showMenu(){
        Scanner sc = new Scanner(System.in);
        int choice=-1;
        while (choice!=0) {
            System.out.println(YELLOW+"\n==============================================================================");
            System.out.println("\t1 . VIEW AVAILABLE CAR FOR SERVICES\t2 . BOOK CLEANING");
            System.out.println("===============================<"+RED+" 0 . EXIT "+YELLOW+">===================================");
            System.out.print("ENTER CHOICE : "+reset);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    viewCars();
                break;
                case 2:
                    book();
                break;
                case 0:
                return;
                default:
                    System.out.println("INVALID CHOICE");
                break;
            }
        }
        
    }

    void book() {
        Scanner sc = new Scanner(System.in);
        System.out.print(YELLOW+"\nENTER CAR ID : "+reset);
        int ID = sc.nextInt();
        bill();
        contact();
    }

    void bill(){
        System.out.println(GREEN+"\n--------------------------------------------------------------------------------");
        System.out.println("\t\tName : "+reset+Main.userData.get(Main.index).name+"                              \t\t");
        System.out.println(GREEN+"\t\tMobile number : "+reset+Main.userData.get(Main.index).mobileNumber+"                           \t\t");
        System.out.println(GREEN+"\t\tPrice : "+reset+price);
        System.out.println(GREEN+"--------------------------------------------------------------------------------"+reset);
    }

    void viewCars() {
        c.display_all_cars(stock);
    }

    void contact(){
        details();
        System.out.println(GREEN+"CONTACT US FOR ANY QUERY"+reset);
    }
    void details(){
        System.out.println();
        System.out.println(YELLOW+"==============================================================================");
        System.out.println("\tOUR SERVICES ARE AVAILABLE IN BELOW MENTIONED LOCATIONS");
        System.out.println("\t1. Happy Cars , APMC   \t: +919987654123");
        System.out.println("\t2. Dream Cars , Sarkhej\t: +916578024359");
        System.out.println("\t3. Smart Cars , Thaltej\t: +919099874290");
        System.out.println("=============================================================================="+reset);
        System.out.println();
    }
}
