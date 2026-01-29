package lab1;

import java.util.Scanner;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double d = b * b - 4 * a * c;

        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x1 + " " + x2);
        } 
        else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        } 
        else {
            double real = -b / (2 * a);
            double imag = Math.sqrt(-d) / (2 * a);
            System.out.println(real + " + " + imag + "i");
            System.out.println(real + " - " + imag + "i");
        }
    }
}



