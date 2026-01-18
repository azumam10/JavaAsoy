package Pert6.soal4;

public class Elektronik extends Produk {
    private String garansi;

    public Elektronik() {
        super(); // Panggil konstruktor Produk Maenan
        this.garansi = "1 tahun";
    }

    public Elektronik(String namaProduk, double harga, int stok, String garansi) {
        super(namaProduk, harga, stok);
        this.garansi = garansi;
    }

    public String getGaransi() {
        return garansi;
    }

    public void setGaransi(String garansi) {
        this.garansi = garansi;
    }

  
    public void info() {
        super.info(); // Tampilin semua info dari Produk
        System.out.println("Garansi: " + garansi);
        System.out.println("========================");
    }


}