package Pert9.Tugas1;

public class Kucing extends Hewan{
    
 String suara;

 public Kucing(String nama, int usia, String suara){
    super(nama, usia);
    this.suara = suara;
 }

 @Override
 public void Tampilan(){
    super.Tampilan();
    System.out.println("Suara : " + suara);
 }
}
