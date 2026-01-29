# 📝 Dokumentasi Lengkap - Aplikasi Rental PlayStation

Halo teman-teman! Selamat datang di dokumentasi lengkap proyek **Rental PlayStation**. Di sini gue bakal jelasin dari A sampai Z tentang gimana aplikasi ini dibuat, kenapa pakai teknik tertentu, dan konsep-konsep apa aja yang dipake. 

Siap-siap belajar ya! ☕

---

## 📚 Daftar Isi

1. [Pengenalan Proyek](#pengenalan-proyek)
2. [Konsep & Teknologi yang Digunakan](#konsep--teknologi-yang-digunakan)
3. [Struktur Database](#struktur-database)
4. [Penjelasan Code Detail](#penjelasan-code-detail)
5. [Flow Aplikasi](#flow-aplikasi)
6. [Tips & Trik](#tips--trik)

---

## 🎮 Pengenalan Proyek

### Apa sih Aplikasi Ini?

Ini adalah aplikasi **desktop** untuk mengelola rental PlayStation. Jadi bayangin aja, lo punya rental PS dan butuh sistem buat:
- Catat siapa aja yang ngrental
- Konsol apa yang dipilih
- Berapa lama rentnya
- Otomatis hitung total biaya
- Bisa edit atau hapus data transaksi

Nah, aplikasi ini solve semua masalah itu dengan antarmuka yang simple dan gampang dipake!

### Kenapa Pakai Java Swing?

Good question! Ini alasannya:

1. **GUI Native Desktop** - Swing udah built-in di Java, jadi ga perlu install library eksternal yang ribet
2. **Mature & Stable** - Teknologi ini udah bertahun-tahun dipake, dokumentasinya lengkap banget
3. **Cross-Platform** - Aplikasi bisa jalan di Windows, Mac, atau Linux tanpa perlu modifikasi code
4. **Perfect untuk CRUD** - Cocok banget buat aplikasi yang fokusnya Create, Read, Update, Delete data

---

## 🛠️ Konsep & Teknologi yang Digunakan

### 1. **MVC Pattern (Simplified Version)**

Meskipun ga strictly MVC, tapi code ini pakai konsep pemisahan:
- **Model** = Database (MySQL) yang nyimpen data
- **View** = Komponen GUI Swing (JFrame, JTable, JButton, dll)
- **Controller** = Method-method yang handle logic (simpanTransaksi, updateTransaksi, dll)

**Kenapa pakai konsep ini?**
- Bikin code lebih terorganisir
- Gampang di-maintain
- Kalau mau ganti database atau UI, ga ribet

### 2. **JDBC (Java Database Connectivity)**

Ini adalah teknologi standar Java buat komunikasi sama database.

**Kenapa pakai JDBC?**
- Native Java, ga perlu library tambahan
- Performance bagus
- Support hampir semua database (MySQL, PostgreSQL, Oracle, dll)

### 3. **CRUD Operations**

Aplikasi ini implement full CRUD:
- **Create** - Simpan transaksi baru
- **Read** - Tampilkan semua transaksi di tabel
- **Update** - Edit transaksi yang udah ada
- **Delete** - Hapus transaksi

**Kenapa CRUD penting?**
Karena 90% aplikasi bisnis itu intinya CRUD. Master ini = master fundamental programming!

### 4. **Event-Driven Programming**

Aplikasi ini pakai konsep event-driven dimana:
- User klik button → Trigger event
- Event di-handle sama ActionListener
- ActionListener jalanin method tertentu

```java
btnSimpan.addActionListener(e -> simpanTransaksi());
```

**Kenapa pakai Lambda Expression (`e ->`) ?**
- Lebih singkat daripada anonymous class
- Code lebih bersih dan readable
- Fitur Java 8+ yang modern

---

## 🗄️ Struktur Database

### Database: `rental_ps`

Aplikasi ini butuh 3 tabel utama:

#### 1. **Tabel `konsol`**
```sql
CREATE TABLE konsol (
    id_konsol INT PRIMARY KEY AUTO_INCREMENT,
    nama_konsol VARCHAR(50),
    harga_per_jam DOUBLE
);
```

**Fungsinya:**
Nyimpen data konsol yang tersedia (PS4, PS5, Xbox, dll) sama harga sewalnya per jam.

**Sample Data:**
```sql
INSERT INTO konsol VALUES 
(1, 'PlayStation 5', 15000),
(2, 'PlayStation 4', 10000),
(3, 'Xbox Series X', 12000);
```

#### 2. **Tabel `pelanggan`**
```sql
CREATE TABLE pelanggan (
    id_pelanggan INT PRIMARY KEY AUTO_INCREMENT,
    nama_pelanggan VARCHAR(100),
    kontak_pelanggan VARCHAR(20)
);
```

**Fungsinya:**
Nyimpen data customer yang rental.

#### 3. **Tabel `transaksi`**
```sql
CREATE TABLE transaksi (
    id_transaksi INT PRIMARY KEY AUTO_INCREMENT,
    id_pelanggan INT,
    id_konsol INT,
    lama_sewa INT,
    total_harga DOUBLE,
    FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan),
    FOREIGN KEY (id_konsol) REFERENCES konsol(id_konsol)
);
```

**Fungsinya:**
Nyimpen data transaksi rental. Relasi ke tabel pelanggan dan konsol pakai **Foreign Key**.

**Kenapa Pakai Foreign Key?**
- Jaga integritas data (ga bisa input id_pelanggan yang ga ada)
- Relasi antar tabel jadi jelas
- Database lebih terstruktur

---

## 💻 Penjelasan Code Detail

Sekarang kita masuk ke inti sarinya! Gue bakal jelasin setiap bagian code dengan detail.

### 📦 Import Statements

```java
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
```

**Kenapa import ini?**

1. **`java.sql.*`** 
   - Buat semua class JDBC (Connection, Statement, ResultSet, dll)
   - Diperlukan buat komunikasi ke database

2. **`javax.swing.*`**
   - Semua komponen GUI (JFrame, JButton, JTextField, dll)
   - Core library buat bikin interface desktop

3. **`javax.swing.table.DefaultTableModel`**
   - Khusus buat manage data di JTable
   - Import terpisah karena ada di sub-package

---

### 🏗️ Class Declaration & Variables

```java
public class RentalPlayStation extends JFrame {
    private JTextField tfNamaPelanggan, tfKontak, tfLamaSewa;
    private JComboBox<String> cbKonsol;
    private JTable table;
    private DefaultTableModel model;
    private Connection conn;
```

**Breakdown:**

1. **`extends JFrame`**
   - JFrame = window/frame aplikasi desktop
   - Dengan extends JFrame, class kita jadi window yang bisa ditampilkan
   - Otomatis punya method-method kayak setTitle(), setSize(), setVisible()

2. **`private`**
   - Semua variable dideklarasiin private buat **encapsulation**
   - Ga bisa diakses dari luar class
   - Best practice OOP!

3. **Variable-variable GUI:**
   - `JTextField` = Kotak input text (nama, kontak, lama sewa)
   - `JComboBox<String>` = Dropdown menu (pilih konsol)
   - `JTable` = Tabel buat nampilin data transaksi
   - `DefaultTableModel` = Model yang manage data di JTable

4. **`Connection conn`**
   - Object buat koneksi ke database MySQL
   - Disimpan sebagai instance variable supaya bisa dipake di semua method

**Kenapa simpan Connection sebagai instance variable?**
- Koneksi cuma dibuat sekali waktu aplikasi start
- Semua method bisa pakai koneksi yang sama
- Lebih efisien daripada buat koneksi baru tiap method

---

### 🔌 Constructor - Database Connection

```java
public RentalPlayStation() {
    try {
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/rental_ps", 
            "root", 
            ""
        );
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, 
            "Koneksi Database Gagal: " + e.getMessage());
        System.exit(0);
    }
```

**Penjelasan:**

1. **Constructor**
   - Otomatis jalan waktu object dibuat
   - Di sini kita setup database connection dulu sebelum yang lain

2. **`DriverManager.getConnection()`**
   - Method JDBC buat buat koneksi ke database
   - Parameter 1: URL database (protocol:vendor://host:port/database_name)
   - Parameter 2: Username MySQL (default "root")
   - Parameter 3: Password (kosong kalau default XAMPP)

3. **Try-Catch Block**
   - Koneksi database bisa gagal (server mati, password salah, dll)
   - Kita tangkap error pakai catch
   - Kalau gagal, tampilkan pesan error dan tutup aplikasi

**Kenapa pakai `System.exit(0)`?**
- Kalau database ga konek, aplikasi ga bakal jalan dengan benar
- Daripada error terus-terusan, mending langsung tutup aja
- Exit code 0 = normal termination

---

### 🎨 GUI Setup - Frame Configuration

```java
setTitle("Rental PlayStation");
setSize(800, 600);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLayout(null);
```

**Penjelasan:**

1. **`setTitle()`**
   - Text yang muncul di title bar window
   - Kasih nama yang jelas sesuai aplikasi

2. **`setSize(800, 600)`**
   - Width = 800 pixel
   - Height = 600 pixel
   - Ukuran cukup buat nampilin semua komponen

3. **`setDefaultCloseOperation(EXIT_ON_CLOSE)`**
   - Apa yang terjadi kalau user klik tombol X
   - EXIT_ON_CLOSE = tutup aplikasi sepenuhnya
   - Alternatif: HIDE_ON_CLOSE, DO_NOTHING_ON_CLOSE

4. **`setLayout(null)`**
   - Pakai **Absolute Positioning** (manual atur posisi)
   - Ga pakai layout manager (FlowLayout, BorderLayout, dll)
   
**Kenapa pakai Absolute Positioning?**
- **Pro:** Full control posisi setiap komponen, gampang buat pemula
- **Con:** Ga responsive, ga adjust otomatis kalau window di-resize
- **Alternatif:** GridBagLayout (lebih flexible tapi lebih kompleks)

---

### 📝 Input Fields - Nama Pelanggan

```java
JLabel lblNama = new JLabel("Nama Pelanggan:");
lblNama.setBounds(20, 20, 125, 25);
add(lblNama);

tfNamaPelanggan = new JTextField();
tfNamaPelanggan.setBounds(150, 20, 200, 25);
add(tfNamaPelanggan);
```

**Penjelasan:**

1. **JLabel**
   - Cuma text static buat label/keterangan
   - Ga bisa di-edit user

2. **`setBounds(x, y, width, height)`**
   - x = 20 pixel dari kiri
   - y = 20 pixel dari atas
   - width = 125 pixel
   - height = 25 pixel

3. **JTextField**
   - Kotak input yang bisa diketik user
   - Dipake buat input nama pelanggan

4. **`add()`**
   - Tambahin komponen ke JFrame
   - Tanpa ini, komponen ga bakal muncul

**Pattern yang Sama Dipakai Buat:**
- Kontak pelanggan
- Lama sewa
- Dan input lainnya

**Kenapa posisi Y naik 40-40?**
- 20, 60, 100, 140...
- Kasih jarak vertikal 40 pixel antar komponen
- Biar ga terlalu rapat, enak dilihat

---

### 📋 ComboBox - Pilihan Konsol

```java
JLabel lblKonsol = new JLabel("Konsol:");
lblKonsol.setBounds(20, 100, 120, 25);
add(lblKonsol);

cbKonsol = new JComboBox<>();
cbKonsol.setBounds(150, 100, 200, 25);
add(cbKonsol);
loadKonsol(); // Memuat data konsol dari database
```

**Kenapa pakai JComboBox?**
- User pilih dari opsi yang udah ditentukan
- Ga bisa sembarangan input (validasi built-in)
- Lebih user-friendly daripada ketik manual

**Generic Type `<String>`:**
- JComboBox bisa nyimpen tipe data apa aja
- Kita specify String biar type-safe
- Hindari ClassCastException

**`loadKonsol()` dipanggil di constructor:**
- Load data konsol dari database waktu aplikasi start
- ComboBox langsung terisi opsi-opsi konsol yang available

---

### 🔽 Method loadKonsol() - Load Data ke ComboBox

```java
private void loadKonsol() {
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM konsol");
        while (rs.next()) {
            cbKonsol.addItem(
                rs.getString("id_konsol") + " - " + 
                rs.getString("nama_konsol") + " (" + 
                rs.getDouble("harga_per_jam") + "/jam)"
            );
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, 
            "Gagal Memuat Data Konsol: " + e.getMessage());
    }
}
```

**Breakdown:**

1. **`Statement stmt`**
   - Object buat eksekusi SQL query
   - Created dari connection yang udah ada

2. **`executeQuery()`**
   - Jalanin SELECT query
   - Return ResultSet (hasil query)

3. **`ResultSet rs`**
   - Kaya iterator/cursor yang bisa loop data hasil query
   - Awalnya posisi sebelum row pertama

4. **`while (rs.next())`**
   - Pindahin cursor ke row berikutnya
   - Return true kalau ada row, false kalau udah habis
   - Loop sampe semua row keproses

5. **`rs.getString()` / `rs.getDouble()`**
   - Ambil value dari kolom tertentu
   - Bisa pakai nama kolom atau index (1, 2, 3...)

6. **Format String:**
   - "1 - PlayStation 5 (15000.0/jam)"
   - User bisa liat: ID, Nama, Harga sekaligus
   - Format ini dipake lagi waktu parsing di method simpan

**Kenapa pakai Try-Catch?**
- Query bisa error (tabel ga ada, syntax salah, dll)
- Exception handling biar aplikasi ga crash
- User dapet feedback error yang jelas

---

### 🔘 Button Setup - CRUD Actions

```java
JButton btnSimpan = new JButton("Simpan");
btnSimpan.setBounds(150, 180, 100, 25);
add(btnSimpan);

JButton btnUpdate = new JButton("Update");
btnUpdate.setBounds(260, 180, 100, 25);
add(btnUpdate);

JButton btnDelete = new JButton("Delete");
btnDelete.setBounds(370, 180, 100, 25);
add(btnDelete);

btnSimpan.addActionListener(e -> simpanTransaksi());
btnUpdate.addActionListener(e -> updateTransaksi());
btnDelete.addActionListener(e -> deleteTransaksi());
```

**Penjelasan:**

1. **3 Button Utama:**
   - Simpan = CREATE (insert data baru)
   - Update = UPDATE (edit data yang udah ada)
   - Delete = DELETE (hapus data)

2. **Posisi Horizontal:**
   - x = 150, 260, 370
   - Jarak 110 pixel antar button (100 width + 10 spacing)
   - Sejajar horizontal di y = 180

3. **ActionListener dengan Lambda:**
   ```java
   e -> simpanTransaksi()
   ```
   - `e` = ActionEvent object (info tentang event)
   - `->` = lambda operator
   - `simpanTransaksi()` = method yang dipanggil

**Kenapa Lambda lebih bagus?**

Sebelum Java 8 harus gini:
```java
btnSimpan.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        simpanTransaksi();
    }
});
```

Dengan lambda jadi super singkat:
```java
btnSimpan.addActionListener(e -> simpanTransaksi());
```

**Lambda = Anonymous Function:**
- Ga perlu bikin class baru
- Code lebih clean
- Perfect buat simple callback

---

### 📊 Table Setup - Tampilan Data

```java
model = new DefaultTableModel(
    new String[]{"ID", "Nama Pelanggan", "Konsol", "Lama Sewa", "Total Harga"}, 
    0
);
table = new JTable(model);
JScrollPane spTable = new JScrollPane(table);
spTable.setBounds(20, 220, 750, 300);
add(spTable);

loadTransaksi();
```

**Breakdown:**

1. **DefaultTableModel**
   - Model yang manage data di tabel
   - Parameter 1: Array nama kolom
   - Parameter 2: Initial row count (0 = kosong dulu)

2. **JTable**
   - Visual component yang nampilin data
   - Butuh model buat tau data apa yang ditampilin

3. **JScrollPane**
   - Wrapper buat JTable
   - Otomatis kasih scrollbar kalau data banyak
   - **PENTING:** JTable HARUS dibungkus JScrollPane!

**Kenapa pakai Model-View Pattern?**
- Model (DefaultTableModel) = Data
- View (JTable) = Display
- Pisahin logic dan presentation
- Gampang update data tanpa recreate table

4. **`loadTransaksi()`**
   - Dipanggil di constructor buat load data awal
   - Tabel langsung terisi waktu aplikasi dibuka

---

### 💾 Method simpanTransaksi() - CREATE Operation

Ini method paling kompleks! Gue bakal jelasin step by step:

#### Step 1: Ambil Data dari Form

```java
String nama = tfNamaPelanggan.getText();
String kontak = tfKontak.getText();
int lamaSewa = Integer.parseInt(tfLamaSewa.getText());
String konsol = (String) cbKonsol.getSelectedItem();
```

**Penjelasan:**
- `getText()` = ambil text dari JTextField
- `Integer.parseInt()` = convert String ke int
- `getSelectedItem()` = ambil item yang dipilih di ComboBox
- Cast ke String karena return type-nya Object

**Kenapa perlu parsing?**
- TextField cuma return String
- Kita butuh int buat lama sewa
- Database field-nya tipe INT

#### Step 2: Validasi Input

```java
if (nama.isEmpty() || kontak.isEmpty() || konsol == null) {
    JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
    return;
}
```

**Kenapa validasi penting?**
- Cegah data kosong masuk database
- User experience lebih baik (dapet feedback langsung)
- Hindari error di database

**`return;`**
- Keluar dari method kalau validasi gagal
- Code dibawahnya ga dieksekusi

#### Step 3: Extract ID Konsol

```java
int idKonsol = Integer.parseInt(konsol.split(" - ")[0]);
```

**Kenapa pakai split?**
- String konsol format: "1 - PlayStation 5 (15000.0/jam)"
- `split(" - ")` = pecah jadi array ["1", "PlayStation 5 (15000.0/jam)"]
- `[0]` = ambil elemen pertama = "1"
- Parse jadi int

**Alternatif:**
Bisa juga simpan id_konsol hidden, tapi cara ini lebih simple untuk aplikasi kecil.

#### Step 4: Insert Data Pelanggan

```java
PreparedStatement psPelanggan = conn.prepareStatement(
    "INSERT INTO pelanggan (nama_pelanggan, kontak_pelanggan) VALUES (?, ?)", 
    Statement.RETURN_GENERATED_KEYS
);
psPelanggan.setString(1, nama);
psPelanggan.setString(2, kontak);
psPelanggan.executeUpdate();
```

**Kenapa pakai PreparedStatement?**
1. **Security** - Cegah SQL Injection
2. **Performance** - Query di-compile sekali, bisa dipakai berkali-kali
3. **Readability** - Lebih jelas daripada concat string

**Placeholder `?`:**
- Penanda parameter yang bakal di-set nanti
- `setString(1, nama)` = ganti ? pertama dengan nilai nama
- `setString(2, kontak)` = ganti ? kedua dengan nilai kontak

**`Statement.RETURN_GENERATED_KEYS`:**
- Kasih tau kita butuh auto-generated ID (id_pelanggan)
- Penting buat dapat ID yang baru di-generate

#### Step 5: Ambil ID Pelanggan yang Baru

```java
ResultSet rsPelanggan = psPelanggan.getGeneratedKeys();
rsPelanggan.next();
int idPelanggan = rsPelanggan.getInt(1);
```

**Kenapa butuh ID ini?**
- Buat insert ke tabel transaksi
- Transaksi butuh tau id_pelanggan-nya berapa

**`getInt(1)`:**
- Ambil value kolom pertama (auto-generated id)
- Index dimulai dari 1, bukan 0!

#### Step 6: Hitung Total Harga

```java
PreparedStatement psKonsol = conn.prepareStatement(
    "SELECT harga_per_jam FROM konsol WHERE id_konsol = ?"
);
psKonsol.setInt(1, idKonsol);
ResultSet rsKonsol = psKonsol.executeQuery();
rsKonsol.next();
double hargaPerJam = rsKonsol.getDouble(1);
double totalHarga = hargaPerJam * lamaSewa;
```

**Flow:**
1. Query harga per jam dari tabel konsol
2. Kalikan dengan lama sewa
3. Dapat total harga

**Kenapa ga ambil harga dari String konsol?**
- Data di database bisa berubah
- Query langsung ke DB lebih akurat
- Ini **Single Source of Truth** principle

#### Step 7: Insert Transaksi

```java
PreparedStatement psTransaksi = conn.prepareStatement(
    "INSERT INTO transaksi (id_pelanggan, id_konsol, lama_sewa, total_harga) VALUES (?, ?, ?, ?)"
);
psTransaksi.setInt(1, idPelanggan);
psTransaksi.setInt(2, idKonsol);
psTransaksi.setInt(3, lamaSewa);
psTransaksi.setDouble(4, totalHarga);
psTransaksi.executeUpdate();
```

**Final insert:**
- Semua data udah lengkap
- Insert ke tabel transaksi
- `executeUpdate()` = jalanin INSERT/UPDATE/DELETE query

#### Step 8: Feedback & Refresh

```java
JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan!");
loadTransaksi();
```

**User Experience:**
- Kasih feedback sukses
- Refresh tabel biar data baru langsung muncul

#### Step 9: Error Handling

```java
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, 
        "Gagal Menyimpan Transaksi: " + e.getMessage());
}
```

**Kenapa catch Exception bukan SQLException?**
- `Integer.parseInt()` bisa throw NumberFormatException
- Lebih aman catch semua exception
- User tetap dapet feedback kalau ada error

---

### ✏️ Method updateTransaksi() - UPDATE Operation

```java
private void updateTransaksi() {
    try {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Pilih transaksi yang ingin diupdate!");
            return;
        }
```

**Konsep Baru: Table Selection**

1. **`getSelectedRow()`**
   - Return index row yang dipilih user
   - Return -1 kalau ga ada yang dipilih

2. **Validasi Selection:**
   - Cek dulu ada row yang dipilih atau engga
   - Kalau -1, kasih pesan error

**User Flow:**
1. User klik row di tabel
2. Edit data di form
3. Klik Update
4. Data terupdate

#### Ambil ID Transaksi

```java
int idTransaksi = (int) model.getValueAt(selectedRow, 0);
```

**`getValueAt(row, column)`:**
- Ambil value dari cell tertentu
- Column 0 = kolom pertama = ID
- Di-cast ke int karena return Object

#### Update Pelanggan

```java
PreparedStatement psPelanggan = conn.prepareStatement(
    "UPDATE pelanggan SET nama_pelanggan = ?, kontak_pelanggan = ? " +
    "WHERE id_pelanggan = (SELECT id_pelanggan FROM transaksi WHERE id_transaksi = ?)"
);
psPelanggan.setString(1, nama);
psPelanggan.setString(2, kontak);
psPelanggan.setInt(3, idTransaksi);
psPelanggan.executeUpdate();
```

**Subquery di WHERE:**
- Cari id_pelanggan dari transaksi
- Update pelanggan berdasarkan id_pelanggan itu
- Elegant! Ga perlu query terpisah

#### Update Transaksi

```java
PreparedStatement psTransaksi = conn.prepareStatement(
    "UPDATE transaksi SET id_konsol = ?, lama_sewa = ?, total_harga = ? " +
    "WHERE id_transaksi = ?"
);
psTransaksi.setInt(1, idKonsol);
psTransaksi.setInt(2, lamaSewa);
psTransaksi.setDouble(3, totalHarga);
psTransaksi.setInt(4, idTransaksi);
psTransaksi.executeUpdate();
```

**SET Clause:**
- Tentuin kolom mana yang mau diupdate
- WHERE clause = kondisi row mana yang diupdate

---

### 🗑️ Method deleteTransaksi() - DELETE Operation

```java
private void deleteTransaksi() {
    try {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Pilih transaksi yang ingin dihapus!");
            return;
        }

        int idTransaksi = (int) model.getValueAt(selectedRow, 0);
```

**Pattern yang Sama:**
- Validasi selection
- Ambil ID transaksi

#### Konfirmasi Dialog

```java
int confirm = JOptionPane.showConfirmDialog(this, 
    "Apakah Anda yakin ingin menghapus transaksi ini?", 
    "Konfirmasi Hapus", 
    JOptionPane.YES_NO_OPTION, 
    JOptionPane.WARNING_MESSAGE
);
```

**Kenapa perlu konfirmasi?**
- Delete = permanent action
- Hindari accident (klik ga sengaja)
- Best practice UX!

**Return Value:**
- YES_OPTION = user klik Yes
- NO_OPTION = user klik No
- CLOSED_OPTION = user tutup dialog

#### Execute Delete

```java
if (confirm == JOptionPane.YES_OPTION) {
    PreparedStatement psTransaksi = conn.prepareStatement(
        "DELETE FROM transaksi WHERE id_transaksi = ?"
    );
    psTransaksi.setInt(1, idTransaksi);
    psTransaksi.executeUpdate();

    JOptionPane.showMessageDialog(this, "Transaksi berhasil dihapus!");
    loadTransaksi();
}
```

**Simple DELETE:**
- Cuma hapus dari tabel transaksi
- Data pelanggan tetap ada (bisa dipake lagi nanti)

**Alternatif Design:**
- Bisa juga soft delete (flag deleted = true)
- Atau hapus pelanggan juga kalau ga ada transaksi lain

---

### 📖 Method loadTransaksi() - READ Operation

```java
private void loadTransaksi() {
    model.setRowCount(0);
```

**Clear Table:**
- Set row count jadi 0 = hapus semua data lama
- Biar ga duplicate waktu reload

#### Complex JOIN Query

```java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(
    "SELECT t.id_transaksi, p.nama_pelanggan, k.nama_konsol, " +
    "t.lama_sewa, t.total_harga " +
    "FROM transaksi t " +
    "JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan " +
    "JOIN konsol k ON t.id_konsol = k.id_konsol"
);
```

**SQL JOIN Explanation:**

1. **Table Aliases:**
   - `t` = transaksi
   - `p` = pelanggan
   - `k` = konsol
   - Bikin query lebih pendek

2. **JOIN Operation:**
   - Gabungin 3 tabel jadi 1 result set
   - JOIN ON = kondisi penggabungan
   - t.id_pelanggan = p.id_pelanggan = cocokkan ID

**Kenapa pakai JOIN?**
- Data tersebar di 3 tabel
- User mau liat nama pelanggan, bukan ID
- JOIN = combine data jadi readable

#### Populate Table

```java
while (rs.next()) {
    model.addRow(new Object[]{
        rs.getInt(1),      // ID transaksi
        rs.getString(2),   // Nama pelanggan
        rs.getString(3),   // Nama konsol
        rs.getInt(4),      // Lama sewa
        rs.getDouble(5)    // Total harga
    });
}
```

**`model.addRow()`:**
- Tambahin row baru ke table model
- Parameter = array of Object
- Urutan harus sesuai kolom di SELECT query

**Index dimulai dari 1:**
- JDBC ResultSet index dari 1
- Beda sama array Java yang dari 0
- Hati-hati, sering bikin bug!

---

### 🚀 Main Method - Entry Point

```java
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> 
        new RentalPlayStation().setVisible(true)
    );
}
```

**Breakdown:**

1. **`main` method:**
   - Entry point aplikasi Java
   - Dipanggil waktu program dijalankan

2. **`SwingUtilities.invokeLater()`:**
   - Jalanin code di **Event Dispatch Thread (EDT)**
   - Thread khusus buat GUI Swing

**Kenapa ga langsung `new RentalPlayStation()`?**
- Swing component HARUS dibuat di EDT
- Thread safety!
- Hindari concurrency issues

3. **Lambda Expression:**
   ```java
   () -> new RentalPlayStation().setVisible(true)
   ```
   - `()` = ga ada parameter
   - Create object RentalPlayStation
   - `setVisible(true)` = tampilin window

**Chaining Method:**
- Constructor return object
- Langsung bisa call method `setVisible()`
- Concise dan elegant!

---

## 🔄 Flow Aplikasi

### 1️⃣ Skenario: Simpan Transaksi Baru

```
User Buka Aplikasi
    ↓
Constructor dipanggil
    ↓
Koneksi Database dibuat
    ↓
GUI components di-setup
    ↓
loadKonsol() → ComboBox terisi
    ↓
loadTransaksi() → Table terisi
    ↓
User isi form (nama, kontak, konsol, lama sewa)
    ↓
User klik button "Simpan"
    ↓
ActionListener trigger → simpanTransaksi()
    ↓
Validasi input
    ↓
Insert ke tabel pelanggan → dapat id_pelanggan
    ↓
Query harga konsol
    ↓
Hitung total harga
    ↓
Insert ke tabel transaksi
    ↓
JOptionPane tampil "Berhasil"
    ↓
loadTransaksi() → Table refresh
    ↓
User liat data baru di tabel
```

### 2️⃣ Skenario: Update Transaksi

```
User pilih row di table
    ↓
User edit data di form
    ↓
User klik "Update"
    ↓
Validasi selection (ada row dipilih?)
    ↓
Ambil id_transaksi dari row
    ↓
Update tabel pelanggan
    ↓
Update tabel transaksi
    ↓
Feedback & refresh
```

### 3️⃣ Skenario: Delete Transaksi

```
User pilih row di table
    ↓
User klik "Delete"
    ↓
Validasi selection
    ↓
JOptionPane konfirmasi
    ↓
User klik "Yes"
    ↓
DELETE query dieksekusi
    ↓
Feedback & refresh
```

---

## 💡 Tips & Trik

### 1. **Connection Management**

**Current Code:**
```java
private Connection conn;
```

**Best Practice untuk Production:**
```java
// Tutup connection waktu aplikasi ditutup
@Override
public void dispose() {
    try {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    super.dispose();
}
```

### 2. **Input Validation yang Lebih Baik**

**Enhanced Validation:**
```java
// Validasi lama sewa harus angka positif
try {
    int lamaSewa = Integer.parseInt(tfLamaSewa.getText());
    if (lamaSewa <= 0) {
        JOptionPane.showMessageDialog(this, 
            "Lama sewa harus lebih dari 0!");
        return;
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, 
        "Lama sewa harus berupa angka!");
    return;
}
```

### 3. **Clear Form Setelah Simpan**

```java
private void clearForm() {
    tfNamaPelanggan.setText("");
    tfKontak.setText("");
    tfLamaSewa.setText("");
    cbKonsol.setSelectedIndex(0);
}

// Panggil di akhir simpanTransaksi()
clearForm();
```

### 4. **Auto-Select Row Setelah Insert**

```java
// Di akhir simpanTransaksi()
int lastRow = model.getRowCount() - 1;
table.setRowSelectionInterval(lastRow, lastRow);
```

### 5. **Format Currency**

```java
import java.text.NumberFormat;
import java.util.Locale;

// Di loadTransaksi()
NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(
    new Locale("id", "ID")
);
String formattedPrice = currencyFormat.format(rs.getDouble(5));
model.addRow(new Object[]{
    rs.getInt(1),
    rs.getString(2),
    rs.getString(3),
    rs.getInt(4),
    formattedPrice  // Rp 150.000,00
});
```

---

## 🎯 Konsep Penting yang Dipelajari

### 1. **Object-Oriented Programming (OOP)**
- Class & Object
- Encapsulation (private variables)
- Inheritance (extends JFrame)

### 2. **Database Concepts**
- CRUD Operations
- SQL Queries (SELECT, INSERT, UPDATE, DELETE)
- JOIN Operations
- Foreign Key Relations
- Primary Key & Auto Increment

### 3. **GUI Programming**
- Event-Driven Programming
- ActionListener & Lambda
- Layout Management
- User Input Handling

### 4. **JDBC (Java Database Connectivity)**
- Connection Management
- Statement vs PreparedStatement
- ResultSet
- Exception Handling

### 5. **Design Patterns**
- Model-View (simplified MVC)
- Separation of Concerns

### 6. **Best Practices**
- Input Validation
- Error Handling (Try-Catch)
- User Feedback (JOptionPane)
- Confirmation Dialogs

---

## 🚨 Common Errors & Solutions

### Error 1: "No suitable driver found"

**Penyebab:**
- MySQL JDBC driver belum ada
- Belum ditambahkan ke classpath

**Solution:**
1. Download `mysql-connector-java.jar`
2. Add ke project libraries
3. Di IDE: Project Properties → Libraries → Add JAR

### Error 2: "Access denied for user 'root'@'localhost'"

**Penyebab:**
- Password salah
- User ga punya permission

**Solution:**
```java
// Sesuaikan dengan setup MySQL lo
conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/rental_ps", 
    "your_username",  // Ganti
    "your_password"   // Ganti
);
```

### Error 3: Table doesn't exist

**Penyebab:**
- Database belum dibuat
- Tabel belum dibuat

**Solution:**
```sql
-- Jalanin di MySQL
CREATE DATABASE rental_ps;
USE rental_ps;

-- Create tables (lihat bagian Struktur Database)
```

### Error 4: NumberFormatException

**Penyebab:**
- User input text di field lama sewa
- Empty string di-parse jadi int

**Solution:**
- Add validation (lihat Tips & Trik #2)

---

## 📈 Pengembangan Lebih Lanjut

### Ideas untuk Improve:

1. **Fitur Login**
   - Admin & user biasa
   - Role-based access

2. **Laporan**
   - Transaksi per hari/bulan
   - Export to PDF/Excel

3. **Search & Filter**
   - Cari berdasarkan nama
   - Filter by konsol

4. **Durasi Real-Time**
   - Timer countdown
   - Notifikasi waktu habis

5. **Multiple Konsol**
   - Rental lebih dari 1 konsol
   - Shopping cart concept

6. **Pembayaran**
   - Status: Lunas/Belum
   - Metode bayar

7. **Database Connection Pool**
   - Lebih efisien untuk banyak user
   - Pakai HikariCP

8. **Better UI/UX**
   - Pakai JavaFX (lebih modern)
   - Atau bikin web app (Spring Boot + React)

---

## 🎓 Kesimpulan

Proyek ini adalah **fundamental** dari aplikasi CRUD desktop. Konsep-konsep yang dipelajari di sini applicable ke berbagai aplikasi lain:

✅ Rental mobil  
✅ Kasir toko  
✅ Perpustakaan  
✅ Inventory management  
✅ Dan masih banyak lagi!

**Key Takeaways:**
- JDBC untuk database connectivity
- Swing untuk GUI desktop
- PreparedStatement untuk security
- Separation of concerns
- Error handling yang baik
- User experience yang diperhatikan

---

## 📚 Resources untuk Belajar Lebih Lanjut

1. **JDBC Tutorial:**
   - Oracle JDBC Documentation
   - TutorialsPoint JDBC

2. **Java Swing:**
   - Oracle Swing Tutorial
   - Java2s Swing Examples

3. **SQL:**
   - W3Schools SQL Tutorial
   - SQLZoo

4. **Best Practices:**
   - Effective Java by Joshua Bloch
   - Clean Code by Robert C. Martin

---

## 🙏 Penutup

Semoga dokumentasi ini membantu lo memahami proyek Rental PlayStation dari A sampai Z! Kalau ada pertanyaan atau mau diskusi, feel free to reach out.

**Happy Coding!** 🚀

---

*Dokumentasi ini dibuat dengan ❤️ untuk membantu teman-teman belajar Java programming*

**Last Updated:** Januari 2026  
**Version:** 1.0