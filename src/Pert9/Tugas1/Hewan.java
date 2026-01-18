package Pert9.Tugas1;

public class Hewan {

    protected String nama;
    protected int usia;

    public  Hewan (String nama, int usia){
        this.nama = nama;
        this.usia = usia;
    }

    void Tampilan (){
        System.out.println("Nama :" + nama);
        System.out.println("Usia :" + usia);
    }
    
}
