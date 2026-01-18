package Projek.ProjekGui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Gak dipake di GUI, tapi dibiarin kalo lo butuh signature-nya

public abstract class Game {
    protected String namaGame;
    
    // COLLECTION: List untuk nyimpen soal.
    protected List<SoalModel> daftarSoal = new ArrayList<>();

    public Game(String namaGame) {
        this.namaGame = namaGame;
        initSoal(); // Paksa anak buat isi soal pas lahir
    }

    // ABSTRACT: Anak wajib tentuin soalnya apa aja
    protected abstract void initSoal();

    // ABSTRACT: Anak lama (console) wajib punya ini
    public abstract void mainkan(Pemain pemain, Scanner scan);

    // === LOGIC GUI (Dipake bareng-bareng) ===
    
    public String getNamaGame() {
         return namaGame;
         }
    
    public int getJumlahSoal() { 
        return daftarSoal.size();
     }

    public String getPertanyaan(int index) {
        if (index < daftarSoal.size()) return daftarSoal.get(index).tanya;
        return "";
    }

    public String getKunci(int index) {
        if (index < daftarSoal.size()) return daftarSoal.get(index).jawab;
        return "";
    }

    // Default Logic: Cek String vs String (Case Insensitive)
    // POLYMORPHISM: Method ini bisa di-Override sama anak kalo butuh cara cek beda
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

    // CLASS PEMBANTU (Encapsulation data soal)
    protected class SoalModel {
        String tanya;
        String jawab;
        public SoalModel(String t, String j) { this.tanya = t; this.jawab = j; }
    }
}