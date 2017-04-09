package cctv.cn.ipanda.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.RecycleViewAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.HomeContract;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;
import cctv.cn.ipanda.presenter.panada_home.HomePresentImp;

/**
 * Created by ASUS on 2017/4/7.
 */

public class PanadaHomeFragment extends BaseFragment implements HomeContract.View{

    private RecyclerView mRecycle;
    private List<Object> list;
    private HomePresentImp presentImp;
    private RecycleViewAdapter adapter;
    private PanadaHomeBean panadaHomeBean;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panada_home;
    }

    @Override
    protected void loadData() {
        presentImp.getAllList(Urls.HOME_URL);
    }

    @Override
    protected void initData() {


    }


    @Override
    protected void initView(View view) {
        mRecycle = (RecyclerView) view.findViewById(R.id.mRecycleView);
        presentImp = new HomePresentImp(this);
        list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecycle.setLayoutManager(manager);
        //实例化适配
        adapter = new RecycleViewAdapter(getActivity(),list);
        mRecycle.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void dismiss() {

    }

    @Override
    public void loadError() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void toPersonCenter() {

    }

    @Override
    public void toVideoPlay() {

    }

    @Override
    public void changeTitleBar() {

    }

    @Override
    public void loadDetail(PanadaHomeBean bean) {
        this.panadaHomeBean = bean;
        PanadaHomeBean.DataBean.AreaBean area = bean.getData().getArea();
        list.add(area);
        adapter.notifyDataSetChanged();
    }

}
