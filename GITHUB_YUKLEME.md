# OOP_Study — GitHub’a yükleme (sadece bu klasör)

Bu rehber **yalnızca `OOP_Study`** klasörünü ayrı bir GitHub reposu yapar.  
Terminalden repo oluşturmak için **GitHub CLI (`gh`)** kullanılır.

---

## 0. Gereksinimler

```bash
java -version    # JDK 11+
gh --version     # GitHub CLI
```

`gh` yoksa (Mac):

```bash
brew install gh
```

---

## 1. GitHub’a giriş yap

Token hatası alırsan:

```bash
gh auth login
```

- GitHub.com → HTTPS → Login with browser (veya token)  
- Hesabın: terminalde `gh auth status` ile kontrol et

---

## 2. OOP_Study klasörüne gir

```bash
cd "/Users/sarp/Desktop/üni/OOP/OOP_Study"
```

---

## 3. Yerel git + ilk commit

Bu klasörde daha önce `git init` yapılmadıysa:

```bash
git init
git branch -M main
```

Dosyaları ekle (`.class` zaten `.gitignore`’da):

```bash
git add .
git status
```

Staged listesinde `ch01`…`ch12`, `ornekler`, `vize_ornekler`, `README.md`, `LICENSE`, `derle.sh` olmalı.  
`*.class` görünmemeli.

```bash
git commit -m "Initial commit: Java OOP study (ch1-12, TR comments)"
```

---

## 4. GitHub’da repo oluştur + push (tek komut)

`REPO_ADI` istediğin isim (ör. `java-oop-study`):

```bash
gh repo create REPO_ADI --public --source=. --remote=origin --push --description "COM2044 Java OOP vize/final çalışma notları (Bölüm 1-12, Türkçe yorumlu örnekler)"
```

Örnek:

```bash
gh repo create java-oop-study --public --source=. --remote=origin --push --description "COM2044 Java OOP vize/final çalışma notları"
```

Bittiğinde terminalde repo URL’si yazar, örn.  
`https://github.com/KULLANICI_ADIN/java-oop-study`

---

## 5. Kontrol

```bash
gh repo view --web
```

Sayfada `README.md` görünmeli; `ch01`, `ch07`, `derle.sh` klasör/dosyaları listelenmeli.

---

## Sonradan güncelleme

```bash
cd "/Users/sarp/Desktop/üni/OOP/OOP_Study"
# dosyaları düzenle...
git add .
git commit -m "Update chapter notes"
git push
```

---

## Alternatif: `gh` olmadan

GitHub sitesinde boş repo oluştur, sonra:

```bash
cd "/Users/sarp/Desktop/üni/OOP/OOP_Study"
git init && git branch -M main
git add . && git commit -m "Initial commit: Java OOP study"
git remote add origin https://github.com/KULLANICI_ADIN/REPO_ADI.git
git push -u origin main
```

---

## Sık sorunlar

| Sorun | Ne yap |
|--------|--------|
| `gh auth` token invalid | `gh auth login` |
| `repository already exists` | Başka `REPO_ADI` seç veya `gh repo create KULLANICI/REPO_ADI` |
| `remote origin already exists` | `git remote -v` kontrol; gerekirse `git remote set-url origin ...` |
| `git push` rejected | `git pull --rebase origin main` sonra `git push` |

---

## Arkadaşına paylaşım metni

> Java OOP vize/final — Bölüm 1–12, Türkçe yorumlu örnekler  
> `git clone https://github.com/KULLANICI_ADIN/REPO_ADI.git`  
> `cd REPO_ADI` → `chmod +x derle.sh && ./derle.sh`
