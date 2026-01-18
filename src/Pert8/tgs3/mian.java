package Pert8.tgs3;

public class mian {
    public static void main(String[] args) {
        Kondisi kon1 = new Kondisi("Rafli", 22, "Normal");
        System.out.println("=====================");
        kon1.Tampilan();
        Penyakit sakit1 = new Penyakit("Rafli", 22, "Demam");
        sakit1.Tampilan();
        System.out.println("=====================");
    }
}
