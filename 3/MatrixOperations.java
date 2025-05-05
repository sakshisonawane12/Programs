public class MatrixOperations {

    // Print matrix
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    // Transpose
    static int[][] transpose(int[][] matrix) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                result[j][i] = matrix[i][j];
        return result;
    }

    // Determinant
    static int determinant(int[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Inverse using adjoint and determinant
    static int[][] inverse(int[][] m) {
        int det = determinant(m);
        if (det == 0) {
            return null;
        }

        int[][] inv = new int[3][3];

        inv[0][0] =  (m[1][1] * m[2][2] - m[1][2] * m[2][1]);
        inv[0][1] = -(m[0][1] * m[2][2] - m[0][2] * m[2][1]);
        inv[0][2] =  (m[0][1] * m[1][2] - m[0][2] * m[1][1]);

        inv[1][0] = -(m[1][0] * m[2][2] - m[1][2] * m[2][0]);
        inv[1][1] =  (m[0][0] * m[2][2] - m[0][2] * m[2][0]);
        inv[1][2] = -(m[0][0] * m[1][2] - m[0][2] * m[1][0]);

        inv[2][0] =  (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
        inv[2][1] = -(m[0][0] * m[2][1] - m[0][1] * m[2][0]);
        inv[2][2] =  (m[0][0] * m[1][1] - m[0][1] * m[1][0]);

        // Divide each element by determinant
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inv[i][j] = inv[i][j] / det;

        return inv;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        System.out.println("\nTranspose:");
        printMatrix(transpose(matrix));

        int det = determinant(matrix);
        System.out.println("\nDeterminant: " + det);

        System.out.println("\nInverse:");
        int[][] inv = inverse(matrix);
        if (inv == null) {
            System.out.println("Inverse not possible (Determinant is 0)");
        } else {
            printMatrix(inv);
        }
    }
}
