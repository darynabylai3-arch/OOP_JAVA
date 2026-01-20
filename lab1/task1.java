package lab1;

import java.util.Scanner;

public class task1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine() ;

        int count = s.length();

        System.out.println("+" + "*".repeat(count)+"+");
        System.out.println("|"+s+"|");
        System.out.println("+" + "*".repeat(count)+"+");

    }
}