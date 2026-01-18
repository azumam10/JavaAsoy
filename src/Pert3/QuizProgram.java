package Pert3;

import java.util.Scanner;

public class QuizProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char loop;
do{
        System.out.println("=== Tugas Pertemuan 3 ===");
        System.out.println("1. Menentukan Bilangan Terbesar 2 Bilangan");
        System.out.println("2. Menentukan Bilangan Ganjil/Genap");
        System.out.println("3. Program Diskon");
        System.out.println("4. Nama Hari Dengan Simbol");
        System.out.print("Pilih Menu (1-4): ");
        int menu = scan.nextInt();

        switch (menu) {
            case 1:
                // Program menentukan bilangan terbesar dari 2 bilangan
                System.out.print("Masukkan bilangan pertama: ");
                int a = scan.nextInt();
                System.out.print("Masukkan bilangan kedua: ");
                int b = scan.nextInt();

                if (a > b) {
                    System.out.println("Bilangan terbesar adalah: " + a);
                } else if (b > a) {
                    System.out.println("Bilangan terbesar adalah: " + b);
                } else {
                    System.out.println("Kedua bilangan sama besar");
                }
                break;
            case 2:
                // Program menentukan bilangan ganjil atau genap
                System.out.print("Masukkan bilangan: ");
                int bil = scan.nextInt();

                if (bil % 2 == 0) {
                    System.out.println(bil + " adalah bilangan Genap");
                } else {
                    System.out.println(bil + " adalah bilangan Ganjil");
                }
                break;
            case 3:
                // Program pemberian diskon berdasarkan jumlah pembelian
                System.out.print("Masukkan total belanja: ");
                int total = scan.nextInt();
                double diskon = 0;

                if (total >= 100000) {
                    diskon = 0.2; // diskon 20% jika belanja >= 100rb
                } else if (total >= 50000) {
                    diskon = 0.1; // diskon 10% jika belanja >= 50rb
                } else {
                    diskon = 0; // tidak ada diskon jika < 50rb
                }

                double potongan = total * diskon;
                double bayar = total - potongan;
                System.out.println("Total Belanja : " + total);
                System.out.println("Diskon        : " + (diskon * 100) + "%");
                System.out.println("Total Bayar   : " + bayar);
                break;
            case 4:
                // Program menentukan nama hari berdasarkan kode angka
                System.out.print("Masukkan kode hari (0-6): ");
                int kode = scan.nextInt();

                if (kode == 0) {
                    System.out.println("Hari Minggu");
                } else if (kode == 1) {
                    System.out.println("Hari Senin");
                } else if (kode == 2) {
                    System.out.println("Hari Selasa");
                } else if (kode == 3) {
                    System.out.println("Hari Rabu");
                } else if (kode == 4) {
                    System.out.println("Hari Kamis");
                } else if (kode == 5) {
                    System.out.println("Hari Jumat");
                } else if (kode == 6) {
                    System.out.println("Hari Sabtu");
                } else {
                    System.out.println("Kode tidak valid! (hanya 0-6)");
                }
                break;
            default:
                System.out.println("Menu tidak tersedia!");
                break;
        }
        System.out.println("Ke menu Utama? Y/N");
        loop = scan.next().charAt(0);

    }while (loop == 'y' || loop == 'Y');
    }
}

