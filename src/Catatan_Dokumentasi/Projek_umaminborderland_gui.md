📝 Dokumentasi Projek: UMAM IN BORDER LAND (Section 1)
🎮 Section 1: Konsep & Filosofi Projek
💀 Inspirasi: Alice in Borderland
Projek ini bukan sekadar tugas kuliah biasa. Konsepnya diambil dari seri Netflix "Alice in Borderland". Bayangkan kamu terbangun di sebuah ruangan kosong yang gelap. Di depanmu hanya ada sebuah layar monitor yang menyala terang. Layar itu adalah aplikasi ini.

Di sini, kamu nggak cuma main game. Kamu sedang bertaruh nyawa. Pilihanmu cuma dua: Lulus (HIDUP) atau Eliminasi (MATI).

🏢 Setting: "The Game Arena"
Aplikasi ini diposisikan sebagai Interface Arena.

Ruang Isolasi: Begitu program dijalankan, kamu masuk ke arena.

Layar Digital: GUI (Graphic User Interface) yang kamu lihat adalah satu-satunya alat komunikasi antara kamu dan "Game Master".

Aturan Main: Kamu harus memilih arena (Matematika atau Teka-teki). Skor di bawah 3 berarti Game Over alias nyawa melayang.

🗄️ Alibi Teknologi: Kenapa Pakai Java Collections? (Bukan SQL)
Mungkin ada yang nanya: "Bang, kok databasenya nggak pakai MySQL?" Nah, ini alibi sekaligus alasan teknis yang jenius buat projek ini:

Volatile System: Dalam dunia Borderland, arena bersifat sementara. Begitu game selesai atau arena ditutup, data nggak perlu disimpan secara permanen di server luar. Data cukup hidup di memori (RAM) selama arena aktif.

Zero Latency: Di game maut, kita nggak butuh delay buat koneksi ke database SQL. Kita pakai ArrayList (Java Collections) supaya akses data riwayat pemain super cepat.

Standalone Arena: Program ini dirancang sebagai sistem mandiri yang nggak butuh koneksi internet atau database eksternal. Layarnya adalah databasenya. Selama program nggak berhenti, riwayat "korban" sebelumnya akan terus tercatat di memori arena.

Note buat Adek Tingkat: > "Kalian nggak butuh server database yang ribet kalau kalian bisa mengelola memori dengan efisien pakai Java Collections. Di sini, List adalah buku takdir kalian."

📝 Dokumentasi Projek: UMAM IN BORDER LAND (Section 2)
🏗️ Section 2: Arsitektur "The Game Master" (Abstract Class & Abstraksi)
Dalam sebuah arena maut, harus ada Aturan Dasar yang berlaku untuk semua jenis permainan. Di Java, kita pakai konsep Abstract Class.

1. Abstract Class: Game.java (Sang Pembuat Aturan)
Game.java adalah "Master Blueprint". Class ini nggak bisa kamu bikin jadi objek langsung (kamu nggak bisa mainin "Game" aja, kamu harus milih arena spesifik).

Kenapa harus Abstract? Karena setiap arena punya cara "inisialisasi soal" yang beda-beda. Tapi, semua arena PASTI punya nama dan PASTI punya daftar soal.

Bedah Kode Utama:

Java
public abstract class Game {
    protected String namaGame;
    
    // COLLECTION: Inilah "Memori Arena" kita. 
    // Data cuma hidup di sini selama layar monitor (program) menyala.
    protected List<SoalModel> daftarSoal = new ArrayList<>(); 

    public Game(String namaGame) {
        this.namaGame = namaGame;
        initSoal(); // Paksa arena untuk nyiapin soal begitu ruangan dibuka
    }

    // ABSTRACT METHOD: Kewajiban bagi setiap Arena (Anak Class)
    protected abstract void initSoal(); 
}
2. Inner Class: SoalModel (Bungkus Data)
Di dalam class Game, ada class kecil namanya SoalModel. Ini adalah penerapan Encapsulation sederhana. Gunanya buat ngebungkus "Pertanyaan" dan "Jawaban" jadi satu paket biar nggak berantakan.

Java
protected class SoalModel {
    String tanya;
    String jawab;
    public SoalModel(String t, String j) {
         this.tanya = t; 
         this.jawab = j;
    }
}
3. Logika Sang Hakim: cekJawaban()
Ini adalah bagian paling krusial. Method ini bertugas jadi Hakim. Dia yang nentuin kamu berhak lanjut atau harus tereliminasi.

