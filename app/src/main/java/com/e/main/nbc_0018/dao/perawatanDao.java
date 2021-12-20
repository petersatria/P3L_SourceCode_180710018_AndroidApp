package com.e.main.nbc_0018.dao;

public class perawatanDao {
    String id_prw,nama_prw,deskripsi_prw,harga_prw,poin_prw,isMedis;

    public String getId_prw() {
        return id_prw;
    }

    public void setId_prw(String id_prw) {
        this.id_prw = id_prw;
    }

    public String getNama_prw() {
        return nama_prw;
    }

    public void setNama_prw(String nama_prw) {
        this.nama_prw = nama_prw;
    }

    public String getDeskripsi_prw() {
        return deskripsi_prw;
    }

    public void setDeskripsi_prw(String deskripsi_prw) {
        this.deskripsi_prw = deskripsi_prw;
    }

    public String getHarga_prw() {
        return harga_prw;
    }

    public void setHarga_prw(String harga_prw) {
        this.harga_prw = harga_prw;
    }

    public String getPoin_prw() {
        return poin_prw;
    }

    public void setPoin_prw(String poin_prw) {
        this.poin_prw = poin_prw;
    }

    public String getIsMedis() {
        return isMedis;
    }

    public void setIsMedis(String isMedis) {
        this.isMedis = isMedis;
    }

    public perawatanDao() {
    }

    public perawatanDao(String id_prw, String nama_prw, String deskripsi_prw, String harga_prw, String poin_prw, String isMedis) {
        this.id_prw = id_prw;
        this.nama_prw = nama_prw;
        this.deskripsi_prw = deskripsi_prw;
        this.harga_prw = harga_prw;
        this.poin_prw = poin_prw;
        this.isMedis = isMedis;
    }
}
