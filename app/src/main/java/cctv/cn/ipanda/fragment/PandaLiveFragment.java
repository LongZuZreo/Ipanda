package cctv.cn.ipanda.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cctv.cn.ipanda.model.pandalive.PandaLiveJcyiBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveTalkListBean;
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
    private BaseFragment pandaLiveListFragment1;
    private BaseFragment pandaLiveListFragment2;
    private BaseFragment pandaLiveListFragment3;
    private BaseFragment pandaLiveListFragment4;
    private BaseFragment pandaLiveListFragment5;
    private BaseFragment pandaLiveListFragment6;
    private BaseFragment pandaLiveListFragment7;
    private BaseFragment pandaLiveListFragment8;
    private BaseFragment pandaLiveListFragment9;
    private BaseFragment pandaLiveListFragment10;
    private BaseFragment pandaLiveListFragment11;
    private Bundle bundle;



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

        bundle = new Bundle();
        fragments = new ArrayList<>();
        list = new ArrayList<>();
        datas = new ArrayList<>();
        liveFragment = new LiveFragment();
        pandaLiveListFragment = new PandaLiveListFragment();
        pandaLiveListFragment1 = new PandaLiveListFragment();
        pandaLiveListFragment2 = new PandaLiveListFragment();
        pandaLiveListFragment3 = new PandaLiveListFragment();
        pandaLiveListFragment4 = new PandaLiveListFragment();
        pandaLiveListFragment5 = new PandaLiveListFragment();
        pandaLiveListFragment6 = new PandaLiveListFragment();
        pandaLiveListFragment7 = new PandaLiveListFragment();
        pandaLiveListFragment8 = new PandaLiveListFragment();
        pandaLiveListFragment9 = new PandaLiveListFragment();
        pandaLiveListFragment10 = new PandaLiveListFragment();
        pandaLiveListFragment11 = new PandaLiveListFragment();
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
                            Map<String, String> map = new HashMap<String, String>();
                            map.put("order", tablistBean.getOrder());
                            map.put("id", tablistBean.getId());
                            tabLayout.addTab(tabLayout.newTab().setText(title).setTag(map));
                        }
                    }
                }
            }

            @Override
            public void onError(String msg) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Map<String, String> map = (Map<String, String>) tab.getTag();

                if (map.get("order").equals("1")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(liveFragment, bundle, false);

                } else if (map.get("order").equals("2")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment1, bundle, false);

                } else if (map.get("order").equals("3")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment2, bundle, false);

                } else if (map.get("order").equals("4")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment3, bundle, false);
                }else if (map.get("order").equals("5")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment4, bundle, false);
                }
                else if (map.get("order").equals("6")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment5, bundle, false);
                }
                else if (map.get("order").equals("7")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment6, bundle, false);
                }
                else if (map.get("order").equals("8")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment7, bundle, false);
                }
                else if (map.get("order").equals("9")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment8, bundle, false);
                }
                else if (map.get("order").equals("10")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment9, bundle, false);

                }else if (map.get("order").equals("11")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment10, bundle, false);
                }else if (map.get("order").equals("12")) {

                    bundle.putString("id", map.get("id"));
                    changeFragment(pandaLiveListFragment11, bundle, false);
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

    /**
     * 精彩一刻
     *
     * @param pandaLiveJcyiBean
     */
    @Override
    public void showJcyk(PandaLiveJcyiBean pandaLiveJcyiBean) {

    }

    @Override
    public void showTalkList(PandaLiveTalkListBean pandaLiveJcyiBean) {

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
