package cctv.cn.ipanda.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.Util.CircleImageView;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.adapter.pandacultureadapter.PandaCultureBannerAdapter;
import cctv.cn.ipanda.adapter.pandacultureadapter.PandaCultureItemAdapter;
import cctv.cn.ipanda.adapter.pandaobserveradapter.PandaObserverBannerAdapter;
import cctv.cn.ipanda.adapter.pandaobserveradapter.PandaObserverItemAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.contract.CultureContract;
import cctv.cn.ipanda.model.panda_culture.PandaCultureEntity;
import cctv.cn.ipanda.model.panda_observer.PandaObserverHeadEntity;
import cctv.cn.ipanda.presenter.panda_culture.PandaCulturePersenter;
import cctv.cn.ipanda.presenter.panda_obsenver.PandaObservePersenter;


/**
 * Created by hp1 on 2017-04-07.
 */

public class PandaCultureFragment extends BaseFragment implements CultureContract.View {
    private PandaCulturePersenter pandaCulturePersenter;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private List<PandaCultureEntity.BigImgBean> dataBeanList;
    private List<ImageView> imgs;
    private PandaCultureBannerAdapter pandaCultureBannerAdapter;
    private ViewPager pandaCultureViewPagerView;
    private TextView pandaCultureBannerTitle;
    private List<PandaCultureEntity.ListBean> listBeanList;
    private PandaCultureItemAdapter itemAdapter;
    private List<CircleImageView> points;
    private int currentPosition = 10000;
    private ViewGroup pointsLinearLayout;
    private PandaWebView pandaWebView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_culture;
    }

    @Override
    protected void loadData() {
        pandaCulturePersenter.getDataAll();
    }

    @Override
    protected void initData() {
        imgs = new ArrayList<>();
        points = new ArrayList<>();
        listBeanList = new ArrayList<>();
        pandaCulturePersenter = new PandaCulturePersenter(this);
        dataBeanList = new ArrayList<>();
        pandaWebView = new PandaWebView();
        itemAdapter = new PandaCultureItemAdapter(getActivity(), listBeanList);
        pullToRefreshRecyclerView.setAdapter(itemAdapter);
    }

    @Override
    protected void initView(View view) {

        View pandaCultureView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_panda_culture_banner, null);
        pandaCultureViewPagerView = (ViewPager) pandaCultureView.findViewById(R.id.panda_culture_banner);
        pandaCultureBannerTitle = (TextView) pandaCultureView.findViewById(R.id.panda_culture_banner_title);
        pointsLinearLayout = (ViewGroup) pandaCultureView.findViewById(R.id.pointsLinearLayout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.panda_culture_pulltorefresh);
        pullToRefreshRecyclerView.setLayoutManager(linearLayoutManager);
        pullToRefreshRecyclerView.addHeaderView(pandaCultureView);
        pullToRefreshRecyclerView.setPullRefreshEnabled(false);
        pullToRefreshRecyclerView.setLoadingMoreEnabled(false);
    }

    @Override
    protected void initListener() {
        pandaCultureViewPagerView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (CircleImageView circleImageView : points) {
                    circleImageView.setImageResource(R.drawable.white_point);
                }
                points.get(position % points.size()).setImageResource(R.drawable.gray_point);
                pandaCultureBannerTitle.setText(dataBeanList.get(position % points.size()).getTitle());
                currentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    currentPosition = currentPosition + 1;
                    pandaCultureViewPagerView.setCurrentItem(currentPosition);
                    sendEmptyMessageDelayed(1, 3000);
                    break;
            }
        }
    };

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
    public void showAll(PandaCultureEntity entity) {
        dataBeanList.addAll(entity.getBigImg());
        listBeanList.addAll(entity.getList());
        createImg(entity);
        itemAdapter.notifyDataSetChanged();
    }

    private void createImg(PandaCultureEntity entity) {
        final List<PandaCultureEntity.BigImgBean> tab = entity.getBigImg();
        int pointPosition = 0;
        for (int i = 0; i < tab.size(); i++) {
            PandaCultureEntity.BigImgBean bigImgBean = tab.get(i);
            String image = bigImgBean.getImage();
            final ImageView imageView = new ImageView(getActivity());


            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(this).load(image).into(imageView);
            imageView.setTag(i);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a = (int) imageView.getTag();
                    PandaCultureEntity.BigImgBean bigImgBean1 = tab.get(a);
                    MainActivity activity = (MainActivity) getActivity();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bigImgBean1.getUrl());
                    bundle.putString("title", bigImgBean1.getTitle());
                    bundle.putString("imageurl", bigImgBean1.getImage());
                    activity.changeFragment(pandaWebView, bundle, false);

                }
            });
            imgs.add(imageView);


            CircleImageView circleImageView = new CircleImageView(getActivity());
            circleImageView.setCircleModel(CircleImageView.POINT);
            RelativeLayout.LayoutParams pointViewParams = new RelativeLayout.LayoutParams(dp2Px(8), dp2Px(8));
            circleImageView.setLayoutParams(pointViewParams);
            circleImageView.setTag(pointPosition);
            circleImageView.setImageResource(R.drawable.white_point);
            points.add(circleImageView);
            pointsLinearLayout.addView(circleImageView);
            pointPosition++;

        }
        pandaCultureBannerAdapter = new PandaCultureBannerAdapter(imgs);
        points.get(0).setImageResource(R.drawable.gray_point);
        pandaCultureViewPagerView.setAdapter(pandaCultureBannerAdapter);
        pandaCultureBannerAdapter.notifyDataSetChanged();
        pandaCultureViewPagerView.setCurrentItem(currentPosition);
        handler.sendEmptyMessageDelayed(1, 3000);

    }

    public int dp2Px(int dpValue) {
        return (int) (getActivity().getResources().getDisplayMetrics().density * dpValue + 0.5f);
    }
}
