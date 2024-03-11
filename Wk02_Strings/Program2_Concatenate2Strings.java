/*
 * Show two ways to concatenate two strings together to get the String
 * "Incture Tech"
 * String str1= "Incture"
 * String str2="Tech"
 */
public class Program2_Concatenate2Strings {
    public static void main(String[] args) {
        String str1 = "Incture", str2 = "Tech";
        String str3 = str1 + str2;
        System.out.println("Using '+': " + str3);
        String str4 = str1.concat(str2);
        System.out.println("Using concat: " + str4);
    }
}
