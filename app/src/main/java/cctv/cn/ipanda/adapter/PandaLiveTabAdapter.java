package cctv.cn.ipanda.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cctv.cn.ipanda.base.BaseFragment;

/**
 * Created by lenovo on 2017/4/8.
 */

public class PandaLiveTabAdapter extends FragmentPagerAdapter {

    private List<String> datas;
    private List<BaseFragment> fragments;

    public PandaLiveTabAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> datas) {
        super(fm);
        this.fragments = fragments;
        this.datas = datas;
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
        return datas.get(position);
    }
}
