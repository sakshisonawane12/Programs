import java.util.Arrays;

public class ArrayOperations {

    // Method to find the largest and smallest elements in an array
    public static void findLargestAndSmallest(int[] arr) {
        int largest = arr[0];
        int smallest = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        
        System.out.println("Largest Element: " + largest);
        System.out.println("Smallest Element: " + smallest);
    }

    // Method to reverse an array in place
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }

    // Method to merge two arrays into a sorted array
    public static int[] mergeAndSortArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        
        // Copy elements from arr1 and arr2 into mergedArray
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        
        // Sort the merged array
        Arrays.sort(mergedArray);
        
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 1, 5};
        int[] arr2 = {9, 2, 6, 5, 3};
        
        // Find largest and smallest
        findLargestAndSmallest(arr1);
        
        // Reverse the array
        reverseArray(arr1);
        
        // Merge and sort two arrays
        int[] mergedArray = mergeAndSortArrays(arr1, arr2);
        System.out.println("Merged and Sorted Array: " + Arrays.toString(mergedArray));
    }
}
