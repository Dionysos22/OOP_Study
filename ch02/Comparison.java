package ch02;

import java.util.Scanner;

/**
 * Fig. 2.15: Comparison.java (eşitlik/ilişkisel operatörlerle karar verme)
 *
 * Konu: if, koşul (condition), == != < <= > >=
 */
public class Comparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int number1 = input.nextInt();

        System.out.print("Enter second integer: ");
        int number2 = input.nextInt();

        // İlişkisel operatörlerin her biri boolean üretir (true/false).
        if (number1 == number2) {
            System.out.printf("%d == %d%n", number1, number2);
        }
        if (number1 != number2) {
            System.out.printf("%d != %d%n", number1, number2);
        }
        if (number1 < number2) {
            System.out.printf("%d < %d%n", number1, number2);
        }
        if (number1 > number2) {
            System.out.printf("%d > %d%n", number1, number2);
        }
        if (number1 <= number2) {
            System.out.printf("%d <= %d%n", number1, number2);
        }
        if (number1 >= number2) {
            System.out.printf("%d >= %d%n", number1, number2);
        }
    }
}

