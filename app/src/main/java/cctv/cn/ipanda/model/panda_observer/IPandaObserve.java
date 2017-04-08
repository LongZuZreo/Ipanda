package cctv.cn.ipanda.model.panda_observer;

import cctv.cn.ipanda.model.BaseModel;
import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by hp1 on 2017-04-07.
 */

public interface IPandaObserve extends BaseModel {
    void getPandaObserveHead(String url, MyCallback callback);
    void getPandaObserveItem(String url, MyCallback callback);
}
