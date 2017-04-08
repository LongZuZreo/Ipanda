package cctv.cn.ipanda.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 张志远 on 2017/4/6.
 */

public abstract class BaseFragment extends Fragment {


    protected Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
        initListener();
        loadData();
    }
    public void setParams(Bundle bundle){
        this.bundle=bundle;
    }

    protected abstract int getLayoutId();

    protected abstract void loadData();

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract void initListener();
}
