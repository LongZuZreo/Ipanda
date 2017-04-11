package cctv.cn.ipanda.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveJcyiBean;
import cctv.cn.ipanda.presenter.panda_live.PandaLivePersenterImpl;

/**
 * Created by lenovo on 2017/4/7.
 */

public class LiveFragment extends BaseFragment implements LiveContract.View, View.OnClickListener {

    private ImageView panda_live_image;
    private TextView panda_live_title;
    private CheckBox panda_live_detail;
    private TextView panda_live_detailInfo;
    private PandaLivePersenterImpl pandaLivePersenter;
    public static PandaLiveBean.LiveBean liveBean;
    private TabLayout panda_live_live_tablayout;
    public static List<PandaLiveBean.BookmarkBean.MultipleBean> multiple;
    private List<PandaLiveBean.BookmarkBean.WatchTalkBean> watchTalk;
    private BaseFragment currentFragment;
    private BaseFragment pandaLiveEyeFragment;
    private BaseFragment pandaLiveLiveFragment;
    private FrameLayout panda_live_framlayout;

    private void changeFragment(BaseFragment fragment, Bundle bundle, boolean isBack) {

        FragmentManager supportFragmentManager = getFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        if (bundle != null)
            fragment.setParams(bundle);

        transaction.hide(currentFragment);

        if (!fragment.isAdded())

            transaction.add(R.id.panda_live_framlayout, fragment);

        transaction.show(fragment);

        transaction.commit();

        currentFragment = fragment;
    }


    @Override
    protected int getLayoutId() {

        return R.layout.fragment_panda_live_live;
    }

    @Override
    protected void initView(View view) {

        panda_live_title = (TextView) view.findViewById(R.id.panda_live_title);
        panda_live_detail = (CheckBox) view.findViewById(R.id.panda_live_detail);
        panda_live_image = (ImageView) view.findViewById(R.id.panda_live_image);
        panda_live_detailInfo = (TextView) view.findViewById(R.id.panda_live_detailInfo);
        panda_live_live_tablayout = (TabLayout) view.findViewById(R.id.panda_live_live_tablayout);
        panda_live_live_tablayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected void initData() {

        pandaLiveEyeFragment = new PandaLiveEyeFragment();
        pandaLiveLiveFragment = new PandaLiveLiveFragment();
        pandaLivePersenter = new PandaLivePersenterImpl(this);

        currentFragment = pandaLiveLiveFragment;
        changeFragment(pandaLiveLiveFragment, null, false);
    }

    @Override
    protected void loadData() {

        pandaLivePersenter.getData();
    }


    @Override
    protected void initListener() {

    }

    @Override
    public void clickTabToOtherList() {

        panda_live_live_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if ((int) tab.getTag() == 1000) {

                    changeFragment(pandaLiveLiveFragment, null, false);

                } else if ((int) tab.getTag() == 1001) {

                    changeFragment(pandaLiveEyeFragment, null, false);
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

    @Override
    public void showDetail(PandaLiveBean pandaLiveBean) {

        getList(pandaLiveBean);
    }

    public void getList(PandaLiveBean pandaLiveBean) {

        if (pandaLiveBean != null) {

            List<PandaLiveBean.LiveBean> live = pandaLiveBean.getLive();
            multiple = pandaLiveBean.getBookmark().getMultiple();
            watchTalk = pandaLiveBean.getBookmark().getWatchTalk();

            if (live != null) {

                for (int i = 0; i < live.size(); i++) {

                    liveBean = live.get(i);
                }

                Glide.with(App.context).load(liveBean.getImage()).into(panda_live_image);
                panda_live_title.setText(liveBean.getTitle());
/*
                String name = (String) bundle.get("name");
                panda_live_title.setText(name);*/

                panda_live_detail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (panda_live_detail.isChecked()) {

                            panda_live_detailInfo.setVisibility(View.VISIBLE);
                            panda_live_detailInfo.setText(liveBean.getBrief());

                        } else {

                            panda_live_detailInfo.setVisibility(View.GONE);
                        }
                    }
                });
            }
        }
    }

    @Override
    public void dismissDetail() {

    }

    @Override
    public void sendMessageSuccess() {

    }

    @Override
    public void addMessageSuccess() {

    }

    @Override
    public void clickTabtoHome() {

    }

    @Override
    public void showLiveFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {

    }

    /**
     * 多视角直播标题
     */
    @Override
    public void showLiveTitle() {

        for (int i = 0; i < multiple.size(); i++) {

            PandaLiveBean.BookmarkBean.MultipleBean multipleBean = multiple.get(i);
            String title = multipleBean.getTitle();
            panda_live_live_tablayout.addTab(panda_live_live_tablayout.newTab().setText(title).setTag(1000));
        }
    }

    @Override
    public void showEyeFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {

    }

    /**
     * 边看边聊标题
     */
    @Override
    public void showEyeTitle() {

        for (int i = 0; i < watchTalk.size(); i++) {

            PandaLiveBean.BookmarkBean.WatchTalkBean watchTalkBean = watchTalk.get(i);
            String title = watchTalkBean.getTitle();
            panda_live_live_tablayout.addTab(panda_live_live_tablayout.newTab().setText(title).setTag(1001));
        }

    }

    @Override
    public void showJcyk(PandaLiveJcyiBean pandaLiveJcyiBean) {

    }

    @Override
    public void loadTab2(PandaLiveBqBean pandaLiveBqBean) {

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

    /**
     * 播放视频的方法
     */
    @Override
    public void toVideoPlay() {

        panda_live_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    @Override
    public void changeTitleBar() {

    }

    @Override
    public void onClick(View view) {

    }
}
