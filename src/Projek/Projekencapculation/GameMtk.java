package Projek.Projekencapculation;
import java.util.Scanner; 

public class GameMtk {
    public void mainkan(Pemain pemain, Scanner scan){
        int skor = 0;

        System.out.println("\n--- TEBAKAN MATEMATIKA ---");
        System.out.println("Ada 5 soal. Untuk keluar lebih awal ketik 0 sebagai jawaban.");
        System.out.println("Menangkan Minimal 3 Soal Untuk Kembali Hidup Hidup ☠️");

        //soal
        String[] soal = {
            "1) Usia Jek 22 tahun. Berapa usianya 8 tahun lalu?",
            "2) I = 1, V = 5, X = 10, L = ? ",
            "3) Sebuah mobil menempuh 120 km dalam 2 jam. Berapa kecepatan rata-ratanya (km/jam)?",
            "4) Di dalam sebuah kotak terdapat bola merah dan biru. Jumlah bola merah adalah 3 kali jumlah bola biru. Jika total bola adalah 20, berapa banyak bola biru?",
            "5) A dapat menyelesaikan pekerjaan dalam 6 jam, B dalam 12 jam. Jika mereka bekerja bersama, berapa lama pekerjaan selesai?"
        };

        //Jawaban
        int[] jawabanBenar = {
            14,  // 22 - 8
            50,  // L = 50
            60,  // 120/2
            5,   // 3B + B = 20 → B = 5
            4    // (1/6 + 1/12) pekerjaan per jam = 1/4 → selesai dalam 4 jam
        };

        //looping buat nampilin pertanyaan
        for (int i = 0; i < soal.length; i++) {
            System.out.println("\nSoal " + (i + 1) + ":");
            System.out.println(soal[i]);
            System.out.print("Jawaban Anda (ketik 0 untuk keluar): ");

            // Validasi input angka
            if (!scan.hasNextInt()) {
                scan.nextLine(); // buang input salah
                System.out.println("Input bukan angka. Soal dilewati.");
                continue;
            }
        
            int jawabanUser = scan.nextInt();
            scan.nextLine(); // buang newline

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
        }

        pemain.tambahskor(skor);
        System.out.println("Nama Pemain : " + pemain.getNama());
        System.out.println("Skor : " + pemain.getSkor());
        if (pemain.getSkor() < 3 ){
            System.out.println("Anda kalah!! ");
            System.out.println("#### SILAHKAN MASUK KE NERAKA ####");
        }
        

 }
}