package Pert9.Tugas3;

class PegawaiTetap extends Pegawai {

    int tunjangan;

    public PegawaiTetap(String nama, int Gajipokok, int tunjangan){
        super(nama, Gajipokok);
        this.tunjangan = tunjangan;
    }

    @Override
    public int HitungGaji(){
        return Gajipokok + tunjangan;
    }
    
    @Override
    public void Tampilan(){
        super.Tampilan();
        System.out.println("Tunjangan : " + tunjangan);
        System.out.println("Total Gaji : " + HitungGaji());
    }
}
