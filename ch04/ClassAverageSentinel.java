package ch04;

import java.util.Scanner;

/**
 * Sentinel-controlled iteration örneği (gözcü kontrollü).
 *
 * Problem:
 * - kaç not girileceği belli değil
 * - kullanıcı -1 girince bitir
 *
 * Önemli nokta:
 * - "sentinel" değeri (burada -1) gerçek verilerle karışmamalı
 * - Döngü bittiğinde gradeCounter=0 olabilir; bu durumda ortalama hesaplanmaz (0'a bölme hatası önlenir)
 */
public class ClassAverageSentinel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int gradeCounter = 0;

        System.out.print("Enter grade or -1 to quit: ");
        int grade = input.nextInt();

        while (grade != -1) {
            total += grade;
            gradeCounter++;

            System.out.print("Enter grade or -1 to quit: ");
            grade = input.nextInt();
        }

        if (gradeCounter != 0) {
            double average = (double) total / gradeCounter;
            System.out.printf("Total = %d, Count = %d, Average = %.2f%n", total, gradeCounter, average);
        } else {
            System.out.println("No grades were entered.");
        }
    }
}

