package com.qfeng.day02;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class DemoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        //设置和ListView显示一样的效果。
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //设置滑动的监听
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                System.out.println("===onScrollStateChanged==>" + newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                System.out.println("===onScrolled=dx=>" + dx);
                System.out.println("===onScrolled=dy=>" + dy);
            }
        });


        //设置是否已经指定大小了。一般，用在优化的时候。
        recyclerView.setHasFixedSize(true);


        //设置适配器
        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            data.add("隔壁老王" + i);
        }

        MyAdapter adapter = new MyAdapter(data, this);

        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(DemoActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);


//        recyclerView.addItemDecoration(
//                new MyItemDecoration(getResources().getDrawable(R.mipmap.ic_launcher)));

        recyclerView.addItemDecoration(new MyItemDecoration(new ColorDrawable(Color.RED)));

        //listView.setDivider(Drawable);

//        //给Recycle添加一个分割线。
//        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
//            //这个类是抽象的，但是没有抽象方法
//            //绘制，画。用来绘制分割线。
//            @Override
//            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//                super.onDraw(c, parent, state);
//
//                //待会儿需要画的分割线的左边的坐标
//                int left = parent.getPaddingLeft();
//
//                //右边的坐标
//                int right = parent.getWidth() - parent.getPaddingRight();
//
//                //因为，所有的分割线，左右的坐标都是一样的。
//
//
//                Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
//                p.setColor(Color.RED);
//
//                //获取到子控件的数量
//                int count = parent.getChildCount();
//                for (int i = 0; i < count; i++) {
//                    //使用一个for循环，遍历一下。实际上，需要在每个子控件之间，画分割线
//                    View child = parent.getChildAt(i);
//
//                    //child.getmargin
//                    RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams)
//                            child.getLayoutParams();
//
//                    //分割线上面的坐标，就是子控件本身的高度+对外面的margin值
//                    int top = child.getBottom() + lp.bottomMargin;
//
//                    int bottom = top + 20; //表示，设置分割线的高度为20个px。
//                    c.drawRect(left, top, right, bottom, p);
//                }
//            }
//
//            //获取item项的偏移
//            @Override
//            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//                super.getItemOffsets(outRect, view, parent, state);
//                outRect.set(0 , 0 , 0 , 20);
//            }
//        });
////
        //这个方法可以用，但是稍微有点点麻烦。可以使用，在item布局的下面，直接使用一个View的方式，画分割线


//        recyclerView.addHeader();
//        recyclerView.addFooter();
//        recyclerView.setDivider();
//        recyclerView.setOnItemClickListener();
    }


    public void fling(View view) {
        //可以滑动到某个指定的位置
        recyclerView.fling(0, 9000);
    }
}
