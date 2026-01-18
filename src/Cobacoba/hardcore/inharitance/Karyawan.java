package Cobacoba.hardcore.inharitance;

// Superclass
class Karyawan {
    protected String nama;
    protected double gaji;

    public Karyawan(String nama, double gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama + ", Gaji: " + gaji);
    }
}

// Subclass 1
class Manajer extends Karyawan {
    private String departemen;

    public Manajer(String nama, double gaji, String departemen) {
        super(nama, gaji);
        this.departemen = departemen;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Departemen: " + departemen);
    }
}

// Subclass 2
class Programmer extends Karyawan {
    private String bahasaPemrograman;

    public Programmer(String nama, double gaji, String bahasa) {
        super(nama, gaji);
        this.bahasaPemrograman = bahasa;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bahasa Pemrograman: " + bahasaPemrograman);
    }
}

// Subclass 3
class Magang extends Karyawan {
    private int durasi; // Durasi magang dalam bulan

    public Magang(String nama, double gaji, int durasi) {
        super(nama, gaji);
        this.durasi = durasi;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Durasi Magang: " + durasi + " bulan");
    }
}