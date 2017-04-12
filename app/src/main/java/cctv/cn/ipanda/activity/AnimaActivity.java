package cctv.cn.ipanda.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/7.
 */

public class AnimaActivity extends Activity{
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anima);
        imageView = (ImageView) findViewById(R.id.mImage);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.donghua);
        imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isFirstShow();
                finish();
               /* Intent intent = new Intent(AnimaActivity.this,FirstPagerActivity.class);
                startActivity(intent);*/
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
    /**
     * 记录是否首次登录，是，跳到引导页，否则跳到首页
     */
    public void isFirstShow(){
        SharedPreferences preferences = getSharedPreferences("goods",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        boolean isFirst = preferences.getBoolean("isFirst", true);
        if(isFirst){
            Intent intent = new Intent(AnimaActivity.this,FirstPagerActivity.class);
            startActivity(intent);
            editor.putBoolean("isFirst",false);
            editor.commit();

        }else{
            Intent intent = new Intent(AnimaActivity.this,MainActivity.class);
            startActivity(intent);


        }



    }



}
