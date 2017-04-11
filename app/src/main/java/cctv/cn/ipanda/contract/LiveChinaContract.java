package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaListEntity;
import cctv.cn.ipanda.model.panda_live_china.IPandaLiveChinaTabEntity;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface LiveChinaContract {

    interface View extends BaseView{
        /**
         *弹出tab栏编辑的popupwindow
         */
        void toTabPopupWindow();

        /**
         * 点击tab跳转到其他列表页
         */
        void toOtherTab();

        /**
         * 加载tab栏
         */
        void loadTab(IPandaLiveChinaTabEntity iPandaLiveChinaTabEntity);

        /**
         * 加载List列表
         */
        void loadList(IPandaLiveChinaListEntity iPandaLiveChinaListEntity);
    }

    interface Presenter extends BasePresenter{

        /**
         * 加载所有Tab
         */
        void getAllTab();

        /**
         * 加载List列表
         */
        void getVideoList(String url);
    }
}
