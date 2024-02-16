import java.util.ArrayList;
import java.util.Scanner;

public class admin {
    final static String BLUE = "\033[1;94m";
    final static String RED = "\033[1;31m";
    final static String YELLOW = "\u001b[33m";
    final static String reset = "\u001b[0m";
    Scanner sc = new Scanner(System.in);
    Car c = new Car();
    ArrayList<Car> stock = c.store();
    String userName = "admin";
    String password = "admin123";
    void adminLogin(){
        String un = "";
        String pass = "";
        int x = 0;
        while (!(un.equals(userName) && pass.equals(pass))) {
            if(x>0){
                System.out.println("\nINVALID CREDENTIALS");
            }
            System.out.print(BLUE+"ENTER USER NAME : "+reset);
            un = sc.next();
            System.out.print(BLUE+"ENTER PASSWORD : "+reset);
            pass = sc.next();
            x++;
        }
        makeChanges();
    }
    void checkStock(){
        c.display_all_cars(stock);
    }
    void makeChanges(){
        int choice = 0;
        while (choice!=5) {
            System.out.println(BLUE+"\nWHAT WOULD YOU LIKE TO DO ?");
            System.out.println("\n==============================================================================");
            System.out.println("\t1 . SHOW CARS\t2 . EDIT NAME\t3 . EDIT PRICE\t4 . ADD CAR");
            System.out.println("===============================<"+RED+" 5 . EXIT "+BLUE+">===================================");
            System.out.print("ENTER CHOICE : "+reset);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    checkStock();
                break;
                case 2:
                    editName();
                break;
                case 3:
                    editPrice();
                break;
                case 4:
                    addCar();
                break;
                case 5:
                    System.out.println(YELLOW+"\n\nOPERATION COMPLETED SUCCESSFULLY\n\n"+reset);
                    Main.main(null);
                break;
                default:
                break;
            }
        }
    }
    void addCar() {
        Scanner sc = new Scanner(System.in);
        Car c = new Car();
        System.out.print(YELLOW+"\nENTER CAR COMPANY : "+reset);
        c.car_company = sc.nextLine();
        System.out.print(YELLOW+"ENTER CAR NAME : "+reset);
        c.car_name = sc.nextLine();
        System.out.print(YELLOW+"ENTER CAR PRICE : "+reset);
        c.car_price = sc.nextInt();
        c.car_id = stock.size()+1;
        stock.add(c);
        stock.get(stock.size()-1).display();
    }
    void editName(){
        System.out.print(BLUE+"ENTER ID OF CAR : "+reset);
        int id = sc.nextInt();
        sc.nextLine();
        if(id>stock.size()-1){
            System.out.println("NO CAR WITH ID " + id);
            return;
        }
        stock.get(id-1).display();
        System.out.print(BLUE+"ENTER NEW NAME : "+reset);
        stock.get(id-1).car_name = sc.nextLine();
        stock.get(id-1).display();
    }
    void editPrice(){
        System.out.print(BLUE+"ENTER ID OF CAR : "+reset);
        int id = sc.nextInt();
        sc.nextLine();
        if(id>stock.size()-1){
            System.out.println("NO CAR WITH ID " + id);
            return;
        }
        stock.get(id-1).display();
        System.out.print(BLUE+"ENTER NEW PRICE : "+reset);
        stock.get(id-1).car_price = sc.nextDouble();
        stock.get(id-1).display();
    }
}
