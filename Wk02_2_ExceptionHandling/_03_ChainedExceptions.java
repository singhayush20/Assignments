
//Program to demonstrate chained exceptions
import java.util.Scanner;

public class _03_ChainedExceptions {

    private static class ApiException extends RuntimeException {
        ApiException(String m) {
            super(m);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers");
        int n = sc.nextInt();
        int m = sc.nextInt();

        try {
            int sum = calcSum(n, m);
            System.out.println("Quotient: " + sum);
        } catch (ArithmeticException e) {
            ApiException apiException = new ApiException("Error occurred while performing division operation");
            apiException.initCause(e);
            throw apiException;
        }
        finally{
            sc.close();
        }
    }

    private static int calcSum(int a, int b) {
      return a/b;
    }
}
