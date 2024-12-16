package by.teachmeskills.yadevich.lesson20.task1;

public class MorningThread extends Thread{

    public MorningThread(String taskName) {
        super(taskName);
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(getName() + " completed.");
    }
}