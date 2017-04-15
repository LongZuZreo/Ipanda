package cctv.cn.ipanda.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMWXHandler;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.WeiXinShareContent;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.common.App;

/**
 * Created by hp1 on 2017-04-13.
 */

public class ShareControllerUtil   {

    private  ShareAction shareAction;

    public void shareHttp(String url, String title, String imageUrl) {
        shareAction = new ShareAction(App.context);
        shareAction.setDisplayList(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE);
        shareAction.setCallback(umShareListener);
        ImageView imageView = new ImageView(App.context);
        Glide.with(App.context).load(imageUrl).into(imageView);
        UMImage thumb = new UMImage(App.context, String.valueOf(imageView));
        UMWeb web = new UMWeb(url);
        web.setTitle("熊猫频道");//标题
        web.setThumb(thumb);  //缩略图
        web.setDescription(title+",熊猫频道邀请您一同观看！"+url);//描述
        shareAction.withMedia(web);
        shareAction.share();
        shareAction.open();
    }

    public void shareImage() {
        shareAction = new ShareAction(App.context);
        shareAction.setDisplayList(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE);
        shareAction.setCallback(umShareListener);
        UMImage image = new UMImage(App.context, R.mipmap.ic_launcher);
        image.compressStyle = UMImage.CompressStyle.QUALITY;
        image.compressFormat = Bitmap.CompressFormat.PNG;
        shareAction.withMedia(image);
        image.setDescription("这是一张图片");
        shareAction.share();
        shareAction.open();
    }
    UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onResult(SHARE_MEDIA platform) {

            Toast.makeText(App.context, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(App.context, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(App.context, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

}
