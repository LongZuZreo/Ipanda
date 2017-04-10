package cctv.cn.ipanda.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.PandaLiveTabAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.presenter.panda_live.PandaLiveBqPresenterImpl;


/**
 * Created by lenovo on 2017/4/7.
 */

public class PandaLiveFragment extends BaseFragment implements LiveContract.View {

    private TabLayout tabLayout;
    private PandaLiveBqPresenterImpl pandaLivePresenter;
    private PandaLiveTabAdapter adapter;
    private List<BaseFragment> fragments;
    private List<String> datas;
    private List<PandaLiveBqBean.TablistBean> list;
    private BaseFragment currentFragment;
    private BaseFragment liveFragment;
    private BaseFragment pandaLiveListFragment;


    private void changeFragment(BaseFragment fragment, Bundle bundle, boolean isBack) {

        FragmentManager supportFragmentManager = getFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        if (bundle != null)
            fragment.setParams(bundle);

        transaction.hide(currentFragment);

        if (!fragment.isAdded())

            transaction.add(R.id.panda_live_Framlayout, fragment);

        transaction.show(fragment);

        transaction.commit();

        currentFragment = fragment;
    }

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_panda_live;
    }


    @Override
    protected void initView(View view) {

        tabLayout = (TabLayout) view.findViewById(R.id.panda_live_tablayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void initData() {

        fragments = new ArrayList<>();
        list = new ArrayList<>();
        datas = new ArrayList<>();
        liveFragment = new LiveFragment();
        pandaLiveListFragment = new PandaLiveListFragment();
        pandaLivePresenter = new PandaLiveBqPresenterImpl(App.context);

        currentFragment = liveFragment;
        changeFragment(liveFragment, null, false);
    }

    @Override
    protected void loadData() {

        pandaLivePresenter.getTabTitle(Urls.PANDALIVEBQ, null, new MyCallback<PandaLiveBqBean>() {
            @Override
            public void onSuccess(PandaLiveBqBean pandaLiveBqBean) {

                Log.i("aaaaa", "aaaaaaaa");
                list.addAll(pandaLiveBqBean.getTablist());

                if (pandaLiveBqBean != null) {

                    List<PandaLiveBqBean.TablistBean> tablist = pandaLiveBqBean.getTablist();

                    if (tablist != null) {

                        for (int i = 0; i < tablist.size(); i++) {

                            PandaLiveBqBean.TablistBean tablistBean = tablist.get(i);
                            String title = tablistBean.getTitle();
                            tabLayout.addTab(tabLayout.newTab().setText(title).setTag(123));
                            datas.add(title);
                        }
                    }

                    Toast.makeText(getActivity(), "直播", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String msg) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if ((int) tab.getTag() == 123) {

                    changeFragment(liveFragment, null, false);
                    Toast.makeText(App.context, "9999", Toast.LENGTH_SHORT).show();

                } else {

                    changeFragment(pandaLiveListFragment, null, false);
                    Toast.makeText(App.context, "8888", Toast.LENGTH_SHORT).show();
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
    protected void initListener() {

    }

    @Override
    public void clickTabToOtherList() {

    }

    /**
     * 显示详情
     */
    @Override
    public void showDetail(PandaLiveBean pandaLiveBean) {

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

    @Override
    public void showLiveTitle() {

    }

    @Override
    public void showEyeFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {

    }

    @Override
    public void showEyeTitle() {

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
     * 视频播放
     */
    @Override
    public void toVideoPlay() {

    }

    /**
     * 标题切换
     */
    @Override
    public void changeTitleBar() {

    }
}
