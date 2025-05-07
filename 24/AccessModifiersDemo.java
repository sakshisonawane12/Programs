import java.util.Scanner;

// Base class Person
class Person {
    private String name;
    public int age;
    protected String address;
    String phoneNumber;

    public Person(String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public void updatePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
}

// Derived class Employee
class Employee extends Person {
    public int employeeId;

    public Employee(String name, int age, String address, String phoneNumber, int employeeId) {
        super(name, age, address, phoneNumber);
        this.employeeId = employeeId;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee ID: " + employeeId);
    }
}

public class AccessModifiersDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Employee
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter employee ID: ");
        int employeeId = sc.nextInt();

        // Create Employee object
        Employee emp = new Employee(name, age, address, phoneNumber, employeeId);

        // Display details
        emp.displayDetails();

        // Update and display phone number
        sc.nextLine(); // Consume newline
        System.out.print("Enter new phone number: ");
        String newPhone = sc.nextLine();
        emp.updatePhoneNumber(newPhone);
        System.out.println("Updated Phone Number: " + emp.phoneNumber);

        sc.close();
    }
}
