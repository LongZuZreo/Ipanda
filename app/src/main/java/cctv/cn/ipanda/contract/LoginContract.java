package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;
import cctv.cn.ipanda.model.panda_login.LoginEntity;
import cctv.cn.ipanda.model.panda_observer.PandaObserveItemEntity;
import cctv.cn.ipanda.model.panda_observer.PandaObserverHeadEntity;

/**
 * Created by 张志远 on 2017/4/13.
 */

public interface LoginContract {
    interface View extends BaseView {
        void loginSuccess(LoginEntity entity);

        void loginFail(String failMsg);
    }
    interface Presenter extends BasePresenter {

        void login(String userName,String password);
    }

}
