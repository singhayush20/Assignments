// Create a thread which contains below methods
// • getID()
// • isAlive()
// • currentThread()
// • sleep(milliseconds)

public class _04_ThreadMethods {
    public static void main(String[] args) {
        CustomThread nt = new CustomThread();
        System.out.println(nt.getID());
        System.out.println(nt.isAlive());
        System.out.println(nt.currentThread());
        nt.sleep(1000);

    }
}

class CustomThread implements Runnable {
    private Thread thread;

    public CustomThread() {
        thread = new Thread(this);
        thread.start();
    }

    public long getID() {
        return thread.getId();
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    public Thread currentThread() {
        return Thread.currentThread();
    }

    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}
