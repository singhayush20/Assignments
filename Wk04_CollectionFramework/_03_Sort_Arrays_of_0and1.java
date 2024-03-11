//sort array of 0s and 1s efficiently
import java.util.Arrays;
public class _03_Sort_Arrays_of_0and1 {
    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 0, 0, 1, 1, 0, 0, 0 };
        System.out.println("Array before sorting: " + Arrays.toString(arr));
        int n = arr.length;
        sortArray(arr, 0, n - 1);
        System.out.println("Array after sorting: " + Arrays.toString(arr));
    }

    private static void sortArray(int[] arr, int i, int j) {
        while (i < j) {
            if (arr[i] == 1) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            } else {
                i++;
            }
        }
    }
}
