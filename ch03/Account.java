package ch03;

/**
 * Bölüm 3 "Account" örneklerinin birleşik sürümü.
 *
 * Konular:
 * - instance variable (name, balance)
 * - constructor ile başlatma
 * - set/get metotları
 * - basit doğrulama (negatif bakiye olmasın gibi)
 */
public class Account {
    private String name;
    private double balance;

    // 3.2: boş constructor (Java varsayılan da üretebilirdi; burada bilerek yazıyoruz)
    public Account() {
        this.name = "";
        this.balance = 0.0;
    }

    // 3.3: constructor ile isim başlatma
    public Account(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    // 3.4: constructor ile isim + bakiye başlatma
    public Account(String name, double balance) {
        this.name = name;
        if (balance > 0.0) {
            this.balance = balance;
        } else {
            this.balance = 0.0;
        }
    }

    public void deposit(double amount) {
        if (amount > 0.0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0.0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

