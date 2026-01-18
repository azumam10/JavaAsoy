package Projek.Projekencapculation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean ulang = true;

    while(ulang){
    System.out.print("Masukan Nama Anda : ");
    String nama = scan.nextLine();
    Pemain pemain = new Pemain(nama);
    
    GameMtk gamemtk = new GameMtk();
    Gametekateki tekateki = new Gametekateki();

boolean running = true; // untuk mengatur loop menu utama
    
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
                    gamemtk.mainkan(pemain, scan);
                    break;
                case 2:
                    tekateki.mainkan(pemain, scan);
                    break;
                case 3:
                    System.out.println("Terima kasih telah bermain! Sampai ketemu lagi ✌️");
                    running = false;
                    ulang = false;
                    break;
                default:
                    System.out.println("Pilih Dengan Benar Atau Panah Muncul Di Jam 10");

            }
            running = false;
        }
        
    }
 
    }

    }
