package cctv.cn.ipanda.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.PandaLiveRecycleAdapter;
import cctv.cn.ipanda.base.BaseFragment;

import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.presenter.panda_live.PandaLivePersenterImpl;


/**
 * Created by lenovo on 2017/4/8.
 */

public class PandaLiveListFragment extends BaseFragment implements LiveContract.View {

    private PullToRefreshRecyclerView refreshRecyclerView;
    private PandaLiveRecycleAdapter adapter;
    private List<PandaLiveBqBean.TablistBean> datas;
    private PandaLivePersenterImpl pandaLivePersenter;

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

        pandaLivePersenter = new PandaLivePersenterImpl(this);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        refreshRecyclerView.setLayoutManager(manager);
        datas = new ArrayList<>();
        adapter = new PandaLiveRecycleAdapter(getActivity(), datas);
        refreshRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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
    public void showLiveTitle( ) {

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
