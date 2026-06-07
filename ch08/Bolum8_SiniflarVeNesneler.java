package ch08;

/**
 * Bölüm 8 — Classes and Objects: A Deeper Look (Slayt 8)
 *
 * NE ÖĞRENECEKSİN?
 * - Kapsülleme (encapsulation): private alan + public getter/setter
 * - Constructor overloading: aynı sınıf adı, farklı parametre listesi
 * - this(...) ile constructor zinciri — kod tekrarını azaltır
 * - static: sınıfa ait, tüm nesneler paylaşır (Book.bookCount gibi)
 * - private constructor + static factory (sınav ipucu!)
 *
 * ch03'te Account ile temel gördün; burada derinleşiyoruz.
 * Vize Book.java (vize_ornekler/) ile aynı kalıplar burada.
 *
 * Slayt: Slides/8.pdf  ·  Sonraki: ch09
 *
 * Çalıştırma: java -cp . ch08.Bolum8_SiniflarVeNesneler
 */
public class Bolum8_SiniflarVeNesneler {

    public static void main(String[] args) {
        intro();
        encapsulationOrnek();
        constructorOverload();
        thisVeZincir();
        staticOrnek();
        privateConstructorOrnek();
        vizeBookBaglantisi();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 8: Sınıflar ve nesneler (Slayt 8) ===");
        System.out.println("private alan + kontrollü erişim, ctor çeşitleri, static, private ctor.");
        System.out.println("Book.java ile aynı mantık — vize sorusu buradan gelir.\n");
    }

    private static void encapsulationOrnek() {
        System.out.println("[8.2] Encapsulation (kapsülleme)");
        /*
         * NEDEN private?
         *   Dışarıdan balance = -999 yazılmasın diye alanı gizleriz.
         *   deposit/withdraw gibi metotlar kuralları kontrol eder.
         *
         * UML'de private alan:  - balance : double
         * UML'de public metot:   + deposit(amount : double)
         *
         * Sınav: getter/setter yazma, setter içinde doğrulama (negatif olmasın vb.)
         */
        BankAccount acc = new BankAccount("Sarp", 100.0);
        acc.deposit(50);    // +50 → 150
        acc.withdraw(30);   // -30 → 120
        acc.withdraw(999);  // yetersiz bakiye → işlem yapılmaz
        System.out.println("  " + acc);
        System.out.println();
    }

    private static void constructorOverload() {
        System.out.println("[8.3] Constructor overloading (aşırı yükleme)");
        /*
         * AYNI SINIF ADI, FARKLI PARAMETRE LİSTESİ:
         *
         *   Product()
         *   Product(String name, double price)
         *   Product(String name, double price, String category)
         *
         * Derleyici çağrıdaki argüman sayısına/tiplerine göre doğru olanı seçer.
         * Book.java: Book(), Book(title,author), Book(title,author,price)
         *
         * Sınav: kaç farklı ctor var, new Book("x","y") hangisini çağırır?
         */
        Product p1 = new Product();                  // varsayılan isim + fiyat 0
        Product p2 = new Product("Kalem", 12.5);     // 2 parametreli ctor
        System.out.println("  " + p1);
        System.out.println("  " + p2);
        System.out.println();
    }

    private static void thisVeZincir() {
        System.out.println("[8.4] this ve constructor chaining");
        /*
         * this(...)  → aynı sınıfta BAŞKA bir constructor'ı çağırır (ilk satırda olmalı)
         * this.alan  → parametre adı alan adıyla aynıysa "benim alanım" demek için
         *
         * Zincir örneği (Product içinde):
         *   Product()           → this("İsimsiz", 0.0)
         *   Product(n, p)       → this(n, p, "Genel")
         *   Product(n, p, cat)  → asıl atamalar burada
         *
         * Amaç: ortak kod tek yerde, tekrar yok.
         */
        Product p = new Product("Defter", 25.0, "Kırtasiye");
        System.out.println("  " + p);
        System.out.println();
    }

