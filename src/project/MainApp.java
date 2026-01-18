package project;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;
        do {
            System.out.println("\n=== Sistem Pengelolaan Limbah Plastik ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt(); sc.nextLine();

            switch (pilih) {
                case 1:
                    BarangCRUD.tambahBarang();
                    break;
                case 2:
                    BarangCRUD.lihatBarang();
                    break;
                case 3:
                    BarangCRUD.updateBarang();
                    break;
                case 4:
                    BarangCRUD.hapusBarang();
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan salah!");
                    break;
            }        } while (pilih != 0);
        sc.close();
    }
}
