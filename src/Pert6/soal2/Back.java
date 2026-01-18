package Pert6.soal2;

public class Back {

    private String Rekening;
    private double Saldo = 20000;

    public Back(String Rekening, double Saldo){
        this.Rekening = Rekening;
        setsaldo(Saldo);
    }

    public String Getrekening(){
        return Rekening;
    }
    public double Getsaldo(){
        return Saldo;
    }

    public void SetRekening(){
        this.Rekening = Rekening;
    }

    public void setsaldo(double Saldo){
        
        if(Saldo < 0){
            System.out.println("masukan uang!!!");
        }else{
            this.Saldo += Saldo;
            System.out.println("saldo masuk :Rp. " +Saldo);
        }
    }

    public void Tampilan(){
        System.out.println("Rekening : " + Rekening +"|" + "Saldo :" +Saldo);
    }
    
}
