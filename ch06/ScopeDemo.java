package ch06;

/**
 * Scope (kapsam) örneği: aynı isim farklı bloklarda.
 *
 * Kapsam (scope) = bir değişkene nereden erişebildiğimiz.
 * - Dış blokta tanımlanan değişkenler, iç bloklardan görülebilir.
 * - İç blokta tanımlanan değişkenler (ör. if bloğundaki `y`), blok bitince yok olur.
 *
 * Bu örnek özellikle "y neden burada görünmüyor?" sorusuna cevap vermek için var.
 */
public class ScopeDemo {
    public static void main(String[] args) {
        int x = 1; // dış scope
        System.out.println("x (outer) = " + x);

        if (x == 1) {
            // Bu blok yeni bir scope oluşturur
            int y = 2;
            System.out.println("y (inner) = " + y);

            // x'e erişebiliriz (dış scope görünür)
            x = x + y;
            System.out.println("x (updated) = " + x);
        }

        // burada y yok (inner scope bitti)
        System.out.println("x (final) = " + x);
    }
}

