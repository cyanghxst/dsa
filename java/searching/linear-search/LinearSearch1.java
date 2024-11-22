import java.util.Scanner;

public class LinearSearch1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = generate(10);
        shuffle(array);

        System.out.printf("Array:\n%s\n", java.util.Arrays.toString(array));

        System.out.print("\nEnter an element to search: ");

        while(!scan.hasNextInt()) {
            System.out.println("\nInvalid input. Please enter an integer.");
            scan.next();
        }

        int element = scan.nextInt();
        int index = linearSearch(array, element);

        if (index == -1) {
            System.out.printf("\n%d not found.\n", element);
            return;
        }

        System.out.printf("\nThe index of %d is %d\n", element, index);
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

    public static int linearSearch(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }

        return -1;
    }
}
