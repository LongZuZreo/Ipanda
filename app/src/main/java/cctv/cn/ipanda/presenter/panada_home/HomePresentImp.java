package cctv.cn.ipanda.presenter.panada_home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.HomeContract;
import cctv.cn.ipanda.fragment.PanadaHomeFragment;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.http.RetrofitUtils;
import cctv.cn.ipanda.model.panada_hdjh.PanadaInterfactionBean;
import cctv.cn.ipanda.model.panada_home.CctvAgainBean;
import cctv.cn.ipanda.model.panada_home.PanadaChinaListBean;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;
import cctv.cn.ipanda.model.panada_home.UpdateBean;


/**
 * Created by ASUS on 2017/4/7.
 */

public class HomePresentImp implements HomeContract.Presenter{

    private HomeContract.View view;
    private final RetrofitUtils retrofitUtils;

    public HomePresentImp(HomeContract.View view){
        this.view = view;
        retrofitUtils = RetrofitUtils.getInstance();
    }


    @Override
    public void getAllList(String url) {

        Map<String,String> params = new HashMap<>();
        retrofitUtils.getData(Urls.HOME_URL, params, new MyCallback<PanadaHomeBean>() {
            @Override
            public void onSuccess(PanadaHomeBean bean) {
               view.loadDetail(bean);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
    //CCTV再一次发送网络请求
    public void getCctv(String url){
        Map<String,String> params = new HashMap<>();
        retrofitUtils.getData(url, params, new MyCallback<CctvAgainBean>() {
            @Override
            public void onSuccess(CctvAgainBean cctvAgainBean) {
                view.loadCcctv(cctvAgainBean);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
    //光影中国发送二次请求
    public void getListBean(String url){
        Map<String,String> params = new HashMap<>();
        retrofitUtils.getData(url, params, new MyCallback<PanadaChinaListBean>() {
            @Override
            public void onSuccess(PanadaChinaListBean panadaChinaListBean) {
                List<PanadaChinaListBean.ListBean> list = panadaChinaListBean.getList();
                view.loadListBean(panadaChinaListBean);
            }

            @Override
            public void onError(String msg) {
                msg.toString();
            }
        });
    }
    //互动集合
    public void getHdjh(String url){
        retrofitUtils.getData(url, null, new MyCallback<PanadaInterfactionBean>() {
            @Override
            public void onSuccess(PanadaInterfactionBean panadaInterfactionBean) {
                view.loadInteractionBean(panadaInterfactionBean);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
    //获取版本号
    public void getVersion(String url){
        retrofitUtils.getData(url, null, new MyCallback<UpdateBean>() {
            @Override
            public void onSuccess(UpdateBean updateBean) {
                view.getVersion(updateBean);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
