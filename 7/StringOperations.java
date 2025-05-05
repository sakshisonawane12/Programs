import java.util.Scanner;

public class StringOperations {

    // Method to check if a given string is a palindrome
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to count the occurrences of a specific character in a string
    public static int countCharacterOccurrences(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    // Method to remove all whitespace from a string
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input string from user
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Check if the string is a palindrome
        if (isPalindrome(inputString)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        // Count occurrences of a specific character
        System.out.print("Enter a character to count its occurrences: ");
        char characterToCount = scanner.next().charAt(0);
        int occurrences = countCharacterOccurrences(inputString, characterToCount);
        System.out.println("The character '" + characterToCount + "' appears " + occurrences + " times.");

        // Remove all whitespace from the string
        String stringWithoutWhitespace = removeWhitespace(inputString);
        System.out.println("String without whitespace: " + stringWithoutWhitespace);
    }
}

