import java.util.Scanner;

// Base class
class Fruit {
    String name;
    String taste;
    String size;

    // Constructor
    Fruit(String name, String taste, String size) {
        this.name = name;
        this.taste = taste;
        this.size = size;
    }

    // Method to be overridden
    void eat() {
        System.out.println("Fruit: " + name + ", Taste: " + taste);
    }
}

// Apple subclass
class Apple extends Fruit {
    Apple(String name, String taste, String size) {
        super(name, taste, size);
    }

    @Override
    void eat() {
        System.out.println("Apple tastes " + taste + ".");
    }
}

// Orange subclass
class Orange extends Fruit {
    Orange(String name, String taste, String size) {
        super(name, taste, size);
    }

    @Override
    void eat() {
        System.out.println("Orange tastes " + taste + ".");
    }
}

public class FruitTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Apple input
        System.out.println("Enter Apple details:");
        System.out.print("Taste: ");
        String appleTaste = sc.nextLine();
        System.out.print("Size: ");
        String appleSize = sc.nextLine();

        // Orange input
        System.out.println("\nEnter Orange details:");
        System.out.print("Taste: ");
        String orangeTaste = sc.nextLine();
        System.out.print("Size: ");
        String orangeSize = sc.nextLine();

        Apple apple = new Apple("Apple", appleTaste, appleSize);
        Orange orange = new Orange("Orange", orangeTaste, orangeSize);

        System.out.println("\nTasting Fruits:");
        apple.eat();
        orange.eat();

        sc.close();
    }
}
