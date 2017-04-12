package cctv.cn.ipanda.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.adapter.FirstPagerAdapter;

/**
 * Created by ASUS on 2017/4/7.
 */

public class FirstPagerActivity extends Activity{
    private ViewPager mViewPager;
    private List<View> list;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        init();
        finish();
    }

    public void init(){
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        list = new ArrayList<>();
        //添加集合
        View view = LayoutInflater.from(this).inflate(R.layout.viewpager_one,null);
        view.setBackgroundResource(R.drawable.guide_one);
        View view1 = LayoutInflater.from(this).inflate(R.layout.viewpager_two,null);
        view1.setBackgroundResource(R.drawable.guide_two);
        View view2 = LayoutInflater.from(this).inflate(R.layout.viewpager_three,null);
        view2.setBackgroundResource(R.drawable.guide_three);
        mText = (TextView) view2.findViewById(R.id.mText);
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPagerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        list.add(view);
        list.add(view1);
        list.add(view2);
        //实例化适配器
        FirstPagerAdapter adapter = new FirstPagerAdapter(list);
        mViewPager.setAdapter(adapter);
    }
}
