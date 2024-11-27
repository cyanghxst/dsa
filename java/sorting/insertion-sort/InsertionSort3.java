import java.util.*;

public class InsertionSort3 {
    public static void main(String[] args) {
        int[] array = generate(10, false);
        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        insertionSort(array);
        System.out.printf("\nSorted Array:\n%s\n", Arrays.toString(array));
    }

    public static int[] generate(int size, boolean fixedSeed) {
        Random random = fixedSeed ? new Random(69) : new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }

        return array;
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;

            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
    }
}
