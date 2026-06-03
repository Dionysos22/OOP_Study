import java.util.Scanner;

/**
 * Bölüm 2: Introduction to Java Applications; Input/Output and Operators
 *
 * Bu dosya "tek tek küçük örnekler" şeklinde ilerler.
 * Her örnek bir metotta durur, main içinden çağrılır.
 */
public class Bolum2_Temeller {
    public static void main(String[] args) {
        intro();
        ilkProgram_Println();
        ilkProgramiDuzenleme();
        printfIleMetin();
        tamSayiToplama();
        bellekKavramlari();
        aritmetik();
        esitlikVeIliskiselOperatorler();
        ozet();
    }

    // 2.1 Introduction (Giriş)
    private static void intro() {
        /*
         * Java ile uygulama yazarken temel akış:
         * - Kaynak kod: .java dosyası
         * - Derleme: javac ile bytecode (.class) oluşur
         * - Çalıştırma: java ile JVM üzerinde çalışır
         *
         * Bu "derle-çalıştır" mantığını oturtmak, sonraki tüm konuların temelidir.
         */
        System.out.println("=== Bolum 2 ===");
    }

    // 2.2 Your First Program in Java: Printing a Line of Text
    private static void ilkProgram_Println() {
        /*
         * System.out: standart çıktı akışı (konsol)
         * println: metni yazdırır ve satır sonuna geçer
         */
        System.out.println("[2.2] Merhaba Java!");
    }

    // 2.3 Modifying Your First Java Program
    private static void ilkProgramiDuzenleme() {
        /*
         * Programı "düzenlemek" genelde:
         * - yeni satırlar eklemek
         * - çıktı mesajlarını değiştirmek
         * - basit değişkenler kullanmak
         *
         * Burada basit bir değişkenle mesajı birleştiriyoruz.
         */
        String ders = "OOP";
        System.out.println("[2.3] Ders: " + ders);
    }

    // 2.4 Displaying Text with printf
    private static void printfIleMetin() {
        /*
         * printf biçimli çıktı verir:
         * - %s: String
         * - %d: int
         * - %f: floating point
         * - %.2f: 2 ondalık basamak
         * - %n: platform bağımsız yeni satır
         */
        double ort = 87.456;
        System.out.printf("[2.4] Ortalama: %.2f%n", ort);
    }

    // 2.5 Another Application: Adding Integers
    private static void tamSayiToplama() {
        /*
         * Girdi almak için çoğunlukla Scanner kullanılır.
         * Not: Scanner, kullanıcıdan veri bekler. Bu örnekte "girdi yoksa" takılmamak için
         * küçük bir kontrol yapıyoruz: hasNextInt().
         */
        System.out.print("[2.5] Iki tam sayi gir (ornegin: 3 5): ");
        Scanner sc = new Scanner(System.in);

        // hasNextInt(): Bir SONRAKİ token'ın (boşlukla ayrılmış parça) int olup olmadığını kontrol eder.
        // Bu kontrolü yapmadan nextInt() çağırırsak ve kullanıcı "x" gibi bir şey girerse program hata fırlatır.
        if (sc.hasNextInt()) {
            // İlk sayı gerçekten int ise güvenle okuyabiliriz.
            int a = sc.nextInt();

            // Aynı kontrolü ikinci sayı için tekrar yapıyoruz.
            // Çünkü kullanıcı tek sayı girmiş olabilir ya da ikinci token int olmayabilir.
            if (sc.hasNextInt()) {
                // İkinci sayı da int ise okuyup topluyoruz.
                int b = sc.nextInt();
                int toplam = a + b;
                System.out.println("Toplam = " + toplam);
            } else {
                // Buraya düşmek: İlk sayı okundu ama ikinci int yok (ya hiç yok ya da int değil).
                System.out.println("Ikinci sayi yok, ornek atlandi.");
            }
        } else {
            // Buraya düşmek: Daha ilk token int değilse hiç okumaya çalışmadan örneği pas geçiyoruz.
            System.out.println("Girdi bulunamadi, ornek atlandi.");
        }
        // sc.close();
        // Not: sc System.in'i de kapatır. Aynı JVM içinde ileride tekrar input okunacaksa sorun çıkarabilir.
        // Bu dosyada birden fazla örnek/metot aynı çalıştırmada çağrılabildiği için burada özellikle kapatmıyoruz.
    }

    // 2.6 Memory Concepts
    private static void bellekKavramlari() {
        /*
         * Bellek fikrini basitleştirelim:
         * - Değişken: bellekte bir "kutucuk" gibi düşün
         * - Atama (=): kutucuğa değer koymak
         * - Bir değişkeni kullanmak: kutudaki değeri okumak
         *
         * Java'da primitive tipler (int, double, boolean...) değeri direkt tutar.
         * Referans tipler (String, Scanner, sınıflar...) ise nesnenin adresini tutar (referans).
         */
        int x = 10;      // primitive: değer direkt tutulur
        String y = "10"; // referans: String nesnesine referans
        System.out.println("[2.6] x=" + x + ", y=" + y);
    }

    // 2.7 Arithmetic (Aritmetik)
    private static void aritmetik() {
        /*
         * Temel aritmetik operatörler:
         * +, -, *, /, %
         *
         * Dikkat: int / int => int (kesir atılır)
         *       double ile yaparsan kesir korunur.
         */
        int a = 7, b = 3;
        System.out.println("[2.7] 7/3 (int) = " + (a / b));
        System.out.println("[2.7] 7/3 (double) = " + (a / (double) b));
        System.out.println("[2.7] 7%3 = " + (a % b));
    }

    // 2.8 Decision Making: Equality and Relational Operators
    private static void esitlikVeIliskiselOperatorler() {
        /*
         * Karşılaştırma operatörleri boolean (true/false) üretir:
         * ==, !=, <, <=, >, >=
         *
         * Önemli not:
         * - primitive tiplerde == değeri karşılaştırır
         * - String gibi nesnelerde == referansı karşılaştırır (aynı nesne mi?)
         *   Metin içerik karşılaştırması için equals() kullanılır.
         */
        int n1 = 5, n2 = 7;
        System.out.println("[2.8] 5 < 7 ? " + (n1 < n2));

        String s1 = new String("java");
        String s2 = new String("java");
        System.out.println("[2.8] s1==s2 ? " + (s1 == s2));           // genelde false
        System.out.println("[2.8] s1.equals(s2) ? " + s1.equals(s2)); // true
    }

    // 2.9 Wrap-Up (Özet)
    private static void ozet() {
        /*
         * Bu bölümde:
         * - Konsola yazdırma (println, printf)
         * - Scanner ile giriş
         * - Aritmetik ve karşılaştırma operatörleri
         * - Primitive vs referans fikrine giriş
         *
         * Sonraki bölümlerde bunların üstüne sınıflar ve kontrol yapıları ekleniyor.
         */
        System.out.println("=== Bolum 2 bitti ===");
        System.out.println();
    }
}

