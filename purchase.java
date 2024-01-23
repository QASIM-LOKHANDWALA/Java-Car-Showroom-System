import java.util.*;

class purchase{
    final static String GREEN = "\u001b[32;1m";
    final static String YELLOW = "\u001b[33m";
    final static String CYAN = "\u001b[36m";
    final static String reset = "\u001b[0m";
    Scanner sc = new Scanner(System.in);
    void purchase_car(ArrayList<Car> c){
        boolean flag = true;
        System.out.println(YELLOW+"================================== Welcome ===================================\n");
        while(flag){
            System.out.print("Enter Car ID to purchase the Car : "+reset);
            int selected_car = sc.nextInt();
            sc.nextLine();
            for(int i = 0 ; i<c.size() ; i++){
                if(selected_car == c.get(i).car_id){
                    flag = false;
                    System.out.println(YELLOW+"Your Selected Car  : "+reset);
                    c.get(i).display();
                    String temp;
                    while(true){
                        System.out.print(GREEN+"\nDo you want to purchase this Car (If yes enter 'Y' or no enter 'N') : "+reset);
                        temp = sc.nextLine();
                        if(temp.equalsIgnoreCase("Y")||temp.equalsIgnoreCase("N")){
                            break;
                        }else{
                            System.out.println("\nINVALID INPUT");
                            continue;
                        }
                    }
                    if(temp.equalsIgnoreCase("Y")){
                        System.out.println(YELLOW+"\nSelect Payment Mode ");
                        System.out.println("1. EMI");
                        System.out.println("2. Cash");
                        System.out.print("Enter Choice : "+reset);
                        int ch = sc.nextInt();
                        if(ch==1){
                            emi(c.get(i).car_price);
                        }
                        else if(ch==2){
                            System.out.println(GREEN+"Submit Your Payment On The Billing Desk!!"+reset);
                        }
                    }
                    else{
                        flag = false;
                    }
                    
                }
            } 
        }
    }
    void emi(double amount){
        System.out.println(YELLOW+"\n=============================================================================");
        System.out.println("\t\t\tSELECT DURATION OF EMI");
        System.out.println("\t\t\t   1. 24 Months ");
        System.out.println("\t\t\t   2. 48 Months ");
        System.out.println("\t\t   (Rate Of Interest per month is 9%)\n");
        System.out.print("ENTER CHOICE : "+reset);
        int choice = sc.nextInt();
        if(choice!=1 && choice!=2){
            System.out.println("INVALID CHOICE");
            emi(amount);
        }else{
            double principal = amount;

            int tenureInYears = 0;
            double annualInterestRate = 9;
            if(choice ==1 ){
            tenureInYears = 2;
            }
            else if(choice == 2){
                tenureInYears = 4; 
            }
            double monthlyInterestRate = (annualInterestRate / 100) / 12;

            int numberOfPayments = tenureInYears * 12;

            double emi = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

            for(int x=0 ; x<50 ; x++){
                System.out.println();
            }
            System.out.println(GREEN+"\n--------------------------------------------------------------------------------");
            System.out.println("\t\tName : "+reset+Main.userData.get(Main.index).name+"                              \t\t");
            System.out.println(GREEN+"\t\tMobile number : "+reset+Main.userData.get(Main.index).mobileNumber+"                           \t\t");
            System.out.printf("%s\t\tYour Monthly EMI is %s: Rs %.2f           \t\t\t\n",GREEN,reset,emi);
            System.out.printf("%s\t\tTotal Amount after adding Interest :%s Rs %.2f\t\t\n",GREEN,reset,(emi*tenureInYears*12));
            System.out.println(GREEN+"--------------------------------------------------------------------------------"+reset);
        }
        
    }
}