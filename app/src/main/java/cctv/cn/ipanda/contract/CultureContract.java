package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;
import cctv.cn.ipanda.model.panda_culture.PandaCultureEntity;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface CultureContract {

    interface View extends BaseView{


        void showAll(PandaCultureEntity entity);

    }
    interface Presenter extends BasePresenter{
        void getDataAll();
    }
}
