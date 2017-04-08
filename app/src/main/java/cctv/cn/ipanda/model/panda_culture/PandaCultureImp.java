package cctv.cn.ipanda.model.panda_culture;

import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by hp1 on 2017-04-07.
 */

public class PandaCultureImp implements IPandaCulture {
    @Override
    public void getPandaCultureHead(String url, MyCallback myCallback) {
        retrofitUtils.getData(url,null,myCallback);
    }

    @Override
    public void getPandaCultureItem(String url, MyCallback myCallback) {
        retrofitUtils.getData(url,null,myCallback);
    }
}
