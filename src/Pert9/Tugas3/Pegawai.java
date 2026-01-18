package Pert9.Tugas3;

public class Pegawai {

    protected String nama;
    protected int Gajipokok;

    public Pegawai(String nama, int Gajipokok){
        this.nama = nama;
        this.Gajipokok = Gajipokok;
    }

    public int HitungGaji(){
        return Gajipokok;
    }

    public void Tampilan(){
        System.out.println("Nama : " + nama);
        System.out.println("Gaji Pokok : " + Gajipokok);
    }

}
