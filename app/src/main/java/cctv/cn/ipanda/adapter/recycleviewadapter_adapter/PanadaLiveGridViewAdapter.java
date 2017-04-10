package cctv.cn.ipanda.adapter.recycleviewadapter_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;

/**
 * Created by ASUS on 2017/4/10.
 */

public class PanadaLiveGridViewAdapter extends MyCommonBaseAdapter<PanadaHomeBean.DataBean.PandaliveBean.ListBean>{
    public PanadaLiveGridViewAdapter(Context context, List datas) {
        super(context, datas, R.layout.recycleview_panadalive_item_gridview);

    }


    @Override
    protected void display(CommonViewHolder holder, PanadaHomeBean.DataBean.PandaliveBean.ListBean listBean) {
        holder.setImage(R.id.mPanadaLive_GridView_image,listBean.getImage());
        holder.setText(R.id.mPanadaLive_GridView_image_message,listBean.getTitle());

    }
}
