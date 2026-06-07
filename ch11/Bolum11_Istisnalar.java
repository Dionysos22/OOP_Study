package ch11;

/**
 * Bölüm 11 — Exception Handling (Slayt 11)
 *
 * NE ÖĞRENECEKSİN?
 * - try-catch-finally: hata yakalama, program çökmesin
 * - throws: metot "bu hatayı fırlatabilir" der — çağıran yakalar veya bildirir
 * - Checked vs Unchecked exception farkı (sınavın en sık sorusu!)
 * - Kendi exception sınıfını yazma: extends Exception
 *
 * CHECKED vs UNCHECKED:
 *   Checked   → Exception altı, RuntimeException DEĞİL → catch veya throws ZORUNLU
 *               örn: IOException, InvalidAgeException
 *   Unchecked → RuntimeException altı → derleyici zorunlu tutmaz
 *               örn: NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException
 *
 * Slayt: Slides/11.pdf  ·  Sonraki: ch16
 *
 * Çalıştırma: java -cp . ch11.Bolum11_Istisnalar
 */
public class Bolum11_Istisnalar {

    public static void main(String[] args) {
        intro();
        tryCatchFinally();
        throwsOrnek();
        checkedVsUnchecked();
        customException();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 11: Exception handling (Slayt 11) ===");
        System.out.println("Hata olunca program durmasın — anlamlı mesaj ver.");
        System.out.println("Checked = catch/throws zorunlu | Unchecked = isteğe bağlı.\n");
    }

    private static void tryCatchFinally() {
        System.out.println("[11.2–11.4] try-catch-finally");
        /*
         * try     → hata çıkabilecek kod
         * catch   → belirli exception tipini yakala, program devam etsin
         * finally → catch olsa da olmasa da ÇALIŞIR (kaynak kapatma vb.)
         *
         * Örnek akış:
         *   a[5] → ArrayIndexOutOfBoundsException fırlatır
         *   catch yakalar → mesaj basar
         *   finally → "finally bloğu çalıştı"
         *   main devam eder (çökmez)
         *
         * Sınav output: try içindeki println çalışmaz, catch mesajı + finally görünür.
         */
        try {
            int[] a = { 1, 2 };
            System.out.println("  a[5] = " + a[5]); // buraya gelmeden exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  Yakalandı: " + e.getClass().getSimpleName() + " → " + e.getMessage());
        } finally {
            System.out.println("  finally bloğu çalıştı.");
        }
        System.out.println("  Program devam ediyor.\n");
    }

    private static void throwsOrnek() {
        System.out.println("[11.5] throws — metot bildirimi");
        /*
         *   void validateAge(int age) throws InvalidAgeException { ... }
         *
         * Checked exception fırlatan metot:
         *   - Ya kendi içinde try-catch ile yakalar
         *   - Ya imzada throws yazar → çağıran sorumlu olur
         *
         * main'de try-catch ile çağırıyoruz çünkü validateAge checked fırlatıyor.
         *
         * Sınav: "throws eksik" veya "try-catch unutulmuş" derleme hatası
         */
        try {
            validateAge(15); // 18 altı → exception
        } catch (InvalidAgeException e) {
            System.out.println("  Hata: " + e.getMessage());
        }
        System.out.println();
    }

    private static void checkedVsUnchecked() {
        System.out.println("[11.6] Checked vs Unchecked — EZBERLE");
        /*
         * ┌─────────────┬──────────────────────────┬─────────────────────┐
         * │             │ Checked                  │ Unchecked           │
         * ├─────────────┼──────────────────────────┼─────────────────────┤
         * │ Kalıtım     │ Exception (Runtime değil)│ RuntimeException    │
         * │ Derleyici   │ catch veya throws zorunlu│ zorunlu değil       │
         * │ Örnek       │ IOException              │ NumberFormatException│
         * │             │ InvalidAgeException      │ NullPointerException │
         * └─────────────┴──────────────────────────┴─────────────────────┘
         *
         * Integer.parseInt("abc") → NumberFormatException (unchecked)
         * try-catch yazmasan da kod derlenir (ama çalışınca crash olabilir)
         */
        System.out.println("  Unchecked örnek: Integer.parseInt(\"abc\")");
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("  → NumberFormatException yakalandı (unchecked).");
        }
        System.out.println();
    }

    private static void customException() {
        System.out.println("[11.7] Özel exception sınıfı");
        /*
         *   class InsufficientFundsException extends Exception {
         *       public InsufficientFundsException(String message) {
         *           super(message);
         *       }
         *   }
         *
         * Neden kendi exception?
         *   - Hata anlamlı isim taşır (bakiye yetersiz vs genel Exception)
         *   - catch (InsufficientFundsException e) ile hedefli yakalama
         *
         * throw new InsufficientFundsException("...");  → metot içinde fırlat
         * throws InsufficientFundsException             → imzada bildir (checked ise)
         */
        try {
            withdraw(1000, 500);  // OK
            withdraw(1000, 1500); // exception
        } catch (InsufficientFundsException e) {
            System.out.println("  " + e.getMessage());
        }
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 11 özeti ===");
        System.out.println("try-catch-finally | throws | checked=catch/throws | custom extends Exception");
    }

    /** Checked exception fırlatır — çağıran try-catch veya throws kullanmalı. */
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Yaş 18'den küçük: " + age);
        }
        System.out.println("  Yaş uygun: " + age);
    }

    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Bakiye yetersiz. balance=" + balance + ", istenen=" + amount);
        }
        System.out.println("  Çekim başarılı: " + amount);
    }

    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
}
