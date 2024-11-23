public class SelectionSort2 {
    public static void main(String[] args) {
        int[] array = generate(10);
        shuffle(array);

        System.out.printf("Shuffled Array:\n%s\n", java.util.Arrays.toString(array));

        selectionSort(array);

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

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexOfSmallest = getIndexOfSmallestFrom(array, i);
            swap(array, i, indexOfSmallest);
        }
    }

    public static int getIndexOfSmallestFrom(int[] array, int index) {
        int smallest = array[index];
        int indexOfSmallest = index;

        for (int i = index; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                indexOfSmallest = i;
            }
        }

        return indexOfSmallest;
    }
}
