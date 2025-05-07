import java.util.Scanner;

public class MinSubarrayLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input for target
        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        // User input for array size
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int minLength = findMinSubArrayLen(target, nums);
        System.out.println("Minimum length of subarray: " + minLength);

        sc.close();
    }

    // Sliding window approach
    public static int findMinSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
