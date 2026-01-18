package Pert9.Tugas3;

public class PegawaiKontrak extends Pegawai {
    private int bonusPerProyek; 
    private int jumlahProyek;   

    public PegawaiKontrak(String nama, int gajiPokok,int bonusPerProyek, int jumlahProyek) {
        super(nama, gajiPokok);
        this.bonusPerProyek = bonusPerProyek;
        this.jumlahProyek   = jumlahProyek;
    }

    @Override
    public int HitungGaji() {
        return Gajipokok + (bonusPerProyek * jumlahProyek);
    }

    @Override
    public void Tampilan() {
        super.Tampilan();
        System.out.println("Bonus Proyek : Rp " + bonusPerProyek);
        System.out.println("Jmlh Proyek   : " + jumlahProyek);
        System.out.println("Total Gaji   : " + HitungGaji());
        
    }
}
    

