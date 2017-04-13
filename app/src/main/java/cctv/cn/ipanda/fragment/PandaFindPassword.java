package cctv.cn.ipanda.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;

/**
 * Created by 张志远 on 2017/4/13.
 */

public class PandaFindPassword extends BaseFragment {

    private EditText editUserPhone;
    private EditText checkCodeEdit;
    private EditText phoneCheckCode;
    private EditText newPasswordEdit;
    private Button findPwdBtn;
    private Button phoneCheckCodeBtn;
    private ImageView checkCodeImage;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_phone_find_pwd;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

        editUserPhone = (EditText) view.findViewById(R.id.editUserPhone);

        checkCodeEdit = (EditText)view.findViewById(R.id.checkCodeEdit);

        phoneCheckCode = (EditText)view.findViewById(R.id.phoneCheckCode);

        newPasswordEdit = (EditText)view.findViewById(R.id.newPasswordEdit);

        findPwdBtn = (Button) view.findViewById(R.id.findPwdBtn);

        phoneCheckCodeBtn = (Button)view.findViewById(R.id.phoneCheckCodeBtn);

        checkCodeImage = (ImageView) view.findViewById(R.id.checkCodeImage);
    }

    @Override
    protected void initListener() {

    }
}
