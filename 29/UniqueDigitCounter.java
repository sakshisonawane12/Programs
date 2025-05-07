import java.util.Scanner;

public class UniqueDigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter a number: ");
        String number = sc.nextLine();

        // Array to count frequency of each digit (0-9)
        int[] freq = new int[10];

        for (char ch : number.toCharArray()) {
            if (Character.isDigit(ch)) {
                freq[ch - '0']++;
            } else {
                System.out.println("Invalid input. Please enter digits only.");
                return;
            }
        }

        // Count digits that appear only once
        int uniqueCount = 0;
        for (int count : freq) {
            if (count == 1) {
                uniqueCount++;
            }
        }

        System.out.println("Number of unique digits: " + uniqueCount);
        sc.close();
    }
}
