package lab1.BonusTask;

public class IntArray {
    private int[] arr;

    public IntArray(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void display() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}