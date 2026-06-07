package ch16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Bölüm 16 — Generic Collections (Slides/16.pdf)
 *
 * Slayt 16: List, Set, Map, Iterator, Collections yardımcı metotları.
 * ch07'de ArrayList temeli var; burada koleksiyon hiyerarşisi derinleşir.
 *
 * Kitap referans: Deitel Ch.16 (slayt yeterli değilse)
 *
 * Çalıştırma:
 *   java -cp . ch16.Bolum16_GenericCollections
 */
public class Bolum16_GenericCollections {

    public static void main(String[] args) {
        intro();
        listOrnekleri();
        setOrnekleri();
        mapOrnekleri();
        iteratorOrnek();
        collectionsSort();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 16: Generic Collections (Slayt 16) ===\n");
    }

    private static void listOrnekleri() {
        System.out.println("[16.1] List — ArrayList vs LinkedList");
        /*
         * List<E>: sıralı, tekrarlı eleman olabilir.
         * ArrayList → hızlı rastgele erişim (get)
         * LinkedList → ekleme/silmede avantaj
         */
        List<String> array = new ArrayList<>();
        array.add("Ali");
        array.add("Zeynep");
        array.add("Ali"); // tekrar OK

        List<String> linked = new LinkedList<>();
        linked.add("B");
        linked.add("A");

        System.out.println("  ArrayList: " + array);
        System.out.println("  LinkedList: " + linked);
        System.out.println();
    }

    private static void setOrnekleri() {
        System.out.println("[16.2] Set — HashSet vs TreeSet");
        /*
         * Set<E>: tekrarsız eleman. HashSet sırasız, TreeSet sıralı.
         */
        Set<Integer> hash = new HashSet<>();
        hash.add(3);
        hash.add(1);
        hash.add(3); // eklenmez
        System.out.println("  HashSet: " + hash);

        Set<String> tree = new TreeSet<>();
        tree.add("Java");
        tree.add("C++");
        tree.add("Python");
        System.out.println("  TreeSet (sıralı): " + tree);
        System.out.println();
    }

    private static void mapOrnekleri() {
        System.out.println("[16.3] Map — HashMap");
        /*
         * Map<K,V>: anahtar-değer. Aynı key ikinci kez put → değer güncellenir.
         */
        Map<String, Double> gpaMap = new HashMap<>();
        gpaMap.put("Ali", 3.5);
        gpaMap.put("Zeynep", 3.9);
        gpaMap.put("Ali", 3.6); // güncelleme

        System.out.println("  Zeynep GPA: " + gpaMap.get("Zeynep"));
        System.out.println("  Tüm map: " + gpaMap);
        System.out.println();
    }

    private static void iteratorOrnek() {
        System.out.println("[16.4] Iterator");
        List<String> names = List.of("Ada", "Bora", "Cem");
        Iterator<String> it = names.iterator();
        System.out.print("  Iterator ile: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");
    }

    private static void collectionsSort() {
        System.out.println("[16.5] Collections.sort + Comparable");
        /*
         * Collections.sort(list) → eleman Comparable implement etmeli
         */
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ali", 3.2));
        students.add(new Student("Zeynep", 3.9));
        students.add(new Student("Can", 2.8));

        Collections.sort(students);
        System.out.println("  GPA azalan:");
        for (Student s : students) {
            System.out.println("    " + s);
        }
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 16 özeti ===");
        System.out.println("List | Set | Map | Iterator | Collections.sort | Comparable");
    }

    static class Student implements Comparable<Student> {
        private final String name;
        private final double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        @Override
        public int compareTo(Student other) {
            return Double.compare(other.gpa, this.gpa);
        }

        @Override
        public String toString() {
            return name + " (" + gpa + ")";
        }
    }
}