Safety Check: Mencegah sistem crash kalau ada kesalahan index soal.

Normalization: Pakai .toLowerCase() dan .trim().

Alibi: "Game Master nggak peduli kamu pakai huruf kapital atau nggak, atau nggak sengaja ngetik spasi. Yang penting intinya sama. Kami adil, tapi mematikan."

4. Class Pemain.java (Identitas Korban)
Class ini simpel, tapi vital. Ini adalah data diri kamu selama ada di dalam Borderland.

Encapsulation: nama dan skor dibuat private. Nggak boleh ada yang bisa curang ngubah skor lewat jalur belakang!

Override toString(): Kita mengubah cara Java "melihat" pemain. Bukan lagi sekadar alamat memori yang aneh, tapi jadi teks: Nama (Skor: X).

Contoh Kode:

Java
@Override
public String toString() {
    return nama + " (Skor: " + skor + ")";
}
💡 Kenapa Pakai Struktur Gini?
Gampang Nambah Arena: Kalau besok kita mau bikin "Game Tebak Gambar", kita tinggal extends Game tanpa harus ngerombak sistem pengecekan jawaban atau sistem skor.

Organisir Data: Pakai ArrayList di dalam class Game bikin data soal rapi. Setiap arena punya "Buku Soal"-nya masing-masing.

📝 Dokumentasi Projek: UMAM IN BORDER LAND (Section 3)
🎭 Section 3: Arena Spesifik & Jurus Polymorphism
Setelah kita punya "Blueprint" dari sang Game Master di Section 2, sekarang saatnya kita membangun arena permainannya. Di sini kita punya dua jenis arena: Teka-teki (Logika kata) dan Matematika (Logika angka).

1. Arena 1: Gametekateki.java (The Riddle Realm)
Arena ini fokus pada permainan kata. Karena cara mengecek jawabannya standar (cuma bandingin teks), kita nggak perlu repot-repot nulis ulang logika pengecekan. Kita cukup pakai apa yang udah dibikin sama "Bapak"-nya di class Game.

Isi Penting:

super("Nama Game"): Memanggil bapaknya buat ngasih tau nama arenanya.

initSoal(): Di sini kita masukin daftar teka-teki maut.

Java
public class Gametekateki extends Game {
    public Gametekateki() {
        super("Game Tekateki Botak"); // Ngasih tau Game Master nama arenanya
    }

    @Override
    protected void initSoal() {
        // Daftar teka-teki maut
        daftarSoal.add(new SoalModel("Semakin dikejar, semakin jauh. Apa itu?", "bayangan"));
        // ... soal lainnya
    }
}
2. Arena 2: GameMtk.java (The Lethal Math)
Nah, ini arena yang lebih berbahaya. Di sini, jawaban user harus berupa angka. Kalau user panik terus ngetik huruf, sistem bisa crash. Maka dari itu, kita pakai Polymorphism untuk memodifikasi cara kerja "Hakim" (cekJawaban).

✨ Konsep Polymorphism & Overriding
Kita menulis ulang (@Override) method cekJawaban khusus untuk arena ini.

Logic: Kita ubah String jawaban user jadi Integer (int).

Survival Mechanism (try-catch): Kalau user input huruf, sistem nggak akan mati/error, tapi langsung dianggap SALAH oleh NumberFormatException.

Bedah Kode:

Java
@Override
public boolean cekJawaban(int index, String jawabanUser) {
    try {
        // 1. Ubah input teks user jadi angka murni
        int user = Integer.parseInt(jawabanUser.trim());
        
        // 2. Ambil kunci jawaban asli (yang juga angka)
        int kunci = Integer.parseInt(getKunci(index));
        
        // 3. Bandingkan angka vs angka
        return user == kunci;
    } catch (NumberFormatException e) {
        // Kalau user input "dua" (huruf), padahal minta 2 (angka)
        // Langsung eliminasi! Jangan biarkan sistem crash.
        return false; 
    }
}
3. Kenapa Polymorphism itu Keren di Sini?
Coba bayangkan kalau kamu adalah GameGui (Layar Monitor). Layar monitor nggak perlu tau dia lagi nampilin game apa. Dia cuma perlu panggil: activeGame.cekJawaban(index, input)

