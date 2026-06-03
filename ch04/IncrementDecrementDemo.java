package ch04;

/**
 * ++ ve -- operatörleri: prefix vs postfix.
 *
 * Bu örnek iki şeyi aynı anda gösterir:
 * - **Prefix** (`++i`, `--i`): değişken önce güncellenir, sonra ifade içinde kullanılır.
 * - **Postfix** (`i++`, `i--`): değişken önce ifade içinde kullanılır, sonra güncellenir.
 *
 * Ayrıca bileşik atama operatörlerine (`+=`, `*=`, ...) küçük bir örnek içerir.
 */
public class IncrementDecrementDemo {
    public static void main(String[] args) {
        int i = 5;

        int a = ++i; // önce artır, sonra ata -> i=6, a=6
        int b = i++; // önce ata, sonra artır -> b=6, i=7

        System.out.printf("i=%d, a=%d, b=%d%n", i, a, b);

        int x = 10;
        x += 5; // bileşik atama: x = x + 5
        x *= 2; // x = x * 2
        System.out.printf("x=%d%n", x);
    }
}

