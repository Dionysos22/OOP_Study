# Java OOP Study — Vize & Final (Bölüm 1–12)

COM2044 ve benzeri **Nesneye Yönelik Programlama** dersleri için **Türkçe açıklamalı**, **çalıştırılabilir** Java örnekleri.

Kitap paralelliği: *Java How to Program (Early Objects)* — Deitel, Bölüm 1–12.

---

## Kimler için?

- Vize öncesi: Bölüm **1–6** + `vize_ornekler/Book.java`
- Final öncesi: Bölüm **7–12** + `ornekler/` (Lab 6–7 konuları bu bölümlerde özetlenir)

**Gereksinim:** JDK **11+**

---

## Hızlı başlangıç

```bash
git clone https://github.com/KULLANICI_ADIN/REPO_ADI.git
cd REPO_ADI
chmod +x derle.sh && ./derle.sh
java -cp . ch06.Bolum6_Metotlar
```

Bu repoyu zaten indirdiysen, klasörde:

```bash
chmod +x derle.sh && ./derle.sh
java -cp . ornekler.Final_OdemeOzeti
```

---

## Klasör yapısı

```
ch01/ … ch06/     Vize konuları
ch07/ … ch12/     Final konuları
ornekler/         Sınav tarzı mini örnekler
vize_ornekler/    Book.java (vize)
SINAV_KONTROL_LISTESI.txt
INDEKS.txt
derle.sh
```

---

## Bölüm özeti

| Bölüm | Konu |
|-------|------|
| 1–2 | Java giriş, girdi/çıktı, operatörler |
| 3–4 | Sınıf/nesne, if/while |
| 5–6 | for, switch, metotlar, static, enum |
| 7–8 | Dizi, ArrayList, encapsulation |
| 9–10 | Kalıtım, polimorfizm, interface |
| 11–12 | Exception, Factory Method |

Detaylı dosya listesi: [`INDEKS.txt`](INDEKS.txt)  
Çalışma listesi: [`SINAV_KONTROL_LISTESI.txt`](SINAV_KONTROL_LISTESI.txt)

---

## Çalıştırma notları

**Paketli** (`package ch06;`):

```bash
java -cp . ch06.Bolum6_Metotlar
```

**Paketsiz** (`Bolum4_Kontrol1`):

```bash
java -cp ch04 Bolum4_Kontrol1
```

**Book (vize):**

```bash
cd vize_ornekler && javac Book.java && java Book
```

---

## Önerilen sıra

1. `SINAV_KONTROL_LISTESI.txt`  
2. Vize: `ch03`, `ch06`, `vize_ornekler/Book.java`  
3. Final: `ch07` → `ch12`  
4. `ornekler/` — oku, kapat, sıfırdan yazmayı dene  

`ch03` ve `ch08` ikisi de sınıf/nesne anlatır; ikisini de oku.

---

## Lisans

MIT — eğitim ve paylaşım için. Üniversite ödev kurallarına uygun kullan.

---

## Repoyu GitHub’a yüklemek (senin için)

Adım adım terminal rehberi: [`GITHUB_YUKLEME.md`](GITHUB_YUKLEME.md)
