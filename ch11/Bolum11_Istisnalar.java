package ch11;

/**
 * Bölüm 11: Exception Handling (Slayt 11)
 *
 * Çalıştırma:
 *   java -cp . ch11.Bolum11_Istisnalar
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
        System.out.println("=== Bölüm 11: Exception handling ===\n");
    }

    private static void tryCatchFinally() {
        System.out.println("[11.2–11.4] try-catch-finally");
        /*
         * try: riskli kod
         * catch: belirli exception tipini yakala
         * finally: her durumda çalışır (kaynak kapatma vb.)
         */
        try {
            int[] a = { 1, 2 };
            System.out.println("  a[5] = " + a[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  Yakalandı: " + e.getClass().getSimpleName() + " → " + e.getMessage());
        } finally {
            System.out.println("  finally bloğu çalıştı.");
        }
        System.out.println();
    }

    private static void throwsOrnek() {
        System.out.println("[11.5] throws");
        /*
         * Metot checked exception fırlatıyorsa throws bildirir veya try-catch kullanır.
         */
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("  Hata: " + e.getMessage());
        }
        System.out.println();
    }

    private static void checkedVsUnchecked() {
        System.out.println("[11.6] Checked vs unchecked");
        /*
         * Unchecked (RuntimeException altı): NumberFormatException, IllegalArgumentException,
         *   ArrayIndexOutOfBoundsException — derleyici zorunlu catch istemez.
         * Checked (Exception altı, Runtime değil): IOException — ya catch ya throws.
         */
        System.out.println("  Unchecked örnek: Integer.parseInt(\"abc\")");
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("  → NumberFormatException yakalandı.");
        }
        System.out.println();
    }

    private static void customException() {
        System.out.println("[11.7] Özel exception sınıfı");
        /*
         * class XxxException extends Exception { ... }
         */
        try {
            withdraw(1000, 500);
        } catch (InsufficientFundsException e) {
            System.out.println("  " + e.getMessage());
        }
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 11 özeti ===");
        System.out.println("try-catch-finally | throws | checked/unchecked | custom exception");
    }

    /** Checked özel exception — yaş doğrulama. */
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
