package by.teachmeskills.yadevich.lesson20.task2.actionCars;

import by.teachmeskills.yadevich.lesson20.task2.serviceStation.ServiceStation;

public class CarAdder implements Runnable{
    private final ServiceStation serviceStation;

    public CarAdder(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        try {
            while (true) {//гарантирует, что поток будет непрерывно добавлять машины, пока он не будет остановлен
                serviceStation.addCar();//добавляет машину в очередь сто
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
