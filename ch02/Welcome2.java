package ch02;

/**
 * Fig. 2.3: Welcome2.java (Welcome1'in düzenlenmiş hali fikri)
 *
 * Konu: print vs println ve kaçış karakteri \n.
 */
public class Welcome2 {
    public static void main(String[] args) {
        // print: satır sonuna geçmez.
        System.out.print("Welcome to ");
        System.out.println("Java Programming!");

        // \n: newline (yeni satır) escape sequence.
        System.out.print("Satir1\nSatir2\n");
    }
}

