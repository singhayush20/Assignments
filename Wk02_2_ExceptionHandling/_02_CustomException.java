//Write code to throw a custom exception when entered number is greater than 100 or less than 0.
import java.util.Scanner;
public class _02_CustomException {

    private static class NumberOutOfoundException extends RuntimeException{
        NumberOutOfoundException(String s){
            super(s);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner sc=new Scanner(System.in);
      int num=sc.nextInt();
     try{
        if(isNumOutOfBounds(num)){
            throw new NumberOutOfoundException("Number out of bounds");
        }
        System.out.println("Number is: "+num);
     }
     catch(NumberOutOfoundException e){
        e.printStackTrace();
     }
      finally{
          sc.close();

      }

    }
    private static boolean isNumOutOfBounds(int num) {
        return num>100 || num<0;
    }
}
