public class NumberTriangle {
    public static void main(String[] args) {
        int n = 6;  // Number of rows

        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = n - i; j > 0; j--)
                System.out.print(" ");

            for (int j = 1; j <= i; j++)
                System.out.print(i + " ");

            System.out.println();
        }
    }
}
