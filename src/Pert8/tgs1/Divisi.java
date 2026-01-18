package Pert8.tgs1;

// multivel inheritance
// subclass 2 -> 1

public class Divisi extends Karyawan {
 String Dapartement;
 
 public Divisi(String Dapartemen, int gaji, String nama){
    super(gaji, nama);
    this.Dapartement = Dapartemen;
 }

 public void Display(){
    super.Output();
    System.out.println("Departemen: " + Dapartement);
    System.out.println("=====================");
}
    
}
