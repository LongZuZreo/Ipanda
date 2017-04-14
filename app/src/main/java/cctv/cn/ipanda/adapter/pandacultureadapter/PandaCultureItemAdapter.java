package cctv.cn.ipanda.adapter.pandacultureadapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.VideoActivity;
import cctv.cn.ipanda.model.panda_culture.PandaCultureEntity;

/**
 * Created by hp1 on 2017-04-11.
 */

public class PandaCultureItemAdapter extends BaseAdapter<PandaCultureEntity.ListBean> {
    public PandaCultureItemAdapter(Context context , List<PandaCultureEntity.ListBean> datas) {
        super(context, R.layout.fragment_panda_culture_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final PandaCultureEntity.ListBean listBean) {

        RelativeLayout relativeLayout = holder.getView(R.id.panda_observe_relativeLayout);
/*
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = listBean.;
                Intent intent = new Intent(context, VideoActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });*/

        holder.setText(R.id.panda_oculture_item_sp_time,listBean.getVideoLength())
                .setText(R.id.panda_culture_item_title,listBean.getTitle())
                .setText(R.id.panda_culture_item_time,listBean.getBrief());
        ImageView imageView = holder.getView(R.id.panda_culture_item_image);
        Glide.with(context).load(listBean.getImage()).into(imageView);
    }
}
