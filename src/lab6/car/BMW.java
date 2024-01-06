package lab6.car;

import java.util.Random;

public class BMW extends PassengerCar {

    public BMW(String brand, String model, int price, double fuelConsumption, int maxSpeed, boolean isBroken) {
        super(brand, model, price, fuelConsumption, maxSpeed, isBroken);
    }

    public void startEngine() {
        int random = new Random().nextInt(2);
        isBroken = random == 1;
    }
}
