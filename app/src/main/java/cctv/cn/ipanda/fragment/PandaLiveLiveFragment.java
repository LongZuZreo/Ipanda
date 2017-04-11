package cctv.cn.ipanda.fragment;

import android.util.Log;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.PandaLiveLiveGridViewAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.presenter.panda_live.PandaLiveDuoshijiaoPresenterImpl;

/**
 * Created by lenovo on 2017/4/10.
 */

public class PandaLiveLiveFragment extends BaseFragment implements LiveContract.View {

    private GridView gridView;
    private PandaLiveLiveGridViewAdapter gridViewAdapter;
    private List<PandaLiveDuoshijiaoBean.ListBean> datas;
    private PandaLiveDuoshijiaoPresenterImpl pandaLiveDuoshijiaoPresenter;
    private String url;
    private PandaLiveBean.BookmarkBean.MultipleBean multipleBean;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_live_duoshijiaolive;
    }

    @Override
    protected void loadData() {

        pandaLiveDuoshijiaoPresenter.getData();

    }

    @Override
    protected void initData() {

        datas = new ArrayList<>();
        pandaLiveDuoshijiaoPresenter = new PandaLiveDuoshijiaoPresenterImpl(this);
        gridViewAdapter = new PandaLiveLiveGridViewAdapter(App.context, datas);
        gridView.setAdapter(gridViewAdapter);
    }

    @Override
    protected void initView(View view) {

        gridView = (GridView) view.findViewById(R.id.panda_live_duoshijiao_gridview);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void clickTabToOtherList() {

    }

    @Override
    public void showDetail(final PandaLiveBean pandaLiveBean) {

        final PandaLiveBean.BookmarkBean bookmark = pandaLiveBean.getBookmark();
        final List<PandaLiveBean.BookmarkBean.MultipleBean> multiple = bookmark.getMultiple();

        for (int i = 0; i < multiple.size(); i++) {

            multipleBean = multiple.get(i);
            url = multipleBean.getUrl();
        }

        pandaLiveDuoshijiaoPresenter.getLiveFragment(url, null, new MyCallback<PandaLiveDuoshijiaoBean>() {
            @Override
            public void onSuccess(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {

                List<PandaLiveDuoshijiaoBean.ListBean> list = pandaLiveDuoshijiaoBean.getList();
                datas.addAll(list);
                gridViewAdapter.notifyDataSetChanged();
                Log.i("wwww", "wwwwwww");
            }

            @Override
            public void onError(String msg) {

            }
        });
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

        if (pandaLiveDuoshijiaoBean != null) {

            List<PandaLiveDuoshijiaoBean.ListBean> list = pandaLiveDuoshijiaoBean.getList();
            datas.addAll(list);
            gridViewAdapter.notifyDataSetChanged();
        }
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

    @Override
    public void toVideoPlay() {

    }

    @Override
    public void changeTitleBar() {

    }
}