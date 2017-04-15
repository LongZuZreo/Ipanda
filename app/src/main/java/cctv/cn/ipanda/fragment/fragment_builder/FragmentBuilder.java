package cctv.cn.ipanda.fragment.fragment_builder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;

/**
 * Created by 张志远 on 2017/4/14.
 */

public class FragmentBuilder {



    private static FragmentBuilder fragmentBuilder;
    public FragmentManager fragmentManager;
    private BaseFragment fragment;

    private FragmentBuilder(){
        init();
    }
    public static synchronized FragmentBuilder getInstance(){

        if (fragmentBuilder==null)
            fragmentBuilder=new FragmentBuilder();

        return fragmentBuilder;
    }
    private void init(){
        fragmentManager = App.context.getSupportFragmentManager();
    }
    public FragmentBuilder startFragment(Class<? extends BaseFragment> fragmentClass){

        String fragmentName = fragmentClass.getSimpleName();

        fragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentName);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment ==null){
            try {
                fragment =fragmentClass.newInstance();
                transaction.add(R.id.mFram,fragment,fragmentName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        if (App.lastFragment!=null){
            transaction.hide(App.lastFragment);
        }
        transaction.show(fragment);

        transaction.addToBackStack(fragmentName);

        App.lastFragment=fragment;

        transaction.commit();
        return this;
    }

    public FragmentBuilder setParams(Bundle bundle){
        fragment.setParams(bundle);
        return this;
    }

    public BaseFragment build(){
        return fragment;
    }


}
