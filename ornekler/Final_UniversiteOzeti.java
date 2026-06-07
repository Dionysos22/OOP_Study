package ornekler;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Lab 8 özet pratiği — sınavda hatırlanacak iskelet.
 *
 * Kendi pratiğin: dosyayı kapat, aynı yapıyı sıfırdan yaz.
 *
 * Çalıştırma:
 *   java -cp . ornekler.Final_UniversiteOzeti
 */
public class Final_UniversiteOzeti {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        try {
            people.add(new Student(1, "Ayse", 3.5));
            people.add(new Student(2, "Mehmet", 3.9));
            people.add(new Professor(10, "Dr. A", 30000, 2));
        } catch (InvalidGPAException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Members ---");
        for (Person p : people) {
            p.displayInfo();
        }

        System.out.println("--- Salaries ---");
        for (Person p : people) {
            if (p instanceof AcademicStaff staff) {
                System.out.println(staff.getName() + ": " + staff.calculateSalary());
            }
        }

        ArrayList<Student> students = new ArrayList<>();
        for (Person p : people) {
            if (p instanceof Student s) {
                students.add(s);
            }
        }
        Collections.sort(students);
        System.out.println("--- Students by GPA ---");
        for (Student s : students) {
            System.out.println(s.getName() + " " + s.getGpa());
        }
    }

    abstract static class Person {
        private final int id;
        private final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        String getName() {
            return name;
        }

        abstract void displayInfo();
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
        private final double gpa;

        Student(int id, String name, double gpa) throws InvalidGPAException {
            super(id, name);
            if (gpa < 0 || gpa > 4) {
                throw new InvalidGPAException("GPA must be between 0 and 4.");
            }
            this.gpa = gpa;
        }

        double getGpa() {
            return gpa;
        }

        @Override
        void displayInfo() {
            System.out.println("Student " + getName() + " GPA=" + gpa);
        }

        @Override
        public int compareTo(Student other) {
            return Double.compare(other.gpa, this.gpa);
        }
    }

    static class AcademicStaff extends Person implements Payable {
        protected final double baseSalary;

        AcademicStaff(int id, String name, double baseSalary) {
            super(id, name);
            this.baseSalary = baseSalary;
        }

        @Override
        public double calculateSalary() {
            return baseSalary;
        }

        @Override
        void displayInfo() {
            System.out.println("Staff " + getName());
        }
    }

    static class Professor extends AcademicStaff {
        private final int papers;

        Professor(int id, String name, double baseSalary, int papers) {
            super(id, name, baseSalary);
            this.papers = papers;
        }

        @Override
        public double calculateSalary() {
            return baseSalary + papers * 1000;
        }

        @Override
        void displayInfo() {
            System.out.println("Professor " + getName());
        }
    }
}
