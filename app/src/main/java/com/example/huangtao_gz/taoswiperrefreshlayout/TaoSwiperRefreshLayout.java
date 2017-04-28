package com.example.huangtao_gz.taoswiperrefreshlayout;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangtao-gz on 2017/03/14.
 */

public class TaoSwiperRefreshLayout extends SwipeRefreshLayout {
    /**
     * Simple constructor to use when creating a SwipeRefreshLayout from code.
     *
     * @param context
     */
    public TaoSwiperRefreshLayout(Context context) {
        super(context);
    }

    /**
     * Constructor that is called when inflating SwipeRefreshLayout from XML.
     *
     * @param context
     * @param attrs
     */
    public TaoSwiperRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 从上面的 Child 分析可知，滑动开始的调用startNestedScroll()，Parent 收到onStartNestedScroll()回调，决定是否需要配合 Child 一起进行处理滑动，如果需要配合，还会回调onNestedScrollAccepted()。
     * @param target
     * @param dx
     * @param dy
     * @param consumed
     */
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
    }


}
