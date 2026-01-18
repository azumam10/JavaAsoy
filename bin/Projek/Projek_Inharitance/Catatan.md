# Dokumentasi Project Game Inheritance - Java

## 📚 Pengenalan Project
Project ini adalah sebuah sistem game interaktif berbasis Inheritance dan Abstraksi di Java. Konsepnya adalah pemain harus menjalani beberapa jenis game untuk mendapatkan poin. Jika poin yang dikumpulkan kurang dari 3, pemain dianggap kalah.

---

## 🏗️ Struktur Architecture Project

```
Projek_Inheritance/
├── Game.java (Class Abstrak - Parent/Induk)
├── GameMtk.java (Child - Game Matematika)
├── Gametekateki.java (Child - Game Tekateki)
├── Pemain.java (Class untuk menyimpan data pemain)
└── main.java (Class utama yang menjalankan program)
```

---

## 📖 DOKUMENTASI DETAIL SETIAP CLASS

---

## 1️⃣ CLASS: `Game.java` (Abstrak Parent Class)

**Penjelasan Umum:**
Class `Game` adalah class induk yang bersifat **abstrak**. Artinya, class ini hanya menjadi "cetak biru" atau template untuk class-class anak (child class). Class induk ini tidak bisa dibuat objek secara langsung, melainkan harus di-extend (diturunkan) oleh class anak terlebih dahulu.

**Analoginya:** Seperti orang tua yang membuat peraturan umum yang harus diikuti oleh semua anak, meski setiap anak bisa menjalankan peraturan itu dengan cara berbeda-beda.

---

### 🔹 Package & Import
```java
package Projek.Projek_Inharitance;
import java.util.Scanner;
```
- **Package**: Mengelompokkan class-class dalam folder terstruktur agar mudah diorganisir.
- **Import Scanner**: Untuk membaca input dari user melalui keyboard.

---

### 🔹 Deklarasi Class Abstrak
```java
public abstract class Game {
```
**Penjelasan:**
- **`public`**: Class ini bisa diakses dari mana saja dalam project.
- **`abstract`**: Menjadikan class ini abstrak, artinya tidak bisa diinstansiasi (dibuat objek) secara langsung. Class ini hanya bisa diturunkan (di-extend) oleh class lain.

---

### 🔹 Variabel Protected
```java
protected String namaGame;
```
**Penjelasan:**
- **`protected`**: Variabel ini bisa diakses oleh class ini sendiri dan class anak (child class) yang mewarisnya, tetapi tidak bisa diakses dari class lain di luar hierarchy inheritance.
- **`namaGame`**: Menyimpan nama dari game yang sedang dimainkan (contoh: "Tekateki Matematika Mematikan").

---

### 🔹 Constructor (Konstruktor)
```java
public Game(String namaGame){
    this.namaGame = namaGame;
}
```
**Penjelasan:**
- **Apa itu Konstruktor?** Constructor adalah method spesial yang dijalankan otomatis saat objek dibuat. Kegunaannya adalah untuk menginisialisasi (memberikan nilai awal) pada variabel-variabel dalam class.
- **`this.namaGame = namaGame`**: `this` merujuk ke objek saat ini. Baris ini menetapkan nilai parameter `namaGame` ke dalam variabel instance `namaGame`. Fungsinya adalah menyimpan nama game ke dalam object yang akan dibuat.

**Contoh Penggunaan di Child Class:**
Ketika class `GameMtk` memanggil `super("Tekateki Matematika Mematikan")`, nilai string tersebut dilewatkan ke constructor ini dan disimpan dalam `namaGame`.

---

### 🔹 Method Regular
```java
public void Namagame(){
    System.out.println("=======" + namaGame + "========");
    System.out.println("Fokus Dan Selesaikan");
}
```
**Penjelasan:**
- **`void`**: Method ini tidak mengembalikan nilai apapun, hanya menampilkan output ke layar.
- **Fungsi Method**: Untuk menampilkan nama game dalam format header yang menarik, bersama dengan motivasi "Fokus Dan Selesaikan".
- **`System.out.println()`**: Perintah untuk mencetak teks ke layar konsol.

**Kapan Digunakan?** Method ini dipanggil di awal setiap game untuk memberitahu pemain game mana yang sedang dijalankan.

---

