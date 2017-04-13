package cctv.cn.ipanda.fragment;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.pandaobserveradapter.PandaObserverBannerAdapter;
import cctv.cn.ipanda.adapter.pandaobserveradapter.PandaObserverItemAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.contract.ObserverContract;
import cctv.cn.ipanda.model.panda_observer.PandaObserveItemEntity;
import cctv.cn.ipanda.model.panda_observer.PandaObserverHeadEntity;
import cctv.cn.ipanda.presenter.panda_obsenver.PandaObservePersenter;

/**
 * Created by hp1 on 2017-04-07.
 */

public class PandaObserverFragment extends MainFragment implements ObserverContract.View, PullToRefreshListener {


    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private List<PandaObserverHeadEntity.DataBean.BigImgBean> dataBeanList;
    private List<ImageView> imgs;
    private PandaObserverBannerAdapter pandaObserverBannerAdapter;
    private ViewPager pandaObserverViewPagerView;
    private TextView pandaObserverBannerTitle;
    private List<PandaObserveItemEntity.ListBean> listBeanList;
    private PandaObserverItemAdapter itemAdapter;
    private PandaObservePersenter pandaObservePersenter;
    private PandaObserverHeadEntity.DataBean data;
    private String mSecUrl;
    private int mPage = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_observe;
    }

    @Override
    protected void loadData() {
        pandaObservePersenter.getHead();
    }

    @Override
    protected void initData() {
        imgs = new ArrayList<>();
        listBeanList = new ArrayList<>();
        pandaObservePersenter = new PandaObservePersenter(this);
        dataBeanList = new ArrayList<>();
        itemAdapter = new PandaObserverItemAdapter(getActivity(), listBeanList);
        pullToRefreshRecyclerView.setAdapter(itemAdapter);
    }

    @Override
    protected void initView(View view) {
        View pandaObserverViewPager = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_panda_observe_head, null);
        pandaObserverViewPagerView = (ViewPager) pandaObserverViewPager.findViewById(R.id.panda_observer_banner);
        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.panda_observe);
        pandaObserverBannerTitle = (TextView) pandaObserverViewPager.findViewById(R.id.panda_observer_banner_title);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        pullToRefreshRecyclerView.setLayoutManager(linearLayoutManager);
        pullToRefreshRecyclerView.addHeaderView(pandaObserverViewPager);
        pullToRefreshRecyclerView.setPullRefreshEnabled(false);

    }

    @Override
    protected void initListener() {
        pullToRefreshRecyclerView.setPullToRefreshListener(this);
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
    public void showHead(PandaObserverHeadEntity entity) {
        data = entity.getData();
        pandaObservePersenter.getItem(data.getListurl());
        dataBeanList.addAll(data.getBigImg());
        createImg(entity);


    }

    @Override
    public void showItem(PandaObserveItemEntity entity) {
        pullToRefreshRecyclerView.setRefreshComplete();
        List<PandaObserveItemEntity.ListBean> list = entity.getList();
        listBeanList.addAll(list);
        itemAdapter.notifyDataSetChanged();
    }

    private void createImg(PandaObserverHeadEntity entity) {
        List<PandaObserverHeadEntity.DataBean.BigImgBean> tab = entity.getData().getBigImg();
        for (int i = 0; i < tab.size(); i++) {
            PandaObserverHeadEntity.DataBean.BigImgBean bigImgBean = tab.get(i);
            String imageUrl = bigImgBean.getImage();
            ImageView imageView = new ImageView(getActivity());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(this).load(imageUrl).into(imageView);
            imgs.add(imageView);
            pandaObserverBannerTitle.setText(bigImgBean.getTitle());
            pandaObserverBannerTitle.setLines(1);

        }
        pandaObserverBannerAdapter = new PandaObserverBannerAdapter(imgs);
        pandaObserverViewPagerView.setAdapter(pandaObserverBannerAdapter);
        pandaObserverViewPagerView.setCurrentItem(1000);

    }

    @Override
    public void onRefresh() {
        pullToRefreshRecyclerView.setRefreshComplete();
    }

    @Override
    public void onLoadMore() {
        mPage++;
        mSecUrl = data.getListurl().trim() + "&pageSize=6&page=";
        pandaObservePersenter.getItem(mSecUrl.toString() + mPage);
        pullToRefreshRecyclerView.setLoadMoreComplete();
    }
}
