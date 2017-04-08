package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface HomeContract {

    interface View extends BaseView{



        /**
         * 跳转到详情页
         */

        void loadDetail(PanadaHomeBean bean);
    }

    interface Presenter extends BasePresenter{
        void getAllList(String url);
    }
}
