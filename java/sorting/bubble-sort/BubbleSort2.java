import java.util.Arrays;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] array = generate(10);
        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        bubbleSort(array);

        System.out.printf("\nSorted Array:\n%s\n", Arrays.toString(array));
    }

    public static int[] generate(int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 101);
        }

        return array;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 1; i <= array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
