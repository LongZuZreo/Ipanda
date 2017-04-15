package cctv.cn.ipanda.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.activity.VideoActivity;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.common.Urls;
import cctv.cn.ipanda.fragment.PandaLiveListFragment;
import cctv.cn.ipanda.model.http.MyCallback;
import cctv.cn.ipanda.model.http.MyVadioPlay;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveJcyiBean;
import cctv.cn.ipanda.model.pandalive.PandaVadioBean;
import cctv.cn.ipanda.presenter.panda_live.PandaLiveTabPresenterImpl;

/**
 * Created by lenovo on 2017/4/8.
 */

public class PandaLiveRecycleAdapter extends BaseAdapter<PandaLiveJcyiBean.VideoBean> {

    private PandaLiveTabPresenterImpl pandaLivePersenter;

    public PandaLiveRecycleAdapter(Context context, List<PandaLiveJcyiBean.VideoBean> datas, PandaLiveTabPresenterImpl pandaLivePersenter) {
        super(context, R.layout.fragment_panda_live_item, datas);
        this.pandaLivePersenter = pandaLivePersenter;
    }

    @Override
    public void convert(ViewHolder holder, final PandaLiveJcyiBean.VideoBean videoBean) {

        RelativeLayout relativeLayout = holder.getView(R.id.panda_live_list_info);

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String vid = videoBean.getVid();
                String t = videoBean.getT();

                Intent intent = new Intent(context, VideoActivity.class);

                intent.putExtra("pid", vid);
                intent.putExtra("title", t);
                context.startActivity(intent);

            }
        });

        ImageView imageView = holder.getView(R.id.panda_live_img);
        Glide.with(App.context).load(videoBean.getImg()).into(imageView);

        holder.setText(R.id.panda_live_item_title, videoBean.getT())
                .setText(R.id.panda_live_item_data, videoBean.getPtime());


    }
}
