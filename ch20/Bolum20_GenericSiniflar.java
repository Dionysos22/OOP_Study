package ch20;

import java.util.ArrayList;

/**
 * Bölüm 20 — Generic Classes and Methods (Slayt 20)
 *
 * NE ÖĞRENECEKSİN?
 * - Generic (jenerik): <T> tip parametresi — çalışma zamanında değil derlemede tip güvenliği
 * - Generic sınıf: class Box<T> { T value; }
 * - Generic metot: <T> void printArray(T[] arr)
 * - Raw type kullanma: ArrayList list = new ArrayList(); ← tip güvenliği yok
 *
 * NEDEN GENERIC?
 *   Object her şeyi tutar ama cast gerekir, hata runtime'da çıkar.
 *   Box<String> sadece String tutar — yanlış tip derlemede yakalanır.
 *
 * ch16'daki List<String>, ch20'deki Box<T> aynı fikir.
 *
 * Slayt: Slides/20.pdf
 *
 * Çalıştırma: java -cp . ch20.Bolum20_GenericSiniflar
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
        System.out.println("=== Bölüm 20: Generic Classes and Methods (Slayt 20) ===");
        System.out.println("<T> = tip parametresi | derleyici tip kontrolü yapar");
        System.out.println("Box<String>, Repository<Student>, ArrayList<Integer> — hepsi generic.\n");
    }

    private static void genericSinif() {
        System.out.println("[20.1] Generic sınıf — Box<T>");
        /*
         *   class Box<T> {
         *       private T value;
         *       T get() { return value; }
         *   }
         *
         * Kullanım:
         *   Box<String> s = new Box<>("Merhaba");  → T = String
         *   Box<Integer> n = new Box<>(42);        → T = Integer
         *
         * <> diamond operator (Java 7+): sağ tarafta tip tekrar yazılmaz.
         *
         * s.get() → String döner, cast gerekmez.
         */
        Box<String> stringBox = new Box<>("Merhaba");
        Box<Integer> intBox = new Box<>(42);

        System.out.println("  stringBox: " + stringBox.get());
        System.out.println("  intBox: " + intBox.get());
        System.out.println();
    }

    private static void genericMetot() {
        System.out.println("[20.2] Generic metot — <T> printArray");
        /*
         *   static <T> void printArray(T[] array) { ... }
         *          ↑
         *   metot seviyesinde tip parametresi (sınıf generic olmasa bile)
         *
         * Aynı metot Integer[], String[], Double[] için çalışır — kod tekrarı yok.
         *
         * Derleyici çağrıdaki argümandan T'yi çıkarır (type inference).
         */
        Integer[] nums = { 1, 2, 3 };
        String[] words = { "a", "b" };
        printArray(nums);
        printArray(words);
        System.out.println();
    }

    /** Generic metot — T tipinde dizi yazdırır. */
    private static <T> void printArray(T[] array) {
        System.out.print("  printArray: ");
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static void typeSafety() {
        System.out.println("[20.3] Tip güvenliği — raw type KULLANMA");
        /*
         * ESKİ (kötü):
         *   ArrayList list = new ArrayList();
         *   list.add("metin");
         *   list.add(123);        // derleme hatası YOK
         *   String s = (String) list.get(1);  // ClassCastException!
         *
         * DOĞRU:
         *   ArrayList<String> list = new ArrayList<>();
         *   list.add("metin");
         *   list.add(123);        // DERLEME HATASI ✓
         *
         * Generic'in asıl faydası: hatayı erken yakala.
         */
        ArrayList<String> safe = new ArrayList<>();
        safe.add("Java");
        // safe.add(123);  // ← derleyici reddeder
        System.out.println("  Generic liste: " + safe);
        System.out.println();
    }

    private static void genericRepoOrnek() {
        System.out.println("[20.4] Generic repository — tek kod, farklı tipler");
        /*
         *   class Repository<T> {
         *       ArrayList<T> items;
         *       void add(T item) { ... }
         *   }
         *
         * Repository<Student>  → sadece Student
         * Repository<String>   → sadece String
         *
         * Aynı add/remove/size mantığı her tip için tekrar yazılmaz.
         * ch16 List<T> fikrinin sınıf tasarımına uygulanmış hali.
         */
        Repository<Student> studentRepo = new Repository<>();
        studentRepo.add(new Student("Ali", 3.5));
        studentRepo.add(new Student("Zeynep", 3.9));
        System.out.println("  Repo boyutu: " + studentRepo.size());
        studentRepo.displayAll();
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 20 özeti ===");
        System.out.println("class Box<T> | <T> metot | diamond <> | raw type yok | Repository<T>");
    }

    /** Generic sınıf — T tipinde tek değer tutar. */
    static class Box<T> {
        private T value;

        Box(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    }

    /** Generic depo — tip güvenli ArrayList sarmalayıcı. */
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
