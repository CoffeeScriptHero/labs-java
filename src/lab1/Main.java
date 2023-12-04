package lab1;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int C2 = 1309 % 2; // 1  O1 = -
        int C3 = 1309 % 3; // 1
        int C5 = 1309 % 5; // 4  O2 = -
        int C7 = 1309 % 7; // 0  byte
        final int C = C3;

        int n = requestNumber("n"), m = requestNumber("m");
        int a = requestNumber("a"), b = requestNumber("b");

        if (a > n || b > m) {
            throw new ArithmeticException("Incorrect lower limit value");
        }

        if (a <= C && n >= C) {
            throw new ArithmeticException("Division by zero");
        }

        float sum = 0;

        for (byte i = (byte) a; i <= n; ++i) {
            for (byte j = (byte) b; j <= m; ++j) {
                sum += (float) (i - j) / (i - C);
            }
        }

        System.out.println("Sum : " + sum);
    }

    public static int requestNumber(String varName) {
        while (true) {
            System.out.printf("Enter value for %s variable: ", varName);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("This is not a number! Try again.");
            }
        }
    }
}