### 🔹 Abstract Method
```java
public abstract void mainkan(Pemain pemain, Scanner scan);
```
**Penjelasan:**
- **`abstract`**: Method ini adalah "kontrak" yang harus diimplementasikan oleh semua class anak. Class anak WAJIB membuat method dengan nama dan signature yang sama.
- **Fungsi**: Method ini adalah peraturan umum yang harus diikuti oleh semua game. Setiap game pasti akan memiliki cara bermain (mainkan), meski cara detailnya berbeda-beda.
- **Parameter**:
  - `Pemain pemain`: Object pemain yang sedang bermain, untuk menyimpan skor mereka.
  - `Scanner scan`: Untuk membaca input dari user.

**Analogi:** Seperti orang tua yang mengatakan "Semua anak harus belajar", tetapi cara belajar masing-masing anak bisa berbeda (ada yang membaca buku, ada yang praktik, dll).

---

## 2️⃣ CLASS: `GameMtk.java` (Child Class - Game Matematika)

**Penjelasan Umum:**
Class ini adalah class anak yang mewarisi dari class `Game`. Class ini mengimplementasikan game pertanyaan matematika dimana pemain harus menjawab soal dengan benar.

---

### 🔹 Deklarasi Class dan Inheritance
```java
public class GameMtk extends Game {
```
**Penjelasan:**
- **`extends Game`**: Keyword `extends` berarti class `GameMtk` mewarisi (inherit) dari class `Game`. Artinya, `GameMtk` mendapatkan semua property dan method dari class `Game`, dan bisa menambahkan atau mengubah functionality-nya.

---

### 🔹 Constructor dengan Super
```java
public GameMtk(){
    super("Tekateki Matematika Mematikan");
}
```
**Penjelasan:**
- **Constructor Tanpa Parameter**: Constructor class ini tidak menerima parameter apapun.
- **`super()`**: Keyword ini digunakan untuk memanggil constructor dari parent class (`Game`). Baris ini memanggil constructor parent class dan memberikan string `"Tekateki Matematika Mematikan"` sebagai nama game.
- **Fungsi**: Menginisialisasi nama game dengan nilai yang telah ditentukan.

**Analogi:** Seperti anak yang memanggil ayahnya untuk melakukan persiapan dasar (setup awal) sebelum anak melakukan hal spesifiknya sendiri.

---

### 🔹 Override Method Abstrak
```java
@Override
public void mainkan(Pemain pemain, Scanner scan){
```
**Penjelasan:**
- **`@Override`**: Anotasi (annotation) yang menandakan bahwa method ini mengoverride (menimpa/menggantikan) abstract method dari parent class. Ini membantu compiler dan programmer mengetahui bahwa ini adalah implementasi dari contract yang sudah ditetapkan di parent class.
- **Fungsi Method `mainkan()`**: Menjalankan logika game matematika secara lengkap.

---

### 🔹 Variabel Skor
```java
int skor = 0;
```
**Penjelasan:**
- Variabel lokal untuk menghitung jumlah soal yang dijawab dengan benar selama bermain.
- Diinisialisasi dengan nilai 0 di awal.

---

### 🔹 Array Soal dan Jawaban
```java
String[] soal = {
    "1) Usia Jek 22 tahun. Berapa usianya 8 tahun lalu?",
    "2) I = 1, V = 5, X = 10, L = ? ",
    // ... soal lainnya
};

int[] jawabanBenar = {
    14,  // 22 - 8
    50,  // L = 50
    // ... jawaban lainnya
};
```
**Penjelasan:**
- **`String[] soal`**: Array string yang menyimpan 5 soal matematika. Setiap index dalam array menyimpan satu soal lengkap.
- **`int[] jawabanBenar`**: Array integer yang menyimpan jawaban benar untuk setiap soal. Index-nya selaras dengan array `soal` (soal[0] jawabannya jawabanBenar[0], dan seterusnya).
- **Fungsi**: Menyediakan data pertanyaan dan jawaban referensi yang akan dibandingkan dengan jawaban user.

---

### 🔹 Loop dan Validasi Input
```java
for (int i = 0; i < soal.length; i++) {
    try {
        System.out.println("\nSoal " + (i + 1) + ":");
        System.out.println(soal[i]);
        System.out.print("Jawaban Anda (ketik 0 untuk keluar): ");
        
        int jawabanUser = scan.nextInt();
        scan.nextLine(); // buang newline
```

