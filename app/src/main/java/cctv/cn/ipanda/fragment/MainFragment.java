package cctv.cn.ipanda.fragment;

import android.view.View;

import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.base.BaseFragment;

/**
 * Created by 张志远 on 2017/4/13.
 */

public abstract class MainFragment extends BaseFragment {

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            ((MainActivity)getActivity()).radioGroup.setVisibility(View.VISIBLE);
        }
    }
}
