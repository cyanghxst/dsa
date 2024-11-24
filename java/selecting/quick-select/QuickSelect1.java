import java.util.*;

public class QuickSelect1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = generate(10);
        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        int element = quickSelect(array, 0, array.length - 1, 4);

        System.out.printf("\nThe %dth smallest element is %d\n", 4, element);
    }

    public static int[] generate(int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 101);
        }

        return array;
    }

    public static int quickSelect(int[] array, int low, int high, int k) {
        int pivotIndex = partition(array, low, high);

        if (pivotIndex == k - 1) return array[pivotIndex];

        return (pivotIndex > k - 1)
            ? quickSelect(array, low, pivotIndex - 1, k)
            : quickSelect(array, pivotIndex + 1, high, k);
    }

    public static int partition(int[] array, int low, int high) {
        int random = (int) (Math.random() * (high - low + 1)) + low;
        int pivot = array[random];

        swap(array, random, high);

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (array[j] > pivot) continue;
            i++;
            if (j > i) swap(array, j, i);
        }

        return i;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
