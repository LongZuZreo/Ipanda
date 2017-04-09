package cctv.cn.ipanda.fragment;

import android.view.View;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.contract.LiveChinaContract;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaTabEntity;

/**
 * Created by 张志远 on 2017/4/7.
 */

public class PandaLiveChinaFragment extends BaseFragment implements LiveChinaContract.View{
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_live_china;
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
    public void toTabPopupWindow() {

    }

    @Override
    public void toOtherTab() {

    }

    @Override
    public void loadTab(IPandaLiveChinaTabEntity iPandaLiveChinaTabEntity) {

        List<IPandaLiveChinaTabEntity.TablistBean> tablist = iPandaLiveChinaTabEntity.getTablist();


    }
}
