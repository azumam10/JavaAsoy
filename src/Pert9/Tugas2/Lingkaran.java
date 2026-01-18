package Pert9.Tugas2;

class Lingkaran extends BangunDatar {
    double jariJari;
    
   
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }
    
   
    @Override
    public double luas() {
        return Math.PI * jariJari * jariJari;
    }
    
    @Override
    public void info() {
        System.out.println("---------------------------");
        System.out.println("Lingkaran dengan jari-jari = " + jariJari);
        System.out.println("Luas = " + luas());
        System.out.println("---------------------------");
        
    }
}