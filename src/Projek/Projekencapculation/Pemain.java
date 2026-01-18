package Projek.Projekencapculation;

public class Pemain {
    private String nama;
    private int skor;

    // konstraktor nya
    public Pemain(String nama){
        this.nama = nama;
        this.skor = 0;
    }
    
    public String getNama(){
        return nama;
    }

    public int getSkor(){
        return skor;
    }

    public void tambahskor(int poin){
        this.skor += poin;
    }

    public void resetSkor(){
        this.skor = 0;
    }

    public void tampilkanProfil(){
        System.out.println("Nama Pemain: " + nama);
        System.out.println("Skor Pemain: " + skor);
    }


}
