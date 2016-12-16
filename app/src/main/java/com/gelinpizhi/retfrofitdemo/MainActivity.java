package com.gelinpizhi.retfrofitdemo;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.gelinpizhi.retfrofitdemo.InterFace.Srervice;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<String> {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_baidu);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://wwww.baidu.com")
                .addConverterFactory(
                        new Converter.Factory() {
                            @Override
                            public Converter<ResponseBody, ?>
                            responseBodyConverter(Type type,
                                                  Annotation[] annotations,
                                                  Retrofit retrofit) {
                                return new Converter<ResponseBody,
                                        String>() {
                                    @Override
                                    public String convert(ResponseBody value) throws IOException {
                                        return value.string();
                                    }
                                };
                            }
                        }
                        //i8uhiugi
                ).build();
        Srervice srervice = retrofit.create(Srervice.class);
        Call<String> call = srervice.getBaidu();
        call.enqueue(this);




    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
               textView.setText(response.body());


        Toast.makeText(this, "沃日，竟然成功了哈哈哈", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Toast.makeText(this, "请求失败。。。。"+call.request().url(), Toast.LENGTH_SHORT).show();
        t.getStackTrace();//获取到错误栈
    }
}
