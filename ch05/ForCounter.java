package ch05;

/**
 * for döngüsü: counter-controlled iteration için standart kalıp.
 *
 * for yapısı, sayaç kontrollü döngülerde en kompakt biçimdir:
 * - başlatma: `int counter = 1`
 * - koşul: `counter <= 5`
 * - güncelleme: `counter++`
 *
 * Aynı mantık `while` ile de yazılabilir; for genelde daha okunaklı olur.
 */
public class ForCounter {
    public static void main(String[] args) {
        for (int counter = 1; counter <= 5; counter++) {
            System.out.printf("counter = %d%n", counter);
        }
    }
}

