public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 6;  // You can change this value for more rows

        for (int i = 0; i < n; i++) {
            // Print spaces for formatting
            for (int k = 0; k < n - i; k++)
                System.out.print(" ");

            int num = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
