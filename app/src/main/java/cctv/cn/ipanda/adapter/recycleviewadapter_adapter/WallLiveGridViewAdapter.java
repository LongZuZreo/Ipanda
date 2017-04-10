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

public class WallLiveGridViewAdapter extends MyCommonBaseAdapter<PanadaHomeBean.DataBean.WallliveBean.ListBeanX>{
    public WallLiveGridViewAdapter(Context context, List<PanadaHomeBean.DataBean.WallliveBean.ListBeanX> datas) {
        super(context, datas, R.layout.recycleview_wallview_item_gridview);
    }

    @Override
    protected void display(CommonViewHolder holder, PanadaHomeBean.DataBean.WallliveBean.ListBeanX listBeanX) {
        holder.setText(R.id.mPanadaWalllive_Gridview_title,listBeanX.getTitle());
        holder.setImage(R.id.mPanadaWalllive_Gridview_image,listBeanX.getImage());
    }
}
