package lab6.car;

public class Volkswagen extends PassengerCar {

    public Volkswagen(String brand, String model, int price, double fuelConsumption, int maxSpeed, boolean isBroken) {
        super(brand, model, price, fuelConsumption, maxSpeed, isBroken);
    }

    public void enableFlightMode() {
        System.out.println("FLIGHT MODE ENABLED");
    }
}
