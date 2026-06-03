package ch10;

/**
 * Bölüm 10: Polymorphism and Interfaces
 *
 * Lab 6: GameCharacter referansıyla Warrior/Wizard
 * Lab 7: PaymentProcessor referansıyla somut processor'lar
 *
 * Çalıştırma:
 *   javac ch10/Bolum10_Polimorfizm.java
 *   java -cp . ch10.Bolum10_Polimorfizm
 */
public class Bolum10_Polimorfizm {

    public static void main(String[] args) {
        intro();
        ustTipReferans();
        dynamicBinding();
        abstractClassOrnek();
        interfaceOrnek();
        instanceofOrnek();
        labBaglantisi();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 10: Polimorfizm ve arayüzler ===\n");
    }

    private static void ustTipReferans() {
        System.out.println("[10.1] Üst tip referansı");
        /*
         * Employee e = new SalariedEmployee(...);
         * Referans tipi Employee, nesne SalariedEmployee → polimorfik kullanım.
         */
        Employee e1 = new SalariedEmployee("Ayşe", 50000);
        Employee e2 = new HourlyEmployee("Mehmet", 45, 160);
        System.out.println("  " + e1.payDescription());
        System.out.println("  " + e2.payDescription());
        System.out.println();
    }

    private static void dynamicBinding() {
        System.out.println("[10.2] Dynamic binding (çalışma anında bağlama)");
        /*
         * e.payDescription() çağrısı → nesnenin GERÇEK tipindeki metot çalışır.
         * Lab 7: PaymentProcessor p = factory...; p.processPayment() → hangi sınıf
         * ise o sınıfın processPayment'ı çalışır.
         */
        Employee[] staff = {
                new SalariedEmployee("Zeynep", 60000),
                new HourlyEmployee("Can", 50, 140)
        };
        double total = 0;
        for (Employee e : staff) {
            total += e.monthlyPay();
            System.out.println("  " + e.getName() + " → " + e.monthlyPay());
        }
        System.out.println("  Toplam aylık ödeme: " + total);
        System.out.println();
    }

    private static void abstractClassOrnek() {
        System.out.println("[10.3] abstract class");
        /*
         * abstract sınıf: hem ortak kod hem soyut metot tanımlanabilir.
         * Soyut metot somut alt sınıfta @Override ile yazılmalı.
         * new Shape() doğrudan yapılamaz; Circle, Rectangle yapılabilir.
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
        System.out.println("[10.4] interface");
        /*
         * interface: sözleşme; implements eden sınıf tüm metotları yazmalı.
         * Çoklu interface mümkün; çoklu extends yok (sınıf için).
         * Lab 7: implements PaymentProcessor
         */
        Notifier email = new EmailNotifier();
        Notifier sms = new SmsNotifier();
        sendAll(new Notifier[] { email, sms }, "Ödeme onaylandı");
        System.out.println();
    }

    private static void sendAll(Notifier[] notifiers, String message) {
        for (Notifier n : notifiers) {
            n.notifyUser(message);
        }
    }

    private static void instanceofOrnek() {
        System.out.println("[10.5] instanceof ve pattern matching");
        /*
         * Lab 6 DuelRPG:
         *   if (c instanceof Wizard w) return w.getMana() == 0;
         * Tür kontrolü + güvenli downcast (Java 16+ pattern).
         */
        Employee e = new HourlyEmployee("Deniz", 40, 100);
        if (e instanceof HourlyEmployee h) {
            System.out.println("  Saatlik çalışan: " + h.getHours() + " saat");
        }
        System.out.println();
    }

    private static void labBaglantisi() {
        System.out.println("[Lab bağlantısı]");
        System.out.println("  Lab 6: GameCharacter hedef/saldıran — override attack");
        System.out.println("  Lab 7: PaymentProcessor processor — interface polimorfizm");
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
