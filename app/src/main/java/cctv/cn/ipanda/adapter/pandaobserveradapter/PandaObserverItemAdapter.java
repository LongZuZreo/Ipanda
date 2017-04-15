package cctv.cn.ipanda.adapter.pandaobserveradapter;

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
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.model.panda_observer.PandaObserveItemEntity;

/**
 * Created by hp1 on 2017-04-11.
 */

public class PandaObserverItemAdapter extends BaseAdapter<PandaObserveItemEntity.ListBean> {
    public PandaObserverItemAdapter(Context context, List<PandaObserveItemEntity.ListBean> datas) {
        super(context, R.layout.fragment_panda_observe_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final PandaObserveItemEntity.ListBean entity) {

        RelativeLayout relativeLayout = holder.getView(R.id.panda_observe_relativeLayout);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = entity.getGuid();
                String title = entity.getTitle();
                if (id != null && title != null) {
                    Intent intent = new Intent(context, VideoActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("title", title);
                    context.startActivity(intent);
                }
            }
        });


        holder.setText(R.id.panda_observe_item_sp_time, entity.getVideolength())
                .setText(R.id.panda_observe_item_title, entity.getTitle())
                .setText(R.id.panda_observe_item_time, entity.getGuid());
        ImageView imageView = holder.getView(R.id.panda_observe_item_image);
        Glide.with(context).load(entity.getPicurl()).into(imageView);
    }
}
