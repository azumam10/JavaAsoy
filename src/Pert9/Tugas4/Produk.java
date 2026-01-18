package Pert9.Tugas4;

public class Produk {
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void Info(){
        System.out.println("Nama Produk : " + nama);
        System.out.println("Harga Produk : " + harga);
        System.out.println("Stok Produk : " + stok);
    }

    


    
}
