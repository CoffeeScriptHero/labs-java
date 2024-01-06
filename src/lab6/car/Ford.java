package lab6.car;

public class Ford extends PassengerCar {

    public Ford(String brand, String model, int price, double fuelConsumption, int maxSpeed, boolean isBroken) {
        super(brand, model, price, fuelConsumption, maxSpeed, isBroken);
    }

    public void increasePrice(int price) {
        this.price += price;
    }
}
