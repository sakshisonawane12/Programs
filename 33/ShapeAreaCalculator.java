import java.util.Scanner;

// Shape Interface
interface Shape {
    double calculateArea();
}

// Circle class implements Shape
class Circle implements Shape {
    double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implement calculateArea for Circle
    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);  // π × radius²
    }
}

// Rectangle class implements Shape
class Rectangle implements Shape {
    double length, width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implement calculateArea for Rectangle
    @Override
    public double calculateArea() {
        return length * width;  // length × width
    }
}

// Triangle class implements Shape
class Triangle implements Shape {
    double base, height;

    // Constructor
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Implement calculateArea for Triangle
    @Override
    public double calculateArea() {
        return 0.5 * base * height;  // 0.5 × base × height
    }
}

// Main class
public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an array of Shape references
        Shape[] shapes = new Shape[3];

        // Taking input for Circle
        System.out.print("Enter radius of the circle: ");
        double radius = sc.nextDouble();
        shapes[0] = new Circle(radius);

        // Taking input for Rectangle
        System.out.print("Enter length of the rectangle: ");
        double length = sc.nextDouble();
        System.out.print("Enter width of the rectangle: ");
        double width = sc.nextDouble();
        shapes[1] = new Rectangle(length, width);

        // Taking input for Triangle
        System.out.print("Enter base of the triangle: ");
        double base = sc.nextDouble();
        System.out.print("Enter height of the triangle: ");
        double height = sc.nextDouble();
        shapes[2] = new Triangle(base, height);

        // Using polymorphism to calculate areas
        System.out.println("\nArea of Circle: " + shapes[0].calculateArea());
        System.out.println("Area of Rectangle: " + shapes[1].calculateArea());
        System.out.println("Area of Triangle: " + shapes[2].calculateArea());

        
    }
}

