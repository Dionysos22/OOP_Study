package ch04;

/**
 * while döngüsü (counter-controlled iteration) temel örnek.
 *
 * "Sayaç kontrollü" döngü kalıbı 3 parçadan oluşur:
 * - başlangıç değeri (counter = 1)
 * - koşul (counter <= 5)
 * - güncelleme (counter++)
 *
 * Güncelleme unutulursa koşul hiç değişmeyebilir ve **sonsuz döngü** oluşabilir.
 */
public class WhileCounter {
    public static void main(String[] args) {
        int counter = 1; // başlangıç

        // koşul true kaldığı sürece tekrar eder
        while (counter <= 5) {
            System.out.printf("counter = %d%n", counter);
            counter++; // güncelleme -> sonsuz döngüyü engeller
        }
    }
}

