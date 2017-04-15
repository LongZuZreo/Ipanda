package cctv.cn.ipanda.fragment;

import android.view.View;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.base.BaseFragment;

/**
 * Created by 张志远 on 2017/4/13.
 */

public class PandaRegisterPhoneFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_phone_register;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void show() {
        MainActivity.currentFragment=this;
    }

    @Override
    protected void hide() {

    }
}
