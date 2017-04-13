package cctv.cn.ipanda.fragment;

import android.support.design.widget.TabLayout;
import android.view.View;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;

/**
 * Created by 张志远 on 2017/4/13.
 */

public class PandaRegisterFragment extends BaseFragment {

    private TabLayout mTab;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        mTab = (TabLayout) view.findViewById(R.id.mTab);

        mTab.addTab(mTab.newTab().setText("手机注册"));

        mTab.addTab(mTab.newTab().setText("邮箱注册"));
    }

    @Override
    protected void initListener() {
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals("手机注册")){

                }else{

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
}
