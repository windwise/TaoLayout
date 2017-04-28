package com.example.huangtao_gz.taoswiperrefreshlayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    private CoordinatorLayout container;
    private SwipeRefreshLayout swipeRefreshLayout;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    swipeRefreshLayout.setRefreshing(false);
                        Snackbar.make(container,"刷新成功", Snackbar.LENGTH_LONG).setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                    return true;
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincontent, R.layout.testcollapse, R.layout.customtoolbar);
//        setContentView(R.layout.maincontent, R.layout.collapselayout);
        container = (CoordinatorLayout) findViewById(R.id.CoordinatorLayout);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            strings.add(i + "");
        }

        MyAdapter adapter = new MyAdapter(strings);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setNestedScrollingEnabled(true);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        handler.sendEmptyMessageDelayed(1, 3000);
    }
}
