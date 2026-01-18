package Pert2;
import java.util.Scanner;


public class BangunRuang {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pilihan;
        double LuasAlas,KelilingAlas,Tinggi,LuasPrisma, Volume;
        char Pilihan;

do{


        System.out.println("#################################");
        System.out.println("Perhitungan Luas Bangun Prisma");
        System.out.println("#################################");
        System.out.println("===================================");
        System.out.print("Masukan Luas Alas Prisma :");
        LuasAlas = scan.nextDouble();
        System.out.println("===================================");
        System.out.print("Masukan Keliling Alas Prisma :");
        KelilingAlas = scan.nextDouble();
        System.out.println("===================================");
        System.out.print("Masukan Tinggi Prisma :");
        Tinggi = scan.nextDouble();
        System.out.println("===================================");

        LuasPrisma = 2 * LuasAlas + KelilingAlas * Tinggi;
        Volume = LuasAlas * Tinggi;
        System.out.println("=======================");
        System.out.println("LUAS PERMUKAAN PRISMA " + LuasPrisma);
        System.out.println("VOLUME PRISMA ADALAH " + Volume);
        System.out.println("=======================");

        System.out.print("Lanjut Menghitung ? Y / N :");
        Pilihan = scan.next().charAt(0);

}while (Pilihan == 'Y' || Pilihan == 'y');

    }
}
