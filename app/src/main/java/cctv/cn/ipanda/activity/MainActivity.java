package cctv.cn.ipanda.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseActivity;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.fragment.PanadaHomeFragment;
import cctv.cn.ipanda.fragment.PandaCultureFragment;
import cctv.cn.ipanda.fragment.PandaLiveFragment;
import cctv.cn.ipanda.fragment.PandaObserverFragment;
import cctv.cn.ipanda.fragment.PandaLiveChinaFragment;
import cctv.cn.ipanda.fragment.PandaPersonFragment;
import cctv.cn.ipanda.fragment.PandaRegisterFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private BaseFragment currentFragment;
    private BaseFragment eyeFragment;
    private BaseFragment cultureFragment;
    private BaseFragment liveFragment;
    private BaseFragment liveChinaFragment;
    private BaseFragment homeFragment;
    public static final int HOME_TITLE = 1;
    public static final int OTHER_TITLE = 2;
    public static final int PERSON_OR_INTERTACT=3;
    public static final int EDIT_TITLE=4;
    public static final int RIGHT_TYPE=5;
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
    private TextView editText;
    public RadioGroup radioGroup;
    public PandaPersonFragment pandaPersonFragment;
   FragmentManager supportFragmentManager;
    private PandaRegisterFragment registerFragment;


    public void changeFragment(BaseFragment fragment, Bundle bundle, boolean isBack) {

        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        if (bundle != null)
            fragment.setParams(bundle);

        transaction.hide(currentFragment);
        if (isBack) {
            transaction.addToBackStack(null);
        }else{
            currentFragment = fragment;
        }
        if (!fragment.isAdded())

            transaction.add(R.id.mFram, fragment);

        transaction.show(fragment);

        if (isBack)
            transaction.addToBackStack(null);

        transaction.commit();
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
        editText = (TextView) findViewById(R.id.edit_text);
        radioGroup = (RadioGroup) findViewById(R.id.fragment_radio_group);
    }

    @Override
    protected void initData() {

        homeFragment = new PanadaHomeFragment();

        eyeFragment = new PandaObserverFragment();

        cultureFragment = new PandaCultureFragment();

        liveFragment = new PandaLiveFragment();

        liveChinaFragment = new PandaLiveChinaFragment();

        pandaPersonFragment = new PandaPersonFragment();

        registerFragment = new PandaRegisterFragment();

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
        editText.setOnClickListener(this);
        titleBackImage.setOnClickListener(this);
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
                changeFragment(pandaPersonFragment,null,true);
                changTitle(PERSON_OR_INTERTACT,"个人中心");
                break;
            case R.id.hudong_image:
                changeFragment(pandaPersonFragment,null,true);
                changTitle(PERSON_OR_INTERTACT,"互动·集合");
                break;
            case R.id.edit_text:
                if (editText.equals("注册")){
                    changeFragment(registerFragment,null,true);
                    changTitle(PERSON_OR_INTERTACT,"注册");
                }else{

                }
                break;
            case R.id.title_back_img:
                supportFragmentManager.popBackStack();
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
                editText.setVisibility(View.GONE);
                break;
            case OTHER_TITLE:
                tabTitle.setText(title);
                tabTitle.setVisibility(View.VISIBLE);
                hudongImage.setVisibility(View.GONE);
                titlePandaSign.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                break;
            case PERSON_OR_INTERTACT:
                tabTitle.setText(title);
                titlePandaSign.setVisibility(View.GONE);
                hudongImage.setVisibility(View.GONE);
                titleBackImage.setVisibility(View.VISIBLE);
                tabTitle.setVisibility(View.VISIBLE);
                personSign.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
                break;
            case EDIT_TITLE:
                tabTitle.setText(title);
                titlePandaSign.setVisibility(View.GONE);
                hudongImage.setVisibility(View.GONE);
                titleBackImage.setVisibility(View.VISIBLE);
                tabTitle.setVisibility(View.VISIBLE);
                personSign.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.GONE);
                break;
            case RIGHT_TYPE:
                if (title.equals("登陆")) {
                    tabTitle.setText(title);
                    titlePandaSign.setVisibility(View.GONE);
                    hudongImage.setVisibility(View.GONE);
                    titleBackImage.setVisibility(View.VISIBLE);
                    tabTitle.setVisibility(View.VISIBLE);
                    personSign.setVisibility(View.GONE);
                    editText.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.GONE);
                    editText.setText("注册");
                }else{
                    tabTitle.setText(title);
                    titlePandaSign.setVisibility(View.GONE);
                    hudongImage.setVisibility(View.GONE);
                    titleBackImage.setVisibility(View.VISIBLE);
                    tabTitle.setVisibility(View.VISIBLE);
                    personSign.setVisibility(View.GONE);
                    editText.setVisibility(View.GONE);
                    radioGroup.setVisibility(View.GONE);
                }
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
