package cctv.cn.ipanda.presenter.panda_register;

import java.util.HashMap;
import java.util.Map;

import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LoginContract;
import cctv.cn.ipanda.contract.RegisterContract;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.panda_register.RegisterEntity;
import cctv.cn.ipanda.model.panda_register.RegisterModel;
import cctv.cn.ipanda.model.panda_register.RegisterModelImpl;

/**
 * Created by 张志远 on 2017/4/14.
 */

public class PresenterImpl implements RegisterContract.Presenter {

    private RegisterContract.View view;

    private RegisterModel registerModel;
    public PresenterImpl(RegisterContract.View view) {
        this.view=view;
        registerModel=new RegisterModelImpl();
    }

    @Override
    public void register(String userName, String password, String checkCode,String Cookie) {

        Map<String,String> params=new HashMap<>();

        params.put("mailAdd",userName);

        params.put("passWd",password);

        params.put("verificationCode",checkCode);

        params.put("addons","IPanda.Android");

        Map<String,String> headers=new HashMap<>();

        headers.put("Referer","iPanda.Android");

        headers.put("User-Agent","CNTV_APP_CLIENT_CNTV_MOBILE");

        headers.put("Cookie",Cookie);

        registerModel.register(Urls.REGISTER_URL, params, new MyCallback<RegisterEntity>() {
            @Override
            public void onSuccess(RegisterEntity registerEntity) {

             RegisterEntity registerEntity1=registerEntity;

            }

            @Override
            public void onError(String msg) {
                view.onRegisterError();
            }
        },headers);
    }
}
