import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception{
        ThreadGroup group = new ThreadGroup("Group");
        Callable<Integer> thread1 = new MyThread(group, "First");
        Callable<Integer> thread2 = new MyThread(group, "Second");
        Callable<Integer> thread3 = new MyThread(group, "Third");
        Callable<Integer> thread4 = new MyThread(group, "Fourth");


        ExecutorService threadPull = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer> future = threadPull.submit(thread1);

        threadPull.invokeAll(Arrays.asList(thread1, thread2, thread3, thread4));
        try {
            Thread.sleep(15_000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        threadPull.shutdown();
        group.interrupt();

    }
}
