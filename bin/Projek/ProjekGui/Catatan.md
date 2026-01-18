# 📝 Catatan Detail: Game Borderland Survival Record

> Catatan ini bakal jelasin semua code dari project game quiz Java lo dengan bahasa santai dan gampang dimengerti. Cocok buat belajar konsep OOP!

---

## 🎯 Konsep Utama yang Dipake

Project ini pake 4 konsep penting OOP:

1. **Encapsulation** → Nyimpen data di dalam class pake private
2. **Inheritance** → Bikin class anak yang ngewariskan dari class parent
3. **Polymorphism** → Method yang sama tapi beda implementasi
4. **Collection** → Pake ArrayList buat simpen data dinamis

---

## 📦 1. Class `Pemain.java`

**Fungsi:** Class ini buat nyimpen data pemain (nama & skor)

```java
public class Pemain {
    private String nama;  // ENCAPSULATION: Data disimpen private
    private int skor;
```

### Kenapa pake `private`?
Supaya data ga bisa diubah sembarangan dari luar. Harus lewat method getter/setter.

### Constructor
```java
public Pemain(String nama) {
    this.nama = nama;
    this.skor = 0;  // Skor awal selalu 0
}
```
**Maksudnya:** Setiap bikin pemain baru, nama diisi dari input, skor otomatis mulai dari 0.

### Method-method penting:

```java
public void tambahSkor(int poin) {
    this.skor += poin;  // Tambahin skor
}
```
**Kapan dipake?** Pas game selesai, skor dari game bakal ditambahin ke total skor pemain.

```java
public String getNama() { return nama; }
public int getSkor() { return skor; }
```
**Fungsi:** Getter buat ambil data (karena variable-nya private).

```java
@Override
public String toString() {
    return nama + " (Skor: " + skor + ")";
}
```
**Fungsi:** Override method toString() biar pas di-print langsung muncul format yang bagus.
**Contoh output:** `Budi (Skor: 4)`

---

## 🎮 2. Abstract Class `Game.java`

**Fungsi:** Class induk buat semua jenis game. Ini template-nya!

### Kenapa Abstract?
Karena ini cuma blueprint doang. Yang implementasi detailnya itu anak-anaknya (GameMtk, Gametekateki).

```java
public abstract class Game {
    protected String namaGame;
```
**Keyword `protected`:** Bisa diakses sama class anak, tapi ga bisa dari luar package.

### Collection: ArrayList untuk Soal

```java
protected List<SoalModel> daftarSoal = new ArrayList<>();
```

**Kenapa pake ArrayList?**
- Ukurannya dinamis (bisa nambah/ngurangin soal sesuka hati)
- Lebih fleksibel daripada array biasa
- Gampang diakses pake index

### Abstract Method (Wajib diisi anak!)

```java
protected abstract void initSoal();
public abstract void mainkan(Pemain pemain, Scanner scan);
```

**Maksudnya:** Setiap anak class HARUS bikin implementasi method ini. Kalo ga, error!

### Method Konkret (Udah ada isinya)

```java
public String getPertanyaan(int index) {
    if (index < daftarSoal.size()) 
        return daftarSoal.get(index).tanya;
    return "";
}
```
**Fungsi:** Ambil soal berdasarkan index. Dikasih safety check biar ga error kalo index lebih dari jumlah soal.

```java
// Method ini tugasnya jadi HAKIM: Nentuin TRUE (Hidup) atau FALSE (Mati)
public boolean cekJawaban(int index, String jawabanUser) {
    
    // 1. CEK KEAMANAN (Safety First)
    // "Eh, user minta cek soal nomor 10, padahal soal kita cuma ada 5."
    // Kalau indexnya kebablasan, langsung tolak (return false) biar gak Error/Crash.
    if (index >= daftarSoal.size()) return false;

    // 2. AMBIL KUNCI JAWABAN ASLI (Siapin Kopekan)
    // Ambil jawaban bener dari database soal, terus KECILIN HURUFNYA (.toLowerCase).
    // Kenapa dikecilin? Biar "Jawab" sama "JAWAB" dianggep sama.
    String kunci = daftarSoal.get(index).jawab.toLowerCase();

    // 3. BANDINGIN SAMA JAWABAN USER (The Moment of Truth)
    // jawabanUser.trim()        -> Buang spasi gak guna di depan/belakang (misal "  Ayam  " jadi "Ayam")
    // .toLowerCase()            -> Ubah jadi huruf kecil semua ("Ayam" jadi "ayam")
    // .equals(kunci)            -> Cek apakah sama persis dengan kunci?
    return jawabanUser.trim().toLowerCase().equals(kunci);
}
```

