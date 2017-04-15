package cctv.cn.ipanda.model.panda_register;

import java.util.Map;

import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by 张志远 on 2017/4/14.
 */

public class RegisterModelImpl implements RegisterModel {
    @Override
    public <T> void register(String url, Map<String, String> params, MyCallback<T> myCallback, Map<String, String> headers) {
        retrofitUtils.getDatawithHeader(url,params,myCallback,headers);
    }
}