**Penjelasan:**
- **`for (int i = 0; i < soal.length; i++)`**: Loop yang mengulang sebanyak jumlah soal dalam array (5 kali). Variable `i` dimulai dari 0 dan increment setiap iterasi.
- **`soal.length`**: Property yang memberikan jumlah elemen dalam array `soal`.
- **`try`**: Block yang menangkap error (exception). Jika ada error saat eksekusi, akan ditangani di block `catch`.
- **`scan.nextInt()`**: Membaca input user dalam bentuk angka integer.
- **`scan.nextLine()`**: Menghapus karakter "newline" yang tertinggal setelah membaca integer, agar input berikutnya tidak terganggu.

---

### 🔹 Pengecekan Jawaban
```java
if (jawabanUser == 0) {
    System.out.println("Anda Menyerah Silahkan Masuk Ke Ruang Eksekusi");
    break;
}

if (jawabanUser == jawabanBenar[i]) {
    System.out.println("Benar!");
    skor++;
} else {
    System.out.println("Salah, nyawa anda taruhannya Jawaban benar: " + jawabanBenar[i]);
}
```

**Penjelasan:**
- **Kondisi Pertama**: Jika user mengetik 0, dianggap menyerah dan loop `for` akan dihentikan dengan perintah `break`.
- **Kondisi Kedua**: Jika jawaban user sama dengan jawaban benar, increment skor sebesar 1.
- **Else**: Jika jawaban salah, tampilkan jawaban yang benar. Skor tidak bertambah.

---

### 🔹 Exception Handling
```java
} catch (Exception e) {
    scan.nextLine(); // buang input salah
    System.out.println("Input bukan angka. Soal dilewati.");
    continue;
}
```

**Penjelasan:**
- **`catch (Exception e)`**: Menangkap error apapun yang terjadi di dalam block `try`. Variabel `e` menyimpan informasi error tersebut.
- **Fungsi**: Jika user memasukkan input yang bukan angka (misalnya huruf), error akan ditangkap di sini, dan user diminta untuk memasukkan input lagi.
- **`continue`**: Melompat ke iterasi loop berikutnya tanpa menjalankan kode di bawahnya.

---

### 🔹 Penambahan Skor dan Pengecekan Kemenangan
```java
pemain.tambahskor(skor);
System.out.println("Nama Pemain : " + pemain.getNama());
System.out.println("Skor : " + pemain.getSkor());

if (pemain.getSkor() < 3){
    System.out.println("Anda kalah!! ");
    System.out.println("#### SILAHKAN MASUK KE NERAKA ####");
}
```

**Penjelasan:**
- **`pemain.tambahskor(skor)`**: Memanggil method `tambahskor()` pada object `pemain` untuk menambahkan skor yang didapat dari game ini ke total skor pemain.
- **`pemain.getNama()` dan `pemain.getSkor()`**: Getter method untuk mendapatkan nama dan skor pemain dari object `pemain`.
- **Pengecekan Kemenangan**: Jika total skor pemain kurang dari 3, berarti pemain kalah.

---

## 3️⃣ CLASS: `Gametekateki.java` (Child Class - Game Tekateki)

**Penjelasan Umum:**
Class ini adalah class anak yang mewarisi dari class `Game`. Class ini mengimplementasikan game tekateki logika dimana pemain harus menjawab dengan teks bukan angka.

---

### 🔹 Constructor
```java
public Gametekateki(){
    super("Game Tekateki Botak");
}
```

**Penjelasan:**
- Sama seperti `GameMtk`, constructor ini memanggil parent constructor dengan melewatkan nama game `"Game Tekateki Botak"`.

---

### 🔹 Override Method Mainkan
```java
@Override
public void mainkan(Pemain pemain, Scanner scan){
    int skor = 0;
    Namagame();
```

**Penjelasan:**
- Mengimplementasikan abstract method `mainkan()` sesuai kebutuhan game tekateki.
- **`Namagame()`**: Method dari parent class yang dipanggil untuk menampilkan header nama game.

---

### 🔹 Array 2 Dimensi untuk Soal dan Jawaban
```java
String[][] soalJawaban = {
    {"Merah berhenti, kuning waspada, hijau jalan. Maka hitam adalah...", "lampu mati"},
    {"Punya sirip tapi bukan ikan, punya sayap tapi bukan burung. Apa itu?", "pesawat"},
    // ... soal dan jawaban lainnya
};
```

