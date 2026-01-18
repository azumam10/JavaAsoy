package Projek.Projek_Inharitance;
import java.util.Scanner;

public class Gametekateki extends Game {

    public Gametekateki(){
        super("Game Tekateki Botak");
    }

    @Override
    public void mainkan(Pemain pemain, Scanner scan){
        int skor = 0;

        Namagame();

        System.out.println("=== GUNAKAN LOGIKA ANDA ===");
        System.out.println("=== JIKA HANYA BERHASIL MENJAWAB 3, ANDA DITEMBAK DI TEMPAT ===");
        System.out.println("Hukumannya Mandi Air Panas Bersama Anak Punk Soal Salah x 100 anak Punk Nanahan");

        String[][] soalJawaban = {
            {"Merah berhenti, kuning waspada, hijau jalan. Maka hitam adalah...", "lampu mati"},
            {"Punya sirip tapi bukan ikan, punya sayap tapi bukan burung. Apa itu?", "pesawat"},
            {"Semakin dikejar, semakin jauh. Apa itu?", "bayangan"},
            {"50 hewan terbalik secara berurutan, maka Lion pada urutan ke berapa ? (clue: no15)", "no17"},
            {"Kalau dibutuhkan dilempar. Kalau tidak dibutuhkan diambil. Apa itu?", "jangkar"}
        };

        for (int i = 0; i < soalJawaban.length; i++) {
            System.out.println("\nSoal " + (i + 1) + ":");
            System.out.println(soalJawaban[i][0]);
            System.out.print("Jawaban Anda: ");
            String jawaban = scan.nextLine().toLowerCase().trim();

            if (jawaban.equals(soalJawaban[i][1].toLowerCase())) {
                System.out.println("Benar!");
                skor++;
            } else {
                System.out.println(" Salah, Nyawa anda taruhan. Jawaban benar: " + soalJawaban[i][1]);
            }
        }

        pemain.tambahskor(skor);
        System.out.println("Nama Pemain: " + pemain.getNama());
        System.out.println("Skor : " + pemain.getSkor());
        

        
    }
    
}
