import java.util.*;

public class FindMedian1 {
    public static void main(String[] args) {
        int[] array = generate(getRandom(1, 10));
        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        double median = findMedian(array);

        if (median == Math.round(median)) {
            System.out.printf("\nThe median is %.0f\n", median);
            return;
        }

        System.out.printf("\nThe median is %.1f\n", median);
    }

    public static int[] generate(int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = getRandom(0, 100);
        }

        return array;
    }

    public static int getRandom(int start, int end) {
        return (int) (Math.random() * (end - start + 1)) + start;
    }

    public static double findMedian(int[] array) {
        int size = array.length;
        int lastIndex = size - 1;

        if (size % 2 != 0) {
            return quickSelect(array, 0, lastIndex, lastIndex / 2);
        }

        int middle1 = quickSelect(array, 0, lastIndex, lastIndex / 2);
        int middle2 = quickSelect(array, 0, lastIndex, (lastIndex / 2) + 1);

        return (double) (middle1 + middle2) / 2;
    }

    public static int quickSelect(int[] array, int low, int high, int index) {
        int pivotIndex = partition(array, low, high);

        if (pivotIndex == index) return array[pivotIndex];

        return (pivotIndex > index)
            ? quickSelect(array, low, pivotIndex - 1, index)
            : quickSelect(array, pivotIndex + 1, high, index);
    }

    public static int partition(int[] array, int low, int high) {
        // pick random element as a pivot
        int random = getRandom(low, high);
        int pivot = array[random];

        // move pivot to the right most
        swap(array, random, high);

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (array[j] > pivot) continue;
            i++;
            if (j > i) swap(array, i, j);
        }

        return i;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
