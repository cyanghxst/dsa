import java.util.*;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] array = generate(20);
        System.out.printf("Original Array:\n%s\n", Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        System.out.printf("\nSorted Array:\n%s\n", Arrays.toString(array));
    }

    public static int[] generate(int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 101);
        }

        return array;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) return;

        int pi = partition(array, low, high);
        quickSort(array, low, pi);
        quickSort(array, pi + 1, high);
    }

    public static int partition(int[] array, int low, int high) {
        int i = low - 1, j = high + 1;

        int random = (int) (Math.random() * (high - low + 1)) + low;
        int pivot = array[random];

        swap(array, random, low);

        while (true) {
            do {
                i++;
            } while (array[i] < pivot);

            do {
                j--;
            } while (array[j] > pivot);

            if (i >= j) return j;

            swap(array, i, j);
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
