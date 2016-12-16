package com.gelinpizhi.menu;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.gelinpizhi.menu.Adapters.CookAdapter;
import com.gelinpizhi.menu.GsonDataclass.Tngou;

import com.gelinpizhi.menu.GsonDataclass.TngouList;
import com.gelinpizhi.menu.RetrofiUtil.ServiceRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Tngou> {


    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private ServiceRetrofit retrofit1;
    private Call<Tngou> list;
    private int page=1;
    private CookAdapter adapter;
    private List<TngouList> lists = new ArrayList<>();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.reclycle_menu);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.sw_recycle_refash);
        //设置颜色
        refreshLayout.setColorSchemeColors(Color.WHITE , Color.YELLOW , Color.GREEN , Color.BLACK);

        //就是改变圆球的颜色
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.RED);

        //true ， 表示 可以缩放，  1 ， 2 表示移动的偏移量
        refreshLayout.setProgressViewOffset(true , 0 , 100);


        refreshLayout.setSize(SwipeRefreshLayout.LARGE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create()).build();
        retrofit1 = retrofit.create(ServiceRetrofit.class);

           refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page++;
                list = retrofit1.getList(0, page, 10);
                Log.i("Info","======================================>"+page);

                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                    }
                }, 3000);

                list.enqueue(MainActivity.this);

            }
        });

        list= retrofit1.getList(0,page,10);
        list.enqueue(this);


        //kugiougifyukfy



    }



    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {



        if (lists.isEmpty()){

            lists=response.body().getTngouLists();
            adapter = new CookAdapter(lists, this, new CookAdapter.ItemOnClick() {
                @Override
                public void onitemClick(View v, int position) {
                    Toast.makeText(MainActivity.this, "我的位置："+position, Toast.LENGTH_SHORT).show();
                }
            });
            recyclerView.setAdapter(adapter);


        }else{
            lists.addAll(response.body().getTngouLists());
            adapter.notifyDataSetChanged();
        }




    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {

    }
}
