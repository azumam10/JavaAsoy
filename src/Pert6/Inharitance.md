📖 Catatan Belajar PBO: Memahami Pewarisan (Inheritance)
Halo Dek! Kalau kamu lagi baca ini, berarti kamu lagi masuk ke materi paling seru di Java, yaitu Inheritance. Jangan pusing dulu liat kodenya yang panjang, kita bedah pelan-pelan ya.

🧐 Apa itu Inheritance?
Inheritance (Pewarisan) itu simpelnya adalah cara kita bikin class baru tapi gak perlu nulis kode dari nol. Kita "minjem" atau "mewarisi" sifat dari class yang udah ada.

Kenapa pakai ini? Biar kita gak copy-paste kode yang sama berulang kali. Kalau bisa diwarisin, ngapain nulis ulang?

Kapan pakai ini? Pas kamu punya hubungan "Is-A" (Adalah). Contoh: Elektronik adalah Produk. Kucing adalah Hewan.

Ciri utamanya di Java adalah keyword extends.

Java
public class Elektronik extends Produk { 
    // Artinya Elektronik adalah anak dari Produk
}
Langkah 1: Buat Super Class (Produk.java)
Ini adalah "Bapak" atau Template Dasar-nya. Isinya adalah hal-hal umum yang pasti dipunyai semua barang, mau itu baju, makanan, atau elektronik.

Apa aja isinya?
Atribut (Data): Nama, harga, dan stok. Kita set private biar aman (Encapsulation).

Constructor: Buat nyiapin data pas barang baru dibikin.

Method Logika: Fungsi buat nambah dan kurangin stok.

Contoh Codenya:

Java
public class Produk {
    private String Namaproduk;
    private double harga;
    private int stok;

    // Ini Constructor: Biar pas "Lahir" barangnya udah punya nama & harga
    public Produk(String Namaproduk, double harga, int stok) {
        this.Namaproduk = Namaproduk;
        this.harga = harga;
        this.stok = stok;
    }

    // Fungsi buat nambah stok (Logika Bisnis)
    public void TambahStok(Scanner scan) {
        System.out.print("Masukkan jumlah stok : ");
        int jumlah = scan.nextInt();
        if (jumlah > 0) {
            stok += jumlah; // Stok nambah
            System.out.println("Sip! Stok sekarang: " + stok);
        }
    }
}
Langkah 2: Buat Sub Class / Class Pewarisan (Elektronik.java)
Nah, di sini keajaibannya. Elektronik itu anak dari Produk. Dia punya semua yang dipunyai Produk, tapi dia punya ciri khas sendiri: Garansi.

Apa yang spesial di sini?
super(): Kita manggil Constructor Bapaknya. Karena Bapaknya butuh Nama & Harga, si Anak harus setor data itu ke atas.

super.info(): Kita manggil fungsi info punya Bapak, terus kita tambahin info Garansi di bawahnya. Ini namanya Overriding (Menimpa/Melengkapi).

Contoh Codenya:

Java
public class Elektronik extends Produk {
    private String garansi; // Atribut tambahan khusus elektronik

    public Elektronik(String nama, double harga, int stok, String garansi) {
        super(nama, harga, stok); // 📞 Setor data ke Super Class (Produk)
        this.garansi = garansi;
    }

    @Override
    public void info() {
        super.info(); // 🏠 Jalankan info standar dari Produk
        System.out.println("Garansi: " + garansi); // ✨ Tambahkan info garansi
    }
}
Langkah 3: Menjalankan di Class Utama (Main.java)
Di sini tempat kita ngetes semua yang udah kita bikin. Biar programnya interaktif dan gak langsung mati, kita pakai Looping (Perulangan).

Kenapa pakai do-while?
Kita pakai do-while karena kita pengen minimal menunya muncul sekali buat user, baru setelah itu dicek: "User mau lanjut (pilih 1-3) atau mau keluar (pilih 4)?".

Gimana cara manggilnya?

Java
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    // Kita bikin objek dari Class Anak (Elektronik)
    Elektronik produk = new Elektronik("Mouse Fantech", 100000, 10, "1 Tahun");

    int pilih;
    do {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Tambah Stok | 2. Kurang Stok | 3. Info | 4. Keluar");
        System.out.print("Pilihan: ");
        pilih = scan.nextInt();

        // Switch case buat milih jalan mana yang mau diambil
        switch (pilih) {
            case 1 -> produk.TambahStok(scan); // Manggil fungsi dari bapaknya
            case 3 -> produk.info();           // Manggil fungsi yang udah di-override
            case 4 -> System.out.println("Bye!");
        }
    } while (pilih != 4); // Loop terus selama pilihannya BUKAN 4
}