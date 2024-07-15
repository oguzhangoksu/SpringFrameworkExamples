package com.haydikodlayalim.entity;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Kullanici {

    
    @Id
    private String id;
    private String adi;
    private String soyadi;
    private HashMap özellikleri;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAdi() {
        return adi;
    }
    public void setAdi(String adi) {
        this.adi = adi;
    }
    public String getSoyadi() {
        return soyadi;
    }
    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }
    public HashMap getÖzellikleri() {
        return özellikleri;
    }
    public void setÖzellikleri(HashMap özellikleri) {
        this.özellikleri = özellikleri;
    }


}
