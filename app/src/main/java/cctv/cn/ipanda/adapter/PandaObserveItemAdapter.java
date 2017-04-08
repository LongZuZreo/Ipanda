package cctv.cn.ipanda.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.model.panda_observe.PandaObserveHeadEntity;
import cctv.cn.ipanda.model.panda_observe.PandaObserveItemEntity;

/**
*
*@author king
*Created at 2017-04-07 14:33
*
*/

public class PandaObserveItemAdapter extends BaseAdapter<PandaObserveItemEntity.ListBean> {


    public PandaObserveItemAdapter(Context context, int layoutId, List<PandaObserveItemEntity.ListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, PandaObserveItemEntity.ListBean listBean) {
        holder.setText(R.id.panda_observe_item_title,listBean.getTitle())
                .setText(R.id.panda_observe_item_sp_time,listBean.getVideolength())
                .setText(R.id.panda_observe_item_time,listBean.getId());
           //     .setImageResource(R.id.panda_observe_item_image,listBean.getPicurl());
    }
}
