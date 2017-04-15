package cctv.cn.ipanda.common;
import android.app.Application;
import cctv.cn.ipanda.base.BaseActivity;
import cctv.cn.ipanda.base.BaseFragment;
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
    }
}
