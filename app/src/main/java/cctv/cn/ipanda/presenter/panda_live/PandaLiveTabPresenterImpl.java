package cctv.cn.ipanda.presenter.panda_live;

import java.util.Map;

import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.IPandaLiveModel;
import cctv.cn.ipanda.model.pandalive.PandaLiveModelImpl;

/**
 * Created by lenovo on 2017/4/11.
 */

public class PandaLiveTabPresenterImpl implements LiveContract.Presenter {

    private LiveContract.View liveFragment;
    private IPandaLiveModel pandaLiveModel;


    public PandaLiveTabPresenterImpl(LiveContract.View view) {

        pandaLiveModel = new PandaLiveModelImpl();

        liveFragment = view;

    }

    @Override
    public <T> void getTabTitle(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getData() {

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

        pandaLiveModel.getJcyk(url,params,callback);
    }

    @Override
    public <T> void getLiveFragment(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getEyeFragment(String url, Map<String, String> params, MyCallback<T> callback) {

    }
}
