package Cobacoba.hardcore.inharitance;

// Superclass
class Buah {
    protected String nama;
    protected String warna;

    public Buah(String nama, String warna) {
        this.nama = nama;
        this.warna = warna;
    }

    public void tampilkanInfo() {
        System.out.println("Buah: " + nama + ", Warna: " + warna);
    }
}

// Subclass 1
class Apel extends Buah {
    public Apel(String warna) {
        super("Apel", warna);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis: Renyah dan Manis");
    }
}

// Subclass 2
class Pisang extends Buah {
    public Pisang(String warna) {
        super("Pisang", warna);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis: Kaya Kalium");
    }
}

// Subclass 3
class Mangga extends Buah {
    public Mangga(String warna) {
        super("Mangga", warna);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis: Raja Buah");
    }
}
