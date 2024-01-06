package lab6.car;

public class Audi extends PassengerCar {

    public Audi(String brand, String model, int price, double fuelConsumption, int maxSpeed, boolean isBroken) {
        super(brand, model, price, fuelConsumption, maxSpeed, isBroken);
    }

    public void increaseMaxSpeed(int speed) {
        if (speed > 30) {
            return;
        }
        maxSpeed += speed;
    }
}
