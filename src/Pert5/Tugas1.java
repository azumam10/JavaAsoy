package Pert5;

import java.util.Scanner;


public class Tugas1 {

    private double Saldo = 0;


    // method liat saldo
    public double getsaldo(){
        return Saldo;
    }

    public void Setor(double Jumlah){
        if (Jumlah > 0) {
            Saldo += Jumlah;
        }else{
            System.out.println("stor harus positif");
        }
    }

    public void Tarik(double Jumlah){
        if (Jumlah > Saldo) {
            System.out.println("Saldo anda kurang");
        }else{
            Saldo -= Jumlah;
        }
    }

 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pilih;
        Tugas1 akun = new Tugas1();
        double stor;
        
        
        do {
        System.out.println("System Bank Sederhana");
        System.out.println("1. Setor Tunai");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Lihat Saldo");
        System.out.println("4. Keluar");
        System.out.print("Pilih Menu :");
        pilih = scan.nextInt();

        switch (pilih) {
            case 1:
            System.out.println("Masukan Jumlah Setor : ");
            stor = scan.nextDouble();
            akun.Setor(stor);
            System.out.println("Saldo Anda Sekarang : " + akun.getsaldo());            
                break;
            case 2:
            System.out.println("Masukan Jumlah Tarik : ");
            stor = scan.nextDouble();
            akun.Tarik(stor);
            System.out.println("Saldo Anda Sekarang : " + akun.getsaldo());
                break;
            case 3:
            System.out.println("Saldo Anda Sekarang : " + akun.getsaldo());
                break;
            default:
                break;
        }
    } while (pilih != 4);

    System.out.println("Terima kasih telah menggunakan sistem kami.");
    scan.close();
    }
    
}
