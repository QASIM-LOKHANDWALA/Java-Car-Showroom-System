import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class popup extends JFrame {
    popup(){
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pack();
    }
    void verifyMobile(String mno,String name){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int otp = 1000+random.nextInt(10000);
        JOptionPane.showMessageDialog(null, "YOUR OTP IS : "+otp, "VERIFT", JOptionPane.PLAIN_MESSAGE);
        String enteredOtp = JOptionPane.showInputDialog(null,"ENTER OTP ","enter here");
        if(otp == Integer.parseInt(enteredOtp)){
            JOptionPane.showMessageDialog(null, "MOBILE NUMBER VERIFIED!","SUCCESSFUL",JOptionPane.PLAIN_MESSAGE);

            System.out.print("Enter Password: ");
            String pass = sc.next();

            String[] arr = name.split(" ");
            String userId = arr[0] + mno.charAt(7) + mno.charAt(8) + mno.charAt(9);

            System.out.println("\nYOUR USER ID: " + userId);
            System.out.println("YOUR PASSWORD: " + pass + "\n");

            customer c = new customer(userId, name, pass, mno);
            Main.userData.add(c);
            Main.size++;
        }else{
            JOptionPane.showMessageDialog(null, "WRONG OTP", "INVALID", JOptionPane.ERROR_MESSAGE);
        }
    }
}
