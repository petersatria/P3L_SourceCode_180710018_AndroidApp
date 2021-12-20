package com.e.main.nbc_0018.api;

import com.e.main.nbc_0018.dao.customerDao;
import com.e.main.nbc_0018.dao.jadwalDao;
import com.e.main.nbc_0018.dao.perawatanDao;
import com.e.main.nbc_0018.dao.produkDao;
import com.e.main.nbc_0018.dao.promoDao;
import com.e.main.nbc_0018.dao.riwayatDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("Produk/mobile")
    Call<List<produkDao>> viewAllProduk();

    @GET("Produk/mobileBest")
    Call<List<produkDao>> viewBestProduk(@Query("tahun") String tahun,@Query("bulan") String bulan);

    @GET("Perawatan/mobile")
    Call<List<perawatanDao>> viewAllPerawtan();

    @GET("Perawatan/mobileBest")
    Call<List<perawatanDao>> viewBestPerawatan(@Query("tahun") String tahun,@Query("bulan") String bulan);

    @GET("Promo/mobile")
    Call<List<promoDao>> viewAllPromo();

    @GET("DetilJadwal/mobile")
    Call<List<jadwalDao>> viewAllJadwal();

    @POST("Customer/login")
    Call<customerDao> login(@Body customerDao body);

    @GET("Customer/mobile")
    Call<customerDao> get(@Query("kode") String kode);

    @GET("Transaksi/mobile")
    Call<List<riwayatDao>> getRiwayat(@Query("kode") String kode);


}
