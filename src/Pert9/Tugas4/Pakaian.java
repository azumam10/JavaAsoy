package Pert9.Tugas4;

public class Pakaian extends Produk {

    private String ukuran;

    public Pakaian(String nama, double harga, int stok, String ukuran){
        super(nama, harga, stok);
        this.ukuran = ukuran;
    }

    @Override
    public void Info(){
        super.Info();
        System.out.println("Ukuran : " + ukuran);
        System.out.println("--------------------");
    }
    
}
