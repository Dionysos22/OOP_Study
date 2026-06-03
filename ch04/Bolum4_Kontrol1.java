import java.util.Scanner;

/**
 * Bölüm 4: Control Statements Part 1; Assignment, ++ and -- Operators
 *
 * Bu bölümün ana fikri: Programın akışını kontrol etmek.
 * - Seçim (if/if-else)
 * - Döngü (while)
 * - Atama, bileşik atama, artırma/azaltma
 */
public class Bolum4_Kontrol1 {
    public static void main(String[] args) {
        intro();
        algorithmVePseudocode();
        ifTekSecim();
        ifElseCiftSecim();
        nestedIfElseStudent();
        whileDongusu();
        sayacKontrollu();
        gozcukontrollu();
        icIceKontrol();
        bilesikAtama();
        artirmaAzaltma();
        primitiveTypes();
        optionalGuiNotu();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bolum 4 ===");
    }

    // 4.2 Algorithms + 4.3 Pseudocode + 4.4 Control Structures
    private static void algorithmVePseudocode() {
        /*
         * Algoritma: Bir problemi çözmek için adım adım tarif.
         * Pseudocode: Programlama dilinden bağımsız, "insan-okur" biçimde yazılmış algoritma.
         *
         * Örnek (pseudocode): 1..10 arasındaki sayıları topla
         *  sum = 0
         *  i = 1
         *  while i <= 10
         *      sum = sum + i
         *      i = i + 1
         *  print sum
         *
         * Kontrol yapıları:
         * - Sequence (sıralı çalışma)
         * - Selection (seçim) -> if/if-else
         * - Iteration (tekrar) -> while (bu bölüm), sonra for/do-while
         */
        System.out.println("[4.2-4.4] Algoritma ve kontrol yapıları anlatımı yorumlarda.");
    }

    // 4.5 if Single-Selection Statement
    private static void ifTekSecim() {
        int yas = 19;
        if (yas >= 18) {
            System.out.println("[4.5] Reşitsiniz.");
        }
        // Koşul false ise blok çalışmaz; else yok.
    }

    // 4.6 if…else Double-Selection Statement
    private static void ifElseCiftSecim() {
        int not = 47;
        if (not >= 50) {
            System.out.println("[4.6] Geçti");
        } else {
            System.out.println("[4.6] Kaldı");
        }
    }

    // 4.7 Student Class: Nested if…else Statements
    private static void nestedIfElseStudent() {
        /*
         * İç içe if-else: çoklu aralıkları sınıflamak için kullanılır.
         * Örn: harf notu gibi.
         */
        int score = 83;
        String grade;
        if (score >= 90) {
            grade = "AA";
        } else if (score >= 80) {
            grade = "BA";
        } else if (score >= 70) {
            grade = "BB";
        } else if (score >= 60) {
            grade = "CB";
        } else if (score >= 50) {
            grade = "CC";
        } else {
            grade = "FF";
        }
        System.out.println("[4.7] score=" + score + " => " + grade);
    }

    // 4.8 while Iteration Statement
    private static void whileDongusu() {
        /*
         * while döngüsü: koşul true olduğu sürece çalışır.
         * Dikkat: koşulu bir noktada false yapmazsan sonsuz döngü olur.
         */
        int i = 1;
        while (i <= 3) {
            System.out.println("[4.8] i=" + i);
            i++;
        }
    }

    // 4.9 Counter-Controlled Iteration
    private static void sayacKontrollu() {
        /*
         * Sayaç kontrollü: kaç kez döneceğin bellidir.
         * Tipik kalıp:
         *  counter = başlangıç
         *  while counter <= limit
         *     ...
         *     counter++
         */
        int toplam = 0;
        int counter = 1;
        while (counter <= 5) {
            toplam += counter;
            counter++;
        }
        System.out.println("[4.9] 1..5 toplam = " + toplam);
    }

    // 4.10 Sentinel-Controlled Iteration
    private static void gozcukontrollu() {
        /*
         * Gözcü (sentinel) kontrollü: kaç kez döneceğin belli değildir.
         * Döngü, özel bir "bitir" değeri girilince sona erer.
         *
         * Örn: -1 girilene kadar sayıları topla.
         */
        System.out.print("[4.10] Sayilar gir (-1 bitirir): ");
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int value;

        if (!sc.hasNextInt()) {
            System.out.println("Girdi yok, ornek atlandi.");
            return;
        }

        value = sc.nextInt();
        while (value != -1) {
            sum += value;
            if (!sc.hasNextInt()) {
                System.out.println("Girdi bitti, toplami yaziyorum.");
                break;
            }
            value = sc.nextInt();
        }
        System.out.println("[4.10] sum=" + sum);
    }

    // 4.11 Nested Control Statements
    private static void icIceKontrol() {
        /*
         * İç içe kontrol: Döngü içinde if veya if içinde döngü.
         * Örn: 1..5 arası çiftleri yaz.
         */
        int n = 1;
        System.out.print("[4.11] ciftler: ");
        while (n <= 5) {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
            n++;
        }
        System.out.println();
    }

    // 4.12 Compound Assignment Operators
    private static void bilesikAtama() {
        /*
         * Bileşik atama:
         *  x += 3  -> x = x + 3
         *  x -= 2  -> x = x - 2
         *  x *= 4, x /= 5, x %= 2
         */
        int x = 10;
        x += 5;
        x *= 2;
        System.out.println("[4.12] x=" + x); // (10+5)*2 = 30
    }

    // 4.13 Increment and Decrement Operators
    private static void artirmaAzaltma() {
        /*
         * ++ ve -- iki tür kullanılır:
         * - prefix: ++i (önce artır, sonra kullan)
         * - postfix: i++ (önce kullan, sonra artır)
         */
        int i = 5;
        int a = ++i; // i=6, a=6
        int b = i++; // b=6, i=7
        System.out.println("[4.13] i=" + i + ", a=" + a + ", b=" + b);
    }

    // 4.14 Primitive Types
    private static void primitiveTypes() {
        /*
         * Java primitive tipler:
         * - whole numbers: byte, short, int, long
         * - floating point: float, double
         * - char, boolean
         *
         * Bu tiplerin boyutları sabittir; performanslıdır ve değer taşırlar.
         */
        int i = 42;
        double d = 3.14;
        boolean ok = true;
        char c = 'A';
        System.out.println("[4.14] i=" + i + ", d=" + d + ", ok=" + ok + ", c=" + c);
    }

    // 4.15 (Optional) GUI and Graphics Case Study
    private static void optionalGuiNotu() {
        /*
         * Bu bölümde GUI opsiyoneldi.
         * Swing/AWT ile çizim örnekleri sonraki dosyalarda (Bölüm 5/6 opsiyonellerinde) gösterilebilir.
         */
        System.out.println("[4.15] GUI opsiyonel konu: bu dosyada sadece not olarak bırakıldı.");
    }

    // 4.16 Wrap-Up
    private static void ozet() {
        System.out.println("=== Bolum 4 bitti ===");
        System.out.println();
    }
}

