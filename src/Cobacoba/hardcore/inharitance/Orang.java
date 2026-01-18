package Cobacoba.hardcore.inharitance;

// Superclass
class Orang {
    protected String nama;
    protected int usia;

    public Orang(String nama, int usia) {
        this.nama = nama;
        this.usia = usia;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama + ", Usia: " + usia);
    }
}

// Subclass 1
class Siswa extends Orang {
    private String idSiswa;

    public Siswa(String nama, int usia, String idSiswa) {
        super(nama, usia);
        this.idSiswa = idSiswa;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("ID Siswa: " + idSiswa);
    }
}

// Subclass 2
class Guru extends Orang {
    private String mataPelajaran;

    public Guru(String nama, int usia, String mataPelajaran) {
        super(nama, usia);
        this.mataPelajaran = mataPelajaran;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Mata Pelajaran: " + mataPelajaran);
    }
}

// Subclass 3
class OrangTua extends Orang {
    private String pekerjaan;

    public OrangTua(String nama, int usia, String pekerjaan) {
        super(nama, usia);
        this.pekerjaan = pekerjaan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Pekerjaan: " + pekerjaan);
    }
}