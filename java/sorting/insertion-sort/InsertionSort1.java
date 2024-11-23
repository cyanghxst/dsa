public class InsertionSort1 {
    public static void main(String[] args) {
        int[] array = generate(10);
        shuffle(array);

        System.out.printf("Shuffled Array:\n%s\n", java.util.Arrays.toString(array));

        insertionSort(array);
        System.out.printf("\nSorted Array:\n%s\n", java.util.Arrays.toString(array));
    }

    public static int[] generate(int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        return array;
    }

    public static void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int random = (int) (Math.random() * array.length);
            swap(array, i, random);
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }

            System.out.printf("\nPass %d:\n%s\n", i, java.util.Arrays.toString(array));
        }
    }
}
