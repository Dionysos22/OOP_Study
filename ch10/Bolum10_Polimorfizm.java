package ch10;

/**
 * Bölüm 10 — Polymorphism and Interfaces (Slayt 10)
 *
 * NE ÖĞRENECEKSİN?
 * - Polimorfizm: üst tip referansı, alt tip nesne (Employee e = new SalariedEmployee(...))
 * - Dynamic binding: hangi metot çalışır → nesnenin GERÇEK tipine göre
 * - abstract class: new yapılamaz, soyut metot zorunlu override
 * - interface: sözleşme (implements), çoklu interface mümkün
 * - instanceof: güvenli tür kontrolü + downcast (Java 16+ pattern: instanceof Tip t)
 *
 * abstract vs interface (kısa):
 *   abstract  → ortak kod + zorunlu metotlar, tek extends
 *   interface → sadece sözleşme, ortak kod yok (Java 8+ default var ama slayt odak farklı)
 *
 * UML: extends ──▷   implements ─ ─ ▷
 *
 * Slayt: Slides/10.pdf  ·  Sonraki: ch11
 *
 * Çalıştırma: java -cp . ch10.Bolum10_Polimorfizm
 */
public class Bolum10_Polimorfizm {

    public static void main(String[] args) {
        intro();
        ustTipReferans();
        dynamicBinding();
        abstractClassOrnek();
        interfaceOrnek();
        instanceofOrnek();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 10: Polimorfizm ve arayüzler (Slayt 10) ===");
        System.out.println("Aynı referans tipi, farklı nesne tipleri — tek döngüde hepsini işle.");
        System.out.println("abstract | interface | instanceof — finalin omurgası.\n");
    }

    private static void ustTipReferans() {
        System.out.println("[10.1] Üst tip referansı");
        /*
         *   Employee e = new SalariedEmployee("Ayşe", 50000);
         *
         * Referans tipi:  Employee     (sol taraf — derleyici bunu bilir)
         * Nesne tipi:       SalariedEmployee  (sağ taraf — çalışma anında bu)
         *
         * e.monthlyPay() çağrısı → SalariedEmployee sürümü çalışır (dynamic binding)
         *
         * Sınav output: Employee[] dizisi, döngüde farklı alt sınıflar, toplam maaş
         */
        Employee e1 = new SalariedEmployee("Ayşe", 50000);
        Employee e2 = new HourlyEmployee("Mehmet", 45, 160);
        System.out.println("  " + e1.payDescription());
        System.out.println("  " + e2.payDescription());
        System.out.println();
    }

    private static void dynamicBinding() {
        System.out.println("[10.2] Dynamic binding (geç bağlama)");
        /*
         * Derleme anında: e tipi Employee → Employee'de monthlyPay var mı? ✓
         * Çalışma anında: e'nin gerçek nesnesi HourlyEmployee → onun monthlyPay'i çalışır
         *
         * Bu yüzden:
         *   Employee[] staff = { new SalariedEmployee(...), new HourlyEmployee(...) };
         *   for (Employee e : staff) e.monthlyPay();  ← her biri kendi hesabını yapar
         *
         * Polimorfizmin özü budur — if/else ile tip kontrolüne gerek kalmaz.
         */
        Employee[] staff = {
                new SalariedEmployee("Zeynep", 60000),
                new HourlyEmployee("Can", 50, 140)
        };
        double total = 0;
        for (Employee e : staff) {
            total += e.monthlyPay();
            System.out.println("  " + e.getName() + " → " + e.monthlyPay() + " TL/ay");
        }
        System.out.println("  Toplam aylık ödeme: " + total);
        System.out.println();
    }

    private static void abstractClassOrnek() {
        System.out.println("[10.3] abstract class (soyut sınıf)");
        /*
         *   abstract class Shape {
         *       public abstract double area();
         *   }
         *
         * new Shape()  → DERLEME HATASI (soyut sınıftan nesne yok)
         * new Circle(2) → OK
         *
         * Alt sınıf abstract metodu @Override ile MUTLAKA implement etmeli.
         *
         * UML: Shape {abstract}, area() {abstract}
         * Sınav: Shape[] = { new Circle(...), new Rectangle(...) }; toplam alan
         */
        Shape[] shapes = {
                new Circle(2.0),
                new Rectangle(3, 4)
        };
        for (Shape s : shapes) {
            System.out.printf("  %s alan = %.2f%n", s.getClass().getSimpleName(), s.area());
        }
        System.out.println();
    }

