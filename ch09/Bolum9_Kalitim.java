package ch09;

/**
 * Bölüm 9 — Inheritance / Kalıtım (Slayt 9)
 *
 * NE ÖĞRENECEKSİN?
 * - extends: alt sınıf üst sınıfın alan/metotlarını miras alır ("is-a" ilişkisi)
 * - super(...): alt sınıf ctor'da üst sınıf ctor'ını çağırır — İLK SATIRDA olmalı
 * - @Override: üst sınıftaki metodu alt sınıfta yeniden tanımlama
 * - protected: alt sınıfların erişebildiği görünürlük
 *
 * Java'da TEK kalıtım: bir sınıf yalnızca bir sınıftan extend edebilir.
 * (Interface'ten birden fazla implements edilebilir — ch10)
 *
 * UML: AltSınıf ──▷ UstSınıf  (düz ok, boş üçgen uçta)
 *
 * Slayt: Slides/9.pdf  ·  Sonraki: ch10
 *
 * Çalıştırma: java -cp . ch09.Bolum9_Kalitim
 */
public class Bolum9_Kalitim {

    public static void main(String[] args) {
        intro();
        extendsOrnek();
        superVeConstructor();
        overrideOrnek();
        protectedNotu();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 9: Kalıtım (Slayt 9) ===");
        System.out.println("Dog extends Animal → Dog BİR Animal'dır.");
        System.out.println("super() | @Override | protected — sınavın üçlüsü.\n");
    }

    private static void extendsOrnek() {
        System.out.println("[9.1–9.3] extends — miras alma");
        /*
         *   class Dog extends Animal { ... }
         *
         * Dog şunları alır:
         *   - Animal'daki protected/public alanlar (name, age)
         *   - Animal'daki metotlar (describe, getAge)
         *   - Kendi ek alan/metotlarını da tanımlayabilir (speak override)
         *
         * "is-a" testi: Dog bir Animal mı? → Evet.
         *
         * Sınav: hangi alan/metot nereden gelir, alt sınıf ne ekler?
         */
        Dog d = new Dog("Karabaş", 4);
        System.out.println("  " + d.describe());  // Animal'dan miras
        System.out.println("  Yaş: " + d.getAge());
        System.out.println("  Konuş: " + d.speak()); // Dog'un override'ı
        System.out.println();
    }

    private static void superVeConstructor() {
        System.out.println("[9.4] super(...) — constructor zinciri");
        /*
         * Alt sınıf oluşturulurken ÖNCE üst sınıf ctor çalışmalı.
         *
         *   public Cat(String name, int age, boolean indoor) {
         *       super(name, age);   ← İLK SATIR (zorunlu kural)
         *       this.indoor = indoor;
         *   }
         *
         * super() yazmazsan Java üst sınıfın varsayılan ctor'ını dener.
         * Üst sınıfta varsayılan yoksa → derleme hatası.
         *
         * Sınav tuzağı: super() ikinci satıra yazılırsa derleme hatası.
         */
        Cat c = new Cat("Minnak", 2, true);
        System.out.println("  " + c.describe() + ", indoor=" + c.isIndoor());
        System.out.println();
    }

    private static void overrideOrnek() {
        System.out.println("[9.5] Method overriding (@Override)");
        /*
         * Üst sınıfta:  public String speak() { return "..."; }
         * Alt sınıfta:   @Override public String speak() { return "Hav hav!"; }
         *
         * @Override ne işe yarar?
         *   - Derleyici "gerçekten üst metodu eziyor musun?" diye kontrol eder
         *   - Yazım hatası (speek) yakalanır
         *
         * Polimorfizm (ch10): Animal a = new Dog(...); a.speak() → "Hav hav!"
         * Çünkü çalışma anında GERÇEK tip Dog'tur.
         */
        Animal[] zoo = {
                new Dog("Rex", 5),
                new Cat("Luna", 1, false)
        };
        for (Animal a : zoo) {
            System.out.println("  " + a.describe() + " → " + a.speak());
        }
        System.out.println();
    }

    private static void protectedNotu() {
        System.out.println("[9.6] protected erişim");
        /*
         * Görünürlük karşılaştırması:
         *
         *   private   → sadece aynı sınıf
         *   protected → aynı paket + TÜM alt sınıflar (paket dışı olsa bile)
         *   public    → her yerden
         *
         * Kalıtımda üst sınıf alanları genelde protected bırakılır ki
         * alt sınıf doğrudan erişebilsin (veya getter kullanılır).
         */
        System.out.println("  Alt sınıf, üst sınıfın protected name/age alanına erişir.");
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 9 özeti ===");
        System.out.println("extends | super() ilk satır | @Override | protected | tek extends hattı");
    }

    /** Üst sınıf — ortak alan ve davranış. */
    static class Animal {
        protected String name;  // protected: alt sınıflar erişir
        protected int age;

        public Animal(String name, int age) {
            this.name = name == null ? "" : name;
            this.age = Math.max(0, age);
        }

        public String describe() {
            return name + " (" + age + " yaş)";
        }

        public int getAge() {
            return age;
        }

        /** Alt sınıflar override edecek — varsayılan sessiz. */
        public String speak() {
            return "...";
        }
    }

    static class Dog extends Animal {
        public Dog(String name, int age) {
            super(name, age); // üst ctor — ilk satır
        }

        @Override
        public String speak() {
            return "Hav hav!";
        }
    }

    static class Cat extends Animal {
        private final boolean indoor; // Cat'e özel alan

        public Cat(String name, int age, boolean indoor) {
            super(name, age);
            this.indoor = indoor;
        }

        public boolean isIndoor() {
            return indoor;
        }

        @Override
        public String speak() {
            return "Miyav!";
        }
    }
}
