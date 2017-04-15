package cctv.cn.ipanda.presenter.panda_live;

import java.util.HashMap;
import java.util.Map;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LiveContract;
import cctv.cn.ipanda.fragment.PandaLiveEyeFragment;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.IPandaLiveModel;
import cctv.cn.ipanda.model.pandalive.PandaLiveModelImpl;
import cctv.cn.ipanda.model.pandalive.PandaLiveTalkListBean;

/**
 * Created by lenovo on 2017/4/13.
 */

public class PandaLiveTalkPersenterImpl implements LiveContract.Presenter, MyCallback<PandaLiveTalkListBean.DataBean> {

    private PandaLiveEyeFragment pandaLiveEyeFragment;
    private IPandaLiveModel pandaLiveModel;

    public PandaLiveTalkPersenterImpl(LiveContract.View view) {

        pandaLiveModel = new PandaLiveModelImpl();

        pandaLiveEyeFragment = (PandaLiveEyeFragment) view;
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

    }

    @Override
    public <T> void getLiveFragment(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getEyeFragment(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public <T> void getTalkList() {

        Map<String, String> params = new HashMap<>();
        params.put("app", "ipandaApp");
        params.put("itemid", "zhiboye_chat");
        params.put("nature", "1");
        params.put("page", "1");
        pandaLiveModel.getTalkList(Urls.TALKLIST, params, new MyCallback<PandaLiveTalkListBean>() {
            @Override
            public void onSuccess(PandaLiveTalkListBean pandaLiveTalkListBean) {

                if (pandaLiveTalkListBean != null) {

                    pandaLiveEyeFragment.showTalkList(pandaLiveTalkListBean);
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Override
    public <T> void vadioPlay(String url, Map<String, String> params, MyCallback<T> callback) {

    }

    @Override
    public void onSuccess(PandaLiveTalkListBean.DataBean dataBean) {

    }

    @Override
    public void onError(String msg) {

    }
}
