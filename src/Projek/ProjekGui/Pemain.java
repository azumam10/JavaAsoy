package Projek.ProjekGui;

public class Pemain {
    private String nama;
    private int skor;

    public Pemain(String nama) {
        this.nama = nama;
        this.skor = 0;
    }

    public void tambahSkor(int poin) {
        this.skor += poin;
    }

    public String getNama() {
         return nama;
         }
    
    public int getSkor() { 
        return skor;
     }
    
    // Method buat nampilin data dia string pendek
    @Override
    public String toString() {
        return nama + " (Skor: " + skor + ")";
    }
}