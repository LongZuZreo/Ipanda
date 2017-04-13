package cctv.cn.ipanda.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.utils.CleanMessageUtil;

/**
 * Created by lenovo on 2017/4/12.
 */

public class SettingFragment extends BaseFragment implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{

    private Button delete;
    private CheckBox isPlay;
    private CheckBox isPush;

    public static final String PACKAGE = "cn.cntv.app.ipanda";
    private TextView cleanSize;

    @Override
    protected int getLayoutId() {
        return R.layout.panda_person_setting;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData()   {
        try {
            cleanSize.setText(CleanMessageUtil.getTotalCacheSize(getActivity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView(View view) {
        isPlay = (CheckBox) view.findViewById(R.id.isPlay);
        isPush = (CheckBox) view.findViewById(R.id.isPush);


    }

    @Override
    protected void initListener() {
        delete.setOnClickListener(this);
        isPlay.setOnCheckedChangeListener(this);
        isPush.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.personal_delete_img:
                CleanMessageUtil.clearAllCache(getActivity());
                cleanSize.setText("0KB");
                break;
            case R.id.isGood:
                openApplicationMarket(PACKAGE);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.isPlay:
                break;
            case R.id.isPush:
                break;
        }
    }
    private void openApplicationMarket(String packageName) {
        try {
            String str = "market://details?id=" + packageName;
            Intent localIntent = new Intent(Intent.ACTION_VIEW);
            localIntent.setData(Uri.parse(str));
            startActivity(localIntent);
        } catch (Exception e) {
            // 打开应用商店失败 可能是没有手机没有安装应用市场
            e.printStackTrace();
            Toast.makeText(getActivity(), "打开应用商店失败", Toast.LENGTH_SHORT).show();
            // 调用系统浏览器进入商城
            String url = "http://app.mi.com/detail/163525?ref=search";
            openLinkBySystem(url);
        }
    }
    private void openLinkBySystem(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
