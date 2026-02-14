package pr3.delivery.model;

public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String model, double baseCost, Engine engine, int numberOfSeats) {
        super(model, baseCost, engine);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public double calculateDeliveryCost() {
        return baseCost * 0.15; // different calculation for car
    }

    public double calculateDeliveryCost(double extraWeight) {
        return calculateDeliveryCost() + extraWeight * 5; // overloaded
    }

    @Override
    public String getVehicleInfo() {
        return super.getVehicleInfo() + ", Seats: " + numberOfSeats;
    }
}
