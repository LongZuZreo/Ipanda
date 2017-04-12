package cctv.cn.ipanda.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseActivity;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.fragment.PanadaHomeFragment;
import cctv.cn.ipanda.fragment.PandaCultureFragment;
import cctv.cn.ipanda.fragment.PandaLiveFragment;
import cctv.cn.ipanda.fragment.PandaObserverFragment;
import cctv.cn.ipanda.fragment.PandaLiveChinaFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private BaseFragment currentFragment;
    private BaseFragment eyeFragment;
    private BaseFragment cultureFragment;
    private BaseFragment liveFragment;
    private BaseFragment liveChinaFragment;
    private BaseFragment homeFragment;
    public static final int HOME_TITLE = 1;
    public static final int OTHER_TITLE = 2;
    private ImageView titlePandaSign;
    private ImageView titleBackImage;
    private TextView tabTitle;
    private ImageView hudongImage;
    private ImageView personSign;
    private RadioButton homeRadio;
    private RadioButton eyeRadio;
    private RadioButton cultureRadio;
    private RadioButton liveRadio;
    private RadioButton liveChinaRadio;

    private void changeFragment(BaseFragment fragment, Bundle bundle, boolean isBack) {

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        if (bundle != null)
            fragment.setParams(bundle);

        transaction.hide(currentFragment);

        if (!fragment.isAdded())

            transaction.add(R.id.mFram, fragment);

        transaction.show(fragment);

        transaction.commit();

        currentFragment = fragment;
    }

    @Override
    protected int getLayoutId() {

        return R.layout.activity_main;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {

        titlePandaSign = (ImageView) findViewById(R.id.title_panda_sign);
        titleBackImage = (ImageView) findViewById(R.id.title_back_img);
        tabTitle = (TextView) findViewById(R.id.tab_title);
        hudongImage = (ImageView) findViewById(R.id.hudong_image);
        personSign = (ImageView) findViewById(R.id.person_sign);
    }

    @Override
    protected void initData() {

        homeFragment = new PanadaHomeFragment();

        eyeFragment = new PandaObserverFragment();

        cultureFragment = new PandaCultureFragment();

        liveFragment = new PandaLiveFragment();

        liveChinaFragment = new PandaLiveChinaFragment();

        currentFragment = homeFragment;

        changeFragment(homeFragment, null, false);

        homeRadio = (RadioButton) findViewById(R.id.home_radio);

        eyeRadio = (RadioButton) findViewById(R.id.eye_radio);

        cultureRadio = (RadioButton) findViewById(R.id.culture_radio);

        liveRadio = (RadioButton) findViewById(R.id.live_radio);

        liveChinaRadio = (RadioButton) findViewById(R.id.live_china_radio);

    }

    @Override
    protected void initListener() {
        homeRadio.setOnClickListener(this);
        eyeRadio.setOnClickListener(this);
        cultureRadio.setOnClickListener(this);
        liveRadio.setOnClickListener(this);
        liveChinaRadio.setOnClickListener(this);
        hudongImage.setOnClickListener(this);
        personSign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_radio:
                changeFragment(homeFragment, null, false);
                changTitle(HOME_TITLE, "首页");
                break;
            case R.id.eye_radio:
                changeFragment(eyeFragment, null, false);
                changTitle(OTHER_TITLE, "熊猫观察");
                break;
            case R.id.culture_radio:
                changeFragment(cultureFragment, null, false);
                changTitle(OTHER_TITLE, "熊猫文化");
                break;
            case R.id.live_radio:
                changeFragment(liveFragment, null, false);
                changTitle(OTHER_TITLE, "熊猫直播");
                break;
            case R.id.live_china_radio:
                changeFragment(liveChinaFragment, null, false);
                changTitle(OTHER_TITLE, "直播中国");
                break;
            case R.id.person_sign:
                Intent intent=new Intent(this,PandaPersonActivity.class);

                startActivity(intent);
                break;
            case R.id.hudong_image:
                Intent intent1=new Intent(this,HuDongActivity.class);

                startActivity(intent1);
                break;
        }
    }

    public void changTitle(int titleType, String title) {
        switch (titleType) {
            case HOME_TITLE:
                titlePandaSign.setVisibility(View.VISIBLE);
                hudongImage.setVisibility(View.VISIBLE);
                personSign.setVisibility(View.VISIBLE);
                tabTitle.setVisibility(View.GONE);
                break;
            case OTHER_TITLE:
                tabTitle.setText(title);
                tabTitle.setVisibility(View.VISIBLE);
                hudongImage.setVisibility(View.GONE);
                titlePandaSign.setVisibility(View.GONE);
                break;
        }
    }
}
