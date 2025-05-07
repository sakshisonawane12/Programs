import java.util.Scanner;

class TrafficLight {
    // Instance variables
    private String color;
    private int duration; // Duration in seconds

    // Constructor
    public TrafficLight(String color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    // Method to change the color
    public void changeColor(String newColor) {
        color = newColor;
        System.out.println("Traffic light color changed to: " + color);
    }

    // Method to check if the light is red
    public boolean isRed() {
        return color.equalsIgnoreCase("Red");
    }

    // Method to check if the light is green
    public boolean isGreen() {
        return color.equalsIgnoreCase("Green");
    }

    // Method to display traffic light details
    public void displayTrafficLightDetails() {
        System.out.println("Traffic Light Color: " + color);
        System.out.println("Duration: " + duration + " seconds");
    }
}

public class TrafficLightExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the color and duration of the traffic light
        System.out.print("Enter the color of the traffic light (Red/Green/Yellow): ");
        String color = scanner.nextLine();
        System.out.print("Enter the duration of the traffic light (in seconds): ");
        int duration = scanner.nextInt();

        // Creating a TrafficLight object
        TrafficLight light1 = new TrafficLight(color, duration);
        
        // Displaying initial details of the traffic light
        System.out.println("\nInitial Traffic Light Details:");
        light1.displayTrafficLightDetails();
        System.out.println();

        // Changing the traffic light color
        System.out.print("Enter the new color for the traffic light: ");
        scanner.nextLine();  // Consume the newline character
        String newColor = scanner.nextLine();
        light1.changeColor(newColor);
        light1.displayTrafficLightDetails();
        
        // Checking if the light is red or green
        System.out.println("\nIs the light red? " + light1.isRed());
        System.out.println("Is the light green? " + light1.isGreen());
    }
}
