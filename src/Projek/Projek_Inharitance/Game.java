package Projek.Projek_Inharitance;

import java.util.Scanner;

// Abstrak ibaratnya Orangtua Yang membebaskan Anaknya menjadi apa
// Karna stiap anak memiliki jalannya masing masing tapi ada 1 peraturan yang harus di ikuti
// nah peraturan itu adalah (mainkan)
public abstract class Game {
    protected String namaGame;

    //  construktornya
    public Game(String namaGame){
        this.namaGame = namaGame;
    }

    public void Namagame(){
        System.out.println("=======" + namaGame + "========");
        System.out.println("Fokus Dan Selesaikan");
    }
    
    // semua Method turunan Harus Menjalankan ini
    public abstract  void mainkan(Pemain pemain, Scanner scan);

}
