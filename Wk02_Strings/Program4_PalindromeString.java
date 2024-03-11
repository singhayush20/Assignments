
//Write a small program to find if a string is palindrome.e.g. Amma, 1221
import java.util.Scanner;

public class Program4_PalindromeString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = scanner.nextLine();
        scanner.close();

        if (isPalindrome(string)) {
            System.out.println(string + " is a palindrome");
        } else {
            System.out.println(string + " is not a palindrome");
        }
    }

    private static boolean isPalindrome(String string) {
        int start = 0, end = string.length() - 1;
        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
