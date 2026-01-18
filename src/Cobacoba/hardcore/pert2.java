package Cobacoba.hardcore;

import java.util.Scanner;

public class pert2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;

        System.out.println("1. Input Nilai");
        System.out.println("2. Hitung Usia Tahun Depan");
        System.out.println("3. Konversi Celcius to Reamur");
        System.out.println("4. Input Nilai");
        System.out.print("Pilih : ");
        menu = scan.nextInt();

        switch (menu) {
            case 1:
            System.out.println("====================");
            System.out.println("Input Nilai");
            System.out.println("====================");
            Nilai(scan);    
            break;
            
            case 2:
            System.out.println("====================");
            System.out.println("Prediksi Usia Tahun Depan");
            System.out.println("====================");
            Usia(scan);
            break;
        
            default:
                break;
        }



        scan.close();
    }

    static void Nilai(Scanner scan){
        String nama,matkul;
        int nilai;
scan.nextLine();
        System.out.print("Nama : ");
        nama = scan.nextLine();
        System.out.print("Matkul : ");
        matkul = scan.nextLine();
        System.out.print("Nilai : ");
        nilai = scan.nextInt();

        System.out.println("Nama :" + nama);
        System.out.println("Matkul :" + matkul);
        System.out.println("Nilai :" + nilai);

        if (nilai >= 68) {
            System.out.println("Anda Lulus ! ");
        }else if (nilai == 100) {
            System.out.println("Anda Lulus Dengan Nilai Sempurna !");
        }else if(nilai < 68){
            System.out.println("Anda Tidak Lulus !!!");
        }else{
            System.out.println("Anda Gila");
        }

    }

    static void Usia(Scanner scan){
        int usia,prediksi,tahun;
        System.out.print("Masukan Usia : ");
        usia = scan.nextInt();
        System.out.print("Prediksi berapa Tahun :" );
        tahun = scan.nextInt();
        prediksi = usia + tahun;
        System.out.printf("Usia Anda %d tahun kedepan adalah : %d tahun",tahun,prediksi);
    }
    
}
