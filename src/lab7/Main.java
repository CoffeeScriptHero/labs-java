package lab7;

import lab6.car.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int C2 = 1309 % 2; // 1 Set
        int C3 = 1309 % 3; // 1 Однозв’язний список

        PassengerCar bmw = new BMW("BMW", "BMW X5 2022", 45000, 11.2, 270, false);
        PassengerCar audi = new Audi("Audi", "Audi A6 2016", 26000, 4.6, 250, false);
        PassengerCar ford = new Ford("Ford", "Ford Focus 2012", 8490, 5.5, 186, false);
        PassengerCar toyota = new Toyota("Toyota", "Toyota Camry 2019", 25900, 4.2, 180, false);
        PassengerCar volkswagen = new Volkswagen("Volkswagen", "Volkswagen Passat 2018", 16450, 4.7, 220, false);

        List<PassengerCar> cars = List.of(audi, ford, toyota, volkswagen);
        PassengerCarSet carSet = new PassengerCarSet(cars);

        printCarSetInfo(carSet);
        carSet.removeAll(cars);
        printCarSetInfo(carSet);

        carSet.add(audi);
        System.out.println("\nContains audi: " + carSet.contains(audi));
        System.out.println("Contains ford: " + carSet.contains(ford));

        List<PassengerCar> someCars = List.of(ford, toyota);
        carSet.addAll(someCars);
        System.out.println(carSet);

        List<PassengerCar> carsForRetaining = List.of(audi, toyota, volkswagen);
        carSet.retainAll(carsForRetaining);
        System.out.println(carSet);
        System.out.println("Contains all (Audi, Toyota): " + carSet.containsAll(List.of(audi, toyota)));
        System.out.println("Converting to array: " + Arrays.toString(carSet.toArray()));

        printCarSetInfo(carSet);
        carSet.clear();
        printCarSetInfo(carSet);
    }

    public static void printCarSetInfo(PassengerCarSet carSet) {
        System.out.println("PassengerCarSet size: " + carSet.size());
        System.out.println(carSet);
    }
}
