package cctv.cn.ipanda.presenter.panda_live;

import android.content.Context;

import java.util.Map;

import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.IPandaLiveModel;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveModelImpl;

/**
 * Created by lenovo on 2017/4/7.
 */

public class PandaLivePresenterImpl implements LiveContract.Presenter, MyCallback<PandaLiveBqBean> {

    private LiveContract.View pandaLiveFragment;
    private IPandaLiveModel pandaLiveModel;

    public PandaLivePresenterImpl(Context context) {

        pandaLiveModel = new PandaLiveModelImpl();
        if (context instanceof LiveContract.View) {
            pandaLiveFragment = (LiveContract.View) context;
        }
    }

    @Override
    public void onSuccess(PandaLiveBqBean pandaLiveBqBean) {

        pandaLiveFragment.loadTab();
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public <T> void getTabTitle(String url, Map<String, String> params, MyCallback<T> callback) {

        pandaLiveModel.getTabTitle(url, params, callback);
    }

    /**
     * 加载数据
     */
    @Override
    public <T> void getData(String url, Map<String, String> params, MyCallback<T> callback) {

        pandaLiveModel.getData(url, params, callback);
    }

    /**
     * 显示图片
     *
     * @param url
     * @param <T>
     */
    @Override
    public <T> void showImage(String url) {

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
     *
     * @param info
     * @param <T>
     */
    @Override
    public <T> void showDetailInfo(String info) {

    }
}
