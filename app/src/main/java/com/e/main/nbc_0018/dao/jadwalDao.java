package com.e.main.nbc_0018.dao;

public class jadwalDao {
    String nama_pegawai,hari,jam_selesai,jam_mulai;

    public jadwalDao(String nama_pegawai, String hari, String jam_selesai, String jam_mulai) {
        this.nama_pegawai = nama_pegawai;
        this.hari = hari;
        this.jam_selesai = jam_selesai;
        this.jam_mulai = jam_mulai;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(String jam_selesai) {
        this.jam_selesai = jam_selesai;
    }

    public String getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(String jam_mulai) {
        this.jam_mulai = jam_mulai;
    }
}
