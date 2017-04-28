package com.example.huangtao_gz.taoswiperrefreshlayout;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.DefaultLayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by huangtao-gz on 2017/03/28.
 */

public class VLayoutDemoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vlayoutdemo_activity);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(10, 10, 10, 10);
            }
        });

        final List<String> strings = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            strings.add(i + "");
        }


        final List<String> gridStrings = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            gridStrings.add(i + "grid");
        }

        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager,false);
        delegateAdapter.addAdapter(new DelegateAdapter.Adapter<GridViewHolder>() {
            @Override
            public LayoutHelper onCreateLayoutHelper() {
                final GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
                gridLayoutHelper.setItemCount(25);
                return gridLayoutHelper ;
            }

            @Override
            public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new GridViewHolder(View.inflate(VLayoutDemoActivity.this,R.layout.item_grid,null));
            }

            @Override
            public void onBindViewHolder(GridViewHolder holder, int position) {
                holder.textView.setText(gridStrings.get(position));
            }

            @Override
            public int getItemCount() {
                return gridStrings.size();
            }
        });

        delegateAdapter.addAdapter(new DelegateAdapter.Adapter<ScrollFixViewHolder>() {
            @Override
            public LayoutHelper onCreateLayoutHelper() {
                final ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(FixLayoutHelper.TOP_RIGHT, 100, 100);
                return scrollFixLayoutHelper;
            }

            @Override
            public ScrollFixViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ScrollFixViewHolder(View.inflate(VLayoutDemoActivity.this,R.layout.item_recyclerview,null));
            }

            @Override
            public void onBindViewHolder(ScrollFixViewHolder holder, int position) {
                holder.textView.setText(strings.get(position));
            }

            @Override
            public int getItemCount() {
                return strings.size();
            }
        });

        recyclerView.setAdapter(delegateAdapter);
    }

    static class ScrollFixViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ScrollFixViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textview);
        }
    }

    static class GridViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public GridViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.gride_text);
        }
    }
}
