package cctv.cn.ipanda.common;

import android.app.Activity;
import android.app.Application;

import io.vov.vitamio.Vitamio;

/**
 * Created by 张志远 on 2017/4/6.
 */

public class App extends Application {

    public static Activity context;
    @Override
    public void onCreate() {
        super.onCreate();
        Vitamio.isInitialized(this);
    }
}
