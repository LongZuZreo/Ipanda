package cctv.cn.ipanda.contract;

import java.util.Map;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;
import cctv.cn.ipanda.model.http.MyCallback;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface LiveContract {

    interface View extends BaseView {
        /**
         * 通过点击tab转到其他列表
         */
        void clickTabToOtherList();

        /**
         * 详情内容的显示
         */
        void showDetail();

        /**
         * 详情内容页取消显示
         */
        void dismissDetail();

        /**
         * 论坛评论列表消息发送成功
         */
        void sendMessageSuccess();

        /**
         * 论坛消息列表的加载
         */
        void addMessageSuccess();

        /**
         * 点击tab跳转到首页fragment内的首页
         */
        void clickTabtoHome();

        /**
         * 加载Tab标题
         */
        void loadTab();
    }

    interface Presenter extends BasePresenter {

        <T> void getTabTitle(String url, Map<String, String> params, MyCallback<T> callback);

        <T> void getData(String url, Map<String, String> params, MyCallback<T> callback);

        <T> void showImage(String url);

        <T> void getTitle(String title);

        <T> void showDetailInfo(String info);
    }
}
