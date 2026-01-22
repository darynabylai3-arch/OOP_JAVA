package lab1;
import java.util.Scanner;


public class task3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();

        if(x<=100 && x>=95){
            System.out.println("A+");
        }
        if(x<95 && x>=90){
            System.out.println("A-");
        }
        if(x<90 && x>=80){
            System.out.println("B+");
        }
        if(x<80 && x>=75){
            System.out.println("B-");
        }
        if(x<75 && x>=70){
            System.out.println("C+");
        }
        if(x<70 && x>=60){
            System.out.println("C-");
        }
        if(x<60 && x>=50){
            System.out.println('D');
        }

        sc.close();



    }
}