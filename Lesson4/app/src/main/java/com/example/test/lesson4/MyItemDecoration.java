package com.example.test.lesson4;

/**
 * Created by fengjen on 2018/2/8.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.graphics.Rect;

public class MyItemDecoration extends RecyclerView.ItemDecoration {
    /**
     *
     * @param outRect 边界
     * @param view recyclerView ItemView
     * @param parent recyclerView
     * @param state recycler 内部数据管理
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, 2);
    }

}
