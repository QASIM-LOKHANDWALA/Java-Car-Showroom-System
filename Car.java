import java.util.Scanner;

class Car {
    Scanner sc = new Scanner(System.in);
    int car_id;
    String car_name;
    double car_price;
    String car_company;
    void display(){
        System.out.println("================================================");

        System.out.println("CAR ID = "+car_id);
        System.out.println("CAR COMPANY NAME = "+car_company);
        System.out.println("CAR NAME = "+car_name);
        System.out.println("CAR PRICE = Rs "+car_price);
        System.out.println("================================================");
    }
    void search_by_company(Car[] c){
        boolean flag = false;
        System.out.print("Enter Company Name To Search = ");
        String search = sc.nextLine();
        System.out.println("Your Searched Car Is :");
        for(int i= 0;i<c.length;i++){
            if(search.equalsIgnoreCase(c[i].car_company))
            {
                flag = true;
                c[i].display();
            }
        }
        if(flag == false){
            System.out.println("No Car Availabe for these Company");
        }
    }
    void search_by_name(Car[] c){
        System.out.print("Enter Car Name To Search : ");
        String search = sc.nextLine();
        System.out.println("Your Searched Car Is :");
        boolean flag = false;
        for(int i= 0;i<c.length;i++){
            if(search.equalsIgnoreCase(c[i].car_name))
            {
                flag = true;
                c[i].display();
            }
        }
        if(flag == false){
            System.out.println("No Car Availabe for these Name");
        }
    }
    void search_by_price(Car[] c){
        System.out.println("Select Price Range From Below List");
        System.out.println("1. Less Than 10 Lakh");
        System.out.println("2. 10 Lakh to 30 Lakh");
        System.out.println("3. 30 Lakh to 50 Lakh");
        System.out.print("Enter Choice : ");
        int search = sc.nextInt();
        for(int i= 0;i<c.length;i++) {
            if(search == 1){
                if(c[i].car_price<=1000000)
                {
                    c[i].display();
                }
            }
            else if(search == 2){
                if(c[i].car_price<=3000000 && c[i].car_price>1000000 )
                {
                    c[i].display();
                }
            }
            else if (search == 3) {
                if(c[i].car_price<=5000000 && c[i].car_price>3000000 )
                {
                    c[i].display();
                }
            }
            else{
                System.out.println("No car available for these price range");
            }
        }
    }

    Car[] store(){
        Car[] c = new Car[15];
        for(int i= 0;i<c.length;i++) {
            c[i] = new Car();
        }


//Maruti cars
        c[0].car_id = 1;
        c[0].car_name = "Swift";
        c[0].car_price = 700000;
        c[0].car_company = "MARUTI SUZUKI";

        c[1].car_id = 2;
        c[1].car_name = "Baleno";
        c[1].car_price = 800000;
        c[1].car_company = "MARUTI SUZUKI";

        c[2].car_id = 3;
        c[2].car_name = "Ertiga";
        c[2].car_price = 1000000;
        c[2].car_company = "MARUTI SUZUKI";
//Toyata Cars
        c[3].car_id = 4;
        c[3].car_name = "Fortuner";
        c[3].car_price = 4500000;
        c[3].car_company = "TOYOTA";

        c[4].car_id = 5;
        c[4].car_name = "Hilux";
        c[4].car_price = 3500000;
        c[4].car_company ="TOYOTA";

        c[5].car_id = 6;
        c[5].car_name = "Innova";
        c[5].car_price = 2800000;
        c[5].car_company ="TOYOTA";

//KIA Cars
        c[6].car_id = 7;
        c[6].car_name = "Sonet";
        c[6].car_price = 1000000;
        c[6].car_company ="KIA";

        c[7].car_id = 8;
        c[7].car_name = "Seltos";
        c[7].car_price = 1300000;
        c[7].car_company ="KIA";

        c[8].car_id = 9;
        c[8].car_name = "Carnival";
        c[8].car_price = 3000000;
        c[8].car_company ="KIA";

//Hyundai

        c[9].car_id = 10;
        c[9].car_name = "i20";
        c[9].car_price = 900000;
        c[9].car_company ="HYUNDAI";


        c[10].car_id = 11;
        c[10].car_name = "Creta";
        c[10].car_price = 1300000;
        c[10].car_company ="HYUNDAI";

        c[11].car_id = 12;
        c[11].car_name = "Venue";
        c[11].car_price = 1000000;
        c[11].car_company ="HYUNDAI";

//Honda

        c[12].car_id = 13;
        c[12].car_name = "City";
        c[12].car_price = 1500000;
        c[12].car_company ="HONDA";

        c[13].car_id = 14;
        c[13].car_name = "Amaze";
        c[13].car_price = 900000;
        c[13].car_company ="HONDA";

        c[14].car_id = 15;
        c[14].car_name = "Civic";
        c[14].car_price = 2500000;
        c[14].car_company ="HONDA";
        return c;
    }

    void display_all_cars(Car c[]) {
        for(int i =0;i<c.length;i++) {
            System.out.println("CAR ID = "+c[i].car_id);
            System.out.println("CAR COMPANY NAME = "+c[i].car_company);
            System.out.println("CAR NAME = "+c[i].car_name);
            System.out.println("CAR PRICE = Rs "+c[i].car_price);
            System.out.println("================================================");
        }
    }

}