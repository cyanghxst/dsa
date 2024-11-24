import java.util.*;

public class BinarySearch4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = generate(20);
        Arrays.sort(array);

        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        System.out.print("\nEnter an element to search: ");

        while(!scan.hasNextInt()) {
            scan.next();
            System.out.println("\nInvalid input. Please enter an integer");
            System.out.print("\nEnter an element to search: ");
        }

        int key = scan.nextInt();
        int index = binarySearch(array, 0, array.length - 1, key);

        if (index == -1) {
            System.out.printf("\n%d not found\n", key);
            return;
        }

        System.out.printf("\nThe index of %d is %d", key, index);
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

        if (key == array[middle]) return middle;

        return (key < array[middle])
            ? binarySearch(array, low, middle - 1, key)
            : binarySearch(array, middle + 1, high, key);
    }
}
