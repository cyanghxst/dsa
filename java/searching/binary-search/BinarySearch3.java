import java.util.*;

public class BinarySearch3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = generate(10);
        quickSort(array, 0, array.length - 1);

        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        System.out.println("\nEnter an element to search");
        System.out.print("\n> ");

        while(!scan.hasNextInt()) {
            System.out.println("\nInvalid input. Please enter an integer");
            scan.next();
        }

        int element = scan.nextInt();
        int index = binarySearch(array, 0, array.length - 1, element);

        if (index == -1) {
            System.out.printf("\n%d not found\n", element);
            return;
        }

        System.out.printf("\nThe index of %d is %d\n", element, index);
    }

    public static int[] generate(int size) {
        int[] array = new int[size];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 101);
        }

        return array;
    }

    public static int binarySearch(int[] array, int low, int high, int key) {
        if (low > high) return -1;

        int middle = (low + high) / 2;

        if (array[middle] == key) return middle;

        return (array[middle] > key) 
            ? binarySearch(array, low, middle - 1, key)
            : binarySearch(array, middle + 1, high, key);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) return;

        int pivotIndex = partition(array, low, high);

        quickSort(array, low, pivotIndex - 1); // left side
        quickSort(array, pivotIndex + 1, high); // right side
    }

    public static int partition(int[] array, int low, int high) {
        int random = (int) (Math.random() * (high - low + 1) + low);
        int pivot = array[random];

        swap(array, high, random);

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (array[j] > pivot) continue;
            i++;
            if (j > 1) swap(array, j, i);
        }

        return i;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
