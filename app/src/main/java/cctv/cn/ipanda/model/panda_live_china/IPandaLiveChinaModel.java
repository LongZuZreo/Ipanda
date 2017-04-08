package cctv.cn.ipanda.model.panda_live_china;

import java.util.Map;

import cctv.cn.ipanda.model.BaseModel;
import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by 张志远 on 2017/4/8.
 */

public interface IPandaLiveChinaModel extends BaseModel {

    void getAllTab(String url, Map<String,String> params, MyCallback<IPandaLiveChinaTabEntity> myCallback);
    void getVideoList(String url, Map<String,String> params, MyCallback<IPandaLiveChinaListEntity> myCallback);
}
