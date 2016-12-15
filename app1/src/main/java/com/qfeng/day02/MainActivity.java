package com.qfeng.day02;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在setContView的时候，会有一个加载布局的操作：
        // LayoutInflater.inflate  .
        // 这样的加载操作，实际上，将会通过布局里面的每个接点，实例化对象。
        // 然后，通过一个树的结构，讲结点关联起来。
        setContentView(R.layout.activity_main);


        //　
        //getLayoutInflater().inflate()

        //RecycleView的简单使用。
        //ListView的简单使用。   获取一个ListView的对象，然后设置一个适配器。

        //1。获取到RecycleView的对象。  类似于ListView ， 也类似于GridView
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);


        //这样，就和ListView一致了
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //LinearLayoutManager 默认，是垂直，不反向的。
       // recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));

        //recyclerView.setLayoutManager(new GridLayoutManager(this , 2, LinearLayoutManager.HORIZONTAL , true));

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL));


        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                System.out.println("====onCreateViewHolder=>" + viewType);

                //加载一个布局，获取到一个对象，然后实例化一个ViewHolder
                //这里，强制要求，使用三个参数的。 同理， Fragment里面的布局加载，也需要使用三个参数的。
                View view = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false);


                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = layoutParams.height+new Random().nextInt(200);
                view.setLayoutParams(layoutParams);


                view.setBackgroundColor(Color.RED);


                MyViewHolder vh = new MyViewHolder(view);

                return vh;
            }

            //类似于:
            /*
            getView(){
                if(convertView == null){
                    convertView = inflate...;
                    ViewHoldel vh = ...
                    ....

                }else{
                    ...
                }

                //下面写的赋值操作。

            }



             */


            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MyViewHolder vh = (MyViewHolder) holder;
                vh.tv.setText("我是一个测试" + position);
            }

            //getCount
            @Override
            public int getItemCount() {
                return 10;
            }

            class MyViewHolder extends RecyclerView.ViewHolder {
                public TextView tv;

                public MyViewHolder(View itemView) {
                    super(itemView);
                    tv = (TextView) itemView.findViewById(android.R.id.text1);
                }
            }

        });


    }
}
