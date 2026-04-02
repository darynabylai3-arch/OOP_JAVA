package lab3.problem_5;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {

        Chocolate[] chocolates = {
            new Chocolate("Twix",      58.0),
            new Chocolate("KitKat",    41.5),
            new Chocolate("Snickers",  92.0),
            new Chocolate("Bounty",    57.0),
            new Chocolate("Milkyway",  26.0)
        };

        Time[] times = {
            new Time(12, 30, 0),
            new Time(8,  0,  0),
            new Time(23, 59, 59),
            new Time(0,  0,  1),
            new Time(10, 15, 30)
        };

        Employee[] employees = {
            new Employee("Alice",   85000),
            new Employee("Bob",     62000),
            new Employee("Charlie", 95000),
            new Employee("Diana",   73000),
            new Employee("Eve",     48000)
        };

        System.out.println("=== Chocolates ===");
        System.out.println("Before: " + Arrays.toString(chocolates));
        Sort.bubbleSort(chocolates);
        System.out.println("Bubble: " + Arrays.toString(chocolates));

        System.out.println("\n=== Times ===");
        System.out.println("Before: " + Arrays.toString(times));
        Sort.mergeSort(times);
        System.out.println("Merge:  " + Arrays.toString(times));

        System.out.println("\n=== Employees ===");
        System.out.println("Before: " + Arrays.toString(employees));
        Sort.bubbleSort(employees);
        System.out.println("Bubble: " + Arrays.toString(employees));
    }
}