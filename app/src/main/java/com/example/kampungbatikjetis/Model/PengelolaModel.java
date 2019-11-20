package com.example.kampungbatikjetis.Model;

public class PengelolaModel {
    private String nama;
    private String jabatan;
    private String nomor_telp;
    private String alamat;
    private int imageId;

    public PengelolaModel(String nama, String jabatan, String nomor_telp, String alamat, int imageId) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.nomor_telp = nomor_telp;
        this.alamat = alamat;
        this.imageId = imageId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNomor_telp() {
        return nomor_telp;
    }

    public void setNomor_telp(String nomor_telp) {
        this.nomor_telp = nomor_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
