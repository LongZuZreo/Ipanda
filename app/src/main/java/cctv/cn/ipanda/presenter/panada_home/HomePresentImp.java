package cctv.cn.ipanda.presenter.panada_home;

import java.util.HashMap;
import java.util.Map;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.HomeContract;
import cctv.cn.ipanda.fragment.PanadaHomeFragment;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.http.RetrofitUtils;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;


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
}
