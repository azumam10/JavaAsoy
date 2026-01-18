package Projek.ProjekGui;

import java.util.Scanner;

public class Gametekateki extends Game {

    public Gametekateki() {
        super("Game Tekateki Botak");
    }

    @Override
    protected void initSoal() {
        daftarSoal.add(new SoalModel("Merah berhenti, kuning waspada, hijau jalan. Hitam?", "lampu mati"));
        daftarSoal.add(new SoalModel("Punya sirip bukan ikan, punya sayap bukan burung?", "pesawat"));
        daftarSoal.add(new SoalModel("Kalau dibutuhkan dilempar. Kalau tidak dibutuhkan diambil. Apa itu?", "jangkar"));
        daftarSoal.add(new SoalModel("Semakin dikejar, semakin jauh. Apa itu?", "bayangan"));
        daftarSoal.add(new SoalModel("50 hewan terbalik secara berurutan, maka Lion pada urutan ke berapa ? (clue: no15)", "no17"));
    }

    @Override
    public void mainkan(Pemain pemain, Scanner scan) {
        // Kosongin aja
    }
}