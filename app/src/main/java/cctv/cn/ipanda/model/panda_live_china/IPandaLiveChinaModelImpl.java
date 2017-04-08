package cctv.cn.ipanda.model.panda_live_china;

import java.util.Map;

import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by 张志远 on 2017/4/8.
 */

public class IPandaLiveChinaModelImpl implements IPandaLiveChinaModel{


    @Override
    public void getAllTab(String url, Map<String, String> params, MyCallback<IPandaLiveChinaTabEntity> myCallback) {
        retrofitUtils.getData(url,params,myCallback);
    }

    @Override
    public void getVideoList(String url, Map<String, String> params, MyCallback<IPandaLiveChinaListEntity> myCallback) {
        retrofitUtils.getData(url,params,myCallback);
    }
}
