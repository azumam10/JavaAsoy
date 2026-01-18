package Pert6.soal1;

public class Esaunggul {
    private String nama;
    private String nim;
    private double ipk;

    public Esaunggul(String nama, String nim, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.ipk = ipk;
    }

    public String Getnama(){
    return this.nama;
    }
    public String Getnim(){
    return this.nim;
    }
    public double  GetIpk(){
    return this.ipk;
    }

    public void setnama(String nama){
        this.nama = nama;

    }
    public void setnim(String nim){
        this.nim = nim;

    }
    public void setIpk(double ipk){
        this.ipk = ipk;

    }

    

    
}
