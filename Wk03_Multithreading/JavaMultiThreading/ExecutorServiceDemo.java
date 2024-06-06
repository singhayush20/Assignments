import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadRn t1 = new ThreadRn("Thread1", 5);
        ThreadRn t2 = new ThreadRn("Thread2", 5);
        ThreadRn t3 = new ThreadRn("Thread3", 5);
        ThreadRn t4 = new ThreadRn("Thread4", 5);
        ThreadRn t5 = new ThreadRn("Thread5", 5);
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.execute(t5);

        Callable<String> callableTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(300);
                return "Task's execution";
            }
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        Future<String> future = executorService.submit(callableTask);
        String res = null;
        try {
            res = future.get();
            System.out.println("Res: "+res);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            String result = executorService.invokeAny(callableTasks);
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

    }

    static class ThreadRn implements Runnable {
        Thread t;
        int i;

        ThreadRn(String name, int count) {
            t = new Thread(this, name);
            i = count;
        }

        @Override
        public void run() {
            for (int x = 0; x <= i; x++) {
                System.out.println(t.getName() + " " + x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}