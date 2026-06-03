package ch07;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Bölüm 7: Arrays and ArrayLists
 *
 * Finalde sık: dizi bildirimi, indeks, length, enhanced for, dizi argümanı,
 * ArrayList (dinamik boyut), Arrays yardımcı sınıfı.
 *
 * Çalıştırma (OOP_Final_Study kökünden):
 *   javac ch07/Bolum7_Diziler.java
 *   java -cp . ch07.Bolum7_Diziler
 */
public class Bolum7_Diziler {

    public static void main(String[] args) {
        intro();
        tekBoyutluDizi();
        diziArguman();
        cokBoyutluNot();
        enhancedFor();
        arrayListOrnek();
        arraysYardimcilari();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 7: Diziler ve ArrayList ===\n");
    }

    private static void tekBoyutluDizi() {
        System.out.println("[7.1–7.4] Tek boyutlu dizi");
        /*
         * int[] scores = new int[5];  → 5 eleman, varsayılan 0
         * int[] scores = { 90, 85, 70 };  → başlangıç değerleri
         *
         * length: eleman sayısı (son indeks = length - 1)
         * İndeks dışı erişim → ArrayIndexOutOfBoundsException
         */
        int[] scores = { 90, 85, 70, 88, 92 };
        System.out.println("  scores.length = " + scores.length);
        System.out.println("  scores[0] = " + scores[0] + ", scores[4] = " + scores[4]);

        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        double avg = (double) sum / scores.length;
        System.out.printf("  Ortalama = %.2f%n", avg);
        System.out.println();
    }

    /** Dizi referansı metoda geçince, metot içindeki değişiklik çağırandaki diziyi de etkiler. */
    private static void diziArguman() {
        System.out.println("[7.5] Dizi metot parametresi (referans)");
        int[] data = { 1, 2, 3 };
        doubleAverage(data);
        System.out.println("  doubleAverage sonrası: " + Arrays.toString(data));
        System.out.println();
    }

    private static void doubleAverage(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int sum = 0;
        for (int v : arr) {
            sum += v;
        }
        int avg = sum / arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + avg; // orijinal diziyi değiştirir
        }
    }

    private static void cokBoyutluNot() {
        System.out.println("[7.6] Çok boyutlu dizi (kısa not)");
        /*
         * int[][] matrix = new int[3][4];
         * Satır sayısı matrix.length; bir satırın uzunluğu matrix[i].length
         */
        int[][] matrix = {
                { 1, 2 },
                { 3, 4, 5 }
        };
        System.out.println("  matrix.length (satır) = " + matrix.length);
        System.out.println("  matrix[1].length = " + matrix[1].length);
        System.out.println();
    }

    private static void enhancedFor() {
        System.out.println("[7.7] Enhanced for (for-each)");
        /*
         * for (int score : scores)  → indeks yok, sadece okuma için pratik
         * Diziyi değiştirmek için klasik for veya indeks gerekir.
         */
        String[] names = { "Ada", "Bora", "Cem" };
        System.out.print("  İsimler: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println("\n");
    }

    private static void arrayListOrnek() {
        System.out.println("[7.8–7.10] ArrayList");
        /*
         * ArrayList<E>: boyutu çalışma anında büyüyebilir (generic koleksiyon).
         * add, get, size, remove — DuelRPG tur listesi gibi kullanılır.
         *
         * Dizi: sabit boyut, ilkel veya referans tipi doğrudan.
         * ArrayList: nesne tutar; int için ArrayList<Integer> (autoboxing).
         */
        ArrayList<Integer> turns = new ArrayList<>();
        turns.add(1);
        turns.add(2);
        turns.add(3);
        System.out.println("  turns.size() = " + turns.size());
        System.out.println("  turns.get(1) = " + turns.get(1));
        System.out.println();
    }

    private static void arraysYardimcilari() {
        System.out.println("[7.11] java.util.Arrays");
        int[] copy = { 5, 1, 9, 3 };
        Arrays.sort(copy);
        System.out.println("  sort sonrası: " + Arrays.toString(copy));
        System.out.println("  binarySearch(9) indeks: " + Arrays.binarySearch(copy, 9));
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 7 özeti ===");
        System.out.println("length | indeks | for / for-each | referans parametre | ArrayList | Arrays.sort");
    }
}
