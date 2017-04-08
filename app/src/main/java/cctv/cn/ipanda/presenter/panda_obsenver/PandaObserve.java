package cctv.cn.ipanda.presenter.panda_obsenver;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.ObserverContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.panda_observer.PandaObserverHeadEntity;
import cctv.cn.ipanda.model.panda_observer.PandaObserveImp;

/**
*@author king
*Created at 2017-04-07 10:58
*/

public class PandaObserve implements ObserverContract.Presenter,MyCallback<PandaObserverHeadEntity>{
    ObserverContract.View view;
    PandaObserveImp imp;
    public PandaObserve(ObserverContract.View view ) {
        this.view = view;
            imp = new PandaObserveImp();
    }

    @Override
    public void getHead() {
      imp.getPandaObserveHead(Urls.PANDA_OBSERVE_HEAD,this);
    }


    @Override
    public void getItem() {
        imp.getPandaObserveHead(Urls.PANDA_OBSERVE_ITEM,this);
    }


    @Override
    public void onSuccess(PandaObserverHeadEntity pandaObserveHeadEntity) {
        view.getHeadData(pandaObserveHeadEntity);
    }

    @Override
    public void onError(String msg) {

    }
}
