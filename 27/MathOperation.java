import java.util.Scanner;

public class MathOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        int sum = 0;
        double average = 0.0;

        try {
            System.out.println("Enter 5 integers:");

            for (int i = 0; i < 5; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                String input = sc.nextLine(); // taking input as String
                numbers[i] = Integer.parseInt(input); // converting to int
                sum += numbers[i];
            }

            average = sum / 5.0;

            System.out.println("\nSum: " + sum);
            System.out.println("Average: " + average);
        } 
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Cannot divide by zero.");
        } 
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Please enter valid integers only.");
        } 
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } 
        finally {
            sc.close();
        }
    }
}
