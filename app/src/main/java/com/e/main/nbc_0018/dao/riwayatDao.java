package com.e.main.nbc_0018.dao;

public class riwayatDao {
    String kode_transaksi,tgl_transaksi,total;

    public riwayatDao(String kode_transaksi, String tgl_transaksi, String total) {
        this.kode_transaksi = kode_transaksi;
        this.tgl_transaksi = tgl_transaksi;
        this.total = total;
    }

    public riwayatDao() {
    }

    public String getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(String kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }

    public String getTgl_transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_transaksi(String tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
