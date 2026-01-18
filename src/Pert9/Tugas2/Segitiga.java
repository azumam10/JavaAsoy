package Pert9.Tugas2;

class Segitiga extends BangunDatar {
    double alas;
    double tinggi;
    
    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }
    
    
    @Override
    public double luas() {
        return 0.5 * alas * tinggi;
    }
    
    @Override
    public void info() {
        System.out.println("---------------------------");
        System.out.println("Segitiga dengan alas = " + alas + " dan tinggi = " + tinggi);
        System.out.println("Luas = " + luas());
        System.out.println("---------------------------");
    }
}
