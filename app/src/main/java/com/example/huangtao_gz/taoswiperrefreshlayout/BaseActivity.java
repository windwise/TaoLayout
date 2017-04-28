package com.example.huangtao_gz.taoswiperrefreshlayout;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by huangtao-gz on 2017/03/17.
 */

public class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CoordinatorLayout contentLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView();
    }

    /**
     * 初始化contentview
     */
    private void initContentView() {
        ViewGroup content = (ViewGroup) findViewById(android.R.id.content);
        if (null != content) {
            content.removeAllViews();
            contentLayout = (CoordinatorLayout) LayoutInflater.from(this).inflate(R.layout.basecontainer, null);
            content.addView(contentLayout);
        } else {
            throw new RuntimeException("初始化布局失败，ViewGroup为空");
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        this.setContentView(layoutResID, true, -1, -1);
    }

    public void setContentView(@LayoutRes int layoutResID, @LayoutRes int collapseViewResID) {
        this.setContentView(layoutResID, true, collapseViewResID, -1);
    }

    public void setContentView(@LayoutRes int layoutResID, @LayoutRes int collapseViewResID, @LayoutRes int customToolbarLayoutResID) {
        this.setContentView(layoutResID, true, collapseViewResID, customToolbarLayoutResID);
    }

    public void setContentView(@LayoutRes int layoutResID, boolean isShowToolBar, @LayoutRes int collapseViewResID, @LayoutRes int customToolbarLayoutResID) {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbarlayout);
        if (-1 != collapseViewResID) {
            View.inflate(this, collapseViewResID, collapsingToolbarLayout);
        }
        if (isShowToolBar) {//如果需要显示toolbar
            if (-1 != customToolbarLayoutResID)
                View.inflate(this, customToolbarLayoutResID, collapsingToolbarLayout);
            initToolbar(customToolbarLayoutResID);
        }
        LayoutInflater.from(this).inflate(layoutResID, contentLayout, true);
    }


    private Toolbar initToolbar(@LayoutRes int customToolbarLayoutResID) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        mToolbar = toolbar;
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            if (null != mToolbar) {
                if (-1 == customToolbarLayoutResID) {
                    enableDefaultNavigationIcon();
                    setDefaultNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                } else {
                    mToolbar.removeAllViewsInLayout();
                    LayoutInflater.from(this).inflate(customToolbarLayoutResID, mToolbar, true);
                }
            }
        }
        return mToolbar;
    }

    /**
     * 显示默认的NavigationIcon
     */
    private void enableDefaultNavigationIcon() {
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setHomeButtonEnabled(true);//确保icon图标能够作为一个操作项被点击
            actionBar.setDisplayShowHomeEnabled(true);//使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，否则，显示应用程序图标
//            actionBar.setDisplayHomeAsUpEnabled(true);//在ActionBar图标（如果没有设置图标icon，文字标题也可以代替）的左侧添加了一个向左的箭头
        }
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
    }

    /**
     * 设置默认的NavigationIcon点击事件
     *
     * @param clickListener
     */
    private void setDefaultNavigationOnClickListener(View.OnClickListener clickListener) {
        setNavigationOnClickListener(clickListener);
    }

    public void setNavigationOnClickListener(View.OnClickListener listener) {
        if (null == mToolbar)
            throw new NullPointerException("toolbar can not be null");
        mToolbar.setNavigationOnClickListener(listener);
    }

}
