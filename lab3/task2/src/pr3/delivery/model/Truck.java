package pr3.delivery.model;

public class Truck extends Vehicle {
    private double maxLoad;

    public Truck(String model, double baseCost, Engine engine, double maxLoad) {
        super(model, baseCost, engine);
        this.maxLoad = maxLoad;
    }

    @Override
    public double calculateDeliveryCost() {
        return baseCost * 0.2; // truck-specific cost
    }

    public double calculateDeliveryCost(double distance, double fuelPrice) {
        return calculateDeliveryCost() + distance * fuelPrice; // overloaded
    }

    @Override
    public String getVehicleInfo() {
        return super.getVehicleInfo() + ", Max Load: " + maxLoad;
    }
}
