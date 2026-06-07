# Java OOP Study — COM2044 (Vize + Final)

Deitel *Java How to Program* Bölüm 1–12 + Lab 6–8 sınav konuları.  
Türkçe yorumlu, çalıştırılabilir Java örnekleri.

**JDK 11+** gerekir.

## İndir

```bash
git clone https://github.com/Dionysos22/java-oop-study.git
cd java-oop-study
chmod +x derle.sh && ./derle.sh
```

## Nereden başlamalı?

1. `CALISMA_SIRASI.txt` — adım adım plan  
2. `SINAV_KONTROL_LISTESI.txt` — konu listesi (kutuları işaretle)

## Klasör yapısı

| Klasör | İçerik |
|--------|--------|
| `ch01`–`ch06` | Vize (temel Java, sınıf, kontrol, metot) |
| `ch07`–`ch12` | Final kitap konuları |
| `ch13` | Lab 8 özeti (abstract, Comparable, generic, dosya I/O) |
| `vize_tekrar` | Output soruları tekrarı |
| `vize_ornekler` | Vize sorusu `Book.java` |
| `ornekler` | Sınav tarzı iskelet kod (Lab 6/7/8) |
| `uml` | UML alıştırmaları |
| `lab` | Lab 6–8 sınav notları (kurallar, hiyerarşi) |

## Çalıştırma

```bash
# Paketli bölüm
java -cp . ch10.Bolum10_Polimorfizm

# Paketsiz bölüm özeti
java -cp ch04 Bolum4_Kontrol1

# Vize / final pratik
java -cp . vize_tekrar.BolumVize_OutputTekrar
java -cp . ornekler.Final_OdemeOzeti
java -cp . ch13.Bolum13_Lab8Universite
cd vize_ornekler && javac Book.java && java Book
```

Tüm dosya listesi: `INDEKS.txt`

## Lisans

[MIT](LICENSE)
