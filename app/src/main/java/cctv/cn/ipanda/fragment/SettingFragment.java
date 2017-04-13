package cctv.cn.ipanda.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.utils.CleanMessageUtil;

/**
 * Created by lenovo on 2017/4/12.
 */

public class SettingFragment extends BaseFragment implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{

    private CheckBox isPlay;
    private CheckBox isPush;

    public static final String PACKAGE = "cn.cntv.app.ipanda";
    private TextView cleanSize;
    private RelativeLayout about;
    private RelativeLayout help;
    private RelativeLayout shengji;
    private RelativeLayout good;
    private RelativeLayout clean;

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
        about = (RelativeLayout) view.findViewById(R.id.panda_setting_about);
        help = (RelativeLayout) view.findViewById(R.id.panda_setting_help);
        shengji = (RelativeLayout) view.findViewById(R.id.panda_setting_shengji);
        good = (RelativeLayout) view.findViewById(R.id.panda_setting_haoping);
        clean = (RelativeLayout) view.findViewById(R.id.clean);

    }

    @Override
    protected void initListener() {
        clean.setOnClickListener(this);
        help.setOnClickListener(this);
        shengji.setOnClickListener(this);
        good.setOnClickListener(this);
        about.setOnClickListener(this);
        isPlay.setOnCheckedChangeListener(this);
        isPush.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.personal_delete_img:
              onClickCleanCache();
                break;
            case R.id.clean:
                openApplicationMarket(PACKAGE);
                break;
            case R.id.panda_setting_shengji:
                Toast.makeText(getActivity(), "已经是最新版本了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.panda_setting_help:
                Intent intent = new Intent(getActivity(),PandaAboutUsFragment.class);
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
    private void onClickCleanCache() {
        getConfirmDialog(getActivity(), "是否清空缓存?", new DialogInterface.OnClickListener
                () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CleanMessageUtil.clearAllCache(getActivity());
                cleanSize.setText("0.00MB");
            }
        }).show();
    }
    public static AlertDialog.Builder getConfirmDialog(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("确定", onClickListener);
        builder.setNegativeButton("取消", null);
        return builder;
    }
    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }
}