**Penjelasan:**
- **`String[][]`**: Array 2 dimensi (array dalam array). Setiap elemen array adalah sebuah array yang berisi 2 string: soal dan jawaban.
- **Struktur**: 
  - Index pertama [i] adalah nomor soal (0 sampai 4).
  - Index kedua [0] adalah pertanyaan.
  - Index kedua [1] adalah jawaban yang benar.
- **Fungsi**: Lebih efisien untuk menyimpan pasangan soal-jawaban yang berhubungan.

---

### 🔹 Loop dan Input Text
```java
for (int i = 0; i < soalJawaban.length; i++) {
    System.out.println("\nSoal " + (i + 1) + ":");
    System.out.println(soalJawaban[i][0]);
    System.out.print("Jawaban Anda: ");
    String jawaban = scan.nextLine().toLowerCase().trim();
```

**Penjelasan:**
- **`soalJawaban[i][0]`**: Mengakses pertanyaan dari array 2D (elemen pertama dari setiap soal).
- **`scan.nextLine()`**: Membaca input user dalam bentuk string/teks (berbeda dengan `nextInt()` yang membaca angka).
- **`.toLowerCase()`**: Method yang mengubah semua huruf menjadi huruf kecil. Fungsinya agar jawaban "Pesawat", "pesawat", dan "PESAWAT" dianggap sama.
- **`.trim()`**: Method yang menghapus spasi di awal dan akhir string. Jadi " pesawat " akan menjadi "pesawat".

---

### 🔹 Pengecekan Jawaban Text
```java
if (jawaban.equals(soalJawaban[i][1].toLowerCase())) {
    System.out.println("Benar!");
    skor++;
} else {
    System.out.println(" Salah, Nyawa anda taruhan. Jawaban benar: " + soalJawaban[i][1]);
}
```

**Penjelasan:**
- **`.equals()`**: Method untuk membandingkan dua string. Mengembalikan `true` jika sama, `false` jika berbeda.
- **`soalJawaban[i][1].toLowerCase()`**: Mengakses jawaban benar dari array 2D dan mengubahnya menjadi huruf kecil untuk perbandingan yang akurat.
- **Logika**: Jika jawaban user sama dengan jawaban benar, skor bertambah 1.

---

## 4️⃣ CLASS: `Pemain.java` (Class untuk Data Pemain)

**Penjelasan Umum:**
Class ini digunakan untuk menyimpan dan mengelola data pemain seperti nama dan skor yang dikumpulkan selama bermain.

---

### 🔹 Variabel Instance
```java
private List<String> nama;
private int skor;
```

**Penjelasan:**
- **`private`**: Variabel ini hanya bisa diakses dari dalam class ini sendiri. Dari luar class, harus menggunakan getter/setter method.
- **`List<String> nama`**: List adalah struktur data yang bisa menyimpan banyak elemen. `List<String>` artinya list yang berisi string. Meskipun di sini hanya menyimpan satu nama, menggunakan `List` membuat code lebih fleksibel untuk pengembangan ke depan.
- **`int skor`**: Menyimpan total skor pemain dalam bentuk bilangan bulat.

---

### 🔹 Constructor
```java
public Pemain(String nama){
    this.nama = new ArrayList<>();
    this.skor = 0;
}
```

**Penjelasan:**
- **`new ArrayList<>()`**: Membuat object baru ArrayList. ArrayList adalah implementasi dari List yang memungkinkan kita menambah atau mengurangi elemen secara dinamis.
- **Inisialisasi**: Saat pemain dibuat, list nama diinisialisasi sebagai ArrayList kosong dan skor dimulai dari 0.

**Catatan:** Constructor ini tidak langsung menambahkan nama ke list. Nama ditambahkan melalui method `addNama()` (meskipun di main class, logic ini sebenarnya bisa diperbaiki).

---

### 🔹 Getter Method
```java
public List<String> getNama(){
    return nama;
}

public int getSkor(){
    return skor;
}
```

**Penjelasan:**
- **Getter**: Method yang digunakan untuk mengambil/membaca nilai variabel private dari luar class.
- **`return`**: Keyword untuk mengembalikan nilai dari method.
- **Fungsi**: Memberikan akses read-only terhadap data pemain tanpa bisa mengubahnya langsung.

