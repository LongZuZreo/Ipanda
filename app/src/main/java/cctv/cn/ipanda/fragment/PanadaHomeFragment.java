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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.RecycleViewAdapter;
import cctv.cn.ipanda.adapter.banner.MyBannerAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.HomeContract;
import cctv.cn.ipanda.model.panada_home.CctvAgainBean;
import cctv.cn.ipanda.model.panada_home.PanadaChinaListBean;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;
import cctv.cn.ipanda.presenter.panada_home.HomePresentImp;

/**
 * Created by ASUS on 2017/4/7.
 */

public class PanadaHomeFragment extends BaseFragment implements HomeContract.View{


    private List<Object> list;
    private HomePresentImp presentImp;
    private RecycleViewAdapter adapter;
    private PanadaHomeBean panadaHomeBean;
    private ViewPager mViewPager;
    private List<ImageView> imageList;
    private MyBannerAdapter bannerAdapter;
    private List<PanadaHomeBean.DataBean> bigImgBeenList;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private String listurl;
    private String listUrl1;


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


        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.mRecycleView);
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.recycleview_image_item, null);
        mViewPager = (ViewPager) view1.findViewById(R.id.mPanadaBanner_viewPager);
        imageList = new ArrayList<ImageView>();

        presentImp = new HomePresentImp(this);
        list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        pullToRefreshRecyclerView.setLayoutManager(manager);
        pullToRefreshRecyclerView.addHeaderView(view1);
        //实例化适配
        adapter = new RecycleViewAdapter(getActivity(),list);
        pullToRefreshRecyclerView.setAdapter(adapter);
        pullToRefreshRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                adapter.notifyDataSetChanged();
                pullToRefreshRecyclerView.setRefreshComplete();

            }

            @Override
            public void onLoadMore() {

            }
        });


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
        PanadaHomeBean.DataBean.ListBeanXXX listBeanXXX = bean.getData().getList().get(0);
        getImageView(bean);

        list.add(area);
        list.add(pandaeyeBean);
        list.add(pandaliveBean);
        list.add(wallliveBean);
        list.add(chinaliveBean);
        list.add(interactiveBean);
//        list.add(cctvBean);
        //CCTV发送二次网络请求
        listurl = cctvBean.getListurl();
        sendAgainRequest(listurl);
        //光影中国发送二次网络请求
        String listUrl1 =  listBeanXXX.getListUrl();
        sendListBean(listUrl1);
        adapter.notifyDataSetChanged();
    }
    public void sendListBean(String url){
        presentImp.getListBean(url);
    }
    @Override
    public void loadCcctv(CctvAgainBean cctvAgainBean) {
        list.add(cctvAgainBean);
        adapter.notifyDataSetChanged();
    }
    public void sendAgainRequest(String url){
        presentImp.getCctv(url);
    }
    @Override
    public void loadListBean(PanadaChinaListBean panadaChinaListBean) {
        list.add(panadaChinaListBean);
        adapter.notifyDataSetChanged();
    }

    public void getImageView( PanadaHomeBean panadaHomeBean1){

        List<PanadaHomeBean.DataBean.BigImgBean> beanList = panadaHomeBean1.getData().getBigImg();
        for(int i=0;i<beanList.size();i++){
            PanadaHomeBean.DataBean.BigImgBean bigImgBean1 = beanList.get(i);
            RelativeLayout relativeLayout = new RelativeLayout(getActivity());
            ViewGroup.LayoutParams relativeParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            relativeLayout.setLayoutParams(relativeParams);
            ImageView imageView = new ImageView(getActivity());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            TextView textView = new TextView(getActivity());
            ViewGroup.LayoutParams textParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            textView.setLayoutParams(textParams);
            String title = bigImgBean1.getTitle();
            textView.setText(title);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            Glide.with(getActivity()).load(bigImgBean1.getImage()).into(imageView);
            imageList.add(imageView);

        }
        bannerAdapter = new MyBannerAdapter(imageList);
        bannerAdapter.notifyDataSetChanged();
        mViewPager.setAdapter(bannerAdapter);

        mViewPager.setCurrentItem(1000);

    }

}
