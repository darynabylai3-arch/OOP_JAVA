package lab4.BonusTask;

public class CountingSort implements Sortable {
    private IntArray intArray;

    public CountingSort(IntArray intArray) {
        this.intArray = intArray;
    }

    @Override
    public void sort() {
        int[] arr = intArray.getArr();
        int max = 10; // диапазон 0-10
        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
}