package cctv.cn.ipanda.viewholder;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cctv.cn.ipanda.R;

/**
 * Created by ASUS on 2017/4/10.
 */

public class PanadaViewPagerViewHolder extends RecyclerView.ViewHolder{

    private final ViewPager panadaViewPager;

    public PanadaViewPagerViewHolder(View itemView) {
        super(itemView);
        panadaViewPager = (ViewPager) itemView.findViewById(R.id.mPanadaBanner_viewPager);
    }
}
