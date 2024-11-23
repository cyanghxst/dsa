import java.util.*;

public class BinarySearch1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = generate(10);
        Arrays.toString(array);

        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        System.out.println("\nEnter an element to search");
        System.out.print("\n> ");

        while(!scan.hasNextInt()) {
            System.out.println("\nInvalid input. Please enter an interger");
            scan.next();
        }

        int element = scan.nextInt();

        int index = binarySearch(array, element);

        if (index == -1) {
            System.out.printf("\n%d not found", element);
            return;
        }

        System.out.printf("The index of %d is %d", element, index);
    }

    public static int[] generate(int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 101);
        }

        return array;
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (array[middle] == key) {
                return middle;
            }

            if (array[middle] > key) {
                high = middle - 1;
                continue;
            }

            if (array[middle] < key) {
                low = middle + 1;
            }
        }

        return -1;
    }
}
