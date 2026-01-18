package Pert6.soal3;

import java.util.Scanner;

public class produk {
    private String Namaproduk;
    private double harga;
    private int stok;

    // konstaktor buat di maenin datanya
    public produk() {
        this.Namaproduk = "Mouse fanctech ";
        this.harga = 100000;
        this.stok = 10;
    }

    // konstraktor dasar
    public produk(String Namaproduk, double harga, int stok) {
        this.Namaproduk = Namaproduk;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return Namaproduk;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void TambahStok(Scanner scan) {
        System.out.print("Masukkan jumlah stok : ");
        int jumlah = scan.nextInt();
        if (jumlah > 0) {
            stok += jumlah;
            System.out.println("Stok berhasil ditambahkan Stok sekarang: " + stok);
        } else {
            System.out.println("Jumlah harus lebih dari 0");
        }
    }

    public void KurangStok(Scanner scan) {
        System.out.print("Mau Kurangi Stok berapa: ");
        int jumlah = scan.nextInt();
        if (jumlah > 0 && jumlah <= stok) {
            stok -= jumlah;
            System.out.println("Stok berhasil dikurangi Stok sekarang: " + stok);
        } else if (jumlah <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
        } else {
            System.out.println("gabisa Stok saat ini cuma: " + stok);
        }
    }

    public void info() {
        System.out.println("Nama Produk: " + Namaproduk);
        System.out.println("Stok: " + stok);
        System.out.println("Harga per barang: Rp " + harga);
    }
}