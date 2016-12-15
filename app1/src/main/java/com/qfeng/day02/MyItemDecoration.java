package com.qfeng.day02;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by innershows on 16/7/26.
 */
public class MyItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;
    private int color;
    private int dividerHeight = 10;

    public MyItemDecoration(int color) {
        this.color = color;
    }

    public MyItemDecoration(Drawable mDivider) {
        this.mDivider = mDivider;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //super.onDraw(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        //获取到divider原始的高
        dividerHeight = mDivider.getIntrinsicHeight() == 0 ?
                10 : mDivider.getIntrinsicHeight();

        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams)
                    child.getLayoutParams();
            int top = child.getBottom() + lp.bottomMargin;
            int bottom = top + dividerHeight;

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, dividerHeight);
    }
}
