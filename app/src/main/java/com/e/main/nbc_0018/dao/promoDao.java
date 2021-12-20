package com.e.main.nbc_0018.dao;

public class promoDao {
    String kode_promo,nama_promo,diskon;

    public String getKode_promo() {
        return kode_promo;
    }

    public void setKode_promo(String kode_promo) {
        this.kode_promo = kode_promo;
    }

    public String getNama_promo() {
        return nama_promo;
    }

    public void setNama_promo(String nama_promo) {
        this.nama_promo = nama_promo;
    }

    public String getDiskon() {
        return diskon;
    }

    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    public promoDao() {
    }

    public promoDao(String kode_promo, String nama_promo, String diskon) {
        this.kode_promo = kode_promo;
        this.nama_promo = nama_promo;
        this.diskon = diskon;
    }
}
