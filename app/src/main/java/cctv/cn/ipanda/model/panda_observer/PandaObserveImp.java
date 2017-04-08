package cctv.cn.ipanda.model.panda_observer;

import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by hp1 on 2017-04-07.
 */

public class PandaObserveImp implements IPandaObserve{
    @Override
    public void getPandaObserveHead(String url, MyCallback callback) {
        retrofitUtils.getData(url,null,callback);
    }

    @Override
    public void getPandaObserveItem(String url, MyCallback callback) {
        retrofitUtils.getData(url,null,callback);
    }
}
