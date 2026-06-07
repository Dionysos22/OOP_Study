package vize_tekrar;

/**
 * Vize konuları output tekrarı (Bölüm 2–6 özeti).
 *
 * Finalde "bu kodun çıktısı ne?" soruları için.
 * Önce kendin tahmin et, sonra çalıştırıp yorum satırlarındaki CEVAP ile karşılaştır.
 *
 * Çalıştırma:
 *   java -cp . vize_tekrar.BolumVize_OutputTekrar
 */
public class BolumVize_OutputTekrar {

    public static void main(String[] args) {
        System.out.println("=== Vize Output Tekrar ===\n");
        ornek1_ifElse();
        ornek2_while();
        ornek3_forBreak();
        ornek4_switch();
        ornek5_metotOverload();
        ornek6_staticVeReferans();
        ornek7_bookTarzi();
        ozet();
    }

    private static void ornek1_ifElse() {
        System.out.println("[1] if-else");
        int x = 10;
        int y = 3;
        if (x > y) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
        System.out.println("x+y=" + (x + y));
        // CEVAP: A  sonra  x+y=13
        System.out.println();
    }

    private static void ornek2_while() {
        System.out.println("[2] while sayaç");
        int total = 0;
        int i = 1;
        while (i <= 4) {
            total += i;
            i++;
        }
        System.out.println("total=" + total);
        // CEVAP: total=10  (1+2+3+4)
        System.out.println();
    }

    private static void ornek3_forBreak() {
        System.out.println("[3] for + break");
        for (int n = 1; n <= 10; n++) {
            if (n == 5) {
                break;
            }
            System.out.print(n + " ");
        }
        System.out.println();
        // CEVAP: 1 2 3 4
        System.out.println();
    }

    private static void ornek4_switch() {
        System.out.println("[4] switch (grade/10)");
        int grade = 87;
        String letter;
        switch (grade / 10) {
            case 10:
            case 9:
                letter = "A";
                break;
            case 8:
                letter = "B";
                break;
            default:
                letter = "F";
        }
        System.out.println("letter=" + letter);
        // CEVAP: letter=B  (87/10 = 8)
        System.out.println();
    }

    private static void ornek5_metotOverload() {
        System.out.println("[5] metot overload");
        System.out.println(max(3, 7));
        System.out.println(max(3.5, 2.1));
        // CEVAP: 7  sonra  3.5
        System.out.println();
    }

    static int max(int a, int b) {
        return a >= b ? a : b;
    }

    static double max(double a, double b) {
        return a >= b ? a : b;
    }

    private static void ornek6_staticVeReferans() {
        System.out.println("[6] static sayaç");
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        c1.tick();
        c2.tick();
        c2.tick();
        System.out.println("count=" + Counter.getCount());
        // CEVAP: count=3
        System.out.println();
    }

    static class Counter {
        private static int count = 0;

        void tick() {
            count++;
        }

        static int getCount() {
            return count;
        }
    }

    private static void ornek7_bookTarzi() {
        System.out.println("[7] Book tarzı: ctor + static + indirim");
        MiniBook b1 = new MiniBook("Java", 120);
        new MiniBook("OOP", 80);
        new MiniBook();
        if (b1.getPrice() > 100) {
            b1.discount(10);
        }
        System.out.println(b1.getPrice());
        System.out.println(MiniBook.getTotal());
        // CEVAP: 108.0  sonra  3
        System.out.println();
    }

    static class MiniBook {
        private static int total = 0;
        private double price;

        MiniBook() {
            this("?", 0);
        }

        MiniBook(String title, double price) {
            this.price = price;
            total++;
        }

        void discount(double pct) {
            price -= price * (pct / 100);
        }

        double getPrice() {
            return price;
        }

        static int getTotal() {
            return total;
        }
    }

    private static void ozet() {
        System.out.println("=== Output tekrar özeti ===");
        System.out.println("break unutma | switch fall-through | static sınıfa ait");
        System.out.println("Tam örnekler: ch04/, ch05/, ch06/");
    }
}