---

### 🔹 Method Tambah Skor
```java
public void tambahskor(int poin){
    this.skor += poin;
}
```

**Penjelasan:**
- **`+= poin`**: Operator compound assignment. `this.skor += poin` sama dengan `this.skor = this.skor + poin`. Menambahkan nilai `poin` ke skor yang sudah ada.
- **Fungsi**: Setiap game yang selesai, skor pemain akan ditambahkan dengan poin yang didapat di game tersebut.

---

### 🔹 Method Reset Skor
```java
public void resetSkor(){
    this.skor = 0;
}
```

**Penjelasan:**
- Mengembalikan skor ke 0. Berguna jika pemain ingin bermain ulang dari awal.

---

### 🔹 Method Tambah Nama
```java
public void addNama(String namas){
    nama.add(namas);
}
```

**Penjelasan:**
- **`.add()`**: Method ArrayList untuk menambahkan elemen baru ke list.
- **Fungsi**: Menambahkan nama pemain ke dalam list `nama`. Meskipun dalam praktik di main class, method ini belum digunakan dengan optimal.

---

### 🔹 Method Tampilkan Profil
```java
public void tampilkanProfil(){
    System.out.println("Nama Pemain: " + nama);
    System.out.println("Skor Pemain: " + skor);
}
```

**Penjelasan:**
- Menampilkan profil lengkap pemain (nama dan skor) ke layar.
- **`+`**: Operator concatenation untuk menggabungkan string.

---

## 5️⃣ CLASS: `main.java` (Entry Point Program)

**Penjelasan Umum:**
Class ini adalah pintu masuk program. Di sini semua class lain digunakan bersama-sama untuk membuat pengalaman bermain game yang lengkap.

---

### 🔹 Method Main dan Loop Utama
```java
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean ulang = true;
    
    while(ulang){
```

**Penjelasan:**
- **`public static void main()`**: Method khusus yang menjadi starting point program. JVM (Java Virtual Machine) akan menjalankan method ini secara otomatis.
- **`Scanner scan = new Scanner(System.in)`**: Membuat object Scanner untuk membaca input dari keyboard (`System.in` adalah standard input).
- **`while(ulang)`**: Loop infinite yang memungkinkan pemain bermain multiple game atau restart game.

---

### 🔹 Input Nama Pemain
```java
System.out.print("Masukan Nama Anda : ");
String nama = scan.nextLine();
Pemain pemain = new Pemain(nama);
```

**Penjelasan:**
- **`System.out.print()`**: Sama seperti `println()`, tetapi tidak membuat baris baru di akhir.
- **`scan.nextLine()`**: Membaca nama yang diinput user.
- **`new Pemain(nama)`**: Membuat object `Pemain` baru dengan nama yang telah diinput.

---

### 🔹 Polymorphism - Deklarasi Object dengan Parent Class Type
```java
Game gamemtk = new GameMtk();
Game tekateki = new Gametekateki();
```

**Penjelasan:**
- **Polymorphism**: "Poly" = banyak, "morph" = bentuk. Bisa menggunakan parent class type untuk mereferensi object child class.
- **Cara Kerja**: Meski variable `gamemtk` bertipe `Game` (parent), dia sebenarnya object `GameMtk` (child). Begitu juga dengan `tekateki`.
- **Fungsi**: Ketika method `mainkan()` dipanggil, Java akan secara otomatis menjalankan implementasi yang tepat berdasarkan tipe object sebenarnya (method overriding).
- **Keuntungan**: Code menjadi fleksibel. Jika nanti ada game baru, tinggal membuat child class baru tanpa perlu mengubah main method.

---

### 🔹 Menu dan Switch Statement
```java
while (running) {
    try {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. =*/+-% ");
        System.out.println("2. TasdhEasKhdsAmnbTgdEsvdhKndI");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu (1-3): ");
        
        int pilihan = scan.nextInt();
        scan.nextLine(); // buang newline
        
        switch (pilihan) {
            case 1:
                gamemtk.mainkan(pemain, scan);
                break;
            case 2:
                tekateki.mainkan(pemain, scan);
                break;
            case 3:
                System.out.println("Terima kasih telah bermain! Sampai ketemu lagi ✌️");
                running = false;
                ulang = false;
                break;
            default:
                System.out.println("Pilih Dengan Benar Atau Panah Muncul Di Jam 10");
        }
        running = false;
```

