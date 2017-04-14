package cctv.cn.ipanda.contract;

import cctv.cn.ipanda.base.BasePresenter;
import cctv.cn.ipanda.base.BaseView;
import cctv.cn.ipanda.model.panada_hdjh.PanadaInterfactionBean;
import cctv.cn.ipanda.model.panada_home.CctvAgainBean;
import cctv.cn.ipanda.model.panada_home.PanadaChinaListBean;
import cctv.cn.ipanda.model.panada_home.PanadaEyesBean;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;
import cctv.cn.ipanda.model.panada_home.UpdateBean;

/**
 * Created by 张志远 on 2017/4/6.
 */

public interface HomeContract {

    interface View extends BaseView{



        /**
         * 跳转到详情页
         */

        void loadDetail(PanadaHomeBean bean);
        //CCTV
        void loadCcctv(CctvAgainBean cctvAgainBean);
        //光影中国
        void loadListBean(PanadaChinaListBean panadaChinaListBean);
        //互动集合
        void loadInteractionBean(PanadaInterfactionBean panadaInterfactionBean);
        //获取版本号
        void getVersion(UpdateBean updateBean);
        //熊猫观察List
        void getPanadaEyesList(PanadaEyesBean panadaEyesBean);
    }

    interface Presenter extends BasePresenter{
        void getAllList(String url);
    }
}
