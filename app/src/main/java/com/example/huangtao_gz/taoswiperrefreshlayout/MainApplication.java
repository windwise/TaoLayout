package com.example.huangtao_gz.taoswiperrefreshlayout;

import android.app.Application;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by huangtao on 2017/03/27.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {

            }
        });
    }
}
