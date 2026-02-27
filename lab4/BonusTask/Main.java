package lab4.BonusTask;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 3, 0, 10, 2, 6, 3};
        IntArray intArray = new IntArray(arr);

        System.out.println("Original array:");
        intArray.display();

        CountingSort sorter = new CountingSort(intArray);
        sorter.sort();

        System.out.println("Sorted array:");
        intArray.display();
    }
}