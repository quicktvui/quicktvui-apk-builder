package com.quicktv.apk.builder;

import androidx.multidex.MultiDexApplication;

import com.extscreen.runtime.EsKitInitHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import eskit.sdk.core.InitConfig;

/**
 * <br>
 *
 * <br>
 */
public class App extends MultiDexApplication {

    public static ExecutorService sExecutor = Executors.newSingleThreadExecutor();

    @Override
    public void onCreate() {
        super.onCreate();
        sExecutor.execute(WORK_INIT_SDK);
    }

    private final Runnable WORK_INIT_SDK = new Runnable() {
        @Override
        public void run() {
            EsKitInitHelper.init(App.this, InitConfig.getDefault()
                    .setRepository(BuildConfig.LOAD_REPOSITORY));
        }
    };

}
