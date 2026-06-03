package ch06;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Bölüm 6: Methods: A Deeper Look
 *
 * Bu dosyanın amacı: metotları sadece "syntax" olarak değil, sınavda sorulabilecek
 * kavramlarla birlikte görmek (static, imza, yığın/özyineleme, yükseltme/dönüşüm,
 * paketler, SecureRandom, enum, kapsam, overload).
 *
 * Çalıştırma (proje kökü OOP_Midterm_Study iken — classpath kök dizindir):
 *   javac ch06/Bolum6_Metotlar.java
 *   java -cp . ch06.Bolum6_Metotlar
 */
public class Bolum6_Metotlar {
    // 6.3 static fields: tüm program boyunca paylaşılan, sınıfa ait sayaç
    private static int callCount = 0;

    public static void main(String[] args) {
        intro();
        programBirimi();
        staticMethodsFieldsMath();
        cokluParametre();
        metotNotlari();
        callStackVeRecursion();
        argumentPromotionCasting();
        apiPackagesNotu();
        secureRandomCaseStudy();
        enumSansOyunu();
        scope();
        methodOverloading();
        optionalGuiNotu();
        ozet();
    }

    // 6.1 Introduction
    private static void intro() {
        System.out.println("=== Bölüm 6: Metotlara daha derin bakış ===");
        System.out.println();
        System.out.println("Bu çıktıda göreceklerin özet fikir:");
        System.out.println("  • Metot = isimlendirilmiş, tekrar kullanılabilir kod bloğu.");
        System.out.println("  • static = nesne üretmeden, sınıf adıyla çağrılabilen üye.");
        System.out.println("  • Çağrı yığıını (call stack) = metotların üst üste çalışma sırası; recursion bunu kullanır.");
        System.out.println("  • Argument promotion = küçük tiplerin (ör. int) büyük tipe (ör. double) güvenli genişlemesi.");
        System.out.println("  • Overload = aynı isim, farklı parametre listesi; derleyici hangi metodu seçeceğine bakarak karar verir.");
        System.out.println();
    }

    // 6.2 Program Units in Java
    private static void programBirimi() {
        System.out.println("[6.2] Program birimleri (parça parça düşün)");
        /*
         * Sınıf (class): alanlar (fields) + metotlar (methods) bir arada.
         * main: JVM'in aradığı giriş noktası — public static void main(String[] args)
         * Metot: tek bir işi iyi tanımlayan blok; başka yerlerden çağrılır.
         */
        System.out.println("  Sınıf: veri (field) + davranış (method) paketler.");
        System.out.println("  main: programın başlangıç metodu; JVM buradan çalıştırır.");
        System.out.println();
    }

    // 6.3 static Methods, static Fields and Class Math
    private static void staticMethodsFieldsMath() {
        System.out.println("[6.3] static metot / static alan ve Math");
        /*
         * static üye:
         *   - Nesneye bağlı değildir; sınıfa aittir.
         *   - Örnek: Math.sqrt — new Math() demeden Math.sqrt(x) çağırırsın.
         * instance (örnek) üye:
         *   - Her nesnenin kendi kopyası olabilir (ör. her hesabın ayrı bakiyesi).
         *
         * callCount burada static: kaç kez bu bölümün mantığına girdiğimizi göstermek için.
         */
        callCount++;
        double x = 16.0;
        System.out.println("  Math.sqrt(" + x + ") = " + Math.sqrt(x) + "  (Math sınıfının static metodu)");
        System.out.println("  callCount (static int) = " + callCount + "  (tüm çağrılar bu sayacı paylaşır)");
        System.out.println();
    }

    // 6.4 Methods with Multiple Parameters
    private static void cokluParametre() {
        System.out.println("[6.4] Birden fazla parametre");
        /*
         * Parametre sırası önemlidir: clamp(value, min, max).
         * Java'da ilkel tipler (int, double, ...) metoda değer olarak geçer (pass by value):
         * metot içinde kopyayı değiştirmek, çağırandaki değişkeni değiştirmez.
         */
        System.out.println("  clamp: değeri [min, max] aralığına sıkıştırır.");
        int result = clamp(15, 0, 10);
        System.out.println("  clamp(15, 0, 10) = " + result + "  (15 üst sınırı aştığı için 10)");
        System.out.println();
    }

