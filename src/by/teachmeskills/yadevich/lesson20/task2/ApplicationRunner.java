package by.teachmeskills.yadevich.lesson20.task2;

import by.teachmeskills.yadevich.lesson20.task2.actionCars.CarAdder;
import by.teachmeskills.yadevich.lesson20.task2.actionCars.CarRemover;
import by.teachmeskills.yadevich.lesson20.task2.constant.CarsConstant;
import by.teachmeskills.yadevich.lesson20.task2.serviceStation.ServiceStation;

/** Task 2.
 There is a service station. The station can service a maximum of a certain number of cars.
 Create a class that will run in a separate thread and will add cars for service at the service station.
 Create a class that will run in a separate thread and will take repaired cars from the service station.
 Let the maximum number of cars available for service be specified in the interface for storing constants.
 Use synchronized, wait, notify.
 */

public class ApplicationRunner {
    public static void main(String[] args) {
            ServiceStation serviceStation = new ServiceStation(CarsConstant.MAX_CAPACITY);

            Thread adderThread = new Thread(new CarAdder(serviceStation)); // создается поток и передается объект serviceStation
            Thread removerThread = new Thread(new CarRemover(serviceStation));

            adderThread.start();
            removerThread.start();
    }
}
