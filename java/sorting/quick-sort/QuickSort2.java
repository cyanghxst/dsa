public class QuickSort2 {
    public static void main(String[] args) {
        int[] array = generate(10);
        shuffle(array);

        System.out.printf("Shuffled Array:\n%s\n", java.util.Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        System.out.printf("\nSorted Array:\n%s\n", java.util.Arrays.toString(array));
    }

    public static int[] generate(int size) {
        int[] array = new  int[size];

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

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) return;

        int partitionIndex = partition(array, low, high);
        quickSort(array, low, partitionIndex); // left side
        quickSort(array, partitionIndex + 1, high); // right side
    }

    // tony hoare's partition
    public static int partition(int[] array, int low, int high) {
        int i = low - 1, j = high + 1;
        int pivot = array[low];

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
}
