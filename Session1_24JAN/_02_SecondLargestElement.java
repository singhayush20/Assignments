// Find second largest element in an array

import java.util.Arrays;
import java.util.Scanner;

public class _02_SecondLargestElement {

    public static void main(String[] args) {
        int arraySize, array[];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        arraySize = scanner.nextInt();
        array = new int[arraySize];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        int secondLargestElement = findSecondLargestElement(array);
        if (secondLargestElement != Integer.MIN_VALUE) {
            System.out.println("Second largest element in " + Arrays.toString(array) + " is: " + secondLargestElement);
        } else {
            System.out.println("Array does not have enough elements to find second largest.");
        }
    }

    private static int findSecondLargestElement(int[] array) {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int element : array) {
            if (element > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = element;
            } else if (element > secondLargest && element != firstLargest) {
                secondLargest = element;
            }
        }

        return secondLargest;
    }
}
