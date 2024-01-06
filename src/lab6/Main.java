package lab6;

import lab6.car.Audi;
import lab6.car.BMW;
import lab6.car.Ford;
import lab6.car.PassengerCar;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 9 - Визначити ієрархію легкових автомобілів.
        // Створити таксопарк. Порахувати вартість автопарку.
        // Провести сортування автомобілів парку за витратами палива.
        // Знайти автомобіль у компанії, що відповідає заданому діапазону швидкості автомобіля.
        int C13 = 1309 % 13;

        PassengerCar bmw = new BMW("BMW", "BMW X5 2022", 45000, 11.2, 270, false);
        //цей метод не буде доступний, адже ми створюємо змінну типу PassengerCar - тобто створюється посилання
        //типу суперкласу на об'єкт підкласу, через що методи, визначені в класі BMW нам не доступні
        //BMW.startEngine();

        BMW newBmw = new BMW("BMW", "BMW X5 2022", 45000, 11.2, 270, false);
        //у цьому випадку, ми створюємо змінну типу підкласу, тому нам і доступні методи класу BMW
        newBmw.startEngine();

        PassengerCar audi = new Audi("Audi", "Audi A6 2016", 26000, 4.6, 250, false);
        PassengerCar ford = new Ford("Ford", "Ford Focus 2012", 8490, 5.5, 186, false);
        PassengerCar toyota = new Ford("Toyota", "Toyota Camry 2019", 25900, 4.2, 180, false);
        PassengerCar volkswagen = new Ford("Volkswagen", "Volkswagen Passat 2018", 16450, 4.7, 220, false);

        CarPark carPark = new CarPark(List.of(bmw, audi, ford, toyota, volkswagen));
        System.out.println(carPark);

        System.out.println("Total cost of the car park: " + carPark.getTotalCost() + " $\n");

        carPark.sortByFuelConsumption();
        System.out.println("Cars sorted by fuel consumption");
        System.out.println(carPark);

        System.out.println("Cars with speed in range 180-220: ");
        carPark.getCarsMatchingSpeedRange(180, 220).forEach(System.out::print);

        System.out.println("\nCars with speed in range 230-300: ");
        carPark.getCarsMatchingSpeedRange(230, 300).forEach(System.out::print);
    }
}
