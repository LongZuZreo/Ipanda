package cctv.cn.ipanda.adapter.recycleviewadapter_adapter;

import android.content.Context;

import java.util.List;

import cctv.cn.ipanda.R;
import cctv.cn.ipanda.base.adapter.CommonViewHolder;
import cctv.cn.ipanda.base.adapter.MyCommonBaseAdapter;
import cctv.cn.ipanda.model.panada_home.PanadaEyesBean;

/**
 * Created by ASUS on 2017/4/14.
 */

public class PanadaEyesListAdapter extends MyCommonBaseAdapter<PanadaEyesBean.ListBean>{
    public PanadaEyesListAdapter(Context context, List<PanadaEyesBean.ListBean> datas) {
        super(context, datas, R.layout.recycleview_panadaeyes_listview_adapter);
    }


    @Override
    protected void display(CommonViewHolder holder, PanadaEyesBean.ListBean listBean) {
        holder.setText(R.id.mPanadaeyes_listview_day,listBean.getVideoLength());
        holder.setText(R.id.mPanadaeyes_listview_message,listBean.getTitle());
        holder.setText(R.id.mPanadaeyes_listview_time,listBean.getDaytime());
        holder.setImage(R.id.mPanadaeyes_listview_image,listBean.getImage());
    }
}
