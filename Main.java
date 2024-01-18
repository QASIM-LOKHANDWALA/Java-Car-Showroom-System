import java.util.*;

public class Main {
    final static String RED = "\u001b[31;1m";
    final static String YELLOW = "\u001b[33m";
    final static String reset = "\u001b[0m";
    static int size=5;
    static ArrayList<customer> userData = new ArrayList<>();
    
    public static void main(String[] args) {
        customer c1 = new customer("qas123", "Qasim Lokhandwala", "12345", "9876543210");
        customer c2 = new customer("kunal12", "Kunal Prajapati", "12345", "9839743210");
        customer c3 = new customer("kunj34", "Kunj Patel", "12345", "9876582930");
        customer c4 = new customer("nish78", "Nishit Kumawat", "12345", "9563543880");
        customer c5 = new customer("kris92", "Krish Zinzuwadia", "12345", "9895173210");
        userData.add(c1);
        userData.add(c2);
        userData.add(c3);
        userData.add(c4);
        userData.add(c5);
        int intial_choice = 0;
        while (true) {
            intial_choice = homePage();
            if(intial_choice==1 || intial_choice==2){
                break;
            }else{
                intial_choice = homePage();
            }
        }

        System.out.println();
        switch (intial_choice) {
            case 1:
                register();
                login();
                menu();
                break;
            case 2:
                login();
                menu();
                break;
        }
        System.out.println("THANK YOU FOR VISITING!");
    }        
        
    
    
    //  METHOD TO SHOW STOCK
    static void menu(){
        Scanner sc = new Scanner(System.in);
        Car car = new Car();
        Car[] Stock = car.store();
        int c = 0;
        while (c!=5) {
            System.out.println(RED+"==============================================================================");
            System.out.println("1 . SEARCH BY COMPANY\t 2 . SEARCH BY NAME\t 3 . SHOW CARS\n4 . SEARCH BY PRICE\t 5 . PURCHASE      \t 6 . SERVICES");
            System.out.println("================================<7 . EXIT>====================================");
            System.out.print("\nENTER YOUR CHOICE : "+reset);
            c = sc.nextInt();
            switch (c) {
                case 1:
                    car.search_by_company(Stock);
                break;
                case 2:
                    car.search_by_name(Stock);
                break;
                case 3:
                    car.display_all_cars(Stock);
                break;
                case 4:
                    car.search_by_price(Stock);
                break;
                case 6:
                    services s = new services();
                    s.showMenu();
                break;
                case 7:
                return;
                default:
                break;
            }
        }
    }
    //  STARTING OF APPLICATION
    static public int homePage(){
        Scanner sc = new Scanner(System.in);
        System.out.println(YELLOW+"=========================WELCOME=========================");
        System.out.println("1 . << REGISTER >>\t 2 . << LOGIN >>");
        System.out.println("=========================================================");
        System.out.print("\nENTER YOUR CHOICE : "+reset);
        int intial_choice = sc.nextInt();
         
        return intial_choice;
    }
    //  LOGIN METHOD
    static void login(){
        Scanner sc = new Scanner(System.in);
        String id;
        String pass;

        boolean log = false;

        while (!log) {
            System.out.print("Enter User ID: ");
            id = sc.next();
            System.out.print("Enter password: ");
            pass = sc.next();
            for(int i=0 ; i<userData.size() ; i++){
                if(!(id.equals(userData.get(i).id) && pass.equals(userData.get(i).password))){
                    continue;
                }else{
                    log = true;
                    break;
                }
            }
        }
         
    }
    //  REGISTER METHOD
    static void register(){
        boolean check = true;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        String mno = "";

        while (true) {
            System.out.print("Enter Mobile Number: ");
            mno = sc.next();
            if(mno.length()!=10){
                System.out.println("INVALID LENGTH");
            }else if(mno.length()==10){
                for(int i=0 ; i<10 ; i++){
                    if(mno.charAt(i)<='9' && mno.charAt(i)>='0'){
                        continue;
                    }else{
                        check = false;
                        break;
                    }
                }
                if(!check){
                    System.out.println("INVALID");
                }else{
                    break;
                }
            }
        }

        System.out.print("Enter Password: ");
        String pass = sc.next();

        String[] arr = name.split(" ");
        String userId = arr[0] + mno.charAt(7) + mno.charAt(8) + mno.charAt(9);

        System.out.println("\nYOUR USER ID: " + userId);
        System.out.println("YOUR PASSWORD: " + pass + "\n");

        customer c = new customer(userId, name, pass, mno);
        userData.add(c);
        size++;
         
    }
}
