package Pert9.Tugas2;

public class mian {
    public static void main(String[] args) {
        
       
        Persegi   persegi   = new Persegi(5);
        Lingkaran lingkaran = new Lingkaran(7);
        Segitiga  segitiga  = new Segitiga(6, 8);
        
        persegi.info();
        lingkaran.info();
        segitiga.info();
        
    }
}
