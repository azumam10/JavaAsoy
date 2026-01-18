package Pert9.Tugas2;

class Persegi extends BangunDatar {
    double sisi;
    
    
    public Persegi(double sisi) {
        this.sisi = sisi;
    }
    
    
    @Override
    public double luas() {
        return sisi * sisi;
    }
    
    @Override
    public void info() {
        System.out.println("---------------------------");
        System.out.println("Persegi dengan sisi = " + sisi);
        System.out.println("Luas = " + luas());
        System.out.println("---------------------------");
        
    }
}