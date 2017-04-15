package cctv.cn.ipanda.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.adapter.PandaLiveRecycleAdapter;
import cctv.cn.ipanda.base.BaseFragment;

import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveJcyiBean;
import cctv.cn.ipanda.presenter.panda_live.PandaLiveTabPresenterImpl;


/**
 * Created by lenovo on 2017/4/8.
 */

public class PandaLiveListFragment extends BaseFragment implements LiveContract.View {

    private PullToRefreshRecyclerView refreshRecyclerView;
    private PandaLiveRecycleAdapter adapter;
    private List<PandaLiveJcyiBean.VideoBean> datas;
    private PandaLiveTabPresenterImpl pandaLivePersenter;
    private String id;
    private int page = 7;
    private int p = 1;


    @Override
    protected int getLayoutId() {

        return R.layout.fragment_panda_live_listview;
    }

    @Override
    protected void initView(View view) {

        refreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.panda_live_recycle);
    }

    @Override
    protected void initData() {

        id = (String) bundle.get("id");
        pandaLivePersenter = new PandaLiveTabPresenterImpl(this);
        LinearLayoutManager manager = new LinearLayoutManager(App.context, LinearLayoutManager.VERTICAL, false);
        refreshRecyclerView.setLayoutManager(manager);
        datas = new ArrayList<>();
        adapter = new PandaLiveRecycleAdapter(App.context, datas);
        refreshRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {

                datas.clear();
                getDatas(page, 1, false);
            }

            @Override
            public void onLoadMore() {

                p = p + 1;
                getDatas(page, p, true);
            }
        });

        refreshRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void loadData() {

        getDatas(page, p, false);
    }

    private void getDatas(int page, int p, final boolean isLoadMore) {

        pandaLivePersenter.getInfo("http://api.cntv.cn/video/videolistById?vsid=" + id + "&n=" + page + "&serviceId=panda&o=desc&of=time&p=" + p, null, new MyCallback<PandaLiveJcyiBean>() {
            @Override
            public void onSuccess(PandaLiveJcyiBean pandaLiveJcyiBean) {

                List<PandaLiveJcyiBean.VideoBean> video = pandaLiveJcyiBean.getVideo();

                datas.addAll(video);
                adapter.notifyDataSetChanged();

                if (isLoadMore) {

                    refreshRecyclerView.setLoadMoreComplete();
                } else {

                    refreshRecyclerView.setRefreshComplete();
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void show() {
        MainActivity.currentFragment=this;
    }

    @Override
    protected void hide() {

    }

    @Override
    public void clickTabToOtherList() {

    }

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
    public void showJcyk(PandaLiveJcyiBean pandaLiveJcyiBean) {

    }

    /**
     * 精彩一刻
     */

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

        refreshRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {

                refreshRecyclerView.setRefreshComplete();
            }

            @Override
            public void onLoadMore() {

                refreshRecyclerView.setLoadMoreComplete();
            }
        });
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
