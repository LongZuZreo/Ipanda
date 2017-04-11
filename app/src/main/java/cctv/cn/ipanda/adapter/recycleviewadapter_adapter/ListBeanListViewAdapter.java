package cctv.cn.ipanda.adapter.recycleviewadapter_adapter;

import android.content.Context;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.model.panada_home.PanadaChinaListBean;
import cctv.cn.ipanda.model.panada_home.PanadaHomeBean;

/**
 * Created by ASUS on 2017/4/11.
 */

public class ListBeanListViewAdapter extends MyCommonBaseAdapter<PanadaChinaListBean.ListBean>{


    public ListBeanListViewAdapter(Context context, List<PanadaChinaListBean.ListBean> datas) {
        super(context, datas, R.layout.recycleview_listbean_item_listview);
    }

    @Override
    protected void display(CommonViewHolder holder, PanadaChinaListBean.ListBean listBean) {
        holder.setText(R.id.mPanadaListBean_listView_title,listBean.getTitle());
        holder.setText(R.id.mPanadaListBean_listView_image_time,listBean.getVideoLength());
        holder.setImage(R.id.mPanadaListBean_listView_image,listBean.getImage());
        holder.setText(R.id.mPanadaListBean_listView_time,listBean.getDaytime());
    }
}
