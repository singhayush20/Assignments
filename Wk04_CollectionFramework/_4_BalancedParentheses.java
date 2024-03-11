//Check for balanced parentheses
import java.util.Stack;
public class _4_BalancedParentheses {
    public static void main(String[] args) {
        String s="[{()}]";
        String s2="[{()}";
        String s3="[{}{}([]";
        System.out.println("Is "+s+" valid: "+isValid(s));
        System.out.println("Is "+s2+" valid: "+isValid(s2));
        System.out.println("Is "+s3+" valid: "+isValid(s3));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else { 
               
                if (stack.isEmpty()) {
                    return false;
                }
              
                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stack.pop();
                } else { 
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
