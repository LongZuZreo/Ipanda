package cctv.cn.ipanda.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.common.App;
import cctv.cn.ipanda.model.pandalive.PandaLiveBqBean;
import cctv.cn.ipanda.model.pandalive.PandaLiveJcyiBean;

/**
 * Created by lenovo on 2017/4/8.
 */

public class PandaLiveRecycleAdapter extends BaseAdapter<PandaLiveJcyiBean.VideoBean> {

    public PandaLiveRecycleAdapter(Context context, List<PandaLiveJcyiBean.VideoBean> datas) {
        super(context, R.layout.fragment_panda_live_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, PandaLiveJcyiBean.VideoBean videoBean) {

        ImageView imageView = holder.getView(R.id.panda_live_img);
        Glide.with(App.context).load(videoBean.getImg()).into(imageView);

        holder.setText(R.id.panda_live_item_title, videoBean.getT())
                .setText(R.id.panda_live_item_data, videoBean.getPtime());
    }
}