**Penjelasan:**

**Switch Statement:**
- **`switch (pilihan)`**: Mengecek nilai variabel `pilihan` dan menjalankan code yang sesuai.
- **`case 1:`**: Jika pilihan = 1, jalankan game matematika.
- **`case 2:`**: Jika pilihan = 2, jalankan game tekateki.
- **`case 3:`**: Jika pilihan = 3, keluar dari game. Variabel `running` dan `ulang` diset `false` untuk menghentikan loop.
- **`default:`**: Jika input tidak cocok dengan case apapun, tampilkan pesan error.
- **`break;`**: Menghentikan eksekusi switch statement dan lanjut ke code di bawahnya.

**Polymorphism di Sini:**
- `gamemtk.mainkan(pemain, scan)` memanggil method `mainkan()` yang sudah di-override di class `GameMtk`.
- `tekateki.mainkan(pemain, scan)` memanggil method `mainkan()` yang sudah di-override di class `Gametekateki`.
- Java tahu method mana yang dijalankan berdasarkan tipe object sebenarnya.

---

### 🔹 Exception Handling di Main
```java
} catch (Exception e) {
    scan.nextLine(); // buang input salah
    System.out.println("Input nggak valid. Ketik angka 1-3 ya.");
    continue;
}
```

**Penjelasan:**
- Menangkap error jika user memasukkan input yang bukan angka.
- **`continue`**: Melompat kembali ke awal loop `while` untuk menampilkan menu lagi.

---

## 🎯 RINGKASAN KONSEP-KONSEP PENTING

### 1. **Inheritance (Pewarisan)**
Class `GameMtk` dan `Gametekateki` mewarisi dari class `Game`. Mereka mendapatkan variabel dan method dari parent class, serta bisa menambah atau mengubah functionality-nya.

### 2. **Abstraksi**
Class `Game` adalah class abstrak yang tidak bisa dibuat object secara langsung. Abstraksi memaksa semua child class untuk mengimplementasikan method abstract yang sudah ditetapkan.

### 3. **Polymorphism**
Dalam main method, bisa menggunakan tipe `Game` untuk mereferensi object `GameMtk` atau `Gametekateki`. Ketika method dipanggil, Java akan menjalankan versi yang tepat sesuai tipe object sebenarnya.

### 4. **Encapsulation**
Class `Pemain` menggunakan access modifier `private` untuk variabel, dan menyediakan getter/setter method untuk kontrol akses. Ini melindungi data dari perubahan yang tidak diinginkan.

### 5. **Exception Handling**
Menggunakan `try-catch` untuk menangani error input user agar program tidak crash.

---

## 🔧 ALUR EKSEKUSI PROGRAM

```
1. Program dimulai → main method dijalankan
2. Scanner dibuat untuk membaca input
3. Loop ulang dimulai → minta nama pemain
4. Object Pemain dibuat dengan nama tersebut
5. Object Game dibuat (GameMtk dan Gametekateki)
6. Menu ditampilkan
7. User memilih game (1 atau 2)
8. Polymorphism bekerja: method mainkan() yang tepat dijalankan
9. Pertanyaan ditampilkan, skor dikumpulkan
10. Skor ditambahkan ke object Pemain
11. Kembali ke menu (atau keluar jika user pilih 3)
12. Jika user pilih 3, loop berhenti, program berakhir
```

---

## ⚠️ CATATAN PERBAIKAN YANG BISA DILAKUKAN

1. **Penggunaan List untuk Nama**: Variabel `nama` menggunakan `List<String>`, tetapi di constructor tidak langsung diassign. Seharusnya:
   ```java
   public Pemain(String nama){
       this.nama = new ArrayList<>();
       this.nama.add(nama);  // Tambahkan ini
       this.skor = 0;
   }
   ```

2. **Input Validation**: Tambahkan validasi untuk memastikan nama tidak kosong.

3. **Method `getNama()`**: Return type `List<String>` sedikit aneh. Lebih baik:
   ```java
   public String getNama(){
       return nama.get(0); // Ambil nama pertama (dan satu-satunya)
   }
   ```

4. **Tracking Multiple Games**: Bisa ditambahkan tracking untuk game mana saja yang sudah dimainkan oleh pemain.

---