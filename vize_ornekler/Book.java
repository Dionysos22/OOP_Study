// Book Sınıfı Tanımlaması
public class Book {
    // Nesne değişkenleri (Instance variables)
    private String title;
    private String author;
    private double price;

    // Sınıfa ait ortak değişken (Static variable). Her nesne oluşturulduğunda 1 artacak.
    private static int bookCount = 0;

    // 1. Hiçbir parametre almayan Constructor (Varsayılan Constructor)
    public Book() {
        this.title = "Bilinmiyor";
        this.author = "Bilinmiyor";
        this.price = 0.0;
        bookCount++; // Her nesne yaratıldığında sayacı artır
    }

    // 2. Sadece başlık ve yazar alan, fiyatı olmayan durum için Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0; // Fiyat verilmediğinde 0.0 kabul ediyoruz
        bookCount++;
    }

    // 3. Tüm bilgileri (başlık, yazar, fiyat) alan Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        bookCount++;
    }

    // Bilgileri ekrana yazdıran metot
    public void displayBook() {
        System.out.println("Kitap: " + title + ", Yazar: " + author + ", Fiyat: " + price + " TL");
    }

    public double getPrice() {
        return price;
    }

    public static int getBookCount() {
        return bookCount;
    }

    // İndirim uygulayan metot
    public void applyDiscount(double percentage) {
        // İndirim miktarını hesapla ve fiyattan düş
        double discountAmount = this.price * (percentage / 100);
        this.price -= discountAmount;
    }

    public static void main(String[] args) {
        // 5 Kitap Oluşturuluyor
        // 1 tane hiçbir şey olmayan
        Book book1 = new Book();

        // 2 tane kitap ismi ve yazar olan
        Book book2 = new Book("Suç ve Ceza", "Dostoyevski");
        Book book3 = new Book("1984", "George Orwell");

        // 2 tane kitap ismi, yazar ve fiyat bilgisi olan
        Book book4 = new Book("Yüzüklerin Efendisi", "J.R.R. Tolkien", 150.0);
        Book book5 = new Book("Java'ya Giriş", "NaoP", 80.0);

        // Kitapları ekrana yazdır (İndirimsiz halleri)
        System.out.println("--- İndirim Öncesi Kitaplar ---");
        book1.displayBook();
        book2.displayBook();
        book3.displayBook();
        book4.displayBook();
        book5.displayBook();

        // Fiyatı 100'den pahalı olanlar için %10 indirim uygula
        if (book1.getPrice() > 100.0) book1.applyDiscount(10);
        if (book2.getPrice() > 100.0) book2.applyDiscount(10);
        if (book3.getPrice() > 100.0) book3.applyDiscount(10);
        if (book4.getPrice() > 100.0) book4.applyDiscount(10);
        if (book5.getPrice() > 100.0) book5.applyDiscount(10);

        // Kitapları tekrar ekrana yazdır
        System.out.println("\n--- İndirim Sonrası Kitaplar ---");
        book1.displayBook();
        book2.displayBook();
        book3.displayBook();
        book4.displayBook();
        book5.displayBook();

        // Toplam kitap sayısını yazdır
        System.out.println("\nToplam Kitap Sayısı: " + Book.getBookCount());
    }
}
