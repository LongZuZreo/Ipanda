package cctv.cn.ipanda.contract;

import java.util.Map;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.pandalive.PandaLiveBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveDuoshijiaoBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveJcyiBean;

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
        void showDetail(PandaLiveBean pandaLiveBean);

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
         * 多视角直播
         */
        void showLiveFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean);

        /**
         * 多视角直播标题
         */
        void showLiveTitle();

        /**
         * 边看边聊
         */
        void showEyeFragment(PandaLiveDuoshijiaoBean pandaLiveDuoshijiaoBean);

        /**
         * 边看边聊标题
         */
        void showEyeTitle();

        /**
         * 精彩一刻
         */
        void showJcyk(PandaLiveJcyiBean pandaLiveJcyiBean);

        /**
         * 加载Tab标题
         */
        void loadTab2(PandaLiveBqBean pandaLiveBqBean);
    }

    interface Presenter extends BasePresenter {

        <T> void getTabTitle(String url, Map<String, String> params, MyCallback<T> callback);

        <T> void getData();

        <T> void getData(String url, Map<String, String> params, MyCallback<T> callback);

        <T> void showImage(String url);

        //多视角直播标题
        <T> void getLiveTitle(String url, Map<String, String> params, MyCallback<T> callback);

        //边看边聊标题
        <T> void getEyeTitle(String url, Map<String, String> params, MyCallback<T> callback);

        <T> void getTitle(String title);

        <T> void showDetailInfo(String url, Map<String, String> params, MyCallback<T> callback);

        //标题详情页
        <T> void getInfo(String url, Map<String, String> params, MyCallback<T> callback);

        //多视角直播
        <T> void getLiveFragment(String url, Map<String, String> params, MyCallback<T> callback);

        //边看边聊
        <T> void getEyeFragment(String url, Map<String, String> params, MyCallback<T> callback);
    }
}
