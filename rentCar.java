import java.util.ArrayList;
import java.util.Scanner;

public class rentCar {
    final static String GREEN = "\u001b[32;1m";
    final static String YELLOW = "\u001b[33m";
    final static String reset = "\u001b[0m";
    Car c = new Car();
    ArrayList<Car> stock = c.store();
    
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

            }else if(choice==0){
                System.out.println(GREEN+"\nPLEASE VISIT AGAIN!\n"+reset);
            }else{
                System.out.println(YELLOW+"INVALID CHOICE"+reset);
            }
        }
    }
    void viewCars(){
        System.out.println(YELLOW+"\n==============================================================================");
        for(int i =0;i<stock.size();i++) {
            if(stock.get(i).car_price>2000000){
                continue;
            }
            System.out.println(GREEN+"CAR ID = "+stock.get(i).car_id);
            System.out.println("CAR COMPANY NAME = "+stock.get(i).car_company);
            System.out.println("CAR NAME = "+stock.get(i).car_name);
            System.out.println("CAR PRICE = Rs "+stock.get(i).car_price+reset);
            System.out.println(YELLOW+"=============================================================================="+reset);
        }
    }
}
