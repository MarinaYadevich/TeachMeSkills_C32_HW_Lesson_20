package by.teachmeskills.yadevich.lesson20.task1;

public class MorningTask implements Runnable{
    private final String taskName;

    public MorningTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() { // метод который содержит код программы который будет вып в потоке. Он вызывается автоматически, когда поток запускается
        System.out.println(taskName + " is running on thread: " + Thread.currentThread().getName());// получает текущий поток в котором выполняется метод и возвращает имя.
        try {
            Thread.sleep(1000); // останавливает вып текущ потока на 1000 милисек
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // если поток прерыв, то восст статус прерывания, чтобы другие части кода знали, что поток был прерван.
        }
        System.out.println(taskName + " completed on thread: " + Thread.currentThread().getName());
    }
}
