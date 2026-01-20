package lab1;
import java.util.Scanner;


public class task2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double  a = sc.nextInt();

        double Perimetr = 4*a;
        double Diagonal = Math.sqrt(a*a + a*a);

        System.out.println("Perimeter:"+Perimetr);
        System.out.print("Diagonal:"+Diagonal);

    }
}
