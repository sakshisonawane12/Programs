import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get file path from user
        System.out.print("Enter the path of the text file: ");
        String filePath = scanner.nextLine();

        int charCount = 0;
        int wordCount = 0;

        try (FileInputStream fis = new FileInputStream(filePath)) {
            StringBuilder content = new StringBuilder();
            int i;

            // Read characters one by one
            while ((i = fis.read()) != -1) {
                content.append((char) i);
                charCount++;
            }

            // Count words using whitespace regex
            String[] words = content.toString().trim().split("\\s+");
            if (words.length == 1 && words[0].isEmpty()) {
                wordCount = 0;
            } else {
                wordCount = words.length;
            }

            System.out.println("\nTotal Characters: " + charCount);
            System.out.println("Total Words: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}
