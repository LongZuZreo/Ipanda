package cctv.cn.ipanda.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.pandalive.IPandaLiveModel;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.PandaLiveModelImpl;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.presenter.pandalive.PandaLivePresenterImpl;

/**
 * Created by lenovo on 2017/4/7.
 */

public class PandaLiveFragment extends BaseFragment implements LiveContract.View {

    private TabLayout tabLayout;
    private PandaLivePresenterImpl pandaLivePresenter;
    private Fragment pandaLiveFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_live;
    }


    @Override
    protected void initView(View view) {

        tabLayout = (TabLayout) view.findViewById(R.id.panda_live_tablayout);
    }

    @Override
    protected void initData() {

        pandaLivePresenter = new PandaLivePresenterImpl(getActivity());
        this.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void clickTabToOtherList() {

    }

    @Override
    public void showDetail() {

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
    public void loadTab() {

        pandaLivePresenter.getTabTitle(Urls.PANDALIVEBQ, null, new MyCallback<PandaLiveBqBean>() {
            @Override
            public void onSuccess(PandaLiveBqBean pandaLiveBqBean) {

                if (pandaLiveBqBean != null) {

                    List<PandaLiveBqBean.TablistBean> tablist = pandaLiveBqBean.getTablist();

                    if (tablist != null) {
                        for (int i = 0; i < tablist.size(); i++) {

                            PandaLiveBqBean.TablistBean tablistBean = tablist.get(i);
                            String title = tablistBean.getTitle();
                            tabLayout.addTab(tabLayout.newTab().setText(title));
                        }
                    }
                }
            }

            @Override
            public void onError(String msg) {

                Toast.makeText(getActivity(), "网络请求失败！", Toast.LENGTH_SHORT).show();
            }
        });
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
}


       /* pandaLiveModel.getTabTitle(Urls.PANDALIVEBQ, null, new MyCallback<PandaLiveBqBean>() {
            @Override
            public void onSuccess(PandaLiveBqBean pandaLiveBean) {

                if (pandaLiveBean != null) {

                    List<PandaLiveBqBean.TablistBean> tablist = pandaLiveBean.getTablist();
                    if (tablist != null) {

                        for (int i = 0; i < tablist.size(); i++) {

                            PandaLiveBqBean.TablistBean tablistBean = tablist.get(i);
                            String title = tablistBean.getTitle();
                            tabLayout.addTab(tabLayout.newTab().setText(title));
                        }
                    }
                }
            }

            @Override
            public void onError(String msg) {

                Toast.makeText(getActivity(), "网络请求失败！", Toast.LENGTH_SHORT).show();
            }
        });*/
