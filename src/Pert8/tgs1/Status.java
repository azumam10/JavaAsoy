package Pert8.tgs1;

// subclass 3 -> 2
public class Status extends Divisi{
    String status;

    public Status(String Dapartemen, int gaji, String nama, String status){
        super(Dapartemen, gaji, nama);
        this.status = status;
    }

    @Override
    public void Display(){
    super.Output();
    System.out.println("Departemen: " + Dapartement);
    System.out.println("---------------------");
    System.out.println("Status : " + status);
    System.out.println("=====================");
}
public static void main(String[] args) {
    
    Status kon1 = new Status("CEO", 1000000000, "Umam", "Kartap");
    kon1.Display();
    Status kon2 = new Status("OBE", 100000, "Virga", "Magang");
    kon2.Display();
    
 }
    
}
