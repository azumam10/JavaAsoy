package Cobacoba.hardcore.inharitance;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Karyawan ===");
        Manajer manajer = new Manajer("John Doe", 80000, "IT");
        Programmer programmer = new Programmer("Jane Smith", 60000, "Java");
        Magang magang = new Magang("Bob", 10000, 6);

        manajer.tampilkanInfo();
        System.out.println();
        programmer.tampilkanInfo();
        System.out.println();
        magang.tampilkanInfo();

        System.out.println("\n=== Buah ===");
        Apel apel = new Apel("Merah");
        Pisang pisang = new Pisang("Kuning");
        Mangga mangga = new Mangga("Kuning");

        apel.tampilkanInfo();
        System.out.println();
        pisang.tampilkanInfo();
        System.out.println();
        mangga.tampilkanInfo();

        System.out.println("\n=== Orang ===");
        Siswa siswa = new Siswa("Alice", 20, "S12345");
        Guru guru = new Guru("Pak Brown", 40, "Matematika");
        OrangTua orangTua = new OrangTua("Bu Green", 45, "Insinyur");

        siswa.tampilkanInfo();
        System.out.println();
        guru.tampilkanInfo();
        System.out.println();
        orangTua.tampilkanInfo();
    }
}