    /** value'yu [min, max] kapalı aralığına alır. */
    private static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    // 6.5 Notes on Declaring and Using Methods
    private static void metotNotlari() {
        System.out.println("[6.5] Metot bildirimi ve kullanımı");
        /*
         * İmza (signature): metot adı + parametre tipleri (sıra ile).
         *   Dönüş tipi imzaya dahil değildir; overload çözümünde parametre listesi önemlidir.
         * Erişim: private/public — nereden çağrılabileceğini sınırlar.
         * static: nesne yokken Bolum6_Metotlar.metotAdi gibi düşünülebilir (aynı sınıf içinde sadece ad yeter).
         */
        System.out.println("  İmza örneği: int clamp(int value, int min, int max)");
        System.out.println("  İyi pratik: kısa metotlar, anlamlı isimler, tek sorumluluk (ne yapıyorsa onu).");
        System.out.println();
    }

    // 6.6 Method-Call Stack and Activation Records
    private static void callStackVeRecursion() {
        System.out.println("[6.6] Call stack (çağrı yığıını) ve recursion");
        /*
         * Her metot çağrısında JVM, o çağrı için yerel değişkenler ve dönüş adresi ile bir
         * "activation record" (etkinlik kaydı) yığınına ekler. Metot bitince kayıt çıkar.
         *
         * Recursion: metot kendi kendini çağırır. Mutlaka durma (base case) olmalı;
         * yoksa sonsuz çağrı → StackOverflowError riski.
         *
         * factorial(n): n! = n * (n-1)! , 0! = 1! = 1
         */
        int n = 5;
        long fact = factorial(n);
        System.out.println("  factorial(" + n + ") = " + fact);
        System.out.println("  Genişletme: 5! = 5 × 4 × 3 × 2 × 1 = " + fact);
        System.out.println("  Yığın fikri: factorial(5) önce factorial(4)'ü çağırır ... ta ki factorial(1) 1 döner;");
        System.out.println("  çarpımlar geri dönüş yolunda (return chain) tamamlanır.");
        System.out.println();
    }

    private static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n negatif olamaz");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 6.7 Argument Promotion and Casting
    private static void argumentPromotionCasting() {
        System.out.println("[6.7] Argument promotion ve casting");
        /*
         * Promotion (widening): bilgi kaybı olmadan otomatik genişletme.
         *   byte → short → int → long → float → double
         *   char → int'a da yükseltilebilir (sayısal bağlamda).
         * Daraltma (narrowing): (int) double gibi — bilgi kaybı olabilir; açık cast gerekir.
         */
        int a = 3;
        double b = 2.5;
        double sum = a + b; // a burada double'a promotion ile katılır
        System.out.println("  int a=3, double b=2.5 → a + b = " + sum + " (sonuç double; int önce double oldu)");
        double d = 3.9;
        int i = (int) d;
        System.out.println("  (int) 3.9 = " + i + "  (kesir kısmı atılır; daraltma cast)");
        System.out.println();
    }

    // 6.8 Java API Packages
    private static void apiPackagesNotu() {
        System.out.println("[6.8] Java API ve paketler");
        /*
         * Paket: ilgili sınıfları isim alanında gruplar (çakışmayı azaltır).
         * java.lang — String, System, Math, Integer ... (import gerekmez)
         * java.util — Scanner, Arrays, List ...
         * java.time — LocalDate, LocalDateTime ...
         */
        System.out.println("  Örnek: java.lang otomatik görülür; diğer paketler için import satırı yazarsın.");
        System.out.println("  Tam nitelikli ad: java.util.Arrays gibi (import yoksa da kullanılabilir).");
        System.out.println();
    }

