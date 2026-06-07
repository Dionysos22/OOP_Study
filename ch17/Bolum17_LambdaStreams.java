package ch17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * Bölüm 17 — Lambdas and Streams (Slides/17.pdf)
 *
 * Slayt 17: functional interface, lambda, stream pipeline.
 *
 * Kitap referans: Deitel Ch.17 (slayt yeterli değilse)
 *
 * Çalıştırma:
 *   java -cp . ch17.Bolum17_LambdaStreams
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
        System.out.println("=== Bölüm 17: Lambdas and Streams (Slayt 17) ===\n");
    }

    private static void functionalInterface() {
        System.out.println("[17.1] Functional interface (SAM)");
        /*
         * Tek abstract metotlu interface → lambda atanabilir.
         * Slayt: IntConsumer, Predicate, Function, Supplier...
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
         * (parametreler) -> ifade   veya   (parametreler) -> { blok }
         * Anonymous method kısayolu; functional interface beklenen yerde kullanılır.
         */
        Runnable merhaba = () -> System.out.println("  Lambda Runnable çalıştı.");
        merhaba.run();
        System.out.println();
    }

    private static void intStreamForEach() {
        System.out.println("[17.3] IntStream.of + forEach (Slayt Fig. 17.x)");
        int[] values = { 3, 10, 6 };
        System.out.print("  forEach: ");
        IntStream.of(values).forEach(v -> System.out.printf("%d ", v));
        System.out.println("\n");
    }

    private static void intStreamReduce() {
        System.out.println("[17.4] reduce — toplam");
        /*
         * reduce(identity, (x, y) -> x + y)
         * identity=0, stream 3+10+6 → 19 (slayt adım adım anlatım)
         */
        int[] values = { 3, 10, 6 };
        int sum = IntStream.of(values).reduce(0, (x, y) -> x + y);
        System.out.println("  reduce toplam = " + sum);
        System.out.println();
    }

    private static void filterSort() {
        System.out.println("[17.5] filter + sorted + forEach");
        int[] values = { 5, 2, 8, 1, 6, 3 };
        System.out.print("  çift, sıralı: ");
        IntStream.of(values)
                .filter(n -> n % 2 == 0)
                .sorted()
                .forEach(n -> System.out.printf("%d ", n));
        System.out.println("\n");
    }

    private static void mapOrnek() {
        System.out.println("[17.6] map — dönüştürme");
        List<String> names = Arrays.asList("ali", "zeynep", "can");
        names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
    }

    private static void ozet() {
        System.out.println("=== Bölüm 17 özeti ===");
        System.out.println("functional interface | lambda | stream pipeline | filter map sorted reduce");
    }
}
