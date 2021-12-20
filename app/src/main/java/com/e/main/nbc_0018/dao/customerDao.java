package com.e.main.nbc_0018.dao;

public class customerDao {
    String nama_cust,poin_cust,kode_cust,password_cust;

    public customerDao(String nama_cust, String poin_cust, String kode_cust, String password_cust) {
        this.nama_cust = nama_cust;
        this.poin_cust = poin_cust;
        this.kode_cust = kode_cust;
        this.password_cust = password_cust;
    }

    public customerDao() {
    }

    public String getNama_cust() {
        return nama_cust;
    }

    public void setNama_cust(String nama_cust) {
        this.nama_cust = nama_cust;
    }

    public String getPoin_cust() {
        return poin_cust;
    }

    public void setPoin_cust(String poin_cust) {
        this.poin_cust = poin_cust;
    }

    public String getKode_cust() {
        return kode_cust;
    }

    public void setKode_cust(String kode_cust) {
        this.kode_cust = kode_cust;
    }

    public String getPassword_cust() {
        return password_cust;
    }

    public void setPassword_cust(String password_cust) {
        this.password_cust = password_cust;
    }
}
