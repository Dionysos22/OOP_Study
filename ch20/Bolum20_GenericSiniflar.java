package ch20;

import java.util.ArrayList;

/**
 * Bölüm 20 — Generic Classes and Methods (Slides/20.pdf)
 *
 * Slayt 20: tip parametresi <T>, generic sınıf, generic metot, type safety.
 *
 * Kitap referans: Deitel Ch.20 (slayt yeterli değilse)
 *
 * Çalıştırma:
 *   java -cp . ch20.Bolum20_GenericSiniflar
 */
public class Bolum20_GenericSiniflar {

    public static void main(String[] args) {
        intro();
        genericSinif();
        genericMetot();
        typeSafety();
        genericRepoOrnek();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 20: Generic Classes and Methods (Slayt 20) ===\n");
    }

    private static void genericSinif() {
        System.out.println("[20.1] Generic sınıf Box<T>");
        /*
         * <T> = type parameter. Kullanırken T yerine gerçek tip yazılır.
         * Box<String> sadece String tutar — derleyici tip kontrolü yapar.
         */
        Box<String> stringBox = new Box<>("Merhaba");
        Box<Integer> intBox = new Box<>(42);

        System.out.println("  stringBox: " + stringBox.get());
        System.out.println("  intBox: " + intBox.get());
        System.out.println();
    }

    private static void genericMetot() {
        System.out.println("[20.2] Generic metot");
        /*
         * <T> metot imzasından önce → metot seviyesinde tip parametresi
         */
        Integer[] nums = { 1, 2, 3 };
        String[] words = { "a", "b" };
        printArray(nums);
        printArray(words);
        System.out.println();
    }

    private static <T> void printArray(T[] array) {
        System.out.print("  printArray: ");
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void typeSafety() {
        System.out.println("[20.3] Tip güvenliği (raw type kullanma)");
        /*
         * ArrayList raw = new ArrayList();  → eski stil, tip kontrolü yok
         * ArrayList<String> list = new ArrayList<>();  → doğru
         */
        ArrayList<String> safe = new ArrayList<>();
        safe.add("Java");
        // safe.add(123);  // derleme hatası — yanlış tip eklenemez
        System.out.println("  Generic liste: " + safe);
        System.out.println();
    }

    private static void genericRepoOrnek() {
        System.out.println("[20.4] Generic repository örneği");
        Repository<Student> studentRepo = new Repository<>();
        studentRepo.add(new Student("Ali", 3.5));
        studentRepo.add(new Student("Zeynep", 3.9));
        System.out.println("  Repo boyutu: " + studentRepo.size());
        studentRepo.displayAll();
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 20 özeti ===");
        System.out.println("<T> generic class | generic method | type safety | Repository<T>");
    }

    static class Box<T> {
        private T value;

        Box(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    }

    static class Repository<T> {
        private final ArrayList<T> items = new ArrayList<>();

        void add(T item) {
            items.add(item);
        }

        int size() {
            return items.size();
        }

        void displayAll() {
            for (T item : items) {
                System.out.println("    " + item);
            }
        }
    }

    static class Student {
        private final String name;
        private final double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            return name + " GPA=" + gpa;
        }
    }
}
