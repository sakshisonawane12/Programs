import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int empId;
    String empName;
    String email;
    String gender;
    float salary;

    public Employee(int empId, String empName, String email, String gender, float salary) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }

    public void GetEmployeeDetails() {
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Salary: " + salary);
        System.out.println("------------------------");
    }
}

class EmployeeDB {
    ArrayList<Employee> list = new ArrayList<>();

    public boolean addEmployee(Employee e) {
        return list.add(e);
    }

    public boolean deleteEmployee(int empId) {
        for (Employee e : list) {
            if (e.empId == empId) {
                list.remove(e);
                return true;
            }
        }
        return false;
    }

    public String showPaySlip(int empId) {
        for (Employee e : list) {
            if (e.empId == empId) {
                return "Payslip -> ID: " + e.empId + ", Name: " + e.empName + ", Salary: " + e.salary;
            }
        }
        return "Employee not found.";
    }

    public void showAllPaySlips() {
        for (Employee e : list) {
            System.out.println(showPaySlip(e.empId));
        }
    }
}

public class EmployeeManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDB empDB = new EmployeeDB();

        System.out.print("Enter number of employees to add: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Name: ");
            String empName = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Gender: ");
            String gender = sc.nextLine();
            System.out.print("Salary: ");
            float salary = sc.nextFloat();

            Employee e = new Employee(empId, empName, email, gender, salary);
            empDB.addEmployee(e);
        }

        System.out.println("\nAll Employee PaySlips:");
        empDB.showAllPaySlips();

        System.out.print("\nEnter Employee ID to delete: ");
        int delId = sc.nextInt();
        if (empDB.deleteEmployee(delId)) {
            System.out.println("Employee with ID " + delId + " deleted.");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nRemaining Employees:");
        for (Employee e : empDB.list) {
            e.GetEmployeeDetails();
        }

        sc.close();
    }
}
