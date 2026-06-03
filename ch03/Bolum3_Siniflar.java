import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

/**
 * Bölüm 3: Introduction to Classes, Objects, Methods and Strings
 *
 * Bu dosya, bölümde geçen kavramları küçük sınıflarla gösterir.
 * Aynı .java dosyasında birden fazla sınıf olabilir; yalnızca public olan sınıfın adı dosya adıyla aynı olmalıdır.
 */
public class Bolum3_Siniflar {
    public static void main(String[] args) {
        intro();
        instanceVariablesSetGet();
        constructorIleBaslatma();
        balanceVeDouble();
        primitiveVsReference();
        optionalGUI();
        ozet();
    }

    // 3.1 Introduction
    private static void intro() {
        /*
         * Sınıf (class): Nesneleri üretmek için bir şablondur.
         * Nesne (object): Sınıftan üretilen somut örnektir (instance).
         * Metot (method): Sınıfın davranışlarıdır (iş yapan fonksiyon).
         * Instance variable: Nesnenin "durumunu" tutan alanlardır (field).
         */
        System.out.println("=== Bolum 3 ===");
    }

    // 3.2 Instance Variables, set Methods and get Methods
    private static void instanceVariablesSetGet() {
        /*
         * Encapsulation (kapsülleme): Alanları genelde private yaparız.
         * Dışarıya kontrollü erişim için get/set metotları verilir.
         */
        AccountV1 acc = new AccountV1();
        acc.setName("Ayse");
        System.out.println("[3.2] name = " + acc.getName());
    }

    // 3.3 Initializing Objects with Constructors
    private static void constructorIleBaslatma() {
        /*
         * Constructor (yapıcı metot): Nesne oluşturulurken otomatik çağrılır.
         * Amaç: nesnenin başlangıç durumunu doğru ayarlamak.
         */
        AccountV2 acc = new AccountV2("Mehmet");
        System.out.println("[3.3] name = " + acc.getName());
    }

    // 3.4 Account with a Balance; Floating-Point Numbers
    private static void balanceVeDouble() {
        /*
         * Para gibi değerlerde double sık kullanılır ama "kesirli temsil hataları" olabilir.
         * Bu seviyede amaç: double'ın kesirli sayı tuttuğunu görmek ve basit işlemleri yapmak.
         */
        AccountV3 acc = new AccountV3("Zeynep", 100.0);
        acc.deposit(25.50);
        acc.withdraw(10.00);
        System.out.printf("[3.4] %s balance=%.2f%n", acc.getName(), acc.getBalance());
    }

    // 3.5 Primitive Types vs. Reference Types
    private static void primitiveVsReference() {
        /*
         * primitive: int/double/boolean gibi tipler -> değer direkt kopyalanır.
         * reference: String / AccountV3 gibi -> referans kopyalanır (aynı nesneyi işaret edebilir).
         */
        int a = 5;
        int b = a; // değer kopyası
        b++;
        System.out.println("[3.5] a=" + a + ", b=" + b + " (primitive kopya)");

        AccountV3 x = new AccountV3("Ali", 10.0);
        AccountV3 y = x; // referans kopyası (aynı nesne)
        y.deposit(5.0);
        System.out.printf("[3.5] x.balance=%.2f, y.balance=%.2f (ayni nesne)%n", x.getBalance(), y.getBalance());

        /*
         * String notu:
         * - String immutable'dır (değiştirilemez). "değiştiriyorum" dediğinde yeni String üretilir.
         * - İçerik karşılaştırması: equals()
         */
        String s1 = "java";
        String s2 = "ja" + "va";
        System.out.println("[3.5] s1.equals(s2) ? " + s1.equals(s2));
    }

    // 3.6 (Optional) GUI and Graphics Case Study: A Simple GUI
    private static void optionalGUI() {
        /*
         * GUI için Swing'de en basit fikir:
         * - JFrame: pencere
         * - JLabel: metin bileşeni
         *
         * Bu örnek opsiyonel olduğu için pencereyi kısa süre gösterip kapatmak yerine
         * "istersen aç" mantığıyla çalıştırıyoruz. (Çalıştırınca pencere açık kalır.)
         */
        boolean guiAc = false; // true yaparsan pencere açılır
        if (!guiAc) {
            System.out.println("[3.6] GUI örneği kapalı (guiAc=false).");
            return;
        }

        JFrame frame = new JFrame("Basit GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 120);
        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("Merhaba GUI!"), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // 3.7 Wrap-Up
    private static void ozet() {
        System.out.println("=== Bolum 3 bitti ===");
        System.out.println();
    }
}

// Basit Account: sadece name alanı + set/get
class AccountV1 {
    private String name;

    public void setName(String name) {
        // this.name -> instance variable
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Constructor ile name set edilen Account
class AccountV2 {
    private String name;

    public AccountV2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Balance içeren Account (double)
class AccountV3 {
    private final String name;
    private double balance;

    public AccountV3(String name, double initialBalance) {
        this.name = name;
        // Basit doğrulama: negatif başlangıç bakiyesi olmasın
        this.balance = Math.max(0.0, initialBalance);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
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
}