    private static void interfaceOrnek() {
        System.out.println("[10.4] interface (arayüz)");
        /*
         *   interface Notifier {
         *       void notifyUser(String message);
         *   }
         *
         * class EmailNotifier implements Notifier { ... }
         *
         * Interface = "şu metodu yazmak ZORUNDASIN" sözleşmesi.
         * Ortak alan/kod yok (sadece public static final sabitler olabilir).
         *
         * Bir sınıf:  extends TekUst  +  implements A, B, C  (çoklu interface)
         *
         * Polimorfizm: Notifier n = new EmailNotifier(); n.notifyUser("...");
         */
        Notifier email = new EmailNotifier();
        Notifier sms = new SmsNotifier();
        sendAll(new Notifier[] { email, sms }, "Ödeme onaylandı");
        System.out.println();
    }

    private static void sendAll(Notifier[] notifiers, String message) {
        for (Notifier n : notifiers) {
            n.notifyUser(message); // hangi implementasyon ise o çalışır
        }
    }

    private static void instanceofOrnek() {
        System.out.println("[10.5] instanceof ve güvenli downcast");
        /*
         * Üst tip referansı → alt tip metoduna/alanına ihtiyaç varsa downcast gerekir.
         *
         * YANLIŞ (tehlikeli):
         *   HourlyEmployee h = (HourlyEmployee) e;  // e aslında Salaried ise CRASH
         *
         * DOĞRU:
         *   if (e instanceof HourlyEmployee h) {
         *       h.getHours();  // Java 16+ pattern — otomatik cast
         *   }
         *
         * Eski stil:
         *   if (e instanceof HourlyEmployee) {
         *       HourlyEmployee h = (HourlyEmployee) e;
         *   }
         */
        Employee e = new HourlyEmployee("Deniz", 40, 100);
        if (e instanceof HourlyEmployee h) {
            System.out.println("  Saatlik çalışan: " + h.getHours() + " saat/ay");
        }
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 10 özeti ===");
        System.out.println("üst tip ref | dynamic binding | abstract | interface | instanceof");
    }

    abstract static class Employee {
        private final String name;

        protected Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        /** Alt sınıflar kendi maaş hesabını yazar. */
        public abstract double monthlyPay();

        public String payDescription() {
            return name + " → " + monthlyPay() + " TL/ay";
        }
    }

    static class SalariedEmployee extends Employee {
        private final double annualSalary;

        public SalariedEmployee(String name, double annualSalary) {
            super(name);
            this.annualSalary = annualSalary;
        }

        @Override
        public double monthlyPay() {
            return annualSalary / 12.0;
        }
    }

    static class HourlyEmployee extends Employee {
        private final double hourlyRate;
        private final int hours;

        public HourlyEmployee(String name, double hourlyRate, int hours) {
            super(name);
            this.hourlyRate = hourlyRate;
            this.hours = hours;
        }

        public int getHours() {
            return hours;
        }

        @Override
        public double monthlyPay() {
            return hourlyRate * hours;
        }
    }

    abstract static class Shape {
        public abstract double area();
    }

    static class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends Shape {
        private final double w;
        private final double h;

        public Rectangle(double w, double h) {
            this.w = w;
            this.h = h;
        }

        @Override
        public double area() {
            return w * h;
        }
    }

    interface Notifier {
        void notifyUser(String message);
    }

    static class EmailNotifier implements Notifier {
        @Override
        public void notifyUser(String message) {
            System.out.println("  [Email] " + message);
        }
    }

    static class SmsNotifier implements Notifier {
        @Override
        public void notifyUser(String message) {
            System.out.println("  [SMS] " + message);
        }
    }
}
