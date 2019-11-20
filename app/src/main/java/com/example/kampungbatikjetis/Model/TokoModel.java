package com.example.kampungbatikjetis.Model;

import androidx.annotation.IntegerRes;

import java.util.ArrayList;
import java.util.List;

public class TokoModel {

    private int imageId;
    private String namaToko;
    private String nomorTelpToko;
    private String alamatToko;

    private List<UlasanModel> ulasanList = new ArrayList<>();
    private List<Integer> gambarId = new ArrayList<>();


    public TokoModel(int imageId, String namaToko, String nomorTelpToko, String alamatToko, List<UlasanModel> ulasanList, List<Integer> gambarId) {
        this.imageId = imageId;
        this.namaToko = namaToko;
        this.nomorTelpToko = nomorTelpToko;
        this.alamatToko = alamatToko;
        this.ulasanList = ulasanList;
        this.gambarId = gambarId;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public String getNomorTelpToko() {
        return nomorTelpToko;
    }

    public void setNomorTelpToko(String nomorTelpToko) {
        this.nomorTelpToko = nomorTelpToko;
    }

    public String getAlamatToko() {
        return alamatToko;
    }

    public void setAlamatToko(String alamatToko) {
        this.alamatToko = alamatToko;
    }

    public List<UlasanModel> getUlasanList() {
        return ulasanList;
    }

    public void setUlasanList(List<UlasanModel> ulasanList) {
        this.ulasanList = ulasanList;
    }

    public List<Integer> getGambarId() {
        return gambarId;
    }

    public void setGambarId(List<Integer> gambarId) {
        this.gambarId = gambarId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}


