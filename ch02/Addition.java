package ch02;

import java.util.Scanner;

/**
 * Fig. 2.7: Addition.java (iki tam sayıyı topla)
 *
 * Konu: Scanner ile input, değişken (variable), atama (=), ifade (expression).
 */
public class Addition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt: kullanıcıya ne yapacağını söyleyen çıktı.
        System.out.print("Enter first integer: ");
        int number1 = input.nextInt();

        System.out.print("Enter second integer: ");
        int number2 = input.nextInt();

        int sum = number1 + number2;

        // %d => int (decimal integer), %n => newline
        System.out.printf("Sum is %d%n", sum);
    }
}

