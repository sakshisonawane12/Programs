import java.util.Scanner;
import java.util.Arrays;

// Interface Sortable
interface Sortable {
    void sort(int[] arr);
}

// BubbleSort class implementing Sortable
class BubbleSort implements Sortable {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        // Bubble sort logic
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

// SelectionSort class implementing Sortable
class SelectionSort implements Sortable {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        // Selection sort logic
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

public class SortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        // Take user input for the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create instances of BubbleSort and SelectionSort
        Sortable bubbleSort = new BubbleSort();
        Sortable selectionSort = new SelectionSort();

        // Apply BubbleSort
        bubbleSort.sort(arr);
        System.out.println("Sorted array using BubbleSort: " + Arrays.toString(arr));

        // Get the array again from the user to apply SelectionSort
        System.out.println("Enter the elements of the array again for SelectionSort:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Apply SelectionSort
        selectionSort.sort(arr);
        System.out.println("Sorted array using SelectionSort: " + Arrays.toString(arr));

        // Close the scanner
        scanner.close();
    }
}
