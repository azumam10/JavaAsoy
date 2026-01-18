package Pert6.soal3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        produk data = new produk();  

        System.out.println("1. Tambah Stok");
        System.out.println("2. Info Produk");
        System.out.println("3. Kurangi Stok (Hapus Sebagian)");
        System.out.print("Masukkan pilihan: ");
        int pilih = scan.nextInt();

        switch (pilih) {
            case 1:
                data.TambahStok(scan);
                break;
            case 2:
                data.info();
                break;
            case 3:
                data.KurangStok(scan);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }

        scan.close();
    }
}