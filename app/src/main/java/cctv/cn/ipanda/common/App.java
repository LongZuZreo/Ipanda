package cctv.cn.ipanda.common;

import android.app.Activity;
import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import cctv.cn.ipanda.base.BaseActivity;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.utils.ShareControllerUtil;
import cn.jpush.android.api.JPushInterface;
import io.vov.vitamio.Vitamio;

/**
 * Created by 张志远 on 2017/4/6.
 */

public class App extends Application {

    public static BaseActivity context;
    public static BaseFragment lastFragment;
    @Override
    public void onCreate() {
        super.onCreate();
        Vitamio.isInitialized(this);
        Config.DEBUG = true;
        UMShareAPI.get(this);
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);
    }
    {
        PlatformConfig.setWeixin("wxaca4b7e727c64183", "373097dff7fa64ae9ec93073a93aa350");
    }
}
