package com.example.huangtao_gz.taoswiperrefreshlayout;

import android.graphics.PixelFormat;
import android.os.Bundle;

import com.tencent.smtt.sdk.WebView;

public class TBSActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbs);
        WebView webView = (WebView) findViewById(R.id.forum_context);

    }
}
