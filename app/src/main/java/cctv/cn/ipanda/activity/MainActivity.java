package cctv.cn.ipanda.activity;

import android.os.Process;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseActivity;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.fragment.InteractionFragment;
import cctv.cn.ipanda.fragment.PandaHomeFragment;
import cctv.cn.ipanda.fragment.PandaCultureFragment;
import cctv.cn.ipanda.fragment.PandaLiveFragment;
import cctv.cn.ipanda.fragment.PandaObserverFragment;
import cctv.cn.ipanda.fragment.PandaLiveChinaFragment;
import cctv.cn.ipanda.fragment.PandaPersonFragment;
import cctv.cn.ipanda.fragment.PandaRegisterFragment;
import cctv.cn.ipanda.fragment.fragment_builder.FragmentBuilder;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    public static BaseFragment currentFragment;
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
    public FragmentManager supportFragmentManager;



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

        transaction.commit();
    }

    @Override
    protected int getLayoutId() {
        App.context = this;
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

        homeRadio = (RadioButton) findViewById(R.id.home_radio);

        eyeRadio = (RadioButton) findViewById(R.id.eye_radio);

        cultureRadio = (RadioButton) findViewById(R.id.culture_radio);

        liveRadio = (RadioButton) findViewById(R.id.live_radio);

        liveChinaRadio = (RadioButton) findViewById(R.id.live_china_radio);
        FragmentBuilder.getInstance().startFragment(PandaHomeFragment.class);
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
                FragmentBuilder.getInstance().startFragment(PandaHomeFragment.class);
                changTitle(HOME_TITLE, "首页");
                break;
            case R.id.eye_radio:
                FragmentBuilder.getInstance().startFragment(PandaObserverFragment.class);
                changTitle(OTHER_TITLE, "熊猫观察");
                break;
            case R.id.culture_radio:
                FragmentBuilder.getInstance().startFragment(PandaCultureFragment.class);
                changTitle(OTHER_TITLE, "熊猫文化");
                break;
            case R.id.live_radio:
                FragmentBuilder.getInstance().startFragment(PandaLiveFragment.class);
                changTitle(OTHER_TITLE, "熊猫直播");
                break;
            case R.id.live_china_radio:
                FragmentBuilder.getInstance().startFragment(PandaLiveChinaFragment.class);
                changTitle(OTHER_TITLE, "直播中国");
                break;
            case R.id.person_sign:
                FragmentBuilder.getInstance().startFragment(PandaPersonFragment.class);
                changTitle(PERSON_OR_INTERTACT,"个人中心");
                break;
            case R.id.hudong_image:
                FragmentBuilder.getInstance().startFragment(InteractionFragment.class);
                changTitle(PERSON_OR_INTERTACT,"互动·集合");
                break;
            case R.id.edit_text:
                if (editText.getText().equals("注册")){
                    FragmentBuilder.getInstance().startFragment(PandaRegisterFragment.class);
                    changTitle(PERSON_OR_INTERTACT,"注册");
                }else{

                }
                break;
            case R.id.title_back_img:
                onBackPressed();
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
                titleBackImage.setVisibility(View.GONE);
                break;
            case OTHER_TITLE:
                tabTitle.setText(title);
                tabTitle.setVisibility(View.VISIBLE);
                hudongImage.setVisibility(View.GONE);
                titlePandaSign.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                personSign.setVisibility(View.VISIBLE);
                titleBackImage.setVisibility(View.GONE);
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
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(Process.myPid());
        System.exit(0);
    }

    @Override
    public void onBackPressed() {

        String name = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();

        if ("PandaHomeFragment".equals(name) || "PandaCultureFragment".equals(name)|| "PandaLiveFragment".equals(name) || "PandaObserverFragment".equals(name)||"PandaLiveChinaFragment".equals(name) ){

            finish();

        }else {
            if(getSupportFragmentManager().getFragments().size()>1) {
                getSupportFragmentManager().popBackStackImmediate();
               String fragmentName = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount()-1).getName();
                App.lastFragment= (BaseFragment) getSupportFragmentManager().findFragmentByTag( fragmentName);
                if (fragmentName.equals("PandaHomeFragment")){
                    changTitle(HOME_TITLE, "首页");
                    radioGroup.setVisibility(View.VISIBLE);
                }else if(fragmentName.equals("PandaCultureFragment")){
                    changTitle(OTHER_TITLE, "熊猫文化");
                    radioGroup.setVisibility(View.VISIBLE);
                }else if(fragmentName.equals("PandaObserverFragment")){
                  changTitle(OTHER_TITLE,"熊猫观察");
                    radioGroup.setVisibility(View.VISIBLE);
                }else if(fragmentName.equals("PandaLiveFragment")) {
                    changTitle(OTHER_TITLE, "熊猫直播");
                    radioGroup.setVisibility(View.VISIBLE);
                }else if(fragmentName.equals("PandaLiveChinaFragment")){
                    changTitle(OTHER_TITLE,"直播中国");
                    radioGroup.setVisibility(View.VISIBLE);
                }else if(fragmentName.equals("PandaPersonFragment")){
                    changTitle(PERSON_OR_INTERTACT,"个人中心");
                }else if (fragmentName.equals("InteractionFragment")){
                    changTitle(PERSON_OR_INTERTACT,"互动·集合");
                }else if (fragmentName.equals("PandaRegisterFragment")){
                    changTitle(PERSON_OR_INTERTACT,"注册");
                }
            }
        }
    }
}
