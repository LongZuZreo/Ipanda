package cctv.cn.ipanda.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.IOException;

import cctv.cn.ipanda.common.App;

/**
 * Created by 张志远 on 2017/4/6.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());


        checkPermission();
        initView();
        initData();
        initListener();
        loadData();
    }

    private void checkPermission(){
      /*  if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }*/
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this,"授权成功",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this,"拒绝授权",Toast.LENGTH_LONG).show();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void loadData();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

}
