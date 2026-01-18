package Pert8.tgs1;

// Superclass
public class Karyawan {

    protected int gaji;
    protected String nama;

    public Karyawan (int gaji, String nama){
        this.nama = nama;
        this.gaji = gaji;
    }

    public void Output(){
        System.out.println("=====================");
        System.out.println("Nama: " + nama );
        System.out.println("Gaji: " + gaji );
        
    }
    
}
