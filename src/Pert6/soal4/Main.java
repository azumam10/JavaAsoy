package Pert6.soal4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Buat objek Elektronik
        Elektronik produk = new Elektronik();

        int pilih;
        do {
            System.out.println("\n=== MENU PRODUK ELEKTRONIK ===");
            System.out.println("1. Tambah Stok");
            System.out.println("2. Kurangi Stok");
            System.out.println("3. Info Produk");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilih = scan.nextInt();

            switch (pilih) {
                case 1:
                    produk.TambahStok(scan);
                    break;
                case 2:
                    produk.KurangStok(scan);
                    break;
                case 3:
                    produk.info();
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilih != 4);

        scan.close();
    }
}