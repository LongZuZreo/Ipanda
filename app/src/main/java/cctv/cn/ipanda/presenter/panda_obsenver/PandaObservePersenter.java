package cctv.cn.ipanda.presenter.panda_obsenver;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.ObserverContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.http.RetrofitUtils;
import cctv.cn.ipanda.model.panda_observer.PandaObserveItemEntity;
import cctv.cn.ipanda.model.panda_observer.PandaObserverHeadEntity;


/**
 * @author king
 *         Created at 2017-04-07 10:58
 */

public class PandaObservePersenter implements ObserverContract.Presenter {
    private ObserverContract.View view;
    private RetrofitUtils retrofitUtils;

    public PandaObservePersenter(ObserverContract.View view) {
        this.view = view;
        retrofitUtils = RetrofitUtils.getInstance();
    }

    @Override
    public void getHead() {
        retrofitUtils.getData(Urls.PANDA_OBSERVE_HEAD, null, new MyCallback<PandaObserverHeadEntity>() {
            @Override
            public void onSuccess(PandaObserverHeadEntity pandaObserverHeadEntity) {
                view.showHead(pandaObserverHeadEntity);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Override
    public void getItem(String url) {
        retrofitUtils.getData(url, null, new MyCallback<PandaObserveItemEntity>() {
            @Override
            public void onSuccess(PandaObserveItemEntity entity) {
                view.showItem(entity);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
