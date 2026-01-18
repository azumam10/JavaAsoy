package Cobacoba.hardcore;

import java.util.Scanner;

public class pert1 {

    static void LuasLingkaran(Scanner scan){
        System.out.print("Masukan Jari-Jari Lingkaran :");
        double Jarijari = scan.nextDouble();
        double luas;

        luas = Math.PI *Jarijari*2;

        System.out.println("Luas Lingkaran Adalah : " + luas);
    }

    static void LuasSegitiga(Scanner scan){
        System.out.print("Masukan Tinggi Segitiga :");
        double Tinggi = scan.nextDouble();
        System.out.print("Masukan Alas Segitiga :");
        double Alas = scan.nextDouble();
        double luas;

        luas = 0.5 * Alas*Tinggi;

        System.out.println("Luas Segitiga Adalah : " + luas);
    }

    static void LuasPersegi(Scanner scan){
        System.out.print("Masukan Sisi 1 : ");
        double Sisi1 = scan.nextDouble();
        System.out.print("Masukan Sisi 2 : ");
        double Sisi2 = scan.nextDouble();
        double luas;

        luas = Sisi1 * Sisi2;

        if (Sisi1 == Sisi2) {
            System.out.println("Ini Adalah Persegi 4");
            System.out.println("Luas : " + luas);
        }else{
            System.out.println("Ini Adalah Persegi Panjang");
            System.out.println("Luas : " + luas);

        }


    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int menu;
        char pilih;
do{
        System.out.println("=====================");
        System.out.println("1. Hitung Luas Segitiga");
        System.out.println("2. Hitung Luas Persegi");
        System.out.println("3. Hitung Luas Lingkaran");
        System.out.print("Pilih :");
        menu = scan.nextInt();

        switch (menu) {
            case 1:
            System.out.println("=====================");
            System.out.println("Hitung Luas Segitiga");
            System.out.println("=====================");
            LuasSegitiga(scan);

            break;
            
            case 2:
            System.out.println("=====================");
            System.out.println("Hitung Luas Persegi");
            System.out.println("=====================");
            LuasPersegi(scan);

            break;
            
            case 3:
            System.out.println("=====================");
            System.out.println("Hitung Luas Lingkaran");
            System.out.println("=====================");
            LuasLingkaran(scan);

            break;
        
            default:
                break;
        }

        System.out.print("Tekan Y untuk Lanjut :");
        pilih = scan.next().charAt(0);
    }while(pilih == 'Y' || pilih == 'y');

        scan.close();
    }
    
}
