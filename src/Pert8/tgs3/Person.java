package Pert8.tgs3;

public class Person {

    protected String nama;
    protected int umur;

    public Person(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
    }

    public void Tampilan(){
        System.out.println("Nama : " + nama);
        System.out.println("Umur : " + umur);
    }
    
}

   