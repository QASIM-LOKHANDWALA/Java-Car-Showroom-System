import java.util.ArrayList;
import java.util.Scanner;

class Car {
    final static String GREEN = "\u001b[32;1m";
    final static String YELLOW = "\u001b[33m";
    final static String reset = "\u001b[0m";
    Scanner sc = new Scanner(System.in);
    int car_id;
    String car_name;
    double car_price;
    String car_company;
    static ArrayList<Car> c;
    void display(){
        System.out.println(YELLOW+"=============================================================================="+reset);
        System.out.println(GREEN+"CAR ID : "+car_id);
        System.out.println("CAR COMPANY NAME : "+car_company);
        System.out.println("CAR NAME : "+car_name);
        System.out.println("CAR PRICE : Rs "+car_price+reset);
        System.out.println(YELLOW+"=============================================================================="+reset);
    }
    void search_by_company(ArrayList<Car> c){
        boolean flag = false;
        System.out.print(YELLOW+"Enter Company Name To Search : "+reset);
        String search = sc.nextLine();
        System.out.println(YELLOW+"Your Searched Car Is :"+reset);
        for(int i= 0;i<c.size();i++){
            if(search.equalsIgnoreCase(c.get(i).car_company))
            {
                flag = true;
                c.get(i).display();
            }
        }
        if(flag == false){
            System.out.println(YELLOW+"No Car Availabe for this Company"+reset);
        }
    }
    void search_by_name(ArrayList<Car> c){
        System.out.print(YELLOW+"Enter Car Name To Search : "+reset);
        String search = sc.nextLine();
        System.out.println(YELLOW+"Your Searched Car Is :"+reset);
        boolean flag = false;
        for(int i= 0;i<c.size();i++){
            if(search.equalsIgnoreCase(c.get(i).car_name))
            {
                flag = true;
                c.get(i).display();
            }
        }
        if(flag == false){
            System.out.println(YELLOW+"No Car Availabe for these Name"+reset);
        }
    }
    void search_by_price(ArrayList<Car> c){
        System.out.println(YELLOW+"Select Price Range From Below List");
        System.out.println("1. Less Than 10 Lakh");
        System.out.println("2. 10 Lakh to 30 Lakh");
        System.out.println("3. 30 Lakh to 50 Lakh");
        System.out.print("Enter Choice : "+reset);
        int search = sc.nextInt();
        for(int i= 0;i<c.size();i++) {
            if(search == 1){
                if(c.get(i).car_price<=1000000)
                {
                    c.get(i).display();
                }
            }
            else if(search == 2){
                if(c.get(i).car_price<=3000000 && c.get(i).car_price>1000000 )
                {
                    c.get(i).display();
                }
            }
            else if (search == 3) {
                if(c.get(i).car_price<=5000000 && c.get(i).car_price>3000000 )
                {
                    c.get(i).display();
                }
            }
            else{
                System.out.println(YELLOW+"No car available for these price range"+reset);
            }
        }
    }

    ArrayList<Car> store(){
        c = new ArrayList<>();
//Maruti cars
        Car c1 = new Car();
        c1.car_id = 1;
        c1.car_name = "Swift";
        c1.car_price = 700000;
        c1.car_company = "MARUTI SUZUKI";

        Car c2 = new Car();
        c2.car_id = 2;
        c2.car_name = "Baleno";
        c2.car_price = 800000;
        c2.car_company = "MARUTI SUZUKI";

        Car c3 = new Car();
        c3.car_id = 3;
        c3.car_name = "Ertiga";
        c3.car_price = 1000000;
        c3.car_company = "MARUTI SUZUKI";
//Toyata Cars
        Car c4 = new Car();
        c4.car_id = 4;
        c4.car_name = "Fortuner";
        c4.car_price = 4500000;
        c4.car_company = "TOYOTA";

        Car c5 = new Car();
        c5.car_id = 5;
        c5.car_name = "Hilux";
        c5.car_price = 3500000;
        c5.car_company ="TOYOTA";

        Car c6 = new Car();
        c6.car_id = 6;
        c6.car_name = "Innova";
        c6.car_price = 2800000;
        c6.car_company ="TOYOTA";

//KIA Cars
        Car c7 = new Car();
        c7.car_id = 7;
        c7.car_name = "Sonet";
        c7.car_price = 1000000;
        c7.car_company ="KIA";

        Car c8 = new Car();
        c8.car_id = 8;
        c8.car_name = "Seltos";
        c8.car_price = 1300000;
        c8.car_company ="KIA";

        Car c9 = new Car();
        c9.car_id = 9;
        c9.car_name = "Carnival";
        c9.car_price = 3000000;
        c9.car_company ="KIA";

//Hyundai
        Car c10 = new Car();
        c10.car_id = 10;
        c10.car_name = "i20";
        c10.car_price = 900000;
        c10.car_company ="HYUNDAI";


        Car c11 = new Car();
        c11.car_id = 11;
        c11.car_name = "Creta";
        c11.car_price = 1300000;
        c11.car_company ="HYUNDAI";

        Car c12 = new Car();
        c12.car_id = 12;
        c12.car_name = "Venue";
        c12.car_price = 1000000;
        c12.car_company ="HYUNDAI";

//Honda
        Car c13 = new Car();
        c13.car_id = 13;
        c13.car_name = "City";
        c13.car_price = 1500000;
        c13.car_company ="HONDA";

        Car c14 = new Car();
        c14.car_id = 14;
        c14.car_name = "Amaze";
        c14.car_price = 900000;
        c14.car_company ="HONDA";

        Car c15 = new Car();
        c15.car_id = 15;
        c15.car_name = "Civic";
        c15.car_price = 2500000;
        c15.car_company ="HONDA";

        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        c.add(c5);
        c.add(c6);
        c.add(c7);
        c.add(c8);
        c.add(c9);
        c.add(c10);
        c.add(c11);
        c.add(c12);
        c.add(c13);
        c.add(c14);
        c.add(c15);

        return c;
    }

    void display_all_cars(ArrayList<Car> c) {
        System.out.println(YELLOW+"\n==============================================================================");
        for(int i =0;i<c.size();i++) {
            System.out.println(GREEN+"CAR ID = "+c.get(i).car_id);
            System.out.println("CAR COMPANY NAME = "+c.get(i).car_company);
            System.out.println("CAR NAME = "+c.get(i).car_name);
            System.out.println("CAR PRICE = Rs "+c.get(i).car_price+reset);
            System.out.println(YELLOW+"=============================================================================="+reset);
        }
    }

}