import java.util.Scanner;

class MathOperations {
    // Static method to calculate square
    public static int square(int n) {
        return n * n;
    }

    // Instance method to calculate cube
    public int cube(int n) {
        return n * n * n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Static method
        System.out.println("Square of " + number + ": " + MathOperations.square(number));

        // Instance method
        MathOperations obj = new MathOperations();
        System.out.println("Cube of " + number + ": " + obj.cube(number));

        sc.close();
    }
}
