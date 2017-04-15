package cctv.cn.ipanda.model.panda_register;

import java.util.Map;

import cctv.cn.ipanda.model.BaseModel;
import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by 张志远 on 2017/4/14.
 */

public interface RegisterModel extends BaseModel {

    <T>void register(String url, Map<String,String> params, MyCallback<T> myCallback,Map<String,String> headers);
}
