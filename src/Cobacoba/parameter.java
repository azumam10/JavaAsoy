package Cobacoba;

import java.util.Scanner;
public class parameter {

    public static void sapa(String Nama){
        System.out.println("Selamat pagi " + Nama);
    }

    public static int Tambah(int a, int b) {
        return a + b;
    }
    public static int Kurang(int a, int b) {
        return a - b;
    }
    public static int Bagi(int a, int b) {
        return a / b;
    }
    public static int Kali(int a, int b) {
        return a * b;
    }

    public static int Deretangka(int n){
        if (n <= 1) {
            return n;
        }
        return n + Deretangka(n - 1);
    }

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int Pilih;
   do{     
    System.out.println("pilih menu ");    
    System.out.println("1. Sapa ");    
    System.out.println("2. Arit matika ");    
    System.out.println("3. deret angka ");    
    System.out.print("pilih menu : ");
    Pilih = scan.nextInt();
    
switch (Pilih) {
    case 1:
        System.out.println("Masukan Nama :");
        scan.nextLine();
        String Nama = scan.nextLine();
        sapa(Nama);
        break;

    case 2:
    System.out.print("masukan angka pertama :");
    int a = scan.nextInt();
    System.out.print("masukan angka kedua :");
    int b = scan.nextInt();
    int hasilTambah = Tambah(a, b);
    int hasilKurang = Kurang(a, b);
    int HasilBagi = Bagi(a, b);
    int hasilKali = Kali(a, b);
    
    System.out.println("hasil penjumlahan = " + hasilTambah);
    System.out.println("hasil Pengurangan = " + hasilKurang);
    System.out.println("hasil pembagian = " + HasilBagi);
    System.out.println("hasil Perkalian = " + hasilKali);
    break;

    case 3:
    System.out.print("Masukang Angka : ");
    int n = scan.nextInt();
    int hasilderet = Deretangka(n);
    System.out.println("Hasil = " + hasilderet);


    default:
        break;
}
   }while (Pilih !=0);
scan.close();
    }
    
}
