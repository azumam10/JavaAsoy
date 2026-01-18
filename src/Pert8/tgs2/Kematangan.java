package Pert8.tgs2;

public class Kematangan extends Buah {
    String kematangan;

    public Kematangan(String kematangan, String nama, String warna){
        super(nama,warna);
        this.kematangan = kematangan;
    }

    public void Display(){
        super.Output();
        System.out.println("Kematangan : " + kematangan);
    }

    public static void main(String[] args) {
        Kematangan hasil1 = new Kematangan("Matang", "Apel", "Merah");
        hasil1.Display();
    }
    
}
