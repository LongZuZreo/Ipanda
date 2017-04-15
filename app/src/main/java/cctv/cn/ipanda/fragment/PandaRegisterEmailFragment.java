package cctv.cn.ipanda.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.LiveChinaContract;
import cctv.cn.ipanda.contract.RegisterContract;
import cctv.cn.ipanda.presenter.panda_register.PresenterImpl;

/**
 * Created by 张志远 on 2017/4/13.
 */

public class PandaRegisterEmailFragment extends BaseFragment implements RegisterContract.View{

    private EditText editUserPhone;
    private EditText checkCodeEdit;
    private EditText newPasswordEdit;
    private EditText newCheckPasswordEdit;
    private Button registerBtn;
    private ImageView checkCodeImage;

    public static final int SEND_CHECK_CODE=123;
    private String cookie;
    private RegisterContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_email_register;
    }

    @Override
    protected void loadData(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    URL url=new URL(Urls.IMAGE_CODE);

                    HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();

                    httpURLConnection.setRequestMethod("POST");

                    httpURLConnection.setConnectTimeout(10000);

                    httpURLConnection.setReadTimeout(10000);

                    httpURLConnection.setDoOutput(true);

                    httpURLConnection.setDoInput(true);

                    httpURLConnection.connect();

                    InputStream inputStream=httpURLConnection.getInputStream();

                    Bitmap bitmap= BitmapFactory.decodeStream(inputStream);

                    Message msg=new Message();

                    msg.what=SEND_CHECK_CODE;

                    Map checkCodeMap=new HashMap();

                    checkCodeMap.put("bitmap",bitmap);

                    checkCodeMap.put("cookie",cookie);

                    msg.obj=bitmap;

                    handler.sendMessage(msg);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }


    Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){

                case SEND_CHECK_CODE:
                    Map map = (Map) msg.obj;

                    cookie = (String) map.get("cookie");

                    Bitmap bitmap= (Bitmap) map.get("bitmap");
                    checkCodeImage.setImageBitmap(bitmap);
                    break;
            }
        }
    };

    @Override
    protected void initData() {
        presenter = new PresenterImpl(this);
    }

    @Override
    protected void initView(View view) {

        editUserPhone = (EditText) view.findViewById(R.id.editUserPhone);

        checkCodeEdit = (EditText) view.findViewById(R.id.checkCodeEdit);

        newPasswordEdit = (EditText)view.findViewById(R.id.newPasswordEdit);

        newCheckPasswordEdit = (EditText)view.findViewById(R.id.newCheckPasswordEdit);

        registerBtn = (Button) view.findViewById(R.id.findPwdBtn);

        checkCodeImage = (ImageView)view.findViewById(R.id.checkCodeImage);
    }

    @Override
    protected void initListener() {

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editUserPhone.getText().toString().equals("") || newPasswordEdit.toString().equals("") || newCheckPasswordEdit.toString().equals("")){

                    Toast.makeText(App.context, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();

                }else {
                    if (checkCodeEdit.getText().toString().equals("")) {
                        Toast.makeText(App.context, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    }else {
                        if (newPasswordEdit.getText().toString().equals(newCheckPasswordEdit.getText().toString())){
                            if (editUserPhone.getText().toString().matches("^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$")) {

                                presenter.register(editUserPhone.getText().toString(),newPasswordEdit.getText().toString(),checkCodeEdit.getText().toString(),cookie);

                            } else {
                                Toast.makeText(App.context, "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(App.context, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });

    }

    @Override
    protected void show() {

    }

    @Override
    protected void hide() {

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
    public void onRegisterSuccess() {

    }

    @Override
    public void onRegisterError() {

    }
}
