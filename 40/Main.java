import java.util.Scanner;

// Abstract class Shape
abstract class Shape {
    // Abstract method to calculate area
    public abstract double calculateArea();

    // Abstract method to calculate perimeter
    public abstract double calculatePerimeter();
}

// Subclass Circle that extends Shape
class Circle extends Shape {
    private double radius;  // radius of the circle

    // Constructor to initialize the radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implement calculateArea() for Circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;  // Area of circle: π * r^2
    }

    // Implement calculatePerimeter() for Circle
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;  // Perimeter of circle: 2 * π * r
    }
}

// Subclass Triangle that extends Shape
class Triangle extends Shape {
    private double side1, side2, side3;  // sides of the triangle

    // Constructor to initialize the sides of the triangle
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Implement calculateArea() for Triangle (using Heron's formula)
    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;  // semi-perimeter
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));  // Heron's formula for area
    }

    // Implement calculatePerimeter() for Triangle
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;  // Perimeter of triangle: sum of all sides
    }
}

public class Main {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Input for Circle
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        // Create a Circle object with the input radius
        Shape circle = new Circle(radius);
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

        // Input for Triangle
        System.out.print("Enter the first side of the triangle: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the second side of the triangle: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the third side of the triangle: ");
        double side3 = scanner.nextDouble();

        // Create a Triangle object with the input sides
        Shape triangle = new Triangle(side1, side2, side3);
        System.out.println("Triangle Area: " + triangle.calculateArea());
        System.out.println("Triangle Perimeter: " + triangle.calculatePerimeter());

        // Close the scanner
        scanner.close();
    }
}
