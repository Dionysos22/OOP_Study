package ch05;

/**
 * AutoPolicy test: String switch kullanımını gösterir.
 *
 * Amaç:
 * - Aynı sınıftan iki farklı nesne üret
 * - Her birinin state değerine göre "no-fault" durumunun değiştiğini gör
 */
public class AutoPolicyTest {
    public static void main(String[] args) {
        AutoPolicy policy1 = new AutoPolicy(11111111, "Toyota Camry", "NJ");
        AutoPolicy policy2 = new AutoPolicy(22222222, "Ford Fusion", "ME");

        printPolicy(policy1);
        printPolicy(policy2);
    }

    private static void printPolicy(AutoPolicy policy) {
        System.out.printf("Account #%d: %s (%s)%n",
                policy.getAccountNumber(),
                policy.getMakeAndModel(),
                policy.getState());

        System.out.printf("  No-fault state? %s%n", policy.isNoFaultState() ? "YES" : "NO");
    }
}

