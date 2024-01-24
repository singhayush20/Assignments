
// Write a Java program to find the common elements between two arrays (String values)

import java.util.Scanner;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _01_CommonElementsInArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array1");
        int arr1Len = scanner.nextInt();
        System.out.println("Enter the size of the array2");
        int arr2Len = scanner.nextInt();
        System.out.println("Enter the elements of the array1");
        String arr1[] = new String[arr1Len];
        for (int i = 0; i < arr1Len; i++) {
            arr1[i] = scanner.next();
        }
        System.out.println("Enter the elements of the array2");
        String arr2[] = new String[arr2Len];
        for (int i = 0; i < arr2Len; i++) {
            arr2[i] = scanner.next();
        }
        scanner.close();
        System.out.println("Common elements of array1 and array2: " + findCommonElements(arr1, arr2));
    }

    private static List<String> findCommonElements(String[] array1, String[] array2) {
        HashSet<String> arr1 = new HashSet<>(Arrays.asList(array1));

        List<String> commonElements = new ArrayList<>();
        int arr2Len = array2.length;
        for (int i = 0; i < arr2Len; i++) {
            if (arr1.contains(array2[i])) {
                commonElements.add(array2[i]);
            }
        }
        return commonElements;
    }
}