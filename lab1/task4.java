package lab1;

import java.util.Scanner;

public class task4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int D = b * b - 4 * a * c;
		
		if(D < 0) {
			System.out.println("Error");
		} 
		if(D==0){
			int x = (-b)/2*a;
			System.out.print(x);
		}
		else System.out.println(D);
        
        scanner.close();
		
	}

}

