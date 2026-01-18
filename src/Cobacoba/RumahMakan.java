package Cobacoba;
import java.util.Scanner;

public class RumahMakan {
    
    static void PesanMakanan() {
    int Lele = 10000;
    int Ayam = 15000;
    int Bebek = 20000;
    int Kangkung = 5000;
    int TahuTempe = 7000;
    int Nasi = 3000;
    int pilihMakanan;
    char lanjut;

    
        System.out.println("Memesan makanan di Rumah Makan Umamis Lele");
        System.out.println("1. Pecel Lele komplit");
        System.out.println("2. Pecel ayam komplit");
        System.out.println("3. Pecel bebek komplit");
        System.out.println("4. Cah kangkung ");
        System.out.println("5. Tahu tempe ");
        System.out.println("6. Nasi putih");
        System.out.print("Masukkan pilihan makanan Anda: ");
        pilihMakanan = new Scanner(System.in).nextInt();
        switch (pilihMakanan) {
            case 1:
                System.out.println("Anda memesan Pecel Lele komplit dengan harga " + Lele);
                break;
            case 2:
                System.out.println("Anda memesan Pecel Ayam komplit dengan harga " + Ayam);
                break;
            case 3:
                System.out.println("Anda memesan Pecel Bebek komplit dengan harga " + Bebek);
                break;
            case 4:
                System.out.println("Anda memesan Cah kangkung dengan harga " + Kangkung);
                break;
            case 5:
                System.out.println("Anda memesan Tahu tempe dengan harga " + TahuTempe);
                break;
            case 6:
                System.out.println("Anda memesan Nasi putih dengan harga " + Nasi);
                break;
            default:
                System.out.println("Pilihan tidak valid");
                break;
        }
        System.out.println("lanjut pesan makanan? ( Y / N)");
        lanjut = new Scanner(System.in).next().charAt(0);
        if (lanjut == 'Y' || lanjut == 'y') {
            main(null);
        } else {
            System.out.println("Terima kasih telah memesan di Rumah Makan Umamis Lele");
        }
    } 

    


    static void PesanMinuman() {
        System.out.println("Memesan minuman di Rumah Makan Umamis Lele");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int pilihan;
        System.out.println("Kasir Rumah Makan Umamis Lele");
        System.out.println("Pilih Pesanan:");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        pilihan = scan.nextInt();

        switch (pilihan ) {
            case 1:
            PesanMakanan();
                break;
            case 2:
            PesanMinuman();
                break;
            default:
                break;
        }




    }
}
