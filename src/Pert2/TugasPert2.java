package Pert2;
import java.util.Scanner;

public class TugasPert2 {
    // Scanner global biar bisa dipakai semua method
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih; // variabel untuk menyimpan pilihan menu

        do {
            // Tampilan menu
            System.out.println("\n=== MENU PROGRAM ===");
            System.out.println("1. Input Nilai");
            System.out.println("2. Hitung Usia Tahun Depan");
            System.out.println("3. Konversi Celsius ke Reamur");
            System.out.println("4. Hrga Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilih = input.nextInt();

             input.nextLine();

            // Pemilihan menu dengan switch
            switch (pilih) {
                case 1:
                    inputNilai(); // memanggil method void inputNilai
                    break;
                case 2:
                    hitungUsia(); // memanggil method void hitungUsia
                    break;
                case 3:
                    konversiSuhu(); // memanggil method void konversiSuhu
                    break;
                case 4:
                    HargaBarang();
                case 5:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi!");
            }
        } while (pilih != 5); // perulangan sampai pilih 4 (keluar)

        input.close();
    }

    // Method void untuk input nilai
    public static void inputNilai() {
    // Gunakan nextLine() untuk input string agar bisa menerima spasi
    System.out.print("Masukkan Nama       : ");
    String nama = input.nextLine(); // variabel nama bertipe String

    System.out.print("Masukkan Pelajaran  : ");
    String pelajaran = input.nextLine(); // variabel pelajaran bertipe String

    System.out.print("Masukkan Nilai      : ");
    int nilai = input.nextInt(); // variabel nilai bertipe int

    input.nextLine(); 

    // Menampilkan hasil
    System.out.println("\n=== Data Nilai Siswa ===");
    System.out.println("Nama Siswa   : " + nama);
    System.out.println("Pelajaran    : " + pelajaran);
    System.out.println("Nilai        : " + nilai);

    // Tambahan keterangan lulus/tidak lulus
    if (nilai >= 75) {
        System.out.println("Keterangan   : Lulus");
    } else {
        System.out.println("Keterangan   : Tidak Lulus");
    }
}


    // Method void untuk menghitung usia tahun depan
    public static void hitungUsia() {
        System.out.print("Masukkan Usia: ");
        int usia = input.nextInt(); // variabel usia bertipe int
        int usiaTahunDepan = usia + 1; // ekspresi penjumlahan usia + 1
        System.out.println("Usia tahun depan adalah: " + usiaTahunDepan);
    }

    // Method void untuk konversi Celsius ke Reamur
    public static void konversiSuhu() {
        System.out.print("Masukkan suhu dalam Celsius: ");
        double celsius = input.nextDouble(); // variabel celsius bertipe double
        double reamur = (4.0 / 5.0) * celsius; // ekspresi konversi
        System.out.println("Konversi suhu: " + celsius + " Celsius = " + reamur + " Reamur");
    }

    public static void HargaBarang() {
        String NamaBarang = "Buku PBO";
        int harga = 1000000;

        System.out.println("|" + NamaBarang + "|" + harga + "|");
        System.out.printf("%30s | %10d | \n",NamaBarang, harga);
        System.out.printf("%-30s | %10d | \n",NamaBarang, harga);
        
    }

}
