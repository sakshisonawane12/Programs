// Base class Shape
abstract class Shape {
    // Abstract method for drawing
    public abstract void draw();

    // Abstract method for erasing
    public abstract void erase();
}

// Subclass Circle that inherits from Shape
class Circle extends Shape {
    // Implement draw() method for Circle
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }

    // Implement erase() method for Circle
    @Override
    public void erase() {
        System.out.println("Erasing a circle.");
    }
}

// Subclass Triangle that inherits from Shape
class Triangle extends Shape {
    // Implement draw() method for Triangle
    @Override
    public void draw() {
        System.out.println("Drawing a triangle.");
    }

    // Implement erase() method for Triangle
    @Override
    public void erase() {
        System.out.println("Erasing a triangle.");
    }
}

// Subclass Square that inherits from Shape
class Square extends Shape {
    // Implement draw() method for Square
    @Override
    public void draw() {
        System.out.println("Drawing a square.");
    }

    // Implement erase() method for Square
    @Override
    public void erase() {
        System.out.println("Erasing a square.");
    }
}

public class ShapeClass {
    public static void main(String[] args) {
        // Create an array of Shape references (demonstrating polymorphism)
        Shape[] shapes = new Shape[3];

        // Create objects of Circle, Triangle, and Square
        shapes[0] = new Circle();
        shapes[1] = new Triangle();
        shapes[2] = new Square();

        // Call draw() and erase() methods polymorphically
        for (Shape shape : shapes) {
            shape.draw();  // Call draw() method
            shape.erase();  // Call erase() method
            System.out.println();  // Blank line for separation
        }
    }
}
