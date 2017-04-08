package cctv.cn.ipanda.model.panda_culture;

import cctv.cn.ipanda.model.BaseModel;
import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by hp1 on 2017-04-07.
 */

public interface IPandaCulture extends BaseModel {
    void getPandaCultureHead(String url, MyCallback myCallback);
    void getPandaCultureItem(String url, MyCallback myCallback);
}
