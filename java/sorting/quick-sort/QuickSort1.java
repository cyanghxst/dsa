public class QuickSort1 {
    public static void main(String[] args) {
        int[] array = generate(10);
        shuffle(array);

        System.out.printf("Shuffled Array:\n%s\n", java.util.Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

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

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) return; // base case

        int pivotIndex = partition(array, low, high);

        quickSort(array, low, pivotIndex - 1); // left side
        quickSort(array, pivotIndex + 1, high); // right side
    }

    public static int partition(int[] array, int low, int high) {
        int random = (int) (Math.random() * (high - low + 1)) + low;
        int pivot = array[random];

        swap(array, random, high);

        int i = low - 1;

        // lomuto's partition
        for (int j = low; j <= high; j++) {
            if (array[j] > pivot) continue;
            i++;
            if (j > i) swap(array, j, i);
        }

        return i;
    }
}
