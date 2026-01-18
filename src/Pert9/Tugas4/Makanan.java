package Pert9.Tugas4;

public class Makanan extends Produk {
    // private LocalDateTime Waktu;
    private int tahunkadaluarsa;

    public Makanan (String nama, double harga, int stok,  int tahunkadaluarsa){
        super(nama, harga, stok);
        // this.Waktu = LocalDateTime.now();
        this.tahunkadaluarsa = tahunkadaluarsa;
    }

    @Override
    public void Info(){
        super.Info();
        if (tahunkadaluarsa > 2025) {
            System.out.println("Makanan Belum Kadaluarsa");
        }else if (tahunkadaluarsa <= 2025){
            System.out.println("Makanan Kadaluarsa Tidak bisa Dibeli");
        }

        System.out.println("-----------------");
    }

}
