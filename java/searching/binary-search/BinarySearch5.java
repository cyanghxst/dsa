import java.util.*;

public class BinarySearch5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = generate(20);
        Arrays.sort(array);

        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        System.out.print("\nEnter an element to search: ");
        int key = scan.nextInt();

        int index = binarySearch(array, 0, array.length - 1, key);

        if (index == -1) {
            System.out.printf("\n%d not found", key);
            return;
        }

        System.out.printf("\nThe index of %d is %d\n", key, index);
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
}
