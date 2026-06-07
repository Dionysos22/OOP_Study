package ch07;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Bölüm 7 — Arrays and ArrayLists (Slayt 7)
 *
 * NE ÖĞRENECEKSİN?
 * - Dizi (array): sabit boyutlu, aynı tipte elemanlar
 * - ArrayList: boyutu büyüyebilen liste (ch16'da detay)
 * - İndeks, length, for / for-each döngüsü
 * - Dizi referans olarak metoda gider → metot içi değişiklik dışarıyı etkiler
 *
 * DİZİ vs ArrayList (kısa):
 *   Dizi        → int[] scores; boyut sabit, ilkel tip doğrudan
 *   ArrayList   → ArrayList<Integer>; add/remove, nesne tutar (autoboxing)
 *
 * Slayt: Slides/7.pdf  ·  Sonraki: ch08
 *
 * Çalıştırma: java -cp . ch07.Bolum7_Diziler
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
        System.out.println("=== Bölüm 7: Diziler ve ArrayList (Slayt 7) ===");
        System.out.println("Dizi = aynı tipten elemanlar, indeks 0'dan başlar.");
        System.out.println("Sınavda: length, indeks hatası, ortalama, ArrayList add/get/size\n");
    }

    private static void tekBoyutluDizi() {
        System.out.println("[7.1–7.4] Tek boyutlu dizi");
        /*
         * İKİ YOLLA DİZİ OLUŞTURMA:
         *
         *   int[] a = new int[5];     → 5 eleman, hepsi varsayılan 0
         *   int[] b = { 90, 85, 70 }; → başlangıç değerleriyle
         *
         * ÖNEMLİ KURALLAR:
         *   length     → eleman SAYISI (son geçerli indeks = length - 1)
         *   scores[5]  → 5 elemanlı dizide HATA (0..4 geçerli) → ArrayIndexOutOfBoundsException
         *
         * Sınav output: döngüyle toplam / ortalama hesabı sık çıkar.
         */
        int[] scores = { 90, 85, 70, 88, 92 };
        System.out.println("  scores.length = " + scores.length);       // 5
        System.out.println("  scores[0] = " + scores[0]);               // ilk eleman
        System.out.println("  scores[4] = " + scores[4]);               // son eleman

        int sum = 0;
        for (int i = 0; i < scores.length; i++) { // i < length (<= length-1)
            sum += scores[i];
        }
        // Ortalamada (double) cast unutma — yoksa tam bölme olur
        double avg = (double) sum / scores.length;
        System.out.printf("  Ortalama = %.2f%n", avg);
        System.out.println();
    }

    private static void diziArguman() {
        System.out.println("[7.5] Dizi metot parametresi — REFERANS");
        /*
         * Java'da dizi bir REFERANStır (ch03'teki gibi).
         * Metoda int[] arr geçince, metot AYNI dizinin kendisine dokunur.
         * doubleAverage içinde arr[i] değişince main'deki data da değişir.
         *
         * Sınav tuzağı: "metot kopya alır mı?" → Hayır, referans kopyalanır.
         */
        int[] data = { 1, 2, 3 };
        System.out.println("  Önce:  " + Arrays.toString(data));
        doubleAverage(data);
        System.out.println("  Sonra: " + Arrays.toString(data)); // değişmiş!
        System.out.println();
    }

    /** Her elemana dizinin ortalamasını ekler — orijinal dizi değişir. */
    private static void doubleAverage(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int sum = 0;
        for (int v : arr) {
            sum += v;
        }
        int avg = sum / arr.length; // tam bölme (kasıtlı basit örnek)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + avg;
        }
    }

    private static void cokBoyutluNot() {
        System.out.println("[7.6] Çok boyutlu dizi (kısa not)");
        /*
         * int[][] m = new int[3][4];  → 3 satır, her satır 4 sütun
         * m.length        → satır sayısı
         * m[i].length     → i. satırın sütun sayısı (jagged array olabilir)
         */
        int[][] matrix = {
                { 1, 2 },
                { 3, 4, 5 }   // ikinci satır 3 eleman — düzensiz tablo
        };
        System.out.println("  matrix.length (satır) = " + matrix.length);
        System.out.println("  matrix[1].length (2. satır sütun) = " + matrix[1].length);
        System.out.println();
    }

    private static void enhancedFor() {
        System.out.println("[7.7] Enhanced for — for-each");
        /*
         *   for (String name : names) { ... }
         *
         * Ne zaman kullan?
         *   ✓ Tüm elemanları okumak / gezmek
         *   ✗ İndeks lazımsa (names[i]) → klasik for kullan
         *   ✗ Diziyi değiştirirken indeks gerekir → klasik for
         */
        String[] names = { "Ada", "Bora", "Cem" };
        System.out.print("  İsimler: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println("\n");
    }

    private static void arrayListOrnek() {
        System.out.println("[7.8–7.10] ArrayList — dinamik liste");
        /*
         * ArrayList<E> = Generic koleksiyon (E = eleman tipi).
         *
         * Sık metotlar:
         *   add(x)    → sona ekler
         *   get(i)    → i. elemanı döner
         *   size()    → eleman sayısı (dizideki length gibi)
         *   remove(i) → i. elemanı siler
         *
         * int dizisi yerine ArrayList<Integer> kullanınca:
         *   turns.add(1)  → int otomatik Integer'a sarılır (autoboxing)
         *
         * ch16'da List, Set, Map ayrıntısı var.
         */
        ArrayList<Integer> turns = new ArrayList<>();
        turns.add(1);
        turns.add(2);
        turns.add(3);
        System.out.println("  turns.size() = " + turns.size());   // 3
        System.out.println("  turns.get(1) = " + turns.get(1));   // 2 (indeks 1)
        System.out.println();
    }

    private static void arraysYardimcilari() {
        System.out.println("[7.11] java.util.Arrays yardımcı sınıfı");
        /*
         * Arrays.sort(arr)         → diziyi sıralar (yerinde değiştirir!)
         * Arrays.toString(arr)     → "[1, 2, 3]" metni
         * Arrays.binarySearch(arr, key) → SIRALI dizide arama; indeks veya negatif
         *
         * binarySearch önce sort gerekir — aksi halde sonuç anlamsız.
         */
        int[] copy = { 5, 1, 9, 3 };
        Arrays.sort(copy);
        System.out.println("  sort sonrası: " + Arrays.toString(copy));
        System.out.println("  binarySearch(9) indeks: " + Arrays.binarySearch(copy, 9));
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 7 özeti ===");
        System.out.println("length | indeks 0..length-1 | for / for-each");
        System.out.println("dizi referans parametre | ArrayList add/get/size | Arrays.sort");
    }
}
