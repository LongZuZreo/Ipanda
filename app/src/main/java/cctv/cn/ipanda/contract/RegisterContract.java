package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;

/**
 * Created by 张志远 on 2017/4/14.
 */

public interface RegisterContract {

    interface View extends BaseView{
        void onRegisterSuccess();
        void onRegisterError();
    }

    interface Presenter extends BasePresenter{

        void register(String userName,String password,String checkCode,String Cookie);
    }
}
