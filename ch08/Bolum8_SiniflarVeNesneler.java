package ch08;

/**
 * Bölüm 8: Classes and Objects — A Deeper Look
 *
 * Vizede Book.java ile örtüşen konular; finalde kalıtım öncesi temel tekrar.
 *
 * Önce ch03 oku: Bolum3_Siniflar, Account*.java (giriş seviyesi).
 * Bu dosya: ctor zinciri, static sayaç, Book (vize_ornekler/Book.java) ile aynı kalıp.
 *
 * Çalıştırma:
 *   javac ch08/Bolum8_SiniflarVeNesneler.java
 *   java -cp . ch08.Bolum8_SiniflarVeNesneler
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
        System.out.println("=== Bölüm 8: Sınıflar ve nesneler ===\n");
    }

    private static void encapsulationOrnek() {
        System.out.println("[8.2] Encapsulation (kapsülleme)");
        /*
         * private alanlar + public getter/setter → dışarıdan kontrollü erişim.
         * İş kuralları setter içinde uygulanabilir (ör. bakiye negatif olmasın).
         */
        BankAccount acc = new BankAccount("Sarp", 100.0);
        acc.deposit(50);
        acc.withdraw(30);
        System.out.println("  " + acc);
        System.out.println();
    }

    private static void constructorOverload() {
        System.out.println("[8.3] Constructor overloading");
        /*
         * Aynı sınıf adı, farklı parametre listesi → derleyici uygun olanı seçer.
         * Book: Book(), Book(title, author), Book(title, author, price)
         */
        Product p1 = new Product();
        Product p2 = new Product("Kalem", 12.5);
        System.out.println("  " + p1);
        System.out.println("  " + p2);
        System.out.println();
    }

    private static void thisVeZincir() {
        System.out.println("[8.4] this ve constructor chaining");
        /*
         * this(...) → aynı sınıfta başka constructor'ı çağırır (kod tekrarını azaltır).
         * this.field → parametre ile alan adı çakışınca hangisinin alan olduğunu belirtir.
         */
        Product p = new Product("Defter", 25.0, "Kırtasiye");
        System.out.println("  " + p);
        System.out.println();
    }

    private static void staticOrnek() {
        System.out.println("[8.5] static alan ve metot");
        /*
         * static: sınıfa ait; nesne sayısından bağımsız paylaşılır.
         * Book.bookCount, static factory metotları
         */
        Product a = new Product("A", 1);
        Product b = new Product("B", 2);
        System.out.println("  Oluşturulan ürün sayısı: " + Product.getInstanceCount());
        System.out.println();
    }

    private static void privateConstructorOrnek() {
        System.out.println("[8.6] Private constructor (finalde önemli)");
        /*
         * private ClassName() { } → dışarıdan new ClassName() YAPILAMAZ.
         * Nesne oluşturma static factory metoduyla yapılır (Slayt 8 / sınav ipucu).
         * UML: constructor satırında "-" (private)
         */
        IdGenerator g1 = IdGenerator.next();
        IdGenerator g2 = IdGenerator.next();
        System.out.println("  IdGenerator: " + g1 + ", " + g2);
        System.out.println("  new IdGenerator() derleme hatası — sadece next() kullan.");
        System.out.println();
    }

    private static void vizeBookBaglantisi() {
        System.out.println("[Vize bağlantısı] Book.java");
        System.out.println("  vize_ornekler/Book.java → overload ctor, static bookCount, applyDiscount");
        System.out.println("  UML: uml/UML_Calisma.txt → Book");
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 8 özeti ===");
        System.out.println("encapsulation | ctor overload | this | static | private ctor + factory");
    }

    /** Encapsulation örneği — mini banka hesabı. */
    static class BankAccount {
        private final String owner;
        private double balance;

        public BankAccount(String owner, double initialBalance) {
            this.owner = owner == null ? "" : owner;
            this.balance = Math.max(0, initialBalance);
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

    static class Product {
        private static int instanceCount = 0;

        private String name;
        private double price;
        private String category;

        public Product() {
            this("İsimsiz", 0.0);
        }

        public Product(String name, double price) {
            this(name, price, "Genel");
        }

        public Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
            instanceCount++;
        }

        public static int getInstanceCount() {
            return instanceCount;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
        }
    }

    static class IdGenerator {
        private static int seq = 1000;

        private IdGenerator() {
        }

        static IdGenerator next() {
            IdGenerator g = new IdGenerator();
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
