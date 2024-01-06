package lab6;

import lab6.car.FuelConsumptionComparator;
import lab6.car.PassengerCar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Class that represents car park.<br/>
 * There is only one private field that represents list of cars.<br/>
 * Besides constructor, getters and overridden toString method, there are several useful methods for analyzing and sorting the car park.
 *
 */
public class CarPark {

    private List<PassengerCar> cars;

    public CarPark() {}

    public CarPark(List<PassengerCar> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void setCars(List<PassengerCar> cars) {
        this.cars = cars;
    }

    public List<PassengerCar> getCars() {
        return cars;
    }

    public void addCar(PassengerCar car) {
        cars.add(car);
    }

    public int getTotalCost() {
        return cars.stream()
            .mapToInt(PassengerCar::getPrice)
            .sum();
    }

    public void sortByFuelConsumption() {
        cars.sort(new FuelConsumptionComparator());
    }

    public List<PassengerCar> getCarsMatchingSpeedRange(int from, int to) {
        return cars.stream()
            .filter(car -> car.getMaxSpeed() >= from && car.getMaxSpeed() <= to)
            .toList();
    }

    @Override
    public String toString() {
        System.out.println("Car Park:");
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> sb.append(car.toString()));
        return sb.toString();
    }
}
