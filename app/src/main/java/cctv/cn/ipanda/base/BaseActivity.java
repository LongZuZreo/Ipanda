package cctv.cn.ipanda.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

/**
 * Created by 张志远 on 2017/4/6.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        initListener();
        loadData();
    }

    protected abstract int getLayoutId();

    protected abstract void loadData();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

}
