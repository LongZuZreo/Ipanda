package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;
import cctv.cn.ipanda.model.panda_observer.PandaObserverHeadEntity;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface ObserverContract {

    interface View extends BaseView{
        void getHeadData(PandaObserverHeadEntity entity);
        void getItemData();
    }
    interface Presenter extends BasePresenter{
        void getHead();
        void getItem();
    }

}