    private static void staticOrnek() {
        System.out.println("[8.5] static alan ve metot");
        /*
         * static = SINIFA ait, nesneye değil.
         *
         *   Product a = new Product("A", 1);
         *   Product b = new Product("B", 2);
         *   Product.getInstanceCount()  → 2 (iki nesne oluşturuldu)
         *
         * Book.getBookCount() → kaç kitap oluşturuldu (vize sorusu)
         *
         * static metot: nesne olmadan SınıfAdi.metotAdi() ile çağrılır.
         * static alan:  tüm nesneler TEK kopyayı paylaşır.
         */
        Product a = new Product("A", 1);
        Product b = new Product("B", 2);
        System.out.println("  Oluşturulan ürün sayısı: " + Product.getInstanceCount());
        System.out.println();
    }

    private static void privateConstructorOrnek() {
        System.out.println("[8.6] Private constructor — SINAVDA ÖNEMLİ");
        /*
         *   private IdGenerator() { }
         *
         * Dışarıdan new IdGenerator() YAZILAMAZ → derleme hatası.
         * Nesne sadece sınıf içinden veya static factory ile:
         *   IdGenerator.next()
         *
         * NEDEN?
         *   Kimin ne zaman nesne oluşturacağını sınıf kontrol eder.
         *   Tek giriş noktası (factory metot) → tutarlı kullanım.
         *
         * UML:  - IdGenerator()   (private, eksi işareti)
         *        + next() : IdGenerator {static}
         */
        IdGenerator g1 = IdGenerator.next();
        IdGenerator g2 = IdGenerator.next();
        System.out.println("  IdGenerator: " + g1 + ", " + g2); // 1001, 1002
        System.out.println("  new IdGenerator() → derleme hatası");
        System.out.println();
    }

    private static void vizeBookBaglantisi() {
        System.out.println("[Vize bağlantısı] Book.java");
        System.out.println("  vize_ornekler/Book.java → ctor overload, static bookCount, applyDiscount");
        System.out.println("  UML: uml/UML_Calisma.txt");
        System.out.println("  Kendin dene: Book'u kapat, aynı yapıyı sıfırdan yaz.\n");
    }

    private static void ozet() {
        System.out.println("=== Bölüm 8 özeti ===");
        System.out.println("private/public | ctor overload | this(...) | static | private ctor + factory");
    }

    /** Mini banka — kapsülleme: dışarıdan balance'a doğrudan erişim yok. */
    static class BankAccount {
        private final String owner;
        private double balance;

        public BankAccount(String owner, double initialBalance) {
            this.owner = owner == null ? "" : owner;
            this.balance = Math.max(0, initialBalance); // negatif başlangıç engeli
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }

        @Override
        public String toString() {
            return "BankAccount{owner='" + owner + "', balance=" + balance + "}";
        }
    }

    /** Constructor zinciri örneği — üç ctor birbirini this(...) ile çağırır. */
    static class Product {
        private static int instanceCount = 0; // static: tüm Product nesneleri paylaşır

        private String name;
        private double price;
        private String category;

        public Product() {
            this("İsimsiz", 0.0); // 2 parametreli ctor'a yönlendir
        }

        public Product(String name, double price) {
            this(name, price, "Genel"); // 3 parametreli ctor'a yönlendir
        }

        public Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
            instanceCount++; // her yeni nesnede sayaç artar
        }

        public static int getInstanceCount() {
            return instanceCount;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
        }
    }

    /** private ctor — sadece next() ile nesne üretilir. */
    static class IdGenerator {
        private static int seq = 1000;

        private IdGenerator() {
            // dışarıdan new yapılamaz
        }

        static IdGenerator next() {
            IdGenerator g = new IdGenerator(); // sınıf içinden new OK
            g.id = ++seq;
            return g;
        }

        private int id;

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }
}
