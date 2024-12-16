package by.teachmeskills.yadevich.lesson20.task2.actionCars;

import by.teachmeskills.yadevich.lesson20.task2.serviceStation.ServiceStation;

public class CarRemover implements Runnable{
    private final ServiceStation serviceStation;

    public CarRemover(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() { //логика удаления машин из очереди обслуживания на СТО.
        try {
            while (true) {
                serviceStation.removeCar();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
