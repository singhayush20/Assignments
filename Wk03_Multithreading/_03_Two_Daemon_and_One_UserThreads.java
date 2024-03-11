//Create two daemon and one user thread

public class _03_Two_Daemon_and_One_UserThreads {

    public static void main(String[] args) {
        // Creating two daemon threads
        Thread dt1 = new Thread(new DaemonTask(), "Daemon Thread 1");
        Thread dt2 = new Thread(new DaemonTask(), "Daemon Thread 2");

        // Setting daemon status for the daemon threads
        dt1.setDaemon(true);
        dt2.setDaemon(true);

        // Creating a user thread
        Thread tUser = new Thread(new UserTask(), "User Thread 1");

        // Starting all threads
        dt1.start();
        dt2.start();
        tUser.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting main thread... "+Thread.currentThread().getName());
    }

    // Task for daemon threads
    private static class DaemonTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " is up and running... ");
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Task for user thread
    private static class UserTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is up and running...");
            try {
                Thread.sleep(3000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
