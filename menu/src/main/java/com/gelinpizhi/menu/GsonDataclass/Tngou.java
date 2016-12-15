package com.gelinpizhi.menu.GsonDataclass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by guanguan on 2016/12/14.
 */

public class Tngou {
    @SerializedName("status")
    private boolean  status;
    @SerializedName("total")
    private int   total;
    @SerializedName("tngou")
    private List<TngouList> tngouLists;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTngouLists(List<TngouList> tngouLists) {
        this.tngouLists = tngouLists;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public List<TngouList> getTngouLists() {
        return tngouLists;
    }

    public int getTotal() {
        return total;
    }
}
