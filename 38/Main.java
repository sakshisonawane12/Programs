import java.util.Scanner;

// Abstract class Person
abstract class Person {
    // Private fields
    private String name;
    private int age;

    // Constructor to initialize the fields
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and Setter methods for name and age (encapsulation)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract method
    public abstract void displayDetails();
}

// Student class inheriting from Person
class Student extends Person {
    // Additional fields
    private int rollNumber;
    private String course;

    // Constructor to initialize the fields
    public Student(String name, int age, int rollNumber, String course) {
        super(name, age);  // Calling the constructor of the parent class
        this.rollNumber = rollNumber;
        this.course = course;
    }

    // Getter and Setter methods for rollNumber and course
    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Override displayDetails() method to print student details
    @Override
    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
    }
}

// Teacher class inheriting from Person
class Teacher extends Person {
    // Additional fields
    private int employeeId;
    private String subject;

    // Constructor to initialize the fields
    public Teacher(String name, int age, int employeeId, String subject) {
        super(name, age);  // Calling the constructor of the parent class
        this.employeeId = employeeId;
        this.subject = subject;
    }

    // Getter and Setter methods for employeeId and subject
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Override displayDetails() method to print teacher details
    @Override
    public void displayDetails() {
        System.out.println("Teacher Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Subject: " + subject);
    }
}

// Main class to demonstrate polymorphism and user input
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create an array of Person references (polymorphism)
        Person[] people = new Person[2];

        // User input for Student
        System.out.println("Enter Student details:");
        System.out.print("Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Age: ");
        int studentAge = scanner.nextInt();
        System.out.print("Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        System.out.print("Course: ");
        String course = scanner.nextLine();
        
        // Storing the Student object in the array
        people[0] = new Student(studentName, studentAge, rollNumber, course);

        // User input for Teacher
        System.out.println("\nEnter Teacher details:");
        System.out.print("Name: ");
        String teacherName = scanner.nextLine();
        System.out.print("Age: ");
        int teacherAge = scanner.nextInt();
        System.out.print("Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        System.out.print("Subject: ");
        String subject = scanner.nextLine();
        
        // Storing the Teacher object in the array
        people[1] = new Teacher(teacherName, teacherAge, employeeId, subject);

        // Calling displayDetails() method for each object using a loop
        for (Person person : people) {
            person.displayDetails();
            System.out.println();  // Printing a blank line for separation
        }

        scanner.close();
    }
}
