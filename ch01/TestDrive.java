package ch01;

/**
 * 1.10 Test-Driving a Java Application
 *
 * Amaç: Java programını derle-çalıştır döngüsünü pratik etmek.
 *
 * Terminalde (OOP_Midterm_Study içinde):
 *   javac ch01/TestDrive.java
 *   java -cp . ch01.TestDrive
 *
 * Not:
 * - "package ch01;" dediğimiz için çalıştırırken -cp . ve tam sınıf adını kullanırız.
 */
public class TestDrive {
    public static void main(String[] args) {
        System.out.println("TestDrive çalıştı.");

        // args: komut satırından gelen parametreler.
        // Örn: java -cp . ch01.TestDrive merhaba 123
        System.out.println("args.length = " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.printf("args[%d] = %s%n", i, args[i]);
        }
    }
}
