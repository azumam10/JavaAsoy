📝 Dokumentasi Lengkap - Studi Kasus PBO: Produk Elektronik
Halo dek! Selamat datang di catatan bedah kode. Di sini kita bakal bahas gimana cara bikin sistem manajemen stok barang pakai konsep PBO (Pemrograman Berorientasi Objek) yang bener.

Kita nggak cuma ngetik kode, tapi kita lagi belajar gimana cara bikin program yang rapi, aman, dan gampang dikembangin. ☕

📚 Daftar Isi
Pengenalan Konsep

Teknik Utama yang Digunakan

Penjelasan Code: Super Class (Produk)

Penjelasan Code: Sub Class (Elektronik)

Penjelasan Code: Main Class

Flow Aplikasi

🏗️ Pengenalan Konsep
Di proyek kecil ini, kita punya dua entitas: Produk dan Elektronik. Hubungannya simpel: Elektronik adalah sebuah Produk.

Dalam PBO, kita nggak mau nulis hal yang sama dua kali. Kalau semua barang punya nama dan harga, kenapa harus ditulis ulang di setiap class? Di sinilah kita pakai Inheritance (Pewarisan).

🛠️ Teknik Utama yang Digunakan
1. Encapsulation (Enkapsulasi)
Kita pakai akses private buat variabel.

Kenapa? Biar data nggak bisa diubah sembarangan dari luar class. Kalau mau ubah stok, harus lewat method TambahStok() yang udah ada validasinya. Data jadi aman dari human error.

2. Inheritance (Pewarisan)
Menggunakan keyword extends.

Kenapa? Biar class Elektronik bisa langsung punya fitur Produk (nama, harga, stok) tanpa ngetik ulang. Hemat tenaga, kode jadi bersih!

3. Method Overriding
Menulis ulang method info() milik bapak (Produk) di class anak (Elektronik).

Kenapa? Biar si anak bisa nambahin info unik (kayak Masa Garansi) yang nggak dipunyai produk biasa.

💻 Penjelasan Code: Super Class (Produk.java)
Ini adalah pondasi kita. Semua barang di toko kita pasti punya Nama, Harga, dan Stok.

Java
public class Produk {
    // 1. Data dikunci (Private) biar aman
    private String Namaproduk;
    private double harga;
    private int stok;

    // 2. Constructor: Setting data awal pas objek dibuat
    public Produk(String Namaproduk, double harga, int stok) {
        this.Namaproduk = Namaproduk;
        this.harga = harga;
        this.stok = stok;
    }

    // 3. Method Logika: Nambah stok dengan validasi
    public void TambahStok(Scanner scan) {
        System.out.print("Masukkan jumlah stok : ");
        int jumlah = scan.nextInt();
        if (jumlah > 0) {
            stok += jumlah; 
            System.out.println("Sip! Stok sekarang: " + stok);
        } else {
            System.out.println("Mana ada nambah stok tapi angkanya minus?");
        }
    }
}
💻 Penjelasan Code: Sub Class (Elektronik.java)
Ini adalah spesialisasi. Elektronik ngambil semua sifat Produk tapi ditambahin fitur Garansi.

Java
public class Elektronik extends Produk { // Keyword 'extends' adalah kuncinya!
    private String garansi;

    public Elektronik(String nama, double harga, int stok, String garansi) {
        // Manggil constructor Bapaknya pakai 'super'
        super(nama, harga, stok); 
        this.garansi = garansi;
    }

    // Method Overriding: Modifikasi info biar lebih lengkap
    @Override
    public void info() {
        super.info(); // Jalankan dulu info standar dari Bapak
        System.out.println("Garansi: " + garansi); // Tambahin info garansi
    }
}
💻 Penjelasan Code: Main Class (Main.java)
Ini adalah "Remote Control" buat jalanin semuanya. Kita pakai menu interaktif.

Java
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    // Bikin objek Elektronik (Anak)
    Elektronik produk = new Elektronik("Mouse Fantech", 100000, 10, "1 Tahun");

    int pilih;
    // Pakai do-while biar menu muncul minimal satu kali
    do {
        System.out.println("\n=== MENU PRODUK ===");
        System.out.println("1. Tambah Stok\n2. Kurangi Stok\n3. Info\n4. Keluar");
        System.out.print("Pilihan: ");
        pilih = scan.nextInt();

        switch (pilih) {
            case 1 -> produk.TambahStok(scan);
            case 2 -> produk.KurangStok(scan);
            case 3 -> produk.info();
            case 4 -> System.out.println("Program Selesai!");
            default -> System.out.println("Pilihan salah, dek!");
        }
    } while (pilih != 4); // Berhenti kalau user pilih 4
}
🔄 Flow Aplikasi
Inisialisasi: Program jalan, objek Elektronik dibuat di memori dengan data default (Nama: Mouse, Stok: 10, Garansi: 1 Thn).

Looping Menu: User dikasih 4 pilihan. Kita pakai do-while karena kita harus nanya dulu ke user sebelum ngecek kondisinya.

Eksekusi: * Kalau pilih 1, method TambahStok() dari class Produk jalan.

Kalau pilih 3, method info() dari class Elektronik jalan (yang udah di-override).

Terminasi: User pilih 4, loop berhenti, program kelar.

💡 Tips Buat Kamu
Keyword this: Dipakai buat nunjuk variabel di dalam class itu sendiri biar nggak ketuker sama parameter.

Keyword super: Dipakai buat manggil "Bapak"-nya. Jangan dilupain ya!

Validasi: Selalu cek input user (kayak if (jumlah > 0)). Program yang bagus adalah program yang nggak gampang crash kalau user salah input.