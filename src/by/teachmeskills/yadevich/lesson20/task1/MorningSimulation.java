package by.teachmeskills.yadevich.lesson20.task1;

/** Task 1.
 Create a program that simulates the morning: reading the news, breakfast, coffee.
 Set each thread to a name and priority from the config file.
 Let there be 3 threads.
 Create and run 3 threads.
 Make two options: using the Runnable interface and/or using the Thread class.
 */

public class MorningSimulation {
    public static void main(String[] args) {

        Thread newsThread = new Thread(new MorningTask("Reading news"), "NewsThread"); //передается объект MorningTask
        newsThread.setPriority(Thread.NORM_PRIORITY);

        MorningThread breakfastThread = new MorningThread("BreakfastThread"); // создается поток
        breakfastThread.setPriority(Thread.MAX_PRIORITY);

        Thread coffeeThread = new Thread(new MorningTask("Coffee time"), "CoffeeThread"); // создает объект класса Thread там передается обьект MorningTask, которая представляет выполнение действия Coffee time.
        coffeeThread.setPriority(Thread.MIN_PRIORITY);

        newsThread.start(); // запускает выполнение потока, этот метод вызывает метод run
        breakfastThread.start();
        coffeeThread.start();
        try {
            newsThread.join();//основной поток приостанавливается, пока указанные потоки не завершат свое выполнение. гарантирует, что все задачи будут завершены до выполнения следующего кода.
            breakfastThread.join();
            coffeeThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Morning routine completed!");
    }
}

