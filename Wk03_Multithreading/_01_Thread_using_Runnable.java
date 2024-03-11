//Create a Thread by implementing Runnable interface
public class _01_Thread_using_Runnable {
    public static void main(String[] args) {
        NewThread nt = new NewThread();
        Thread thread=new Thread(nt,"number thread");
        thread.start();
    }

    private static class NewThread implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println("Child Thread: "+i);
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
