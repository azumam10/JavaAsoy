package Pert9.Tugas4;

public class main {

    public static void main(String[] args) {
        Elektronik elektronik1 = new Elektronik("Laptop Dell", 10000, 3, 2);
        elektronik1.Info();
        Pakaian pakaian1 = new Pakaian("Hoodie", 125000, 8, "L");
        pakaian1.Info();
        Makanan makanan1 = new Makanan("Bengbeng", 5000, 10, 2024);
        makanan1.Info();
        
        Makanan makanan2 = new Makanan("Tuku", 10000, 3,  2026);
        makanan2.Info();



    }
    
}
