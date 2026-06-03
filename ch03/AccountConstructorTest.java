package ch03;

/**
 * Constructor örneği: nesneleri ilk değerlerle başlatmak.
 *
 * Buradaki amaç:
 * - `new Account("Jane Green")` gibi bir çağrıda, nesnenin adı daha baştan doğru gelsin.
 * - Aynı sınıftan birden fazla nesne üretilebildiğini ve her birinin kendi state'ine sahip olduğunu görmek.
 */
public class AccountConstructorTest {
    public static void main(String[] args) {
        Account account1 = new Account("Jane Green");
        Account account2 = new Account("John Blue");

        System.out.printf("account1 name: %s%n", account1.getName());
        System.out.printf("account2 name: %s%n", account2.getName());
    }
}

