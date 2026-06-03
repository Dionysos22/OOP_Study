package ornekler;

/**
 * Lab 7 özet pratiği — tam lab kodu değil; sınavda hatırlanacak iskelet.
 *
 * Kurallar (Lab 7 PDF ile aynı):
 *   credit  → amount <= 5000
 *   paypal  → amount >= 10
 *   crypto  → amount % 5 == 0
 *
 * Çalıştırma:
 *   javac ornekler/Final_OdemeOzeti.java
 *   java -cp . ornekler.Final_OdemeOzeti
 */
public class Final_OdemeOzeti {

    public static void main(String[] args) {
        demo("credit", 2000);
        demo("paypal", 5);    // hata: min 10
        demo("crypto", 100);  // OK
        demo("bank", 50);     // bilinmeyen tip
    }

    private static void demo(String type, double amount) {
        System.out.println("--- type=" + type + ", amount=" + amount + " ---");
        try {
            PaymentProcessor p = PaymentFactory.create(type);
            p.processPayment(amount);
        } catch (PaymentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    interface PaymentProcessor {
        void processPayment(double amount) throws PaymentException;
    }

    static class PaymentException extends Exception {
        public PaymentException(String message) {
            super(message);
        }
    }

    static class CreditCardProcessor implements PaymentProcessor {
        private static final double MAX = 5000;

        @Override
        public void processPayment(double amount) throws PaymentException {
            if (amount > MAX) {
                throw new PaymentException("Credit card payment cannot exceed " + (int) MAX);
            }
            System.out.println("Processing credit card payment of " + amount);
        }
    }

    static class PayPalProcessor implements PaymentProcessor {
        @Override
        public void processPayment(double amount) throws PaymentException {
            if (amount < 10) {
                throw new PaymentException("PayPal payment must be at least 10");
            }
            System.out.println("Processing PayPal payment of " + amount);
        }
    }

    static class CryptoProcessor implements PaymentProcessor {
        @Override
        public void processPayment(double amount) throws PaymentException {
            if (amount % 5 != 0) {
                throw new PaymentException("Crypto payment amount must be a multiple of 5");
            }
            System.out.println("Processing crypto payment of " + amount);
        }
    }

    static class PaymentFactory {
        private PaymentFactory() {
        }

        public static PaymentProcessor create(String type) {
            if (type == null) {
                throw new IllegalArgumentException("Unknown payment type: null");
            }
            switch (type.trim().toLowerCase()) {
                case "credit":
                    return new CreditCardProcessor();
                case "paypal":
                    return new PayPalProcessor();
                case "crypto":
                    return new CryptoProcessor();
                default:
                    throw new IllegalArgumentException("Unknown payment type: " + type.trim());
            }
        }
    }
}
