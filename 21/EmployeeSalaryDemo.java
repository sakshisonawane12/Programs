import java.util.Scanner;

// Base class
class Employee {
    String name;
    int id;
    double basicSalary;

    // Constructor
    public Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    // Method to display details of the employee
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Basic Salary: " + basicSalary);
    }

    // Method to calculate the salary (to be overridden)
    public double calculateSalary() {
        return basicSalary;
    }
}

// Manager class derived from Employee
class Manager extends Employee {
    double bonus;

    // Constructor for Manager
    public Manager(String name, int id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    // Overriding calculateSalary method to include bonus
    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }
}

// Developer class derived from Employee
class Developer extends Employee {
    double projectAllowance;

    // Constructor for Developer
    public Developer(String name, int id, double basicSalary, double projectAllowance) {
        super(name, id, basicSalary);
        this.projectAllowance = projectAllowance;
    }

    // Overriding calculateSalary method to include project allowance
    @Override
    public double calculateSalary() {
        return basicSalary + projectAllowance;
    }
}

public class EmployeeSalaryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for Manager
        System.out.println("Enter details for Manager:");
        System.out.print("Name: ");
        String managerName = sc.nextLine();
        System.out.print("ID: ");
        int managerId = sc.nextInt();
        System.out.print("Basic Salary: ");
        double managerBasicSalary = sc.nextDouble();
        System.out.print("Bonus: ");
        double managerBonus = sc.nextDouble();
        sc.nextLine();  // Consume newline character

        // Creating Manager object
        Employee manager = new Manager(managerName, managerId, managerBasicSalary, managerBonus);

        // Taking input for Developer
        System.out.println("\nEnter details for Developer:");
        System.out.print("Name: ");
        String developerName = sc.nextLine();
        System.out.print("ID: ");
        int developerId = sc.nextInt();
        System.out.print("Basic Salary: ");
        double developerBasicSalary = sc.nextDouble();
        System.out.print("Project Allowance: ");
        double developerProjectAllowance = sc.nextDouble();

        // Creating Developer object
        Employee developer = new Developer(developerName, developerId, developerBasicSalary, developerProjectAllowance);

        // Displaying details and calculating salary for Manager
        System.out.println("\nManager Details:");
        manager.displayDetails();
        System.out.println("Total Salary: " + manager.calculateSalary());

        // Displaying details and calculating salary for Developer
        System.out.println("\nDeveloper Details:");
        developer.displayDetails();
        System.out.println("Total Salary: " + developer.calculateSalary());

        sc.close();
    }
}

