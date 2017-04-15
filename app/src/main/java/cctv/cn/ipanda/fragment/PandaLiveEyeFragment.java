package cctv.cn.ipanda.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.PandaLiveTalkAdapter;
import cctv.cn.ipanda.base.AutoLoadListener;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveJcyiBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveTalkListBean;
import cctv.cn.ipanda.presenter.panda_live.PandaLiveTalkPersenterImpl;

/**
 * Created by lenovo on 2017/4/10.
 */

public class PandaLiveEyeFragment extends BaseFragment implements LiveContract.View {

    private EditText pinglun;
    private Button sendMsg;
    private PullToRefreshRecyclerView listView;
    private List<PandaLiveTalkListBean.DataBean.ContentBean> datas;
    private PandaLiveTalkAdapter adapter;
    private PandaLiveTalkPersenterImpl pandaLiveTalkPersenter;
    private boolean isLoadMore;
    private View footView;
    private boolean isLodding;

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    private String total;

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_live_kanliao;
    }

    @Override
    protected void loadData() {

        pandaLiveTalkPersenter.getTalkList();
    }

    @Override
    protected void initData() {

        pandaLiveTalkPersenter = new PandaLiveTalkPersenterImpl(this);
        datas = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(App.context, LinearLayoutManager.VERTICAL, false);
        listView.setLayoutManager(manager);
        listView.setPullRefreshEnabled(false);
        adapter = new PandaLiveTalkAdapter(App.context, datas);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void initView(View view) {

        pinglun = (EditText) view.findViewById(R.id.panda_live_kanliao_edit);
        sendMsg = (Button) view.findViewById(R.id.panda_live_kanliao_sendMsg);
        listView = (PullToRefreshRecyclerView) view.findViewById(R.id.panda_live_talklistview);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void show() {

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

    @Override
    public void showTalkList(PandaLiveTalkListBean pandaLiveJcyiBean) {

        if (pandaLiveJcyiBean != null) {

            PandaLiveTalkListBean.DataBean data = pandaLiveJcyiBean.getData();

            isLodding = false;

            total = data.getTotal();

            List<PandaLiveTalkListBean.DataBean.ContentBean> content = data.getContent();

            datas.addAll(content);

            adapter.notifyDataSetChanged();
        }

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

        listView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

                pandaLiveTalkPersenter.getTalkList();
                Toast.makeText(App.context, "成功加载更多", Toast.LENGTH_SHORT).show();
                Log.i("www", "wwww");
            }
        });
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
