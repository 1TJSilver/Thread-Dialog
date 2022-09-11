public class Main {
    public static void main(String[] args) throws Exception{
        ThreadGroup group = new ThreadGroup("Group");
        MyThread thread1 = new MyThread(group, "First");
        MyThread thread2 = new MyThread(group, "Second");
        MyThread thread3 = new MyThread(group, "Third");
        MyThread thread4 = new MyThread(group, "Fourth");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(15_000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        group.interrupt();
    }
}
