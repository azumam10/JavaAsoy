package Cobacoba.Animal;

public class Main{
    public static void main(String[] args) {

        Animal[] Hewan = new Animal[4];

        Hewan[0] = new Animal();
        Hewan[1] = new Dog();
        Hewan[2] = new Macan();
        Hewan[3] = new Kucing();

        for (Animal tes : Hewan) {
            tes.suara();
            
        }

        
    }
}