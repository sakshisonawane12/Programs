import java.util.*;

abstract class Staff {
    protected String name;
    protected int id;
    protected double salary;

    public Staff(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void displayDetails();
    public abstract double calculateBonus();
    public abstract void promote();
}

class Professor extends Staff {
    private String department;

    public Professor(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Professor - Name: " + name + ", ID: " + id + ", Salary: " + salary + ", Department: " + department);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.20;
    }

    @Override
    public void promote() {
        salary += 10000;
        System.out.println(name + " promoted to Senior Professor. New salary: " + salary);
    }
}

class AdministrativeStaff extends Staff {
    private String role;

    public AdministrativeStaff(String name, int id, double salary, String role) {
        super(name, id, salary);
        this.role = role;
    }

    @Override
    public void displayDetails() {
        System.out.println("Admin Staff - Name: " + name + ", ID: " + id + ", Salary: " + salary + ", Role: " + role);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }

    @Override
    public void promote() {
        salary += 5000;
        System.out.println(name + " promoted to Senior " + role + ". New salary: " + salary);
    }
}

class MaintenanceStaff extends Staff {
    private String shift;

    public MaintenanceStaff(String name, int id, double salary, String shift) {
        super(name, id, salary);
        this.shift = shift;
    }

    @Override
    public void displayDetails() {
        System.out.println("Maintenance Staff - Name: " + name + ", ID: " + id + ", Salary: " + salary + ", Shift: " + shift);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05;
    }

    @Override
    public void promote() {
        salary += 2000;
        System.out.println(name + " promoted with shift bonus. New salary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        System.out.print("Enter number of staff members to add: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < count; i++) {
            System.out.println("\nStaff #" + (i + 1));
            System.out.println("Select type: 1. Professor  2. Administrative Staff  3. Maintenance Staff");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            Staff staff = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    staff = new Professor(name, id, salary, dept);
                    break;
                case 2:
                    System.out.print("Enter Role: ");
                    String role = scanner.nextLine();
                    staff = new AdministrativeStaff(name, id, salary, role);
                    break;
                case 3:
                    System.out.print("Enter Shift: ");
                    String shift = scanner.nextLine();
                    staff = new MaintenanceStaff(name, id, salary, shift);
                    break;
                default:
                    System.out.println("Invalid choice. Skipping...");
                    continue;
            }

            staffList.add(staff);
        }

        System.out.println("\n--- Staff Details & Actions ---");
        for (Staff s : staffList) {
            s.displayDetails();
            System.out.println("Bonus: ₹" + s.calculateBonus());
            s.promote();
            System.out.println();
        }

        scanner.close();
    }
}
