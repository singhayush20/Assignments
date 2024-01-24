// Write a program to print all subarrays with 0 sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class _03_SubarraysWithZeroSum {

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

        findSubarraysWithZeroSum(array);
    }

    private static void findSubarraysWithZeroSum(int[] array) {
        HashMap<Integer, ArrayList<Integer>> sumMap = new HashMap<>();
        
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (sum == 0) {
                System.out.println("Subarrays with 0 sum: " + Arrays.toString(Arrays.copyOfRange(array, 0, i + 1)));
            }

            ArrayList<Integer> sumIndexList = sumMap.getOrDefault(sum, new ArrayList<>());
            if (sumMap.containsKey(sum)) {
                int sumIndexListSize = sumIndexList.size();
                for (int j = 0; j < sumIndexListSize; j++) {
                    int prevIndex = sumIndexList.get(j);
                    System.out.println("Subarrays with 0 sum: " + Arrays.toString(Arrays.copyOfRange(array, prevIndex+1, i + 1)));
                }
            }
            sumIndexList.add(i);
            sumMap.put(sum, sumIndexList);
        }
    }
}
