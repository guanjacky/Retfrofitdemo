package com.qfeng.day02;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by innershows on 16/7/26.
 */
public class MyAdapter extends RecyclerView.Adapter {

    List<String> data;
    Context ctx;

    public MyAdapter(List<String> data, Context ctx) {
        this.data = data;
        this.ctx = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            //表示是一个头
            View inflate = LayoutInflater.from(ctx).inflate(android.R.layout.simple_list_item_1, parent, false);
            TextView tv = (TextView) inflate.findViewById(android.R.id.text1);
            tv.setText("我是一个头");
            return new HeaderViewHolder(inflate);
        }

        if (viewType == 2) {
            //表示是一个尾
            View inflate = LayoutInflater.from(ctx).inflate(android.R.layout.simple_list_item_1, parent, false);
            TextView tv = (TextView) inflate.findViewById(android.R.id.text1);
            tv.setText("我是一个尾");
            return new HeaderViewHolder(inflate);
        }

        View itemView = LayoutInflater.from(ctx).
                inflate(R.layout.item, parent, false);
        MyViewHolder vh = new MyViewHolder(itemView);

        return vh;
    }


    //一个ListView怎么设置两种不同的布局？

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 0;//表示，第一个位置的类型,和其他位置的类型都不一样。 第0个是头.
            //当系统在重用布局的时候，会提前判断类型，不是同一类型的，不重用。
        }

        if (position == data.size() - 1) {
            return 2; //表示，尾部。
        }

        return 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (1 == getItemViewType(position)) {
            ((MyViewHolder) holder).tv.setText(data.get(position - 1));
        }
    }

    ////////////onCreateViewHolder//////onBindViewHolder/////////
    /////////////就是类似于我们ListView 里面的适配器，getView方法的一个整理。//////////
    @Override
    public int getItemCount() {
        return data.size();
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;
        public ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            iv = (ImageView) itemView.findViewById(R.id.iv);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    System.out.println("====点击发生了===>" + position);
                    if (onItemClickListener != null) {//当点击事件发生的时候，会回调onItemClick方法
                        onItemClickListener.onItemClick(v, position);
                    }

                }
            });

        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}





