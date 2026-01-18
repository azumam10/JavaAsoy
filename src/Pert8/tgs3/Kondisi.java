package Pert8.tgs3;

public class Kondisi extends Person {
    String kondisi;

    public Kondisi(String nama, int umur, String kondisi){
        super(nama,umur);
        this.kondisi = kondisi;
    }

    @Override
    public void Tampilan(){
        super.Tampilan();
        System.out.println("Kondisi : " + kondisi);
    }
}
