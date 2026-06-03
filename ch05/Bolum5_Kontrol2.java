import java.util.Scanner;

/**
 * Bölüm 5: Control Statements Part 2; Logical Operators
 *
 * Bu bölümde:
 * - for döngüsü (sayaç kontrollü için ideal)
 * - do-while (en az 1 kez çalışır)
 * - switch (çoklu seçim) + String ile kullanım
 * - break/continue
 * - mantıksal operatörler: &&, ||, !
 */
public class Bolum5_Kontrol2 {
    public static void main(String[] args) {
        intro();
        forDongusu();
        forOrnekleri();
        doWhile();
        switchCokluSecim();
        stringSwitchCaseStudy();
        breakContinue();
        logicalOperators();
        yapisalProgramlamaOzeti();
        optionalGuiNotu();
        ozet();
    }

    private static void intro() {
        System.out.println("=== Bolum 5 ===");
    }

    // 5.3 for Iteration Statement
    private static void forDongusu() {
        /*
         * for döngüsü, sayaç kontrollü döngülerde en okunaklı seçenek.
         * Yapı:
         *  for (başlatma; koşul; güncelleme) { ... }
         */
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        System.out.println("[5.3] 1..5 sum=" + sum);
    }

    // 5.4 Examples Using the for Statement
    private static void forOrnekleri() {
        /*
         * Örnekler:
         * - tersten sayma
         * - adım büyüklüğü ile ilerleme
         */
        System.out.print("[5.4] tersten: ");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("[5.4] ikiser: ");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 5.5 do…while Iteration Statement
    private static void doWhile() {
        /*
         * do-while farkı: koşul sonda kontrol edilir -> gövde en az 1 kez çalışır.
         */
        int i = 0;
        do {
            System.out.println("[5.5] i=" + i);
            i++;
        } while (i < 2);
    }

    // 5.6 switch Multiple-Selection Statement
    private static void switchCokluSecim() {
        /*
         * switch: bir değişkenin değerine göre farklı case'lere dallanır.
         * break yoksa "fall-through" olur (bir sonraki case'e akmaya devam eder).
         */
        int day = 3;
        String name;
        switch (day) {
            case 1:
                name = "Pazartesi";
                break;
            case 2:
                name = "Sali";
                break;
            case 3:
                name = "Carsamba";
                break;
            default:
                name = "Bilinmiyor";
        }
        System.out.println("[5.6] day=" + day + " => " + name);
    }

    // 5.7 Strings in switch Statements (AutoPolicy case study fikri)
    private static void stringSwitchCaseStudy() {
        /*
         * Java'da switch ifadesi String ile de kullanılabilir.
         * Bu örnekte "bölge" girip basit kural uyguluyoruz.
         */
        System.out.print("[5.7] Bölge gir (TR/EU/US): ");
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) {
            System.out.println("Girdi yok, ornek atlandi.");
            return;
        }
        String region = sc.next().toUpperCase();

        int taxPercent;
        switch (region) {
            case "TR":
                taxPercent = 20;
                break;
            case "EU":
                taxPercent = 15;
                break;
            case "US":
                taxPercent = 8;
                break;
            default:
                taxPercent = 0;
        }
        System.out.println("[5.7] region=" + region + " => tax%=" + taxPercent);
    }

    // 5.8 break and continue Statements
    private static void breakContinue() {
        /*
         * break: en yakın döngü/switch'ten çıkar.
         * continue: o iterasyonu bitirir, döngünün bir sonraki turuna geçer.
         */
        System.out.print("[5.8] continue ile tekleri atla: ");
        for (int i = 1; i <= 6; i++) {
            if (i % 2 == 1) {
                continue; // tekleri yazma
            }
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("[5.8] break ile 4'te dur: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 5.9 Logical Operators
    private static void logicalOperators() {
        /*
         * Mantıksal operatörler:
         * - && (AND): iki koşul da true olmalı
         * - || (OR): en az biri true olmalı
         * - !  (NOT): tersine çevirir
         *
         * Short-circuit:
         * - A && B: A false ise B değerlendirilmez.
         * - A || B: A true ise B değerlendirilmez.
         */
        int age = 20;
        boolean hasStudentCard = true;
        boolean indirim = (age < 18) || hasStudentCard;
        System.out.println("[5.9] indirim? " + indirim);

        int x = 0;
        // x != 0 false olduğu için (x != 0 && 10/x > 1) ifadesinde 10/x çalıştırılmaz -> hata yok.
        boolean safe = (x != 0) && (10 / x > 1);
        System.out.println("[5.9] short-circuit guvenli mi? " + safe);
    }

    // 5.10 Structured-Programming Summary
    private static void yapisalProgramlamaOzeti() {
        /*
         * Yapısal programlama fikri:
         * - Akış üç temel yapı ile kurulabilir: sequence, selection, iteration
         * - goto gibi kontrolsüz sıçramalar yerine bu yapı taşları ile okunabilir kod yazılır.
         */
        System.out.println("[5.10] Yapısal programlama özeti yorumlarda.");
    }

    // 5.11 (Optional) GUI and Graphics Case Study
    private static void optionalGuiNotu() {
        /*
         * Bu bölümde opsiyonel olarak şekil çizimleri (dikdörtgen/oval) vardı.
         * İstersen ileride ayrı bir Swing çizim dosyası ekleyebiliriz.
         */
        System.out.println("[5.11] GUI çizim kısmı opsiyonel: bu örnekte not olarak geçildi.");
    }

    // 5.12 Wrap-Up
    private static void ozet() {
        System.out.println("=== Bolum 5 bitti ===");
        System.out.println();
    }
}

