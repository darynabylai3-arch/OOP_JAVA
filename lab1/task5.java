package lab1;

import java.util.Scanner;

public class task5 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        int balance = 0;
        System.out.println("current balance: " + balance);

        int money = sc.nextInt();
        balance+=money;
        System.out.println("current balance: " + balance);


    }
}
