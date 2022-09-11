import java.util.concurrent.Callable;

public class MyThread extends Thread implements Callable<Integer>{
    static int messageCount = 0;
    String name;
    public MyThread (String name){
        Thread.currentThread().setName(name);
        this.name = name;
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Hello! I'm thread " + Thread.currentThread().getName());
                Thread.sleep(2500);
            }
        } catch (InterruptedException ex) {

        }
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " 2 + " + messageCount + " = " + (2 + messageCount));
            messageCount++;
            Thread.sleep(500);
        }
        return messageCount;
    }

}
