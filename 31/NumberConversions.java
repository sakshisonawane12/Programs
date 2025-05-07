public class NumberConversions {
    public static void main(String[] args) {
        // Check if the user has provided a command-line argument
        if (args.length < 1) {
            System.out.println("Please provide an integer as a command-line argument.");
            return;
        }

        try {
            // Parse the provided command-line argument to an integer
            int number = Integer.parseInt(args[0]);

            // Print the binary, octal, and hexadecimal equivalents
            System.out.println("Given Number: " + number);
            System.out.println("Binary equivalent: " + Integer.toBinaryString(number));
            System.out.println("Octal equivalent: " + Integer.toOctalString(number));
            System.out.println("Hexadecimal equivalent: " + Integer.toHexString(number).toUpperCase());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide a valid integer.");
        }
    }
}


