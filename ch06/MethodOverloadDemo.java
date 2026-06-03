package ch06;

/**
 * Method overloading (aşırı yükleme) örneği.
 *
 * Aynı isim, farklı parametre listeleri -> derleyici doğru olanı seçer.
 *
 * Bu örnekte:
 * - `square(int)` çağrısı tam sayı sürümüne gider
 * - `square(double)` çağrısı ondalıklı sürüme gider
 *
 * Not: Dönüş tipi tek başına overload için yeterli değildir; parametre listesi farklı olmalıdır.
 */
public class MethodOverloadDemo {
    public static void main(String[] args) {
        System.out.println("square(7) = " + square(7));
        System.out.println("square(7.5) = " + square(7.5));
    }

    private static int square(int x) {
        return x * x;
    }

    private static double square(double x) {
        return x * x;
    }
}

