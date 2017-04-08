package cctv.cn.ipanda.fragment;

import android.view.View;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.model.panda_culture.PandaCultureImp;
import cctv.cn.ipanda.presenter.panda_culture.PandaCulture;

/**
 * Created by hp1 on 2017-04-07.
 */

public class PandaCultureFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_culture;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        PandaCulture pandaCulture = new PandaCulture();

    }

    @Override
    protected void initListener() {

    }
}
