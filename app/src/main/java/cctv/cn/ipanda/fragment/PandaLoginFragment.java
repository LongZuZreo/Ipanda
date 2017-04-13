package cctv.cn.ipanda.fragment;

import android.graphics.Paint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.base.BaseActivity;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.contract.LoginContract;
import cctv.cn.ipanda.model.panda_login.LoginEntity;
import cctv.cn.ipanda.presenter.panda_login.LoginPresenterImpl;

/**
 * Created by 张志远 on 2017/4/13.
 */

public class PandaLoginFragment extends BaseFragment implements View.OnClickListener,LoginContract.View{

    private TextView textView;
    private EditText editUserName;
    private EditText editUserPassWord;
    private Button loginBtn;
    private PandaFindPassword pandaFindPassword;
    private LoginContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void loadData() {
    }

    @Override
    protected void initData() {
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void initView(View view) {
        textView = (TextView) view.findViewById(R.id.forget_password);

        textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        textView.getPaint().setAntiAlias(true);

        editUserName = (EditText) view.findViewById(R.id.editUserName);

        editUserPassWord = (EditText)view.findViewById(R.id.editUserPassword);

        loginBtn = (Button) view.findViewById(R.id.loginBtn);
    }

    @Override
    protected void initListener() {

        textView.setOnClickListener(this);

        loginBtn.setOnClickListener(this);

        pandaFindPassword = new PandaFindPassword();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forget_password:
                ((MainActivity)getActivity()).changeFragment(pandaFindPassword,null,true);
                break;
            case R.id.loginBtn:
                presenter.login(editUserName.getText().toString(),editUserPassWord.getText().toString());
                break;

        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismiss() {

    }

    @Override
    public void loadError() {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void toPersonCenter() {

    }

    @Override
    public void toVideoPlay() {

    }

    @Override
    public void changeTitleBar() {

    }

    @Override
    public void loginSuccess(LoginEntity entity) {

       getActivity().getSupportFragmentManager().popBackStack();

    }


    @Override
    public void loginFail(String failMsg) {
        Toast.makeText(getActivity(), failMsg, Toast.LENGTH_SHORT).show();
    }
}
