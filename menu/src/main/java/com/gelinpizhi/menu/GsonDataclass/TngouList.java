package com.gelinpizhi.menu.GsonDataclass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by guanguan on 2016/12/14.
 */

public class TngouList {
    @SerializedName("count")
    private int count;
    @SerializedName("description")
    private String description;
    @SerializedName("fcount")
    private int fcount;
    @SerializedName("id")
    private int id;
    @SerializedName("images")
    private String images;
    @SerializedName("img")
    private String img;
    @SerializedName("keyword")
    private String keyword;
    @SerializedName("name")
    private String name;
    @SerializedName("rcount")
    private int rcount;

    public void setCount(int count) {
        this.count = count;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public int getCount() {

        return count;
    }

    public String getDescription() {
        return description;
    }

    public int getFcount() {
        return fcount;
    }

    public int getId() {
        return id;
    }

    public String getImages() {
        return images;
    }

    public String getImg() {
        return img;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getName() {
        return name;
    }

    public int getRcount() {
        return rcount;
    }
}
