package cctv.cn.ipanda.activity;
import android.net.Uri;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.BaseActivity;
import cctv.cn.ipanda.view.CustomMediaController;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by 张志远 on 2017/4/7.
 */

public class VideoActivity extends BaseActivity implements  MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener{
    //视频地址
    private String path = "http://baobab.wdjcdn.com/145076769089714.mp4";
    private Uri uri;
    private ProgressBar pb;
    private TextView downloadRateView, loadRateView;
    private CustomMediaController mCustomMediaController;
    private VideoView mVideoView;
    @Override
    protected int getLayoutId() {
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window = VideoActivity.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        //必须写这个，初始化加载库文件
        Vitamio.isInitialized(this);
        //设置视频解码监听
//        if (!LibsChecker.checkVitamioLibs(this)) {
//            return;
//        }
    return R.layout.activity_video;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {
        mVideoView = (VideoView) findViewById(R.id.buffer);
        mCustomMediaController=new CustomMediaController(this,mVideoView,this);
        mCustomMediaController.setVideoName("白火锅 x 红火锅");
        pb = (ProgressBar) findViewById(R.id.probar);
        downloadRateView = (TextView) findViewById(R.id.download_rate);
        loadRateView = (TextView) findViewById(R.id.load_rate);
    }

    @Override
    protected void initData() {
        uri = Uri.parse(path);
        mVideoView.setVideoURI(uri);//设置视频播放地址
        mCustomMediaController.show(5000);
        mVideoView.setMediaController(mCustomMediaController);
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//高画质
        mVideoView.requestFocus();
        mVideoView.setOnInfoListener(this);
        mVideoView.setOnBufferingUpdateListener(this);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        switch (what) {
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                    pb.setVisibility(View.VISIBLE);
                    downloadRateView.setText("");
                    loadRateView.setText("");
                    downloadRateView.setVisibility(View.VISIBLE);
                    loadRateView.setVisibility(View.VISIBLE);

                }
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                mVideoView.start();
                pb.setVisibility(View.GONE);
                downloadRateView.setVisibility(View.GONE);
                loadRateView.setVisibility(View.GONE);
                break;
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                downloadRateView.setText("" + extra + "kb/s" + "  ");
                break;
        }
        return true;
    }
}
