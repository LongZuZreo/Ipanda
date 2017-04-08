package cctv.cn.ipanda.fragment;

import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.contract.ObserverContract;
import cctv.cn.ipanda.model.panda_observer.PandaObserverHeadEntity;
import cctv.cn.ipanda.presenter.panda_obsenver.PandaObserve;

/**
 * Created by hp1 on 2017-04-07.
 */

public class PandaObserverFragment extends BaseFragment implements ObserverContract.View {

    private PandaObserve pandaObserve;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_observe;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {
        pandaObserve = new PandaObserve(this);
    }

    @Override
    protected void initView(View view) {
        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.panda_observe);
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
    public void getHeadData(PandaObserverHeadEntity entity) {
        entity.getData();
    }

    @Override
    public void getItemData() {

    }
}
