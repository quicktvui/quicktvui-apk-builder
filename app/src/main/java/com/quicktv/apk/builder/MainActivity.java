package com.quicktv.apk.builder;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import eskit.sdk.core.EsData;
import eskit.sdk.core.EsManager;

/**
 * <br>
 *
 * <br>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.sExecutor.execute(WORK_START_APP);
    }

    private final Runnable WORK_START_APP = () -> {

        // 第一步 设置启动参数
        EsData data = new EsData();
        data.setAppPackage(BuildConfig.LOAD_APP_NAME);

        // 第二步 启动
        EsManager.get().start(data);
    };

    @Override
    protected void onStop() {
        super.onStop();
        if (!isFinishing()) {
            finish();
        }
    }
}
