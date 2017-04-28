package com.example.huangtao_gz.taoswiperrefreshlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by huangtao-gz on 2017/03/14.
 */

public class MyAdapter extends RecyclerView.Adapter {

    private List<String> strings;

    MyAdapter(List<String> strings) {
        this.strings = strings;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyHolder){
            ((MyHolder) holder).textView.setText(strings.get(position));
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return strings.size();
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;

        MyHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
