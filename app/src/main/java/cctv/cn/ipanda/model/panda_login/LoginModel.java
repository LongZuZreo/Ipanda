package cctv.cn.ipanda.model.panda_login;

import java.util.Map;

import cctv.cn.ipanda.model.BaseModel;
import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by 张志远 on 2017/4/13.
 */

public interface LoginModel extends BaseModel {

    <T>void login(String url, Map<String,String> params,Map<String,String> headers, MyCallback<T> myCallback);
}
