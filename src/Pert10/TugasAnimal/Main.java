package Pert10.TugasAnimal;

public class Main {
    public static void main(String[] args) {
        
        Animal hew1 = new Animal();
        Animal hew2 = new Cat();
        Animal hew3 = new Macan();

        Animal[] binatang = new Animal[3];

        binatang[0] = new Cat();
        binatang[1] = new Macan();
        binatang[2] = new Cat();

        for (Animal hewan : binatang) {
            hewan.suara();
            
        }

    }
    
}
