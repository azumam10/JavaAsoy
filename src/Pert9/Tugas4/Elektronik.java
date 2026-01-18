package Pert9.Tugas4;


public class Elektronik extends Produk {

    private int garansi;

    public Elektronik (String nama, double harga, int stok, int garansi){
        super(nama, harga, stok);
        this.garansi = garansi;
    }

    @Override
    public void Info(){
        System.out.println("--------------------------");
        super.Info();
        System.out.println("Garansi :" + garansi + "Bulan");
        System.out.println("--------------------------");
    }



    
}
