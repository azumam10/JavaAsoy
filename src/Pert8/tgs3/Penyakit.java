package Pert8.tgs3;

public class Penyakit extends Person {
    String penyakit;

    public Penyakit(String nama, int umur, String penyakit){
        super(nama,umur);
        this.penyakit = penyakit;
    }

    @Override
    public void Tampilan(){
        System.out.println("=====================");
        super.Tampilan();
        System.out.println("Penyakit : " + penyakit);
    }
    
}
