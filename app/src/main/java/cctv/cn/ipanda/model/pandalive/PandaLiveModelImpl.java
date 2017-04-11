package cctv.cn.ipanda.model.pandalive;

import java.util.Map;

import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by lenovo on 2017/4/7.
 */

public class PandaLiveModelImpl implements IPandaLiveModel {

    //获得熊猫直播标题
    @Override
    public <T> void getTabTitle(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    //获得
    @Override
    public <T> void getData(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    //显示图片
    @Override
    public <T> void showImage(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    @Override
    public <T> void gettitle(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    //获取详细信息
    @Override
    public <T> void getDetailInfo(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    //多视角直播标题
    @Override
    public <T> void getLiveTitle(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    //边看边聊标题
    @Override
    public <T> void getEyeTitle(String url, Map<String, String> params, MyCallback<T> callback) {

        retrofitUtils.getData(url, params, callback);
    }

    //多视角直播
    @Override
    public <T> void getLiveFragment(String url, Map<String, String> params, MyCallback<T> callback) {
        retrofitUtils.getData(url, params, callback);
    }

    //边看表聊
    @Override
    public <T> void getEyeFragment(String url, Map<String, String> params, MyCallback<T> callback) {
        retrofitUtils.getData(url, params, callback);
    }

    @Override
    public <T> void getJcyk(String url, Map<String, String> params, MyCallback<T> callback) {
        retrofitUtils.getData(url, params, callback);
    }
}
