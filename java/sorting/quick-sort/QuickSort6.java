import java.util.*;

public class QuickSort6 {
    public static void main(String[] args) {
        int[] array = generate(10, false);
        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.printf("\nSorted Array:\n%s\n", Arrays.toString(array));
    }

    public static int[] generate(int size, boolean fixedSeed) {
        Random rand = fixedSeed ? new Random(69) : new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(101);
        }

        return array;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) return;

        int partitionIndex = partition(array, low, high);

        quickSort(array, low, partitionIndex);
        quickSort(array, partitionIndex + 1, high);
    }

    public static int partition(int[] array, int low, int high) {
        int medianIndex = medianOfThree(array, low, (low + high) / 2, high);
        int pivot = array[medianIndex];

        swap(array, medianIndex, low);

        int i = low - 1;
        int j = high + 1;

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

    public static int medianOfThree(int[] array, int a, int b, int c) {
        if (array[a] > array[b] ^ array[a] < array[c]) {
            return a;
        }

        if (array[b] > array[a] ^ array[b] < array[c]) {
            return b;
        }

        return c;
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
