package cctv.cn.ipanda.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;

/**
 * Created by lenovo on 2017/4/12.
 */

public class PersonInfoFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout panda_person_img;
    private RelativeLayout panda_person_nicheng;
    private View view;
    private Button photos;
    private Button cancle;
    private Button camera;
    private PopupWindow popupWindow;

    @Override
    protected int getLayoutId() {

        return R.layout.panda_person_personinfo;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initData() {

        view = LayoutInflater.from(App.context).inflate(R.layout.person_info__photo_view, null);

        photos = (Button) view.findViewById(R.id.photosBtn);
        camera = (Button) view.findViewById(R.id.cameraBtn);
        cancle = (Button) view.findViewById(R.id.cancleBtn);
    }

    @Override
    protected void initView(View view) {

        panda_person_img = (RelativeLayout) view.findViewById(R.id.panda_person_img);
        panda_person_nicheng = (RelativeLayout) view.findViewById(R.id.panda_person_nicheng);
    }

    @Override
    protected void initListener() {

        panda_person_img.setOnClickListener(this);
        panda_person_nicheng.setOnClickListener(this);
        photos.setOnClickListener(this);
        camera.setOnClickListener(this);
        cancle.setOnClickListener(this);
    }

    @Override
    protected void show() {
        MainActivity.currentFragment=this;
    }

    @Override
    protected void hide() {

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.panda_person_img:

                showPopupWindow();
                break;
            case R.id.panda_person_nicheng:

                break;
            case R.id.photosBtn:

                dismiss();
                openPhotos();
                break;
            case R.id.cameraBtn:

                openCamera();

                break;
            case R.id.cancleBtn:
                dismiss();
                break;
        }
    }


    /**
     * 打开系统相机
     */
    private void openCamera() {
        Intent intent = new Intent(); //调用照相机
        intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
        startActivity(intent);
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    /**
     * 显示popupWindow
     */
    private void showPopupWindow() {

        popupWindow = new PopupWindow(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);

        popupWindow.setContentView(view);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //外部点击
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    /**
     * 打开裁剪框
     *
     * @param uri
     */
    private void openCrop(Uri uri) {

        Intent intent = new Intent("com.android.camera.action.CROP");

        intent.setDataAndType(uri, "image/*");

        intent.putExtra("crop", true);

        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
//        intent.putExtra("output", Uri.fromFile(file));

        startActivityForResult(intent, 200);
    }

    /**
     * 打开相册
     */
    private void openPhotos() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 100);
    }

    /**
     * 关闭popupWindow
     */
    private void dismiss() {

        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }

    }
}
