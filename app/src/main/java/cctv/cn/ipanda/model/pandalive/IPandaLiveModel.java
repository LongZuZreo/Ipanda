package cctv.cn.ipanda.model.pandalive;

import java.util.Map;

import cctv.cn.ipanda.model.http.BaseModel;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.http.pandalive.PandaLiveBqBean;

/**
 * Created by lenovo on 2017/4/7.
 */

public interface IPandaLiveModel extends BaseModel {

    //标题栏
    <T> void getTabTitle(String url, Map<String, String> params, MyCallback<T> callback);

    //加载数据
    <T> void getData(String url, Map<String, String> params, MyCallback<T> callback);

    //显示图片
    <T> void showImage(String url, Map<String, String> params, MyCallback<T> callback);

    //大标题
    <T> void gettitle(String url, Map<String, String> params, MyCallback<T> callback);

    //详细信息
    <T> void getDetailInfo(String url, Map<String, String> params, MyCallback<T> callback);
}
