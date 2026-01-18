package Projek;
import java.util.Scanner;


public class GameMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true; // flag untuk mengatur loop menu utama

        // Loop menu utama, berhenti kalau user pilih "Keluar"
        while (running) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. =*/+-% ");
            System.out.println("2. TasdhEasKhdsAmnbTgdEsvdhKndI");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            // Validasi input: hanya terima angka 1-3
            if (!scan.hasNextInt()) {
                scan.nextLine(); // buang input salah
                System.out.println("Input nggak valid. Ketik angka 1-3 ya.");
                continue;
            }

            int pilihan = scan.nextInt();
            scan.nextLine(); // buang newline biar input berikutnya aman

            switch (pilihan) {
                case 1:
                    mainkanTebakanMatematika(scan);
                    break;
                case 2:
                    mainkanTebakKata(scan);
                    break;
                case 3:
                    System.out.println("Terima kasih telah bermain! Sampai ketemu lagi ✌️");
                    running = false;
                    break;
                default:
                    System.out.println("Pilih Dengan Benar Atau Panah Muncul Di Jam 10");
            }
        }

        scan.close(); // close resource
    }

    
    // method buat Mtk
    public static void mainkanTebakanMatematika(Scanner scan) {
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

        // nyimpen skor
        int skor = 0;

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

        // Hasil akhir
        System.out.println("\n=== HASIL TEBAKAN MATEMATIKA ===");
        System.out.println("Skor Anda: " + skor + " dari " + soal.length);
        if (skor == soal.length) {
            System.out.println("🔥 Mantap! Full skor!");
        } else if (skor >= 3) {
            System.out.println("👍 Bagus! Masih bisa ditingkatkan.");
        } else {
            System.out.println("Anda Gagal Silahkan Lihat Kearah Belakang :)");
            System.out.println("☠️☠️☠️☠️☠️");
        }
    }

 

    //method void buat teateki
    public static void mainkanTebakKata(Scanner scanner) {
        System.out.println("\n--- GAME TEBAK KATA ---");
        System.out.println("Jawab teka-teki berikut dengan logika!");
        System.out.println("Menangkan Minimal 3 Soal Untuk Kembali Hidup Hidup ");

        String[][] soalJawaban = {
            {"Merah berhenti, kuning waspada, hijau jalan. Maka hitam adalah...", "lampu mati"},
            {"Punya sirip tapi bukan ikan, punya sayap tapi bukan burung. Apa itu?", "pesawat"},
            {"Semakin dikejar, semakin jauh. Apa itu?", "bayangan"},
            {"50 hewan terbalik secara berurutan, maka Lion pada urutan ke berapa ? (clue: no15)", "no17"},
            {"Kalau dibutuhkan dilempar. Kalau tidak dibutuhkan diambil. Apa itu?", "jangkar"}
        };

        int skor = 0;

        for (int i = 0; i < soalJawaban.length; i++) {
            System.out.println("\nSoal " + (i + 1) + ":");
            System.out.println(soalJawaban[i][0]);
            System.out.print("Jawaban Anda: ");
            String jawaban = scanner.nextLine().toLowerCase().trim();

            if (jawaban.equals(soalJawaban[i][1].toLowerCase())) {
                System.out.println("Benar!");
                skor++;
            } else {
                System.out.println(" Salah, Nyawa anda taruhan. Jawaban benar: " + soalJawaban[i][1]);
            }
        }

        System.out.println("\n=== HASIL AKHIR TEBAK KATA ===");
        System.out.println("Skor Anda: " + skor + " dari " + soalJawaban.length);
        if (skor == soalJawaban.length) {
            System.out.println(" Luar biasa! Semua benar!");
        } else if (skor >= 3) {
            System.out.println(" Lumayan, bisa lebih baik.");
        } else {
            System.out.println("Mau Pakai Pedang Atau Shotgun 🥷🥷");
        }
    }
}
