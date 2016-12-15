package com.gelinpizhi.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.gelinpizhi.menu.Adapters.CookAdapter;
import com.gelinpizhi.menu.GsonDataclass.Tngou;

import com.gelinpizhi.menu.RetrofiUtil.ServiceRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Tngou> {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.reclycle_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ServiceRetrofit retrofit1 = retrofit.create(ServiceRetrofit.class);
        Call<Tngou> list = retrofit1.getList(0, 1, 10);
        list.enqueue(this);


    }



    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {
            recyclerView.setAdapter(new CookAdapter(response.body().getTngouLists(),this));

    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {

    }
}
