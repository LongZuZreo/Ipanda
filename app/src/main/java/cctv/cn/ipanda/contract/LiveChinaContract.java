package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;

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
        void loadTab();
    }

    interface Presenter extends BasePresenter{

    }
}
