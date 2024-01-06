package lab6.car;

import java.util.Comparator;

/**
 *
 * Class that stands for comparing cars based on their fuel consumption.
 *
 */
public class FuelConsumptionComparator implements Comparator<PassengerCar> {

    @Override
    public int compare(PassengerCar car1, PassengerCar car2) {
        return Double.compare(car1.getFuelConsumption(), car2.getFuelConsumption());
    }
}
