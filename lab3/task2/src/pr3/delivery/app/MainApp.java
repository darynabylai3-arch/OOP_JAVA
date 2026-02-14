package pr3.delivery.app;

import pr3.delivery.model.*;
import pr3.delivery.service.DeliveryService;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        Engine engine1 = new Engine("V6", 300);
        Engine engine2 = new Engine("Diesel", 500);

        Car car1 = new Car("Toyota Camry", 25000, engine1, 5);
        Truck truck1 = new Truck("Volvo FH", 80000, engine2, 20000);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car1);
        vehicles.add(truck1);

        DeliveryService service = new DeliveryService();
        service.printAllVehicles(vehicles);
        service.calculateAllDeliveries(vehicles);
        System.out.println("Total Delivery Cost: " + service.calculateTotalCost(vehicles));

        // Demonstrate overloading
        System.out.println("Car delivery with extra weight: " + car1.calculateDeliveryCost(100));
        System.out.println("Truck delivery with distance & fuel: " + truck1.calculateDeliveryCost(500, 3.5));
    }
}
