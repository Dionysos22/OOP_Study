package ch01;

import java.time.LocalDateTime;

/**
 * Chapter 1: Introduction to Computers, the Internet and Java
 *
 * Bu bölüm çoğunlukla "kavram" anlatır.
 * Bu dosya, sınav için gereken başlıkları tek yerde, yorumlarla özetler
 * ve birkaç küçük çıktı ile hatırlamayı kolaylaştırır.
 */
public class Chapter1_Notes {
    public static void main(String[] args) {
        intro();
        hardwareVsSoftware();
        dataHierarchy();
        languageLevels();
        objectTechnology();
        operatingSystems();
        programmingLanguages();
        javaNedir();
        typicalJavaDevEnvironment();
        testDrivingAJavaApplication();
        internetAndWeb();
        softwareTechnologies();
        gettingHelp();
    }

    // 1.1 Introduction
    private static void intro() {
        /*
         * Bilgisayarlar "donanım (hardware)" + "yazılım (software)" birleşimidir.
         * Yazılım, donanıma ne yapacağını söyleyen komutlar/instrüksiyonlar bütünüdür.
         *
         * Bu derste biz yazılım kısmını Java ile yazacağız.
         */
        System.out.println("=== Chapter 1 Notes ===");
        System.out.println("Now: " + LocalDateTime.now());
        System.out.println();
    }

    // 1.2 Hardware and Software
    private static void hardwareVsSoftware() {
        /*
         * Hardware (Donanım): CPU, RAM, disk/SSD, ekran kartı, klavye, ağ kartı...
         * Software (Yazılım): işletim sistemi, uygulamalar, sürücüler, senin yazdığın programlar...
         *
         * CPU: komutları işler.
         * RAM: çalışma belleği (geçici).
         * Disk: kalıcı depolama.
         */
        System.out.println("[1.2] Hardware vs Software: yorumlarda.");
    }

    // 1.3 Data Hierarchy
    private static void dataHierarchy() {
        /*
         * Veri hiyerarşisi (en küçükten büyüğe tipik anlatım):
         * bit -> byte -> field -> record -> file -> database
         *
         * bit: 0 veya 1
         * byte: 8 bit (çoğunlukla)
         * field: bir anlamlı parça (ör. "isim")
         * record: ilgili field'ların bir araya gelmesi (ör. bir öğrenci kaydı)
         * file: kayıtların toplandığı dosya
         * database: birçok dosya/tablo ve ilişki
         */
        System.out.println("[1.3] Data hierarchy: bit/byte/field/record/file/database");
    }

    // 1.4 Machine, Assembly and High-Level Languages
    private static void languageLevels() {
        /*
         * Makine dili: 0-1 seviyesinde, CPU'ya çok yakın. Okuması zor.
         * Assembly: sembolik isimler (MOV, ADD...) ama hâlâ donanıma yakın.
         * Yüksek seviye diller: insan için daha okunur (Java, Python, C#...).
         *
         * Java'da akış genelde:
         *  .java (source code) -> javac -> .class (bytecode) -> JVM -> çalışır
         */
        System.out.println("[1.4] Language levels: yorumlarda.");
    }

    // 1.5 Introduction to Object Technology
    private static void objectTechnology() {
        /*
         * Nesne yönelimli düşünce:
         * - "Nesne": durum (state) + davranış (behavior)
         *   Örn: BankaHesabı nesnesi -> balance (state), deposit/withdraw (behavior)
         *
         * Temel kavramlar:
         * - class: şablon
         * - object: sınıftan üretilen instance
         * - encapsulation: veriyi (field) saklayıp metotlarla kontrol etme
         */
        System.out.println("[1.5] Object technology: class/object/encapsulation");
    }

    // 1.6 Operating Systems
    private static void operatingSystems() {
        /*
         * İşletim sistemi (OS):
         * - donanım kaynaklarını yönetir (CPU zamanı, bellek, disk, I/O)
         * - uygulamalara servis sağlar (dosya sistemi, ağ, süreç yönetimi...)
         *
         * Örnek OS: Windows, macOS, Linux, Android, iOS
         */
        System.out.println("[1.6] Operating systems: yorumlarda.");
    }

    // 1.7 Programming Languages
    private static void programmingLanguages() {
        /*
         * Programlama dilleri: bilgisayara ne yapacağını söylemenin biçimi.
         * - compiled (derlenen) diller: kaynak -> makine/ara kod
         * - interpreted (yorumlanan) diller: çalışma zamanında yorumlanır
         *
         * Java hibrit bir yaklaşım:
         * - javac: bytecode üretir
         * - JVM: bytecode'u çalıştırır (çoğu zaman JIT ile optimize eder)
         */
        System.out.println("[1.7] Programming languages: compiled vs interpreted");
    }

    // 1.8 Java
    private static void javaNedir() {
        /*
         * Java'nın önemli fikirleri:
         * - Platform bağımsızlık: "write once, run anywhere" (JVM sayesinde)
         * - Zengin standart kütüphane (Java API)
         * - OOP odaklı tasarım
         */
        System.out.println("[1.8] Java: JVM + bytecode + API");
    }

    // 1.9 A Typical Java Development Environment
    private static void typicalJavaDevEnvironment() {
        /*
         * Tipik geliştirme ortamı bileşenleri:
         * - JDK (javac, java, araçlar)
         * - Editör/IDE (Cursor/VSCode, IntelliJ, Eclipse...)
         * - Kaynak kontrol (git)
         *
         * Bu projede terminalde kullandığımız ana komutlar:
         * - javac: derle
         * - java: çalıştır
         */
        System.out.println("[1.9] JDK + IDE + terminal araçları");
    }

    // 1.10 Test-Driving a Java Application
    private static void testDrivingAJavaApplication() {
        /*
         * "Test-drive": küçük bir uygulamayı derleyip çalıştırarak ortamın doğru kurulu olduğunu görmek.
         * Örn:
         *   javac MyProgram.java
         *   java MyProgram
         *
         * Bölüm 2'deki Welcome1/2/3 bu fikrin tipik örnekleridir.
         */
        System.out.println("[1.10] Test-driving: derle + çalıştır (javac/java)");
    }

    // 1.11 Internet and World Wide Web
    private static void internetAndWeb() {
        /*
         * Internet: ağların ağı (network of networks).
         * WWW (Web): internet üzerinde çalışan servislerden biri (HTTP, URL, tarayıcılar).
         *
         * Temel terimler:
         * - client/server
         * - HTTP/HTTPS
         * - URL, domain
         */
        System.out.println("[1.11] Internet vs WWW: yorumlarda.");
    }

    // 1.12 Software Technologies
    private static void softwareTechnologies() {
        /*
         * Slaytlarda genelde:
         * - Agile, DevOps
         * - Cloud
         * - Mobile
         * - AI/ML
         * gibi güncel yazılım teknolojilerinden bahsedilir.
         *
         * Sınavda amaç: bu kavramların "ne olduğuna dair" genel fikir.
         */
        System.out.println("[1.12] Software technologies: cloud/mobile/AI vb.");
    }

    // 1.13 Getting Your Questions Answered
    private static void gettingHelp() {
        /*
         * Yardım bulma yolları:
         * - Resmî dokümantasyon: Java API docs
         * - IDE ipuçları
         * - Hata mesajlarını okumak + anahtar kelime aramak
         * - Stack Overflow / forumlar
         *
         * Pratik: hata mesajındaki ilk "asıl" satırı yakala, sonra sebebe in.
         */
        System.out.println("[1.13] Getting help: docs + error messages + search");
    }
}
