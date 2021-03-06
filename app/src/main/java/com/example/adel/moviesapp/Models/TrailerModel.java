package com.example.adel.moviesapp.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed Adel on 1/22/2017.
 */

public class TrailerModel {
    @SerializedName("id")
    String id;
    @SerializedName("iso_639_1")
    String iso_639_1;
    @SerializedName("iso_3166_1")
    String iso_3166_1;
    @SerializedName("key")
    String key;
    @SerializedName("site")
    String site;
    @SerializedName("name")
    String name;
    @SerializedName("size")
    String size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @SerializedName("type")
    String type;

}
