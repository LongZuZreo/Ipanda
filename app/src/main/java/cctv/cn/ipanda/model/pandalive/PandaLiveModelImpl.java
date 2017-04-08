package cctv.cn.ipanda.model.pandalive;

import java.util.Map;

import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.http.pandalive.IPandaLiveModel;
import cctv.cn.ipanda.model.http.pandalive.PandaLiveBqBean;

/**
 * Created by lenovo on 2017/4/7.
 */

public class PandaLiveModelImpl implements IPandaLiveModel {


    @Override
    public <T> void getTabTitle(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    @Override
    public <T> void getData(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    @Override
    public <T> void showImage(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    @Override
    public <T> void gettitle(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    @Override
    public <T> void getDetailInfo(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }
}
