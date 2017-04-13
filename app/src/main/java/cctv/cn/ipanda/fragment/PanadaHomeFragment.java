package cctv.cn.ipanda.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.MainActivity;
import cctv.cn.ipanda.adapter.RecycleViewAdapter;
import cctv.cn.ipanda.adapter.banner.MyBannerAdapter;
import cctv.cn.ipanda.base.BaseFragment;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.contract.HomeContract;
import cctv.cn.ipanda.model.panada_hdjh.PanadaInterfactionBean;
import cctv.cn.ipanda.model.panada_home.CctvAgainBean;
import cctv.cn.ipanda.model.panada_home.PanadaChinaListBean;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;
import cctv.cn.ipanda.model.panada_home.UpdateBean;
import cctv.cn.ipanda.model.panda_culture.PandaCultureEntity;
import cctv.cn.ipanda.presenter.panada_home.HomePresentImp;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by ASUS on 2017/4/7.
 */

public class PanadaHomeFragment extends BaseFragment implements HomeContract.View{


    private List<Object> list;
    private HomePresentImp presentImp;
    private RecycleViewAdapter adapter;
    private PanadaHomeBean panadaHomeBean;
    private ViewPager mViewPager;
    private List<ImageView> imageList;
    private MyBannerAdapter bannerAdapter;
    private List<PanadaHomeBean.DataBean> bigImgBeenList;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private String listurl;
    private String listUrl1;
    private static int versionCode;
    private AlertDialog alertDialog;
    private int imageChage = 1000;
    private PandaWebView pandaWebView;
    int total=0;
    private String versionsUrl;

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_panada_home;
    }

    @Override
    protected void loadData() {
        presentImp.getAllList(Urls.HOME_URL);
    }
    //获取当前版本
    @Override
    protected void initData() {
        pandaWebView = new PandaWebView();
        getAppVersionName(getActivity());
    }
    public static String getAppVersionName(Context context) {
        String versionName = "";

        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            //versioncode = pi.versionCode;
            versionCode = pi.versionCode;
            Log.i("aaa", versionCode +"");
            if (versionName == null || versionName.length() <= 0) {
                return"";
            }
        } catch (Exception e) {
            Log.i("aaa",versionName);
        }
        return versionName;

    }
        //发送网络请求获取最新版本号
        public void getVersion(){
            presentImp.getVersion(Urls.UPDATE_URL);
        }
    @Override
    public void getVersion(UpdateBean updateBean) {
        String versionsNum = updateBean.getData().getVersionsNum();
        versionsUrl = updateBean.getData().getVersionsUrl();
        int versionsInt = Integer.parseInt(versionsNum);
        if(versionCode<versionsInt){
            getShowDialog();
        }else{
            Toast.makeText(getActivity(),"已经是最新版本",Toast.LENGTH_LONG).show();
        }

    }
    public void getShowDialog() {
        new AlertDialog.Builder(getActivity()).setTitle("版本升级")//设置对话框标题

                .setMessage("检测到最新版本，新版本对系统做了更好的优化")//设置显示的内容

                .setPositiveButton("立即跟新",new DialogInterface.OnClickListener() {//添加确定按钮



                    @Override

                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                        // TODO Auto-generated method stub
                        dialog.dismiss();
                        showDialogUpdate();
                        dialog.dismiss();

                    }

                }).setNegativeButton("稍后再说",new DialogInterface.OnClickListener() {//添加返回按钮



            @Override

            public void onClick(DialogInterface dialog, int which) {//响应事件

                // TODO Auto-generated method stub

                dialog.dismiss();

            }

        }).show();//在按键响应事件中显示此对话框
    }
    /**
     * 提示版本更新的对话框
     */
    private void showDialogUpdate() {
        // 这里的属性可以一直设置，因为每次设置后返回的是一个builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // 设置提示框的标题
        builder.setTitle("版本升级").
                // 设置提示框的图标
                        setIcon(R.mipmap.ic_launcher).
                // 设置要显示的信息
                        setMessage("发现新版本！请及时更新").
                // 设置确定按钮
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "选择确定哦", 0).show();
                        dialog.dismiss();
                        loadNewVersionProgress();//下载最新的版本程序

                    }
                }).

                // 设置取消按钮,null是什么都不做，并关闭对话框
                        setNegativeButton("取消", null);

        // 生产对话框
        alertDialog = builder.create();
        // 显示对话框
        alertDialog.show();


    }
    /**
     * 下载新版本程序，需要子线程
     */
    private void loadNewVersionProgress() {
        final   String uri=versionsUrl;
        final ProgressDialog pd;    //进度条对话框
        pd = new  ProgressDialog(getActivity());
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
        pd.show();
        //启动子线程下载任务
        new Thread(){
            @Override
            public void run() {
                try {
                    File file = getFileFromServer(uri, pd);
                    sleep(3000);
                    installApk(file);
                    pd.dismiss(); //结束掉进度条对话框
                } catch (Exception e) {
                    //下载apk失败
                    Log.i("abc","下载失败");
//                    Toast.makeText(getActivity(), "下载新版本失败", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }}.start();
    }
    /**
     * 从服务器获取apk文件的代码
     * 传入网址uri，进度条对象即可获得一个File文件
     * （要在子线程中执行哦）
     */
    public  File getFileFromServer(String uri, final ProgressDialog pd) throws Exception{
        //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            URL url = new URL(uri);
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //获取到文件的大小
            pd.setMax(conn.getContentLength());
            InputStream is = conn.getInputStream();
            long time= System.currentTimeMillis();//当前时间的毫秒数
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), time+"updata.apk");
            if(!file.exists())
                file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len ;

            while((len =bis.read(buffer))!=-1){
                fos.write(buffer, 0, len);
                total+= len;
                //获取当前下载量
                pd.setProgress(total);
            }
            fos.close();
            bis.close();
            is.close();
            return file;
        }
        else{
            return null;
        }
    }
    /**
     * 安装apk
     */
    protected void installApk(File file) {
        Intent intent = new Intent();
        //执行动作
        intent.setAction(Intent.ACTION_VIEW);
        //执行的数据类型
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       // alertDialog.dismiss();
    }

    @Override
    protected void initView(View view) {


        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.mRecycleView);
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.recycleview_image_item, null);
        mViewPager = (ViewPager) view1.findViewById(R.id.mPanadaBanner_viewPager);
        imageList = new ArrayList<ImageView>();

        presentImp = new HomePresentImp(this);
        list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        pullToRefreshRecyclerView.setLayoutManager(manager);
        pullToRefreshRecyclerView.addHeaderView(view1);
        //实例化适配
        adapter = new RecycleViewAdapter(getActivity(),list);
        pullToRefreshRecyclerView.setAdapter(adapter);
        pullToRefreshRecyclerView.setPullRefreshEnabled(false);
        pullToRefreshRecyclerView.setLoadingMoreEnabled(false);

    }


    @Override
    protected void initListener() {
    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
                imageChage = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });
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
    public void loadDetail(PanadaHomeBean bean) {
        this.panadaHomeBean = bean;
        PanadaHomeBean.DataBean.AreaBean area = bean.getData().getArea();
        PanadaHomeBean.DataBean.PandaeyeBean pandaeyeBean = bean.getData().getPandaeye();
        PanadaHomeBean.DataBean.PandaliveBean pandaliveBean = bean.getData().getPandalive();
        PanadaHomeBean.DataBean.WallliveBean wallliveBean = bean.getData().getWalllive();
        PanadaHomeBean.DataBean.ChinaliveBean chinaliveBean = bean.getData().getChinalive();
        PanadaHomeBean.DataBean.InteractiveBean interactiveBean = bean.getData().getInteractive();
        PanadaHomeBean.DataBean.CctvBean cctvBean = bean.getData().getCctv();
        PanadaHomeBean.DataBean.ListBeanXXX listBeanXXX = bean.getData().getList().get(0);
        getImageView(bean);
        getVersion();
        list.add(area);
        list.add(pandaeyeBean);
        list.add(pandaliveBean);
        list.add(wallliveBean);
        list.add(chinaliveBean);
        list.add(interactiveBean);
//        list.add(cctvBean);
        //CCTV发送二次网络请求
        listurl = cctvBean.getListurl();
        sendAgainRequest(listurl);
        //光影中国发送二次网络请求
        String listUrl1 =  listBeanXXX.getListUrl();
        sendListBean(listUrl1);

        adapter.notifyDataSetChanged();
    }
    public void sendListBean(String url){
        presentImp.getListBean(url);
    }
    @Override
    public void loadCcctv(CctvAgainBean cctvAgainBean) {
        list.add(cctvAgainBean);
        adapter.notifyDataSetChanged();
    }
    public void sendAgainRequest(String url){
        presentImp.getCctv(url);
    }
    @Override
    public void loadListBean(PanadaChinaListBean panadaChinaListBean) {
        list.add(panadaChinaListBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadInteractionBean(PanadaInterfactionBean panadaInterfactionBean) {

    }


    public void getImageView( PanadaHomeBean panadaHomeBean1){

      final   List<PanadaHomeBean.DataBean.BigImgBean> beanList = panadaHomeBean1.getData().getBigImg();
        for(int i=0;i<beanList.size();i++){
            PanadaHomeBean.DataBean.BigImgBean bigImgBean1 = beanList.get(i);
            final ImageView imageView = new ImageView(getActivity());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(getActivity()).load(bigImgBean1.getImage()).into(imageView);
            imageView.setTag(i);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a = (int) imageView.getTag();
                    PanadaHomeBean.DataBean.BigImgBean bigImgBean1 = beanList.get(a);
                    MainActivity activity = (MainActivity) getActivity();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", bigImgBean1.getUrl());
                    bundle.putString("title", bigImgBean1.getTitle());
                    bundle.putString("imageurl", bigImgBean1.getImage());
                    activity.changeFragment(pandaWebView, bundle, false);

                }
            });


            imageList.add(imageView);

        }
        bannerAdapter = new MyBannerAdapter(imageList);
        bannerAdapter.notifyDataSetChanged();
        mViewPager.setAdapter(bannerAdapter);

        mViewPager.setCurrentItem(1000);
        handler.sendEmptyMessageDelayed(1,2000);

    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    imageChage = imageChage+1;
                    mViewPager.setCurrentItem(imageChage);
                    sendEmptyMessageDelayed(1,2000);
                    break;
            }

        }
    };

}
