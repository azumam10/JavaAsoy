package Pert8.tgs2;

public class Buah {
    protected String nama;
    protected String warna;

    public Buah(String nama, String warna){
        this.nama = nama;
        this.warna = warna;
    }

    public void Output(){
        System.out.println("Buah : " + nama);
        System.out.println("Warna : " + warna);
    }
    
}
