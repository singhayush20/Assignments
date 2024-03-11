/*
 * Q3. String sam = "Did Sam see bees? Sam did.";
 * Q: What is the value displayed by the expression sam.length()?
 * Q: What is the value returned by the method call sam.charAt(12)?
 * Q: Write an expression that refers to the letter b in the string referred to by sam.
 */
public class Program3_StringFuncs {
    public static void main(String[] args) {
        String sam = "Did Sam see bees? Sam did.";

        System.out.println("The length of the string is: " + sam.length());
        System.out.println("The character at index 12 is: " + sam.charAt(12));
        System.out.println("The index of the letter b is: " + sam.indexOf("b"));
    }
}
