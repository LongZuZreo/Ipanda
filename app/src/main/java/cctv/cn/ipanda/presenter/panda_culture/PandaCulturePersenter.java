package cctv.cn.ipanda.presenter.panda_culture;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.CultureContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.http.RetrofitUtils;
import cctv.cn.ipanda.model.panda_culture.PandaCultureEntity;

/**
 * Created by hp1 on 2017-04-07.
 */

public class PandaCulturePersenter implements CultureContract.Presenter {
    private CultureContract.View view;
    private RetrofitUtils retrofitUtils;

    public PandaCulturePersenter(CultureContract.View view) {
        this.view = view;
        retrofitUtils = RetrofitUtils.getInstance();
    }

    @Override
    public void getDataAll() {
        retrofitUtils.getData(Urls.PANDACULTURE, null, new MyCallback<PandaCultureEntity>() {
            @Override
            public void onSuccess(PandaCultureEntity pandaObserverHeadEntity) {

                view.showAll(pandaObserverHeadEntity);

            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
