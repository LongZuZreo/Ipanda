package cctv.cn.ipanda.presenter.panda_live;

import android.content.Context;
import android.util.Log;

import java.util.Map;

import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.fragment.PandaLiveFragment;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.IPandaLiveModel;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveModelImpl;

/**
 * Created by lenovo on 2017/4/7.
 */

public class PandaLiveBqPresenterImpl implements LiveContract.Presenter, MyCallback<PandaLiveBqBean> {

    private PandaLiveFragment pandaLiveFragment;
    private IPandaLiveModel pandaLiveModel;

    public PandaLiveBqPresenterImpl(Context context) {

        pandaLiveModel = new PandaLiveModelImpl();

        pandaLiveFragment = new PandaLiveFragment();
    }

    @Override
    public void onSuccess(PandaLiveBqBean pandaLiveBqBean) {

        pandaLiveFragment.loadTab2(pandaLiveBqBean);
    }

    @Override
    public void onError(String msg) {

        Log.i("aaa", "000");
    }

    @Override
    public <T> void getTabTitle(String url, Map<String, String> params, MyCallback<T> callback) {

        pandaLiveModel.getTabTitle(url, params, callback);
    }


    /**
     * 加载数据
     */
    @Override
    public <T> void getData() {

    }


    @Override
    public <T> void getData(String url, Map<String, String> params, MyCallback<T> callback) {

        pandaLiveModel.getData(url, params, callback);
    }

    /**
     * 标题详情页
     *
     */

    @Override
    public <T> void getLiveFragment(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getEyeFragment(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    /**
     * 多视角直播
     *
     * @param url
     * @param params
     * @param callback
     * @param <T>
     */
    /**
     * 边看边聊
     *
     * @param url
     * @param params
     * @param callback
     * @param <T>
     */

    /**
     * 显示图片
     *
     * @param url
     * @param <T>
     */
    @Override
    public <T> void showImage(String url) {

    }

    @Override
    public <T> void getLiveTitle(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getEyeTitle(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    /**
     * 显示标题
     *
     * @param title
     * @param <T>
     */
    @Override
    public <T> void getTitle(String title) {


    }

    /**
     * 显示详细信息
     */
    @Override
    public <T> void showDetailInfo(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getInfo(String url, Map<String, String> params, MyCallback<T> callback) {

    }
}