    // 6.9 Case Study: Secure Random-Number Generation
    private static void secureRandomCaseStudy() {
        System.out.println("[6.9] SecureRandom ile zar örneği");
        /*
         * java.util.Random: genel amaçlı; oyun / basit simülasyon için yeterli olabilir.
         * SecureRandom: kriptografik olarak daha güçlü rastgelelik (tahmin zorluğu);
         *   güvenlik gerektiren yerlerde tercih edilir.
         *
         * nextInt(6) → 0..5 arası; zar için 1..6: 1 + rng.nextInt(6)
         */
        SecureRandom rng = new SecureRandom();
        int[] freq = new int[7]; // indeks 1..6 kullanılır; 0 boş
        int rolls = 20;
        for (int k = 0; k < rolls; k++) {
            int die = 1 + rng.nextInt(6);
            freq[die]++;
        }
        System.out.println("  " + rolls + " atışta yüz frekansları [0,1,2,3,4,5,6] = " + Arrays.toString(freq));
        System.out.println("  (0 indeksi kullanılmıyor; 1–6 zar yüzleri.)");
        System.out.println();
    }

    // 6.10 A Game of Chance; Introducing enum Types
    private static void enumSansOyunu() {
        System.out.println("[6.10] enum ile tip-güvenli sabitler");
        /*
         * enum: sınırlı sayıda sabit değer (YAZI/TURA gibi). String yerine enum kullanmak
         * yazım hatalarını azaltır, switch-case ile temiz eşleşme sağlar.
         */
        SecureRandom rng = new SecureRandom();
        Coin result = rng.nextBoolean() ? Coin.YAZI : Coin.TURA;
        System.out.println("  Yazı-tura sonucu: " + result + "  (name=" + result.name() + ")");
        System.out.println();
    }

    private enum Coin {
        YAZI,
        TURA
    }

    // 6.11 Scope of Declarations
    private static void scope() {
        System.out.println("[6.11] Kapsam (scope)");
        /*
         * Yerel değişken: bildirildiği blok süresince geçerli (metot, if, for içi).
         * Dış bloktan iç blok görünür; içte tanımlı olan dışarı çıkmaz.
         * Aynı isimle içeride yeniden tanımlama (shadowing) mümkündür — karışıklık yaratmamaya dikkat.
         */
        int x = 10;
        if (x > 5) {
            int y = 3;
            System.out.println("  if bloğu içinde: x=" + x + ", y=" + y + " (y sadece bu blokta var)");
        }
        System.out.println("  if dışında y kullanılamaz; x hâlâ " + x);
        System.out.println();
    }

    // 6.12 Method Overloading
    private static void methodOverloading() {
        System.out.println("[6.12] Method overloading (aşırı yükleme)");
        /*
         * Aynı metot adı, farklı parametre sayısı veya tipleri.
         * Derleyici, çağrı sırasında verilen argümanlara en uygun overload'u seçer.
         * Dönüş tipi overload ayırt etmek için yeterli değildir (aynı parametreyle iki farklı dönüş tipi yazılamaz).
         */
        System.out.println("  max(3, 7) → int overload: " + max(3, 7));
        System.out.println("  max(3.2, 7.1) → double overload: " + max(3.2, 7.1));
        System.out.println();
    }

    private static int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    private static double max(double a, double b) {
        return (a >= b) ? a : b;
    }

    // 6.13 (Optional) GUI and Graphics Case Study
    private static void optionalGuiNotu() {
        System.out.println("[6.13] (Opsiyonel) GUI / Graphics");
        /*
         * Kitapta Swing ile JPanel, paintComponent, Graphics2D, renk/dolu şekiller örneklenir.
         * Sınav odağı genelde metot + event döngüsü fikri; ayrı dosyada çizim denemesi yapılabilir.
         */
        System.out.println("  Bu dosyada GUI çizimi yok; istersen ayrı bir sınıfta JPanel örneği eklenebilir.");
        System.out.println();
    }

    // 6.14 Wrap-Up
    private static void ozet() {
        System.out.println("=== Bölüm 6 özeti ===");
        System.out.println("static | imza | call stack & recursion | promotion/cast | paket | SecureRandom | enum | scope | overload");
        System.out.println();
    }
}
