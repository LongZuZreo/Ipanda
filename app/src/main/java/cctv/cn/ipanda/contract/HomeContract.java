package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface HomeContract {

    interface View extends BaseView{

        /**
         * 填充轮播图图片
         */
        void toBanner();

        /**
         * 跳转到详情页
         */
        void toDetail();
    }

    interface Presenter extends BasePresenter{

    }
}
