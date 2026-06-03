package ornekler;

/**
 * Final sınav tarzı örnek: Soyut sınıf + kalıtım + polimorfizm
 *
 * Sık soru kalıbı: Shape / Circle / Rectangle, area() override,
 * Shape[] dizisi üzerinde döngü ile toplam alan.
 *
 * Çalıştırma:
 *   javac ornekler/Final_SekilOrnegi.java
 *   java -cp . ornekler.Final_SekilOrnegi
 *
 * Kendi pratiğin: Bu dosyayı kapat, aynı yapıyı sıfırdan yazmayı dene.
 */
public class Final_SekilOrnegi {

    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle("Daire-1", 3.0),
                new Rectangle("Dörtgen-1", 4, 5),
                new Circle("Daire-2", 1.5)
        };

        double totalArea = 0;
        for (Shape s : shapes) {
            System.out.println(s.describe());
            totalArea += s.area();
        }
        System.out.printf("%nToplam alan = %.2f%n", totalArea);
    }

    abstract static class Shape {
        private final String label;

        protected Shape(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public abstract double area();

        public String describe() {
            return getLabel() + " → alan=" + String.format("%.2f", area());
        }
    }

    static class Circle extends Shape {
        private final double radius;

        public Circle(String label, double radius) {
            super(label);
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends Shape {
        private final double width;
        private final double height;

        public Rectangle(String label, double width, double height) {
            super(label);
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }
    }
}
