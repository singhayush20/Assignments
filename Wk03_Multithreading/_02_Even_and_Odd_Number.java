 //Print even and odd numbers using different threads
 class PrintEvenThread implements Runnable {
    private int maxVal;

    public PrintEvenThread(int maxVal) {
        this.maxVal = maxVal;
    }

    @Override
    public void run() {
        for (int i = 2; i <= maxVal; i += 2) {
            System.out.println(Thread.currentThread().getName() + "=> " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PrintOddThread implements Runnable {
    private int maxVal;

    public PrintOddThread(int maxVal) {
        this.maxVal = maxVal;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maxVal; i += 2) {
            System.out.println(Thread.currentThread().getName() + "=> " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class _02_Even_and_Odd_Number {
    public static void main(String[] args) {
        int maxVal = 20; 

        PrintEvenThread even = new PrintEvenThread(maxVal);
        PrintOddThread odd = new PrintOddThread(maxVal);

        Thread evenThread = new Thread(even, "Even");
        Thread oddThread = new Thread(odd, "Odd");

        evenThread.start();
        oddThread.start();
    }
}
