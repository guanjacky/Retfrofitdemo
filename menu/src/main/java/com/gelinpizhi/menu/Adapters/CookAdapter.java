package com.gelinpizhi.menu.Adapters;

import android.content.Context;


import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;



import com.gelinpizhi.menu.GsonDataclass.TngouList;
import com.gelinpizhi.menu.R;
import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by guanguan on 2016/12/14.
 */

public class CookAdapter extends RecyclerView.Adapter{
    private List<TngouList> lists;
    private Context cxt;
    private ItemOnClick itemOnClick;




    public CookAdapter(List<TngouList> lists, Context cxt,ItemOnClick itemOnClick) {
        this.lists = lists;
        this.cxt = cxt;
        this.itemOnClick=itemOnClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {

          View view = LayoutInflater.from(cxt).inflate(R.layout.adapteractivity,parent,false);
          MyViewHolder ret = new MyViewHolder(view);


        return ret;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            int position = holder.getAdapterPosition();
            @Override
            public void onClick(View view) {
                itemOnClick.onitemClick(holder.itemView,position);
            }
        });
        MyViewHolder mh = (MyViewHolder) holder;

        mh.tv01.setText(lists.get(position).getName());
        mh.tv02.setText(lists.get(position).getDescription());
        mh.tv03.setText(lists.get(position).getKeyword());

        Picasso.with(cxt).
                load("http：//tnfs.tngou.net/img"+lists.get(position)
                        .getImg())
                .placeholder(R.mipmap.ic_launcher)
                .into(((MyViewHolder)holder).im);



    }


    @Override
    public int getItemCount() {
        return lists.size();

    }






    class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView im;
        public TextView tv01,tv02,tv03;

        public MyViewHolder(View itemView) {
            super(itemView);
            im = (ImageView) itemView.findViewById(R.id.iv_pic);
            tv01= (TextView) itemView.findViewById(R.id.tv_name);
            tv02= (TextView) itemView.findViewById(R.id.tv_decription);
            tv03= (TextView) itemView.findViewById(R.id.tv_key);


        }

    }
    public static interface ItemOnClick{
       public void onitemClick(View v,int position);


    }
    }



