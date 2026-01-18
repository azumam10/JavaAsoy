package Projek.Projek_Inharitance;

import java.util.ArrayList;
import java.util.List;

public class Pemain {
    private List<String> nama;
    private int skor;

    // konstraktor nya
    public Pemain(String nama){
        this.nama = new ArrayList<>();
        this.skor = 0;
    }
    
    // getter nama
    public List<String> getNama(){
        return nama;
    }

    // getter skor
    public int getSkor(){
        return skor;
    }

    public void tambahskor(int poin){
        this.skor += poin;
    }

    public void resetSkor(){
        this.skor = 0;
    }
    public void addNama(String namas){
        nama.add(namas);
    }

    public void tampilkanProfil(){
        System.out.println("Nama Pemain: " + nama);
        System.out.println("Skor Pemain: " + skor);
    }


}
