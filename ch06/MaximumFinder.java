package ch06;

import java.util.Scanner;

/**
 * Çoklu parametre + geri dönüş değeri örneği:
 * Kullanıcıdan 3 double al, en büyüğünü bul.
 *
 * Konu: metot yazma, parametreler, return.
 */
public class MaximumFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter three floating-point values: ");
        double n1 = input.nextDouble();
        double n2 = input.nextDouble();
        double n3 = input.nextDouble();

        double result = maximum(n1, n2, n3);
        System.out.printf("Maximum is %.2f%n", result);
    }

    private static double maximum(double x, double y, double z) {
        double max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        return max;
    }
}

