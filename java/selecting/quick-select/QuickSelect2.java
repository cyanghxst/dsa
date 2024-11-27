import java.util.*;

public class QuickSelect2 {
    public static void main(String[] args) {
        int[] array = generate(10, false);
        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        int key = 4;
        int element = quickSelect(array, 0, array.length - 1, key);

        System.out.printf("\nThe %dth smallest element is %d\n", key, element);
    }
    
    public static int[] generate(int size, boolean fixedSeed) {
        Random random = fixedSeed ? new Random(420) : new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }

        return array;
    }

    public static int quickSelect(int[] array, int low, int high, int key) {
        int pivotIndex = partition(array, low, high);

        if (pivotIndex == key - 1) return array[pivotIndex];

        return (pivotIndex > key - 1)
            ? quickSelect(array, low, pivotIndex - 1, key)
            : quickSelect(array, pivotIndex + 1, high, key);
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (array[j] <= pivot) {
                i++;
                if (j > 1) {
                    swap(array, j, i);
                }
            }
        }

        return i;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
