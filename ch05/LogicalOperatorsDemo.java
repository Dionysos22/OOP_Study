package ch05;

/**
 * Mantıksal operatörler ve short-circuit davranışı.
 *
 * Short-circuit (kısa devre) kuralı:
 * - `A && B` ifadesinde A false ise B çalıştırılmaz.
 * - `A || B` ifadesinde A true ise B çalıştırılmaz.
 *
 * Bu davranış, bazı durumlarda hatayı önler (ör. 0'a bölme) ve performans sağlar.
 */
public class LogicalOperatorsDemo {
    public static void main(String[] args) {
        int age = 17;
        boolean hasCard = false;

        boolean canGetDiscount = (age < 18) || hasCard;
        System.out.println("discount? " + canGetDiscount);

        int x = 0;
        // x != 0 false olduğu için sağ taraf çalışmaz -> divide by zero olmaz.
        boolean safe = (x != 0) && (10 / x > 1);
        System.out.println("safe? " + safe);

        System.out.println("!true => " + (!true));
    }
}

