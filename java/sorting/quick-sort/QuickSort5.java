import java.util.*;

public class QuickSort5 {
    public static void main(String[] args) {
        int[] array = generate(10);
        System.out.printf("Array:\n%s\n", Arrays.toString(array));

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

        int pivotIndex = partition(array, low, high);
        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }

    public static int partition(int[] array, int low, int high) {

        // median of three
        int median = median(array, low, (low + high) / 2, high);
        int pivot = array[median];

        swap(array, median, high);

        int i = low - 1;

        // lomuto's partition
        for (int j = low; j <= high; j++) {
            if (array[j] > pivot) continue;
            i++;
            if (j > i) swap(array, j, i);
        }

        return i;
    }

    public static int median(int[] array, int a, int b, int c) {
        if (array[a] > array[b] ^ array[a] < array[c]) {
            return a;
        } else if (array[b] > array[a] ^ array[b] < array[c]) {
            return b;
        } else {
            return c;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
