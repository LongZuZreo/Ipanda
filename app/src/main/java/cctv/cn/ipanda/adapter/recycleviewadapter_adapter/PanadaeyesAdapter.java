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

public class PanadaeyesAdapter extends MyCommonBaseAdapter<PanadaHomeBean.DataBean.PandaeyeBean.ItemsBean>{
    public PanadaeyesAdapter(Context context, List<PanadaHomeBean.DataBean.PandaeyeBean.ItemsBean> datas) {
        super(context, datas, R.layout.recycleview_panadaeyes_item_listview);
    }

    @Override
    protected void display(CommonViewHolder holder, PanadaHomeBean.DataBean.PandaeyeBean.ItemsBean itemsBean) {

    }
}
