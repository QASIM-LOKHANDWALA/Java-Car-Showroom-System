import java.util.*;

public class Main {
    static int size=1;
    static ArrayList<customer> userData = new ArrayList<>();
    
    public static void main(String[] args) {
        customer c1 = new customer("qas123", "qasim", "12345", "9876543210");
        userData.add(c1);
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
                break;
            case 2:
                login();
                break;
        }

            Car call = new Car();
            Car [] Store = call.store();
            call.display_all_cars(Store);
            System.out.println("hi");
            call.search_by_company(Store);
            call.search_by_price(Store);
        
    }
    
    //  METHOD TO SHOW STOCK
    static void showStock(){

    }
    //  STARTING OF APPLICATION
    static public int homePage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================WELCOME=========================");
        System.out.println("1 . << REGISTER >>\t 2 . << LOGIN >>");
        System.out.println("=========================================================");
        System.out.print("\nENTER YOUR CHOICE : ");
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
