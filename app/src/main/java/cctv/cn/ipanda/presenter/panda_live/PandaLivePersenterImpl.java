package cctv.cn.ipanda.presenter.panda_live;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Map;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.fragment.LiveFragment;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.IPandaLiveModel;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveModelImpl;

/**
 * Created by lenovo on 2017/4/8.
 */

public class PandaLivePersenterImpl implements LiveContract.Presenter, MyCallback<PandaLiveBean> {

    private List<PandaLiveBean.BookmarkBean.MultipleBean> multiple;
    private List<PandaLiveBean.BookmarkBean.WatchTalkBean> watchTalk;
    public static PandaLiveBean.LiveBean liveBean;
    private LiveContract.View liveFragment;
    private IPandaLiveModel pandaLiveModel;

    public PandaLivePersenterImpl(LiveContract.View view) {

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
                    liveFragment.showLiveTitle();
                    liveFragment.showEyeTitle();
                    liveFragment.dismissDetail();
                    liveFragment.clickTabToOtherList();
                }
            }

            @Override
            public void onError(String msg) {

                Log.i("0000", msg);
            }
        });

    }

    @Override
    public <T> void getData(String url, Map<String, String> params, MyCallback<T> callback) {

        pandaLiveModel.getData(url, params, callback);
    }

    /**
     * 标题详情页
     *
     * @param url
     * @param params
     * @param callback
     * @param <T>
     */
    @Override
    public <T> void getInfo(String url, Map<String, String> params, MyCallback<T> callback) {


    }

    /**
     * 多视角直播
     */
    @Override
    public <T> void getLiveFragment(String url, Map<String, String> params, MyCallback<T> callback) {

//        pandaLiveModel.getLiveFragment();
    }

    /**
     * 边看边聊
     */
    @Override
    public <T> void getEyeFragment(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void showImage(String url) {

    }

    /**
     * 多视角直播标题
     */
    @Override
    public <T> void getLiveTitle(String url, Map<String, String> params, MyCallback<T> callback) {

        pandaLiveModel.getLiveTitle(url, params, callback);
    }

    /**
     * 边看边聊标题
     */
    @Override
    public <T> void getEyeTitle(String url, Map<String, String> params, MyCallback<T> callback) {

        pandaLiveModel.getEyeTitle(url, params, callback);
    }

    @Override
    public <T> void getTitle(String title) {

    }

    @Override
    public <T> void showDetailInfo(String url, Map<String, String> params, MyCallback<T> callback) {

        pandaLiveModel.getDetailInfo(url, params, callback);
    }

    @Override
    public void onSuccess(PandaLiveBean pandaLiveBean) {
/*
        liveFragment.showDetail(pandaLiveBean);
        liveFragment.showLiveTitle();
        liveFragment.showEyeTitle();*/
    }

    @Override
    public void onError(String msg) {

    }
}