**Logic cek jawaban:**
1. Kunci jawaban diubah ke lowercase
2. Input user di-trim (buang spasi) & lowercase juga
3. Dibanding pake `.equals()`

**PENTING:** Method ini bisa di-override sama anak! (POLYMORPHISM)

### Inner Class: SoalModel

```java
protected class SoalModel {
    String tanya;
    String jawab;
    public SoalModel(String t, String j) { 
        this.tanya = t; 
        this.jawab = j; 
    }
}
```

**Fungsi:** Encapsulation! Bikin satu object buat nyimpen 1 soal + jawabannya.

**Contoh pemakaian:**
```java
daftarSoal.add(new SoalModel("2+2=?", "4"));
```

---

## 🔢 3. Class `GameMtk.java` (Anak ke-1)

**Fungsi:** Game khusus matematika (validasi jawaban pake angka)

### Constructor

```java
public GameMtk() {
    super("Tekateki Matematika Mematikan");
}
```
**`super(...)`:** Panggil constructor parent (Game) buat set nama game.

### Implementasi initSoal()

```java
@Override
protected void initSoal() {
    daftarSoal.add(new SoalModel("1) Usia Jek 22 tahun. Berapa usianya 8 tahun lalu?", "14"));
    daftarSoal.add(new SoalModel("2) I = 1, V = 5, X = 10, L = ?", "50"));
    // dst...
}
```

**Yang terjadi:**
1. ArrayList `daftarSoal` (dari parent) diisi pake `.add()`
2. Setiap soal dibungkus dalam object `SoalModel`

### POLYMORPHISM: Override cekJawaban()

```java
@Override
public boolean cekJawaban(int index, String jawabanUser) {
    try {
        int user = Integer.parseInt(jawabanUser.trim());
        int kunci = Integer.parseInt(getKunci(index));
        return user == kunci;
    } catch (NumberFormatException e) {
        return false;
    }
}
```

**Bedanya sama parent:**
- Parent: Cek string biasa
- GameMtk: Parse jadi integer dulu, baru bandingin

**Keuntungan:**
- Input "14" = benar ✅
- Input "14.0" = salah (bukan integer) ❌
- Input "empat belas" = salah ❌

---

## 🧩 4. Class `Gametekateki.java` (Anak ke-2)

**Fungsi:** Game teka-teki (validasi pake string biasa)

```java
public Gametekateki() {
    super("Game Tekateki Botak");
}
```

### Implementasi initSoal()

```java
@Override
protected void initSoal() {
    daftarSoal.add(new SoalModel("Merah berhenti, kuning waspada, hijau jalan. Hitam?", "lampu mati"));
    daftarSoal.add(new SoalModel("Punya sirip bukan ikan, punya sayap bukan burung?", "pesawat"));
    // dst...
}
```

### Cek Jawaban

Class ini **GA OVERRIDE** method `cekJawaban()`, jadi pake punya parent (perbandingan string biasa).

---

## 🖥️ 5. Class `GameGui.java` (GUI Utama)

**Fungsi:** Interface utama game pake Swing

### Komponen GUI

```java
private JTextArea textArea;      // Buat nampilin soal
private JTextField inputField;   // Buat user ketik jawaban
private JButton btnSubmit;       // Tombol submit
```

### Variable Game Logic

```java
private Pemain pemainSaatIni;           // Object pemain yang lagi main
private Game activeGame;                // Game yang dipilih (Mtk/Tekateki)
private int soalIndex = 0;              // Soal ke berapa sekarang
private int skorSesi = 0;               // Skor sementara di sesi ini
```

### 🎯 COLLECTION: Database Pemain

```java
private List<Pemain> databasePemain = new ArrayList<>();
```

**Ini inti dari "buku tamu" lo!**
- Nyimpen semua object `Pemain` yang udah main
- Bisa nampilin riwayat pemain sebelumnya
- Data ga ilang selama program masih jalan

---

## 🔄 Alur Program GameGui

### 1. Constructor & Setup GUI

```java
public GameGui() {
    setTitle("Borderland Survival Record");
    setSize(500, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);  // Muncul di tengah layar
    setLayout(new BorderLayout());
```

