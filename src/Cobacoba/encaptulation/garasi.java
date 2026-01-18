package Cobacoba.encaptulation;

public class garasi {

    private String merek;
    private String tipe;
    private int tahun;
    private int stok;
    
    // konstraktor
    public garasi(String merek, String tipe, int tahun, int stok){
        this.merek = merek;
        this.tipe = tipe;
        this.stok = stok;
        this.tahun = tahun;
    }

    // ===== seter geter ======
    public String getMerek(){
        return merek;
    }
    public String getTipe(){
        return tipe;
    }
    public int getTahun(){
        return tahun;
    }
    public int getStok(){
        return stok;
    }

    

}
