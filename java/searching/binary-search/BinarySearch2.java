import java.util.*;

public class BinarySearch2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = generate(10);
        Arrays.sort(array);

        System.out.printf("Array:\n%s\n", Arrays.toString(array));

        System.out.println("\nEnter an element to search");
        System.out.print("\n> ");

        while (!scan.hasNextInt()) {
            System.out.println("\nInvalid value. Please enter an integer");
            scan.next();
        }

        int element = scan.nextInt();

        int index = binarySearch(array, 0, array.length - 1, element); 

        if (index == -1) {
            System.out.printf("\n%d not found\n");
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
}
