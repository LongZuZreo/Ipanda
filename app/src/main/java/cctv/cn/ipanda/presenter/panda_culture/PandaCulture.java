package cctv.cn.ipanda.presenter.panda_culture;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.CultureContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.panda_culture.PandaCultureEntity;
import cctv.cn.ipanda.model.panda_culture.PandaCultureImp;

/**
 * Created by hp1 on 2017-04-07.
 */

public class PandaCulture implements CultureContract.View, MyCallback<PandaCultureEntity> {
    private PandaCultureImp pandaCultureImp;
    private CultureContract.View view;
    public PandaCulture(CultureContract.View view) {
      this.view = view;
        pandaCultureImp = new PandaCultureImp();
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
    public void getBanner() {

    }

    @Override
    public void getItem() {

    }

    @Override
    public void onSuccess(PandaCultureEntity pandaCultureEntity) {

    }

    @Override
    public void onError(String msg) {

    }
}
