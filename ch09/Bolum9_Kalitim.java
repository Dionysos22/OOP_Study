package ch09;

/**
 * Bölüm 9: Inheritance (Slayt 9)
 *
 * Çalıştırma:
 *   java -cp . ch09.Bolum9_Kalitim
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
        System.out.println("=== Bölüm 9: Kalıtım (Inheritance) ===\n");
    }

    private static void extendsOrnek() {
        System.out.println("[9.1–9.3] extends ve alt sınıf");
        /*
         * class Dog extends Animal  → Dog, Animal'ın alan/metotlarını miras alır.
         * Java'da tek sınıf kalıtımı: bir sınıf yalnızca bir sınıftan extend edebilir.
         */
        Dog d = new Dog("Karabaş", 4);
        System.out.println("  " + d.describe());
        System.out.println("  Yaş: " + d.getAge());
        System.out.println();
    }

    private static void superVeConstructor() {
        System.out.println("[9.4] super ve constructor zinciri");
        /*
         * Alt sınıf constructor'ı ilk satırda super(...) çağırmalı (varsayılan hariç).
         */
        Cat c = new Cat("Minnak", 2, true);
        System.out.println("  " + c.describe() + ", indoor=" + c.isIndoor());
        System.out.println();
    }

    private static void overrideOrnek() {
        System.out.println("[9.5] Method overriding (@Override)");
        /*
         * Üst sınıftaki metot alt sınıfta yeniden tanımlanır; imza uyumlu olmalı.
         * @Override: derleyici kontrolü (yazım hatasını yakalar).
         */
        Animal[] zoo = {
                new Dog("Rex", 5),
                new Cat("Luna", 1, false)
        };
        for (Animal a : zoo) {
            System.out.println("  speak → " + a.speak());
        }
        System.out.println();
    }

    private static void protectedNotu() {
        System.out.println("[9.6] protected");
        /*
         * protected: aynı pakette ve alt sınıflardan erişilebilir.
         */
        System.out.println("  Alt sınıf, üst sınıfın protected üyelerine erişir (aynı paket kurallarına dikkat).");
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 9 özeti ===");
        System.out.println("extends | super | @Override | protected | tek kalıtım hattı");
    }

    static class Animal {
        protected String name;
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

        public String speak() {
            return "...";
        }
    }

    static class Dog extends Animal {
        public Dog(String name, int age) {
            super(name, age);
        }

        @Override
        public String speak() {
            return "Hav hav!";
        }
    }

    static class Cat extends Animal {
        private final boolean indoor;

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
