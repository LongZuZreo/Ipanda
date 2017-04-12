package cctv.cn.ipanda.presenter.panda_live;

import android.util.Log;

import java.util.List;
import java.util.Map;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.IPandaLiveModel;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveModelImpl;

/**
 * Created by lenovo on 2017/4/10.
 */

public class PandaLiveDuoshijiaoPresenterImpl implements LiveContract.Presenter ,MyCallback<PandaLiveDuoshijiaoBean>{


    private List<PandaLiveBean.BookmarkBean.MultipleBean> multiple;
    private List<PandaLiveBean.BookmarkBean.WatchTalkBean> watchTalk;
    private LiveContract.View liveFragment;
    private IPandaLiveModel pandaLiveModel;

    public PandaLiveDuoshijiaoPresenterImpl(LiveContract.View view) {

        pandaLiveModel = new PandaLiveModelImpl();

        liveFragment = view;

    }


    @Override
    public <T> void getTabTitle(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getData() {

        pandaLiveModel.getData(Urls.PANDALIVE, null, new MyCallback<PandaLiveBean>() {
            @Override
            public void onSuccess(PandaLiveBean pandaLiveBean) {

                if (pandaLiveBean != null) {

                    liveFragment.showDetail(pandaLiveBean);
                }
            }

            @Override
            public void onError(String msg) {

            }
        });

    }

    @Override
    public <T> void getData(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void showImage(String url) {

    }

    @Override
    public <T> void getLiveTitle(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getEyeTitle(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getTitle(String title) {

    }

    @Override
    public <T> void showDetailInfo(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getInfo(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getLiveFragment(String url, Map<String, String> params, MyCallback<T> callback) {

        pandaLiveModel.getLiveFragment(url, params, callback);
    }

    @Override
    public <T> void getEyeFragment(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public void onSuccess(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean) {

        liveFragment.showLiveFragment(pandaLiveDuoshijiaoBean);
    }

    @Override
    public void onError(String msg) {

    }
}
