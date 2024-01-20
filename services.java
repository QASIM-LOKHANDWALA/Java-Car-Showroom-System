import java.util.Random;
import java.util.Scanner;

public class services {
    final static String GREEN = "\u001b[32;1m";
    final static String YELLOW = "\u001b[33m";
    final static String reset = "\u001b[0m";
    Car car = new Car();
    Car[] arr = car.store();
    String carName;
    double repairCost;
    int repairDays;
    Random random = new Random();

    //  DISPLAY STARTING PAGE
    void showMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.print(YELLOW+"ENTER CAR NAME : "+reset);
        this.carName = sc.next();
        checkAvailability();
    }
    //  CHECK IF CAR SERVICE IS AVAILABLE
    void checkAvailability(){
        boolean check = false;
        int i;
        for(i=0 ; i<arr.length ; i++){
            if(this.carName.equalsIgnoreCase(arr[i].car_name)){
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Services are available!");
            estimate(i);
        }else{
            System.out.println("Services are not available!");
        }
    }
    //  ESTIMATE THE TIME AND COST FOR REPAIR
    void estimate(int i){
        double cost = arr[i].car_price;
        if(cost<=1000000){
            this.repairCost = 3500;
            this.repairDays = 1+random.nextInt(4);
        }else if(cost<=3000000 && cost>1000000){
            this.repairCost = 6000;
            this.repairDays = 1+random.nextInt(4);
        }else if(cost<=5000000 && cost>3000000){
            this.repairCost = 10000;
            this.repairDays = 1+random.nextInt(4);
        }
        System.out.println();
        System.out.println(YELLOW+"ESTIMATED COST : "+repairCost);
        System.out.println("ESTIMATED TIME : "+repairDays+" DAYS"+reset);
        details();
    }
    //  SHOW DETAILS ABOUT SERVICE CENTERS
    void details(){
        System.out.println();
        System.out.println("==============================================================================");
        System.out.println("\tOUR SERVICES ARE AVAILABLE IN BELOW MENTIONED LOCATIONS");
        System.out.println("\t1. Happy Cars , APMC   \t: +919987654123");
        System.out.println("\t2. Dream Cars , Sarkhej\t: +916578024359");
        System.out.println("\t3. Smart Cars , Thaltej\t: +919099874290");
        System.out.println("==============================================================================");
        System.out.println();
    }
}
