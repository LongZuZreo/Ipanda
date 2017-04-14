package cctv.cn.ipanda.fragment;

import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.hdjhback.PanadaHdjeAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.HomeContract;
import cctv.cn.ipanda.model.panada_hdjh.PanadaInterfactionBean;
import cctv.cn.ipanda.model.panada_home.CctvAgainBean;
import cctv.cn.ipanda.model.panada_home.PanadaChinaListBean;
import cctv.cn.ipanda.model.panada_home.PanadaEyesBean;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;
import cctv.cn.ipanda.model.panada_home.UpdateBean;
import cctv.cn.ipanda.presenter.panada_home.HomePresentImp;

/**
 * Created by ASUS on 2017/4/12.
 */
//互动集合页
public class InteractionFragment extends BaseFragment implements HomeContract.View{

    private ListView mlistview;
    private HomePresentImp presentImp;
    private List<PanadaInterfactionBean.InteractiveBean> list;
    private PanadaHdjeAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hdjh;
    }

    @Override
    protected void loadData() {
    presentImp.getHdjh(Urls.HDJH);
    }

    @Override
    protected void initData() {
        presentImp = new HomePresentImp(this);
        list = new ArrayList<>();
        adapter = new PanadaHdjeAdapter(getActivity(),list);
        mlistview.setAdapter(adapter);
    }

    @Override
    protected void initView(View view) {
        mlistview = (ListView) view.findViewById(R.id.mhdjelistview);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void loadDetail(PanadaHomeBean bean) {

    }

    @Override
    public void loadCcctv(CctvAgainBean cctvAgainBean) {

    }

    @Override
    public void loadListBean(PanadaChinaListBean panadaChinaListBean) {

    }

    @Override
    public void loadInteractionBean(PanadaInterfactionBean panadaInterfactionBean) {
        list.addAll(panadaInterfactionBean.getInteractive());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getVersion(UpdateBean updateBean) {

    }

    @Override
    public void getPanadaEyesList(PanadaEyesBean panadaEyesBean) {

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
