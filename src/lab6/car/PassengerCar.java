package lab6.car;

/**
 *
 * Abstract class that represents passenger car.<br/>
 * It has protected fields, getters and overridden toString method.
 *
 */
public abstract class PassengerCar {

    protected String brand;
    protected String model;
    protected int price;
    protected double fuelConsumption;
    protected int maxSpeed;
    protected boolean isBroken;

    public PassengerCar(String brand, String model, int price, double fuelConsumption, int maxSpeed, boolean isBroken) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.isBroken = isBroken;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isBroken() {
        return isBroken;
    }

    @Override
    public String toString() {
        return String.format(
            "\t- Car{Brand: %s, model: %s, price: %s, fuelConsumption: %.2f, maxSpeed: %d, isBroken: %b}\n",
            brand, model, price, fuelConsumption, maxSpeed, isBroken
        );
    }
}
