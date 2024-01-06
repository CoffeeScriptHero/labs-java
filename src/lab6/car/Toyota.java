package lab6.car;

public class Toyota extends PassengerCar {

    public Toyota(String brand, String model, int price, double fuelConsumption, int maxSpeed, boolean isBroken) {
        super(brand, model, price, fuelConsumption, maxSpeed, isBroken);
    }

    public void jump() {
        System.out.println("Toyota jumped 30 meters to the top (wtf?)");
    }
}
