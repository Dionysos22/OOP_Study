package ch13;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Bölüm 13: Lab 8 — University Management System (final özeti)
 *
 * Lab 8'deki sınav konularını tek dosyada toplar:
 * abstract sınıf, interface + kalıtım, Comparable, generic repository,
 * custom checked exception, instanceof downcast, dosya yazma.
 *
 * Lab notları: lab/LAB_SINAV_NOTLARI.txt
 *
 * Çalıştırma:
 *   javac ch13/Bolum13_Lab8Universite.java
 *   java -cp . ch13.Bolum13_Lab8Universite
 */
public class Bolum13_Lab8Universite {

    public static void main(String[] args) {
        intro();
        nesneOlusturma();
        polimorfikYazdirma();
        instanceofMaas();
        siralama();
        genericRepo();
        dosyaYazma();
        gecersizGpa();
        lab8YolHaritasi();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bölüm 13: Lab 8 — Üniversite Yönetimi ===\n");
    }

    private static ArrayList<Person> ornekListe() {
        ArrayList<Person> people = new ArrayList<>();
        try {
            people.add(new Student(1, "Ali", "CS", 3.9));
            people.add(new Student(2, "Zeynep", "SE", 2.5));
            people.add(new Professor(10, "Dr. X", "Prof.", 30000, 3));
            people.add(new ResearchAssistant(20, "Asst. Y", "RA", 20000, 2));
        } catch (InvalidGPAException e) {
            System.out.println("  Hata: " + e.getMessage());
        }
        return people;
    }

    private static void nesneOlusturma() {
        System.out.println("[13.1] Nesne oluşturma + checked exception");
        /*
         * Student constructor throws InvalidGPAException → try-catch zorunlu.
         * new Person() YAZILAMAZ — Person abstract.
         */
        ArrayList<Person> people = ornekListe();
        System.out.println("  Oluşturulan üye sayısı: " + people.size());
        System.out.println();
    }

    private static void polimorfikYazdirma() {
        System.out.println("[13.2] Polimorfizm — ArrayList<Person>");
        ArrayList<Person> people = ornekListe();
        for (Person p : people) {
            p.displayInfo();
        }
        System.out.println();
    }

    private static void instanceofMaas() {
        System.out.println("[13.3] instanceof + downcast + Payable");
        ArrayList<Person> people = ornekListe();
        for (Person p : people) {
            if (p instanceof AcademicStaff staff) {
                System.out.println("  " + staff.getName() + " → maaş: " + staff.calculateSalary());
            }
        }
        System.out.println();
    }

    private static void siralama() {
        System.out.println("[13.4] Comparable + Collections.sort");
        ArrayList<Student> students = new ArrayList<>();
        for (Person p : ornekListe()) {
            if (p instanceof Student s) {
                students.add(s);
            }
        }
        Collections.sort(students);
        for (Student s : students) {
            System.out.println("  " + s.getName() + " GPA=" + s.getGpa());
        }
        System.out.println();
    }

    private static void genericRepo() {
        System.out.println("[13.5] Generic repository UniversityRepository<T>");
        UniversityRepository<Student> repo = new UniversityRepository<>();
        try {
            repo.add(new Student(3, "Can", "Math", 3.0));
        } catch (InvalidGPAException e) {
            System.out.println("  " + e.getMessage());
        }
        System.out.println("  Repo boyutu: " + repo.size());
        System.out.println();
    }

    private static void dosyaYazma() {
        System.out.println("[13.6] FileWriter + IOException (checked)");
        ArrayList<Student> students = new ArrayList<>();
        for (Person p : ornekListe()) {
            if (p instanceof Student s) {
                students.add(s);
            }
        }
        try (FileWriter w = new FileWriter("students_practice.txt")) {
            for (Student s : students) {
                w.write(s.getId() + " | " + s.getName() + " | GPA: " + s.getGpa() + "\n");
            }
            System.out.println("  students_practice.txt yazıldı.");
        } catch (IOException e) {
            System.out.println("  Dosya hatası: " + e.getMessage());
        }
        System.out.println();
    }

    private static void gecersizGpa() {
        System.out.println("[13.7] Geçersiz GPA — custom exception");
        try {
            new Student(99, "Hatali", "X", 5.5);
        } catch (InvalidGPAException e) {
            System.out.println("  Yakalandı: " + e.getMessage());
        }
        System.out.println();
    }

    private static void lab8YolHaritasi() {
        System.out.println("[Lab 8 yapısı]");
        System.out.println("  Person (abstract) → Student | AcademicStaff (+ Payable)");
        System.out.println("  AcademicStaff → Professor | ResearchAssistant");
        System.out.println("  + InvalidGPAException, UniversityRepository<T>, FileWriter");
        System.out.println("  Detay: lab/LAB_SINAV_NOTLARI.txt");
        System.out.println();
    }

    private static void ozet() {
        System.out.println("=== Bölüm 13 özeti ===");
        System.out.println("abstract Person | Payable | Comparable<Student>");
        System.out.println("instanceof | generic repo | FileWriter | UML: uml/UML_Calisma.txt");
    }

    public abstract static class Person {
        private final int id;
        private final String name;

        protected Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public abstract void displayInfo();
    }

    interface Payable {
        double calculateSalary();
    }

    static class InvalidGPAException extends Exception {
        InvalidGPAException(String message) {
            super(message);
        }
    }

    static class Student extends Person implements Comparable<Student> {
        private final String department;
        private final double gpa;

        Student(int id, String name, String department, double gpa) throws InvalidGPAException {
            super(id, name);
            if (gpa < 0 || gpa > 4) {
                throw new InvalidGPAException("GPA must be between 0 and 4.");
            }
            this.department = department;
            this.gpa = gpa;
        }

        public double getGpa() {
            return gpa;
        }

        @Override
        public void displayInfo() {
            System.out.println("  Student: " + getName() + " | " + department + " | GPA=" + gpa);
        }

        @Override
        public int compareTo(Student other) {
            return Double.compare(other.gpa, this.gpa);
        }
    }

    static class AcademicStaff extends Person implements Payable {
        protected final String title;
        protected final double baseSalary;

        AcademicStaff(int id, String name, String title, double baseSalary) {
            super(id, name);
            this.title = title;
            this.baseSalary = baseSalary;
        }

        @Override
        public double calculateSalary() {
            return baseSalary;
        }

        @Override
        public void displayInfo() {
            System.out.println("  Staff: " + getName() + " | " + title);
        }
    }

    static class Professor extends AcademicStaff {
        private final int publishedPapers;

        Professor(int id, String name, String title, double baseSalary, int publishedPapers) {
            super(id, name, title, baseSalary);
            this.publishedPapers = publishedPapers;
        }

        @Override
        public double calculateSalary() {
            return baseSalary + publishedPapers * 1000;
        }

        @Override
        public void displayInfo() {
            System.out.println("  Professor: " + getName() + " | papers=" + publishedPapers);
        }
    }

    static class ResearchAssistant extends AcademicStaff {
        private final int projects;

        ResearchAssistant(int id, String name, String title, double baseSalary, int projects) {
            super(id, name, title, baseSalary);
            this.projects = projects;
        }

        @Override
        public double calculateSalary() {
            return baseSalary + projects * 500;
        }

        @Override
        public void displayInfo() {
            System.out.println("  RA: " + getName() + " | projects=" + projects);
        }
    }

    static class UniversityRepository<T> {
        private final ArrayList<T> items = new ArrayList<>();

        void add(T item) {
            items.add(item);
        }

        int size() {
            return items.size();
        }
    }
}
