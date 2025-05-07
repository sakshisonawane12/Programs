import java.util.Scanner;

interface Vehicle {
    void startRide();
    void endRide();
    double calculateFare(int distance);
}

interface PricingStrategy {
    double applyPricing(double baseFare);
}

class PeakHourPricing implements PricingStrategy {
    public double applyPricing(double baseFare) {
        return baseFare * 1.5;
    }
}

class HolidayPricing implements PricingStrategy {
    public double applyPricing(double baseFare) {
        return baseFare * 1.2;
    }
}

class NormalPricing implements PricingStrategy {
    public double applyPricing(double baseFare) {
        return baseFare;
    }
}

class Bike implements Vehicle {
    private PricingStrategy pricingStrategy;

    public Bike(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void startRide() {
        System.out.println("Bike ride started.");
    }

    public void endRide() {
        System.out.println("Bike ride ended.");
    }

    public double calculateFare(int distance) {
        double baseFare = distance * 5;
        return pricingStrategy.applyPricing(baseFare);
    }
}

class Auto implements Vehicle {
    private PricingStrategy pricingStrategy;

    public Auto(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void startRide() {
        System.out.println("Auto ride started.");
    }

    public void endRide() {
        System.out.println("Auto ride ended.");
    }

    public double calculateFare(int distance) {
        double baseFare = distance * 8;
        return pricingStrategy.applyPricing(baseFare);
    }
}

class Cab implements Vehicle {
    private PricingStrategy pricingStrategy;

    public Cab(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void startRide() {
        System.out.println("Cab ride started.");
    }

    public void endRide() {
        System.out.println("Cab ride ended.");
    }

    public double calculateFare(int distance) {
        double baseFare = distance * 12;
        return pricingStrategy.applyPricing(baseFare);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Choose vehicle
        System.out.println("Select Vehicle (1. Bike, 2. Auto, 3. Cab): ");
        int vehicleChoice = scanner.nextInt();

        // Choose pricing strategy
        System.out.println("Select Pricing Strategy (1. Normal, 2. Peak Hour, 3. Holiday): ");
        int strategyChoice = scanner.nextInt();

        // Enter distance
        System.out.println("Enter distance in km: ");
        int distance = scanner.nextInt();

        PricingStrategy strategy;
        switch (strategyChoice) {
            case 2: strategy = new PeakHourPricing(); break;
            case 3: strategy = new HolidayPricing(); break;
            default: strategy = new NormalPricing(); break;
        }

        Vehicle vehicle;
        switch (vehicleChoice) {
            case 1: vehicle = new Bike(strategy); break;
            case 2: vehicle = new Auto(strategy); break;
            case 3: vehicle = new Cab(strategy); break;
            default:
                System.out.println("Invalid vehicle choice.");
                scanner.close();
                return;
        }

        vehicle.startRide();
        double fare = vehicle.calculateFare(distance);
        System.out.println("Total Fare: ₹" + fare);
        vehicle.endRide();

        scanner.close();
    }
}