**BorderLayout:** Layout manager yang bagi jadi 5 zona (North, South, East, West, Center)

```java
textArea = new JTextArea();
textArea.setEditable(false);  // Ga bisa diedit user
add(new JScrollPane(textArea), BorderLayout.CENTER);
```

**JScrollPane:** Tambahin scrollbar otomatis kalo text kepanjangan.

```java
btnSubmit.addActionListener(e -> prosesJawaban());
```

**Lambda expression:** Cara singkat bikin event listener. Pas tombol diklik, method `prosesJawaban()` dipanggil.

---

### 2. Method `mulaiSesiBaru()`

**Dipanggil kapan?**
- Pas program pertama kali jalan
- Pas game selesai (loop buat pemain baru)

```java
String nama = JOptionPane.showInputDialog(this, "Masukkan Nama Peserta Baru:");
if (nama == null || nama.isEmpty()) nama = "Unknown";
```

**Safety check:** Kalo user cancel/kosong, kasih nama default.

```java
pemainSaatIni = new Pemain(nama);
```

**PENTING:** Bikin object `Pemain` BARU setiap kali! Jadi data ga ke-carry dari pemain sebelumnya.

```java
String[] options = {"Matematika", "Teka-teki"};
int pilih = JOptionPane.showOptionDialog(...);

if (pilih == 0) activeGame = new GameMtk();
else activeGame = new Gametekateki();
```

**POLYMORPHISM:** Variable `activeGame` bertipe `Game`, tapi bisa nampung `GameMtk` atau `Gametekateki`.

---

### 3. Method `updateTampilanSoal()`

```java
private void updateTampilanSoal() {
    textArea.setText("=== " + activeGame.getNamaGame() + " ===\n");
    textArea.append("Player Aktif: " + pemainSaatIni.getNama() + "\n\n");
    textArea.append("Soal ke-" + (soalIndex + 1) + ":\n");
    textArea.append(activeGame.getPertanyaan(soalIndex) + "\n");
    inputField.setText("");
    inputField.requestFocus();  // Cursor langsung ke input field
}
```

**Flow:**
1. Hapus text lama pake `setText()`
2. Tambahin info pake `append()`
3. Ambil soal dari `activeGame` (bisa GameMtk atau Gametekateki)
4. Reset input field & kasih focus

---

### 4. Method `prosesJawaban()`

```java
private void prosesJawaban() {
    String jawaban = inputField.getText();
    if (jawaban.isEmpty()) return;  // Kalo kosong, ga ngapa-ngapain
```

```java
boolean benar = activeGame.cekJawaban(soalIndex, jawaban);
```

**POLYMORPHISM lagi!** 
- Kalo `activeGame` = GameMtk → Pake validasi angka
- Kalo `activeGame` = Gametekateki → Pake validasi string

```java
if (benar) {
    JOptionPane.showMessageDialog(this, "Benar!");
    skorSesi++;  // Tambahin skor sementara
} else {
    JOptionPane.showMessageDialog(this, "Salah! Kunci: " + activeGame.getKunci(soalIndex));
}
```

```java
soalIndex++;  // Lanjut ke soal berikutnya

if (soalIndex >= activeGame.getJumlahSoal()) {
    gameSelesai();  // Udah habis soalnya
} else {
    updateTampilanSoal();  // Tampilin soal baru
}
```

---

### 5. Method `gameSelesai()` - CORE LOGIC!

#### Step 1: Update Skor Pemain

```java
pemainSaatIni.tambahSkor(skorSesi);
```

Skor sementara ditambahin ke object pemain.

#### Step 2: Tentuin Status

```java
String status = (skorSesi >= 3) ? "HIDUP (Lulus)" : "MATI (Eliminasi)";
```

**Ternary operator:** Kalo skor ≥ 3 hidup, kalo < 3 mati.

#### Step 3: SIMPEN KE DATABASE! (COLLECTION)

```java
databasePemain.add(pemainSaatIni);
```

**INI YANG BIKIN RIWAYAT TERSIMPAN!**
- Object `pemainSaatIni` dimasukin ke ArrayList
- Data ga ilang meskipun mulai sesi baru
- Bisa diakses buat ditampilin nanti

#### Step 4: Bikin Laporan

```java
StringBuilder laporan = new StringBuilder();
laporan.append("=== GAME OVER ===\n");
laporan.append("Nama: ").append(pemainSaatIni.getNama()).append("\n");
laporan.append("Status: ").append(status).append("\n");
laporan.append("Skor: ").append(pemainSaatIni.getSkor()).append("\n\n");
```

