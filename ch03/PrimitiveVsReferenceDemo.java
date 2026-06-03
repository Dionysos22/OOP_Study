package ch03;

/**
 * 3.5 Primitive Types vs. Reference Types
 *
 * Konu: primitive değer kopyası, referans adres kopyası.
 *
 * Bu dosyada 3 ayrı karşılaştırma var:
 * - `int` gibi primitive tiplerde atama: değer kopyalanır (a değişmez, b değişir).
 * - `Account` gibi nesnelerde atama: referans kopyalanır (x ve y aynı nesneyi gösterir).
 * - `String` karşılaştırması: `==` referans, `equals()` içerik karşılaştırır.
 */
public class PrimitiveVsReferenceDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = a; // değer kopyalanır
        b++;
        System.out.printf("primitive: a=%d, b=%d%n", a, b);

        Account x = new Account("X", 10.0);
        Account y = x; // referans kopyalanır (aynı nesne)
        y.deposit(5.0);
        System.out.printf("reference: x.balance=%.2f, y.balance=%.2f%n", x.getBalance(), y.getBalance());

        String s1 = new String("java");
        String s2 = new String("java");
        // == referans kıyaslar, equals içerik kıyaslar
        System.out.println("s1==s2 ? " + (s1 == s2));
        System.out.println("s1.equals(s2) ? " + s1.equals(s2));
    }
}

