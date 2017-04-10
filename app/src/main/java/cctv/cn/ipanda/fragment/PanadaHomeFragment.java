package cctv.cn.ipanda.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.RecycleViewAdapter;
import cctv.cn.ipanda.adapter.banner.MyBannerAdapter;
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
    private ViewPager mViewPager;

    private List<ImageView> imageList;
    private MyBannerAdapter bannerAdapter;
    private List<PanadaHomeBean.DataBean.BigImgBean> bigImgBeenList;

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
        PanadaHomeBean.DataBean.PandaeyeBean pandaeyeBean = bean.getData().getPandaeye();
        PanadaHomeBean.DataBean.PandaliveBean pandaliveBean = bean.getData().getPandalive();
        PanadaHomeBean.DataBean.WallliveBean wallliveBean = bean.getData().getWalllive();
        PanadaHomeBean.DataBean.ChinaliveBean chinaliveBean = bean.getData().getChinalive();
        PanadaHomeBean.DataBean.InteractiveBean interactiveBean = bean.getData().getInteractive();
        PanadaHomeBean.DataBean.CctvBean cctvBean = bean.getData().getCctv();
        //PanadaHomeBean.DataBean.ListBeanXXX listBeanXXX = bean.getData().getList();


        list.add(area);
        list.add(pandaeyeBean);
        list.add(pandaliveBean);
        list.add(wallliveBean);
        list.add(chinaliveBean);
        list.add(interactiveBean);
        list.add(cctvBean);
        adapter.notifyDataSetChanged();
    }
    public void getImageView(PanadaHomeBean.DataBean bigImgBean){
        List<PanadaHomeBean.DataBean.BigImgBean>  beanList= bigImgBean.getBigImg();
        for(int i=0;i<beanList.size();i++){
            PanadaHomeBean.DataBean.BigImgBean bigImgBean1 = beanList.get(i);
            ImageView imageView = new ImageView(getActivity());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(getActivity()).load(bigImgBean1.getImage()).into(imageView);
            imageList.add(imageView);
        }
        bannerAdapter.notifyDataSetChanged();
        mViewPager.setCurrentItem(1000);
    }

}
