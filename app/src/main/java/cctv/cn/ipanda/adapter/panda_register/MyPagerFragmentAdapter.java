package cctv.cn.ipanda.adapter.panda_register;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.io.StringBufferInputStream;
import java.util.List;

import cctv.cn.ipanda.base.BaseFragment;

/**
 * Created by 张志远 on 2017/4/13.
 */

public class MyPagerFragmentAdapter extends FragmentPagerAdapter{
    private List<BaseFragment> fragments;

    private List<String> titles;

    public MyPagerFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles) {
        super(fm);
        this.fragments=fragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
