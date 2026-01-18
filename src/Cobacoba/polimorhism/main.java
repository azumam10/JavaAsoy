package Cobacoba.polimorhism;

public class main {
public static void main(String[] args) {
    Kendaraan semarang = new Mobil();
    semarang.Jalankan();
    Kendaraan jakarta = new Motor();
    jakarta.Jalankan();

    Kendaraan[] garasi = new Kendaraan[3];

    garasi[0] = new Mobil();
    garasi[1] = new Motor();
    garasi[2] = new Mobil();

    for(Kendaraan k  : garasi){
        k.Jalankan();
        System.out.println("-------------------");
    }


}
        
}
