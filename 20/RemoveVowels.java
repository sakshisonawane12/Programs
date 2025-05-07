import java.util.Scanner;

public class RemoveVowels {
    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        // Take input from user
        System.out.print("Enter a paragraph: ");
        String paragraph = sc.nextLine();
        
        // Convert the paragraph to a StringBuilder for efficient modification
        StringBuilder transformedParagraph = new StringBuilder(paragraph);
        
        // Variable to count the number of vowels removed
        int vowelsRemoved = 0;
        
        // Loop through the paragraph and remove vowels
        for (int i = 0; i < transformedParagraph.length(); i++) {
            char ch = transformedParagraph.charAt(i);
            if (isVowel(ch)) {
                transformedParagraph.deleteCharAt(i);
                vowelsRemoved++;
                i--;  // Adjust index after removing a character
            }
        }
        
        // Output the transformed paragraph and the number of vowels removed
        System.out.println("\nTransformed Paragraph: " + transformedParagraph.toString());
        System.out.println("Total vowels removed: " + vowelsRemoved);
        
        sc.close();
    }

    // Method to check if a character is a vowel
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);  // Convert the character to lowercase for uniformity
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
