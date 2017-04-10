package cctv.cn.ipanda.adapter.recycleviewadapter_adapter;

import android.content.Context;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;

/**
 * Created by ASUS on 2017/4/10.
 */

public class ChinaLiveGridViewAdapter extends MyCommonBaseAdapter<PanadaHomeBean.DataBean.ChinaliveBean.ListBeanXX>{


    public ChinaLiveGridViewAdapter(Context context, List<PanadaHomeBean.DataBean.ChinaliveBean.ListBeanXX> datas) {
        super(context, datas, R.layout.recycleview_chinalive_item_gridview);
    }

    @Override
    protected void display(CommonViewHolder holder, PanadaHomeBean.DataBean.ChinaliveBean.ListBeanXX listBeanXX) {
        holder.setImage(R.id.mPanadaChinalive_GridView_image,listBeanXX.getImage());
        holder.setText(R.id.mPanadaChinalive_GridView_title,listBeanXX.getTitle());
    }
}
