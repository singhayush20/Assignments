//Program 1: Write a small piece of code which shows simple usage of try-catch block with throw and throws keyword.

public class _01_throw_and_throws {
    public static void main(String[] args) {
        try{
            printNum(10);
            printNum(200);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void printNum(int n) throws Exception {
       if(n>100){
        throw new Exception("Exception thrown");
       }
       else{
        System.out.println("Number is: "+n);
       }
    }
}