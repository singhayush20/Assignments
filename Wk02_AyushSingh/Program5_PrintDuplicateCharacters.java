
//Print duplicate characters from a string
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Program5_PrintDuplicateCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = scanner.nextLine();
        scanner.close();

        // print duplicate characters in the string
        printDuplicateCharacters(string);
    }

    private static void printDuplicateCharacters(String string) {
        // using hashmap, print duplicate characters
        HashMap<Character, Integer> map = new HashMap<>();
        int n = string.length();

        for (int i = 0; i < n; i++) {
            char ch = string.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println("Duplicate characters are: ");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }

}