Kalau activeGame itu Teka-teki, dia pakai cara bandingin teks.

Kalau activeGame itu MTK, dia pakai cara bandingin angka (lewat try-catch).

Pesan buat Adek Tingkat: "Inilah kekuatan OOP. Kamu nggak perlu bikin banyak 'if-else' yang ribet di program utama. Cukup biarkan setiap objek (Arena) tau cara menilai dirinya sendiri. Itu namanya Smart Objects."

💡 Summary Section 3:
Inheritance: Anak class mewarisi semua sifat bapaknya, tapi tetap punya identitas sendiri (soal yang beda).

Polymorphism: Kita bisa memodifikasi perilaku method yang sama (cekJawaban) sesuai kebutuhan arena masing-masing.

Robustness: Penggunaan try-catch memastikan arena tetap berjalan meskipun "korban" memberikan input yang salah format.

📝 Dokumentasi Projek: UMAM IN BORDER LAND (Section 4)
🖥️ Section 4: Layar Monitor Arena (The GUI & Event Handling)
Kalau Section 2 dan 3 adalah "Otak" dan "Aturan" permainannya, maka Section 4 adalah Terminal yang dilihat oleh pemain di dalam ruangan. Kita pakai Java Swing untuk membangun antarmuka ini.

1. Desain Terminal: JFrame & Null Layout
Kita nggak pakai layout manager otomatis (kayak FlowLayout atau BorderLayout). Kita pakai setLayout(null).

Kenapa?

Alibi: "Di Borderland, segalanya harus presisi. Kita tentuin sendiri koordinat setiap tombol dan teks (pakai setBounds) supaya tampilannya kaku, raw, dan terkesan seperti terminal komputer tua yang fungsional."

Java
public GameGui() {
    setTitle("UMAM IN BORDER LAND");
    setSize(500, 400);
    setLayout(null); // Kita yang pegang kendali posisi (Absolute Positioning)

    // Area Pertanyaan (Layar Monitor Utama)
    textArea = new JTextArea();
    textArea.setEditable(false); // Biar user gak bisa iseng hapus soal!
    
    // Kolom Jawaban (Tempat User Bertaruh)
    inputField = new JTextField();
    inputField.setBounds(20, 240, 350, 35);
}
2. Pemicu Aksi: Event Handling dengan Lambda
Bayangkan tombol "JAWAB" adalah tombol eksekusi. Begitu ditekan, sistem harus langsung memproses nasib pemain. Di sini kita pakai Lambda Expression yang diperkenalkan sejak Java 8.

Java
btnSubmit.addActionListener(e -> prosesJawaban());
Kenapa pakai Lambda?

Clean Code: Nggak perlu bikin anonymous class yang panjang dan bikin mata sepet.

Modern: Ini cara "kating" jaman sekarang ngetik kode. Lebih singkat, lebih padat, lebih maut.

3. Alur Permainan (The Game Loop)
Di dalam GUI ini, ada tiga method utama yang ngatur siklus hidup pemain:

A. mulaiSesiBaru() (Pendaftaran Korban)
Sistem bakal minta nama lewat JOptionPane. Kalau user nggak ngisi, sistem otomatis kasih nama "ORANG GILA". Ini adalah sentuhan dark jokes biar suasana Borderland-nya makin kerasa.

B. updateTampilanSoal() (The Display)
Method ini tugasnya narik data dari activeGame (yang kita bahas di Section 3) dan nampilinnya ke layar. Dia nggak peduli gamenya apa, dia cuma minta: "Kasih saya soal nomor sekian!"

C. prosesJawaban() (The Verdict)
Di sinilah momen penentuan.

Ambil teks dari inputField.

Lempar ke cekJawaban() milik arena yang sedang aktif.

Kalau salah? Muncul pesan "PIKIR LAH PAKAI OTAK".

Kalau soal habis? Panggil gameSelesai().

4. Dialog Akhir: JOptionPane (The Result)
Begitu game selesai, sistem bakal ngeluarin laporan akhir. Di sinilah Status Hidup/Mati ditentukan berdasarkan skor.

Java
String status = (skorSesi >= 3) ? "HIDUP (Lulus)" : "MATI (Eliminasi)";
Catatan Teknis: Kita pakai StringBuilder buat nyusun laporan akhir. Kenapa? Karena menyambung teks (String concatenation) di dalam perulangan itu boros memori. StringBuilder jauh lebih efisien buat nyusun daftar "korban" sebelumnya.

