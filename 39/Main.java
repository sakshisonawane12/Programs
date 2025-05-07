// Base class Employee
class Employee {
    // Method to represent work done by a generic employee
    public void work() {
        System.out.println("Employee is working.");
    }

    // Method to return the salary of the employee
    public double getSalary() {
        return 50000;  // Example salary
    }
}

// Subclass HRManager that inherits from Employee
class HRManager extends Employee {
    // Override the work() method to provide specific functionality for HRManager
    @Override
    public void work() {
        System.out.println("HR Manager is managing employee resources.");
    }

    // Additional method to add a new employee
    public void addEmployee(String employeeName) {
        System.out.println("New employee " + employeeName + " has been added to the HR department.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an Employee object
        Employee emp = new Employee();
        emp.work();  // Call the work() method
        System.out.println("Salary: $" + emp.getSalary());  // Call the getSalary() method

        // Create an HRManager object
        HRManager hrManager = new HRManager();
        hrManager.work();  // Call the overridden work() method
        hrManager.addEmployee("John Doe");  // Call the addEmployee() method
        System.out.println("Salary: $" + hrManager.getSalary());  // Call the getSalary() method from Employee class
    }
}
