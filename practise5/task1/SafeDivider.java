package practise5.task1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivider {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first integer: ");
                int x1 = Integer.parseInt(scan.nextLine());

                System.out.print("Enter second integer: ");
                int x2 = Integer.parseInt(scan.nextLine());

                int result = x1 / x2;
                System.out.println("Result: " + x1 + " / " + x2 + " = " + result);

            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero is not allowed. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid integers, not text. Please try again.");
            }
        }

        // scan.close(); -- unreachable in an infinite loop, but would go here
    }
}