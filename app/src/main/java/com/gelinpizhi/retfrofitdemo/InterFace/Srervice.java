package com.gelinpizhi.retfrofitdemo.InterFace;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by guanguan on 2016/12/13.
 */

public interface Srervice {
    @GET("/")//网页的子目录，要是访问的额是根目录就是/
    Call<String> getBaidu();

}
