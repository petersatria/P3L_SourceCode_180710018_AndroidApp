package com.e.main.nbc_0018.dao;

public class produkDao {
    String id_prd,nama_prd,deskripsi_prd,harga_prd,satuan_prd,stok_prd,ukuran_prd;

    public produkDao(String id_prd, String nama_prd, String deskripsi_prd, String harga_prd, String satuan_prd, String stok_prd, String ukuran_prd) {
        this.id_prd = id_prd;
        this.nama_prd = nama_prd;
        this.deskripsi_prd = deskripsi_prd;
        this.harga_prd = harga_prd;
        this.satuan_prd = satuan_prd;
        this.stok_prd = stok_prd;
        this.ukuran_prd = ukuran_prd;
    }

    public produkDao() {
    }

    public String getId_prd() {
        return id_prd;
    }

    public void setId_prd(String id_prd) {
        this.id_prd = id_prd;
    }

    public String getNama_prd() {
        return nama_prd;
    }

    public void setNama_prd(String nama_prd) {
        this.nama_prd = nama_prd;
    }

    public String getDeskripsi_prd() {
        return deskripsi_prd;
    }

    public void setDeskripsi_prd(String deskripsi_prd) {
        this.deskripsi_prd = deskripsi_prd;
    }

    public String getHarga_prd() {
        return harga_prd;
    }

    public void setHarga_prd(String harga_prd) {
        this.harga_prd = harga_prd;
    }

    public String getSatuan_prd() {
        return satuan_prd;
    }

    public void setSatuan_prd(String satuan_prd) {
        this.satuan_prd = satuan_prd;
    }

    public String getStok_prd() {
        return stok_prd;
    }

    public void setStok_prd(String stok_prd) {
        this.stok_prd = stok_prd;
    }

    public String getUkuran_prd() {
        return ukuran_prd;
    }

    public void setUkuran_prd(String ukuran_prd) {
        this.ukuran_prd = ukuran_prd;
    }
}
