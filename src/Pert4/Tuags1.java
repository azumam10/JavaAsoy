package Pert4;
import java.util.Scanner;

public class Tuags1 {
    
    public static void sapa(String nama) {
        System.out.println("SELAMAAT PAAGGIIII " + nama + "!" + " BAANNGGUUUNNN " + nama + "!"  );
    }

    public static int Kali(int a, int b) {
        return a * b;
    }

    public static int Tambah(int a, int b) {
        return a + b;
    }
    
    public static int kurang(int a, int b) {
        return a - b;
    }

    public static int Bagi(int a, int b) {
        return a / b;
    }

    public static int jumlahDeret(int n) {
        if (n <= 1) {
            System.out.println("1");
            return 1;
        }
        System.out.print(n+ " + ");
        return n + jumlahDeret(n - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            // Tampilkan menu
            System.out.println("\n=== Menu Program ===");
            System.out.println("1. Sapa");
            System.out.println("2. Aritmatika Dua Bilangan");
            System.out.println("3. Jumlah Deret");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-3): ");
            pilihan = scan.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama Anda: ");
                    scan.nextLine(); // Membersihkan buffer
                    String nama = scan.nextLine();
                    sapa(nama);
                    break;

                case 2:
                    System.out.print("Masukkan bilangan pertama: ");
                    int a = scan.nextInt();
                    System.out.print("Masukkan bilangan kedua: ");
                    int b = scan.nextInt();
                    int hasilTambah = Tambah(a, b);
                    int hasilKurang = kurang(a, b);
                    int hasilBagi = Bagi(a, b);
                    int hasilKali = Kali(a, b);
                    System.out.println("Hasil Penjumlahan: " + hasilTambah);
                    System.out.println("Hasil Kurang: " + hasilKurang);
                    System.out.println("Hasil Pembagian: " + hasilBagi);
                    System.out.println("Hasil Perkalian: " + hasilKali);
                    break;

                case 3:
                    System.out.print("Masukkan batas deret (n): ");
                    int n = scan.nextInt();
                    int hasilDeret = jumlahDeret(n);
                    System.out.println("Jumlah deret dari 1 sampai " + n + ": " + hasilDeret);
                    break;

                case 0:
                    System.out.println("DADAHH....");
                    break;

                default:
                    System.out.println("angka jangan huruf");
            }
        } while (pilihan != 0);

        
    }
}