💡 Summary Section 4:
Swing Components: Menggunakan JTextArea untuk output, JTextField untuk input, dan JButton untuk trigger.

Lambda Expression: Cara ringkas untuk menangani klik tombol.

User Feedback: Menggunakan JOptionPane sebagai media komunikasi darurat antara Game Master dan Pemain.

State Management: Program terus mengingat skor dan index soal selama sesi berjalan.

Ini adalah bagian penutup yang paling "jenius" dari segi alibi teknis. Kita bakal bahas gimana caranya aplikasi ini punya "ingatan" tanpa perlu nyimpen data di harddisk (SQL). Ini adalah Section 5.

📝 Dokumentasi Projek: UMAM IN BORDER LAND (Section 5)
🧠 Section 5: Memori Arena (Java Collections & "The Database Alibi")
Di bagian akhir ini, kita bakal bahas rahasia terbesar kenapa aplikasi ini bisa menampilkan daftar "korban" atau pemain sebelumnya, padahal kita nggak pakai database MySQL sama sekali. Kita pakai Java Collections.

1. Konsep "Ghost Data" (Memori Volatile)
Dalam dunia Borderland, sebuah arena bersifat sementara. Begitu permainan selesai dan lampu ruangan dimatikan, semua jejak harus hilang.

Teknisnya: Kita menggunakan ArrayList<Pemain>.

Alibinya: "Data pemain disimpan di dalam memori RAM (volatile). Selama aplikasi (Layar Monitor) tidak di-close, arwah para pemain sebelumnya akan tetap tersimpan di dalam List. Tapi begitu aplikasi dimatikan, semua data terhapus tanpa jejak (Wipe Out). Ini adalah sistem keamanan tingkat tinggi agar arena tidak bisa dilacak oleh pihak luar."

2. Implementasi ArrayList sebagai Database
Di dalam GameGui.java, kita mendeklarasikan sebuah List yang bertugas menampung objek Pemain.

Java
// Inilah database rahasia kita
private List<Pemain> databasePemain = new ArrayList<>(); 
Setiap kali ada pemain yang menyelesaikan game (baik hidup maupun mati), objek mereka akan dilempar ke dalam list ini:

Java
databasePemain.add(pemainSaatIni); // Mencatat korban baru ke memori
3. Menampilkan Riwayat (The Hall of Fame/Shame)
Bagaimana cara kita menampilkan daftar pemain yang udah main sebelumnya? Kita pakai Looping (Perulangan) dan bantuan method toString().

Di dalam method gameSelesai(), kita menyusun laporan menggunakan StringBuilder:

Java
laporan.append("=== RIWAYAT PEMAIN SEBELUMNYA ===\n");

// Kita iterasi (kelilingi) isi List satu per satu
for (Pemain p : databasePemain) {
    if (p != pemainSaatIni) { // Jangan tampilin diri sendiri dua kali
        laporan.append("- ").append(p.toString()).append("\n");
    }
}
Kenapa pakai p.toString()? Karena di class Pemain kita sudah melakukan Override pada method toString(). Jadi, daripada Java nampilin kode aneh kayak Pemain@1b6d3586, dia bakal nampilin teks yang manusiawi: Umam (Skor: 5).

4. Kenapa Collections Lebih Cocok Buat Projek Ini dibanding SQL?
Speed: Akses data di RAM jauh lebih cepat daripada harus "ngetuk pintu" ke server MySQL.

Portability: Program ini bisa kamu copy ke flashdisk dan jalanin di mana aja tanpa perlu ribet install XAMPP atau setting database. Tinggal Double Click, dan arena maut siap dimulai.

Simplicity: Untuk skala game kecil, ArrayList jauh lebih hemat kode.

💡 Kesimpulan Akhir (Pesan buat Adek Tingkat):
"Belajar PBO itu bukan cuma soal hafal sintaks, tapi soal gimana kamu membangun narasi lewat kodemu. Gunakan Abstract Class buat aturan, Inheritance buat hierarki, Polymorphism buat variasi aksi, dan Collections buat ingatan sistemmu. Selamat terjebak di dunia koding, semoga kalian tetap HIDUP (Lulus)!"