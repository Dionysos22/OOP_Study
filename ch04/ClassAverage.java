package ch04;

import java.util.Scanner;

/**
 * Sınıf ortalaması (counter-controlled iteration) örneği.
 *
 * Fikir:
 * - kaç tane not gireceğimiz belli (ör: 3 tane)
 * - sayaç ile döngü kurulur
 *
 * Buradaki tipik adımlar:
 * - total (toplam) biriktir
 * - gradeCounter ile kaç tane not okunduğunu takip et
 * - en sonda average = total / numberOfGrades
 */
public class ClassAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int gradeCounter = 1;
        final int numberOfGrades = 3;

        while (gradeCounter <= numberOfGrades) {
            System.out.print("Enter grade: ");
            int grade = input.nextInt();
            total += grade;
            gradeCounter++;
        }

        double average = (double) total / numberOfGrades;
        System.out.printf("Total = %d, Average = %.2f%n", total, average);
    }
}

