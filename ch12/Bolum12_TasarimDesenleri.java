package ch12;

/**
 * Bölüm 12 (özet): Tasarım desenleri — Factory Method
 *
 * Lab 7 PaymentFactory ile birebir bağlantı.
 * Lab 7 kuralları: lab/LAB_SINAV_NOTLARI.txt
 *
 * Çalıştırma:
 *   javac ch12/Bolum12_TasarimDesenleri.java
 *   java -cp . ch12.Bolum12_TasarimDesenleri
 */
public class Bolum12_TasarimDesenleri {

    public static void main(String[] args) {
        intro();
        interfaceVsBaseClass();
        privateConstructorNotu();
        factoryMethodDemo();
        openClosedNotu();
        lab7YolHaritasi();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 12: Factory Method (Lab 7) ===\n");
    }

    private static void interfaceVsBaseClass() {
        System.out.println("[12.1] Interface vs base class");
        /*
         * SORU (reflection Q1): Neden PaymentProcessor interface?
         * - Ortak kod yok; sadece sözleşme (processPayment) yeterli.
         * - Farklı iş kuralları; kalıtım hiyerarşisi zorlamak gereksiz.
         * - Bir sınıf birden fazla interface implement edebilir.
         */
        System.out.println("  Interface = ne yapılacağı; base class = paylaşılan kod + kalıtım.");
        System.out.println("  Ödeme tipleri birbirinden bağımsız kurallara sahip → interface uygun.");
        System.out.println();
    }

    private static void privateConstructorNotu() {
        System.out.println("[12.2] Private constructor + Factory");
        /*
         * PaymentFactory:
         *   private PaymentFactory() { }
         *   public static PaymentProcessor createProcessor(String type)
         */
        System.out.println("  private ctor → new PaymentFactory() yasak");
        System.out.println("  static create... → client somut sınıf adını bilmez");
        System.out.println("  Kod: ornekler/Final_OdemeOzeti.java");
        System.out.println();
    }

    private static void factoryMethodDemo() {
        System.out.println("[12.3] Factory Method");
        /*
         * PaymentFactory.createProcessor(type) → doğru PaymentProcessor döner.
         * Client (main) somut sınıf adını bilmez → genişletmeye açık.
         */
        try {
            DocumentExporter pdf = DocumentFactory.create("pdf");
            DocumentExporter html = DocumentFactory.create("html");
            pdf.export("Rapor verisi");
            html.export("Rapor verisi");
        } catch (IllegalArgumentException e) {
            System.out.println("  Hata: " + e.getMessage());
        }
        System.out.println();
    }

    private static void openClosedNotu() {
        System.out.println("[12.4] Open/Closed ilkesi");
        /*
         * Yeni ödeme tipi: CryptoProcessor + factory'de case "crypto"
         * SmartPaymentSystem try-catch bloğu değişmeden kalabilir.
         */
        System.out.println("  Davranışı genişlet (yeni processor), mevcut client kodunu minimum değiştir.");
        System.out.println();
    }

    private static void lab7YolHaritasi() {
        System.out.println("[Lab 7 dosya sırası — okuma önerisi]");
        System.out.println("  1. PaymentProcessor.java (interface)");
        System.out.println("  2. PaymentException.java");
        System.out.println("  3. CreditCard / PayPal / Crypto (implements + kurallar)");
        System.out.println("  4. PaymentFactory.java");
        System.out.println("  5. SmartPaymentSystem.java (main + try-catch)");
        System.out.println("  Lab kuralları: lab/LAB_SINAV_NOTLARI.txt");
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 12 özeti ===");
        System.out.println("interface sözleşmesi | Factory.create | Open/Closed | Lab 7");
    }

    interface DocumentExporter {
        void export(String data);
    }

    static class PdfExporter implements DocumentExporter {
        @Override
        public void export(String data) {
            System.out.println("  [PDF] Export: " + data);
        }
    }

    static class HtmlExporter implements DocumentExporter {
        @Override
        public void export(String data) {
            System.out.println("  [HTML] Export: " + data);
        }
    }

    static class DocumentFactory {
        private DocumentFactory() {
        }

        public static DocumentExporter create(String type) {
            if (type == null) {
                throw new IllegalArgumentException("Unknown type: null");
            }
            switch (type.trim().toLowerCase()) {
                case "pdf":
                    return new PdfExporter();
                case "html":
                    return new HtmlExporter();
                default:
                    throw new IllegalArgumentException("Unknown type: " + type);
            }
        }
    }
}
