import java.util.Scanner;

public class GCDAndBinaryConverter {

    // Method to find GCD using Euclidean algorithm
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to convert decimal to binary
    public static String decimalToBinary(int num) {
        return Integer.toBinaryString(num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Find GCD of two numbers");
            System.out.println("2. Convert Decimal to Binary");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    int num1 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    int num2 = scanner.nextInt();
                    int gcd = findGCD(num1, num2);
                    System.out.println("GCD: " + gcd);
                    break;

                case 2:
                    System.out.print("Enter a decimal number: ");
                    int decimal = scanner.nextInt();
                    String binary = decimalToBinary(decimal);
                    System.out.println("Binary: " + binary);
                    break;

                case 3:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        } while (choice != 3);

        scanner.close();
    }
}

