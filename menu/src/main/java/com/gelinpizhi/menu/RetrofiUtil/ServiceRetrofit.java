package com.gelinpizhi.menu.RetrofiUtil;

import com.gelinpizhi.menu.GsonDataclass.Tngou;
import com.gelinpizhi.menu.GsonDataclass.TngouList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by guanguan on 2016/12/14.
 */

public interface ServiceRetrofit {

    @GET("api/cook/list")
    Call<Tngou> getList(@Query("id") int id, @Query("page")int page, @Query("row")int row);
}
