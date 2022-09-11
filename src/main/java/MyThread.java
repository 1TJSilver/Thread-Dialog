public class MyThread extends Thread{
    public MyThread (String name){
        Thread.currentThread().setName(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
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
}
