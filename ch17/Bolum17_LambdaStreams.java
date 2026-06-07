package ch17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * Bölüm 17 — Lambdas and Streams (Slayt 17)
 *
 * NE ÖĞRENECEKSİN?
 * - Functional interface: tek abstract metotlu interface (SAM)
 * - Lambda: (param) -> ifade  — kısa anonymous metot
 * - Stream pipeline: kaynak → ara işlemler → terminal işlem
 *
 * Stream pipeline örneği:
 *   IntStream.of(5,2,8,1)
 *       .filter(n -> n % 2 == 0)   // ara: çiftleri seç
 *       .sorted()                   // ara: sırala
 *       .forEach(n -> print(n));    // terminal: yazdır
 *
 * Sık terminal işlemler: forEach, reduce, count, sum
 * Sık ara işlemler: filter, map, sorted
 *
 * NOT: Stream kendisi depolamaz; bir kez tüketilir, tekrar kullanılamaz.
 *
 * Slayt: Slides/17.pdf  ·  Sonraki: ch20
 *
 * Çalıştırma: java -cp . ch17.Bolum17_LambdaStreams
 */
public class Bolum17_LambdaStreams {

    public static void main(String[] args) {
        intro();
        functionalInterface();
        lambdaSyntax();
        intStreamForEach();
        intStreamReduce();
        filterSort();
        mapOrnek();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 17: Lambdas and Streams (Slayt 17) ===");
        System.out.println("Lambda = kısa fonksiyon | Stream = veri boru hattı");
        System.out.println("filter → map → sorted → forEach / reduce\n");
    }

    private static void functionalInterface() {
        System.out.println("[17.1] Functional interface (SAM)");
        /*
         * SAM = Single Abstract Method — tam bir abstract metot.
         *
         *   interface IntConsumer {
         *       void accept(int value);   ← tek abstract metot
         *   }
         *
         * Lambda bu interface'i implement eder:
         *   IntConsumer yazdir = value -> System.out.print(value + " ");
         *   yazdir.accept(1);  // 1 yazar
         *
         * java.util.function paketinde hazır interface'ler:
         *   Predicate, Function, Consumer, Supplier, IntConsumer...
         */
        IntConsumer yazdir = value -> System.out.print(value + " ");
        System.out.print("  IntConsumer: ");
        yazdir.accept(1);
        yazdir.accept(2);
        yazdir.accept(3);
        System.out.println("\n");
    }

    private static void lambdaSyntax() {
        System.out.println("[17.2] Lambda sözdizimi");
        /*
         * İKİ FORM:
         *
         *   (parametreler) -> ifade
         *   (parametreler) -> { satır1; satır2; return x; }
         *
         * Parametre yoksa:
         *   () -> System.out.println("merhaba")
         *
         * Tek parametre, tip yazmadan:
         *   x -> x * 2
         *
         * Lambda nerede kullanılır?
         *   Functional interface beklenen yerde (forEach, filter, Comparator vb.)
         */
        Runnable merhaba = () -> System.out.println("  Lambda Runnable çalıştı.");
        merhaba.run();
        System.out.println();
    }

    private static void intStreamForEach() {
        System.out.println("[17.3] IntStream + forEach (terminal)");
        /*
         * IntStream.of(dizi) → int değerlerinden stream oluşturur
         * .forEach(lambda)    → her eleman için lambda çalışır (terminal)
         *
         * Klasik for yerine:
         *   for (int v : values) System.out.print(v);
         * Stream ile:
         *   IntStream.of(values).forEach(v -> System.out.print(v));
         *
         * Slayt Fig. 17.x: of + forEach zinciri
         */
        int[] values = { 3, 10, 6 };
        System.out.print("  forEach: ");
        IntStream.of(values).forEach(v -> System.out.printf("%d ", v));
        System.out.println("\n");
    }

    private static void intStreamReduce() {
        System.out.println("[17.4] reduce — toplama (terminal)");
        /*
         * .reduce(başlangıç, (x, y) -> x + y)
         *
         * Adım adım (values = {3, 10, 6}, identity = 0):
         *   x=0,  y=3  → 0+3  = 3
         *   x=3,  y=10 → 3+10 = 13
         *   x=13, y=6  → 13+6 = 19
         *
         * Sınav output: reduce adımlarını takip et.
         */
        int[] values = { 3, 10, 6 };
        int sum = IntStream.of(values).reduce(0, (x, y) -> x + y);
        System.out.println("  reduce toplam = " + sum);
        System.out.println();
    }

    private static void filterSort() {
        System.out.println("[17.5] filter + sorted + forEach (pipeline)");
        /*
         * Pipeline = zincirleme metot çağrıları:
         *
         *   kaynak
         *     .filter( koşul )     ← ara işlem: elemanları süzer
         *     .sorted()           ← ara işlem: sıralar
         *     .forEach( işlem )   ← terminal: tüketir, stream biter
         *
         * n -> n % 2 == 0  → "n çift mi?" Predicate lambda
         *
         * Çıktı: 2 6 8 (çiftler, küçükten büyüğe)
         */
        int[] values = { 5, 2, 8, 1, 6, 3 };
        System.out.print("  çift, sıralı: ");
        IntStream.of(values)
                .filter(n -> n % 2 == 0)
                .sorted()
                .forEach(n -> System.out.printf("%d ", n));
        System.out.println("\n");
    }

    private static void mapOrnek() {
        System.out.println("[17.6] map — dönüştürme (String stream)");
        /*
         * .map(x -> dönüşüm)  → her elemanı başka tipe/ değere çevirir
         *
         * String::toUpperCase  → method reference (lambda kısayolu)
         *   s -> s.toUpperCase() ile aynı
         *
         * Comparator.naturalOrder() → alfabetik sıralama
         */
        List<String> names = Arrays.asList("ali", "zeynep", "can");
        System.out.print("  büyük harf, sıralı: ");
        names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
    }

    private static void ozet() {
        System.out.println("=== Bölüm 17 özeti ===");
        System.out.println("functional interface | (x)->ifade | filter map sorted | forEach reduce");
    }
}
