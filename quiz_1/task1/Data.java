package quiz_1.task1;
import java.util.Scanner;

class Data {
    private double sum;
    private double max;
    private int count;

    public Data() {
        this.sum = 0.0;
        this.max = Double.MIN_VALUE;
        this.count = 0;
    }
    public void addValue(double value) {
        sum += value;
        count++;

        if (count == 1 || value > max) {
            max = value;
        }
    }
    public double getAverage() {
        if (count == 0) {
            return 0.0;
        }
        return sum / count;
    }
    public double getLargest() {
        if (count == 0) {
            return 0.0;
        }
        return max;
    }
}

class Analyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data data = new Data();
        
        System.out.println("Enter numbers (Q to quit):");
        
        while (true) {
            System.out.print("Enter number (Q to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Q")) {
                break;
            }
            
            try {
                double value = Double.parseDouble(input);
                data.addValue(value);
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid number or 'Q' to quit.");
            }
        }
        
        scanner.close();

        System.out.println("Average = " + data.getAverage());
        System.out.println("Maximum = " + data.getLargest());
    }
}