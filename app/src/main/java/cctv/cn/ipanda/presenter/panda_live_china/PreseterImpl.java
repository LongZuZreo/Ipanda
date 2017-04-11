package cctv.cn.ipanda.presenter.panda_live_china;

import cctv.cn.ipanda.base.BaseView;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LiveChinaContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaListEntity;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaModel;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaModelImpl;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaTabEntity;

/**
 * Created by 张志远 on 2017/4/8.
 */

public class PreseterImpl implements LiveChinaContract.Presenter{

    LiveChinaContract.View view;

    IPandaLiveChinaModel model;
    public PreseterImpl(BaseView view) {
        this.view= (LiveChinaContract.View) view;
        this.model=new IPandaLiveChinaModelImpl();
    }

    @Override
    public void getAllTab(){
        model.getAllTab(Urls.PANDA_LIVE_CHINA_TAB, null, new MyCallback<IPandaLiveChinaTabEntity>() {
            @Override
            public void onSuccess(IPandaLiveChinaTabEntity iPandaLiveChinaTabEntity) {
                view.loadTab(iPandaLiveChinaTabEntity);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
    @Override
    public void getVideoList(String url) {
        model.getVideoList(url, null, new MyCallback<IPandaLiveChinaListEntity>() {
            @Override
            public void onSuccess(IPandaLiveChinaListEntity iPandaLiveChinaListEntity) {
                view.loadList(iPandaLiveChinaListEntity);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
