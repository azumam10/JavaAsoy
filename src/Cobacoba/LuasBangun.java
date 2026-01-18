package Cobacoba;
import java.util.Scanner;

public class LuasBangun {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int PilihMenu;
        char loop;

        do{
            System.out.println("Pilih Bangun Ruang");
            System.out.println("1. Segitiga");
            System.out.println("2. Persegi Persegi");
            System.out.println("3. Lingkaran");
            System.out.print("Pilih Menu :");
            PilihMenu = scan.nextInt();

            switch (PilihMenu) {
                case 1:
                double TinggiSegitiga, AlasSegitiga, LuasSegitiga;

                System.out.print("Masukan Panjang :");
                TinggiSegitiga = scan.nextDouble();
                System.out.print("Masukan Lebar :");
                AlasSegitiga = scan.nextDouble();
                LuasSegitiga = 0.5 * TinggiSegitiga * AlasSegitiga;
                
                System.out.println("=======================");
                System.out.println("Luas Segitiga adalah : " + LuasSegitiga );
                System.out.println("=======================");
                
                    break;

                case 2:
                double PanjangPersegi,TinggiPersegi,LuasPersegi;

                System.out.print("Masukan Panjang Persegi :");
                PanjangPersegi = scan.nextDouble();
                System.out.print("Masukan Tinggi Persegi :");
                TinggiPersegi = scan.nextDouble();
                
                LuasPersegi = PanjangPersegi * TinggiPersegi;
                if (PanjangPersegi == TinggiPersegi) {
                    System.out.println("===============================");
                    System.out.println("INI ADALAH PERSEGI 4");
                    System.out.println("Dengan Luas : " + LuasPersegi);
                    System.out.println("===============================");
                }else if (PanjangPersegi != TinggiPersegi) {
                    System.out.println("===============================");
                    System.out.println("INI ADALAH PERSEGI PANJANG ");
                    System.out.println("Dengan Luas : " + LuasPersegi);
                    System.out.println("===============================");
                    
                    
                } 
                else{
                   System.out.println("Masukan Angka");
                }

                break;
                
                case 3:
                double JariLingkaran, LuasLingkaran;

                System.out.print("Masukan Jari Jari Lingkaran :");
                JariLingkaran = scan.nextDouble();

                LuasLingkaran = Math.PI * JariLingkaran * JariLingkaran;
                
                System.out.println("=========================");
                System.out.println("Luas Lingkaran Adalah : " + LuasLingkaran);
                System.out.println("=========================");

                break;
            
                default:
                    break;
            }

            System.out.println("Kembali Menghitung? Y/N");
            loop = scan.next().charAt(0);
        }while (loop == 'Y' || loop == 'y');
           
    }

    
}
