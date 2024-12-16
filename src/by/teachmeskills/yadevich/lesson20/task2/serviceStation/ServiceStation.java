package by.teachmeskills.yadevich.lesson20.task2.serviceStation;

public class ServiceStation {
    private final int capacity;
    private int currentCars = 0;

    public ServiceStation(int capacity) {
        this.capacity = capacity;
    }


    public synchronized void addCar() throws InterruptedException {
        while (currentCars >= capacity) {
            System.out.println("The service station is full. Waiting...");
            wait(); //переходит в режим ожидания
        }
        currentCars++;
        System.out.println("Machine added. Now in service: " + currentCars);
        notifyAll(); //пробуждает все потоки, ожидающие на этом мониторе
    }

    public synchronized void removeCar() throws InterruptedException {
        while (currentCars <= 0) {
            System.out.println("No machines for delivery. Waiting...");
            wait();
        }
        currentCars--;
        System.out.println("The car has been picked up. Remaining in service: " + currentCars);
        notifyAll();
    }
}
