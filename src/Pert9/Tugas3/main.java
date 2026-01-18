package Pert9.Tugas3;

public class main {
    public static void main(String[] args) {
        
        Pegawai Peg1 = new Pegawai("Umam", 10000);
        Peg1.Tampilan();
        PegawaiKontrak pegawaiKontrak1 = new PegawaiKontrak("Azkiya", 10000000, 500000, 5);
        pegawaiKontrak1.Tampilan();
        PegawaiTetap pegawaiTetap1 = new PegawaiTetap("Azumam", 10000000, 2000000);
        pegawaiTetap1.Tampilan(); 
        
    }
}
