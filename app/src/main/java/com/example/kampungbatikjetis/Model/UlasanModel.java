package com.example.kampungbatikjetis.Model;

public class UlasanModel {

    private String nama;
    private int jumlahBintang;
    private String isiUlasan;

    public UlasanModel(String nama, int jumlahBintang, String isiUlasan) {
        this.nama = nama;
        this.jumlahBintang = jumlahBintang;
        this.isiUlasan = isiUlasan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlahBintang() {
        return jumlahBintang;
    }

    public void setJumlahBintang(int jumlahBintang) {
        this.jumlahBintang = jumlahBintang;
    }

    public String getIsiUlasan() {
        return isiUlasan;
    }

    public void setIsiUlasan(String isiUlasan) {
        this.isiUlasan = isiUlasan;
    }
}
