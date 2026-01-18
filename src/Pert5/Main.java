package Pert5;
import java.util.Scanner;


// CLASS Mahasiswa

// =======================
// CLASS Main
// =======================
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Input Data Mahasiswa ===");
        System.out.print("Masukkan Nama : ");
        String nama = input.nextLine();

        System.out.print("Masukkan NIM  : ");
        String nim = input.nextLine();

        System.out.print("Masukkan IPK  : ");
        double ipk = input.nextDouble();

        // Membuat objek mahasiswa
        Mahasiswa mhs = new Mahasiswa(nama, nim, ipk);

        // Menampilkan data
        mhs.tampilkanData();

        // Coba ubah IPK lewat setter
        System.out.print("\nUbah IPK jadi: ");
        double ipkBaru = input.nextDouble();
        mhs.setIpk(ipkBaru);

        // Tampilkan lagi setelah diubah
        mhs.tampilkanData();

        input.close();
    }
}
