import java.util.Scanner;
import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the array size from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        // Take user input for the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Function call to move zeroes to the end
        moveZeroesToEnd(arr);

        // Output the updated array
        System.out.println("Updated array: " + Arrays.toString(arr));

        // Close the scanner
        scanner.close();
    }

    // Function to move all zeroes to the end of the array
    public static void moveZeroesToEnd(int[] arr) {
        int nonZeroIndex = 0; // Pointer to track non-zero elements

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Swap non-zero elements with the current index
                int temp = arr[i];
                arr[i] = arr[nonZeroIndex];
                arr[nonZeroIndex] = temp;

                // Move the non-zero index forward
                nonZeroIndex++;
            }
        }
    }
}
