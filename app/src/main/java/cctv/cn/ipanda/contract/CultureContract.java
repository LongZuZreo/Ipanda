package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface CultureContract {

    interface View extends BaseView{

        /**
         * 填充轮播图图片
         */
        void getBanner();
        void getItem();
    }
    interface Presenter extends BasePresenter{
        void getItem();
    }
}
