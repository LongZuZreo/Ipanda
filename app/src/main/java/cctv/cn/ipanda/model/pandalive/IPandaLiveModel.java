package cctv.cn.ipanda.model.pandalive;

import java.util.Map;

import cctv.cn.ipanda.model.BaseModel;
import cctv.cn.ipanda.model.http.MyCallback;

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

    //多视角直播
    <T> void getLiveTitle(String url, Map<String, String> params, MyCallback<T> callback);

    //边看边聊直播
    <T> void getEyeTitle(String url, Map<String, String> params, MyCallback<T> callback);

    //多视角
    <T> void getLiveFragment(String url, Map<String, String> params, MyCallback<T> callback);

    //边看边聊
    <T> void getEyeFragment(String url, Map<String, String> params, MyCallback<T> callback);

    //精彩一刻
    <T> void getJcyk(String url, Map<String, String> params, MyCallback<T> callback);

    //边看边聊列表
    <T> void getTalkList(String url, Map<String, String> params, MyCallback<T> callback);
}
