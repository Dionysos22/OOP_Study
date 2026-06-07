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
 * Bölüm 16 — Generic Collections (Slayt 16)
 *
 * NE ÖĞRENECEKSİN?
 * - List: sıralı, tekrarlı (ArrayList, LinkedList)
 * - Set: tekrarsız (HashSet, TreeSet)
 * - Map: anahtar-değer çifti (HashMap)
 * - Iterator: koleksiyonda gezinme
 * - Collections.sort + Comparable
 *
 * ch07'de ArrayList gördün; burada tüm koleksiyon ailesi.
 *
 * Koleksiyon seçimi (pratik):
 *   Sıralı liste, indeks lazım     → ArrayList
 *   Tekrar istemiyorum             → HashSet
 *   Anahtarla hızlı arama          → HashMap
 *   Sıralı tekrarsız               → TreeSet
 *
 * Slayt: Slides/16.pdf  ·  Sonraki: ch17
 *
 * Çalıştırma: java -cp . ch16.Bolum16_GenericCollections
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
        System.out.println("=== Bölüm 16: Generic Collections (Slayt 16) ===");
        System.out.println("List | Set | Map — hangisi ne işe yarar?");
        System.out.println("Collections.sort + Comparable compareTo\n");
    }

    private static void listOrnekleri() {
        System.out.println("[16.1] List — ArrayList vs LinkedList");
        /*
         * List<E> = sıralı koleksiyon, aynı eleman birden fazla olabilir.
         *
         * ArrayList:
         *   - Dizi tabanlı, get(i) hızlı
         *   - Orta/sona ekle-sil yavaş olabilir
         *
         * LinkedList:
         *   - Zincir (node) tabanlı, ekle-sil hızlı
         *   - get(i) yavaş (baştan yürür)
         *
         * İkisi de List interface'ini implement eder → List<String> ref ile tutulabilir.
         */
        List<String> array = new ArrayList<>();
        array.add("Ali");
        array.add("Zeynep");
        array.add("Ali"); // List'te tekrar OK

        List<String> linked = new LinkedList<>();
        linked.add("B");
        linked.add("A");

        System.out.println("  ArrayList (tekrar var): " + array);
        System.out.println("  LinkedList: " + linked);
        System.out.println();
    }

    private static void setOrnekleri() {
        System.out.println("[16.2] Set — HashSet vs TreeSet");
        /*
         * Set<E> = TEKRARSIZ eleman koleksiyonu.
         *
         * hash.add(3); hash.add(3);  → ikinci 3 EKLENMEZ
         *
         * HashSet: sıra garantisi yok, hızlı
         * TreeSet: elemanlar sıralı (Comparable veya Comparator ile)
         *
         * Sınav output: HashSet'e aynı eleman iki kez add → boyut 1 artmaz
         */
        Set<Integer> hash = new HashSet<>();
        hash.add(3);
        hash.add(1);
        hash.add(3); // yok sayılır
        System.out.println("  HashSet (sırasız, tekrarsız): " + hash);

        Set<String> tree = new TreeSet<>();
        tree.add("Java");
        tree.add("C++");
        tree.add("Python");
        System.out.println("  TreeSet (alfabetik sıralı): " + tree);
        System.out.println();
    }

    private static void mapOrnekleri() {
        System.out.println("[16.3] Map — HashMap (anahtar → değer)");
        /*
         * Map<K,V> = her anahtar (key) bir değere (value) bağlı.
         *
         *   put("Ali", 3.5)
         *   get("Ali")  → 3.5
         *   aynı key tekrar put → değer GÜNCELLENİR (yeni eleman değil)
         *
         * Sözlük gibi düşün: isim → GPA
         */
        Map<String, Double> gpaMap = new HashMap<>();
        gpaMap.put("Ali", 3.5);
        gpaMap.put("Zeynep", 3.9);
        gpaMap.put("Ali", 3.6); // Ali'nin GPA'sı güncellenir

        System.out.println("  Zeynep GPA: " + gpaMap.get("Zeynep"));
        System.out.println("  Tüm map: " + gpaMap);
        System.out.println();
    }

    private static void iteratorOrnek() {
        System.out.println("[16.4] Iterator — koleksiyonda gezinme");
        /*
         * Iterator it = list.iterator();
         * while (it.hasNext()) {
         *     String s = it.next();
         * }
         *
         * for-each aslında arka planda Iterator kullanır.
         * Iterator ile döngü sırasında remove() de yapılabilir (ileri seviye).
         */
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
         * Collections.sort(liste) → listenin elemanları Comparable olmalı.
         *
         * compareTo(other) sözleşmesi:
         *   negatif → this, other'dan ÖNCE
         *   0       → eşit
         *   pozitif → this, other'dan SONRA
         *
         * GPA azalan (yüksek önce):
         *   return Double.compare(other.gpa, this.gpa);
         *
         * compareTo'yu sınıfın İÇİNDE tanımlarsın: implements Comparable<Student>
         */
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ali", 3.2));
        students.add(new Student("Zeynep", 3.9));
        students.add(new Student("Can", 2.8));

        Collections.sort(students);
        System.out.println("  GPA azalan sıra:");
        for (Student s : students) {
            System.out.println("    " + s);
        }
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 16 özeti ===");
        System.out.println("List (tekrarlı) | Set (tekrarsız) | Map (key→value)");
        System.out.println("Iterator | Collections.sort | Comparable compareTo");
    }

    /** compareTo ile sıralanabilir öğrenci — GPA yüksek önce. */
    static class Student implements Comparable<Student> {
        private final String name;
        private final double gpa;

        Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        @Override
        public int compareTo(Student other) {
            // other - this → azalan GPA
            return Double.compare(other.gpa, this.gpa);
        }

        @Override
        public String toString() {
            return name + " (" + gpa + ")";
        }
    }
}
