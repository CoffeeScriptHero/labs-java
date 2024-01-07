package lab2;


public class Main {

    public static void main(String[] args) {
        int C5 = 1309 % 5; // 4  C=AxB
        int C7 = 1309 % 7; // 0  double
        int C11 = 1309 % 11; // 0 Обчислити суму найменших елементів кожного стовпця матриці

        double[][] matrix1 = {
            {2, 5, 3,},
            {1, 15, 529},
            {0, 2351, -511}
        };

        double[][] matrix2 = {
            {64, 34},
            {213, -5},
            {-35, 69}
        };

        System.out.println("Sum of min elements in columns of matrix1: " + sumOfMinElementsInColumns(matrix1));
        System.out.println("Result of Matrix1 * Matrix2: ");
        printMatrix(multiplyMatrices(matrix1, matrix2));
    }

    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        if ((matrix1 == null || matrix2 == null) || matrix1[0].length != matrix2.length) {
            throw new ArithmeticException("Impossible to multiply matrices");
        }

        double[][] result = new double[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; ++i) {
            for (int j = 0; j < matrix2[0].length; ++j) {
                for (int k = 0; k < matrix1[0].length; ++k) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static double sumOfMinElementsInColumns(double[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Invalid matrix");
        }

        double sum = 0;

        for (int col = 0; col < matrix[0].length; ++col) {
            double min = matrix[0][col];
            for (int row = 1; row < matrix.length; ++row) {
                if (matrix[row][col] < min) {
                    min = matrix[row][col];
                }
            }
            sum += min;
        }

        return sum;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.2f  ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
