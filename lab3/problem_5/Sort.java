package lab3.problem_5;

public class Sort {

    static <E> void swap(E[] array, int i, int j) {
        E temp   = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static <E extends Comparable<E>> void bubbleSort(E[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static <E extends Comparable<E>> void mergeSort(E[] array) {
        if (array.length <= 1) return;
        mergeSort(array, 0, array.length - 1);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] array, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Comparable<E>> void merge(E[] array, int left, int mid, int right) {
        Object[] temp = new Object[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i].compareTo(array[j]) <= 0) temp[k++] = array[i++];
            else                                    temp[k++] = array[j++];
        }
        while (i <= mid)   temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        for (int m = 0; m < temp.length; m++) {
            array[left + m] = (E) temp[m];
        }
    }
}