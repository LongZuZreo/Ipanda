package cctv.cn.ipanda.fragment;

import android.view.View;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveJcyiBean;

/**
 * Created by lenovo on 2017/4/10.
 */

public class PandaLiveEyeFragment extends BaseFragment implements LiveContract.View{

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_live_kanliao;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

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
