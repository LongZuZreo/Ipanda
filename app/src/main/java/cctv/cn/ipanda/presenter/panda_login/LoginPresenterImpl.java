package cctv.cn.ipanda.presenter.panda_login;

import java.util.HashMap;
import java.util.Map;

import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LoginContract;
import cctv.cn.ipanda.model.db.db_dao.LoginEntityDb;
import cctv.cn.ipanda.model.db.db_manager.DbManager;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.panda_login.LoginEntity;
import cctv.cn.ipanda.model.panda_login.LoginModel;
import cctv.cn.ipanda.model.panda_login.LoginModelImpl;

/**
 * Created by 张志远 on 2017/4/13.
 */

public class LoginPresenterImpl implements LoginContract.Presenter {

    private LoginContract.View view;

    private LoginModel loginModel;
    private final DbManager dbManager;

    public LoginPresenterImpl(LoginContract.View view) {
        this.view=view;
        loginModel=new LoginModelImpl();
        dbManager = new DbManager(App.context);
    }


    @Override
    public void login(String userName,String password) {

        Map<String,String> params=new HashMap<>();

        params.put("from", Urls.LOGIN_URL);
        params.put("service", "client_transaction");
        params.put("username", userName);
        params.put("password", password);

        Map<String,String> headers=new HashMap<>();

        headers.put("Referer",Urls.LOGIN_URL);

        headers.put("User-Agent","CNTV_APP_CLIENT_CYNTV_MOBILE");

        loginModel.login(Urls.LOGIN_URL, params, headers, new MyCallback<LoginEntity>() {
            @Override
            public void onSuccess(LoginEntity entity) {

                if (entity.getErrType().equals("0")){
                    LoginEntityDb loginEntityDb=new LoginEntityDb(null,entity.getTimestamp(),entity.getTicket(),entity.getErrType(),entity.getErrMsg(),entity.getUserSeqId(),entity.getUsrid());

                    dbManager.insertData(loginEntityDb);

                    view.loginSuccess(entity);
                }else{
                    view.loginFail(entity.getErrMsg());
                }

            }

            @Override
            public void onError(String msg) {
                view.loginFail(msg);
            }
        });
    }
}
