import java.util.*;

class purchase{
    final static String RED = "\u001b[31;1m";
    final static String YELLOW = "\u001b[33m";
    final static String CYAN = "\u001b[36m";
    final static String reset = "\u001b[0m";
    Scanner sc = new Scanner(System.in);
    void purchase_car(Car c[]){
        boolean flag = true;
        System.out.println(YELLOW+"================================== Welcome ===================================\n");
        while(flag){
            System.out.print("Enter Car ID to purchase the Car = ");
            int selected_car = sc.nextInt();
            sc.nextLine();
            for(int i = 0 ; i<c.length ; i++){
                if(selected_car == c[i].car_id){
                    flag = false;
                    System.out.println("Your Selected Car  : ");
                    c[i].display();
                    System.out.print("\nDo you want to purchase this Car (If yes enter 'Y' or no enter 'N') : ");
                    String temp = sc.nextLine();
                    if(temp.equalsIgnoreCase("Y")){
                        System.out.println("Select Payment Mode ");
                        System.out.println("1. EMI");
                        System.out.println("2. Cash");
                        System.out.print("Enter Choice : ");
                        int ch = sc.nextInt();
                        if(ch==1){
                            emi(c[i].car_price);
                        }
                        else if(ch==2){
                            System.out.println("Submit Your Payment On The Billing Desk!!");
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
        System.out.println("\n========================== Welcome to EMI calculator =========================");
        System.out.println("Select Period From Below List");
        System.out.println("1. 24 Months ");
        System.out.println("2. 48 Months ");
        System.out.println("(Rate Of Interest per month is 9%)");
        System.out.print("Enter Choice = ");
        int choice = sc.nextInt();
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

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("|\t\tName : "+Main.userData.get(Main.index).name+"                              \t\t|");
        System.out.println("|\t\tMobile number : "+Main.userData.get(Main.index).mobileNumber+"                           \t\t|");
        System.out.printf("|\t\tYour Monthly EMI is : Rs %.2f           \t\t\t|\n",emi);
        System.out.printf("|\t\tTotal Amount after adding Interest : Rs %.2f\t\t|\n",(emi*tenureInYears*12));
        System.out.println("--------------------------------------------------------------------------------");
    }
}