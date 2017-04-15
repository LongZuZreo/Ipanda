package cctv.cn.ipanda.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.adapter.panda_register.MyPagerFragmentAdapter;
import cctv.cn.ipanda.base.BaseFragment;

/**
 * Created by 张志远 on 2017/4/13.
 */

public class PandaRegisterFragment extends BaseFragment {

    private TabLayout mTab;

    private FragmentManager fragmentManager;

    private BaseFragment currentFragment;
    private PandaRegisterPhoneFragment pandaRegisterPhoneFragment;
    private PandaRegisterEmailFragment pandaRegisterEmailFragment;

    private List<BaseFragment> fragments;
    private ViewPager viewPager;
    private List<String> titles;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {

        titles=new ArrayList<>();

        titles.add("邮箱注册");

        titles.add("手机注册");

        fragments=new ArrayList<>();

        fragments.add(pandaRegisterEmailFragment);

        fragments.add(pandaRegisterPhoneFragment);

        MyPagerFragmentAdapter myPagerFragmentAdapter=new MyPagerFragmentAdapter(getFragmentManager(),fragments,titles);

        viewPager.setAdapter(myPagerFragmentAdapter);

    }

    @Override
    protected void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.mTab);

        viewPager = (ViewPager) view.findViewById(R.id.mViewPager);

        pandaRegisterPhoneFragment = new PandaRegisterPhoneFragment();

        pandaRegisterEmailFragment = new PandaRegisterEmailFragment();

        mTab.setupWithViewPager(viewPager);

    }

    @Override
    protected void initListener() {
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals("手机注册")){

                    viewPager.setCurrentItem(0);

                }else{
                    viewPager.setCurrentItem(1);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void show() {
    }

    @Override
    protected void hide() {

    }
}