**StringBuilder:** Lebih efisien buat gabungin banyak string.

#### Step 5: Tampilin Riwayat Pemain Sebelumnya

```java
laporan.append("=== RIWAYAT PEMAIN SEBELUMNYA ===\n");
if (databasePemain.size() > 1) {
    for (Pemain p : databasePemain) {
        if (p != pemainSaatIni) {
            laporan.append("- ").append(p.toString()).append("\n");
        }
    }
} else {
    laporan.append("(Belum ada korban lain)\n");
}
```

**Enhanced for loop:** Loop semua isi ArrayList.

**Logic:**
- Size > 1 → Ada pemain lama (pemain sekarang udah masuk, jadi minimal 1)
- `p != pemainSaatIni` → Jangan nampilin diri sendiri lagi
- `p.toString()` → Dipanggil otomatis, hasilnya format dari class Pemain

#### Step 6: Loop Balik

```java
mulaiSesiBaru();
```

Program ga berhenti! Langsung minta nama baru & mulai lagi.

---

## 🎓 Konsep OOP yang Dipake

### 1. Encapsulation
```java
// Di class Pemain
private String nama;  // Data disembunyiin
public String getNama() { return nama; }  // Diakses lewat method
```

### 2. Inheritance
```java
public class GameMtk extends Game { ... }
public class Gametekateki extends Game { ... }
```
Dua class ini ngewariskan semua property & method dari `Game`.

### 3. Polymorphism
```java
// Bisa nampung berbagai jenis game
Game activeGame;

// Runtime polymorphism
activeGame = new GameMtk();     // Atau
activeGame = new Gametekateki();

// Method yang sama, tapi beda implementasi
activeGame.cekJawaban(0, "14");
```

### 4. Abstraction
```java
public abstract class Game {
    protected abstract void initSoal();  // Ga ada isi, anak yang implementasi
}
```

### 5. Collection (ArrayList)
```java
// Dinamis, bisa nambah/kurangin sesuka hati
List<Pemain> databasePemain = new ArrayList<>();
databasePemain.add(pemain1);
databasePemain.add(pemain2);
```

---

## 🚀 Cara Jalanin Program

1. **Compile semua file:**
   ```bash
   javac Projek/ProjekGui/*.java
   ```

2. **Jalanin GUI:**
   ```bash
   java Projek.ProjekGui.GameGui
   ```

3. **Flow:**
   - Input nama
   - Pilih game (Mtk/Tekateki)
   - Jawab 5 soal
   - Liat hasil & riwayat pemain
   - Loop lagi buat pemain baru

---

## 💡 Tips Modifikasi

### Nambah Soal Baru
Edit di `initSoal()`:
```java
daftarSoal.add(new SoalModel("Soal baru?", "jawaban"));
```

### Ubah Batas Lulus
Edit di `gameSelesai()`:
```java
String status = (skorSesi >= 4) ? "HIDUP" : "MATI";  // Ganti 3 jadi 4
```

### Bikin Game Baru
1. Bikin class baru extends `Game`
2. Override `initSoal()`
3. (Opsional) Override `cekJawaban()` kalo butuh validasi khusus
4. Tambahin option di `mulaiSesiBaru()`

---

## 🐛 Common Errors & Solusi

### Error: "Cannot find symbol Pemain"
**Solusi:** Pastikan semua file di package yang sama (`Projek.ProjekGui`)

### Error: NullPointerException
**Biasanya:** Lupa init object sebelum dipake.
**Solusi:** Pastikan `pemainSaatIni` & `activeGame` udah di-init di `mulaiSesiBaru()`

### Soal ga muncul
**Cek:** Method `initSoal()` udah dipanggil di constructor `Game`?

---

## 📌 Kesimpulan

Project ini ngajarin lo:
- ✅ Bikin class dengan encapsulation
- ✅ Pake inheritance buat reuse code
- ✅ Polymorphism buat fleksibilitas
- ✅ Abstract class sebagai template
- ✅ Collection (ArrayList) buat data dinamis
- ✅ GUI dengan Swing
- ✅ Event handling

**Intinya:** Lo bikin "framework" game quiz yang bisa dikembangin jadi berbagai jenis game, dengan sistem penyimpanan data pemain yang rapi!
