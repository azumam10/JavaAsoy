package Projek.ProjekGui;

import java.util.Scanner;

public class GameMtk extends Game {

    public GameMtk() {
        super("Tekateki Matematika Mematikan");
    }

    // Implementasi isi soal (Pake List)
    @Override
    protected void initSoal() {
        daftarSoal.add(new SoalModel("1) Usia Jek 22 tahun. Berapa usianya 8 tahun lalu?", "14"));
        daftarSoal.add(new SoalModel("2) I = 1, V = 5, X = 10, L = ?", "50"));
        daftarSoal.add(new SoalModel("3) 10 + 10 x 0 = ?", "10"));
        daftarSoal.add(new SoalModel("4) Akar dari 144?", "12"));
        daftarSoal.add(new SoalModel("5) Sebuah mobil menempuh 120 km dalam 2 jam. Berapa kecepatan rata-ratanya (km/jam)?", "60"));
    }

    // POLYMORPHISML: Kita ubah cara cek jawaban khusus MTK (Validasi Angka)
    @Override
    public boolean cekJawaban(int index, String jawabanUser) {
        try {
            // Cek apakah input angka valid
            int user = Integer.parseInt(jawabanUser.trim());
            int kunci = Integer.parseInt(getKunci(index));
            return user == kunci;
        } catch (NumberFormatException e) {
            return false; // Kalo input huruf, otomatis salah
        }
    }

    @Override
    public void mainkan(Pemain pemain, Scanner scan) {
        // Kosongin aja karena kita fokus GUI
    }
}